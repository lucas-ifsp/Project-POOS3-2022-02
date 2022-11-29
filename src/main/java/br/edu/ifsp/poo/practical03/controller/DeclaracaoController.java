package br.edu.ifsp.poo.practical03.controller;

import br.edu.ifsp.poo.practical03.model.declaracao.DeclaracaoCompleta;
import br.edu.ifsp.poo.practical03.model.declaracao.DeclaracaoDao;
import br.edu.ifsp.poo.practical03.model.declaracao.DeclaracaoSimplificada;
import br.edu.ifsp.poo.practical03.model.gasto.Gasto;
import br.edu.ifsp.poo.practical03.model.gasto.GastoDao;
import br.edu.ifsp.poo.practical03.persistence.DeclaracaoDaoImpl;
import br.edu.ifsp.poo.practical03.persistence.GastoDAOImpl;
import br.edu.ifsp.poo.practical03.view.GastoView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class DeclaracaoController {

    @FXML private TableView<Gasto> tabela;
    @FXML private TableColumn<Gasto, Integer> cID;
    @FXML private TableColumn<Gasto, String> cDescricao;
    @FXML private TableColumn<Gasto, Double> cValor;
    @FXML private TableColumn<Gasto, String> cCnpj;
    @FXML private TableColumn<Gasto, String> cInstituicaoRegistro;
    @FXML private TableColumn<Gasto, String> cTipo;
    @FXML private TextField txtGanhoTributavel;
    @FXML private TextField txtValorPago;
    @FXML private Label lbPagarSimplificada;
    @FXML private Label lbPagarCompleta;

    private ObservableList<Gasto> gastosTabela;
    private DeclaracaoCompleta completa;
    private DeclaracaoSimplificada simplificada;

    @FXML
    private void initialize(){
        associarColunasAPropriedades();
        associarTabelaAFonteDeDados();
        carregarDeclaracoes();
        carregarGastos();
        exibirImposto();
    }

    private void associarColunasAPropriedades() {
        cID.setCellValueFactory(new PropertyValueFactory<>("id"));
        cDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        cValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        cCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        cInstituicaoRegistro.setCellValueFactory(new PropertyValueFactory<>("instituicaoRegistro"));
        cTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    }

    private void associarTabelaAFonteDeDados() {
        gastosTabela = FXCollections.observableArrayList();
        tabela.setItems(gastosTabela);
    }

    private void carregarDeclaracoes() {
        DeclaracaoDao dao = new DeclaracaoDaoImpl();
        completa = (DeclaracaoCompleta) dao.buscar(1).orElseThrow();
        simplificada = (DeclaracaoSimplificada) dao.buscar(2).orElseThrow();
        txtGanhoTributavel.setText(String.valueOf(completa.getGanhoTributavel()));
        txtValorPago.setText(String.valueOf(completa.getValorPago()));
    }

    private void carregarGastos() {
        GastoDao dao = new GastoDAOImpl();
        final List<Gasto> gastos = dao.buscarTodos();
        gastosTabela.clear();
        completa.clearGastos();
        gastos.forEach(completa::addGasto);
        gastosTabela.setAll(gastos);

    }

    private void exibirImposto() {
        lbPagarSimplificada.setText(String.format("%.2f", simplificada.getValorAPagar()));
        lbPagarCompleta.setText(String.format("%.2f",completa.getValorAPagar()));
    }

    public void adicionarGasto(ActionEvent unused) {
        final GastoView gastoView = new GastoView();
        gastoView.showAndWait();
        carregarGastos();
    }

    public void editarGasto(ActionEvent unused) {
        final Gasto possivelGasto = tabela.getSelectionModel().getSelectedItem();
        if(possivelGasto != null){
            final GastoView gastoView = new GastoView();
            gastoView.showAndWait(possivelGasto, false);
            carregarGastos();
        }
    }

    public void visualizarGasto(ActionEvent unused) {
        final Gasto possivelGasto = tabela.getSelectionModel().getSelectedItem();
        if(possivelGasto != null){
            final GastoView gastoView = new GastoView();
            gastoView.showAndWait(possivelGasto, true);
        }
    }

    public void removerGasto(ActionEvent unused) {
        final Gasto possivelGasto = tabela.getSelectionModel().getSelectedItem();
        if(possivelGasto != null){
            GastoDao dao = new GastoDAOImpl();
            dao.remover(possivelGasto.getId());
            carregarGastos();
        }
    }

    public void atualizarDeclaracoes(ActionEvent unused) {
        final double renda = Double.parseDouble(txtGanhoTributavel.getText());
        final double pago = Double.parseDouble(txtValorPago.getText());

        completa.setGanhoTributavel(renda);
        completa.setValorPago(pago);
        simplificada.setGanhoTributavel(renda);
        simplificada.setValorPago(pago);

        DeclaracaoDao dao = new DeclaracaoDaoImpl();
        dao.atualizar(completa);
        dao.atualizar(simplificada);

        exibirImposto();
    }
}
