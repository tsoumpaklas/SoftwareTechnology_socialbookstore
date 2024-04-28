package socialbookstore.domainmodel;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "bookcategories")

public class BookCategory {
    @ManyToMany
    @JoinTable(
        name = "user_profile_book_category",
        joinColumns = @JoinColumn(name = "category_id"),
        inverseJoinColumns = @JoinColumn(name = "user_profile_id")
    )
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    
    @Column
    private String name;

    @Column
    private List <Book> books;

    public BookCategory(int categoryId, String name){
        this.categoryId = categoryId;
        this.name = name;
    }

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

    public List<Book> getBooks() {
        return books;
    }
    
}
