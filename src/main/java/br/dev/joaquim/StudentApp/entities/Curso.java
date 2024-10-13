public class Curso {
    private String nome;
    private String nomeProfessor;
    private String periodo;
    private int codigoCurso;

    public Curso(String nome, String nomeProfessor, String periodo, int codigoCurso) {
        this.nome = nome;
        this.nomeProfessor = nomeProfessor;
        this.periodo = periodo;
        this.codigoCurso = codigoCurso;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeProfessor() {
        return this.nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getCodigoCurso() {
        return this.codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public String toString() {
        return "Curso " + getNome() + " [Código: " + getCodigoCurso() + ", Professor: " + getNomeProfessor() + ", Período: " + getPeriodo() + "]";
    }
}