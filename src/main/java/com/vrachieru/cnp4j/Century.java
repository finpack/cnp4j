package com.vrachieru.cnp4j;

import com.vrachieru.cnp4j.exception.Cnp4jException;

import java.util.Arrays;
import java.util.List;

public enum Century {

    NINETEENTH(1800),
    TWENTIETH(1900),
    TWENTY_FIRST(2000);

    private static List<Integer> NINETEENTH_CENTURY_CODES = Arrays.asList(3, 4);

    private static List<Integer> TWENTIETH_CENTURY_CODES = Arrays.asList(1, 2, 7, 8, 9);

    private static List<Integer> TWENTY_FIRST_CENTURY_CODES = Arrays.asList(5, 6);

    private int startYear;

    Century(int startYear) {
        this.startYear = startYear;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public static Century getByCode(final int code) {
        if (NINETEENTH_CENTURY_CODES.contains(code)) {
            return NINETEENTH;
        } if (TWENTIETH_CENTURY_CODES.contains(code)) {
            return TWENTIETH;
        } else if (TWENTY_FIRST_CENTURY_CODES.contains(code)) {
            return TWENTY_FIRST;
        }
        throw new Cnp4jException();
    }
}
