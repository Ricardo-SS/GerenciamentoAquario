package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import model.Arraia;

public class ArraiaControle {
    private ArrayList<Arraia> arraias;


public ArraiaControle() {
    this.arraias = new ArrayList<>();
    // Carrega arraias do arquivo
    carregarArquivo("data/Arraia.txt");
  }

  public void inserirArraia(Arraia arraia) {
    arraias.add(arraia);
    System.out.println("Arraia inserida com sucesso.");
    escreverArquivo("data/Arraia.txt");
  }

  public void removerArraia(int id) {
    boolean removido = false;
    for (Arraia arraia : arraias) {
      if (arraia.getIdAnimal() == id) {
        arraias.remove(arraia);
        System.out.println("Arraia removida com sucesso.");
        removido = true;
        escreverArquivo("data/Arraia.txt");
        break;
      }
    }
    if (!removido) {
      System.out.println("Arraia não encontrada.");
    }
  }

  public Arraia buscarArraia(int id) {
    for (Arraia arraia : arraias) {
      if (arraia.getIdAnimal() == id) {
        return arraia;
      }
    }
    System.out.println("Arraia não encontrada.");
    return null;
  }

  public ArrayList<Arraia> listarArraias() {
    return arraias;
  }

  public int obterProximoId() {
    int maiorId = 0;
    for (Arraia arraia : arraias) {
      if (arraia.getIdAnimal() > maiorId) {
        maiorId = arraia.getIdAnimal();
      }
    }
    return maiorId + 1; // Retorna o próximo ID disponível
  }


  public void editarArraia(int id, Arraia arraiaEditado) {
    Arraia arraia = buscarArraia(id);
    if (arraia != null) {
      arraia.setEspecie(arraiaEditado.getEspecie());
      arraia.setTamanho(arraiaEditado.getTamanho());
      arraia.setDieta(arraiaEditado.getDieta());
      arraia.setTemperaturaAgua(arraiaEditado.getTemperaturaAgua());
      arraia.setAguaSalgada(arraiaEditado.getAguaSalgada());
      arraia.setEspinhoVenenoso(arraiaEditado.getEspinhoVenenoso());
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
            boolean espinhoVenenoso = Boolean.parseBoolean(partes[6]);

            Arraia arraia = new Arraia(id, especie, tamanho, dieta, temperaturaAgua, aguaSalgada, espinhoVenenoso);
            arraias.add(arraia);
          }
        }
        System.out.println("Arraias carregadas com sucesso do arquivo " + nomeArquivo);
      } catch (FileNotFoundException e) {
        System.err.println("Arquivo não encontrado: " + e.getMessage());
      }

    }
  }

  private void escreverArquivo(String nomeArquivo) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
      for (Arraia arraia : arraias) {
        writer.println(arraia.getIdAnimal() + "," + arraia.getEspecie() + "," + arraia.getTamanho() + ","
            + arraia.getDieta() + "," + arraia.getTemperaturaAgua() + "," + arraia.getAguaSalgada() + ","
            + arraia.getEspinhoVenenoso());
      }
      System.out.println("Arraias salvas com sucesso no arquivo " + nomeArquivo);
    } catch (IOException e) {
      System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
  }


}
  




