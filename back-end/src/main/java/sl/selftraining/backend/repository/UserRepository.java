package sl.selftraining.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sl.selftraining.backend.model.User;

import java.util.Optional;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
