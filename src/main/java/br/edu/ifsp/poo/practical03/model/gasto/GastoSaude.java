package br.edu.ifsp.poo.practical03.model.gasto;

public class GastoSaude extends Gasto {

    public static final double DEDUCAO_MAX_SAUDE = 1_500.00;
    private String registroConselho;

    public GastoSaude() {
    }

    public GastoSaude(int id, String descricao, String cnpj, double valor, String registroConselho) {
        super(id, descricao, cnpj, valor);
        this.registroConselho = registroConselho;
    }

    @Override
    public String getTipo() {
        return "Saúde";
    }

    @Override
    public String getInstituicaoRegistro() {
        return registroConselho;
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    public void setRegistroConselho(String registroConselho) {
        this.registroConselho = registroConselho;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Registro no Conselho: %s ", registroConselho) + " | Tipo: Saúde";
    }
}
