package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import model.Tartaruga;

public class TartarugaControle {
  private ArrayList<Tartaruga> tartarugas;

  // controle de verificação de tanque
  public TartarugaControle() {
    this.tartarugas = new ArrayList<>();
    // Carrega tartarugas do arquivo
    carregarArquivo("data/Tartaruga.txt");
  }

  public void inserirTartaruga(Tartaruga tartaruga) {
    tartarugas.add(tartaruga);
    System.out.println("Tartaruga inserida com sucesso.");
    escreverArquivo("data/Tartaruga.txt");
  }

  public void removerTartaruga(int id) {
    boolean removido = false;
    for (Tartaruga tartaruga : tartarugas) {
      if (tartaruga.getIdAnimal() == id) {
        tartarugas.remove(tartaruga);
        System.out.println("Tartaruga removida com sucesso.");
        removido = true;
        escreverArquivo("data/Tartaruga.txt");
        break;
      }
    }
    if (!removido) {
      System.out.println("Tartaruga não encontrada.");
    }
  }

  public Tartaruga buscarTartaruga(int id) {
    for (Tartaruga tartaruga : tartarugas) {
      if (tartaruga.getIdAnimal() == id) {
        return tartaruga;
      }
    }
    System.out.println("Tartaruga não encontrada.");
    return null;
  }

  public ArrayList<Tartaruga> listarTartarugas() {
    return tartarugas;
  }

  public int obterProximoId() {
    int maiorId = 0;
    for (Tartaruga tartaruga : tartarugas) {
      if (tartaruga.getIdAnimal() > maiorId) {
        maiorId = tartaruga.getIdAnimal();
      }
    }
    return maiorId + 1; // Retorna o próximo ID disponível
  }

  // editar a tartaruga passando o id
  public void editarTartaruga(int id, Tartaruga tartarugaEditada) {
    Tartaruga tartaruga = buscarTartaruga(id);
    if (tartaruga != null) {
      tartaruga.setEspecie(tartarugaEditada.getEspecie());
      tartaruga.setTamanho(tartarugaEditada.getTamanho());
      tartaruga.setDieta(tartarugaEditada.getDieta());
      tartaruga.setTemperaturaAgua(tartarugaEditada.getTemperaturaAgua());
      tartaruga.setAguaSalgada(tartarugaEditada.getAguaSalgada());
      tartaruga.setCascoDuro(tartarugaEditada.getCascoDuro());
      System.out.println("Tartaruga editada com sucesso.");

      // Chame o método escreverArquivo() após a edição dos dados
      escreverArquivo("data/Tartaruga.txt");
    } else {
      System.out.println("Tartaruga não encontrada.");
    }
  }

  private void carregarArquivo(String nomeArquivo) {
    File file = new File(nomeArquivo);
    if (!file.exists()) {
      // Se o arquivo não existir, cria-o
      try {
        file.createNewFile();
      } catch (IOException e) {
        System.err.println("Erro ao criar o arquivo: " + e.getMessage());
      }
    } else {
      // Se o arquivo existir, carrega os dados
      try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNextLine()) {
          String linha = scanner.nextLine();
          if (!linha.isEmpty()) { // Verifica se a linha não está vazia
            String[] partes = linha.split(",");
            int id = Integer.parseInt(partes[0]);
            String especie = partes[1];
            double tamanho = Double.parseDouble(partes[2]);
            String dieta = partes[3];
            double temperaturaAgua = Double.parseDouble(partes[4]);
            boolean aguaSalgada = Boolean.parseBoolean(partes[5]);
            boolean cascoDuro = Boolean.parseBoolean(partes[6]);
            int idTanque = Integer.parseInt(partes[7]);

            Tartaruga tartaruga = new Tartaruga(id, especie, tamanho, dieta, temperaturaAgua, aguaSalgada, cascoDuro,
                idTanque);
            tartarugas.add(tartaruga);
          }
        }
        System.out.println("Tartarugas carregadas com sucesso do arquivo " + nomeArquivo);
      } catch (FileNotFoundException e) {
        System.err.println("Arquivo não encontrado: " + e.getMessage());
      }

    }
  }

  private void escreverArquivo(String nomeArquivo) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
      for (Tartaruga tartaruga : tartarugas) {
        writer.println(tartaruga.getIdAnimal() + "," + tartaruga.getEspecie() + "," + tartaruga.getTamanho() + ","
            + tartaruga.getDieta() + "," + tartaruga.getTemperaturaAgua() + "," + tartaruga.getAguaSalgada() + ","
            + tartaruga.getCascoDuro() + "," + tartaruga.getIdTanque());
      }
      System.out.println("Tartarugas salvas com sucesso no arquivo " + nomeArquivo);
    } catch (IOException e) {
      System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
  }
}
