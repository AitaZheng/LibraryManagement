package org.aita.library.exception;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
public class LibraryManagementMemberException extends LibraryManagementBusinessException {
    public LibraryManagementMemberException() {
    }

    public LibraryManagementMemberException(String message) {
        super(message);
    }

    public LibraryManagementMemberException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryManagementMemberException(Throwable cause) {
        super(cause);
    }

    public LibraryManagementMemberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
