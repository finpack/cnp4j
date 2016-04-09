package com.vrachieru.cnp4j;

import org.junit.Test;

import static com.vrachieru.cnp4j.Century.NINETEENTH;
import static com.vrachieru.cnp4j.Century.TWENTIETH;
import static com.vrachieru.cnp4j.Century.TWENTY_FIRST;
import static org.junit.Assert.assertEquals;

public class CenturyTest {

    @Test
    public void getByCode_success() {
        assertEquals(NINETEENTH, Century.getByCode(3));
        assertEquals(NINETEENTH, Century.getByCode(4));

        assertEquals(TWENTIETH, Century.getByCode(1));
        assertEquals(TWENTIETH, Century.getByCode(2));
        assertEquals(TWENTIETH, Century.getByCode(7));
        assertEquals(TWENTIETH, Century.getByCode(8));
        assertEquals(TWENTIETH, Century.getByCode(9));

        assertEquals(TWENTY_FIRST, Century.getByCode(5));
        assertEquals(TWENTY_FIRST, Century.getByCode(6));
    }

    @Test
    public void getStartYear_success() {
        assertEquals(1800, NINETEENTH.getStartYear());
        assertEquals(1900, TWENTIETH.getStartYear());
        assertEquals(2000, TWENTY_FIRST.getStartYear());
    }
}
