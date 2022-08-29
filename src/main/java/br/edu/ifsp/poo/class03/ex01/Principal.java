package br.edu.ifsp.poo.class03.ex01;

public class Principal {
    public static void main(String[] args) {
        Personagem personagem = new Personagem();
        personagem.setNome("Pikachu");
        personagem.setIdade(3);

        Personagem outroPersonagem = new Personagem();
        outroPersonagem.setNome("Pikaralho");
        outroPersonagem.setIdade(5);

        printCoisas(personagem);

//        Dublador dublador = new Dublador("Vitor", 321);
//
//        dublador.setPersonagem(personagem);
//
//        System.out.println(personagem.getDublador());
//        System.out.println( dublador.getPersonagem().getNome());
    }

    private static void printCoisas(Personagem personagem) {
        System.out.println(personagem.getNome());
        System.out.println(personagem.getIdade());
    }
}
