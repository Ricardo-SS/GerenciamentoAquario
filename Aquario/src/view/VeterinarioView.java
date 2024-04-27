package view;

import controller.VeterinarioControle;
import model.Veterinario;
import java.util.ArrayList;
import java.util.Scanner;

public class VeterinarioView {
    private VeterinarioControle veterinarioControle = new VeterinarioControle();
    Scanner scanner = new Scanner(System.in);

    public void exibirMenuVeterinario() {
        int opcao;
        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("--------------------");
            System.out.println("[1] - Adicionar Veterinario");
            System.out.println("[2] - Remover Veterinario");
            System.out.println("[3] - Listar Veterinario");
            System.out.println("[4] - Buscar Veterinario");
            System.out.println("[5] - Editar Veterinario");
            System.out.println("[0] - Voltar");
            System.out.println("--------------------");
            System.out.print("Opcão: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    inserirVeterinario();
                    break;
                case 2:
                    removerVeterinario();
                    break;
                case 3:
                    listarVeterinarios();
                    break;
                case 4:
                    buscarVeterinario();
                    break;

                case 5:
                    editarVeterinario();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void inserirVeterinario() {
        // Obter o próximo ID disponível
        int id = veterinarioControle.obterProximoId();
        System.out.print("\nNovo ID atribuido: " + id);
        System.out.print("\nDigite a matrícula: ");
        int matricula = scanner.nextInt();
        System.out.print("\nDigite o nome: ");
        String nome = scanner.next();
        System.out.print("Digite o valor da comissão: ");
        double comissaoAnimal = scanner.nextDouble();
        System.out.print("Digite a quantidade de animais atendidos: ");
        int quantAnimais = scanner.nextInt();

        Veterinario veterinario = new Veterinario(id, matricula, nome, comissaoAnimal, quantAnimais);
        veterinarioControle.inserirVeterinario(veterinario);
    }

    private void removerVeterinario() {
        System.out.print("Digite o ID do Veterinário a ser removida: ");
        int id = scanner.nextInt();
        veterinarioControle.removerVeterinario(id);
        System.out.println("Veterinário removida com sucesso.");
    }

    private void listarVeterinarios() {
        ArrayList<Veterinario> veterinarios = veterinarioControle.listarVeterinarios();
        for (Veterinario veterinario : veterinarios) {
            System.out.println(veterinario);
        }
    }

    private void buscarVeterinario() {
        System.out.print("Digite o ID do veterinário a ser buscada: ");
        int id = scanner.nextInt();
        Veterinario veterinario = veterinarioControle.buscarVeterinario(id);
        if (veterinario != null) {
            System.out.println(veterinario);
        } else {
            System.out.println("Veterinario não encontrada.");
        }
    }

    private void editarVeterinario() {
        System.out.print("Digite o ID do veterinario a ser editada: ");
        int id = scanner.nextInt();
        Veterinario veterinarioExistente = veterinarioControle.buscarVeterinario(id);
        if (veterinarioExistente != null) {
            // Exibir os dados atuais da veterinario
            System.out.println("Veterinario encontrada:");
            System.out.println(veterinarioExistente);
            System.out.println("Agora você pode editar os dados da veterinário.");

            // Solicitar ao usuário os novos dados da veterinario
            System.out.print("Digite a nova matricula: ");
            int novaMatricula = scanner.nextInt();
            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.next();
            System.out.print("Digite o valor da comissão: ");
            Double novaComissaoAnimal = scanner.nextDouble();
            System.out.print("Digite a quantidade de atendimentos: ");
            int novaQuantDeAnimais = scanner.nextInt();

            // Cria uma nova veterinario com os dados atualizados
            Veterinario veterinarioEditado = new Veterinario(id, novaMatricula, novoNome, novaComissaoAnimal,
                    novaQuantDeAnimais);

            // Chamar o método de edição no controle
            veterinarioControle.editarVeterinario(id, veterinarioEditado);
        } else {
            System.out.println("veterinario não encontrado.");
        }
    }
}
