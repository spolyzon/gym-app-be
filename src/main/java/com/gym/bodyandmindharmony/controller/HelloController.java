package com.gym.bodyandmindharmony.controller;

import com.gym.bodyandmindharmony.models.HelloModel;
import com.nimbusds.jwt.SignedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.text.ParseException;
import java.util.Map;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    private static final String PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw5f7RLr6fY02XFBBRQlr\n" +
            "14r2JnhPxRvPjwWXGLN8d4qjWhvO06VZnZh6fRC24AkGuTV+81i6Hs9bwKGS3syt\n" +
            "ajymH4rtcXd+IqORLR/xBSTzSZmedPt4jdQ4zUroAHxfDdQp2tmKYeRXd6uRmCz9\n" +
            "iT+OT4cmxAvmcytRSTHwwmVrFOxGzNYFzTKjiR5YLyhk5nAyma7x67bul8j7R+AV\n" +
            "iy56zxhmqrhQT5bNOI+mPrk7d8N/tqkSMfwrog4PaKgCMKzyKXLgWw5ju8K5KH1N\n" +
            "FPPubFmP9thlWlMwUePEIgRWSQj39fIjC2XBTcZqABCqagZuN/GT8791dvMwccnj\n" +
            "IwIDAQAB\n" +
            "-----END PUBLIC KEY-----\n";

    @GetMapping
    public ResponseEntity<?> hello(Principal principal) throws ParseException {
//        log.info("Printing headers");
//        headers.forEach((key, value) -> log.info("Name: " + key + ", Value: " + value));
//        test(headers.get("authorization"));
        log.info(principal.getName());
        return ResponseEntity.ok(new HelloModel("valid token"));
    }

}
