package de.sep.calocalendar.utils;

import de.sep.calocalendar.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createAndLogError(ex.getMessage()));
    }

    private static Error createAndLogError(String errorMessage) {
        return Optional.ofNullable(errorMessage)
                .map(erMessage -> createAndLogError(List.of(erMessage)))
                .orElseGet(ControllerExceptionHandler::createAndLogError);
    }

    private static Error createAndLogError(List<String> errorMessages) {
        return new Error()
                .errorMessages(errorMessages)
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    private static Error createAndLogError() {
        return new Error()
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase());
    }
}
