package view;

import java.util.Scanner;
import controller.LocalControle;
import model.Local;

public class LocalView {
    private LocalControle controle = new LocalControle();
    
    Scanner scanner = new Scanner(System.in);

    public void exibirMenuLocal() {
        int opcao;
        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("[1] - Adicionar Local");
            System.out.println("[2] - Remover Local");
            System.out.println("[3] - Listar Locais");
            System.out.println("[4] - Buscar Local");
            System.out.println("[5] - Editar Local");
            System.out.println("[0] - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarLocal();
                    break;
                case 2:
                    removerLocal();
                    break;
                case 3:
                    listarLocais();
                    break;
                case 4:
                    buscarLocal();
                    break;
                case 5:
                    editarLocal();
                    break;  
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarLocal() {
        int id = controle.obterProximoId();
        System.out.print("\nNovo ID atribuido: " + id);
        System.out.print("\nDigite o setor do local: ");
        String setor = scanner.next();

        Local local = new Local(id, setor);
        controle.inserirLocal(local);
    }

    private void removerLocal() {
        System.out.print("Digite o ID do local a ser removido: ");
        int id = scanner.nextInt();
        controle.removerLocal(id);
    }

    private void listarLocais() {
        System.out.println("Locais cadastrados:");
        for (Local local : controle.listarLocal()) {
            System.out.println(local);
        }
    }

    private void buscarLocal() {
        System.out.print("Digite o ID do local a ser buscado: ");
        int id = scanner.nextInt();
        Local local = controle.buscarLocal(id);
        if (local != null) {
            System.out.println("Local encontrado: " + local);
        }
    }
    
    private void editarLocal() {
      System.out.print("Digite o ID do local a ser editado: ");
      int id = scanner.nextInt();
      System.out.print("Digite o novo setor: ");
      String novoSetor = scanner.next();
      controle.editarLocal(id, novoSetor);
  }
}
