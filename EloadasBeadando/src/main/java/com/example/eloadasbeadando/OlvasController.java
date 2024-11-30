package com.example.eloadasbeadando;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import static com.example.eloadasbeadando.SqliteConnection.Connector;

public class OlvasController implements Initializable {
    @FXML public TableView<Compiled> olvas_tablazat;
    @FXML public TableColumn<Compiled, Integer> id_column;
    @FXML public TableColumn<Compiled, String> nev_column;
    @FXML public TableColumn<Compiled, String> tipus_column;
    @FXML public TableColumn<Compiled, Integer> dijazott_column;
    @FXML public TableColumn<Compiled, Integer> ertek_column;
    @FXML public TableColumn<Compiled, String> egyseg_column;
    @FXML public TableColumn<Compiled, String> mentes_column;
    @FXML public ConnectionModel connectionModel = new ConnectionModel();

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        if (connectionModel.isDbConnected()) {
            showAdat();
        } else {

        }
    }

    public ObservableList<Compiled> getOsszAdat() {
        ObservableList<Compiled> osszadatLista = FXCollections.observableArrayList();
        Connection connection = Connector();
        String query = "select * from ar inner join suti on suti.id = ar.sutiid inner join tartalom on suti.id = tartalom.sutiid";
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

        olvas_tablazat.setItems(list);
    }
}
