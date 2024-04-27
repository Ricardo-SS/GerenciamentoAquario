package model;

public class Veterinario extends Funcionario {
    // Atributos
    private double comissaoAnimal;
    private int quantAnimais;

    // Contrutor
    public Veterinario(int id, int matricula, String nome, double comissaoAnimal, int quantAnimais){
        super(id, nome, matricula);
        this.comissaoAnimal = comissaoAnimal;
        this.quantAnimais = quantAnimais;
    }
    
    // Getters e setters
    public double getComissaoAnimal() {
        return comissaoAnimal;
    }

    public void setComissaoAnimal(double comissaoAnimal) {
        this.comissaoAnimal = comissaoAnimal;
    }

    public int getQuantAnimais() {
        return quantAnimais;
    }

    public void setQuantAnimais(int quantAnimais) {
        this.quantAnimais = quantAnimais;
    }

    @Override
    public String toString(){
        return super.toString() + 
        ", Comissão=" + this.comissaoAnimal +
        ", Quantidade de Animais=" + this.quantAnimais + "]";

    }
}
