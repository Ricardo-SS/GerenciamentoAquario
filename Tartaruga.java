public class Tartaruga extends Animais {
  private boolean cascoDuro;

  // inicializando
  public Tartaruga() {
	  super();
	  this.cascoDuro = true;
	}

  // Construtor
  public Tartaruga(int idAnimal, String nome, String especie, double tamanho, double peso, int idade, 
  String dieta, double temperaturaDaAgua, boolean aguaSalgada, boolean cascoDuro) {
    
    // pegado os atributos da classe principal
    super(idAnimal, nome, especie, tamanho, peso, idade, 
    dieta, temperaturaDaAgua, aguaSalgada);

    this.cascoDuro = cascoDuro;
  }
  // mestodo get
  public boolean getCascoDuro() {
    return cascoDuro;
  }
  // metodo set
  public void setCascoDuro(boolean cascoDuro) {
    this.cascoDuro = cascoDuro;
  }

  // metodo toString
  @Override
  public String toString() {
    return super.toString() + "Casco duro: " + this.cascoDuro;
  }

  //metodo para obter o tipo de casco
  public boolean obterCascoDuro () {
    return cascoDuro;
  }
  
}