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

	@Column(name = "username")
	private String username;
	@Column(name = "fullname")
	private String fullName;
	@Column(name = "age")
	private int age;

	public UserProfile() {}

	@ManyToMany
	@JoinTable(
			name = "userprofile_bookauthor",
			joinColumns = @JoinColumn(name = "user_profile_id"),
			inverseJoinColumns = @JoinColumn(name = "book_author_id"))
	private List<BookAuthor> favouriteBookAuthors;

	@ManyToMany
	@JoinTable(
			name = "userprofile_bookcategory",
			joinColumns = @JoinColumn(name = "user_profile_id"),
			inverseJoinColumns = @JoinColumn(name = "book_category_id"))
	private List<BookCategory> favouriteBookCategories;

	@ManyToMany
	@JoinTable(
			name = "userprofile_requestedbooks",
			joinColumns = @JoinColumn(name = "user_profile_id"),
			inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<Book> requestedBooks;

	@OneToMany(mappedBy = "offeringUser")
	private List<Book> bookOffers;

	public List<BookAuthor> getFavouriteBookAuthors() {
		return favouriteBookAuthors;
	}

	public void setBookAuthors(List<BookAuthor> favouriteBookAuthors) {
		this.favouriteBookAuthors = favouriteBookAuthors;
	}

	public List<BookCategory> getFavouriteBookCategories() {
		return favouriteBookCategories;
	}

	public void setFavouriteBookCategories(List<BookCategory> favouriteBookCategories) {
		this.favouriteBookCategories = favouriteBookCategories;
	}

	public List<Book> getRequestedBooks() {
		return requestedBooks;
	}

	public void setRequestedBooks(List<Book> requestedBooks) {
		this.requestedBooks = requestedBooks;
	}

	public List<Book> getBookOffers() {
		return bookOffers;
	}

	public void setBookOffers(List<Book> bookOffers) {
		this.bookOffers = bookOffers;
	}

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setFavouriteBookAuthors(List<BookAuthor> favouriteBookAuthors) {
		this.favouriteBookAuthors = favouriteBookAuthors;
	}
}

