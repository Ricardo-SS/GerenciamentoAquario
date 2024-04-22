package view;

import controller.FuncionariosController;
import java.util.Scanner;

public class FuncionarioView {
    @SuppressWarnings("unused")
    private FuncionariosController funcionariosController = new FuncionariosController();
    GerenteView gerenteView = new GerenteView();
    VeterinarioView veterinarioView = new VeterinarioView();
    Scanner scanner = new Scanner(System.in);


    public void exibirMenuFuncionario() {
        int opcao;
        do {
          System.out.println("\nSelecione uma opção:");
          System.out.println("--------------------");
          System.out.println("[1] - Gerente");
          System.out.println("[2] - Veterinario");
          System.out.println("[0] - Voltar");
          System.out.print("Opcão: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                System.out.print("Opcão selecionada [Gerente] ");
                   gerenteView.exibirMenuGerente();
                    break;
                case 2:
                    veterinarioView.exibirMenuVeterinario();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
 
}
