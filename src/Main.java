import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.PostoTrabalho;
import model.PostoTrabalhoI;
import model.PostoTrabalhoII;
import model.Transportadora;

public class Main {
    public static void main(String[] args) {

        String descricao = "T1 1 3\n" +
                "T2 1 3\n" +
                "PI A IN T1 12\n" +
                "PII B T1 T2 10 18\n" +
                "PI C T1 T2 14\n" +
                "PII D T2 OUT 5 30";

        Map<String, Transportadora> transportadoras = new HashMap<>();
        List<PostoTrabalho> postosTrabalho = new ArrayList<>();

        Transportadora transportadoraIn = new Transportadora("IN", Integer.MAX_VALUE, Integer.MAX_VALUE);
        transportadoras.put("IN", transportadoraIn);

        Transportadora transportadoraOut = new Transportadora("OUT", Integer.MAX_VALUE, Integer.MAX_VALUE);
        transportadoras.put("OUT", transportadoraOut);

        String[] linhas = descricao.split("\n");

        for (String linha : linhas) {

            String[] partes = linha.split(" ");

            if (partes[0].startsWith("T")) {

                // Linha contém informações de transportadora
                String identificador = partes[0];
                int capacidade = Integer.parseInt(partes[1]);
                int tempoMaximoTransporte = Integer.parseInt(partes[2]);

                Transportadora transportadora = new Transportadora(identificador, capacidade, tempoMaximoTransporte);
                transportadoras.put(identificador, transportadora);

            } else {

                // Linha contém informações de posto de trabalho
                String tipo = partes[0];
                String identificador = partes[1];
                String idTransportadoraEntrada = partes[2];
                String idTransportadoraSaida = partes[3];
                int tempoProc1 = Integer.parseInt(partes[4]);

                Transportadora transportadoraEntrada = transportadoras.get(idTransportadoraEntrada);
                Transportadora transportadoraSaida = transportadoras.get(idTransportadoraSaida);

                // A transportadora foi encontrada
                if (transportadoraEntrada != null && transportadoraSaida != null) {

                    if (tipo.equals("PI")) {

                        PostoTrabalhoI postoTrabalhoI = new PostoTrabalhoI(identificador, transportadoraEntrada,
                                transportadoraSaida, tempoProc1);
                        postosTrabalho.add(postoTrabalhoI);

                    } else if (tipo.equals("PII")) {

                        int tempoProc2 = Integer.parseInt(partes[5]);

                        PostoTrabalhoII postoTrabalhoII = new PostoTrabalhoII(identificador, transportadoraEntrada,
                                transportadoraSaida, tempoProc1, tempoProc2);
                        postosTrabalho.add(postoTrabalhoII);

                    }

                    // A transportadora não foi encontrada
                } else {
                    System.out.println("Transportadora não encontrada com o ID: " + idTransportadoraEntrada + " ou "
                            + idTransportadoraSaida);
                }

            }
        }

        // Exemplo de uso dos dados coletados
        System.out.println("Transportadoras:");
        for (Transportadora transportadora : transportadoras.values()) {
            System.out.println(transportadora);
        }

        System.out.println("\nPostos de Trabalho:");
        for (PostoTrabalho postoTrabalho : postosTrabalho) {
            System.out.println(postoTrabalho);
        }

    }
}
