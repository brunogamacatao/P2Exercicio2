package br.edu.unifacisa.p2.facisaflix;

public class Episodio {
  private int numero;
  private String nome;
  private int duracao;
  private Temporada temporada;
  
  public Episodio(int numero, String nome, int duracao) {
    this.numero = numero;
    this.nome = nome;
    this.duracao = duracao;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getDuracao() {
    return duracao;
  }

  public void setDuracao(int duracao) {
    this.duracao = duracao;
  }

  public Temporada getTemporada() {
    return temporada;
  }

  public void setTemporada(Temporada temporada) {
    this.temporada = temporada;
  }
  
  @Override
  public String toString() {
    return temporada.getSerie().getNome() + 
        " - S" + temporada.getNumero() + "E" + numero;
  }
}
