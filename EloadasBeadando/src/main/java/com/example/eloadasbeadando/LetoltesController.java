package com.example.eloadasbeadando;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import soapclient.MNBArfolyamServiceSoap;
import soapclient.MNBArfolyamServiceSoapImpl;
import java.io.PrintWriter;

public class LetoltesController {

    MNBArfolyamServiceSoapImpl impl = new MNBArfolyamServiceSoapImpl();
    MNBArfolyamServiceSoap service= impl.getCustomBindingMNBArfolyamServiceSoap();
    @FXML CheckBox cbInfo;
    @FXML CheckBox cbCurrencies;
    @FXML CheckBox cbDateInterval;
    @FXML CheckBox cbCurrentExchange;

    public void letolt(ActionEvent event) {
        try{
            PrintWriter writer=new PrintWriter("MNB.txt");
            writer.println(service.getInfo());
            writer.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void letolt2(ActionEvent event) {
        try{
            PrintWriter writer=new PrintWriter("MNB.txt");
            if(cbInfo.isSelected()){writer.println(service.getInfo());}
            if(cbCurrencies.isSelected()){writer.println(service.getCurrencies());}
            if(cbDateInterval.isSelected()){writer.println(service.getDateInterval());}
            if(cbCurrentExchange.isSelected()){writer.println(service.getCurrentExchangeRates());}
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
