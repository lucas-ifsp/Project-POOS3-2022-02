package br.edu.ifsp.poo.class6.ex02;

public class Pessoa {
    private final int  idade;
    private final String nome;

    public Pessoa(int idade, String nome) {
        this.idade = idade;
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }
}
