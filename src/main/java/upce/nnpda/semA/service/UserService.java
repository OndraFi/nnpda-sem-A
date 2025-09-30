package upce.nnpda.semA.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import upce.nnpda.semA.domain.User;
import upce.nnpda.semA.exception.UserAlreadyExistsException;
import upce.nnpda.semA.exception.UserNotFoundException;
import upce.nnpda.semA.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;


@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

}