package one.digital.innovation.characterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <p>This serves just as a message for the Exception for not finding a Skill</p>
 * <p>in the database, returning an Http Status NOT FOUND.</p>
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SkillNotFoundException extends Exception {
    public SkillNotFoundException(Long id) {
        super("Skill not found with ID: " + id);
    }
}
