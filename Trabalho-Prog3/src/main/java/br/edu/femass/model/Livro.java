package br.edu.femass.model;

public class Livro {

    private Long codigo;
    private String titulo;

    private String autor;
    private String ano;

    public Livro(){
    }

    public Livro(Long codigo, String titulo, String autor, String ano){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public Livro(String text, String text1, String text2, String text3) {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Livro livro = (Livro) obj;
        if(obj == null) return false;
        return livro.getCodigo().equals(codigo);
    }

    public String getAutor() {
        return autor;
    }

    public String getAno() {
        return ano;
    }
}
