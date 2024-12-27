package icu.uuqk.user.exception;

/**
 * Exception thrown when a member with the same field already exists in the database.
 */
public class MemberAlreadyExistsException extends RuntimeException {
    public MemberAlreadyExistsException(String fieldName, String fieldValue) {
        super(String.format("Member already exists with %s: %s", fieldName, fieldValue));
    }
}
