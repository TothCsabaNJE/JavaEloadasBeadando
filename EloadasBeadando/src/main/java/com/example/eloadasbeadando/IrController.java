package com.example.eloadasbeadando;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Statement;
import static com.example.eloadasbeadando.SqliteConnection.Connector;

public class IrController {
    public ConnectionModel connectionModel = new ConnectionModel();
    @FXML public TextField suti_nev_textField;
    @FXML public TextField tipus_nev_textField;
    @FXML public CheckBox dijazott_Button;
    @FXML public Button beszuras_Button;

    public void beszuras_click(ActionEvent event) {
        String query = "insert into suti values (\"null\",\"" + suti_nev_textField.getText() + "\",\"" +
                tipus_nev_textField.getText() + "\"," + dijazott_Button.isSelected() + ")";
        executeQuery(query);
    }

    private void executeQuery(String query) {
        Connection connection = Connector();
        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
