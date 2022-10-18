package br.edu.femass.model;

public class Professor extends Leitor{
    private String disciplina;

    public Professor(Long codigo, String nome, String endereco, String telefone, String disciplina) throws Exception{
        super(codigo, nome, endereco, telefone);
        this.disciplina = disciplina;
        setPrazoMaximoDevolucao(30);
        //proximoId();
    }

    public Professor(String disciplina) {
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "disciplina='" + disciplina + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Professor professor = (Professor) obj;
        if(obj == null) return false;
        return professor.getDisciplina().equals(this.disciplina);
    }
}