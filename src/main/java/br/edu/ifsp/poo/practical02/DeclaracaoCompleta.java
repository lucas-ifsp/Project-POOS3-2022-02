package br.edu.ifsp.poo.practical02;

import java.util.ArrayList;
import java.util.List;

public class DeclaracaoCompleta extends Declaracao{
    private final List<Gasto> gastos = new ArrayList<>();

    public DeclaracaoCompleta(int id, double gastoTributavel, double valorPago) {
        super(id, gastoTributavel, valorPago);
    }

    @Override
    public double getDespesaDedutivel() {
        double totalSaude = 0;
        double totalEducacao = 0;
        for (Gasto gasto : gastos) {
            if(gasto instanceof GastoSaude) totalSaude += gasto.getValor();
            else totalEducacao += gasto.getValor();
        }
        return Math.min(GastoEducacao.VALOR_MAX_EDUCACAO, totalEducacao) +
                Math.min(GastoSaude.VALOR_MAX_SAUDE, totalSaude);
    }

    @Override
    public double getValorImposto() {
        double aPagar = 0;
        double aCalcular = getGastoTributavel();

        if(aCalcular > 55_976.16){
            aPagar += (aCalcular - 55_976.16) * 0.275;
            aCalcular = 55_976.16;
        }
        if(aCalcular > 45_012.73){
            aPagar += (aCalcular - 45_012.73) * 0.225;
            aCalcular = 45_012.73;
        }
        if(aCalcular > 33_919.93){
            aPagar += (aCalcular - 33_919.93) * 0.15;
            aCalcular = 33_919.93;
        }
        if(aCalcular > 22_847.88){
            aPagar += (aCalcular - 22_847.88) * 0.075;
        }
        return aPagar;
    }

    public void addGasto(Gasto gasto){
        gastos.add(gasto);
    }

    public Gasto getGasto(int id){
        for (Gasto gasto : gastos) {
            if(gasto.getId() == id) return gasto;
        }
        return null;
    }

    public void removeGasto(Gasto gasto){
        gastos.remove(gasto);
    }

    public void removeGasto(int id){
        for (Gasto gasto : gastos) {
            if(gasto.getId() == id){
                removeGasto(gasto);
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Completa: \n").append(super.toString());
        sb.append("\nDeduções:").append("\n");
        for (Gasto gasto : gastos) {
            sb.append(gasto).append("\n");
        }
        return sb.toString();
    }
}
