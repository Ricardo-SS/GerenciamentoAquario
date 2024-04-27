package model;

public class Tanque {
    // Atributos
    private int id;
    private double volume;
    private double temperaturaAgua;
    private boolean aguaSalgada;
    
    // Construtor
    public Tanque(int id, double volume, double temperaturaAgua, boolean aguaSalgada) {
        this.id = id;
        this.volume = volume;
        this.temperaturaAgua = temperaturaAgua;
        this.aguaSalgada = aguaSalgada;
    }

    // Getters e setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
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
    @Override
    public String toString() {
        return "Tanque [id=" + id + ", volume=" + volume + ", temperaturaAgua=" + temperaturaAgua + ", aguaSalgada="
                + aguaSalgada + "]";
    }
    
}
