package br.edu.ifsp.poo.class7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StringReverser extends Application {

    private Button btnExecute;
    private Label labelInput;
    private Label labelResultText;
    private Label labelResultOutput;
    private TextField txtInput;
    private ControllerStringReverser ctrl = new ControllerStringReverser(this);

    @Override
    public void start(Stage stage) throws Exception {
        btnExecute = new Button("Reverse");
        labelInput = new Label("Input: ");
        txtInput = new TextField();
        labelResultText = new Label("Result: ");
        labelResultOutput = new Label("--");

        btnExecute.setOnAction(actionEvent -> ctrl.reverse());

        HBox layout = new HBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setAlignment(Pos.BASELINE_LEFT); //alinhamento dos componentes

        layout.getChildren().addAll(
                labelInput,
                txtInput,
                labelResultText,
                labelResultOutput,
                btnExecute
        );

        final Scene scene = new Scene(layout, 400, 100);
        stage.setScene(scene);
        stage.show();
    }

    public String getInput() {
        return txtInput.getText();
    }

    public void setResult(String text){
        labelResultOutput.setText(text);
    }

}
