package socialbookstore.domainmodel;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import jakarta.persistence.*;
import socialbookstore.mappers.UserProfileMapper;

@Entity
@Table(name = "userprofiles")


public class UserProfile implements UserProfileMapper{

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


	@ManyToMany
	@JoinTable(
		name = "user_profile_requested_books",
		joinColumns = @JoinColumn(name = "user_profile_id"),
		inverseJoinColumns = @JoinColumn(name = "book_id")
	)
	private List <Book> requestedBooks;


	@OneToMany(mappedBy = "offeringUser")
	private List <Book> bookOffers;




	public List<Book> getRequestedBooks() {
		return requestedBooks;
	}

	public void setRequestedBooks(List<Book> requestedBooks) {
		this.requestedBooks = requestedBooks;
	}

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

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'flush'");
	}

	@Override
	public <S extends UserProfile> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
	}

	@Override
	public <S extends UserProfile> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
	}

	@Override
	public void deleteAllInBatch(Iterable<UserProfile> entities) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
	}

	@Override
	public UserProfile getOne(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getOne'");
	}

	@Override
	public UserProfile getById(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getById'");
	}

	@Override
	public UserProfile getReferenceById(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
	}

	@Override
	public <S extends UserProfile> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public <S extends UserProfile> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public <S extends UserProfile> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
	}

	@Override
	public List<UserProfile> findAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public List<UserProfile> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
	}

	@Override
	public <S extends UserProfile> S save(S entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}

	@Override
	public Optional<UserProfile> findById(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findById'");
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'existsById'");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'count'");
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
	}

	@Override
	public void delete(UserProfile entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
	}

	@Override
	public void deleteAll(Iterable<? extends UserProfile> entities) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
	}

	@Override
	public List<UserProfile> findAll(Sort sort) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public Page<UserProfile> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public <S extends UserProfile> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findOne'");
	}

	@Override
	public <S extends UserProfile> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public <S extends UserProfile> long count(Example<S> example) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'count'");
	}

	@Override
	public <S extends UserProfile> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'exists'");
	}

	@Override
	public <S extends UserProfile, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findBy'");
	}

	@Override
	public UserProfile findByUsername(String username) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
	}

	
}
