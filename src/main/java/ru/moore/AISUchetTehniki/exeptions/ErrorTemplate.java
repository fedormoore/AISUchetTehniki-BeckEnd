package ru.moore.AISUchetTehniki.exeptions;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class ErrorTemplate extends RuntimeException{

    private HttpStatus status;
    private String message;

    public ErrorTemplate(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
