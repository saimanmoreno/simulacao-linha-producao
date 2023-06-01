import model.PostoTrabalhoI;
import model.PostoTrabalhoII;
import model.Transportadora;

public class Main {
    public static void main(String[] args) {

        // Criação dos postos de trabalho
        PostoTrabalhoI postoA = new PostoTrabalhoI("POSTO_A", 10);
        PostoTrabalhoII postoB = new PostoTrabalhoII("POSTO_B", 5, 15);
        PostoTrabalhoII postoC = new PostoTrabalhoII("POSTO_C", 5, 15);
        PostoTrabalhoI postoD = new PostoTrabalhoI("POSTO_D", 20);

        // Criação das transportadoras
        Transportadora entradaLinha = new Transportadora("ENTRADA", Integer.MAX_VALUE);
        Transportadora transportadora1 = new Transportadora("TRANSPORTADORA_1", 5);
        Transportadora transportadora2 = new Transportadora("TRANSPORTADORA_2", 3);
        Transportadora saidaLinha = new Transportadora("SAIDA", Integer.MAX_VALUE);

        // Conexão entre as transportadoras e postos de trabalho

        // ENTRADA => POSTO_A
        entradaLinha.conectarPostoTrabalhoSaida(postoA);

        // POSTO_A => TRANSPORTADORA_1
        transportadora1.conectarPostoTrabalhoEntrada(postoA);

        // TRANSPORTADORA_1 => POSTO_B e C
        transportadora1.conectarPostoTrabalhoSaida(postoB);
        transportadora1.conectarPostoTrabalhoSaida(postoC);

        // POSTO_B e C => TRANSPORTADORA_2
        transportadora2.conectarPostoTrabalhoEntrada(postoB);
        transportadora2.conectarPostoTrabalhoEntrada(postoC);
        
        // TRANSPORTADORA_2 => POSTO_D
        transportadora2.conectarPostoTrabalhoSaida(postoD);

        // POSTO_D => SAIDA
        saidaLinha.conectarPostoTrabalhoEntrada(postoD);

        /*
        // Simulação de produção na linha
        entradaLinha.armazenarProduto();
        entradaLinha.armazenarProduto();
        entradaLinha.armazenarProduto();
        entradaLinha.armazenarProduto();

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

        */

        System.out.println(postoA);
        System.out.println();
        System.out.println(postoB);
        System.out.println();
        System.out.println(postoC);
        System.out.println();
        System.out.println(postoD);
    }
}
