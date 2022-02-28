package dac.task.exceptions;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ItemNotFoundException.class, ObjectNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final String handleNotFoundException(Exception e) {
        return e.toString();
    }

}
