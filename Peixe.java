import java.io.*;
import java.util.Scanner;

public class Peixe extends Animais {
    private String corEscamas;
    private boolean espinhoVenenoso;

    // Construtor
    public Peixe(int idAnimal, String nome, String especie, double tamanho, double peso, int idade, String dieta,
            double temperaturaAgua, boolean aguaSalgada, String corEscamas, boolean espinhoVenenoso) {
        super(idAnimal, nome, especie, tamanho, peso, idade, dieta, temperaturaAgua, aguaSalgada);
        this.corEscamas = corEscamas;
        this.espinhoVenenoso = espinhoVenenoso;
    }

    // Getters e Setters
    public String getCorEscamas() {
        return corEscamas;
    }

    public void setCorEscamas(String corEscamas) {
        this.corEscamas = corEscamas;
    }

    public boolean isEspinhoVenenoso() {
        return espinhoVenenoso;
    }

    public void setEspinhoVenenoso(boolean espinhoVenenoso) {
        this.espinhoVenenoso = espinhoVenenoso;
    }

    public int obterProximoId() {
        int maiorId = 0;
        File file = new File("data/peixes.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0]);
                if (id > maiorId) {
                    maiorId = id;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo peixes.txt não encontrado.");
        }

        return maiorId + 1;
    }

    // Métodos de CRUD
    @Override
    public void inserirAnimal() {
        int id = obterProximoId(); // Obtém o próximo ID disponível

        Scanner scanner = new Scanner(System.in);
        System.out.println("Novo ID atribuído: " + id); // Exibe o novo ID atribuído
        System.out.print("Digite o nome do peixe: ");
        String nome = scanner.next();
        System.out.print("Digite a espécie do peixe: ");
        String especie = scanner.next();
        System.out.print("Digite o tamanho do peixe: ");
        double tamanho = scanner.nextDouble();
        System.out.print("Digite o peso do peixe: ");
        double peso = scanner.nextDouble();
        System.out.print("Digite a idade do peixe: ");
        int idade = scanner.nextInt();
        System.out.print("Digite a dieta do peixe: ");
        String dieta = scanner.next();
        System.out.print("Digite a temperatura da água do peixe: ");
        double temperaturaAgua = scanner.nextDouble();
        System.out.print("Digite se o peixe está em água salgada (true/false): ");
        boolean aguaSalgada = scanner.nextBoolean();
        System.out.print("Digite a cor das escamas do peixe: ");
        String corEscamas = scanner.next();
        System.out.print("Digite se o peixe tem espinho venenoso (true/false): ");
        boolean espinhoVenenoso = scanner.nextBoolean();

        File file = new File("data/peixes.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(
                        id + "," + nome + "," + especie + "," + tamanho + "," + peso + "," + idade + "," + dieta + ","
                                + temperaturaAgua + "," + aguaSalgada + "," + corEscamas + "," + espinhoVenenoso);
                writer.newLine();
                System.out.println("Peixe adicionado com sucesso.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao adicionar peixe: " + e.getMessage());
        }
    }

    @Override
    public void removerAnimal(int idAnimal) {
        try {
            File inputFile = new File("data/peixes.txt");
            File tempFile = new File("data/temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = String.valueOf(idAnimal);
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");
                if (!data[0].equals(lineToRemove)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();

            // Substituindo o arquivo original pelo arquivo temporário
            boolean successful = tempFile.renameTo(inputFile);
            if (!successful) {
                throw new IOException("Não foi possível renomear o arquivo temporário.");
            }
            System.out.println("Peixe removido com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao remover peixe: " + e.getMessage());
        }
    }

    @Override
    public void editarAnimal() {
        // Implementação para editar os dados de um peixe no aquário
        // Aqui você pode solicitar ao usuário os novos dados e modificar o arquivo
        // correspondente
    }

    @Override
    public Animais buscarAnimal(int idAnimal) {
        try {
            File file = new File("data/peixes.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                if (id == idAnimal) {
                    String nome = data[1];
                    String especie = data[2];
                    double tamanho = Double.parseDouble(data[3]);
                    double peso = Double.parseDouble(data[4]);
                    int idade = Integer.parseInt(data[5]);
                    String dieta = data[6];
                    double temperaturaAgua = Double.parseDouble(data[7]);
                    boolean aguaSalgada = Boolean.parseBoolean(data[8]);
                    String corEscamas = data[9];
                    boolean espinhoVenenoso = Boolean.parseBoolean(data[10]);
                    return new Peixe(id, nome, especie, tamanho, peso, idade, dieta, temperaturaAgua, aguaSalgada,
                            corEscamas,
                            espinhoVenenoso);
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void listarTodosAnimais() {
        try {
            File file = new File("data/peixes.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}
