package br.edu.femass.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.now;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;

    public Emprestimo(LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, LocalDate dataDevolucao) {
        this.dataEmprestimo = now();
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(){
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    @Override
    public String toString() {
        return dataEmprestimo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}