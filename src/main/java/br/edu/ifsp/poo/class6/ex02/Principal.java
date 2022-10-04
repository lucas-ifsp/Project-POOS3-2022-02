package br.edu.ifsp.poo.class6.ex02;

import java.util.Optional;

public class Principal {
    public static void main(String[] args) {
        BancoDeDados bd = new BancoDeDados();
        bd.buscaPessoaPorId(10)
                .filter(pessoa -> pessoa.getNome() != null)
                .filter(pessoa -> pessoa.getIdade() > 15)
                .map(Pessoa::getNome)
                .map(String::toUpperCase)
                .ifPresent(System.out::println);



    }
}
