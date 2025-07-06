package com.gym.bodyandmindharmony.filter;

import com.gym.bodyandmindharmony.service.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    // a simple whitelist of paths you don’t want this filter to run on
    private static final Set<String> WHITELIST = Set.of(
            "/api/auth/**",
            "/h2-console/**"
    );

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            final var authHeader = Optional.ofNullable(request.getHeader(AUTHORIZATION_HEADER))
                    .filter(s -> !s.isBlank())
                    .orElseThrow(() -> new InsufficientAuthenticationException("No Authorization header found"));

            final var jwtToken = authHeader.substring(7);

            final var claims = jwtService.getClaims(jwtToken);

            final var authToken = new UsernamePasswordAuthenticationToken(claims.getBody().getSubject(), null, null);

            SecurityContextHolder.getContext().setAuthentication(authToken);

            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException eje) {
            throw new CredentialsExpiredException("JWT Token is expired", eje);
        } catch (JwtException | IllegalArgumentException ex) {
            throw new BadCredentialsException("Invalid JWT token", ex);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        final var path = request.getServletPath();
        final var matcher = new AntPathMatcher();
        return WHITELIST.stream().anyMatch(pattern -> matcher.match(pattern, path));
    }
}
