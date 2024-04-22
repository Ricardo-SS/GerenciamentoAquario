package view;

import controller.ArraiaControle;
import model.Arraia;
import java.util.ArrayList;
import java.util.Scanner;

public class ArraiaView {

    private ArraiaControle arraiaControle = new ArraiaControle();

    Scanner scanner = new Scanner(System.in);

    public void exibirMenu(){
        int opcao;
        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("--------------------");
            System.out.println("[1] - Adicionar Arraia");
            System.out.println("[2] - Remover Arraia");
            System.out.println("[3] - Listar Arraia");
            System.out.println("[4] - Buscar Arraia");
            System.out.println("[5] - Editar Arraia");
            System.out.println("[0] - Voltar");
            System.out.println("--------------------");
            System.out.print("Opcão: ");
              opcao = scanner.nextInt();
  
              switch (opcao) {
                  case 1:
                      inserirArraia();
                      break;
                  case 2:
                      removerArraia();
                      break;
                  case 3:
                      listarArraias();
                      break;
                  case 4:
                      buscarArraia();
                      break;

                  case 5:
                      editarArraia();
                      break;
                    
                  case 0:
                      System.out.println("Saindo...");
                      break;
                  default:
                      System.out.println("Opção inválida. Tente novamente.");
              }
          } while (opcao != 0);
    }

    private void inserirArraia() {
        // Obter o próximo ID disponível
        int id = arraiaControle.obterProximoId();
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
        boolean espinhoVenenoso = scanner.nextBoolean();

        Arraia arraia = new Arraia(id, especie, tamanho, dieta, temperaturaAgua, aguaSalgada, espinhoVenenoso);
        arraiaControle.inserirArraia(arraia);
    }

    private void removerArraia() {
      System.out.print("Digite o ID da arraia a ser removida: ");
      int id = scanner.nextInt();
      arraiaControle.removerArraia(id);
      System.out.println("Arraia removida com sucesso.");
  }
  

    private void listarArraias() {
        ArrayList<Arraia> arraias = arraiaControle.listarArraias();
        for (Arraia arraia : arraias) {
            System.out.println(arraia);
        }
    }

    private void buscarArraia() {
        System.out.print("Digite o ID da arraia a ser buscada: ");
        int id = scanner.nextInt();
        Arraia arraia = arraiaControle.buscarArraia(id);
        if (arraia != null) {
            System.out.println(arraia);
        } else {
            System.out.println("Arraia não encontrada.");
        }
    }

    private void editarArraia() {
        System.out.print("Digite o ID da tartaruga a ser editada: ");
        int id = scanner.nextInt();
        Arraia arraiaExistente = arraiaControle.buscarArraia(id);
        if (arraiaExistente != null) {
          // Exibir os dados atuais da tartaruga
          System.out.println("Tartaruga encontrada:");
          System.out.println(arraiaExistente);
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
          boolean novaEspinhoVenenoso = scanner.nextBoolean();
    
          // Criar uma nova tartaruga com os dados atualizados
          Arraia arraiaEditada = new Arraia(id, novaEspecie, novoTamanho, novaDieta, novaTemperaturaAgua,
              novaAguaSalgada, novaEspinhoVenenoso);
    
          // Chamar o método de edição no controle
          arraiaControle.editarArraia(id, arraiaEditada);
        } else {
          System.out.println("Peixe não encontrado.");
        }
      }


    
}
