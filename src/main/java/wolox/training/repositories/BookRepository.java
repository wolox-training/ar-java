package wolox.training.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import wolox.training.models.Book;

public interface BookRepository extends Repository<Book, Long> {
    Optional<Book> findFirstByAuthor (String author);

    Optional<Book> findById(long id);

    @Query(value = "SELECT b FROM Book b")
    List<Book> findAllBooks();

    void deleteById(long id);

    Book save(Book book);
}
