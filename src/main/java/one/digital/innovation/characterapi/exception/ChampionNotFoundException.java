package one.digital.innovation.characterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ChampionNotFoundException extends Exception {
    public ChampionNotFoundException(Long id) {
        super("Champion not found with ID: " + id);
    }
}
