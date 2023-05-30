package model;

public class PostoTrabalho {
    private String id;
    private int tipo;
    private int tempoProcessamento;
    private int unidadesProduzidas;
    private int intervaloManutencao;
    private boolean emManutencao;
    private Transportadora entrada;
    private Transportadora saida;
    // outros atributos necessários

    public PostoTrabalho(String id, int tipo, int tempoProcessamento, int intervaloManutencao) {
        this.id = id;
        this.tipo = tipo;
        this.tempoProcessamento = tempoProcessamento;
        this.intervaloManutencao = intervaloManutencao;
        this.unidadesProduzidas = 0;
        this.emManutencao = false;
    }

    public String getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public int getTempoProcessamento() {
        return tempoProcessamento;
    }

    public int getUnidadesProduzidas() {
        return unidadesProduzidas;
    }

    public int getIntervaloManutencao() {
        return intervaloManutencao;
    }

    public boolean estaEmManutencao() {
        return emManutencao;
    }

    public Transportadora getEntrada() {
        return entrada;
    }

    public Transportadora getSaida() {
        return saida;
    }

    public void setEntrada(Transportadora entrada) {
        this.entrada = entrada;
    }

    public void setSaida(Transportadora saida) {
        this.saida = saida;
    }

    public void iniciarProcessamento() {
        // lógica para iniciar o processamento de um produto
    }

    public void concluirProcessamento() {
        // lógica para concluir o processamento de um produto
    }

    public void realizarManutencao() {
        // lógica para iniciar a manutenção
    }

    public void concluirManutencao() {
        // lógica para concluir a manutenção
    }

    // outros métodos relevantes
}

