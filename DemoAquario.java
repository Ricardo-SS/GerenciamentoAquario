import java.util.Scanner;

public class DemoAquario {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int opcao;

    do {
      System.out.println("\nSelecione uma opção:");
      System.out.println("[1] - Gerenciar animais");
      System.out.println("[2] - Grenciar funcionarios");
      System.out.println("[0] - Sair");

      System.out.print("Opção: ");
      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          gerenciarAnimais(scanner); // em implatanção
          break;
        case 2:
          gerenciarFuncionarios(scanner);
          break;
        case 0:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
    } while (opcao != 0);

    scanner.close();
  }

  private static void gerenciarAnimais(Scanner scanner) {
    System.out.println("\nSelecione uma opção:");
    System.out.println("1 - Adicionar");
    System.out.println("2 - Remover");
    System.out.println("3 - Buscar");
    System.out.println("4 - Listar");
    System.out.print("Opção: ");
    int opcaoGerencial = scanner.nextInt();

    switch (opcaoGerencial) {
      case 1:
        System.out.println("Opção selecionada - [Adicionar]");
        adcionarAnimais(scanner);
        break;
      case 2:
        System.out.println("Opção selecionada - [Remover]");
        removerAnimal(scanner);
        break;
      case 3:
        System.out.println("Opção selecionada - [Buscar]");
        buscarAnimal(scanner);

        break;
      case 4:
        System.out.println("Opção selecionada - [Listar]");

        break;
      default:
        System.out.println("Opção inválida. Tente novamente.");
        break;
    }

  }

  // que que se repete varias vezes no codigo
  private static void menu2() {
    System.out.println("\nSelecione o tipo de animal:");
    System.out.println("1 - Peixe");
    System.out.println("2 - Tartaruga");
    System.out.println("3 - Arraia");
    System.out.println("0 - Voltar ao inicio");
    System.out.print("Opção: ");
  }

  private static void adcionarAnimais(Scanner scanner) {
    menu2(); // chama o menu de opcoes

    int tipoAnimal = scanner.nextInt();

    switch (tipoAnimal) {
      case 1:
        System.out.print("Tipo selecionado: [Peixe] \n");
        Peixe peixe = new Peixe(0, null, null, 0, 0, 0, null, 0, false, null, false); // Criando um novo objeto Peixe
        peixe.inserirAnimal(); // Chamando o método inserirAnimal() na instância de Peixe
        break;
      case 2:
        // Chamar método para adicionar tartaruga
        System.out.print("Tipo selecionado: [Tartaruga] \n");
        Tartaruga tartaruga = new Tartaruga(0, null, null, 0, 0, 0, null, 0, false, false);
        tartaruga.inserirAnimal(); // Chamando o método inserirAnimal() na instância de Tartaruga
        break;
      case 3:
        // Chamar método para adicionar arraia
        System.out.print("Tipo selecionado: [Arraia] \n");
        Arraia arraia = new Arraia(0, null, null, 0, 0, 0, null, 0, false, false);
        arraia.inserirAnimal(); // Chamando o método inserirAnimal() na instância de Arraia
        break;
      default:
        System.out.println("Opção inválida. Tente novamente.");
        break;
    }
  }

  private static void removerAnimal(Scanner scanner) {
    menu2();
    int tipoAnimal = scanner.nextInt();

    switch (tipoAnimal) {
      case 1:
        System.out.println("Tipo selecionado: [Peixe]");
        System.out.print("Digite o ID do peixe a ser removido: ");
        int idPeixe = scanner.nextInt();
        Peixe peixe = new Peixe(idPeixe, null, null, idPeixe, idPeixe, idPeixe, null, idPeixe, false, null, false);
        peixe.removerAnimal(idPeixe); // Chamando o método removerAnimal() na instância de Peixe
        break;
      case 2:

        System.out.println("Tipo selecionado: [Tartaruga]");
        System.out.print("Digite o ID do peixe a ser removido: ");
        int idTartaruga = scanner.nextInt();
        Tartaruga tartaruga = new Tartaruga(idTartaruga, null, null, idTartaruga, idTartaruga, idTartaruga, null,
            idTartaruga, false, false);
        tartaruga.removerAnimal(idTartaruga); // Chamar método removerAnimal() para remover tartaruga
        break;
      case 3:
        // Chamar método para remover arraia
        System.out.println("Tipo selecionado: [Tartaruga]");
        System.out.print("Digite o ID do peixe a ser removido: ");
        int idArraia = scanner.nextInt();
        Arraia arraia = new Arraia(tipoAnimal, null, null, idArraia, idArraia, idArraia, null, idArraia, false, false);
        arraia.removerAnimal(idArraia); // Chamar método removerAnimal() para remover
        break;
      default:
        System.out.println("Opção inválida. Tente novamente.");
        break;
    }
  }

  // metodo para buscar um animal pelo id
  private static void buscarAnimal(Scanner scanner) {
    
    menu2();
    int tipoAnimal = scanner.nextInt();

    System.out.print("Digite o ID do animal a ser buscado: ");
    int idAnimal = scanner.nextInt();
  
      Animais animalEncontrado = null;
  
      switch (tipoAnimal) {
          case 1:
              animalEncontrado = new Peixe(0, null, null, 0, 0, 0, null, 0, false, null, false).buscarAnimal(idAnimal);
              break;
          case 2:
              animalEncontrado = new Tartaruga(0, null, null, 0, 0, 0, null, 0, false, false).buscarAnimal(idAnimal);
              break;
          case 3:
              animalEncontrado = new Arraia(0, null, null, 0, 0, 0, null, 0, false, false).buscarAnimal(idAnimal);
              break;
          default:
              System.out.println("Opção inválida.");
              return;
      }
  
      if (animalEncontrado != null) {
          System.out.println("Animal encontrado:");
          System.out.println(animalEncontrado.toString());
      } else {
          System.out.println("Animal não encontrado.");
      }
  }

  //Metodo para listar anima
  private static void listarAnimal(Scanner scanner) {

  }

  private static void gerenciarFuncionarios(Scanner scanner) {
    System.out.println("\nSelecione o tipo de animal:");
    System.out.println("[1] - Gerente");
    System.out.println("[2] - Veterinario");
    System.out.println("[0] - Voltar ao inicio");
    System.out.print("Opção: ");
    int tipoFuncionario = scanner.nextInt();

    switch (tipoFuncionario) {
      case 1:
        // chama o metodo para o gerente
        System.out.print("Tipo selecionado: Gerente ");

        break;
      case 2:
        // implementar os dados do vetereinario
        System.out.print("Tipo selecionado: Funcionario ");

        break;
      case 0:
        // finaliza a opção
        break;
      default:
        System.out.println("Opção inválida. Tente novamente.");
        break;
    }
  }

  // private static void adicionarPeixe(Scanner scanner) {
  // // Implemente aqui a lógica para adicionar um peixe
  // System.out.println("Adicionar Peixe selecionado.");
  // }

  private static void adicionarFuncionario(Scanner scanner) {
    // Implementar a lógica para adicionar um funcionário
    System.out.println("Adicionar funcionário selecionado.");
  }

  private static void removerFuncionario(Scanner scanner) {
    // Implementar a lógica para remover um funcionário
    System.out.println("Remover funcionário selecionado.");
  }
}
