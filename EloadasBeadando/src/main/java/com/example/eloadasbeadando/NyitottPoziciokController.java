package com.example.eloadasbeadando;

import com.oanda.v20.*;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.trade.Trade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NyitottPoziciokController implements Initializable {
    static Context ctx;
    static AccountID accountId;
    @FXML
    public Button mutat_button;
    @FXML
    public Label arfolyam_label;

    public void mutat_click(ActionEvent event) {
        try {
            ctx = new ContextBuilder(Config.URL).setToken(Config.TOKEN).setApplication("StepByStepOrder").build();
            accountId = Config.ACCOUNTID;
            if (true) NyitotttradekKiír();
            arfolyam_label.setText(arfolyam_label.getText() + "\n" + "Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void NyitotttradekKiír() throws ExecuteException, RequestException {
        arfolyam_label.setText(arfolyam_label.getText() + "\n" + "Nyitott tradek:");
        List<Trade> trades = ctx.trade.listOpen(accountId).getTrades();
        for (Trade trade : trades)
            arfolyam_label.setText(arfolyam_label.getText() + "\n" + trade.toString());
        for (Trade trade : trades)
            arfolyam_label.setText(arfolyam_label.getText() + "\n" + trade.getId() + "\t" + trade.getInstrument() + "\t" + trade.getOpenTime() + "\t" + trade.getCurrentUnits() + "\t" + trade.getPrice() + "\t" + trade.getUnrealizedPL());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

}
