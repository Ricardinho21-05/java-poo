
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agenda {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Map<String, String> agenda = new HashMap<>();

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("\n--- AGENDA ---");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Buscar contato");
            System.out.println("3 - Remover contato");
            System.out.println("4 - Listar contatos");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = entrada.nextLine();

                    agenda.put(nome, telefone);

                    System.out.println("Contato adicionado!");

                    break;

                case 2:

                    System.out.print("Nome para buscar: ");
                    nome = entrada.nextLine();

                    if (agenda.containsKey(nome)) {
                        System.out.println("Telefone: " + agenda.get(nome));
                    } else {
                        System.out.println("Contato nao encontrado!");
                    }

                    break;

                case 3:

                    System.out.print("Nome para remover: ");
                    nome = entrada.nextLine();

                    if (agenda.containsKey(nome)) {
                        agenda.remove(nome);
                        System.out.println("Contato removido!");
                    } else {
                        System.out.println("Contato nao encontrado!");
                    }

                    break;

                case 4:

                    System.out.println("\nContatos cadastrados:");

                    for (String chave : agenda.keySet()) {
                        System.out.println(chave + " - " + agenda.get(chave));
                    }

                    break;

                case 5:

                    System.out.println("Encerrando agenda...");

                    break;

                default:

                    System.out.println("Opcao invalida!");

            }

        }

        entrada.close();

    }

}
