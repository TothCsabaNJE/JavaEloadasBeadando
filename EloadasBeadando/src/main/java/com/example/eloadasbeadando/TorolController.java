package com.example.eloadasbeadando;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static com.example.eloadasbeadando.SqliteConnection.Connector;

public class TorolController implements Initializable {
    public ConnectionModel connectionModel = new ConnectionModel();
    @FXML public Button torles_button;
    @FXML public ChoiceBox id_choiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (connectionModel.isDbConnected()) {
            getOsszAzonosito();
        } else {

        }
    }

    public void torles_click(ActionEvent event) {
        String query = "delete from ar where id = " + (int) id_choiceBox.getValue();
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

    public ArrayList<Integer> getOsszAzonosito() {
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
                azonositok = rs.getInt("id");
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
