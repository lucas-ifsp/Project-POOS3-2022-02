package br.edu.ifsp.poo.practical02;

public class DeclaracaoSimplificada extends Declaracao {

    public DeclaracaoSimplificada(int id, double gastoTributavel, double valorPago) {
        super(id, gastoTributavel, valorPago);
    }

    @Override
    public double getValorImposto() {
        return Math.max(0, (getGastoTributavel() - 22_847.88) * 0.2);
    }

    @Override
    public String toString() {
        return "Simplificada: \n" + super.toString();
    }
}
