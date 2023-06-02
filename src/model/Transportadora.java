package model;

import java.util.ArrayList;
import java.util.List;

public class Transportadora {
    private String id;
    private int capacidade;
    private int tempoMaximoTransporte;
    private int produtosArmazenados;
    private List<PostoTrabalho> postosTrabalhoEntrada;
    private List<PostoTrabalho> postosTrabalhoSaida;

    public Transportadora(String id, int capacidade, int tempoMaximoTransporte) {
        this.id = id;
        this.capacidade = capacidade;
        this.tempoMaximoTransporte = tempoMaximoTransporte;

        if (id == "IN" || id == "OUT") {
            this.produtosArmazenados = Integer.MAX_VALUE;
        } else {
            this.produtosArmazenados = 0;
        }

        this.postosTrabalhoEntrada = new ArrayList<>();
        this.postosTrabalhoSaida = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getTempoMaximoTransporte() {
        return tempoMaximoTransporte;
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
    }

    public void conectarPostoTrabalhoSaida(PostoTrabalho postoTrabalho) {
        postosTrabalhoSaida.add(postoTrabalho);
    }

    @Override
    public String toString() {
        return "Transportadora [\n\tid=" + id + ", \n\tcapacidade=" + capacidade + ", \n\ttempoMaximoTransporte="
                + tempoMaximoTransporte + ", \n\tprodutosArmazenados=" + produtosArmazenados + ", \n\tpostosTrabalhoEntrada="
                + postosTrabalhoEntrada + ", \n\tpostosTrabalhoSaida=" + postosTrabalhoSaida + "\n]";
    }
}
