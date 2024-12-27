package icu.uuqk.user.exception;

/**
 * Exception thrown when a member is not found in the database.
 */
public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("Could not find %s with %s: %s", resourceName, fieldName, fieldValue));
    }
}
