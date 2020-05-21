package wolox.training.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import wolox.training.models.Book;

public interface BookRepository extends Repository<Book, Long> {
    Optional<Book> findFirstByAuthor (final String author);

    Optional<Book> findById(final long id);

    List<Book> findAll();

    void deleteById(final long id);

    Book save(final Book book);
}
