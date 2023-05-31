package model;

import java.util.Random;

public class PostoTrabalhoII extends PostoTrabalho {
    private static final int INTERVALO_MANUTENCAO = 100;
    private static final int DURACAO_MANUTENCAO = 60;
    private final int tempoProcessamentoMin;

    public PostoTrabalhoII(String id, int tempoProcessamentoMin, int tempoProcessamentoMax) {
        super(id, TipoPosto.TIPO_II, getRandomTempoProcessamento(tempoProcessamentoMin, tempoProcessamentoMax),
                INTERVALO_MANUTENCAO, DURACAO_MANUTENCAO);
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

    private final int tempoProcessamentoMax;

    public int getTempoProcessamentoMax() {
        return tempoProcessamentoMax;
    }

}
