package br.edu.unifacisa.p2.logica;

import java.util.ArrayList;
import java.util.List;

public class ExerciciosDeLogica {
  public static int somaArray(int[] numeros) {
    return 0;
  }
  
  public static int getMaior(int[] numeros) {
    int maiorAteAgora = numeros[0];

    for (int n : numeros) {
      if (n > maiorAteAgora) {
        maiorAteAgora = n;
      }
    }
    
    return maiorAteAgora;
  }
  
  public static int getMenor(int[] numeros) {
    int menorAteAgora = numeros[0];
    
    for (int n : numeros) {
      if (n < menorAteAgora) {
        menorAteAgora = n;
      }
    }
    
    return menorAteAgora;
  }
  
  public static double getMedia(int[] numeros) {
    double soma = 0.0;
    
    for (int n : numeros) {
      soma += n;
    }
    
    double media = soma / numeros.length;
    
    return media;
  }
  
  public static String[] inverteArray(String[] nomes) {
    return null;
  }
  
  public static List<String> inverteLista(List<String> nomes) {
    List<String> aoContrario = new ArrayList<>();
    
    for (int i = nomes.size() - 1; i >= 0; i--) {
      String nome = nomes.get(i);
      aoContrario.add(nome);
    }
    
    return aoContrario;
  }
  
  public static String junta(List<String> nomes, String caractere) {
    return null;
  }
  
  public static String substitui(String mensagem, String localizar, String substituir) {
    return null;
  }
  
  public static boolean ehNumero(String valor) {
    for (int i = 0; i < valor.length(); i++) {
      char caractere = valor.charAt(i);
      if (caractere < '0' || caractere > '9') {
        return false;
      }
    }
    
    return true;
  }
  
  public static boolean validaCEP(String cep) {
    return true;
  }
  
  public static boolean validaCPF(String cpf) {
    /*
     * Pesquise na internet.
     * Existem algoritmos prontos.
     * No site da receita federal existe a explicação de como os 
     * dígitos verificadores são calculados.
     */
    return false;
  }
  
  public static long fatorial(int n) {
    if (n == 0) {
      return 1;
    }
    
    return n * fatorial(n - 1);
  }
  
  public static int fibonacci(int n) {
    return 0;
  }
}
