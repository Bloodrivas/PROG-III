package br.edu.femass.model;

import java.time.LocalDate;

public class Exemplar {

    private Long codigo;
    private LocalDate dataAquisicao;

    public Exemplar(Object selectedValue){
    }

    public Exemplar(Long codigo, LocalDate dataAquisicao) {
        this.codigo = codigo;
        this.dataAquisicao = dataAquisicao;
    }

    public Exemplar(String text, String text1) {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    @Override
    public String toString() {
        return this.codigo+" "+this.dataAquisicao;
    }

    @Override
    public boolean equals(Object obj) {
        Exemplar exemplar = (Exemplar) obj;
        if (exemplar.getCodigo().equals(codigo) && exemplar.getDataAquisicao().equals(dataAquisicao)) return true;
        return false;
    }
}
