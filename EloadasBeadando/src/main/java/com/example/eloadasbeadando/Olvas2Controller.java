package com.example.eloadasbeadando;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import static com.example.eloadasbeadando.SqliteConnection.Connector;

public class Olvas2Controller implements Initializable {
    public ConnectionModel connectionModel = new ConnectionModel();
    @FXML public TableView<Compiled> olvas2_tablazat;
    @FXML public TableColumn<Compiled, Integer> id_column;
    @FXML public TableColumn<Compiled, String> nev_column;
    @FXML public TableColumn<Compiled, String> tipus_column;
    @FXML public TableColumn<Compiled, Integer> dijazott_column;
    @FXML public TableColumn<Compiled, Integer> ertek_column;
    @FXML public TableColumn<Compiled, String> egyseg_column;
    @FXML public TableColumn<Compiled, String> mentes_column;

    @FXML public TextField sutinev_textField;
    @FXML public ChoiceBox<String> tipus_ChoiceBox;
    @FXML public CheckBox dijazott_checkBox;

    @FXML public RadioButton rud_radioButton;
    @FXML public RadioButton koszoru_radioButton;
    @FXML public RadioButton kg_radioButton;
    @FXML public RadioButton db_radioButton;
    @FXML public RadioButton szel8_radioButton;
    @FXML public RadioButton szel12_radioButton;
    @FXML public RadioButton szel16_radioButton;
    @FXML public RadioButton szel20_radioButton;
    @FXML public RadioButton szel24_radioButton;

    @FXML public Button keres_Button;

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        if (connectionModel.isDbConnected()) {
            ToggleGroup radioGroup = new ToggleGroup();
            rud_radioButton.setToggleGroup(radioGroup);
            koszoru_radioButton.setToggleGroup(radioGroup);
            kg_radioButton.setToggleGroup(radioGroup);
            db_radioButton.setToggleGroup(radioGroup);
            szel8_radioButton.setToggleGroup(radioGroup);
            szel12_radioButton.setToggleGroup(radioGroup);
            szel16_radioButton.setToggleGroup(radioGroup);
            szel20_radioButton.setToggleGroup(radioGroup);
            szel24_radioButton.setToggleGroup(radioGroup);
            getOsszTipus();
        } else {

        }
    }

    public void handledButtonAction(ActionEvent event) {
        showAdat();
    }

    public void getOsszTipus() {
        ArrayList<String> osszTipusLista = new ArrayList<>(new HashSet<>());
        Connection connection = Connector();
        String query = "select tipus from suti";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            String tipus;
            while (rs.next()) {
                tipus = rs.getString("tipus");
                osszTipusLista.add(tipus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashSet<String> hashSetNumbers
                = new HashSet<String>(osszTipusLista);

        for (String var : hashSetNumbers) {
            tipus_ChoiceBox.getItems().add(var);
        }
    }

    public ObservableList<Compiled> getOsszAdat() {
        String egyseg = null;
        if (rud_radioButton.isSelected()) {
            egyseg = "rúd";
        }
        if (koszoru_radioButton.isSelected()) {
            egyseg = "koszorú";
        }
        if( kg_radioButton.isSelected()) {
            egyseg = "kg";
        }
        if (db_radioButton.isSelected()) {
            egyseg = "db";
        }
        if (szel8_radioButton.isSelected()) {
            egyseg = "8 szeletes";
        }
        if (szel12_radioButton.isSelected()) {
            egyseg = "12 szeletes";
        }
        if (szel16_radioButton.isSelected()) {
            egyseg = "16 szeletes";
        }
        if (szel20_radioButton.isSelected()) {
            egyseg = "20 szeletes";
        }
        if (szel24_radioButton.isSelected()) {
            egyseg = "24 szeletes";
        }
        ObservableList<Compiled> osszadatLista = FXCollections.observableArrayList();
        Connection connection = Connector();
        String query = "select * from ar inner join suti on suti.id = ar.sutiid inner join tartalom on suti.id = tartalom.sutiid" +
                "where suti.nev = \"" + sutinev_textField.getText() + "\" and suti.tipus = " + tipus_ChoiceBox.getValue() +
                " and suti.dijazott = " + dijazott_checkBox.isSelected() + " and egyseg = \"" + egyseg + "\"";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Compiled mindenadat;
            while (rs.next()) {
                mindenadat = new Compiled(rs.getInt("id"), rs.getString("nev"),
                        rs.getString("tipus"),rs.getInt("dijazott"), rs.getInt("ertek"),
                        rs.getString("egyseg"), rs.getString("mentes") );
                osszadatLista.add(mindenadat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return osszadatLista;
    }

    public void showAdat(){
        ObservableList<Compiled> list=getOsszAdat();
        id_column.setCellValueFactory(new PropertyValueFactory<Compiled, Integer>("id"));
        nev_column.setCellValueFactory(new PropertyValueFactory<Compiled, String>("nev"));
        tipus_column.setCellValueFactory(new PropertyValueFactory<Compiled, String>("tipus"));
        dijazott_column.setCellValueFactory(new PropertyValueFactory<Compiled, Integer>("dijazott"));
        ertek_column.setCellValueFactory(new PropertyValueFactory<Compiled, Integer>("ertek"));
        egyseg_column.setCellValueFactory(new PropertyValueFactory<Compiled, String>("egyseg"));
        mentes_column.setCellValueFactory(new PropertyValueFactory<Compiled, String>("mentes"));

        olvas2_tablazat.setItems(list);
    }
}
