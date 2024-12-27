package icu.uuqk.user.exception;

/**
 * Exception thrown when an Address Book cannot be created.
 */
public class AddressBookCreateException extends RuntimeException {
    public AddressBookCreateException() {
        super("创建 Address Book 失败");
    }
}
