package br.edu.femass.model;

public class Autor {

    private String nome;
    private String sobrenome;
    private String nacionalidade;

    public Autor(String nome, String sobrenome, String nacionalidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nacionalidade = nacionalidade;
    }

    public Autor() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }

    public boolean equals(Object obj){
        Autor autor = (Autor) obj;
        if(autor.getNome().equals(this.nome) && autor.getSobrenome().equals(this.sobrenome)) return true;
        return false;
    }
}