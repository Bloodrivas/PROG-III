package br.edu.femass.model;

import java.util.List;

public class Leitor {

    private static Long codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private Integer prazoMaximoDevolucao;
    private static Long proximoCodigo = 1L;

    public Leitor(Long codigo, String nome, String endereco, String telefone) throws Exception {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        proximoCodigo++;
    }

    public Leitor(){
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getPrazoMaximoDevolucao(int i) {
        return prazoMaximoDevolucao;
    }

    public void setPrazoMaximoDevolucao(Integer prazoMaximoDevolucao) {
        this.prazoMaximoDevolucao = prazoMaximoDevolucao;
    }

    @Override
    public String toString() {
        return "Leitor{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", prazoMaximoDevolucao=" + prazoMaximoDevolucao +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Leitor leitor = (Leitor) obj;
        if(obj == null) return false;
        return leitor.getCodigo().equals(this.codigo);
    }

    public static void atualizarProximoNumero(List<Leitor> leitores){
        for(Leitor leitor: leitores){
            if(leitor.getCodigo()>proximoCodigo){
                proximoCodigo = leitor.getCodigo()+1;
            }
        }
    }






}