package com.controllers;

import com.App;
import com.jfoenix.controls.JFXComboBox;
import com.model.Production;
import com.util.Dao;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListProductionByPeriodController {

    @FXML
    private JFXComboBox<String> dataSelectorComboBox;

    @FXML
    private TableView<Production> productionTableView;

    @FXML
    private TableColumn<Production, String> eartagColumn;

    @FXML
    private TableColumn<Production, Double> productionColumn;

    private final ObservableList<Production> data = FXCollections.observableArrayList();

    String listingType;

    @FXML
    public void listByDay(){
        Dao<Production> dao = new Dao(Production.class);
        ArrayList<String> temporaryList = new ArrayList<>();
        for (Production prod : dao.listarTodos()){
            LocalDate data = LocalDate.parse(prod.getDate());
            String dia_mes_ano =  data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear();
            if (!temporaryList.contains(dia_mes_ano)){
                temporaryList.add(dia_mes_ano);
            }
        }
        dataSelectorComboBox.getItems().setAll(temporaryList);
        listingType = "ByDay";
    }

    @FXML
    public void listByMonth(){
        Dao<Production> dao = new Dao(Production.class);
        ArrayList<String> temporaryList = new ArrayList<>();
        for (Production prod : dao.listarTodos()){
            LocalDate data = LocalDate.parse(prod.getDate());
            String mes_ano = data.getMonthValue() + "/" + data.getYear();
            if (!temporaryList.contains(mes_ano)){
                temporaryList.add(mes_ano);
            }
        }
        dataSelectorComboBox.getItems().setAll(temporaryList);
        listingType = "ByMonth";
    }

    @FXML
    public void displayProduction() {
        // Configura as colunas
        eartagColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCow().getEartag()));
        productionColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getLiters()).asObject());

        data.clear();

        Dao<Production> dao = new Dao(Production.class);
        if (listingType.equals("ByDay")) {
            for (Production prod : dao.listarTodos()){
                LocalDate data = LocalDate.parse(prod.getDate());
                String dia_mes_ano =  data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear();
                if (dia_mes_ano.equals(dataSelectorComboBox.getValue())){
                    this.data.add(prod);
                }
            }
        }
        else{
            for (Production prod : dao.listarTodos()){
                LocalDate data = LocalDate.parse(prod.getDate());
                String mes_ano = data.getMonthValue() + "/" + data.getYear();
                if (mes_ano.equals(dataSelectorComboBox.getValue())){
                    this.data.add(prod);
                }
            }
        }

        productionTableView.setItems(data);
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
