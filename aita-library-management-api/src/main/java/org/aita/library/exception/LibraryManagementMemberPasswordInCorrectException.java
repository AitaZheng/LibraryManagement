package org.aita.library.exception;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
public class LibraryManagementMemberPasswordInCorrectException extends LibraryManagementBusinessException {
    public LibraryManagementMemberPasswordInCorrectException() {
    }

    public LibraryManagementMemberPasswordInCorrectException(String message) {
        super(message);
    }

    public LibraryManagementMemberPasswordInCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryManagementMemberPasswordInCorrectException(Throwable cause) {
        super(cause);
    }

    public LibraryManagementMemberPasswordInCorrectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
