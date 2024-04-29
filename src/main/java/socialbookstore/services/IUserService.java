package socialbookstore.services;

import org.apache.catalina.User;

public interface IUserService {
    
    public void saveUser(User user);
    public boolean isUserPresent(User user);
    public User findById(String username);
    
}
