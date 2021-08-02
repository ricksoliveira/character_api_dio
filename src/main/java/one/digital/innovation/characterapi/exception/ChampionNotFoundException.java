package one.digital.innovation.characterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <p>This serves just as a message for the Exception for not finding a Champion</p>
 * <p>in the database, returning an Http Status NOT FOUND.</p>
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ChampionNotFoundException extends Exception {
    public ChampionNotFoundException(Long id) {
        super("Champion not found with ID: " + id);
    }
}
