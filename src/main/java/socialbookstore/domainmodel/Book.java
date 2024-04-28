package socialbookstore.domainmodel;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "books")

public class Book {
    
    @ManyToMany
    @JoinTable(
        name = "book_bookAuthor",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List <BookAuthor> bookAuthors;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private BookCategory bookCategory;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column
    private String title;

    @Column
    private List <UserProfile> requestingUsers;

    
    public Book(int bookId, String title){
        this.bookId = bookId;
        this.title = title;
    }

    public void addBookAuthor(BookAuthor author){
        bookAuthors.add(author);
    }
    
    public void addBookCategory(BookCategory category){
        bookCategory = category;
    }

    public void addRequestingUser(UserProfile user){
        requestingUsers.add(user);
    }

    public List<BookAuthor> getBookAuthors() {
        return bookAuthors;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public List<UserProfile> getRequestingUsers() {
        return requestingUsers;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
