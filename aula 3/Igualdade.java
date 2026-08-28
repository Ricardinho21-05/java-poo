import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = teclado.nextLine();

        System.out.println("== : " + (palavra == "java"));
        System.out.println(".equals() : " + palavra.equals("java"));
        System.out.println(".equalsIgnoreCase() : " + palavra.equalsIgnoreCase("java"));

  
 
        teclado.close();
    }
}