package model;

public class Gerente extends Funcionario {

    public Gerente(int id, String nome, int matricula){
        super(id, nome, matricula);

    }

    @Override
    public String toString(){
        return super.toString() + getId();
    }
    
}
