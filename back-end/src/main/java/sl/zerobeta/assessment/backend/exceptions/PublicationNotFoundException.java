package sl.zerobeta.assessment.backend.exceptions;

/**
 * @author Erandika Harshani
 * Created on August 01, 2020
 */
public class PublicationNotFoundException extends RuntimeException {
    public PublicationNotFoundException(String message) {
        super(message);
    }
}
