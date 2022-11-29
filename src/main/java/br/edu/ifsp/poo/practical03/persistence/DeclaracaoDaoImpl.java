package br.edu.ifsp.poo.practical03.persistence;

import br.edu.ifsp.poo.practical03.model.declaracao.Declaracao;
import br.edu.ifsp.poo.practical03.model.declaracao.DeclaracaoCompleta;
import br.edu.ifsp.poo.practical03.model.declaracao.DeclaracaoDao;
import br.edu.ifsp.poo.practical03.model.declaracao.DeclaracaoSimplificada;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DeclaracaoDaoImpl implements DeclaracaoDao {

    @Override
    public void atualizar(Declaracao declaracao) {
        final String sql = "UPDATE declaracao SET ganho_tributavel = ?, valor_pago = ? WHERE id = ?";
        try {
            final PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql);
            stmt.setDouble(1, declaracao.getGanhoTributavel());
            stmt.setDouble(2, declaracao.getValorPago());
            stmt.setInt(3, declaracao.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Declaracao> buscar(Integer id) {
        final String sql = "SELECT * FROM declaracao WHERE id = ?";
        try{
            final PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql);
            stmt.setInt(1, id);
            final ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                final double ganhoTributavel = rs.getDouble("ganho_tributavel");
                final double valorPago = rs.getDouble("valor_pago");
                final Declaracao declaracao = rs.getString("tipo").equals("COMPLETA") ?
                        new DeclaracaoCompleta(id, ganhoTributavel, valorPago):
                        new DeclaracaoSimplificada(id, ganhoTributavel, valorPago);
                return Optional.of(declaracao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
