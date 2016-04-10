package com.vrachieru.cnp4j;

import org.junit.Test;

import static com.vrachieru.cnp4j.Sex.FEMALE;
import static com.vrachieru.cnp4j.Sex.MALE;
import static com.vrachieru.cnp4j.Sex.UNKNOWN;
import static com.vrachieru.cnp4j.Sex.getByCode;
import static org.junit.Assert.assertEquals;

public class SexTest {

    @Test
    public void getByCode_success() {
        assertEquals(MALE, getByCode(1));
        assertEquals(MALE, getByCode(3));
        assertEquals(MALE, getByCode(5));
        assertEquals(MALE, getByCode(7));

        assertEquals(FEMALE, getByCode(2));
        assertEquals(FEMALE, getByCode(4));
        assertEquals(FEMALE, getByCode(6));
        assertEquals(FEMALE, getByCode(8));

        assertEquals(UNKNOWN, getByCode(9));
    }
}
