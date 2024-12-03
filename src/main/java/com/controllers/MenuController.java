package com.controllers;


import com.App;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    JFXButton manageUsersButton;

    @FXML
    public void initialize() {
        if(LoginController.getUser().getRole().equals("user")) {
            manageUsersButton.setVisible(false);
        }
    }

    @FXML
    public void manageUsers(){
        try{
            App.trocarTela("manageUsers.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void manageCows(){
        try{
            App.trocarTela("manageCows.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void manageProductions(){
        try{
            App.trocarTela("manageProductions.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void logout(){
        try{
            App.trocarTela("login.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
