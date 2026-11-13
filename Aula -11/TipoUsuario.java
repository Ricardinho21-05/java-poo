
public enum TipoUsuario {

    ALUNO(3),
    PROFESSOR(5),
    FUNCIONARIO(2);

    private int limiteEmprestimos;

    TipoUsuario(int limiteEmprestimos) {
        this.limiteEmprestimos = limiteEmprestimos;
    }

    public int getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

}

public class Usuario {

    private String nome;
    private TipoUsuario tipo;
    private int emprestimosAtivos;

    public Usuario(String nome, TipoUsuario tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.emprestimosAtivos = 0;
    }

    public boolean podePegarEmprestado() {

        return emprestimosAtivos < tipo.getLimiteEmprestimos();

    }

    public void pegarEmprestado() {

        if (podePegarEmprestado()) {

            emprestimosAtivos++;

            System.out.println("Emprestimo realizado!");

        } else {

            System.out.println("Limite de emprestimos atingido!");

        }

    }

    public String getNome() {
        return nome;
    }

}
