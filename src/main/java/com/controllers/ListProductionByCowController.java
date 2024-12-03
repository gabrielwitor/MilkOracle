package com.controllers;

import com.App;
import com.jfoenix.controls.JFXComboBox;
import com.model.Cow;
import com.model.Production;
import com.util.Dao;
import com.util.Notifier;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.ArrayList;


public class ListProductionByCowController {

    @FXML
    private JFXComboBox<String> cowComboBox;

    @FXML
    private TableView<Production> productionTableView;

    @FXML
    private TableColumn<Production, String> dateColumn;

    @FXML
    private TableColumn<Production, Double> productionColumn;

    private final ObservableList<Production> data = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        Dao<Cow> cowDao = new Dao(Cow.class);
        ArrayList<String> temporaryList = new ArrayList<>();
        for (Cow v : cowDao.listarTodos()){
            temporaryList.add(v.getEartag());
        }
        cowComboBox.getItems().setAll(temporaryList);
    }

    @FXML
    public void displayProduction() {

        if(cowComboBox.getSelectionModel().getSelectedItem() == null){
            Notifier.notifywarning("Nenhuma vaca foi selecionada");
            return;
        }

        dateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate()));
        productionColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getLiters()).asObject());

        data.clear();

        Dao<Production> prodDao = new Dao<>(Production.class);
        for (Production prod : prodDao.listarTodos()){
            if(prod.getCow().getEartag().equals(cowComboBox.getValue())){
                data.add(prod);
            }
        }
        productionTableView.setItems(data);
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
