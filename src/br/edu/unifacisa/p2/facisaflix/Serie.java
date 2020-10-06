package br.edu.unifacisa.p2.facisaflix;

import java.util.ArrayList;
import java.util.List;

public class Serie {
  private String nome;
  private int ano;
  private int estilo;
  private int classificacao;
  private List<Temporada> temporadas;
  
  public Serie(String nome, int ano, int estilo, int classificacao) {
    this.nome = nome;
    this.ano = ano;
    this.estilo = estilo;
    this.classificacao = classificacao;
    this.temporadas = new ArrayList<>();
  }
  
  public void adicionaTemporada(Temporada temporada) {
    temporada.setSerie(this);
    temporadas.add(temporada);
  }
  
  public List<Temporada> getTemporadas() {
    return temporadas;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public int getEstilo() {
    return estilo;
  }

  public void setEstilo(int estilo) {
    this.estilo = estilo;
  }

  public int getClassificacao() {
    return classificacao;
  }

  public void setClassificacao(int classificacao) {
    this.classificacao = classificacao;
  }
  
  @Override
  public String toString() {
    return nome + " (" + ano + ") - " + 
           Estilo.toString(estilo) + 
           " - Classificação: " + Classificacao.toString(classificacao);
  }
}
