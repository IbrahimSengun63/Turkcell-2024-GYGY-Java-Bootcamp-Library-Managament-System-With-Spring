package com.turkcell.library.system.core.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //with exception handler we indicated that whenever an exception happen in application instead of default exception handlers we will define our customized handler
    //to modify exception output we define a class with our desired settings
    //we pass business rule exception object as parameter --> we will interrupt and alter all the business rule exception
    //business rule class's base is extend of super class Runtime exception, using this we extract desired information from business exception and save our problem details class
    //after the process we return our information stored object problem details
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessExceptionDetails handleBusinessException(BusinessException businessException) {
        BusinessExceptionDetails businessExceptionDetails = new BusinessExceptionDetails();
        businessExceptionDetails.setDetail(businessException.getMessage());
        return businessExceptionDetails;
    }

    @ExceptionHandler({NoSuchElementException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BusinessExceptionDetails handleNoSuchElementException(NoSuchElementException exception) {
        BusinessExceptionDetails businessExceptionDetails = new BusinessExceptionDetails();
        businessExceptionDetails.setDetail(exception.getMessage());
        businessExceptionDetails.setStatus("500");
        return businessExceptionDetails;
    }

    // Exception handler method to handle MethodArgumentNotValidException
    // It responds with HTTP status code 400 (Bad Request) for this type of exception
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDetails handleValidationException(MethodArgumentNotValidException ex) {
        // Create a new instance of ValidationProblemDetails to encapsulate validation errors
        ValidationExceptionDetails validationExceptionDetails = new ValidationExceptionDetails();
        // Set the message for the validation exception
        validationExceptionDetails.setDetail("VALIDATION.EXCEPTION");
        // Extract field errors from the exception, convert them into a map, and store them in validationProblemDetails
        validationExceptionDetails.setValidationErrors(
                ex.getBindingResult().getFieldErrors().stream()
                        .collect(Collectors.toMap(error -> Objects.requireNonNull(error.getCodes())[error.getCodes().length - 1],
                                error -> error.getField() + " field " + error.getDefaultMessage()))
        );

        // Return the instance containing the validation errors
        return validationExceptionDetails;
    }
}
