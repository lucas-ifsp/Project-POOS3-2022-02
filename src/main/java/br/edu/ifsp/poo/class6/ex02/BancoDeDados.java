package br.edu.ifsp.poo.class6.ex02;

import java.util.Optional;

public class BancoDeDados {

    public Optional<Pessoa> buscaPessoaPorId(long id){
        //algum select legal de banco;
        return Optional.ofNullable(new Pessoa(16, "Jao"));

    }
}
