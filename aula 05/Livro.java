public class Livro {

    String titulo;
    String autor;
    int paginas;
    boolean disponivel;

    // Construtor
    public Livro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.disponivel = true;
    }

    // Método para emprestar o livro
    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("O livro já está emprestado.");
        }
    }

    // Método para devolver o livro
    public void devolver() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("O livro já está disponível.");
        }
    }

    // Método para exibir as informações do livro
    public void exibirFicha() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Páginas: " + paginas);
        System.out.println("Disponível: " + disponivel);
        System.out.println("-------------------------");
    }
}