package br.edu.ifsp.poo.practical02;

public class GastoSaude extends Gasto{
    public static final int VALOR_MAX_SAUDE = 1500;
    private final String registroConselho;

    public GastoSaude(int id, String descricao, double valor, String cnpj, String registroConselho) {
        super(id, descricao, valor, cnpj);
        this.registroConselho = registroConselho;
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    @Override
    public String toString() {
        return String.format("%s | Tipo = Gasto Saúde | Registro Conselho = %s"
                , super.toString(), registroConselho);
    }
}
