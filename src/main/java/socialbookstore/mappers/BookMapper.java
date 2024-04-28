package socialbookstore.mappers;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import socialbookstore.domainmodel.Book;

public interface BookMapper extends JpaRepository<Book, Long>{
        List<Book> findByTitle(String title);
        List<Book> findByTitleContaining(String title);

}   