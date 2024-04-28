package socialbookstore.domainmodel;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "bookauthors")

public class BookAuthor {
    
    @ManyToMany
    @JoinTable(
        name = "user_profile_book_author",
        joinColumns = @JoinColumn(name = "author_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List <UserProfile> users;
    
    @ManyToMany(mappedBy = "books")
    private List <Book> books;
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column
    private String name;

    public BookAuthor(int authorId, String name){
        this.authorId = authorId;
        this.name = name;
    }
    
    public void addBook(Book book){
        books.add(book);
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    
}
