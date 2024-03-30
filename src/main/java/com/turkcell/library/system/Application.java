package com.turkcell.library.system;

import com.turkcell.library.system.core.utilities.exceptions.BusinessException;
import com.turkcell.library.system.core.utilities.exceptions.ExceptionDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// with this we indicated that we will intervene the communication between application and end user
@RestControllerAdvice
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//with exception handler we indicated that whenever an exception happen in application instead of default exception handlers we will define our customized handler
	//to modify exception output we define a class with our desired settings
	//we pass business rule exception object as parameter --> we will interrupt and alter all the business rule exception
	//business rule class's base is extend of super class Runtime exception, using this we extract desired information from business exception and save our problem details class
	//after the process we return our information stored object problem details
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionDetails handleBusinessException(BusinessException businessException) {
		ExceptionDetails exceptionDetails = new ExceptionDetails();
		exceptionDetails.setMessage(businessException.getMessage());
		return exceptionDetails;
	}
}
