package com.vrachieru.cnp4j.exception;

public enum CnpFormatViolation {
    NULL("null"),
    EMPTY("empty"),
    NOT_NUMERIC("not numeric"),
    UNKNOWN("unknown");

    private String message;

    CnpFormatViolation(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}