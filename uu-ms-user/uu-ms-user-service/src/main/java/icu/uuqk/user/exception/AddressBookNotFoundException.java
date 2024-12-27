package icu.uuqk.user.exception;

/**
 * Exception thrown when a resource is not found in the address book.
 */
public class AddressBookNotFoundException extends RuntimeException {
    public AddressBookNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("Could not find %s with %s: %s", resourceName, fieldName, fieldValue));
    }
}
