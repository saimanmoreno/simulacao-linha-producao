package model;

public class PostoTrabalhoI extends PostoTrabalho {
    private static final int INTERVALO_MANUTENCAO = 50;
    private static final int DURACAO_MANUTENCAO = 30;

    public PostoTrabalhoI(String id, Transportadora transportadoraEntrada, Transportadora transportadoraSaida, int tempoProcessamento) {
        super(id, TipoPosto.TIPO_I, transportadoraEntrada, transportadoraSaida, tempoProcessamento, INTERVALO_MANUTENCAO, (DURACAO_MANUTENCAO + tempoProcessamento));
    }
}
