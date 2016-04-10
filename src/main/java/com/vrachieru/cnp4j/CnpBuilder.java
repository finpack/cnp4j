package com.vrachieru.cnp4j;

import com.vrachieru.cnp4j.exception.Cnp4jException;
import com.vrachieru.cnp4j.exception.InvalidFormatException;

import java.util.Arrays;

import static com.vrachieru.cnp4j.Century.NINETEENTH;
import static com.vrachieru.cnp4j.Century.TWENTIETH;
import static com.vrachieru.cnp4j.Century.TWENTY_FIRST;
import static com.vrachieru.cnp4j.Citizenship.FOREIGN;
import static com.vrachieru.cnp4j.Citizenship.RESIDENT;
import static com.vrachieru.cnp4j.Citizenship.ROMANIAN;
import static com.vrachieru.cnp4j.CnpField.CHECK_DIGIT;
import static com.vrachieru.cnp4j.CnpField.COUNTY;
import static com.vrachieru.cnp4j.CnpField.DAY_OF_BIRTH;
import static com.vrachieru.cnp4j.CnpField.MONTH_OF_BIRTH;
import static com.vrachieru.cnp4j.CnpField.ORDER_NUMBER;
import static com.vrachieru.cnp4j.CnpField.SEX_AND_CENTURY;
import static com.vrachieru.cnp4j.CnpField.YEAR_OF_BIRTH;
import static com.vrachieru.cnp4j.CnpUtil.calculateCheckDigit;
import static com.vrachieru.cnp4j.CnpUtil.getDaysInMonth;
import static com.vrachieru.cnp4j.CnpUtil.isNotNull;
import static com.vrachieru.cnp4j.CnpUtil.isNull;
import static com.vrachieru.cnp4j.CnpUtil.randomEnumValue;
import static com.vrachieru.cnp4j.CnpUtil.randomInt;
import static com.vrachieru.cnp4j.CnpValidator.validate;
import static com.vrachieru.cnp4j.Sex.UNKNOWN;

public class CnpBuilder {

    private Sex sex;

    private Citizenship citizenship;

    private Century century;

    private Integer yearOfBirth;

    private Integer monthOfBirth;

    private Integer dayOfBirth;

    private County county;

    private Integer orderNumber;

    public static CnpBuilder aCnp() {
        return new CnpBuilder();
    }

    public CnpBuilder withSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public CnpBuilder withCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
        return this;
    }

    public CnpBuilder withCentury(Century century) {
        this.century = century;
        return this;
    }

    public CnpBuilder withYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    public CnpBuilder withMonthOfBirth(Integer monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
        return this;
    }

    public CnpBuilder withDayOfBirth(Integer dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
        return this;
    }

    public CnpBuilder withCounty(County county) {
        this.county = county;
        return this;
    }

    public CnpBuilder withOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public Cnp build() {
        sanityCheck();
        fillMissingFieldsRandomly();
        String formatted = formatCnp();
        validate(formatted);
        return new Cnp(formatted);
    }

    private void sanityCheck() {
        if (isNotNull(this.century) && isNotNull(this.yearOfBirth)) {
            throw new InvalidFormatException();
        }
    }

    private void fillMissingFieldsRandomly() {
        fillOrderNumber();
        fillCounty();
        fillYearOfBirth();
        fillMonthOfBirth();
        fillDayOfBirth();
        fillCentury();
        fillCitizenship();
        fillSex();
    }

    private void fillOrderNumber() {
        if (isNull(this.orderNumber)) {
            this.orderNumber = randomInt(1, 999);
        }
    }

    private void fillCounty() {
        if (isNull(this.county)) {
            this.county = randomEnumValue(County.class);
        }
    }

    private void fillYearOfBirth() {
        if (isNull(this.yearOfBirth)) {
            if (this.sex == UNKNOWN || this.citizenship == FOREIGN || this.citizenship == RESIDENT) {
                this.yearOfBirth = randomInt(TWENTIETH.getStartYear(), TWENTIETH.getEndYear());
            } else if (isNull(this.century)) {
                this.yearOfBirth = randomInt(NINETEENTH.getStartYear(), TWENTY_FIRST.getEndYear());
            } else {
                this.yearOfBirth = randomInt(this.century.getStartYear(), this.century.getEndYear());
            }
        }
    }

    private void fillMonthOfBirth() {
        if (isNull(this.monthOfBirth)) {
            this.monthOfBirth = randomInt(1, 12);
        }
    }

    private void fillDayOfBirth() {
        if (isNull(this.dayOfBirth)) {
            this.dayOfBirth = randomInt(1, getDaysInMonth(this.yearOfBirth, this.monthOfBirth));
        }
    }

    private void fillCentury() {
        if (isNull(this.century)) {
            this.century = Century.getFromYear(this.yearOfBirth);
        }
    }

    private void fillCitizenship() {
        if (isNull(this.citizenship)) {
            if (this.century == NINETEENTH || this.century == TWENTY_FIRST) {
                this.citizenship = ROMANIAN;
            } else if (isNull(this.sex)) {
                this.citizenship = randomEnumValue(Citizenship.class);
            } else if (this.sex == UNKNOWN) {
                this.citizenship = FOREIGN;
            } else {
                this.citizenship = randomEnumValue(Citizenship.class, FOREIGN);
            }
        }
    }

    private void fillSex() {
        if (isNull(this.sex)) {
            if (this.citizenship == FOREIGN) {
                this.sex = UNKNOWN;
            } else {
                this.sex = randomEnumValue(Sex.class, UNKNOWN);
            }
        }
    }

    private int correlate() {
        for (int i = 1; i < 10; i++) {
            if (Sex.getMapping().get(i) == this.sex &&
                    Citizenship.getMapping().get(i) == this.citizenship &&
                    Century.getMapping().get(i) == this.century) {
                return i;
            }
        }
        throw new Cnp4jException();
    }

    private String formatCnp() {
        final StringBuilder sb = new StringBuilder();
        sb.append(SEX_AND_CENTURY.format(correlate()));
        sb.append(YEAR_OF_BIRTH.format(yearOfBirth));
        sb.append(MONTH_OF_BIRTH.format(monthOfBirth));
        sb.append(DAY_OF_BIRTH.format(dayOfBirth));
        sb.append(COUNTY.format(county.getCode()));
        sb.append(ORDER_NUMBER.format(orderNumber));
        sb.append(CHECK_DIGIT.format(calculateCheckDigit(sb.toString())));

        return sb.toString();
    }
}
