package me.powerticket.toonbew.common.advice;

import me.powerticket.toonbew.common.exception.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    public String notFoundException(NotFoundException e) {
        return e.getMessage();
    }
}
