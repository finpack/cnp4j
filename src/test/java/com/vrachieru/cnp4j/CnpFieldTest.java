package com.vrachieru.cnp4j;

import com.vrachieru.cnp4j.exception.InvalidFormatException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.vrachieru.cnp4j.CnpField.CHECK_DIGIT;
import static com.vrachieru.cnp4j.CnpField.COUNTY;
import static com.vrachieru.cnp4j.CnpField.DAY_OF_BIRTH;
import static com.vrachieru.cnp4j.CnpField.MONTH_OF_BIRTH;
import static com.vrachieru.cnp4j.CnpField.ORDER_NUMBER;
import static com.vrachieru.cnp4j.CnpField.SEX_AND_CENTURY;
import static com.vrachieru.cnp4j.CnpField.YEAR_OF_BIRTH;
import static com.vrachieru.cnp4j.exception.CnpFormatViolation.NOT_NUMERIC;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.junit.Assert.assertEquals;

public class CnpFieldTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void from_success() {
        String cnp = "1910209405808";

        assertEquals(1, SEX_AND_CENTURY.from(cnp));
        assertEquals(91, YEAR_OF_BIRTH.from(cnp));
        assertEquals(2, MONTH_OF_BIRTH.from(cnp));
        assertEquals(9, DAY_OF_BIRTH.from(cnp));
        assertEquals(40, COUNTY.from(cnp));
        assertEquals(580, ORDER_NUMBER.from(cnp));
        assertEquals(8, CHECK_DIGIT.from(cnp));
    }

    @Test
    public void from_failure_null() {
        from_failure(SEX_AND_CENTURY, null);
    }

    @Test
    public void from_failure_empty() {
        from_failure(YEAR_OF_BIRTH, EMPTY);
    }

    @Test
    public void from_failure_whitespace() {
        from_failure(MONTH_OF_BIRTH, "  ");
    }

    @Test
    public void from_failure_letter() {
        from_failure(COUNTY, "BC");
    }

    private void from_failure(CnpField field, String value) {
        exception.expect(InvalidFormatException.class);
        exception.expectMessage(NOT_NUMERIC.getMessage());

        field.from(value);
    }
}
