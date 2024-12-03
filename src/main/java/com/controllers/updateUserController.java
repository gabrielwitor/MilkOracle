package com.controllers;

import com.App;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.model.User;
import com.util.Dao;
import com.util.GerenciadorDeSenhas;
import com.util.Notifier;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class updateUserController {

    @FXML
    TextField nameTextField;

    @FXML
    PasswordField passwordTextField;

    @FXML
    PasswordField passwordConfirmationTextField;

    @FXML
    private JFXComboBox<String> userComboBox;

    @FXML
    private JFXCheckBox administratorCheckBox;

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
    public void updateUser(){
        if (nameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty() || passwordConfirmationTextField.getText().isEmpty()) {
            Notifier.notifywarning("Todos os campos devem estar preenchidos.");
            return;
        }

        if(!passwordTextField.getText().equals(passwordConfirmationTextField.getText())){
            Notifier.notifywarning("As senhas devem ser iguais.");
            return;
        }

        // Verifica se o usuário está tentando atualizar o usuário com um nome que já está cadastrado
        if(userComboBox.getItems().contains(nameTextField.getText()) && !nameTextField.getText().equals(userComboBox.getSelectionModel().getSelectedItem())){
            Notifier.notifyError("Já há um usuário cadastrado com esse usuário!");
            return;
        }

        String role = (administratorCheckBox.isSelected() ? "admin" : "user");

        Dao<User> dao = new Dao(User.class);

        String hashSenha = GerenciadorDeSenhas.gerarHashSenha(passwordTextField.getText());
        User user = new User(nameTextField.getText(), hashSenha, role);
        dao.alterar("name", userComboBox.getValue(), user);

        Notifier.notifySuccess("A atualização do cadastro do usuário ocorreu com sucesso!");
        userComboBox.getSelectionModel().clearSelection();
        nameTextField.clear();
        passwordTextField.clear();
        passwordConfirmationTextField.clear();
        administratorCheckBox.setSelected(false);
        initialize();

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
