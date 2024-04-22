package model;

public class Peixe extends Animais {
    private String corDaEscama;


    public Peixe(int idAnimal, String especie, double tamanho, String dieta,
    double temperaturaAgua, boolean aguaSalgada, String corDaEscama) {
super(idAnimal, especie, tamanho, dieta, temperaturaAgua, aguaSalgada);
this.corDaEscama = corDaEscama;
}

    // Getters e setters para Cor da Escama
    public String getCorDaEscama() {
        return corDaEscama;
    }

    public void setCorDaEscama(String corDaEscama) {
        this.corDaEscama = corDaEscama;
    }

    @Override
    public String toString() {
        return "ID: " + getIdAnimal() +
                //"\nNome: " + getNome() +
                "\nEspécie: " + getEspecie() +
                "\nTamanho: " + getTamanho() +
                // "\nPeso: " + getPeso() +
                // "\nIdade: " + getIdade() +
                "\nDieta: " + getDieta() +
                "\nTemperatura da água: " + getTemperaturaAgua() +
                "\nÁgua salgada: " + getAguaSalgada() +
                "\nCor da Escama: " + getCorDaEscama();
    }
    

}
