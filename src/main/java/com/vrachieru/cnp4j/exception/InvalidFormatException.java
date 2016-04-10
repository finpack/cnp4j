package com.vrachieru.cnp4j.exception;

import static java.lang.String.format;

public class InvalidFormatException extends Cnp4jException {

    private static final String EXCEPTION_MESSAGE = "The %s field value is %s.";

    public InvalidFormatException() {
        super();
    }

    public InvalidFormatException(String field, CnpFormatViolation reason) {
        super(format(EXCEPTION_MESSAGE, field, reason.getMessage()));
    }
}
