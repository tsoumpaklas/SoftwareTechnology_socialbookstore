package socialbookstore.mappers;

import java.util.List;
import socialbookstore.domainmodel.BookCategory;

public interface BookCategoryMapper {
    List<BookCategory> findByName(String name);
}
