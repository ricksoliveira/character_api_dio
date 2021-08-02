package one.digital.innovation.characterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <p>This serves just as a message for the Exception for not finding a Profession</p>
 * <p>in the database, returning an Http Status NOT FOUND.</p>
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfessionNotFoundException extends Exception {
    public ProfessionNotFoundException(Long id) {
        super("Profession not found with ID: " + id);
    }
}
