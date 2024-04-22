package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import model.Gerente;

public class GerenteControle {
  private ArrayList<Gerente> gerentes;

  public GerenteControle() {
    this.gerentes = new ArrayList<>();
    // Carrega gerentes do arquivo
    carregarArquivo("data/Gerente.txt");
  }

  public void inserirGerente(Gerente gerente) {
    gerentes.add(gerente);
    System.out.println("Gerente inserido com sucesso.");
    escreverArquivo("data/Gerente.txt");
  }

  public void removerGerente(int id) {
    boolean removido = false;
    for (Gerente gerente : gerentes) {
      if (gerente.getMatricula() == id) {
        gerentes.remove(gerente);
        System.out.println("Gerente removido com sucesso.");
        removido = true;
        escreverArquivo("data/Gerente.txt");
        break;
      }
    }
    if (!removido) {
      System.out.println("Gerente não encontrado.");
    }
  }

  public Gerente buscarGerente(int id) {
    for (Gerente gerente : gerentes) {
      if (gerente.getMatricula() == id) {
        return gerente;
      }
    }
    System.out.println("Gerente não encontrado.");
    return null;
  }

  public ArrayList<Gerente> listarGerentes() {
    return gerentes;
  }

  public int obterProximoId() {
    int maiorId = 0;
    for (Gerente gerente : gerentes) {
      if (gerente.getMatricula() > maiorId) {
        maiorId = gerente.getMatricula();
      }
    }
    return maiorId + 1; // Retorna o próximo ID disponível
  }

  // editar a Gerentes passando o id
public void editarGerente(int id, Gerente gerenteEditado) {
  Gerente tartaruga = buscarGerente(id);
  if (tartaruga != null) {
      tartaruga.setNome(gerenteEditado.getNome());
      tartaruga.setMatricula(gerenteEditado.getMatricula());
      System.out.println("Gerentes editada com sucesso.");
      // Chame o método escreverArquivo() após a edição dos dados
      escreverArquivo("data/Gerentes.txt");
  } else {
      System.out.println("Gerentes não encontrada.");
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
            String nome = partes[1];
            int matricula = Integer.parseInt(partes[2]);

            Gerente gerente = new Gerente(id, nome, matricula);
            gerentes.add(gerente);
          }
        }
        System.out.println("Gerentes carregados com sucesso do arquivo " + nomeArquivo);
      } catch (FileNotFoundException e) {
        System.err.println("Arquivo não encontrado: " + e.getMessage());
      }

    }
  }

  private void escreverArquivo(String nomeArquivo) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
      for (Gerente gerente : gerentes) {
        writer.println(gerente.getNome() + "," + gerente.getMatricula());
      }
      System.out.println("Gerentes salvos com sucesso no arquivo " + nomeArquivo);
    } catch (IOException e) {
      System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
  }
}
