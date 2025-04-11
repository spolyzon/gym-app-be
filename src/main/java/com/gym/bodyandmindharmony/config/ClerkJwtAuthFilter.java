package com.gym.bodyandmindharmony.config;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.JWKSourceBuilder;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.DefaultJOSEObjectTypeVerifier;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimNames;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTClaimsVerifier;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Collections;
import java.util.Set;

@Component
public class ClerkJwtAuthFilter extends OncePerRequestFilter {

//    private static final String URL = "https://dominant-dolphin-59.clerk.accounts.dev/.well-known/jwks.json";

    //    private final RemoteJWKSet<SecurityContext> jwkSet;
    private final JWKSet publicKeys;

    public ClerkJwtAuthFilter() throws IOException, ParseException {
//        URL jwksUrl = new URL("https://dominant-dolphin-59.clerk.accounts.dev/.well-known/jwks.json");
//        this.jwkSet = new RemoteJWKSet<>(jwksUrl);
        publicKeys = JWKSet.load(new URL("https://dominant-dolphin-59.clerk.accounts.dev/.well-known/jwks.json"));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try {
                ConfigurableJWTProcessor<SecurityContext> jwtProcessor = new DefaultJWTProcessor<>();

                // Set the required "typ" header "at+jwt" for access tokens
                jwtProcessor.setJWSTypeVerifier(
                        new DefaultJOSEObjectTypeVerifier<>(new JOSEObjectType("jwt")));
                JWKSource<SecurityContext> keySource = JWKSourceBuilder
                        .create(new URL("https://dominant-dolphin-59.clerk.accounts.dev/.well-known/jwks.json"))
                        .retrying(true)
                        .build();

                // The expected JWS algorithm of the access tokens (agreed out-of-band)
                JWSAlgorithm expectedJWSAlg = JWSAlgorithm.RS256;

                // Configure the JWT processor with a key selector to feed matching public
                // RSA keys sourced from the JWK set URL
                JWSKeySelector<SecurityContext> keySelector = new JWSVerificationKeySelector<>(
                        expectedJWSAlg,
                        keySource);
                jwtProcessor.setJWSKeySelector(keySelector);

                // Set the required JWT claims for access tokens
                Set<String> claims = Set.of(
                        JWTClaimNames.SUBJECT,
                        JWTClaimNames.ISSUED_AT,
                        JWTClaimNames.EXPIRATION_TIME,
//                        "scp",
//                        "cid",
                        JWTClaimNames.JWT_ID);
                jwtProcessor.setJWTClaimsSetVerifier(new DefaultJWTClaimsVerifier<>(
                        new JWTClaimsSet.Builder().issuer("https://dominant-dolphin-59.clerk.accounts.dev").build(),
                        claims));
                final var claimsSet = jwtProcessor.process(token, null);
                final var username = claimsSet.getStringClaim("username");
                Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (ParseException | JOSEException | BadJOSEException e) {
                throw new RuntimeException(e);
            }
        }
        filterChain.doFilter(request, response);
    }
}
