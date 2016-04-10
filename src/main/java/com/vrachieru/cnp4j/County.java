package com.vrachieru.cnp4j;

import com.vrachieru.cnp4j.exception.InvalidCountyException;

import java.util.HashMap;
import java.util.Map;

public enum County {

    AB("Alba", 1),
    AR("Arad", 2),
    AG("Arges", 3),
    BC("Bacau", 4),
    BH("Bihor", 5),
    BN("Bistrita-Nasaud", 6),
    BT("Botosani", 7),
    BV("Brasov", 8),
    BR("Braila", 9),
    BZ("Buzau", 10),
    CS("Caraa-Severin", 11),
    CJ("Cluj", 12),
    CT("Constanta", 13),
    CV("Covasna", 14),
    DB("Dambovita", 15),
    DJ("Dolj", 16),
    GL("Galati", 17),
    GJ("Gorj", 18),
    HR("Harghita", 19),
    HD("Hunedoara", 20),
    IL("Ialomita", 21),
    IS("Iasi", 22),
    IF("Ilfov", 23),
    MM("Maramures", 24),
    MH("Mehedinti", 25),
    MS("Mures", 26),
    NT("Neamt", 27),
    OT("Olt", 28),
    PH("Prahova", 29),
    SM("Satu Mare", 30),
    SJ("Salaj", 31),
    SB("Sibiu", 32),
    SV("Suceava", 33),
    TR("Teleorman", 34),
    TM("Timis", 35),
    TL("Tulcea", 36),
    VS("Vaslui", 37),
    VL("Valcea", 38),
    VN("Vrancea", 39),
    B("Bucuresti", 40),
    B1("Bucuresti S.1", 41),
    B2("Bucuresti S.2", 42),
    B3("Bucuresti S.3", 43),
    B4("Bucuresti S.4", 44),
    B5("Bucuresti S.5", 45),
    B6("Bucuresti S.6", 46),
    CL("Calarasi", 51),
    GR("Giurgiu", 52);

    private static final Map<Integer, County> map = new HashMap<>();

    static {
        for (final County county : values()) {
            map.put(county.getCode(), county);
        }
    }

    private String name;

    private int code;

    County(String name, int numericCode) {
        this.name = name;
        this.code = numericCode;
    }

    public String getName() {
        return this.name;
    }

    public int getCode() {
        return this.code;
    }

    public static County getByCode(int code) {
        if (!map.containsKey(code)) {
            throw new InvalidCountyException();
        }
        return map.get(code);
    }
}
