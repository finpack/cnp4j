package com.vrachieru.cnp4j;

import com.vrachieru.cnp4j.exception.Cnp4jException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CnpValidatorTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void validate_success_1800_male() {
        CnpValidator.validate("3350717113978");
        CnpValidator.validate("3290202368859");
        CnpValidator.validate("3070709233667");
    }

    @Test
    public void validate_success_1800_female() {
        CnpValidator.validate("4490805241431");
        CnpValidator.validate("4860708316111");
        CnpValidator.validate("4440510283854");
    }

    @Test
    public void validate_success_1900_male() {
        CnpValidator.validate("1210419290352");
        CnpValidator.validate("1780310350607");
        CnpValidator.validate("1930313207799");
    }

    @Test
    public void validate_success_1900_female() {
        CnpValidator.validate("2750705226687");
        CnpValidator.validate("2151224322302");
        CnpValidator.validate("2190616042297");
    }

    @Test
    public void validate_success_2000_male() {
        CnpValidator.validate("5140129079734");
        CnpValidator.validate("5001116287452");
        CnpValidator.validate("5031107050671");
    }

    @Test
    public void validate_success_2000_female() {
        CnpValidator.validate("6140514337371");
        CnpValidator.validate("6130520171631");
        CnpValidator.validate("6101025222967");
    }

    @Test
    public void validate_failure_invalidCheckDigit() {
        exception.expect(Cnp4jException.class);
        CnpValidator.validate("1910209405800");
    }
}
