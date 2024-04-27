package model;

public class Tartaruga extends Animais {
    private boolean cascoDuro;
    private int idTanque;

    public Tartaruga(int idAnimal, String especie, double tamanho, String dieta,
            double temperaturaAgua, boolean aguaSalgada, boolean cascoDuro, int idTanque2) {
        super(idAnimal, especie, tamanho, dieta, temperaturaAgua, aguaSalgada);
        this.cascoDuro = cascoDuro;
    }

    // Getter para o ID do tanque
    public int getIdTanque() {
        return idTanque;
    }

    // Setter para o ID do tanque
    public void setIdTanque(int idTanque) {
        this.idTanque = idTanque;
    }

    // Getters e setters para cascoDuro
    public boolean getCascoDuro() {
        return cascoDuro;
    }

    public void setCascoDuro(boolean cascoDuro) {
        this.cascoDuro = cascoDuro;
    }

    // Sobrescreve o método toString para formatar a exibição dos dados da tartaruga
    @Override
    public String toString() {
        return "ID: " + getIdAnimal() +
                "\nEspécie: " + getEspecie() +
                "\nTamanho: " + getTamanho() +
                "\nDieta: " + getDieta() +
                "\nTemperatura da água: " + getTemperaturaAgua() +
                "\nÁgua salgada: " + getAguaSalgada() +
                "\nCasco duro: " + getCascoDuro() +
                "\nID do Tanque: " + getIdTanque(); // Adiciona o ID do tanque à representação da tartaruga
    }
}
