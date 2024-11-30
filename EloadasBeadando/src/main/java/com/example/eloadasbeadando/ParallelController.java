package com.example.eloadasbeadando;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class ParallelController {
    @FXML Label label1;
    @FXML Label label2;
    Timeline timeline1=new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            if(label1.getText().equals("Oda")){
                label1.setText("Vissza");
            }else{
                label1.setText("Oda");
            }
        }
    }));
    Timeline timeline2=new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            if(label2.getText().equals("Oda")){
                label2.setText("Vissza");
            }else{
                label2.setText("Oda");
            }
        }
    }));

    @FXML private void initialize() {
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();
    };
}
