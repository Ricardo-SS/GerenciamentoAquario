import java.io.*;
import java.util.Scanner;

public class Tartaruga extends Animais {
  private boolean cascoDuro;

  // construtor
  public Tartaruga(int idAnimal, String nome, String especie, double tamanho, double peso, int idade, String dieta,
      double temperaturaAgua, boolean aguaSalgada, boolean cascoDuro) {
    super(idAnimal, nome, especie, tamanho, peso, idade, dieta, temperaturaAgua, aguaSalgada);
    this.cascoDuro = cascoDuro;
  }

  // metodo para obter o tipo de casco
  public boolean obterCascoDuro() {
    return cascoDuro;
  }

  public boolean isCascoDuro() {
    return cascoDuro;
  }

  public void setCascoDuro(boolean cascoDuro) {
    this.cascoDuro = cascoDuro;
  }

  public int obterProximoId() {
    int maiorId = 0;
    File file = new File("data/tartaruga.txt");

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
      System.err.println("Arquivo tartaruga.txt não encontrado.");
    }

    return maiorId + 1;
  }

  // Métodos de CRUD
  @Override
  public void inserirAnimal() {
    int id = obterProximoId(); // Obtém o próximo ID disponível

    Scanner scanner = new Scanner(System.in);
    System.out.println("Novo ID atribuído: " + id); // Exibe o novo ID atribuído
    System.out.print("Digite o nome: ");
    String nome = scanner.next();
    System.out.print("Digite a espécie: ");
    String especie = scanner.next();
    System.out.print("Digite o tamanho: ");
    double tamanho = scanner.nextDouble();
    System.out.print("Digite o peso: ");
    double peso = scanner.nextDouble();
    System.out.print("Digite a idade: ");
    int idade = scanner.nextInt();
    System.out.print("Digite a dieta: ");
    String dieta = scanner.next();
    System.out.print("Digite a temperatura da água: ");
    double temperaturaAgua = scanner.nextDouble();
    System.out.print("Digite se está em água salgada (true/false): ");
    boolean aguaSalgada = scanner.nextBoolean();
    System.out.print("Digite tem casco duro (true/false): ");
    boolean cascoDuro = scanner.nextBoolean();

    File file = new File("data/tartaruga.txt");
    try {
      if (!file.exists()) {
        file.createNewFile();
      }

      try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
        writer.write(id + "," + nome + "," + especie + "," + tamanho + "," + peso + "," + idade + "," + dieta + ","
            + temperaturaAgua + "," + aguaSalgada + "," + cascoDuro);
        writer.newLine();
        System.out.println("Tartaruga adicionado com sucesso.");
      }
    } catch (IOException e) {
      System.err.println("Erro ao adicionar Tartaruga: " + e.getMessage());
    }
  }

  // metodo remover
  @Override
  public void removerAnimal(int idAnimal) {
    try {
      File inputFile = new File("data/tartaruga.txt");
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
      System.out.println("Tartaruga removido com sucesso.");
    } catch (IOException e) {
      System.err.println("Erro ao remover tartaruga: " + e.getMessage());
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
      File file = new File("data/tartaruga.txt");
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
          // Verifique o comprimento do array antes de acessar o índice 10
          boolean cascoDuro = data.length > 10 ? Boolean.parseBoolean(data[10]) : false;
          return new Tartaruga(id, nome, especie, tamanho, peso, idade, dieta, temperaturaAgua, aguaSalgada, cascoDuro);
        }
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.err.println("Arquivo não encontrado: " + e.getMessage());
    }
    return null;
  }

  @Override
  public void listarTodosAnimais() {
    try {
      File file = new File("data/tartaruga.txt");
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

  @Override
  public String toString() {
    return "Tartaruga{" +
        "\nid=" + getIdAnimal() +
        ", \nnome='" + getNome() + '\'' +
        ", \nespecie='" + getEspecie() + '\'' +
        ", \ntamanho=" + getTamanho() +
        ", \npeso=" + getPeso() +
        ", \nidade=" + getIdade() +
        ", \ndieta='" + getDieta() + '\'' +
        ", \ntemperaturaAgua=" + getTemperaturaAgua() +
        ", \naguaSalgada=" + isAguaSalgada() +
        ", \ncascoDuro=" + cascoDuro +
        '}';
  }
}