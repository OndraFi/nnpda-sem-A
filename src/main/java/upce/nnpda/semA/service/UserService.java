package upce.nnpda.semA.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import upce.nnpda.semA.repository.UserRepository;


@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

}