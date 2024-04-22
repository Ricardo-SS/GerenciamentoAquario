package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import model.Local;

public class LocalControle {
    private ArrayList<Local> locais;

    public LocalControle() {
        this.locais = new ArrayList<>();
        // Carrega locais do arquivo
        carregarArquivo("data/Local.txt");
    }

    public void inserirLocal(Local local) {
        locais.add(local);
        System.out.println("Local cadastrado com sucesso.");
        escreverArquivo("data/Local.txt");
    }

    public void removerLocal(int id) {
        boolean removido = false;
        for (Local local : locais) {
            if (local.getId() == id) {
                locais.remove(local);
                System.out.println("Local removido com sucesso.");
                removido = true;
                escreverArquivo("data/Local.txt");
                break;
            }
        }
        if (!removido) {
            System.out.println("Local não encontrado.");
        }
    }

    public void editarLocal(int id, String novoSetor) {
      Local local = buscarLocal(id);
      if (local != null) {
          local.setSetor(novoSetor);
          System.out.println("Local editado com sucesso.");
          escreverArquivo("data/Local.txt");
      } else {
          System.out.println("Local não encontrado.");
      }
  }

    public Local buscarLocal(int id) {
        for (Local local : locais) {
            if (local.getId() == id) {
                return local;
            }
        }
        System.out.println("Local não encontrado.");
        return null;
    }

    public ArrayList<Local> listarLocal() {
        return locais;
    }

    public int obterProximoId() {
        int maiorId = 0;
        for (Local local : locais) {
            if (local.getId() > maiorId) {
                maiorId = local.getId();
            }
        }
        return maiorId + 1; // Retorna o próximo ID disponível
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
                        String setor = partes[1];

                        Local local = new Local(id, setor);
                        locais.add(local);
                    }
                }
                System.out.println("Locais carregados com sucesso do arquivo " + nomeArquivo);
            } catch (FileNotFoundException e) {
                System.err.println("Arquivo não encontrado: " + e.getMessage());
            }
        }
    }

    private void escreverArquivo(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Local local : locais) {
                writer.println(local.getId() + "," + local.getSetor());
            }
            System.out.println("Locais salvos com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
