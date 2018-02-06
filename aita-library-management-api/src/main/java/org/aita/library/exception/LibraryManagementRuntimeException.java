package org.aita.library.exception;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
public class LibraryManagementRuntimeException extends RuntimeException{
    public LibraryManagementRuntimeException() {
    }

    public LibraryManagementRuntimeException(String message) {
        super(message);
    }

    public LibraryManagementRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryManagementRuntimeException(Throwable cause) {
        super(cause);
    }

    public LibraryManagementRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
