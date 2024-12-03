package com.controllers;

import com.App;
import com.jfoenix.controls.JFXComboBox;
import com.model.User;
import com.util.Dao;
import com.util.Notifier;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class deleteUserController {

    @FXML
    private JFXComboBox<String> userComboBox;

    @FXML
    private void initialize() {
        Dao<User> dao = new Dao<User>(User.class);
        ArrayList<String> temporaryList = new ArrayList<>();
        for (User user : dao.listarTodos()){
            temporaryList.add(user.getName());
        }
        userComboBox.getItems().setAll(temporaryList);
    }

    @FXML
    public void deleteUser() {
        if (userComboBox.getValue() == null) {
            Notifier.notifywarning("Nenhum usuário selecionado");
            return;
        }


        if (userComboBox.getValue().equals(LoginController.getUser().getName())) {
            Notifier.notifyError("Você não pode deletar seu próprio usuário!");
            return;
        }

        Dao<User> dao = new Dao(User.class);
        dao.excluir("name", userComboBox.getValue());

        Notifier.notifySuccess("O usuário foi deletado com sucesso!");

        userComboBox.getItems().remove(userComboBox.getValue());
        userComboBox.setValue(null);
    }

    @FXML
    public void goBack(){
        try{
            App.trocarTela("manageUsers.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
