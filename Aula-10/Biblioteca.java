
public class LivroNaoEncontradoException extends Exception {

    public LivroNaoEncontradoException() {
        super("Livro nao encontrado!");
    }

}

public class LivroIndisponivelException extends Exception {

    public LivroIndisponivelException() {
        super("Livro indisponivel no momento!");
    }

}

public class LimiteDeEmprestimosException extends Exception {

    public LimiteDeEmprestimosException() {
        super("Limite de 3 emprestimos atingido!");
    }

}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Biblioteca {

    static Map<String, Integer> livros = new HashMap<>();

    static Map<String, Integer> emprestimos = new HashMap<>();

    // Emprestar livro
    public static void emprestar(String usuario, String livro)
            throws LivroNaoEncontradoException,
                   LivroIndisponivelException,
                   LimiteDeEmprestimosException {

        if (!livros.containsKey(livro)) {
            throw new LivroNaoEncontradoException();
        }

        if (livros.get(livro) <= 0) {
            throw new LivroIndisponivelException();
        }

        int quantidade = emprestimos.getOrDefault(usuario, 0);

        if (quantidade >= 3) {
            throw new LimiteDeEmprestimosException();
        }

        livros.put(livro, livros.get(livro) - 1);

        emprestimos.put(usuario, quantidade + 1);

        System.out.println("Emprestimo realizado!");

    }

    // Listar livros
    public static void listarLivros() {

        System.out.println("\n--- LIVROS ---");

        for (String livro : livros.keySet()) {

            System.out.println(
                livro + " - Quantidade: " + livros.get(livro)
            );

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        livros.put("Java", 2);
        livros.put("Python", 1);
        livros.put("C++", 0);

        int opcao = 0;

        do {

            try {

                System.out.println("\n--- BIBLIOTECA ---");
                System.out.println("1 - Listar livros");
                System.out.println("2 - Emprestar livro");
                System.out.println("3 - Sair");
                System.out.print("Escolha: ");

                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {

                    case 1:

                        listarLivros();

                        break;

                    case 2:

                        System.out.print("Nome do usuario: ");
                        String usuario = sc.nextLine();

                        System.out.print("Nome do livro: ");
                        String livro = sc.nextLine();

                        try {

                            emprestar(usuario, livro);

                        } catch (LivroNaoEncontradoException e) {

                            System.out.println(e.getMessage());

                        } catch (LivroIndisponivelException e) {

                            System.out.println(e.getMessage());

                        } catch (LimiteDeEmprestimosException e) {

                            System.out.println(e.getMessage());

                        }

                        break;

                    case 3:

                        System.out.println("Saindo da biblioteca...");

                        break;

                    default:

                        System.out.println("Opcao invalida!");

                }

            } catch (NumberFormatException e) {

                System.out.println("Digite uma opcao numerica!");

            } catch (Exception e) {

                System.out.println("Ocorreu um erro: " + e.getMessage());

            }

        } while (opcao != 3);

        sc.close();

    }

}
