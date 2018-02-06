package org.aita.library.exception;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
public class LibraryManagementBusinessException extends LibraryManagementRuntimeException {
    public LibraryManagementBusinessException() {
    }

    public LibraryManagementBusinessException(String message) {
        super(message);
    }

    public LibraryManagementBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryManagementBusinessException(Throwable cause) {
        super(cause);
    }

    public LibraryManagementBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
