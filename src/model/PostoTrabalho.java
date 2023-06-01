package model;

public class PostoTrabalho {
    private String id;
    private TipoPosto tipo;
    private int tempoProcessamento;
    private int unidadesProduzidas;
    private int intervaloManutencao;
    private int duracaoManutencao;
    private EstadoPosto estado;

    private Transportadora transportadoraEntrada;
    private Transportadora transportadoraSaida;

    public PostoTrabalho(String id, TipoPosto tipo, int tempoProcessamento, int intervaloManutencao,
            int duracaoManutencao) {
        this.id = id;
        this.tipo = tipo;
        this.tempoProcessamento = tempoProcessamento;
        this.intervaloManutencao = intervaloManutencao;
        this.duracaoManutencao = duracaoManutencao;
        this.estado = EstadoPosto.ESPERA;
        this.unidadesProduzidas = 0;
    }

    public String getId() {
        return id;
    }

    public TipoPosto getTipo() {
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

    public int getDuracaoManutencao() {
        return duracaoManutencao;
    }

    public EstadoPosto getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "PostoTrabalho [id=" + id + ", tipo=" + tipo + ", tempoProcessamento=" + tempoProcessamento
                + ", unidadesProduzidas=" + unidadesProduzidas + ", intervaloManutencao=" + intervaloManutencao
                + ", duracaoManutencao=" + duracaoManutencao + ", estado=" + estado + ", transportadoraEntrada="
                + transportadoraEntrada.getId() + ", transportadoraSaida=" + transportadoraSaida.getId() + "]";
    }

    public void conectarTransportadoraEntrada(Transportadora transportadora) {
        this.transportadoraEntrada = transportadora;
    }

    public void conectarTransportadoraSaida(Transportadora transportadora) {
        this.transportadoraSaida = transportadora;
    }

    // Iniciar processamento de um novo produto
    public void processarProduto() {

        if (estado == EstadoPosto.ESPERA || estado == EstadoPosto.PARADO) {

            estado = EstadoPosto.OCUPADO;
            unidadesProduzidas++;

            // Realizar manutenção para o Tipo I
            if (tipo == TipoPosto.TIPO_I && unidadesProduzidas % intervaloManutencao == 0) {
                estado = EstadoPosto.MANUTENCAO;
            
                // Realizar manutenção para o Tipo II
            } else if (tipo == TipoPosto.TIPO_II && unidadesProduzidas % intervaloManutencao == 0) {
                estado = EstadoPosto.MANUTENCAO;
            }
        }
    }

    // Finalizar processamento do produto atual
    public void terminarProcessamento() {
        if (estado == EstadoPosto.OCUPADO) {
            estado = EstadoPosto.PARADO;
        }
    }

    public void alterarEstadoManutencao() {
        if (estado == EstadoPosto.MANUTENCAO) {
            estado = EstadoPosto.ESPERA;
        } else {
            estado = EstadoPosto.MANUTENCAO;
        }
    }

}

enum TipoPosto {
    TIPO_I, TIPO_II
}

enum EstadoPosto {
    ESPERA, OCUPADO, PARADO, MANUTENCAO
}
