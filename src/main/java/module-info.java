module poo{
    requires java.sql;
    requires javafx.fxml;
    requires javafx.controls;

    opens br.edu.ifsp.poo.practical03.controller;
    opens br.edu.ifsp.poo.practical03.model.declaracao;
    opens br.edu.ifsp.poo.practical03.model.gasto;
    opens br.edu.ifsp.poo.practical03.view;

}