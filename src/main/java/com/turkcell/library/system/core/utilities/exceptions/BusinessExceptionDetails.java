package com.turkcell.library.system.core.utilities.exceptions;

public class BusinessExceptionDetails extends ExceptionDetails {
    public BusinessExceptionDetails() {
        setTitle("Business Rule Violation");
        setType("http://mydomain.com/exceptions/business");
        setStatus("400");
    }
}
