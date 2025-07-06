package com.gym.bodyandmindharmony.filter;

import com.gym.bodyandmindharmony.exception.GymException;
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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import static com.gym.bodyandmindharmony.exception.ErrorEnum.MISSING_AUTHORISATION_HEADER_ERROR;

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
    private final HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            final var authHeader = Optional.ofNullable(request.getHeader(AUTHORIZATION_HEADER))
                    .filter(s -> !s.isBlank())
                    .orElseThrow(() -> new GymException(MISSING_AUTHORISATION_HEADER_ERROR));

            final var jwtToken = authHeader.substring(7);

            final var claims = jwtService.getClaims(jwtToken);

            final var authToken = new UsernamePasswordAuthenticationToken(claims.getBody().getSubject(), null, null);

            SecurityContextHolder.getContext().setAuthentication(authToken);

            filterChain.doFilter(request, response);
        } catch (Exception exception) {
            handlerExceptionResolver.resolveException(request, response, null, exception);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        final var path = request.getRequestURI();
        final var matcher = new AntPathMatcher();
        return WHITELIST.stream().anyMatch(pattern -> matcher.match(pattern, path));
    }
}
