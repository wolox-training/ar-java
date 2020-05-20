package wolox.training.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String field, String value) {
        super(String.format("Book with %s %s not found", field, value));
    }
}
