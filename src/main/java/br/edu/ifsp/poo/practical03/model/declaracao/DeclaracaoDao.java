package br.edu.ifsp.poo.practical03.model.declaracao;

import java.util.Optional;

public interface DeclaracaoDao {
    void atualizar(Declaracao declaracao);
    Optional<Declaracao> buscar(Integer id);
}
