package br.edu.ifsp.poo.practical03.controller;

import br.edu.ifsp.poo.practical03.model.gasto.Gasto;
import br.edu.ifsp.poo.practical03.model.gasto.GastoDao;
import br.edu.ifsp.poo.practical03.model.gasto.GastoEducacao;
import br.edu.ifsp.poo.practical03.model.gasto.GastoSaude;
import br.edu.ifsp.poo.practical03.persistence.GastoDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GastoController {

    @FXML private Button btnCancelar;
    @FXML private Button btnSalvar;
    @FXML private ComboBox<String> cbTipo;
    @FXML private Label lbId;
    @FXML private TextField txtCNPJ;
    @FXML private TextField txtDescricao;
    @FXML private TextField txtInstituicaoRegistro;
    @FXML private TextField txtValor;
    private int id;

    public enum ViewMode {SAVE, VIEW, UPDATE}

    @FXML
    public void initialize(){
        ObservableList<String> types = FXCollections.observableArrayList("Saúde", "Educação");
        cbTipo.setItems(types);
    }

    public void setGastoIntoView(Gasto gasto){
        id = gasto.getId();
        lbId.setText("ID: " + id);
        txtCNPJ.setText(gasto.getCnpj());
        txtDescricao.setText(gasto.getDescricao());
        txtValor.setText(String.valueOf(gasto.getValor()));
        txtInstituicaoRegistro.setText(gasto.getInstituicaoRegistro());
        final String type = gasto instanceof GastoSaude ? "Saúde" : "Educação";
        cbTipo.getSelectionModel().select(type);
    }

    private Gasto getGastoFromView(){
        final String cnpj = txtCNPJ.getText();
        final String descricao = txtDescricao.getText();
        final double valor = Double.parseDouble(txtValor.getText());
        final String instituicaoRegistro = txtInstituicaoRegistro.getText();
        final String selectedItem = cbTipo.getSelectionModel().getSelectedItem();
        if(selectedItem.equals("Saúde"))
            return new GastoSaude(id, descricao, cnpj, valor, instituicaoRegistro);
        return new GastoEducacao(id, descricao, cnpj, valor, instituicaoRegistro);
    }

    public void configuraExibicao(ViewMode mode){
        if(mode == ViewMode.SAVE) {
            lbId.setVisible(false);
            return;
        }
        if(mode == ViewMode.UPDATE){
            btnSalvar.setText("Atualizar");
            return;
        }
        btnCancelar.setLayoutX(btnSalvar.getLayoutX());
        btnCancelar.setLayoutY(btnSalvar.getLayoutY());
        btnCancelar.setText("Fechar");
        btnSalvar.setVisible(false);

        cbTipo.setDisable(true);
        txtCNPJ.setDisable(true);
        txtDescricao.setDisable(true);
        txtValor.setDisable(true);
        txtInstituicaoRegistro.setDisable(true);
    }

    @FXML
    void cancel(ActionEvent event) {
        close();
    }

    @FXML
    void execute(ActionEvent event) {
        GastoDao dao = new GastoDAOImpl();
        if(id == 0) dao.salvar(getGastoFromView());
        else dao.atualizar(getGastoFromView());
        close();
    }

    private void close() {
        final Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
}
