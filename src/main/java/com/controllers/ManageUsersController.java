package com.controllers;

import com.App;
import javafx.fxml.FXML;

public class ManageUsersController {

    @FXML
    public void newUser(){
        try{
            App.trocarTela("newUser.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void updateUser(){
        try{
            App.trocarTela("updateUser.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteUser(){
        try{
            App.trocarTela("deleteUser.fxml");
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
