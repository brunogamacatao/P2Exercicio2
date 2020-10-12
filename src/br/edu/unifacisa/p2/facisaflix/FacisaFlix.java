package br.edu.unifacisa.p2.facisaflix;

import java.util.ArrayList;
import java.util.List;

public class FacisaFlix {
  private List<Serie> series;
  private List<Usuario> usuarios;
  
  public FacisaFlix() {
    series = new ArrayList<>();
    usuarios = new ArrayList<>();
  }
  
  public void adicionaSerie(Serie serie) {
    series.add(serie);
  }
  
  public void adicionaUsuario(Usuario usuario) {
    usuarios.add(usuario);
  }
  
  public void registraVisualizacao(Usuario usuario, Episodio episodio, int nota) {
    Visualizacao v = new Visualizacao(episodio, nota);
    usuario.adicionaVisualizacao(v);
  }
  
  public List<Serie> getTodasAsSeries() {
    return series;
  }
  
  public List<Serie> getSeriesPorEstilo(int estilo) {
    List<Serie> seriesPorEstilo = new ArrayList<>();
    
    for (Serie s : series) {
      if (s.getEstilo() == estilo) {
        seriesPorEstilo.add(s);
      }
    }
    
    return seriesPorEstilo;
  }
  
  public List<Serie> getSeriesPorClassificacao(int classificacao) {
    List<Serie> seriesPorClassificacao = new ArrayList<>();
    
    for (Serie s : series) {
      if (s.getClassificacao() <= classificacao) {
        seriesPorClassificacao.add(s);
      }
    }
    
    return seriesPorClassificacao;
  }
  
  public List<Serie> getSeriesQueViu(Usuario usuario) {
    List<Serie> seriesQueViu = new ArrayList<>();
    
    for (Visualizacao v : usuario.getVisualizacoes()) {
      Serie s = v.getEpisodio().getTemporada().getSerie();
      if (!seriesQueViu.contains(s)) {
        seriesQueViu.add(s);
      }
    }
    
    return seriesQueViu;
  }
  
  public List<Serie> getSeriesEmComum(Usuario u1, Usuario u2) {
    List<Serie> seriesEmComum = new ArrayList<>();
    
    // Para cada episódio que o usuário 1 viu
    for (Visualizacao v1 : u1.getVisualizacoes()) {
      // Pega a série
      Serie s1 = v1.getEpisodio().getTemporada().getSerie();
      // Para cada episódio que o usuário 2 viu
      for (Visualizacao v2 : u2.getVisualizacoes()) {
        // Pega a série
        Serie s2 = v2.getEpisodio().getTemporada().getSerie();
        
        // Se as duas séries forem iguais
        if (s1.equals(s2)) {
          // Verifica se ela ainda não foi adicionada à lista de séries em comum
          if (!seriesEmComum.contains(s1)) {
            // Adiciona
            seriesEmComum.add(s1);
          }
        }
      }
    }
    
    return seriesEmComum;
  }
  
  public int getQuantidadeDeSeries() {
    return series.size();
  }
  
  public int getQuantidadeTotalDeEpisodios() {
    int numEpisodios = 0;
    // para cada s�rie
    for (Serie s : series) {
      // percorrer cada temporada
      for (Temporada t : s.getTemporadas()) {
        numEpisodios += t.getEpisodios().size();
      }
    }
    
    return numEpisodios;
  }
  
  public int getQuantidadeTotalDeMinutos() {
    int total = 0;
    
    for (Serie s : series) {
      for (Temporada t : s.getTemporadas()) {
        for (Episodio e : t.getEpisodios()) {
          total += e.getDuracao();
        }
      }
    }
    
    return total;
  }
}
