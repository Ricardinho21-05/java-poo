
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Relatorio {

    public static void main(String[] args) {

        Map<String, Integer> produtos = new HashMap<>();

        double totalGeral = 0;
        int totalVendas = 0;

        try {

            BufferedReader leitor = new BufferedReader(
                new FileReader("vendas.csv")
            );

            String linha;

            while ((linha = leitor.readLine()) != null) {

                String[] dados = linha.split(";");

                String nome = dados[0];

                int quantidade = Integer.parseInt(dados[1]);

                double valor = Double.parseDouble(dados[2]);

                double total = quantidade * valor;

                totalGeral += total;

                totalVendas++;

                // Somar quantidade por produto
                int quantidadeAtual = produtos.getOrDefault(nome, 0);

                produtos.put(nome, quantidadeAtual + quantidade);

            }

            leitor.close();

            // Encontrar produto mais vendido
            String maisVendido = "";
            int maiorQuantidade = 0;

            for (String nome : produtos.keySet()) {

                if (produtos.get(nome) > maiorQuantidade) {

                    maiorQuantidade = produtos.get(nome);

                    maisVendido = nome;

                }

            }

            double media = 0;

            if (totalVendas > 0) {
                media = totalGeral / totalVendas;
            }

            // Gravar relatorio
            FileWriter escritor = new FileWriter("relatorio.txt");

            escritor.write("===== RELATORIO DE VENDAS =====\n");

            escritor.write("Total geral: R$ " + totalGeral + "\n");

            escritor.write("Produto mais vendido: " + maisVendido + "\n");

            escritor.write("Quantidade vendida: " + maiorQuantidade + "\n");

            escritor.write("Media por venda: R$ " + media + "\n");

            escritor.close();

            System.out.println("Relatorio criado com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao acessar arquivo!");

        } catch (NumberFormatException e) {

            System.out.println("Erro: quantidade ou valor invalido!");

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Erro: linha incompleta no CSV!");

        }

    }

}
