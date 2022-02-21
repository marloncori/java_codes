package pl.millennium.gnomix.error;

import pl.millennium.gnomix.domain.ErrorMessage;

public class BookAlreadyRegisteredException extends Exception {

    private ErrorMessage error;

    public BookAlreadyRegisteredException() {
        super();
    }

    public BookAlreadyRegisteredException(String message) {
        super(message);
    }

    public BookAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookAlreadyRegisteredException(Throwable cause) {
        super(cause);
    }

    protected BookAlreadyRegisteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
