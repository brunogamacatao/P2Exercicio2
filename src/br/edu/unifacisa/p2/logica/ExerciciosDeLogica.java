package br.edu.unifacisa.p2.logica;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class ExerciciosDeLogica {
  public static int somaArray(int[] numeros) {
    int total = 0;

    for (int n : numeros) {
      total += n;
    }

    return total;
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
    String[] novo = new String[nomes.length];

    for (int i = 0; i < nomes.length; i++) {
      novo[nomes.length - 1 - i] = nomes[i];
    }

    return novo;
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
    String resultado = nomes.get(0);

    for (int i = 1; i < nomes.size(); i++) {
      resultado += caractere + nomes.get(i);
    }

    return resultado;
  }

  public static String substitui(String mensagem, String localizar, String substituir) {
    return mensagem.replaceAll(localizar, substituir);
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
    // O CEP tem 9 caracteres
    // 012345678
    // 58100-000
    if (cep.length() != 9) {
      return false;
    }

    // Os 5 primeiros caracteres devem ser números
    for (int i = 0; i < 5; i++) {
      if (!ehNumero(cep.substring(i, i + 1))) {
        return false;
      }
    }

    // O 6º caractere deve ser um hífen
    char separador = cep.charAt(5);
    if (separador != '-') {
      return false;
    }

    // Os 3 últimos caracteres devem ser números
    for (int i = 6; i < 9; i++) {
      if (!ehNumero(cep.substring(i, i + 1))) {
        return false;
      }
    }

    return true;
  }

  public static boolean validaCPF(String cpf) {
    cpf = cpf.replaceAll("\\.", "");
    cpf = cpf.replaceAll("-", "");
    
    return isCPF(cpf);
  }

  public static boolean isCPF(String CPF) {
    // considera-se erro CPF's formados por uma sequencia de numeros iguais
    if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333")
        || CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666")
        || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11))
      return (false);

    char dig10, dig11;
    int sm, i, r, num, peso;

    // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
    try {
      // Calculo do 1o. Digito Verificador
      sm = 0;
      peso = 10;
      for (i = 0; i < 9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
        num = (int) (CPF.charAt(i) - 48);
        sm = sm + (num * peso);
        peso = peso - 1;
      }

      r = 11 - (sm % 11);
      if ((r == 10) || (r == 11))
        dig10 = '0';
      else
        dig10 = (char) (r + 48); // converte no respectivo caractere numerico

      // Calculo do 2o. Digito Verificador
      sm = 0;
      peso = 11;
      for (i = 0; i < 10; i++) {
        num = (int) (CPF.charAt(i) - 48);
        sm = sm + (num * peso);
        peso = peso - 1;
      }

      r = 11 - (sm % 11);
      if ((r == 10) || (r == 11))
        dig11 = '0';
      else
        dig11 = (char) (r + 48);

      // Verifica se os digitos calculados conferem com os digitos informados.
      if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
        return (true);
      else
        return (false);
    } catch (InputMismatchException erro) {
      return (false);
    }
  }

  public static long fatorial(int n) {
    if (n == 0) {
      return 1;
    }

    return n * fatorial(n - 1);
  }

  public static int fibonacci(int n) {
    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}
