package com.controllers;

import com.App;
import com.jfoenix.controls.JFXComboBox;
import com.model.Cow;
import com.util.Dao;
import com.util.Notifier;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class updateCowController {
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField eartagTextField;

    @FXML
    private TextField breedTextField;

    @FXML
    private JFXComboBox<String> cowComboBox;

    @FXML
    private void initialize() {
        Dao<Cow> dao = new Dao(Cow.class);
        ArrayList<String> temporaryList = new ArrayList<>();
        for (Cow cow : dao.listarTodos()){
            temporaryList.add(cow.getEartag());
        }
        cowComboBox.getItems().setAll(temporaryList);
    }

    @FXML
    public void updateCow(){
        if (nameTextField.getText().isEmpty() || breedTextField.getText().isEmpty() || cowComboBox.getValue() == null) {
            Notifier.notifywarning("Todos os campos devem estar preenchidos.");
            return;
        }

        // Verifica se o usuário está tentando atualizar a vaca com um brinco que já está cadastrado
        if(cowComboBox.getItems().contains(eartagTextField.getText()) && !eartagTextField.getText().equals(cowComboBox.getSelectionModel().getSelectedItem())){
            Notifier.notifyError("Já há uma vaca cadastrada com esse brinco!");
            return;
        }

        Dao<Cow> dao = new Dao(Cow.class);
        Cow cow = new Cow(eartagTextField.getText(), nameTextField.getText(), breedTextField.getText());
        dao.alterar("eartag", cowComboBox.getValue(), cow);

        Notifier.notifySuccess("A atualização do cadastro da vaca ocorreu com sucesso!");
        cowComboBox.getSelectionModel().clearSelection();
        nameTextField.clear();
        breedTextField.clear();
        eartagTextField.clear();
        initialize();
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
