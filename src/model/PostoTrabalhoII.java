package model;

import java.util.Random;

public class PostoTrabalhoII extends PostoTrabalho {
    private static final int INTERVALO_MANUTENCAO = 100;
    private static final int DURACAO_MANUTENCAO = 60;
    private final int tempoProcessamentoMax;
    private final int tempoProcessamentoMin;
    
    public PostoTrabalhoII(String id, Transportadora transportadoraEntrada, Transportadora transportadoraSaida, int tempoProcessamentoMin, int tempoProcessamentoMax) {
        super(id, TipoPosto.TIPO_II, transportadoraEntrada, transportadoraSaida, getRandomTempoProcessamento(tempoProcessamentoMin, tempoProcessamentoMax), INTERVALO_MANUTENCAO, DURACAO_MANUTENCAO);

        this.tempoProcessamentoMin = tempoProcessamentoMin;
        this.tempoProcessamentoMax = tempoProcessamentoMax;
    }

    private static int getRandomTempoProcessamento(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public int getTempoProcessamentoMin() {
        return tempoProcessamentoMin;
    }


    public int getTempoProcessamentoMax() {
        return tempoProcessamentoMax;
    }

}
