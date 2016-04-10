package com.vrachieru.cnp4j;

import org.junit.Test;

import static com.vrachieru.cnp4j.Century.TWENTIETH;
import static com.vrachieru.cnp4j.Sex.MALE;

public class CnpBuilderTest {

    private static final int ITERATIONS = 1000;

    @Test
    public void build_success_random() {
        for (int i = 0; i < ITERATIONS; i++) {
            CnpBuilder.aCnp().build();
        }
    }

    @Test
    public void build_success_withSex() {
        for (int i = 0; i < ITERATIONS; i++) {
            CnpBuilder.aCnp().withSex(MALE).build();
        }
    }

}
