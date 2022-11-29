package br.edu.ifsp.poo.practical03.persistence;

import br.edu.ifsp.poo.practical03.model.gasto.Gasto;
import br.edu.ifsp.poo.practical03.model.gasto.GastoDao;
import br.edu.ifsp.poo.practical03.model.gasto.GastoEducacao;
import br.edu.ifsp.poo.practical03.model.gasto.GastoSaude;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GastoDAOImpl implements GastoDao {
    @Override
    public void salvar(Gasto gasto) {
        final String sql = "INSERT INTO gasto (cnpj, descricao, valor, tipo, instituicao_registro, id_declaracao) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try(final PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, gasto.getCnpj());
            stmt.setString(2, gasto.getDescricao());
            stmt.setDouble(3, gasto.getValor());
            stmt.setString(4, gasto instanceof GastoEducacao ? "EDUCACAO" : "SAUDE");
            stmt.setString(5, gasto.getInstituicaoRegistro());
            stmt.setInt(6, 2);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void atualizar(Gasto gasto) {
        final String sql = """
                UPDATE gasto SET
                cnpj = ?, descricao = ?, valor = ?, tipo = ?, instituicao_registro = ?
                WHERE id =  ?
                """;

        try(final PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, gasto.getCnpj());
            stmt.setString(2, gasto.getDescricao());
            stmt.setDouble(3, gasto.getValor());
            stmt.setString(4, gasto instanceof GastoEducacao ? "EDUCACAO" : "SAUDE");
            stmt.setString(5, gasto.getInstituicaoRegistro());
            stmt.setInt(6, gasto.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void remover(Integer id) {
        final String sql = "DELETE FROM gasto WHERE id = ?";

        try(final PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Gasto> buscarTodos() {
        final List<Gasto> gastos = new ArrayList<>();
        final String sql = "SELECT * FROM gasto";

        try(final PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            final ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                final boolean isSaude = rs.getString("tipo").equals("SAUDE");
                Gasto gasto;

                if(isSaude) {
                    gasto = new GastoSaude();
                    ((GastoSaude) gasto).setRegistroConselho(rs.getString("instituicao_registro"));
                }
                else {
                    gasto = new GastoEducacao();
                    ((GastoEducacao) gasto).setNomeInstituicao(rs.getString("instituicao_registro"));

                }
                gasto.setId(rs.getInt("id"));
                gasto.setDescricao(rs.getString("descricao"));
                gasto.setCnpj(rs.getString("cnpj"));
                gasto.setValor(rs.getDouble("valor"));
                gastos.add(gasto);
            }

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return gastos;
    }
}
