package fr.shewbii.maplr_sugar_shack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectDataException extends RuntimeException {
    public IncorrectDataException() {
        super();
    }
}
