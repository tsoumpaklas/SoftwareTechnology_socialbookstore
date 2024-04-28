package socialbookstore.mappers;

import org.springframework.data.jpa.repository.JpaRepository;

import socialbookstore.domainmodel.UserProfile;

public interface UserProfileMapper extends JpaRepository<UserProfile, Long>{
    UserProfile findByUsername(String username);
}
