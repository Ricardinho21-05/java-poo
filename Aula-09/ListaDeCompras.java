
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaDeCompras {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> lista = new ArrayList<>();

        String item;

        // Lendo os itens
        System.out.println("Digite os itens da lista (digite 'fim' para encerrar):");

        while (true) {
            System.out.print("Item: ");
            item = sc.nextLine();

            if (item.equalsIgnoreCase("fim")) {
                break;
            }

            lista.add(item);
        }

        // Exibindo a lista numerada
        System.out.println("\n--- Lista de Compras ---");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }

        // Exibindo o total de itens
        System.out.println("Total de itens: " + lista.size());

        // Removendo um item
        System.out.print("\nDigite o nome do item que deseja remover: ");
        String remover = sc.nextLine();

        if (lista.remove(remover)) {
            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Item não encontrado na lista.");
        }

        // Exibindo a lista atualizada
        System.out.println("\n--- Lista Atualizada ---");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }

        System.out.println("Total de itens: " + lista.size());

        sc.close();
    }
}
