package br.edu.ifsp.poo.practical02;

public class GastoEducacao extends Gasto{
    public static final int VALOR_MAX_EDUCACAO = 2000;
    private final String nomeInstituicao;

    public GastoEducacao(int id, String descricao, double valor, String cnpj, String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    @Override
    public String toString() {
        return String.format("%s | Tipo = Gasto Educação | Nome Instituição = %s"
                , super.toString(), nomeInstituicao);
    }
}
