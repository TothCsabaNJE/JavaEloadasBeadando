package com.example.eloadasbeadando;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewController {

    private Stage stage=new Stage();
    private Scene scene;
    private Parent root;

    public void switchTo(String sceneString, String title, ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource(sceneString));
        stage=(Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    @FXML protected void menuOlvasClick(ActionEvent actionEvent) throws IOException {
        switchTo("olvas-view.fxml", "Olvas", actionEvent);
    }

    @FXML protected void menuOlvas2Click(ActionEvent actionEvent) throws IOException {
        switchTo("olvas2-view.fxml", "Olvas2", actionEvent);
    }

    @FXML protected void menuIrClick(ActionEvent actionEvent) throws IOException {
        switchTo("ir-view.fxml", "Ír", actionEvent);
    }

    @FXML protected void menuModositClick(ActionEvent actionEvent) throws IOException {
        switchTo("modosit-view.fxml", "Módosít", actionEvent);
    }

    @FXML protected void menuTorolClick(ActionEvent actionEvent) throws IOException {
        switchTo("torol-view.fxml", "Töröl", actionEvent);
    }

    @FXML protected void menuLetoltesClick(ActionEvent actionEvent) throws IOException {
        switchTo("letoltes-view.fxml", "Letöltés", actionEvent);
    }

    @FXML protected void menuLetoltes2Click(ActionEvent actionEvent) throws IOException {
        switchTo("letoltes2-view.fxml", "Letöltés 2", actionEvent);
    }

    @FXML protected void menuGrafikonClick(ActionEvent actionEvent) throws IOException {
        switchTo("grafikon-view.fxml", "Grafikon", actionEvent);
    }

    @FXML protected void menuSzamlaInfClick(ActionEvent actionEvent) throws IOException {
        switchTo("szamlainfo-view.fxml", "Számlainfó", actionEvent);
    }

    @FXML protected void menuAktArClick(ActionEvent actionEvent) throws IOException {
        switchTo("aktualis-arak-view.fxml", "Aktuális árak", actionEvent);
    }

    @FXML protected void menuHistArClick(ActionEvent actionEvent) throws IOException {
        switchTo("historikus-arak-view.fxml", "Historikus árak", actionEvent);
    }

    @FXML protected void menuPozNyitasClick(ActionEvent actionEvent) throws IOException {
        switchTo("nyitas-view.fxml", "Nyitás", actionEvent);
    }

    @FXML protected void menuPozZarasClick(ActionEvent actionEvent) throws IOException {
        switchTo("zaras-view.fxml", "Zárás", actionEvent);
    }

    @FXML protected void menuNyitottPozClick(ActionEvent actionEvent) throws IOException {
        switchTo("nyitott-poziciok-view.fxml", "Nyitott pozíciók", actionEvent);
    }

    @FXML void menuParhuzamosClick(ActionEvent actionEvent) throws IOException {
        switchTo("parhuzamos-view.fxml", "Parhuzamos", actionEvent);
    }

}