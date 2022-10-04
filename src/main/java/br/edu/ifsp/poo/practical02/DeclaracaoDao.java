package br.edu.ifsp.poo.practical02;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DeclaracaoDao {
    private static final Map<Integer, Declaracao> db = new LinkedHashMap<>();

    public void salvar(Declaracao declaracao){
        if(declaracao == null) throw new NullPointerException("Declaração não pode ser nula");
        if(db.containsKey(declaracao.getId())) throw new EntidadeExistenteException("Entidade já cadastrada");
        db.put(declaracao.getId(), declaracao);
    }

    public void editar(Declaracao declaracao){
        if(declaracao == null) throw new NullPointerException("Declaração não pode ser nula");
        db.replace(declaracao.getId(), declaracao);
    }

    public Declaracao lerUm(int key){
     return db.get(key);
    }

    public List<Declaracao> lerTodos(){
        return new ArrayList<>(db.values());
    }

    public void remover(int key){
        db.remove(key);
    }
}
