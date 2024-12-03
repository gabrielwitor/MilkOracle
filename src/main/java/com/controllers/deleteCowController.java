package com.controllers;

import com.App;
import com.jfoenix.controls.JFXComboBox;
import com.model.Cow;
import com.model.User;
import com.util.Dao;
import com.util.Notifier;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class deleteCowController {

    @FXML
    private JFXComboBox<String> cowComboBox;

    @FXML
    private void initialize() {
        Dao<Cow> dao = new Dao<Cow>(Cow.class);
        ArrayList<String> temporaryList = new ArrayList<>();
        for (Cow cow : dao.listarTodos()){
            temporaryList.add(cow.getEartag());
        }
        cowComboBox.getItems().setAll(temporaryList);
    }

    @FXML
    public void deleteCow() {
        if (cowComboBox.getValue() == null) {
            Notifier.notifywarning("Nenhuma vaca selecionada");
            return;
        }

        Dao<Cow> dao = new Dao(Cow.class);
        dao.excluir("eartag", cowComboBox.getValue());

        Notifier.notifySuccess("A vaca foi deletada com sucesso!");

        cowComboBox.getItems().remove(cowComboBox.getValue());
        cowComboBox.setValue(null);
    }

    @FXML
    public void goBack(){
        try{
            App.trocarTela("manageCows.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
