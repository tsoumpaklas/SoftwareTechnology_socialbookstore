package socialbookstore.mappers;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
