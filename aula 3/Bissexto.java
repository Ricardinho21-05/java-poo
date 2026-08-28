import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite um ano: ");
        int ano = teclado.nextInt();

        boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);

        if (bissexto) {
            System.out.println("Ano bissexto!");
        } else {
            System.out.println("Não é ano bissexto!");
        }

        teclado.close();
    }
}