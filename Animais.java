


public abstract class Animais {
  private int idAnimal;
  private String nome;
  private String especie;
  private double tamanho;
  private double peso;
  private int idade;
  private String dieta;
  private double temperaturaAgua;
  private boolean aguaSalgada;

  // Construtor
  public Animais(int idAnimal, String nome, String especie, double tamanho, double peso, int idade, String dieta, double temperaturaAgua, boolean aguaSalgada) {
      this.idAnimal = idAnimal;
      this.nome = nome;
      this.especie = especie;
      this.tamanho = tamanho;
      this.peso = peso;
      this.idade = idade;
      this.dieta = dieta;
      this.temperaturaAgua = temperaturaAgua;
      this.aguaSalgada = aguaSalgada;
  }

  // Getters e Setters
  public int getIdAnimal() {
      return idAnimal;
  }

  public void setIdAnimal(int idAnimal) {
      this.idAnimal = idAnimal;
  }

  public String getNome() {
      return nome;
  }

  public void setNome(String nome) {
      this.nome = nome;
  }

  public String getEspecie() {
      return especie;
  }

  public void setEspecie(String especie) {
      this.especie = especie;
  }

  public double getTamanho() {
      return tamanho;
  }

  public void setTamanho(double tamanho) {
      this.tamanho = tamanho;
  }

  public double getPeso() {
      return peso;
  }

  public void setPeso(double peso) {
      this.peso = peso;
  }

  public int getIdade() {
      return idade;
  }

  public void setIdade(int idade) {
      this.idade = idade;
  }

  public String getDieta() {
      return dieta;
  }

  public void setDieta(String dieta) {
      this.dieta = dieta;
  }

  public double getTemperaturaAgua() {
      return temperaturaAgua;
  }

  public void setTemperaturaAgua(double temperaturaAgua) {
      this.temperaturaAgua = temperaturaAgua;
  }

  public boolean isAguaSalgada() {
      return aguaSalgada;
  }

  public void setAguaSalgada(boolean aguaSalgada) {
      this.aguaSalgada = aguaSalgada;
  }

  // Métodos abstratos que devem ser implementados nas subclasses
  public abstract void inserirAnimal();

  public abstract void removerAnimal(int idAnimal);

  public abstract void editarAnimal();

  public abstract Animais buscarAnimal(int idAnimal);

  public abstract void listarTodosAnimais();
}
