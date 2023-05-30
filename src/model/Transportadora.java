package model;

public class Transportadora {
    private String id;
    private int capacidade;
    // outros atributos necessários

    public Transportadora(String id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
    }

    public String getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean temCapacidadeDisponivel() {
        // lógica para verificar se a transportadora tem capacidade disponível
    }

    public void adicionarProduto() {
        // lógica para adicionar um produto à transportadora
    }

    public void removerProduto() {
        // lógica para remover um produto da transportadora
    }

    // outros métodos relevantes
}

