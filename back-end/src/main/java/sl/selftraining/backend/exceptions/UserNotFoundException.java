package sl.selftraining.backend.exceptions;

/**
 * @author Erandika Harshani
 * Created on August 01, 2020
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
