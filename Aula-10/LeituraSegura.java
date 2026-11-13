import java.util.Scanner;

public class LeituraSegura {

    public static int lerInteiro(Scanner sc, String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);
                String texto = sc.nextLine();

                return Integer.parseInt(texto);

            } catch (NumberFormatException e) {

                System.out.println("Digite um numero inteiro valido!");

            }

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int idade = lerInteiro(sc, "Digite sua idade: ");

        int ano = lerInteiro(sc, "Digite seu ano de nascimento: ");

        System.out.println("Idade: " + idade);
        System.out.println("Ano de nascimento: " + ano);

        sc.close();

    }

}
