package db.ai.digitalbridgeai.controller;

import db.ai.digitalbridgeai.dto.JwtAuthenticationResponce;
import db.ai.digitalbridgeai.dto.SignInRequest;
import db.ai.digitalbridgeai.dto.SignUpRequest;
import db.ai.digitalbridgeai.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest signUpRequest){
        authenticationService.signUp(signUpRequest);
        return new ResponseEntity<>("Аккаунт успешно сохранен!", HttpStatus.CREATED);
    }
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponce> signIn(@RequestBody SignInRequest signInRequest){
        return new ResponseEntity<>(authenticationService.signIn(signInRequest), HttpStatus.OK);
    }
}
