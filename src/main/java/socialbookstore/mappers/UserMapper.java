package socialbookstore.mappers;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User, Long>{
    public Optional<User> findByUsername(String username);
}
