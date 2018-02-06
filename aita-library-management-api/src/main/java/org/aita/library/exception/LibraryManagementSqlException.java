package org.aita.library.exception;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
public class LibraryManagementSqlException extends LibraryManagementRuntimeException {
    public LibraryManagementSqlException() {
    }

    public LibraryManagementSqlException(String message) {
        super(message);
    }

    public LibraryManagementSqlException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryManagementSqlException(Throwable cause) {
        super(cause);
    }

    public LibraryManagementSqlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
