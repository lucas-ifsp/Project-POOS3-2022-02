package br.edu.ifsp.poo.practical03.model.gasto;

import java.util.List;

public interface GastoDao {
    void salvar(Gasto gasto);
    void atualizar(Gasto gasto);
    void remover(Integer id);
    List<Gasto> buscarTodos();
}
