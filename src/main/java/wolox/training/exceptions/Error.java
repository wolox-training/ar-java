package wolox.training.exceptions;

public class Error{
    private String message;
    private int status;

    public Error(){}

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public Error(final String message, final int status) {
        this.message = message;
        this.status = status;
    }

}