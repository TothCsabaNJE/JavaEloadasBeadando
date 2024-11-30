package com.example.eloadasbeadando;

import com.oanda.v20.Config;
import com.oanda.v20.Context;
import com.oanda.v20.ContextBuilder;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.trade.TradeCloseRequest;
import com.oanda.v20.trade.TradeSpecifier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ZarasController implements Initializable {
    static Context ctx;
    static AccountID accountId;
    @FXML
    public Button mutat_button;
    @FXML
    public Label arfolyam_label;
    @FXML
    public TextField zar_textfield;


    public void mutat_click(ActionEvent event) {
        try {
            ctx = new ContextBuilder(Config.URL).setToken(Config.TOKEN).setApplication("StepByStepOrder").build();
            accountId = Config.ACCOUNTID;
            if (true) Zárás();
            arfolyam_label.setText(arfolyam_label.getText() + "\n" + "Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Zárás() {
        arfolyam_label.setText(arfolyam_label.getText() + "\n" + "Close a Trade");
        try {
            String tradeId = zar_textfield.getText();    // a zárni kívánt tradeId
            ctx.trade.close(new TradeCloseRequest(accountId, new TradeSpecifier(tradeId)));
            arfolyam_label.setText(arfolyam_label.getText() + "\n" + "tradeId: " + tradeId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*ctx = new ContextBuilder(Config.URL).setToken(Config.TOKEN).setApplication("StepByStepOrder").build();
        accountId = Config.ACCOUNTID;
        TransactionID tradeId = new TransactionID("25");
        try {
            ctx.trade.close(new TradeCloseRequest(accountId, new TradeSpecifier(tradeId.toString())));
        } catch (Exception e) {   throw new RuntimeException(e);   }
        //.out.println("Done");
        */
    }


}
