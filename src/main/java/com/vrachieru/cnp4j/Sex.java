package com.vrachieru.cnp4j;

import com.vrachieru.cnp4j.exception.InvalidSexException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Sex {

    MALE,
    FEMALE,
    UNKNOWN;

    private static Map<Integer, Sex> MAPPING = new HashMap<Integer, Sex>();

    static {
        for (int i : Arrays.asList(1, 3, 5, 7)) {
            MAPPING.put(i, MALE);
        }
        for (int i : Arrays.asList(2, 4, 6, 8)) {
            MAPPING.put(i, FEMALE);
        }
        MAPPING.put(9, UNKNOWN);
    }

    public static Map<Integer, Sex> getMapping() {
        return MAPPING;
    }

    public static Sex getByCode(final int code) {
        if (!MAPPING.containsKey(code)) {
            throw new InvalidSexException();
        }
        return MAPPING.get(code);
    }
}
