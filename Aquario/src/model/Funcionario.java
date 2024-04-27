package model;

public abstract class Funcionario {
    // Atrubutos
    private int id;
    private String nome;
    private int matricula;
   
    // Construtor
    public Funcionario(int id, String nome, int matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + 
                ", nome=" + nome + 
                ", matricula=" + matricula;
    }



    
}
