package br.edu.ifsp.poo.practical03.model.gasto;

public class GastoEducacao extends Gasto {

    public static final double DEDUCAO_MAX_EDUCACAO = 2_000.00;

    private String nomeInstituicao;

    public GastoEducacao() {
    }

    public GastoEducacao(int id, String descricao, String cnpj, double valor, String nomeInstituicao) {
        super(id, descricao, cnpj, valor);
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public String getTipo() {
        return "Educação";
    }

    @Override
    public String getInstituicaoRegistro() {
        return nomeInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Instituição: %s ", nomeInstituicao) + " | Tipo: Educação";
    }
}
