public class Peixe extends Animais {

    private boolean espinhoVenenoso;
    private String corEscamas;

    public Peixe(int idAnimal, String nome, String especie, double tamanho, double peso, int idade,
            String dieta, double temperaturaDaAgua, boolean aguaSalgada) {

        super(idAnimal, nome, especie, tamanho, peso, idade, dieta, temperaturaDaAgua, aguaSalgada);
        this.espinhoVenenoso = espinhoVenenoso;
        this.corEscamas = corEscamas;

    }

    public boolean getEspinhoVenenoso() {
        return espinhoVenenoso;
    }

    public void setEspinhoVenenoso() {
        this.espinhoVenenoso = espinhoVenenoso;
    }

    public String getCorEscamas() {
        return corEscamas;
    }

    public void setCorEscamas(String corEscama) {
        this.corEscamas = corEscamas;
    }

    @Override
    public String toString() {
        return super.toString() + "Cor de escama: " + this.corEscamas + "Espinho venenoso: " + this.espinhoVenenoso;
    }

}