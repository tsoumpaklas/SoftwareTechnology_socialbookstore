package bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
import socialbookstore.domainmodel.*;

@SpringBootTest
public class TestingSystem {

    List<Book> books = new ArrayList<Book>();
    List<BookAuthor> authors = new ArrayList<BookAuthor>();

    Book book1 = new Book(1, "David Goggins");
    Book book2 = new Book(2, "Atomic Habits");

    BookAuthor author1 = new BookAuthor(1, "David Goggins");
    BookAuthor author2 = new BookAuthor(2, "James Clear");

    BookCategory category1 = new BookCategory(1, "Biography");
    BookCategory category2 = new BookCategory(2, "Self-Help");

    Role Nick = Role.ADMIN;
    User user1 = new User();
    UserProfile NickProfile = new UserProfile("Nick", "Nikolaos Konstantinidis", 23);

    

    @Test
    void testingUser(){
        books.add(book1);
        books.add(book2);

        authors.add(author1);
        authors.add(author2);

    

        user1.setUsername("Nick");
        user1.setPassword("password");
        user1.setRole(Nick);
        
        NickProfile.setRequestedBooks(books);
        NickProfile.setFavouriteBookAuthors(authors);
        NickProfile.addFavouriteBookCategory(category1);
        NickProfile.addFavouriteBookCategory(category2);
        

        assertEquals("Nick", user1.getUsername());
        assertEquals(books, NickProfile.getRequestedBooks());
        assertEquals(authors, NickProfile.getFavouriteBookAuthors());
        assertEquals(category1, NickProfile.getFavouriteBookCategories().get(0));
        assertEquals(category2, NickProfile.getFavouriteBookCategories().get(1));
        
    }
}
