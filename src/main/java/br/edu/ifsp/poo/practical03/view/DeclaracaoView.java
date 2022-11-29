package br.edu.ifsp.poo.practical03.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class DeclaracaoView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final Pane graph = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Scene scene = new Scene(graph, 783, 600);
        stage.setScene(scene);
        stage.setTitle("\u2764\u2764\u2764 Meu Querido Imposto \u2764\u2764\u2764");
        stage.show();
    }
}
