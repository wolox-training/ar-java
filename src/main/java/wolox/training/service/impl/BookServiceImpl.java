package wolox.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wolox.training.exceptions.BookIdMismatchException;
import wolox.training.exceptions.BookNotFoundException;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;
import wolox.training.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findOneByAuthor(String bookAuthor){
        return bookRepository.findFirstByAuthor(bookAuthor)
            .orElseThrow(() -> new BookNotFoundException("Author", bookAuthor));
    }

    @Override
    public Book findOne(Long id){
        return bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException("ID", id.toString()));
    }
    @Override
    public Book create(Book book){ return bookRepository.save(book); }
    @Override
    public void delete(Long id){
        bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException("ID", id.toString()));
        bookRepository.deleteById(id);
    }
    @Override
    public Book update(Book book, Long id){
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException("ID", id.toString()));
        return bookRepository.save(book);
    }
}
