package sl.selftraining.backend.exceptions;

/**
 * @author Erandika Harshani
 * Created on August 01, 2020
 */
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
