package upce.nnpda.semA.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import upce.nnpda.semA.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(@NonNull String email);

    Optional<User> findByEmail(String email);
}
