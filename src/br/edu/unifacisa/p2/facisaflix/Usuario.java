package br.edu.unifacisa.p2.facisaflix;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private String login;
  private List<Visualizacao> visualizacoes;
  
  public Usuario(String login) {
    this.login = login;
    this.visualizacoes = new ArrayList<>();
  }
  
  public void adicionaVisualizacao(Visualizacao visualizacao) {
    visualizacoes.add(visualizacao);
  }
  
  public List<Visualizacao> getVisualizacoes() {
    return visualizacoes;
  }
  
  public String getLogin() {
    return login;
  }
}
