package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import model.Veterinario;

public class VeterinarioControle {
    private ArrayList<Veterinario> veterinarios;

    public VeterinarioControle(){
        this.veterinarios = new ArrayList<>();
         // Carrega veterinarios do arquivo
        carregarArquivo("data/Veterinario.txt");
    }

    public void inserirVeterinario(Veterinario veterinario) {
       veterinarios.add(veterinario);
        System.out.println("Veterinario inserida com sucesso.");
        escreverArquivo("data/Veterinario.txt");
      }

      public void removerVeterinario(int id) {
        boolean removido = false;
        for (Veterinario veterinario : veterinarios) {
          if (veterinario.getMatricula() == id) {
            veterinarios.remove(veterinario);
            System.out.println("Veterinario removida com sucesso.");
            removido = true;
            escreverArquivo("data/Veterinario.txt");
            break;
          }
        }
        if (!removido) {
          System.out.println("Veterinario não encontrada.");
        }

      }

      public ArrayList<Veterinario> listarVeterinarios() {
        return veterinarios;
      }

      public int obterProximoId() {
        int maiorId = 0;
        for (Veterinario veterinario : veterinarios) {
          if (veterinario.getId() > maiorId) {
            maiorId = veterinario.getId();
          }
        }
        return maiorId + 1; // Retorna o próximo ID disponível
      }

      public void editarVeterinario(int id, Veterinario veterinarioEditado) {
        Veterinario veterinario = buscarVeterinario(id);
        if (veterinario != null) {
          veterinario.setNome(veterinarioEditado.getNome());
          veterinario.setMatricula(veterinarioEditado.getMatricula());
            System.out.println("veterinario editada com sucesso.");
            // Chame o método escreverArquivo() após a edição dos dados
            escreverArquivo("data/Tartaruga.txt");
        } else {
            System.out.println("veterinario não encontrada.");
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
                double comissaoAnimal = Double.parseDouble(partes[3]);
                int quantAnimais = Integer.parseInt(partes[4]);
                
    
                Veterinario veterinario = new Veterinario(id, nome, matricula, comissaoAnimal, quantAnimais);
                veterinarios.add(veterinario);
              }
            }
            System.out.println("veterinarios carregadas com sucesso do arquivo " + nomeArquivo);
          } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
          }
    
        }
      }

      private void escreverArquivo(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
          for (Veterinario veterinario : veterinarios) {
            writer.println(veterinario.getMatricula() + "," + veterinario.getNome() + "," + veterinario.getComissaoAnimal() + ","
                + veterinario.getQuantAnimais());
          }
          System.out.println("Veterinários salvos com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
          System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
      }

      public Veterinario buscarVeterinario(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarVeterinario'");
      }
    
}
