package com.vrachieru.cnp4j;

import com.vrachieru.cnp4j.exception.InvalidCenturyException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Century {

    NINETEENTH(1800, 1899),
    TWENTIETH(1900, 1999),
    TWENTY_FIRST(2000, 2999);

    private static Map<Integer, Century> MAPPING = new HashMap<Integer, Century>();

    static {
        for (int i : Arrays.asList(3, 4)) {
            MAPPING.put(i, NINETEENTH);
        }
        for (int i : Arrays.asList(1, 2, 7, 8, 9)) {
            MAPPING.put(i, TWENTIETH);
        }
        for (int i : Arrays.asList(5, 6)) {
            MAPPING.put(i, TWENTY_FIRST);
        }
    }

    private int startYear;

    private int endYear;

    Century(int startYear, int endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public int getEndYear() {
        return this.endYear;
    }

    public static Map<Integer, Century> getMapping() {
        return MAPPING;
    }

    public static Century getByCode(final int code) {
        if (!MAPPING.containsKey(code)) {
            throw new InvalidCenturyException();
        }
        return MAPPING.get(code);
    }

    public static Century getFromYear(final int year) {
        if (year < NINETEENTH.startYear || year > TWENTY_FIRST.endYear) {
            throw new InvalidCenturyException();
        }
        int century = year / 100 * 100;
        if (NINETEENTH.startYear == century) {
            return NINETEENTH;
        } else if (TWENTIETH.startYear == century) {
            return TWENTIETH;
        } else {
            return TWENTY_FIRST;
        }
    }
}
