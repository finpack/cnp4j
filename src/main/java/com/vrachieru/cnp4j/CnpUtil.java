package com.vrachieru.cnp4j;

import static java.lang.Character.getNumericValue;

public class CnpUtil {

    public static final int CNP_LENGTH = 13;

    public static final int[] WEIGHTS = new int[]{2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};

    public static int calculateCheckDigit(String cnp) {
        int sum = calculateSum(cnp);
        int checkDigit = sum % 11;
        return (checkDigit == 10) ? 1 : checkDigit;
    }

    public static int calculateSum(String cnp) {
        int sum = 0;
        for (int i = 0; i < CNP_LENGTH - 1; i++) {
            sum += getNumericValue(cnp.charAt(i)) * WEIGHTS[i];
        }
        return sum;
    }
}
