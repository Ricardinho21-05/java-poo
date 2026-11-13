
public class Cadastro {

    public static void cadastrar(String nome, int idade) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome invalido!");
        }

        if (idade < 0 || idade > 120) {
            throw new IllegalArgumentException("Idade invalida!");
        }

        System.out.println("Cadastro realizado com sucesso!");

    }

    public static void main(String[] args) {

        // Caso 1: válido
        try {

            cadastrar("Joao", 20);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        // Caso 2: nome vazio
        try {

            cadastrar("", 25);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        // Caso 3: idade negativa
        try {

            cadastrar("Maria", -5);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        // Caso 4: idade acima de 120
        try {

            cadastrar("Pedro", 150);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

    }

}
