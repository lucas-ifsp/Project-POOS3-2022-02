package br.edu.ifsp.poo.practical03.view;

import br.edu.ifsp.poo.practical03.controller.GastoController;
import br.edu.ifsp.poo.practical03.model.gasto.Gasto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static br.edu.ifsp.poo.practical03.controller.GastoController.*;
import static javafx.stage.Modality.APPLICATION_MODAL;

public class GastoView {

    public void showAndWait(){
        showAndWait(null, false);
    }

    public void showAndWait(Gasto gasto, boolean onlyView){
        FXMLLoader loader = new FXMLLoader();
        try {
            final Pane pane = loader.load(getClass().getResource("gasto.fxml").openStream());
            final GastoController controller = loader.getController();
            ViewMode mode = ViewMode.SAVE;

            if(gasto != null){
                controller.setGastoIntoView(gasto);
                mode = onlyView ? ViewMode.VIEW : ViewMode.UPDATE;
            }
            controller.configuraExibicao(mode);
            final Scene scene = new Scene(pane, 300, 400);
            final Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
