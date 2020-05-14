package wolox.training.repositories;

import org.springframework.data.repository.Repository;
import wolox.training.models.Book;

public interface BookRepository extends Repository<Book, String> {
    Book findFirstByAuthor (String author);
}
