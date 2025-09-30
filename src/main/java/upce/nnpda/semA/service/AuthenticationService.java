package upce.nnpda.semA.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import upce.nnpda.semA.domain.User;
import upce.nnpda.semA.dto.LoginRequest;
import upce.nnpda.semA.dto.UserRequestDto;
import upce.nnpda.semA.repository.UserRepository;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(UserRequestDto userRequest) {
        User user = userRequest.toUser();
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return userRepository.save(user);
    }

    public User authenticate(LoginRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
