package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import model.Peixe;

public class PeixeControle {
  private ArrayList<Peixe> peixes;

  public PeixeControle() {
    this.peixes = new ArrayList<>();
    // Carrega Peixes do arquivo
    carregarArquivo("data/Peixe.txt");
  }

  public void inserirPeixe(Peixe peixe) {
    peixes.add(peixe);
    System.out.println("Peixe inserida com sucesso.");
    escreverArquivo("data/Peixe.txt");
  }

  public void removerPeixe(int id) {
    boolean removido = false;
    for (Peixe peixe : peixes) {
      if (peixe.getIdAnimal() == id) {
        peixes.remove(peixe);
        System.out.println("Peixe removida com sucesso.");
        removido = true;
        escreverArquivo("data/Peixe.txt");
        break;
      }
    }
    if (!removido) {
      System.out.println("Peixe não encontrada.");
    }
  }

  public Peixe buscarPeixe(int id) {
    for (Peixe peixe : peixes) {
      if (peixe.getIdAnimal() == id) {
        return peixe;
      }
    }
    System.out.println("Peixe não encontrada.");
    return null;
  }

  public ArrayList<Peixe> listarPeixes() {
    return peixes;
  }

  public int obterProximoId() {
    int maiorId = 0;
    for (Peixe peixe : peixes) {
      if (peixe.getIdAnimal() > maiorId) {
        maiorId = peixe.getIdAnimal();
      }
    }
    return maiorId + 1; // Retorna o próximo ID disponível
  }

  public void editarPeixe(int id, Peixe peixeEditado) {
    Peixe peixe = buscarPeixe(id);
    if (peixe != null) {
      peixe.setEspecie(peixeEditado.getEspecie());
      peixe.setTamanho(peixeEditado.getTamanho());
      peixe.setDieta(peixeEditado.getDieta());
      peixe.setTemperaturaAgua(peixeEditado.getTemperaturaAgua());
      peixe.setAguaSalgada(peixeEditado.getAguaSalgada());
      peixe.setCorDaEscama(peixeEditado.getCorDaEscama());
      System.out.println("Peixe editado com sucesso.");

      // Chame o método escreverArquivo() após a edição dos dados
      escreverArquivo("data/Peixe.txt");
    } else {
      System.out.println("Peixe não encontrado.");
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
            String corDaEscama = (partes[6]);

            Peixe peixe = new Peixe(id, especie, tamanho, dieta, temperaturaAgua, aguaSalgada, corDaEscama);
            peixes.add(peixe);
          }
        }
        System.out.println("Peixes carregadas com sucesso do arquivo " + nomeArquivo);
      } catch (FileNotFoundException e) {
        System.err.println("Arquivo não encontrado: " + e.getMessage());
      }

    }
  }

  private void escreverArquivo(String nomeArquivo) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
      for (Peixe peixe : peixes) {
        writer.println(peixe.getIdAnimal() + "," + peixe.getEspecie() + "," + peixe.getTamanho() + ","
            + peixe.getDieta() + "," + peixe.getTemperaturaAgua() + "," + peixe.getAguaSalgada() + ","
            + peixe.getCorDaEscama());
      }
      System.out.println("Arraias salvas com sucesso no arquivo " + nomeArquivo);
    } catch (IOException e) {
      System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
  }

}
