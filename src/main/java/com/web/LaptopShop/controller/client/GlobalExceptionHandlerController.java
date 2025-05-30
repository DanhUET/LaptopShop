package com.web.LaptopShop.controller.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandlerController {
    @ExceptionHandler(value = NullPointerException.class)
    public String handleNullPointerException(Exception e) {

        System.out.println("A null pointer exception ocurred " + e);

        return "nullpointerExceptionPage";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public String handleAllException(Exception e) {

        System.out.println("A unknow Exception Ocurred: " + e);

        return "unknowExceptionPage";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle(NoHandlerFoundException ex) {

        return "client/auth/error";
    }
}
