package com.vrachieru.cnp4j;

import org.junit.Test;

import static com.vrachieru.cnp4j.County.AB;
import static com.vrachieru.cnp4j.County.AG;
import static com.vrachieru.cnp4j.County.AR;
import static com.vrachieru.cnp4j.County.B;
import static com.vrachieru.cnp4j.County.B1;
import static com.vrachieru.cnp4j.County.B2;
import static com.vrachieru.cnp4j.County.B3;
import static com.vrachieru.cnp4j.County.B4;
import static com.vrachieru.cnp4j.County.B5;
import static com.vrachieru.cnp4j.County.B6;
import static com.vrachieru.cnp4j.County.BC;
import static com.vrachieru.cnp4j.County.BH;
import static com.vrachieru.cnp4j.County.BN;
import static com.vrachieru.cnp4j.County.BR;
import static com.vrachieru.cnp4j.County.BT;
import static com.vrachieru.cnp4j.County.BV;
import static com.vrachieru.cnp4j.County.BZ;
import static com.vrachieru.cnp4j.County.CJ;
import static com.vrachieru.cnp4j.County.CL;
import static com.vrachieru.cnp4j.County.CS;
import static com.vrachieru.cnp4j.County.CT;
import static com.vrachieru.cnp4j.County.CV;
import static com.vrachieru.cnp4j.County.DB;
import static com.vrachieru.cnp4j.County.DJ;
import static com.vrachieru.cnp4j.County.GJ;
import static com.vrachieru.cnp4j.County.GL;
import static com.vrachieru.cnp4j.County.GR;
import static com.vrachieru.cnp4j.County.HD;
import static com.vrachieru.cnp4j.County.HR;
import static com.vrachieru.cnp4j.County.IF;
import static com.vrachieru.cnp4j.County.IL;
import static com.vrachieru.cnp4j.County.IS;
import static com.vrachieru.cnp4j.County.MH;
import static com.vrachieru.cnp4j.County.MM;
import static com.vrachieru.cnp4j.County.MS;
import static com.vrachieru.cnp4j.County.NT;
import static com.vrachieru.cnp4j.County.OT;
import static com.vrachieru.cnp4j.County.PH;
import static com.vrachieru.cnp4j.County.SB;
import static com.vrachieru.cnp4j.County.SJ;
import static com.vrachieru.cnp4j.County.SM;
import static com.vrachieru.cnp4j.County.SV;
import static com.vrachieru.cnp4j.County.TL;
import static com.vrachieru.cnp4j.County.TM;
import static com.vrachieru.cnp4j.County.TR;
import static com.vrachieru.cnp4j.County.VL;
import static com.vrachieru.cnp4j.County.VN;
import static com.vrachieru.cnp4j.County.VS;
import static com.vrachieru.cnp4j.County.getByCode;
import static org.junit.Assert.assertEquals;

public class CountyTest {

    @Test
    public void getByCode_success() {
        assertEquals(AB, getByCode(1));
        assertEquals(AR, getByCode(2));
        assertEquals(AG, getByCode(3));
        assertEquals(BC, getByCode(4));
        assertEquals(BH, getByCode(5));
        assertEquals(BN, getByCode(6));
        assertEquals(BT, getByCode(7));
        assertEquals(BV, getByCode(8));
        assertEquals(BR, getByCode(9));
        assertEquals(BZ, getByCode(10));
        assertEquals(CS, getByCode(11));
        assertEquals(CJ, getByCode(12));
        assertEquals(CT, getByCode(13));
        assertEquals(CV, getByCode(14));
        assertEquals(DB, getByCode(15));
        assertEquals(DJ, getByCode(16));
        assertEquals(GL, getByCode(17));
        assertEquals(GJ, getByCode(18));
        assertEquals(HR, getByCode(19));
        assertEquals(HD, getByCode(20));
        assertEquals(IL, getByCode(21));
        assertEquals(IS, getByCode(22));
        assertEquals(IF, getByCode(23));
        assertEquals(MM, getByCode(24));
        assertEquals(MH, getByCode(25));
        assertEquals(MS, getByCode(26));
        assertEquals(NT, getByCode(27));
        assertEquals(OT, getByCode(28));
        assertEquals(PH, getByCode(29));
        assertEquals(SM, getByCode(30));
        assertEquals(SJ, getByCode(31));
        assertEquals(SB, getByCode(32));
        assertEquals(SV, getByCode(33));
        assertEquals(TR, getByCode(34));
        assertEquals(TM, getByCode(35));
        assertEquals(TL, getByCode(36));
        assertEquals(VS, getByCode(37));
        assertEquals(VL, getByCode(38));
        assertEquals(VN, getByCode(39));
        assertEquals(B, getByCode(40));
        assertEquals(B1, getByCode(41));
        assertEquals(B2, getByCode(42));
        assertEquals(B3, getByCode(43));
        assertEquals(B4, getByCode(44));
        assertEquals(B5, getByCode(45));
        assertEquals(B6, getByCode(46));
        assertEquals(CL, getByCode(51));
        assertEquals(GR, getByCode(52));
    }

    @Test
    public void getName_success() {
        assertEquals("Bacau", BC.getName());
    }

    @Test
    public void getCode_success() {
        assertEquals(4, BC.getCode());
    }
}
