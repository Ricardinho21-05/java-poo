
public class Contato {

    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    // Transformar contato em CSV
    public String toCsv() {
        return nome + ";" + telefone;
    }

    // Transformar CSV em contato
    public static Contato fromCsv(String linha) {

        String[] dados = linha.split(";", -1);

        return new Contato(dados[0], dados[1]);

    }

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Contatos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Contato> contatos = new ArrayList<>();

        // Carregar contatos salvos
        try {

            BufferedReader leitor = new BufferedReader(
                new FileReader("contatos.csv")
            );

            String linha;

            while ((linha = leitor.readLine()) != null) {

                if (!linha.isBlank()) {
                    contatos.add(Contato.fromCsv(linha));
                }

            }

            leitor.close();

        } catch (IOException e) {

            System.out.println("Arquivo ainda nao existe.");

        }

        int opcao = 0;

        do {

            System.out.println("\n--- CONTATOS ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");

            try {

                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {

                    case 1:

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();

                        contatos.add(new Contato(nome, telefone));

                        System.out.println("Contato cadastrado!");

                        break;

                    case 2:

                        for (Contato contato : contatos) {

                            System.out.println(
                                contato.getNome() + " - " +
                                contato.getTelefone()
                            );

                        }

                        break;

                    case 3:

                        System.out.println("Saindo...");

                        break;

                    default:

                        System.out.println("Opcao invalida!");

                }

            } catch (NumberFormatException e) {

                System.out.println("Digite um numero valido!");

            }

        } while (opcao != 3);

        // Salvar contatos ao sair
        try {

            FileWriter escritor = new FileWriter("contatos.csv");

            for (Contato contato : contatos) {

                escritor.write(contato.toCsv() + "\n");

            }

            escritor.close();

            System.out.println("Contatos salvos!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar contatos!");

        }

        sc.close();

    }

}
