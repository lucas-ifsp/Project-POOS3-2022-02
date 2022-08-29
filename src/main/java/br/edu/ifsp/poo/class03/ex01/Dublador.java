package br.edu.ifsp.poo.class03.ex01;

public class Dublador {
    private String nome;
    private int registroProfissional;
    private Personagem personagem;

    public Dublador(String nome, int registroProfissional) {
        this.nome = nome; this.registroProfissional = registroProfissional;
    }
    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
        this.personagem.setDublador(this);
    }

    public void setNome(String nome){
        if(nome == null || nome.equals("")) return;
        this.nome = nome;
    }


}

