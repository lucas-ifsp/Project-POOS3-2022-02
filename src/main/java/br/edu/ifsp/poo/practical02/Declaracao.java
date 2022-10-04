package br.edu.ifsp.poo.practical02;

import java.util.Objects;

public abstract class Declaracao {
    private final int id;
    private  double gastoTributavel;
    private  double valorPago;

    public Declaracao(int id, double gastoTributavel, double valorPago) {
        this.id = id;
        this.gastoTributavel = gastoTributavel;
        this.valorPago = valorPago;
    }

    public final double getValorAPagar(){
        return getValorImposto() - valorPago - getDespesaDedutivel();
    }

    public double getDespesaDedutivel(){
        return 0.0;
    }

    public abstract double getValorImposto();

    public double getGastoTributavel() {
        return gastoTributavel;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setGastoTributavel(double gastoTributavel) {
        this.gastoTributavel = gastoTributavel;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Ganho tributável = %.2f | Valor já pago = %.2f | Imposto = %.2f"
                , gastoTributavel, getValorPago(), getValorAPagar());
    }
}
