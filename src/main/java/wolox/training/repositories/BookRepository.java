package wolox.training.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import wolox.training.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findFirstByAuthor (final String author);

    Optional<Book> findById(final long id);

//    void deleteById(final long id);

//    Book save(final Book book);
}
