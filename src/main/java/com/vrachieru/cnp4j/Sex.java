package com.vrachieru.cnp4j;

import com.vrachieru.cnp4j.exception.Cnp4jException;

import java.util.Arrays;
import java.util.List;

public enum Sex {

    MALE,
    FEMALE,
    UNKNOWN;

    private static List<Integer> MALE_GENDER_CODES = Arrays.asList(1, 3, 5, 7);

    private static List<Integer> FEMALE_GENDER_CODES = Arrays.asList(2, 4, 6, 8);

    private static int UNKNOWN_GENDER_CODE = 9;

    public static Sex getByCode(final int code) {
        if (MALE_GENDER_CODES.contains(code)) {
            return MALE;
        } else if (FEMALE_GENDER_CODES.contains(code)) {
            return FEMALE;
        } else if (UNKNOWN_GENDER_CODE == code) {
            return UNKNOWN;
        }
        throw new Cnp4jException();
    }
}
