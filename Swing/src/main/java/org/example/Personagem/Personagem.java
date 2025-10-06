package org.example.Personagem;

public class Personagem {
    private String nome;
    private int idade;
    private String arma;
    private String descricao;

    public Personagem(String nome, int idade, String arma, String descricao) {
        this.nome = nome;
        this.idade = idade;
        this.arma = arma;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}