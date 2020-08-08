package sl.selftraining.backend.exceptions;

/**
 * @author Erandika Harshani
 * Created on August 01, 2020
 */
public class PublicationAlreadyExistException extends RuntimeException {
    public PublicationAlreadyExistException(String message) {
        super(message);
    }
}
