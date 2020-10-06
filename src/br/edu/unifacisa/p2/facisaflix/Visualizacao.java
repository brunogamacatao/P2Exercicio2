package br.edu.unifacisa.p2.facisaflix;

public class Visualizacao {
  private Episodio episodio;
  private int nota;
  
  public Visualizacao(Episodio episodio, int nota) {
    this.episodio = episodio;
    this.nota = nota;
  }

  public Episodio getEpisodio() {
    return episodio;
  }

  public void setEpisodio(Episodio episodio) {
    this.episodio = episodio;
  }

  public int getNota() {
    return nota;
  }

  public void setNota(int nota) {
    this.nota = nota;
  }
}
