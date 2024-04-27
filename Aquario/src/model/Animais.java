package model;

public abstract class Animais {
    // Atributos
    private int idAnimal;
    private String especie;
    private double tamanho;
    private String dieta;
    private double temperaturaAgua;
    private boolean aguaSalgada;

    // Construtor
    public Animais(int idAnimal, String especie, double tamanho, String dieta,
            double temperaturaAgua, boolean aguaSalgada) {
        this.idAnimal = idAnimal;
        this.especie = especie;
        this.tamanho = tamanho;
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

    public boolean getAguaSalgada() {
        return aguaSalgada;
    }

    public void setAguaSalgada(boolean aguaSalgada) {
        this.aguaSalgada = aguaSalgada;
    }

    @Override
    public String toString() {
        return "Id: " + this.idAnimal +
                "\nEspecie: " + this.especie +
                "\nTamanho: " + this.tamanho +
                "\nDieta: " + this.dieta +
                "\nTemperatura da água: " + this.temperaturaAgua +
                "\nAgua Salgada: " + this.aguaSalgada;
    }
}
