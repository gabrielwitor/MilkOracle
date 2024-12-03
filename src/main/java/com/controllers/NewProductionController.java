package com.controllers;

import com.App;
import com.jfoenix.controls.JFXComboBox;
import com.model.Cow;
import com.model.Production;
import com.util.Dao;
import com.util.Notifier;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;

public class NewProductionController {

    @FXML
    JFXComboBox<String> cowComboBox;

    @FXML
    TextField litersTextField;

    @FXML
    private DatePicker productionDate;

    @FXML
    private void initialize(){
        productionDate.setValue(LocalDate.now());

        Dao<Cow> dao = new Dao(Cow.class);
        ArrayList<String> temporaryList = new ArrayList<>();
        for (Cow cow : dao.listarTodos()){
            temporaryList.add(cow.getEartag());
        }
        cowComboBox.getItems().setAll(temporaryList);
    }

    @FXML
    public void newProduction(){

        if (litersTextField.getText().isEmpty() || cowComboBox.getValue() == null) {
            Notifier.notifywarning("Todos os campos devem estar preenchidos.");
            return;
        }

        if(!litersTextField.getText().matches("[1-9][0-9]*(.[0-9]+)?")){
            Notifier.notifyError(String.format("Quantidade de litros \"%s\" inválida!",litersTextField.getText()));
            return;
        }

        if(productionDate.getValue().isAfter(LocalDate.now())){
            Notifier.notifyError("Data inválida! Impossível cadastrar uma produção para um dia no futuro");
            return;
        }

        Dao<Cow> cowDao = new Dao<Cow>(Cow.class);
        Cow cow = cowDao.buscarPorChave("eartag", cowComboBox.getValue());

        Production production = new Production(productionDate.getValue().toString(), cow,  Double.valueOf(litersTextField.getText()));
        Dao<Production> prodDao = new Dao<Production>(Production.class);
        prodDao.inserir(production);

        Notifier.notifySuccess("O cadastro da produção ocorreu com sucesso!");

        litersTextField.clear();
        cowComboBox.setValue(null);
        productionDate.setValue(LocalDate.now());
    }

    @FXML
    public void goBack(){
        try{
            App.trocarTela("manageProductions.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
