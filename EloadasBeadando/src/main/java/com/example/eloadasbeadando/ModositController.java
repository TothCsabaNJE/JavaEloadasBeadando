package com.example.eloadasbeadando;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.eloadasbeadando.SqliteConnection.Connector;
public class ModositController implements Initializable {
    public ConnectionModel connectionModel = new ConnectionModel();
    @FXML public ChoiceBox<Integer> id_choiceBox;
    @FXML public TextField sutiid_textField;
    @FXML public TextField ertek_textField;
    @FXML public TextField egyseg_textField;
    @FXML public Button modositas_button;

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        if (connectionModel.isDbConnected()) {
            getOsszId();
        } else {

        }
    }
    public void modosit_click(ActionEvent event) {
        String query = "update ar set sutiid = '" + sutiid_textField.getText() + "', ertek = '" + ertek_textField.getText() + "', egyseg = '" + egyseg_textField.getText() + " Where id = " + (int) id_choiceBox.getValue();
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

    public ArrayList<Integer> getOsszId() {
        ArrayList<Integer> osszAzLista = new ArrayList<>();
        Connection connection = Connector();
        String query = "select id from ar";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            int azonositok;
            while (rs.next()) {
                azonositok = rs.getInt("az");
                osszAzLista.add(azonositok);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int var : osszAzLista) {
            id_choiceBox.getItems().add(var);
        }
        return osszAzLista;
    }
}
