package db.ai.digitalbridgeai.service;

import db.ai.digitalbridgeai.dto.JwtAuthenticationResponce;
import db.ai.digitalbridgeai.dto.SignInRequest;
import db.ai.digitalbridgeai.dto.SignUpRequest;
import db.ai.digitalbridgeai.entity.User;

public interface AuthenticationService {
    User signUp(SignUpRequest signUpRequest);
    JwtAuthenticationResponce signIn(SignInRequest signInRequest);
}
