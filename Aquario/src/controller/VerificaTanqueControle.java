package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.Tanque;

public class VerificaTanqueControle {
    // private TanqueControle tanqueControle = new TanqueControle(); // Instancia o controle de tanques
    // Método para verificar se o ID do tanque existe
    public boolean verificarIdTanque(int id) {
        ArrayList<Tanque> tanques = carregarTanquesDoArquivo("data/Tanque.txt");

        // Verifica se o ID do tanque existe na lista
        for (Tanque tanque : tanques) {
            if (tanque.getId() == id) {
                return true; // ID do tanque existe
            }
        }
        return false; // ID do tanque não encontrado
    }

    // Método para carregar os tanques do arquivo
    private ArrayList<Tanque> carregarTanquesDoArquivo(String nomeArquivo) {
        ArrayList<Tanque> tanques = new ArrayList<>();
        File file = new File(nomeArquivo);
        if (!file.exists()) {
            // Se o arquivo não existir, cria-o
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        } else {
            // Se o arquivo existir, carrega os dados
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    if (!linha.isEmpty()) { // Verifica se a linha não está vazia
                        String[] partes = linha.split(",");
                        int id = Integer.parseInt(partes[0]);
                        double volume = Double.parseDouble(partes[1]);
                        double temperaturaAgua = Double.parseDouble(partes[2]);
                        boolean aguaSalgada = Boolean.parseBoolean(partes[3]);

                        Tanque tanque = new Tanque(id, volume, temperaturaAgua, aguaSalgada);
                        tanques.add(tanque);
                    }
                }
                // System.out.println("Tanques carregados com sucesso do arquivo " + nomeArquivo);
            } catch (FileNotFoundException e) {
                System.err.println("Arquivo não encontrado: " + e.getMessage());
            }
        }
        return tanques;
    }

    // public ArrayList<Tanque> listarTanque() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'listarTanque'");
    // }
}

