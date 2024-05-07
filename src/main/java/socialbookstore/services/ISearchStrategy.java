package socialbookstore.services;

import socialbookstore.formsdata.BookFormData;
import socialbookstore.formsdata.SearchFormData;
import socialbookstore.mappers.BookMapper;

import java.util.ArrayList;

public interface ISearchStrategy {
    ArrayList<BookFormData> search(SearchFormData searchFormData, BookMapper bookMapper);
}
