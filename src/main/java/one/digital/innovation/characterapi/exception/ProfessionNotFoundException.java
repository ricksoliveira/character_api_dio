package one.digital.innovation.characterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfessionNotFoundException extends Exception {
    public ProfessionNotFoundException(Long id) {
        super("Profession not found with ID: " + id);
    }
}
