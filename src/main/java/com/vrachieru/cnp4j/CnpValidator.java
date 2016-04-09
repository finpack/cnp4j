package com.vrachieru.cnp4j;

import com.vrachieru.cnp4j.exception.Cnp4jException;

import java.util.Calendar;

import static com.vrachieru.cnp4j.CnpField.CHECK_DIGIT;
import static com.vrachieru.cnp4j.CnpField.COUNTY;
import static com.vrachieru.cnp4j.CnpField.DAY_OF_BIRTH;
import static com.vrachieru.cnp4j.CnpField.MONTH_OF_BIRTH;
import static com.vrachieru.cnp4j.CnpField.ORDER_NUMBER;
import static com.vrachieru.cnp4j.CnpField.SEX_AND_CENTURY;
import static com.vrachieru.cnp4j.CnpField.YEAR_OF_BIRTH;
import static com.vrachieru.cnp4j.CnpUtil.CNP_LENGTH;
import static com.vrachieru.cnp4j.CnpUtil.calculateCheckDigit;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.StringUtils.length;

public class CnpValidator {

    public static void validate(final String cnp) {
        validateLength(cnp);
        validateFormat(cnp);
        validateCheckDigit(cnp);
        validateSexAndCentury(cnp);
        validateDateOfBirth(cnp);
        validateCounty(cnp);
        validateOrderNumber(cnp);
    }

    private static void validateLength(final String cnp) {
        if (length(cnp) != CNP_LENGTH) {
            throw new Cnp4jException();
        }
    }

    private static void validateFormat(final String cnp) {
        if (!isNumeric(cnp)) {
            throw new Cnp4jException();
        }
    }

    private static void validateSexAndCentury(final String cnp) {
        int sexAndCentury = SEX_AND_CENTURY.from(cnp);
        Sex.getByCode(sexAndCentury);
        Century.getByCode(sexAndCentury);
    }

    private static void validateDateOfBirth(final String cnp) {
        int centuryCode = SEX_AND_CENTURY.from(cnp);
        Century century = Century.getByCode(centuryCode);
        int year = century.getStartYear() + YEAR_OF_BIRTH.from(cnp);
        int month = MONTH_OF_BIRTH.from(cnp);
        int day = DAY_OF_BIRTH.from(cnp);
        try {
            Calendar cal = Calendar.getInstance();
            cal.setLenient(false);
            cal.set(year, month, day);
            cal.getTime();
        } catch (Exception e) {
            throw new Cnp4jException();
        }
    }

    private static void validateCounty(final String cnp) {
        int countyCode = COUNTY.from(cnp);
        if (County.getByCode(countyCode) == null) {
            throw new Cnp4jException();
        }
    }

    private static void validateOrderNumber(final String cnp) {
        if (ORDER_NUMBER.from(cnp) == 0) {
            throw new Cnp4jException();
        }
    }

    private static void validateCheckDigit(final String cnp) {
        int checkDigit = calculateCheckDigit(cnp);
        if (CHECK_DIGIT.from(cnp) != checkDigit) {
            throw new Cnp4jException();
        }
    }
}
