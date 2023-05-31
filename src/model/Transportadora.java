package model;

import java.util.ArrayList;
import java.util.List;

public class Transportadora {
    private String id;
    private int capacidade;
    private int produtosArmazenados;
    private List<PostoTrabalho> postosTrabalhoEntrada;
    private List<PostoTrabalho> postosTrabalhoSaida;

    public Transportadora(String id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
        this.produtosArmazenados = 0;
        this.postosTrabalhoEntrada = new ArrayList<>();
        this.postosTrabalhoSaida = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getProdutosArmazenados() {
        return produtosArmazenados;
    }

    public boolean possuiCapacidadeDisponivel() {
        return produtosArmazenados < capacidade;
    }

    public void armazenarProduto() {
        if (possuiCapacidadeDisponivel()) {
            produtosArmazenados++;
        }
    }

    public void liberarProduto() {
        if (produtosArmazenados > 0) {
            produtosArmazenados--;
        }
    }
    
    public void conectarPostoTrabalhoEntrada(PostoTrabalho postoTrabalho) {
        postosTrabalhoEntrada.add(postoTrabalho);
        postoTrabalho.conectarTransportadoraEntrada(this);
    }

    public void conectarPostoTrabalhoSaida(PostoTrabalho postoTrabalho) {
        postosTrabalhoSaida.add(postoTrabalho);
        postoTrabalho.conectarTransportadoraSaida(this);
    }

    @Override
    public String toString() {
        return "Transportadora [id=" + id + ", capacidade=" + capacidade + ", produtosArmazenados="
                + produtosArmazenados + "]";
    }
}


