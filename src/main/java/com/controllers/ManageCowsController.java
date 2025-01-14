package com.controllers;

import com.App;
import javafx.fxml.FXML;

public class ManageCowsController {
    @FXML
    public void newCow(){
        try{
            App.trocarTela("newCow.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void updateCow(){
        try{
            App.trocarTela("updateCow.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteCow(){
        try{
            App.trocarTela("deleteCow.fxml");
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
