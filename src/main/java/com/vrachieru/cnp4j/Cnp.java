package com.vrachieru.cnp4j;

import static com.vrachieru.cnp4j.CnpValidator.validate;

public class Cnp {

    private final String value;

    public Cnp(final String value) {
        this.value = value;
    }

    public static Cnp valueOf(final String cnp) {
        validate(cnp);
        return new Cnp(cnp);
    }

    public Sex getSex() {
        return Sex.getByCode(1);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Cnp) {
            return value.equals(((Cnp) obj).value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
