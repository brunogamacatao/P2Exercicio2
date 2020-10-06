package br.edu.unifacisa.p2.facisaflix;

public class Classificacao {
  private static final String[] NOMES = new String[] {
      "Livre", "10 Anos", "14 Anos", "16 Anos", "18 Anos"
  };
  
  public static final int LIVRE          = 0;
  public static final int DEZ_ANOS       = 1;
  public static final int QUATORZE_ANOS  = 2;
  public static final int DEZESSEIS_ANOS = 3;
  public static final int DEZOITO_ANOS   = 4;
  
  public static String toString(int classificacao) {
    return NOMES[classificacao];
  }
}
