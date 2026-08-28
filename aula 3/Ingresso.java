import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        final double INTEIRA = 40.0;

        System.out.print("Digite sua idade: ");
        int idade = teclado.nextInt();

        System.out.print("É estudante? (s/n): ");
        char estudante = teclado.next().charAt(0);

        System.out.print("Digite o dia da semana: ");
        String dia = teclado.next();

        double preco = INTEIRA;
        String descontos = "Descontos aplicados: ";

        // Menores de 18, idosos e estudantes pagam meia
        if (idade < 18 || idade >= 60 || estudante == 's') {
            preco = preco / 2;
            descontos += "meia-entrada";
        } else {
            descontos += "nenhum desconto de meia-entrada";
        }

        // Terça-feira tem mais 20% de desconto
        if (dia.equalsIgnoreCase("terça-feira") || dia.equalsIgnoreCase("terca-feira")) {
            preco = preco * 0.80;
            descontos += " + 20% de terça-feira";
        }

        System.out.printf("Preço final: R$ %.2f%n", preco);
        System.out.println(descontos);

        teclado.close();
    }
}
