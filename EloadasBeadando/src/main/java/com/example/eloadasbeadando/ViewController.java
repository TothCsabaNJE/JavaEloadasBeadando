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
        scene = new Scene(root, 320, 240);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    @FXML protected void menuOlvasClick(ActionEvent actionEvent) throws IOException {
        switchTo("olvas-view.fxml", "Olvas", actionEvent);
    }

    public void menuOlvas2Click(ActionEvent actionEvent) {
    }

    public void menuIrClick(ActionEvent actionEvent) {
    }

    public void menuModositClick(ActionEvent actionEvent) {
    }

    public void menuLetoltesClick(ActionEvent actionEvent) {
    }

    public void menuLetoltes2Click(ActionEvent actionEvent) {
    }

    public void menuGrafikonClick(ActionEvent actionEvent) {
    }

    public void menuSzamlaInfClick(ActionEvent actionEvent) {
    }

    public void menuAktArClick(ActionEvent actionEvent) {
    }

    public void menuHistArClick(ActionEvent actionEvent) {
    }

    public void menuPozNyitasClick(ActionEvent actionEvent) {
    }

    public void menuPozZarasClick(ActionEvent actionEvent) {
    }

    public void menuNyitottPozClick(ActionEvent actionEvent) {
    }

    @FXML void menuParhuzamosClick(ActionEvent actionEvent) throws IOException {
        switchTo("parhuzamos-view.fxml", "Parhuzamos", actionEvent);
    }
}