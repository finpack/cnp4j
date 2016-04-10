package com.vrachieru.cnp4j;

import com.vrachieru.cnp4j.exception.InvalidDateOfBirthException;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static java.lang.Character.getNumericValue;

public class CnpUtil {

    public static final int CNP_LENGTH = 13;

    public static final int[] WEIGHTS = new int[]{2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};

    private static final Random rand = new SecureRandom();

    public static <T> boolean isNull(T value) {
        return value == null;
    }

    public static <T> boolean isNotNull(T value) {
        return !isNull(value);
    }

    public static Date buildDateOfBirth(int year, int month, int day) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setLenient(false);
            cal.set(year, month, day);
            return cal.getTime();
        } catch (Exception e) {
            throw new InvalidDateOfBirthException();
        }
    }

    public static int getDaysInMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static int randomInt(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    public static <T extends Enum<?>> T randomEnumValue(Class<T> clazz) {
        return randomEnumValue(clazz, null);
    }

    public static <T extends Enum<?>> T randomEnumValue(Class<T> clazz, T exclude) {
        List<T> values = new ArrayList(Arrays.asList(clazz.getEnumConstants()));
        values.remove(exclude);
        return values.get(rand.nextInt(values.size()));
    }

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
