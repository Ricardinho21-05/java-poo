import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double num1 = teclado.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = teclado.nextDouble();

        System.out.print("Digite o operador (+, -, *, /): ");
        char operador = teclado.next().charAt(0);

        switch (operador) {
            case '+' -> System.out.println(num1 + num2);
            case '-' -> System.out.println(num1 - num2);
            case '*' -> System.out.println(num1 * num2);
            case '/' -> {
                if (num2 == 0) {
                    System.out.println("Não pode dividir por zero!");
                } else {
                    System.out.println(num1 / num2);
                }
            }
            default -> System.out.println("Operador inválido!");
        }

        teclado.close();
    }
}