package sl.selftraining.backend.exceptions;

/**
 * @author Erandika Harshani
 * Created on August 01, 2020
 */
public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
