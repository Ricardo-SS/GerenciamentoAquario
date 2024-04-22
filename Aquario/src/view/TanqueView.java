package view;

import java.util.Scanner;
import controller.TanqueControle;
import model.Tanque;

public class TanqueView {
    private TanqueControle tanqueControle = new TanqueControle();

    Scanner scanner = new Scanner(System.in);

    public void exibirMenuTanques() {
        int opcao;
        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("[1] - Adicionar Tanque");
            System.out.println("[2] - Remover Tanque");
            System.out.println("[3] - Listar Tanques");
            System.out.println("[4] - Buscar Tanque");
            System.out.println("[5] - Editar Tanque");
            System.out.println("[0] - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarTanque();
                    break;
                case 2:
                    removerTanque();
                    break;
                case 3:
                    listarTanque();
                    break;
                case 4:
                    buscarTanque();
                    break;
                case 5:
                    editarTanque();
                    break;  
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarTanque() {
        int id = tanqueControle.obterProximoId();
        System.out.print("\nNovo ID atribuido: " + id);
        System.out.print("\nDigite o volume do tanque: ");
        double volume = scanner.nextDouble();
        System.out.print("Digite a temperatura da água: ");
        double temperaturaAgua = scanner.nextDouble();
        System.out.print("Digite se é de água salgada (true/false): ");
        boolean aguaSalgada = scanner.nextBoolean();

        Tanque tanque = new Tanque(id, volume, temperaturaAgua, aguaSalgada);
        tanqueControle.inserirTanque(tanque);
    }

    private void removerTanque() {
        System.out.print("Digite o ID do Tanque a ser removido: ");
        int id = scanner.nextInt();
        tanqueControle.removerTanque(id);
    }

    private void listarTanque() {
        System.out.println("Locais cadastrados:");
        for (Tanque tanque : tanqueControle.listarTanque()) {
            System.out.println(tanque);
        }
    }

    private void buscarTanque() {
        System.out.print("Digite o ID do local a ser buscado: ");
        int id = scanner.nextInt();
        Tanque tanque = tanqueControle.buscarTanque(id);
        if (tanque != null) {
            System.out.println("Tanque encontrado: " + tanque);
        }
    }
    
    private void editarTanque() {
      System.out.print("Digite o ID do Tanque a ser editado: ");
      int id = scanner.nextInt();
      System.out.print("Digite o novo volume: ");
      double novoVolume = scanner.nextDouble();
      System.out.print("Digite a nova temperatura da agua: ");
      double novoTemperatura = scanner.nextDouble();
      System.out.print("Digite se é de agua salgada: ");
      boolean novaAgua = scanner.nextBoolean();
      
      tanqueControle.editarTanque(id, novoVolume, novoTemperatura, novaAgua);
  }
}
