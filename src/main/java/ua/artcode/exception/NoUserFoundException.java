package ua.artcode.exception;

/**
 * Created by serhii on 11.03.15.
 */
public class NoUserFoundException extends ApplicationException {
    @Override
    public String getMessage() {
        return "NoUserFind";
    }
}
