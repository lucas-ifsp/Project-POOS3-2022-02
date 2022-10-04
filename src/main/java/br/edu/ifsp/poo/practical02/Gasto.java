package br.edu.ifsp.poo.practical02;

import java.util.Objects;

public abstract class Gasto {
    private final int id;
    private final String descricao;
    private final double valor;
    private final String cnpj;

    public Gasto(int id, String descricao, double valor, String cnpj) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gasto gasto = (Gasto) o;
        return id == gasto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("ID = %d | CNPJ = %s | Descrição = %s | Valor = %.2f",
                id, cnpj, descricao, valor);
    }
}
