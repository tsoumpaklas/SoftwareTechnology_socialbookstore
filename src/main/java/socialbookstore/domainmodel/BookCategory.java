package socialbookstore.domainmodel;

import java.util.List;

import jakarta.persistence.*;
import socialbookstore.mappers.BookCategoryMapper;

@Entity
@Table(name = "bookcategories")

public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private int categoryId;
    
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "bookCategories")
    private List<UserProfile> userProfiles;

    @OneToMany(mappedBy = "bookCategory")
    private List<Book> books;

    public BookCategory() {}

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
