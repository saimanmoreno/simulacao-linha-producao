import model.PostoTrabalho;
import model.Transportadora;

public class App {
    public static void main(String[] args) throws Exception {

        // Criando os objetos de postos de trabalho
        PostoTrabalho postoA = new PostoTrabalho("A", 1, 12, 50);
        PostoTrabalho postoB = new PostoTrabalho("B", 2, 0, 100);
        PostoTrabalho postoC = new PostoTrabalho("C", 1, 14, 100);
        PostoTrabalho postoD = new PostoTrabalho("D", 2, 0, 100);

        // Criando os objetos de transportadoras
        Transportadora t1 = new Transportadora("T1", 1);
        Transportadora t2 = new Transportadora("T2", 1);

        // Estabelecendo as associações entre postos de trabalho e transportadoras
        postoA.setSaida(t1);
        postoB.setEntrada(t1);
        postoB.setSaida(t2);
        postoC.setEntrada(t1);
        postoC.setSaida(t2);
        postoD.setEntrada(t2);
        postoD.setSaida(null); // Saída para o depósito de produtos

        t1.setEntrada(postoA);
        t1.setSaida(postoB);
        t2.setEntrada(postoB);
        t2.setSaida(postoD);

        System.out.println("Hello, World!");
    }
}
