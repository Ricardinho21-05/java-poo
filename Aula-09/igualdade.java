
import java.util.Objects;

public class Aluno {

    private String matricula;
    private String nome;

    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    // Compara os alunos pela matrícula
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Aluno outro = (Aluno) obj;

        return matricula.equals(outro.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

}

import java.util.ArrayList;
import java.util.List;

public class Igualdade {

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();

        Aluno aluno1 = new Aluno("001", "Joao");
        Aluno aluno2 = new Aluno("001", "Maria");

        alunos.add(aluno1);

        System.out.println(alunos.contains(aluno2));

        // Antes de sobrescrever equals e hashCode:
        // Resultado: false

        // Depois de sobrescrever equals e hashCode:
        // Resultado: true

    }

}
