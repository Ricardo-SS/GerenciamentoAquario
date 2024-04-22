package controller;

import java.io.*;
import java.util.ArrayList;

import model.Funcionario;
import model.Gerente;
//import model.Veterinario;

public class FuncionariosController {
    private ArrayList<Funcionario> funcionarios;

        public FuncionariosController() {
        this.funcionarios = new ArrayList<>();
    }

    public void inserirFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("funcionario inserido com sucesso.");
    }
    
        public void removerFuncionario(int id) {
        boolean removido = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula() == id) {
                funcionarios.remove(funcionario);
                System.out.println("Funcionario removido com sucesso.");
                removido = true;
                break;
            }
        }
        if (!removido) {
            System.out.println("Funcionario não encontrado.");
        }
    }

        public Funcionario buscarFuncionario(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula() == id) {
                return funcionario;
            }
        }
        System.out.println("Funcionario não encontrado.");
        return null;
    }

        public ArrayList<Funcionario> listarFuncionarios() {
        return funcionarios;
    }


        // Implementação dos métodos abstratos da classe Funcionarios
    public void inserirFuncionario(Gerente gerente) {
        funcionarios.add(gerente);
        // Salva o animal no arquivo
        escreverArquivo("data/funcionarios.txt");
        System.out.println("Gerente inserido com sucesso.");
    }

        public void listarFuncionario() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

        // Método para escrever os funcionarios em um arquivo de texto
    private void escreverArquivo(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Funcionario funcionario : funcionarios) {
                // Escreve os dados do funcionario em uma linha no arquivo
                writer.println(funcionario.getNome() + ";" + funcionario.getMatricula());
            }
            System.out.println("Funcionarios salvos com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
          
    }


