package com.controllers;

import com.App;
import javafx.fxml.FXML;

public class ManageProductionsController {
    @FXML
    public void newProduction(){
        try{
            App.trocarTela("newProduction.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void listProductionByCow(){
        try{
            App.trocarTela("listProductionByCow.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void listProductionByPeriod(){
        try{
            App.trocarTela("listProductionByPeriod.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    @FXML
    public void goBack(){
        try{
            App.trocarTela("menu.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
