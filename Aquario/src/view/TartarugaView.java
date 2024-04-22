package view;

import controller.TanqueControle;
import controller.TartarugaControle;
import controller.VerificaTanqueControle;
import model.Tanque;
import model.Tartaruga;
import java.util.ArrayList;
import java.util.Scanner;

public class TartarugaView {
  private TartarugaControle tartarugaControle = new TartarugaControle();
  private TanqueControle tanqueControle = new TanqueControle(); // Instancia o controle de tanques


  Scanner scanner = new Scanner(System.in);

  public void exibirMenu() {
    int opcao;
    do {
      System.out.println("\nSelecione uma opção:");
      System.out.println("--------------------");
      System.out.println("[1] - Adicionar Tartaruga");
      System.out.println("[2] - Remover Tartaruga");
      System.out.println("[3] - Listar Tartaruga");
      System.out.println("[4] - Buscar Tartaruga");
      System.out.println("[5] - Editar Tartaruga");
      System.out.println("[0] - Voltar");
      System.out.println("--------------------");
      System.out.print("Opcão: ");
      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          inserirTartaruga();
          break;
        case 2:
          removerTartaruga();
          break;
        case 3:
          listarTartarugas();
          break;
        case 4:
          buscarTartaruga();
          break;
        case 5:
          editarTartaruga();
          break;
        case 0:
          System.out.println("Voltando...");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  // private void inserirTartaruga() {
  //   // Obter o próximo ID disponível
  //   int id = tartarugaControle.obterProximoId();
  //   System.out.print("\nNovo ID atribuido: " + id);
  //   System.out.print("\nDigite a espécie: ");
  //   String especie = scanner.next();
  //   System.out.print("Digite o tamanho: ");
  //   double tamanho = scanner.nextDouble();
  //   System.out.print("Digite a dieta: ");
  //   String dieta = scanner.next();
  //   System.out.print("Digite a temperatura da água: ");
  //   double temperaturaAgua = scanner.nextDouble();
  //   System.out.print("Digite se está em água salgada (true/false): ");
  //   boolean aguaSalgada = scanner.nextBoolean();
  //   System.out.print("Digite se tem casco duro (true/false): ");
  //   boolean cascoDuro = scanner.nextBoolean();

  //   Tartaruga tartaruga = new Tartaruga(id, especie, tamanho, dieta, temperaturaAgua, aguaSalgada, cascoDuro);
  //   tartarugaControle.inserirTartaruga(tartaruga);
  // }
  private void inserirTartaruga() {
    // Instancia o controle de verificação de tanque
    VerificaTanqueControle verificaTanqueControle = new VerificaTanqueControle();

    
    // Obter o próximo ID disponível para a tartaruga
    int idTartaruga = tartarugaControle.obterProximoId();
    System.out.print("\nNovo ID atribuido: " + idTartaruga);

    // Solicitar os dados adicionais da tartaruga
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
    boolean cascoDuro = scanner.nextBoolean();

    int idTanque;
    do {
        // Solicitar e armazenar o ID do tanque fornecido pelo usuário
        System.out.print("Digite o ID do tanque: ");
        idTanque = scanner.nextInt();
        
        // Verifica se o ID do tanque existe chamando o método verificarIdTanque() do controle de verificação de tanque
        if (!verificaTanqueControle.verificarIdTanque(idTanque)) {
            System.out.println("O tanque com o ID " + idTanque + " não existe.");
            // Exibe a lista de tanques disponíveis chamando o método listarTanque() do controle de tanque
            ArrayList<Tanque> tanques = tanqueControle.listarTanque(); // Chamada corrigida para listarTanque()
            System.out.println("Tanques disponíveis:");
            for (Tanque tanque : tanques) {
                System.out.println("ID: " + tanque.getId() + ", Volume: " + tanque.getVolume() + ", Temperatura da Água: " + tanque.getTemperaturaAgua() + ", Água Salgada: " + tanque.isAguaSalgada());
            }
        }
      } while (!verificaTanqueControle.verificarIdTanque(idTanque)); // Repete até que um ID de tanque válido seja fornecido
      
      System.out.println("Tanque selecionado; [" + idTanque + "]");

    // Criar a tartaruga com os dados fornecidos pelo usuário
    Tartaruga tartaruga = new Tartaruga(idTartaruga, especie, tamanho, dieta, temperaturaAgua, aguaSalgada, cascoDuro, idTanque);
    // Inserir a tartaruga usando o controle de tartarugas
    tartarugaControle.inserirTartaruga(tartaruga);
    System.out.println("Tanque selecionado" + tartaruga.getIdTanque());
}




  private void removerTartaruga() {
    System.out.print("Digite o ID da tartaruga a ser removida: ");
    int id = scanner.nextInt();
    tartarugaControle.removerTartaruga(id);
    System.out.println("Tartaruga removida com sucesso.");
  }

  private void listarTartarugas() {
    ArrayList<Tartaruga> tartarugas = tartarugaControle.listarTartarugas();
    for (Tartaruga tartaruga : tartarugas) {
      System.out.println(tartaruga);
    }
  }

  private void buscarTartaruga() {
    System.out.print("Digite o ID da tartaruga a ser buscada: ");
    int id = scanner.nextInt();
    Tartaruga tartaruga = tartarugaControle.buscarTartaruga(id);
    if (tartaruga != null) {
      System.out.println(tartaruga);
    } else {
      System.out.println("Tartaruga não encontrada.");
    }
  }

  private void editarTartaruga() {
    System.out.print("Digite o ID da tartaruga a ser editada: ");
    int id = scanner.nextInt();
    Tartaruga tartarugaExistente = tartarugaControle.buscarTartaruga(id);
    if (tartarugaExistente != null) {
      // Exibir os dados atuais da tartaruga
      System.out.println("Tartaruga encontrada:");
      System.out.println(tartarugaExistente);
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
      System.out.print("Digite se tem casco duro (true/false): ");
      boolean novoCascoDuro = scanner.nextBoolean();
      System.out.print("Digite o numero do tanque: ");
      int novoIdTanque = scanner.nextInt();

      // Criar uma nova tartaruga com os dados atualizados
      Tartaruga tartarugaEditada = new Tartaruga(id, novaEspecie, novoTamanho, novaDieta, novaTemperaturaAgua,
          novaAguaSalgada, novoCascoDuro, novoIdTanque);

      // Chamar o método de edição no controle
      tartarugaControle.editarTartaruga(id, tartarugaEditada);
    } else {
      System.out.println("Tartaruga não encontrada.");
    }
  }

}
