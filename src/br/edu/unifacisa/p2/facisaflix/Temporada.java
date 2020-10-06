package br.edu.unifacisa.p2.facisaflix;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
  private int ano;
  private int numero;
  private List<Episodio> episodios;
  private Serie serie;
  
  public Temporada(int ano, int numero) {
    this.ano = ano;
    this.numero = numero;
    this.episodios = new ArrayList<>();
  }
  
  public void adicionaEpisodio(Episodio episodio) {
    episodio.setTemporada(this);
    episodios.add(episodio);
  }
  
  public List<Episodio> getEpisodios() {
    return episodios;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public Serie getSerie() {
    return serie;
  }

  public void setSerie(Serie serie) {
    this.serie = serie;
  }
  
  @Override
  public String toString() {
    return serie.getNome() + " - Temporada " + numero + " (" + ano + ")";
  }
}
