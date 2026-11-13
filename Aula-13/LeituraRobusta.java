
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraRobusta {

    public static void main(String[] args) {

        try {

            BufferedReader leitor = new BufferedReader(
                new FileReader("notas.csv")
            );

            String linha;
            int numeroLinha = 0;

            while ((linha = leitor.readLine()) != null) {

                numeroLinha++;

                try {

                    if (linha.isBlank()) {
                        throw new Exception("Linha vazia");
                    }

                    String[] dados = linha.split(";", -1);

                    if (dados.length != 2) {
                        throw new Exception("Campo faltando");
                    }

                    String nome = dados[0];

                    int nota = Integer.parseInt(dados[1]);

                    if (nome.isBlank()) {
                        throw new Exception("Nome vazio");
                    }

                    System.out.println(
                        "Aluno: " + nome + " - Nota: " + nota
                    );

                } catch (Exception e) {

                    System.out.println(
                        "Erro na linha " + numeroLinha +
                        ": " + e.getMessage()
                    );

                }

            }

            leitor.close();

        } catch (IOException e) {

            System.out.println("Erro ao abrir o arquivo!");

        }

    }

}
