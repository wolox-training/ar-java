package wolox.training.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(final String field, final String value) {
        super(String.format("Book with %s %s not found", field, value));
    }
}
