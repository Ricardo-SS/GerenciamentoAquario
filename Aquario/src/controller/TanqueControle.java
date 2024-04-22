package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import model.Tanque;

public class TanqueControle {
    private ArrayList<Tanque> tanques;

    public TanqueControle() {
        this.tanques = new ArrayList<>();
        // Carrega tanques do arquivo
        carregarArquivo("data/Tanque.txt");
    }

    public void inserirTanque(Tanque tanque) {
        tanques.add(tanque);
        System.out.println("Tanque cadastrado com sucesso.");
        escreverArquivo("data/Tanque.txt");
    }

    public void removerTanque(int id) {
        boolean removido = false;
        for (Tanque tanque : tanques) {
            if (tanque.getId() == id) {
                tanques.remove(tanque);
                System.out.println("Tanque removido com sucesso.");
                removido = true;
                escreverArquivo("data/Tanque.txt");
                break;
            }
        }
        if (!removido) {
            System.out.println("Tanque não encontrado.");
        }
    }

    public void editarTanque(int id, double volume, double temperaturaAgua, boolean aguaSalgada) {
        Tanque tanque = buscarTanque(id);
        if (tanque != null) {
            tanque.setVolume(volume);
            System.out.println("Volume editado com sucesso.");
            tanque.setTemperaturaAgua(temperaturaAgua);
            System.out.println("Temperatura editado com sucesso.");
            tanque.setAguaSalgada(aguaSalgada);
            escreverArquivo("data/Tanque.txt");
        } else {
            System.out.println("Tanque não encontrado.");
        }
    }

    public Tanque buscarTanque(int id) {
        for (Tanque tanque : tanques) {
            if (tanque.getId() == id) {
                return tanque;
            }
        }
        System.out.println("Tanque não encontrado.");
        return null;
    }

    public ArrayList<Tanque> listarTanque() {
        return tanques;
    }

    public int obterProximoId() {
        int maiorId = 0;
        for (Tanque tanque : tanques) {
            if (tanque.getId() > maiorId) {
                maiorId = tanque.getId();
            }
        }
        return maiorId + 1; // Retorna o próximo ID disponível
    }

    private void carregarArquivo(String nomeArquivo) {
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
                System.out.println("Tanques carregados com sucesso do arquivo " + nomeArquivo);
            } catch (FileNotFoundException e) {
                System.err.println("Arquivo não encontrado: " + e.getMessage());
            }
        }
    }

    private void escreverArquivo(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Tanque tanque : tanques) {
                writer.println(tanque.getId() + "," + tanque.getVolume() + "," + tanque.getTemperaturaAgua() + ","
                        + tanque.isAguaSalgada());
            }
            System.out.println("Tanques salvos com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
