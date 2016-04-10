package com.vrachieru.cnp4j;

import com.vrachieru.cnp4j.exception.InvalidFormatException;

import static com.vrachieru.cnp4j.exception.CnpFormatViolation.NOT_NUMERIC;
import static org.apache.commons.lang3.StringUtils.leftPad;
import static org.apache.commons.lang3.StringUtils.substring;

public enum CnpField {

    SEX_AND_CENTURY(0, 1),
    YEAR_OF_BIRTH(1, 3),
    MONTH_OF_BIRTH(3, 5),
    DAY_OF_BIRTH(5, 7),
    COUNTY(7, 9),
    ORDER_NUMBER(9, 12),
    CHECK_DIGIT(12, 13);

    private int start;
    private int end;

    CnpField(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int from(String cnp) {
        try {
            return Integer.valueOf(substring(cnp, this.start, this.end));
        } catch (NumberFormatException e) {
            throw new InvalidFormatException(this.name(), NOT_NUMERIC);
        }
    }

    public String format(Integer value) {
        int len = this.end - this.start;
        return leftPad(substring(value.toString(), -len), len, '0');
    }
}
