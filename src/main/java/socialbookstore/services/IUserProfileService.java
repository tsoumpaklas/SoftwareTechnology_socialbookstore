package socialbookstore.services;
import java.util.List;

import socialbookstore.formsdata.BookFormData;
import socialbookstore.formsdata.RecommendationsFormData;
import socialbookstore.formsdata.SearchFormData;

public interface IUserProfileService {

    public UserProfileFormData retrieveProfile(String username);
    public void save(UserProfileFormData userProfileFormData);
    public List<BookFormData> retrieveBookOffers(String username);
    public void addBookOffer(String username, BookFormData bookFormData);
    public List<BookFormData> searchBooks(SearchFormData searchFormData);
    public List<BookFormData> recommendBooks(String username, RecommendationsFormData recomFormData);
    public void requestBook(int bookId, String username);
    public List<BookFormData> retrieveRequests(String username);
    public List<UserProfileFormData> retrieveRequestingUsers(int bookId);
    public void deleteBookOffer(String username, int bookId);
    public void deleteBookRequest(String username, int bookId);


}