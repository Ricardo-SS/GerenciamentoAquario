package view;

import java.util.Scanner;

public class AquarioView {
  Scanner scanner = new Scanner(System.in);
  LocalView localView = new LocalView(); // Instancia o objeto LocalView
  TanqueView tanqueView = new TanqueView();
  GerenteView gerenteView = new GerenteView();
  VeterinarioView veterinarioView = new VeterinarioView();
  FuncionarioView funcionarioView = new FuncionarioView();

  public void exibirMenuPrincipal() {
    int opcao;
    do {
      System.out.println("--------------------");
      System.out.println("\nSelecione uma opção:");
      System.out.println("[1] - Gerenciar Animais");
      System.out.println("[2] - Gerenciar Funcionários");
      System.out.println("[3] - Gerenciar Locais");
      System.out.println("[4] - Gerenciar Tanques");
      System.out.println("[0] - Sair");
      System.out.println("--------------------");
      System.out.print("Opção: ");
      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          System.out.println("Opção selecionada - [Gerenciar Animais]");
          menu2(scanner);
          break;
        case 2:
        System.out.println("Opção selecionada - [Gerenciar Funcionários]");
          funcionarioView.exibirMenuFuncionario();
          break;
        case 3:
          System.out.println("Opção selecionada - [Gerenciar Locais]");
          localView.exibirMenuLocal(); // Chama o método exibirMenu() da instância de LocalView
          break;
        case 4:
          // Código para gerenciar locais
          System.out.println("Opção selecionada - [Gerenciar Tanques]");
          tanqueView.exibirMenuTanques(); // Chama o método exibirMenu() da instância de TanquesView
          break;
        case 0:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  private void menu2(Scanner scanner) {
    TartarugaView tartarugaView = new TartarugaView(); // Instancia o objeto TartarugaView
    ArraiaView arraiaView = new ArraiaView();
    PeixeView peixeView = new PeixeView();
    int tipoAnimal;

    do {
      System.out.println("\nSelecione o tipo de animal:");
      System.out.println("[1] - Peixe");
      System.out.println("[2] - Tartaruga");
      System.out.println("[3] - Arraia");
      System.out.println("[0] - Voltar ao inicio");
      System.out.print("Opção: ");
      tipoAnimal = scanner.nextInt();

      switch (tipoAnimal) {
        case 1:
          System.out.println("Opção selecionada - [Peixe]");
          peixeView.exibirMenu();
          break;
        case 2:
          System.out.println("Opção selecionada - [Tartaruga]");
          tartarugaView.exibirMenu(); // Chama o método exibirMenu() da instância de TartarugaView
          break;
        case 3:
          System.out.println("Opção selecionada - [Arraia]");
          arraiaView.exibirMenu();
          break;
        case 0:
          System.out.println("Voltando ao início...");
          exibirMenuPrincipal();
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
    } while (tipoAnimal != 0);

    // scanner.close();
  }

}
