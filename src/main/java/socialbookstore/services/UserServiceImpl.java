package socialbookstore.services;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import socialbookstore.mappers.UserMapper;

@Service
public class UserServiceImpl implements IUserService, IUserDetailsService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserMapper userDAO;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return (UserDetails) userDAO.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}
    

    @Override
    public void saveUser(User user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword()); 
        user.setPassword(encodedPassword);
        userDAO.save(user);
    }

    @Override
    public boolean isUserPresent(User user) {
        Optional<User> storedUser = (userDAO.findByUsername(user.getUsername()));
        return storedUser.isPresent();
    }

    @Override
    public User findById(String username) {
        return userDAO.findByUsername(username).get();
    }
}

