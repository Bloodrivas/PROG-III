package br.edu.femass.model;

public class Aluno extends Leitor{

    private String matricula;

    public Aluno(Long codigo, String nome, String endereco, String telefone, Integer prazoMaximoDevolucao, String matricula) throws Exception {
        super(codigo, nome, endereco, telefone);
        this.matricula = matricula;
        this.getPrazoMaximoDevolucao(15);
    }

    public Aluno() {
    }

    public Aluno(String text, String text1, String text2, String text3) {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno:" +
                "matricula='" + this.matricula.toString() + '\'' + "nome='" + this.getNome().toString();
    }

    @Override
    public boolean equals(Object obj) {
        Aluno aluno = (Aluno) obj;
        if(obj == null) return false;
        return aluno.getMatricula().equals(this.matricula);
    }
}