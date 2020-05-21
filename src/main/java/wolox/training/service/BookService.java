package wolox.training.service;

import wolox.training.models.Book;

public interface BookService {
    Iterable findAll();
    Book findOneByAuthor(String bookAuthor);
    Book findOne(Long id);
    Book create(Book book);
    void delete(Long id);
    Book update(Book book, Long id);
}
