package br.edu.unifacisa.p2.romanos.test;

import br.edu.unifacisa.p2.romanos.Romanos;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RomanosTest {

  @Test
  void testParaRomanosAte10() {
    assertEquals("I", Romanos.paraRomanos(1));
    assertEquals("II", Romanos.paraRomanos(2));
    assertEquals("IV", Romanos.paraRomanos(4));
    assertEquals("V", Romanos.paraRomanos(5));
    assertEquals("VIII", Romanos.paraRomanos(8));
    assertEquals("IX", Romanos.paraRomanos(9));
    assertEquals("X", Romanos.paraRomanos(10));
  }
  
  @Test
  void testParaRomanosAte100() {
    assertEquals("XII", Romanos.paraRomanos(12));
    assertEquals("XXIX", Romanos.paraRomanos(29));
    assertEquals("XXXVII", Romanos.paraRomanos(37));
    assertEquals("XLIX", Romanos.paraRomanos(49));
    assertEquals("L", Romanos.paraRomanos(50));
    assertEquals("LXXXVII", Romanos.paraRomanos(87));
    assertEquals("XCV", Romanos.paraRomanos(95));
  }

  @Test
  void testParaRomanosAte1000() {
    assertEquals("CXII", Romanos.paraRomanos(112));
    assertEquals("CCXXIX", Romanos.paraRomanos(229));
    assertEquals("DXXXVII", Romanos.paraRomanos(537));
    assertEquals("CMXLIX", Romanos.paraRomanos(949));
  }

  @Test
  void testParaRomanosAte3000() {
    assertEquals("MCXII", Romanos.paraRomanos(1112));
    assertEquals("MMCCXXIX", Romanos.paraRomanos(2229));
    assertEquals("MDXXXVII", Romanos.paraRomanos(1537));
    assertEquals("MCMXLIX", Romanos.paraRomanos(1949));
    assertEquals("MCMLXXXII", Romanos.paraRomanos(1982));
  }
  
  @Test
  void testParaDecimal() {
    assertEquals(1, Romanos.paraDecimal("I"));
    assertEquals(4, Romanos.paraDecimal("IV"));
    assertEquals(5, Romanos.paraDecimal("V"));
    assertEquals(9, Romanos.paraDecimal("IX"));
    assertEquals(10, Romanos.paraDecimal("X"));
    assertEquals(40, Romanos.paraDecimal("XL"));
    assertEquals(50, Romanos.paraDecimal("L"));
    assertEquals(90, Romanos.paraDecimal("XC"));
    assertEquals(100, Romanos.paraDecimal("C"));
    assertEquals(400, Romanos.paraDecimal("CD"));
    assertEquals(500, Romanos.paraDecimal("D"));
    assertEquals(900, Romanos.paraDecimal("CM"));
    assertEquals(1000, Romanos.paraDecimal("M"));
    assertEquals(1982, Romanos.paraDecimal("MCMLXXXII"));
  }
}
