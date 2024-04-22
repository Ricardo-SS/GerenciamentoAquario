package view;

import controller.GerenteControle;
import model.Gerente;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenteView {
  private GerenteControle gerenteControle = new GerenteControle();

    Scanner scanner = new Scanner(System.in);


    public void exibirMenuGerente() {
        int opcao;
        do {
          System.out.println("\nSelecione uma opção:");
          System.out.println("--------------------");
          System.out.println("[1] - Adicionar Gerente");
          System.out.println("[2] - Remover Gerente");
          System.out.println("[3] - Listar Gerente");
          System.out.println("[4] - Buscar Gerente");
          System.out.println("[5] - Editar Gerente");
          System.out.println("[0] - Voltar");
          System.out.println("--------------------");
          System.out.print("Opcão: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    inserirGerente();
                    break;
                case 2:
                    removerGerente();
                    break;
                case 3:
                    listarGerentes();
                    break;
                case 4:
                    buscarGerente();
                    break;
                case 5:
                    editarGerente();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void inserirGerente() {
        // Obter o próximo ID disponível
        int id = gerenteControle.obterProximoId();
        System.out.print("\nNovo ID atribuido: " + id);
        System.out.print("\nDigite o nome: ");
        String nome = scanner.next();
        System.out.print("Digite a matricula do Gerente: ");
        int matricula = scanner.nextInt();

        Gerente gerente = new Gerente(id, nome, matricula);
        gerenteControle.inserirGerente(gerente);
    }

    private void removerGerente() {
      System.out.print("Digite o ID do gerente a ser removido: ");
      int id = scanner.nextInt();
      gerenteControle.removerGerente(id);
      System.out.println("Gerente removido com sucesso.");
  }
  

    private void listarGerentes() {
        ArrayList<Gerente> gerentes = gerenteControle.listarGerentes();
        for (Gerente gerente : gerentes) {
            System.out.println(gerente);
        }
    }

    private void buscarGerente() {
        System.out.print("Digite o ID do gerente a ser buscado: ");
        int id = scanner.nextInt();
        Gerente gerente = gerenteControle.buscarGerente(id);
        if (gerente != null) {
            System.out.println(gerente);
        } else {
            System.out.println("Gerente não encontrado.");
        }
    }

    private void editarGerente() {
        System.out.print("Digite o ID do gerente a ser editada: ");
        int id = scanner.nextInt();
        Gerente gerenteExistente = gerenteControle.buscarGerente(id);
        if (gerenteExistente != null) {
          // Exibir os dados atuais da tartaruga
          System.out.println("Gerente encontrada:");
          System.out.println(gerenteExistente);
          System.out.println("Agora você pode editar os dados do gerente.");
    
          // Solicitar ao usuário os novos dados da tartaruga
          System.out.print("Digite o novo nome: ");
          String novoNome = scanner.next();
          System.out.print("Digite a nova matricula: ");
         int novaMatricula = scanner.nextInt();
        
    
          // Criar uma nova tartaruga com os dados atualizados
          Gerente gerenteEditado = new Gerente(id, novoNome, novaMatricula);
    
        
        // Chamar o método de edição no controle
          gerenteControle.editarGerente(id, gerenteEditado);
        } else {
          System.out.println("Gerente não encontrad.");
        }
      }
}
