
public class Livro {

    private String codigo;
    private String nome;
    private int quantidade;

    public Livro(String codigo, String nome, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void emprestar() {
        quantidade--;
    }

}

public class Usuario {

    private String id;
    private String nome;

    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}

public class Emprestimo {

    private Livro livro;
    private Usuario usuario;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BibliotecaPersistente {

    static List<Livro> livros = new ArrayList<>();
    static List<Usuario> usuarios = new ArrayList<>();
    static List<Emprestimo> emprestimos = new ArrayList<>();

    // Salvar os tres arquivos
    public static void salvar() {

        try {

            FileWriter acervo = new FileWriter("acervo.csv");

            for (Livro livro : livros) {

                acervo.write(
                    livro.getCodigo() + ";" +
                    livro.getNome() + ";" +
                    livro.getQuantidade() + "\n"
                );

            }

            acervo.close();

            FileWriter arquivoUsuarios = new FileWriter("usuarios.csv");

            for (Usuario usuario : usuarios) {

                arquivoUsuarios.write(
                    usuario.getId() + ";" +
                    usuario.getNome() + "\n"
                );

            }

            arquivoUsuarios.close();

            FileWriter arquivoEmprestimos =
                new FileWriter("emprestimos.csv");

            for (Emprestimo e : emprestimos) {

                arquivoEmprestimos.write(
                    e.getLivro().getCodigo() + ";" +
                    e.getUsuario().getId() + "\n"
                );

            }

            arquivoEmprestimos.close();

        } catch (IOException e) {

            System.out.println("Erro ao salvar os arquivos!");

        }

    }

    // Carregar os dados
    public static void carregar() {

        livros.clear();
        usuarios.clear();
        emprestimos.clear();

        try {

            // Carregar livros
            BufferedReader leitor = new BufferedReader(
                new FileReader("acervo.csv")
            );

            String linha;

            while ((linha = leitor.readLine()) != null) {

                String[] dados = linha.split(";", -1);

                if (dados.length == 3) {

                    Livro livro = new Livro(
                        dados[0],
                        dados[1],
                        Integer.parseInt(dados[2])
                    );

                    livros.add(livro);

                }

            }

            leitor.close();

        } catch (IOException e) {

            System.out.println("Acervo ainda nao existe.");

        }

        try {

            // Carregar usuarios
            BufferedReader leitor = new BufferedReader(
                new FileReader("usuarios.csv")
            );

            String linha;

            while ((linha = leitor.readLine()) != null) {

                String[] dados = linha.split(";", -1);

                if (dados.length == 2) {

                    usuarios.add(
                        new Usuario(dados[0], dados[1])
                    );

                }

            }

            leitor.close();

        } catch (IOException e) {

            System.out.println("Arquivo de usuarios ainda nao existe.");

        }

        try {

            // Carregar emprestimos e reconectar objetos
            BufferedReader leitor = new BufferedReader(
                new FileReader("emprestimos.csv")
            );

            String linha;

            while ((linha = leitor.readLine()) != null) {

                String[] dados = linha.split(";", -1);

                if (dados.length == 2) {

                    Livro livroEncontrado = null;
                    Usuario usuarioEncontrado = null;

                    // Procurar livro pelo codigo
                    for (Livro livro : livros) {

                        if (livro.getCodigo().equals(dados[0])) {
                            livroEncontrado = livro;
                            break;
                        }

                    }

                    // Procurar usuario pelo ID
                    for (Usuario usuario : usuarios) {

                        if (usuario.getId().equals(dados[1])) {
                            usuarioEncontrado = usuario;
                            break;
                        }

                    }

                    // Reconectar os objetos
                    if (livroEncontrado != null &&
                        usuarioEncontrado != null) {

                        emprestimos.add(
                            new Emprestimo(
                                livroEncontrado,
                                usuarioEncontrado
                            )
                        );

                    }

                }

            }

            leitor.close();

        } catch (IOException e) {

            System.out.println("Arquivo de emprestimos ainda nao existe.");

        }

    }

    // Cadastrar livro
    public static void cadastrarLivro(String codigo, String nome) {

        for (Livro livro : livros) {

            if (livro.getCodigo().equals(codigo)) {
                System.out.println("Codigo ja cadastrado!");
                return;
            }

        }

        livros.add(new Livro(codigo, nome, 3));

        salvar();

        System.out.println("Livro cadastrado!");

    }

    // Cadastrar usuario
    public static void cadastrarUsuario(String id, String nome) {

        for (Usuario usuario : usuarios) {

            if (usuario.getId().equals(id)) {
                System.out.println("ID ja cadastrado!");
                return;
            }

        }

        usuarios.add(new Usuario(id, nome));

        salvar();

        System.out.println("Usuario cadastrado!");

    }

    // Realizar emprestimo
    public static void emprestar(String codigo, String id) {

        Livro livroEncontrado = null;
        Usuario usuarioEncontrado = null;

        for (Livro livro : livros) {

            if (livro.getCodigo().equals(codigo)) {
                livroEncontrado = livro;
            }

        }

        for (Usuario usuario : usuarios) {

            if (usuario.getId().equals(id)) {
                usuarioEncontrado = usuario;
            }

        }

        if (livroEncontrado == null || usuarioEncontrado == null) {

            System.out.println("Livro ou usuario nao encontrado!");

            return;

        }

        if (livroEncontrado.getQuantidade() <= 0) {

            System.out.println("Livro indisponivel!");

            return;

        }

        int totalUsuario = 0;

        for (Emprestimo e : emprestimos) {

            if (e.getUsuario().getId().equals(id)) {
                totalUsuario++;
            }

        }

        if (totalUsuario >= 3) {

            System.out.println("Limite de emprestimos atingido!");

            return;

        }

        livroEncontrado.emprestar();

        emprestimos.add(
            new Emprestimo(livroEncontrado, usuarioEncontrado)
        );

        salvar();

        System.out.println("Emprestimo realizado!");

    }

    // Listar livros
    public static void listarLivros() {

        for (Livro livro : livros) {

            System.out.println(
                livro.getCodigo() + " - " +
                livro.getNome() + " - " +
                livro.getQuantidade() + " unidades"
            );

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        carregar();

        int opcao = 0;

        do {

            try {

                System.out.println("\n--- BIBLIOTECA ---");
                System.out.println("1 - Cadastrar livro");
                System.out.println("2 - Cadastrar usuario");
                System.out.println("3 - Emprestar livro");
                System.out.println("4 - Listar livros");
                System.out.println("5 - Sair");
                System.out.print("Escolha: ");

                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {

                    case 1:

                        System.out.print("Codigo: ");
                        String codigo = sc.nextLine();

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        cadastrarLivro(codigo, nome);

                        break;

                    case 2:

                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Nome: ");
                        nome = sc.nextLine();

                        cadastrarUsuario(id, nome);

                        break;

                    case 3:

                        System.out.print("Codigo do livro: ");
                        codigo = sc.nextLine();

                        System.out.print("ID do usuario: ");
                        id = sc.nextLine();

                        emprestar(codigo, id);

                        break;

                    case 4:

                        listarLivros();

                        break;

                    case 5:

                        salvar();

                        System.out.println("Dados salvos. Saindo...");

                        break;

                    default:

                        System.out.println("Opcao invalida!");

                }

            } catch (NumberFormatException e) {

                System.out.println("Digite um numero valido!");

            } catch (Exception e) {

                System.out.println("Erro: " + e.getMessage());

            }

        } while (opcao != 5);

        sc.close();

    }

}
