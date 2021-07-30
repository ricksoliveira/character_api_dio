package one.digital.innovation.characterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SkillNotFoundException extends Exception {
    public SkillNotFoundException(Long id) {
        super("Skill not found with ID: " + id);
    }
}
