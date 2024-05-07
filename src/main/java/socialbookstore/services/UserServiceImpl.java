package socialbookstore.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import socialbookstore.formsdata.BookFormData;
import socialbookstore.formsdata.RecommendationsFormData;
import socialbookstore.formsdata.SearchFormData;
import socialbookstore.mappers.*;

@Service
public class UserServiceImpl implements IUserService, IUserDetailsService, IUserProfileService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserMapper userDAO;

    @Autowired
    UserProfileMapper userProfileMapper;

    @Autowired
    BookAuthorMapper bookAuthorMapper;

    @Autowired
    BookCategoryMapper bookCategoryMapper;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    SearchFactory searchFactory;

    @Autowired
    RecommendationsFactory recommendationsFactory;

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
        return userDAO.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    @Override
    public UserProfileFormData retrieveProfile(String username) {
        return null;
    }

    @Override
    public void save(UserProfileFormData userProfileFormData) {

    }

    @Override
    public List<BookFormData> retrieveBookOffers(String username) {
        return List.of();
    }

    @Override
    public void addBookOffer(String username, BookFormData bookFormData) {

    }

    @Override
    public List<BookFormData> searchBooks(SearchFormData searchFormData) {
        return List.of();
    }

    @Override
    public List<BookFormData> recommendBooks(String username, RecommendationsFormData recomFormData) {
        return List.of();
    }

    @Override
    public void requestBook(int bookId, String username) {

    }

    @Override
    public List<BookFormData> retrieveRequests(String username) {
        return List.of();
    }

    @Override
    public List<UserProfileFormData> retrieveRequestingUsers(int bookId) {
        return List.of();
    }

    @Override
    public void deleteBookOffer(String username, int bookId) {

    }

    @Override
    public void deleteBookRequest(String username, int bookId) {

    }
}

