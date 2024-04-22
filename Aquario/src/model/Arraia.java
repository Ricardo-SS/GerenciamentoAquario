package model;

public class Arraia  extends Animais {

    private boolean espinhoVenenoso;

    public Arraia(int idAnimal, String especie, double tamanho, String dieta,
                    double temperaturaAgua, boolean aguaSalgada, boolean espinhoVenenoso){
                        super(idAnimal, especie, tamanho, dieta, temperaturaAgua, aguaSalgada);
                        this.espinhoVenenoso = espinhoVenenoso;
                    }


public boolean getEspinhoVenenoso(){
    return espinhoVenenoso;
}

public void setEspinhoVenenoso(boolean espinhoVenenoso){
    this.espinhoVenenoso = espinhoVenenoso;
}

@Override
public String toString(){
    return "ID: " + getIdAnimal() +
    "\nEspécie: " + getEspecie() +
    "\nTamanho: " + getTamanho() +
    "\nDieta: " + getDieta() +
    "\nTemperatura da água: " + getTemperaturaAgua() +
    "\nÁgua salgada: " + getAguaSalgada() +
    "\nEspinho Venenoso: " + getEspinhoVenenoso();
}

}