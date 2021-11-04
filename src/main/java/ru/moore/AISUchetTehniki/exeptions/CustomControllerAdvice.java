package ru.moore.AISUchetTehniki.exeptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler
    public final ResponseEntity<?> handleUserNotFoundException(ErrorTemplate ex) {
        ErrorResponse error = new ErrorResponse(ex.getStatus(), ex.getMessage());
        return new ResponseEntity(error, ex.getStatus());
    }

}
