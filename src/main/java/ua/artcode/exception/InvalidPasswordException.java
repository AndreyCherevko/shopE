package ua.artcode.exception;

/**
 * Created by andrey on 24.03.15.
 */
public class InvalidPasswordException extends ApplicationException {

    @Override
    public String getMessage() {
        return "InvalidPassword";
    }
}
