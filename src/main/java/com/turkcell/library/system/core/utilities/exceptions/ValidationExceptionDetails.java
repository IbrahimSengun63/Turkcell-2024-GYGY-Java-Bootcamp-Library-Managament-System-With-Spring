package com.turkcell.library.system.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidationExceptionDetails extends ExceptionDetails {
    private Map<String, String> validationErrors;
}
