package com.example.eloadasbeadando;

import com.oanda.v20.Config;
import com.oanda.v20.Context;
import com.oanda.v20.ContextBuilder;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.order.MarketOrderRequest;
import com.oanda.v20.order.OrderCreateRequest;
import com.oanda.v20.order.OrderCreateResponse;
import com.oanda.v20.primitives.InstrumentName;
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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NyitasController implements Initializable {
    static Context ctx;
    static AccountID accountId;
    @FXML
    public Button mutat_button;
    @FXML
    public Label arfolyam_label;
    @FXML

    public void mutat_click(ActionEvent event) {
        try {
            ctx = new ContextBuilder(Config.URL).setToken(Config.TOKEN).setApplication("StepByStepOrder").build();
            accountId = Config.ACCOUNTID;
            if (true) Nyitás();
            arfolyam_label.setText(arfolyam_label.getText() + "\n" + "Done");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void Nyitás() {
        arfolyam_label.setText(arfolyam_label.getText() + "\n" + "Place a Market Order");
        InstrumentName instrument = new InstrumentName("AUD_USD");
        try {
            OrderCreateRequest request = new OrderCreateRequest(accountId);
            MarketOrderRequest marketorderrequest = new MarketOrderRequest();
            marketorderrequest.setInstrument(instrument);
// Ha pozitív, akkor LONG, ha negatív, akkor SHORT:
            marketorderrequest.setUnits(-10);
            request.setOrder(marketorderrequest);
            OrderCreateResponse response = ctx.order.create(request);
            arfolyam_label.setText(arfolyam_label.getText() + "\n" + "tradeId: " + response.getOrderFillTransaction().getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
