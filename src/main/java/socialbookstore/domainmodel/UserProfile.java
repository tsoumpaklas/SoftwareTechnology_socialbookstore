package socialbookstore.domainmodel;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "userprofiles")


public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_profile_id")
	private int userProfileId;

	@ManyToMany(mappedBy = "favouriteBookAuthors")
	private List <BookAuthor> favouriteBookAuthors;

	@ManyToMany(mappedBy = "favouriteBookCategories")
	private List <BookCategory> favouriteBookCategories;

	private String username;
	private String fullName;
	private int age;
	private List <Book> bookOffers;


	public UserProfile(String username, String fullname, int age){
		this.username = username;
		this.fullName = fullname;
		this.age = age;
	}

	public void addFavouriteBookAuthor(BookAuthor author){
		favouriteBookAuthors.add(author);
	}
	

	public void addFavouriteBookCategory(BookCategory category){
		favouriteBookCategories.add(category);
	}

	public void addBookOffer(Book book){
		bookOffers.add(book);
	}


	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public List<BookAuthor> getFavouriteBookAuthors() {
		return favouriteBookAuthors;
	}
	
	public void setFavouriteBookAuthors(List<BookAuthor> favouriteBookAuthors) {
		this.favouriteBookAuthors = favouriteBookAuthors;
	}

	
}
