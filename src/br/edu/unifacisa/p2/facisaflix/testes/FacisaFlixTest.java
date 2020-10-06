package br.edu.unifacisa.p2.facisaflix.testes;

import java.util.List;
import br.edu.unifacisa.p2.facisaflix.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacisaFlixTest {
  private FacisaFlix facisaFlix;
  private Usuario joao;
  private Usuario maria;
  private Serie twinPeaks;
  private Serie friends;
  private Serie ahs;
  private Serie dark;
  
  @BeforeEach
  void setUp() throws Exception {
    // Cria o FacisaFlix
    facisaFlix = new FacisaFlix();
    
    // Cria e cadastra alguns usuários
    joao  = new Usuario("joao");
    maria = new Usuario("maria");
    
    facisaFlix.adicionaUsuario(joao);
    facisaFlix.adicionaUsuario(maria);
    
    // Cria as séries com suas temporadas e episódios
    twinPeaks = new Serie("Twin Peaks", 2017, Estilo.FICCAO, Classificacao.DEZESSEIS_ANOS);
    Temporada tpS01 = new Temporada(2017, 1);
    
    Episodio tpS01E01 = new Episodio(1, "Parte 1", 60);
    Episodio tpS01E02 = new Episodio(2, "Parte 2", 54);
    Episodio tpS01E03 = new Episodio(3, "Parte 3", 58);
        
    tpS01.adicionaEpisodio(tpS01E01);
    tpS01.adicionaEpisodio(tpS01E02);
    tpS01.adicionaEpisodio(tpS01E03);
    
    twinPeaks.adicionaTemporada(tpS01);
    
    friends = new Serie("Friends", 1994, Estilo.COMEDIA, Classificacao.LIVRE);
    
    Temporada frS01 = new Temporada(1994, 1);
    Episodio frS01E01 = new Episodio(1, "Aquele da Ultrasonografia no Final", 20);
    Episodio frS01E02 = new Episodio(2, "Aquele do Dedão", 20);
    Episodio frS01E03 = new Episodio(3, "Aquele com George Stephanopoulos", 20);
    Episodio frS01E04 = new Episodio(4, "Aquele com o Sabão em pó da Alemanha Oriental", 20);
    frS01.adicionaEpisodio(frS01E01);
    frS01.adicionaEpisodio(frS01E02);
    frS01.adicionaEpisodio(frS01E03);
    frS01.adicionaEpisodio(frS01E04);
    friends.adicionaTemporada(frS01);
    
    Temporada frS02 = new Temporada(1995, 2);
    Episodio frS02E01 = new Episodio(1, "Aquele com a Nova Namorada do Ross", 20);
    Episodio frS02E02 = new Episodio(2, "Aquele do Leite Materno", 20);
    frS02.adicionaEpisodio(frS02E01);
    frS02.adicionaEpisodio(frS02E02);
    friends.adicionaTemporada(frS02);
    
    ahs = new Serie("American Horror Story", 2011, Estilo.TERROR, Classificacao.DEZOITO_ANOS);
    Temporada ahsS01 = new Temporada(2011, 2);
    Episodio ahsS01E01 = new Episodio(1, "Piloto", 60);
    Episodio ahsS01E02 = new Episodio(2, "Invasão Domiciliar", 50);
    Episodio ahsS01E03 = new Episodio(3, "A Casa Dos Assassinatos", 48);
    Episodio ahsS01E04 = new Episodio(4, "Halloween Parte 1", 55);
    ahsS01.adicionaEpisodio(ahsS01E01);
    ahsS01.adicionaEpisodio(ahsS01E02);
    ahsS01.adicionaEpisodio(ahsS01E03);
    ahsS01.adicionaEpisodio(ahsS01E04);
    ahs.adicionaTemporada(ahsS01);
    
    dark = new Serie("Dark", 2017, Estilo.FICCAO, Classificacao.DEZESSEIS_ANOS);
    
    // Adicionar as séries no facisaflix
    facisaFlix.adicionaSerie(friends);
    facisaFlix.adicionaSerie(twinPeaks);
    facisaFlix.adicionaSerie(ahs);
    facisaFlix.adicionaSerie(dark);
    
    // Registra as visualizações
    facisaFlix.registraVisualizacao(joao, ahsS01E01, 4);
    facisaFlix.registraVisualizacao(joao, frS01E01, 3);
    facisaFlix.registraVisualizacao(joao, frS01E02, 5);
    
    facisaFlix.registraVisualizacao(maria, tpS01E01, 4);
    facisaFlix.registraVisualizacao(maria, tpS01E02, 5);
    facisaFlix.registraVisualizacao(maria, tpS01E03, 5);
    facisaFlix.registraVisualizacao(maria, ahsS01E01, 4);
    facisaFlix.registraVisualizacao(maria, ahsS01E02, 3);
  }

  @Test
  void testGetSeriesPorEstilo() {
    List<Serie> series = null;
    
    series = facisaFlix.getSeriesPorEstilo(Estilo.COMEDIA);
    assertTrue(series.contains(friends));
    
    series = facisaFlix.getSeriesPorEstilo(Estilo.FICCAO);
    assertTrue(series.contains(twinPeaks));
    assertTrue(series.contains(dark));
    
    series = facisaFlix.getSeriesPorEstilo(Estilo.TERROR);
    assertTrue(series.contains(ahs));
  }

  @Test
  void testGetSeriesPorClassificacao() {
    List<Serie> series = null;
    
    series = facisaFlix.getSeriesPorClassificacao(Classificacao.DEZOITO_ANOS);
    assertTrue(series.contains(dark));
    assertTrue(series.contains(ahs));
    assertTrue(series.contains(twinPeaks));
    assertTrue(series.contains(friends));
    
    series = facisaFlix.getSeriesPorClassificacao(Classificacao.LIVRE);
    assertTrue(series.contains(friends));

    series = facisaFlix.getSeriesPorClassificacao(Classificacao.QUATORZE_ANOS);
    assertTrue(series.contains(friends));
  
    series = facisaFlix.getSeriesPorClassificacao(Classificacao.DEZESSEIS_ANOS);
    assertTrue(series.contains(dark));
    assertTrue(series.contains(twinPeaks));
    assertTrue(series.contains(friends));
  }

  @Test
  void testGetSeriesQueViu() {
    List<Serie> series = facisaFlix.getSeriesQueViu(maria);
    assertTrue(series.contains(twinPeaks));
    assertTrue(series.contains(ahs));
  }

  @Test
  void testGetSeriesEmComum() {
    List<Serie> series = facisaFlix.getSeriesEmComum(maria, joao);
    assertTrue(series.contains(ahs));
  }

  @Test
  void testGetQuantidadeDeSeries() {
    assertEquals(4, facisaFlix.getQuantidadeDeSeries());
  }

  @Test
  void testGetQuantidadeTotalDeEpisodios() {
    assertEquals(13, facisaFlix.getQuantidadeTotalDeEpisodios());
  }

  @Test
  void testGetQuantidadeTotalDeMinutos() {
    assertEquals(505, facisaFlix.getQuantidadeTotalDeMinutos());
  }
}
