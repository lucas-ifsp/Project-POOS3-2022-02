package br.edu.ifsp.poo.class03.ex01;


public class Personagem {
    private String nome;
    private static int idade;
    Dublador dublador;

    public Personagem() {
    }

    public Personagem(String nome, int idade, Dublador dublador) {
        this.nome = nome;
        this.idade = idade;
        this.dublador = dublador;
    }

    public Personagem(String nome, int idade) {
        this.nome = nome; this.idade = idade;
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

    public Dublador getDublador() {
        return dublador;
    }

    public void setDublador(Dublador dublador) {
        this.dublador = dublador;
    }
}