package com.vrachieru.cnp4j;

import com.vrachieru.cnp4j.exception.InvalidCitizenshipException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Citizenship {
    ROMANIAN,
    RESIDENT,
    FOREIGN;

    private static Map<Integer, Citizenship> MAPPING = new HashMap<Integer, Citizenship>();

    static {
        for (int i : Arrays.asList(1, 2, 3, 4, 5, 6)) {
            MAPPING.put(i, ROMANIAN);
        }
        for (int i : Arrays.asList(7, 8)) {
            MAPPING.put(i, RESIDENT);
        }
        MAPPING.put(9, FOREIGN);
    }

    public static Map<Integer, Citizenship> getMapping() {
        return MAPPING;
    }

    public static Citizenship getByCode(final int code) {
        if (!MAPPING.containsKey(code)) {
            throw new InvalidCitizenshipException();
        }
        return MAPPING.get(code);
    }
}
