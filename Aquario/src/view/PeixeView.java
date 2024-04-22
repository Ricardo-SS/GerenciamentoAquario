package view;

import controller.PeixeControle;
import model.Peixe;
import java.util.ArrayList;
import java.util.Scanner;

public class PeixeView {

    private PeixeControle peixeControle = new PeixeControle();

    Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
          System.out.println("\nSelecione uma opção:");
          System.out.println("--------------------");
          System.out.println("[1] - Adicionar Peixe");
          System.out.println("[2] - Remover Peixe");
          System.out.println("[3] - Listar Peixe");
          System.out.println("[4] - Buscar Peixe");
          System.out.println("[5] - Editar Peixe");
          System.out.println("[0] - Voltar");
          System.out.println("--------------------");
          System.out.print("Opcão: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    inserirPeixe();
                    break;
                case 2:
                    removerPeixe();
                    break;
                case 3:
                    listarPeixes();
                    break;
                case 4:
                    buscarPeixe();
                    break;
                
                case 5:
                editarPeixe();
                break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void inserirPeixe() {
        // Obter o próximo ID disponível
        int id = peixeControle.obterProximoId();
        System.out.print("\nNovo ID atribuido: " + id);
        System.out.print("\nDigite a espécie: ");
        String especie = scanner.next();
        System.out.print("Digite o tamanho: ");
        double tamanho = scanner.nextDouble();
        System.out.print("Digite a dieta: ");
        String dieta = scanner.next();
        System.out.print("Digite a temperatura da água: ");
        double temperaturaAgua = scanner.nextDouble();
        System.out.print("Digite se está em água salgada (true/false): ");
        boolean aguaSalgada = scanner.nextBoolean();
        System.out.print("Digite se tem casco duro (true/false): ");
        String corDaEscama = scanner.next();

        Peixe peixe = new Peixe(id, especie, tamanho, dieta, temperaturaAgua, aguaSalgada, corDaEscama);
        peixeControle.inserirPeixe(peixe);
    }


    private void removerPeixe() {
        System.out.print("Digite o ID da peixe a ser removida: ");
        int id = scanner.nextInt();
        peixeControle.removerPeixe(id);
        System.out.println("Peixe removida com sucesso.");
    }

    private void listarPeixes() {
        ArrayList<Peixe> peixes = peixeControle.listarPeixes();
        for (Peixe peixe : peixes) {
            System.out.println(peixe);
        }
    }

    private void buscarPeixe() {
        System.out.print("Digite o ID da peixe a ser buscada: ");
        int id = scanner.nextInt();
        Peixe peixe = peixeControle.buscarPeixe(id);
        if (peixe != null) {
            System.out.println(peixe);
        } else {
            System.out.println("Peixe não encontrado.");
        }
    }

    private void editarPeixe() {
        System.out.print("Digite o ID da tartaruga a ser editada: ");
        int id = scanner.nextInt();
        Peixe peixeExistente = peixeControle.buscarPeixe(id);
        if (peixeExistente != null) {
          // Exibir os dados atuais da tartaruga
          System.out.println("Tartaruga encontrada:");
          System.out.println(peixeExistente);
          System.out.println("Agora você pode editar os dados da tartaruga.");
    
          // Solicitar ao usuário os novos dados da tartaruga
          System.out.print("Digite a nova espécie: ");
          String novaEspecie = scanner.next();
          System.out.print("Digite o novo tamanho: ");
          double novoTamanho = scanner.nextDouble();
          System.out.print("Digite a nova dieta: ");
          String novaDieta = scanner.next();
          System.out.print("Digite a nova temperatura da água: ");
          double novaTemperaturaAgua = scanner.nextDouble();
          System.out.print("Digite se está em água salgada (true/false): ");
          boolean novaAguaSalgada = scanner.nextBoolean();
          System.out.print("Qual a cor da Escama: (true/false): ");
          String novaCorDaEscama = scanner.next();
    
          // Criar uma nova tartaruga com os dados atualizados
          Peixe peixeEditado = new Peixe(id, novaEspecie, novoTamanho, novaDieta, novaTemperaturaAgua,
              novaAguaSalgada, novaCorDaEscama);
    
          // Chamar o método de edição no controle
          peixeControle.editarPeixe(id, peixeEditado);
        } else {
          System.out.println("Peixe não encontrado.");
        }
      }
    
}
