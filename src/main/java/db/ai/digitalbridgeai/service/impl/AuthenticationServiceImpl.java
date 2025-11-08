package db.ai.digitalbridgeai.service.impl;

import db.ai.digitalbridgeai.dto.JwtAuthenticationResponce;
import db.ai.digitalbridgeai.dto.SignInRequest;
import db.ai.digitalbridgeai.dto.SignUpRequest;
import db.ai.digitalbridgeai.entity.User;
import db.ai.digitalbridgeai.repo.UserRepo;
import db.ai.digitalbridgeai.role.Authorities;
import db.ai.digitalbridgeai.service.AuthenticationService;
import db.ai.digitalbridgeai.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    public User signUp(SignUpRequest signUpRequest){
        User user = new User();

        user.setEmail(signUpRequest.email());
        user.setName(signUpRequest.name());
        user.setAuthorities(Authorities.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.password()));

        return userRepo.save(user);
    }
    public JwtAuthenticationResponce signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.email(),
                signInRequest.password()));
        var user = userRepo.findByEmail(signInRequest.email())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);

        return new JwtAuthenticationResponce(jwt);
    }
}
