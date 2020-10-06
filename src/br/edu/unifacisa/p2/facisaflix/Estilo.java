package br.edu.unifacisa.p2.facisaflix;

public class Estilo {
  private static final String[] NOMES = new String[] {
      "Ação", "Aventura", "Drama", "Comédia", "Ficção",
      "Fantasia", "Policial", "Reality Show", "Documentário",
      "Terror"
  };
  
  public static final int ACAO         = 0;
  public static final int AVENTURA     = 1;
  public static final int DRAMA        = 2;
  public static final int COMEDIA      = 3;
  public static final int FICCAO       = 4;
  public static final int FANTASIA     = 5;
  public static final int POLICIAL     = 6;
  public static final int REALITY_SHOW = 7;
  public static final int DOCUMENTARIO = 8;
  public static final int TERROR       = 9;
  
  public static String toString(int estilo) {
    return NOMES[estilo];
  }
}
