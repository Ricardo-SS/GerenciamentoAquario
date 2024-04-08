
public abstract class Animais{

    private int idAnimal;
    private String nome;
    private String especie;
    private Double tamanho;
    private Double peso;
    private int idade;
    private String dieta;
    private Double temperaturaDaAgua;
    private boolean aguaSalgada;

//inicialização dos atributos

    public Animais(){
        this.idAnimal = 00;
        this.nome = "";
        this.especie = "";
        this.tamanho = 0.00;
        this.peso = 0.00;
        this.idade = 0;
        this.dieta = "";
        this.temperaturaDaAgua = 0.00;
        this.aguaSalgada = true;

    }

//construtor

    public Animais(int idAnimal, String nome, String especie, double tamanho, double peso, int idade, 
                String dieta, double temperaturaDaAgua, boolean aguaSalgada){

        this.idAnimal = idAnimal;
        this.nome = nome;
        this.especie = especie;
        this.tamanho = tamanho;
        this.peso = peso;
        this.idade = idade;
        this.dieta = dieta;
        this.temperaturaDaAgua = temperaturaDaAgua;
        this.aguaSalgada = aguaSalgada;

    }
//método toString

    @Override
    public String toString(){
        return 

        "Id do animal: " + this.idAnimal + 
        "\nNome: " + this.nome +
        "\nEspecie: " + this.especie +
        "\nTamanho: " + this.tamanho +
        "\nPeso: " + this.peso +
        "\nIdade: " + this.idade +
        "\nDieta: " + this.dieta +
        "\nTemperatura da água: " + this.temperaturaDaAgua +
        "\nAgua Salgada: " + this.aguaSalgada;
    }
//gets && sets

    public int getIdAnimal(){
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal){
        this.idAnimal = idAnimal;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEspecie(){
        return nome;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    public double getTamanho(){
        return tamanho;
    }

    public void setTamanho(double tamanho){
        this.tamanho = tamanho;
    }

    public double getPeso(){
        return peso;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public int getIdade(){
        return idAnimal;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getDieta(){
        return dieta;
    }

    public void setDieta(String dieta){
        this.dieta = dieta;

    }

    public double getTemperaturaDaAgua(){
        return temperaturaDaAgua;
    }

    public void setTemperaturaDaAgua(double temperaturaDaAgua){
        this.temperaturaDaAgua = temperaturaDaAgua;
    }

    public boolean getAguaSalgada(){
        return aguaSalgada;
    }

    public void setAguaSalgada(boolean aguaSalgada){
        this.aguaSalgada = aguaSalgada;
    }

    
}