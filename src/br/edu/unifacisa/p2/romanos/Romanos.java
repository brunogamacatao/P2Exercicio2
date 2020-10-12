package br.edu.unifacisa.p2.romanos;

public class Romanos {
  public static String paraRomanos(int decimal) {
    int milhar   = decimal / 1000;
    int centenas = decimal % 1000;
    
    String prefixo = repete("M", milhar);
    String sufixo = paraRomanosAte1000(centenas);
    
    return prefixo + sufixo;
  }
  
  public static String paraRomanosAte1000(int decimal) {
    int centenas = decimal / 100;
    int dezenas  = decimal % 100;
    
    String prefixo = "";
    
    if (centenas <= 3) {
      prefixo = repete("C", centenas);
    } else if (centenas == 4) {
      prefixo = "CD";
    } else if (centenas <= 8) {
      prefixo = "D" + repete("C", centenas - 5);
    } else if (centenas == 9) {
      prefixo = "CM";
    } else {
      prefixo = "M";
    }
    
    String sufixo = paraRomanosAte100(dezenas);
    
    return prefixo + sufixo;
  }
  
  public static String paraRomanosAte100(int decimal) {
    int dezenas  = decimal / 10;
    int unidades = decimal % 10;
    
    String prefixo = "";
    
    if (dezenas <= 3) {
      prefixo = repete("X", dezenas);
    } else if (dezenas == 4) {
      prefixo = "XL";
    } else if (dezenas <= 8) {
      prefixo = "L" + repete("X", dezenas - 5);
    } else if (dezenas == 9) {
      prefixo = "XC";
    } else {
      prefixo = "C";
    }
    
    String sufixo = paraRomanosAte10(unidades);
    
    return prefixo + sufixo;
  }
  
  public static String paraRomanosAte10(int decimal) {
    if (decimal <= 3) {
      return repete("I", decimal);
    } else if (decimal == 4) {
      return "IV";
    } else if (decimal <= 8) {
      return "V" + repete("I", decimal - 5);
    } else if (decimal == 9) {
      return "IX";
    } else {
      return "X";
    }
  }
  
  private static String repete(String s, int vezes) {
    String retorno = "";
    
    for (int i = 0; i < vezes; i++) {
      retorno += s;
    }
    
    return retorno;
  }
  
  public static int paraDecimal(String romanos) {
    int total = 0;
    
    for (int i = 0; i < romanos.length(); i++) {
      char c = romanos.charAt(i);
      char proximo = (i < romanos.length() - 1) ? romanos.charAt(i + 1) : ' ';
      
      if (c == 'I') {
        total += (proximo == 'V' || proximo == 'X') ? -1 : 1;
      } else if (c == 'V') {
        total += 5;
      } else if (c == 'X') {
        total += (proximo == 'L' || proximo == 'C') ? -10 : 10;
      } else if (c == 'L') {
        total += 50;
      } else if (c == 'C') {
        total += (proximo == 'D' || proximo == 'M') ? -100 : 100;
      } else if (c == 'D') {
        total += 500;
      } else if (c == 'M') {
        total += 1000;
      }
    }
    
    return total;
  }
}
