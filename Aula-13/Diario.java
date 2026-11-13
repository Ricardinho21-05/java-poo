
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Diario {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Mostrar anotacoes antigas
        try {

            BufferedReader leitor = new BufferedReader(
                new FileReader("diario.txt")
            );

            String linha;

            System.out.println("--- MEU DIARIO ---");

            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }

            leitor.close();

        } catch (IOException e) {

            System.out.println("Ainda nao existe um diario.");

        }

        // Ler nova anotacao
        System.out.print("\nDigite sua anotacao: ");
        String frase = sc.nextLine();

        // Pegar data e hora
        LocalDateTime agora = LocalDateTime.now();

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String data = agora.format(formato);

        // Salvar no arquivo sem apagar o anterior
        try {

            FileWriter escritor = new FileWriter("diario.txt", true);

            escritor.write(data + " - " + frase + "\n");

            escritor.close();

            System.out.println("Anotacao salva!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar anotacao!");

        }

        sc.close();

    }

}
