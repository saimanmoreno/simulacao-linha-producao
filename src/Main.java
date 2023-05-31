import model.PostoTrabalhoI;
import model.PostoTrabalhoII;
import model.Transportadora;

public class Main {
    public static void main(String[] args) {

        // Criação dos postos de trabalho
        PostoTrabalhoI posto1 = new PostoTrabalhoI("P1", 10);
        PostoTrabalhoII posto2 = new PostoTrabalhoII("P2", 5, 15);

        // Criação das transportadoras
        Transportadora entradaLinha = new Transportadora("IN", Integer.MAX_VALUE);
        Transportadora transportadora1 = new Transportadora("T1", 5);
        Transportadora transportadora2 = new Transportadora("T2", 3);
        Transportadora saidaLinha = new Transportadora("OUT", Integer.MAX_VALUE);

        // Conexão entre as transportadoras e postos de trabalho
        entradaLinha.conectarPostoTrabalhoSaida(posto1);
        posto1.conectarTransportadoraEntrada(entradaLinha);

        transportadora1.conectarPostoTrabalhoEntrada(posto1);
        posto1.conectarTransportadoraSaida(transportadora1);

        transportadora1.conectarPostoTrabalhoSaida(posto2);
        posto2.conectarTransportadoraEntrada(transportadora1);

        transportadora2.conectarPostoTrabalhoEntrada(posto2);
        posto2.conectarTransportadoraSaida(transportadora2);

        // Simulação de produção na linha
        for (int i = 1; i <= 100; i++) {
            // Processamento nos postos de trabalho
            posto1.processarProduto();
            posto2.processarProduto();

            // Movimentação dos produtos entre as transportadoras
            entradaLinha.liberarProduto();
            transportadora1.armazenarProduto();
            transportadora1.liberarProduto();
            transportadora2.armazenarProduto();
            transportadora2.liberarProduto();
            saidaLinha.armazenarProduto();
        }

        // Exibição das informações finais
        System.out.println("Transportadora " + transportadora1.getId() + ":");
        System.out.println("Produtos Armazenados: " + transportadora1.getProdutosArmazenados());

        System.out.println("Transportadora " + transportadora2.getId() + ":");
        System.out.println("Produtos Armazenados: " + transportadora2.getProdutosArmazenados());

        System.out.println("Transportadora " + saidaLinha.getId() + ":");
        System.out.println("Produtos Armazenados: " + saidaLinha.getProdutosArmazenados());
    }
}
