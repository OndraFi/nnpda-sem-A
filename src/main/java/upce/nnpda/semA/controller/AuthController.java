package upce.nnpda.semA.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upce.nnpda.semA.domain.User;
import upce.nnpda.semA.dto.LoginRequest;
import upce.nnpda.semA.dto.LoginResponse;
import upce.nnpda.semA.dto.UserRequestDto;
import upce.nnpda.semA.dto.UserResponseDto;
import upce.nnpda.semA.service.AuthenticationService;
import upce.nnpda.semA.service.JwtService;

@RestController
@Slf4j
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto registerUserDto) {
        User registeredUser = authenticationService.register(registerUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser.toResponseDto());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        log.info("User authenticated: " + authenticatedUser.getEmail());

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}