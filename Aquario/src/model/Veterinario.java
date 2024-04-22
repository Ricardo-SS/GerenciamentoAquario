package model;

public class Veterinario extends Funcionario {
    private double comissaoAnimal;
    private int quantAnimais;
    
    public Veterinario(int id, String nome, int matricula, double comissaoAnimal, int quantAnimais){
        super(id, nome, matricula);
        this.comissaoAnimal = comissaoAnimal;
        this.quantAnimais = quantAnimais;
    }

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
        "Comissão Animal: " + this.comissaoAnimal +
        "Quantidade de Animais: " + this.quantAnimais;

    }
}
