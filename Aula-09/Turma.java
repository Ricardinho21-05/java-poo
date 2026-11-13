
public class Aluno {

    private String nome;
    private String matricula;
    private double nota;

    public Aluno(String nome, String matricula, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getNota() {
        return nota;
    }

}

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private List<Aluno> alunos = new ArrayList<>();

    // Matricular aluno
    public void matricular(Aluno aluno) {
        alunos.add(aluno);
    }

    // Buscar aluno pela matrícula
    public Aluno buscarPorMatricula(String matricula) {

        for (Aluno aluno : alunos) {

            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }

        }

        return null;
    }

    // Remover aluno pela matrícula
    public void remover(String matricula) {

        Aluno aluno = buscarPorMatricula(matricula);

        if (aluno != null) {
            alunos.remove(aluno);
        }

    }

    // Listar alunos aprovados (nota maior ou igual a 7)
    public List<Aluno> listarAprovados() {

        List<Aluno> aprovados = new ArrayList<>();

        for (Aluno aluno : alunos) {

            if (aluno.getNota() >= 7) {
                aprovados.add(aluno);
            }

        }

        return aprovados;
    }

    // Calcular média da turma
    public double calcularMediaDaTurma() {

        if (alunos.isEmpty()) {
            return 0;
        }

        double soma = 0;

        for (Aluno aluno : alunos) {
            soma += aluno.getNota();
        }

        return soma / alunos.size();
    }

}
