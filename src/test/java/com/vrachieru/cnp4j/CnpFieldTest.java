package com.vrachieru.cnp4j;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import org.junit.Test;

import static com.vrachieru.cnp4j.CnpField.*;
import static org.junit.Assert.assertEquals;

public class CnpFieldTest {

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
}
