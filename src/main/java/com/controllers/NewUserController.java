package com.controllers;

import com.App;
import com.jfoenix.controls.JFXCheckBox;
import com.model.User;
import com.util.Dao;
import com.util.GerenciadorDeSenhas;
import com.util.Notifier;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class NewUserController {

    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private PasswordField passwordConfirmationTextField;

    @FXML
    private JFXCheckBox administratorCheckBox;

    @FXML
    public void signup(){
        if (nameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty() || passwordConfirmationTextField.getText().isEmpty()) {
            Notifier.notifywarning("Todos os campos devem estar preenchidos.");
            return;
        }

        if(!passwordTextField.getText().equals(passwordConfirmationTextField.getText())){
            Notifier.notifywarning("As senhas devem ser iguais.");
            return;
        }

        Dao<User> dao = new Dao(User.class);

        User user = dao.buscarPorChave("name", nameTextField.getText());
        if(user != null){
            Notifier.notifyError("Já existe um usuário com esse nome!");
            return;
        }

        String hashSenha = GerenciadorDeSenhas.gerarHashSenha(passwordTextField.getText());

        String role = (administratorCheckBox.isSelected() ? "admin" : "user");

        user = new User(nameTextField.getText(), hashSenha, role);
        dao.inserir(user);

        Notifier.notifySuccess("O cadastro do usuário ocorreu com sucesso!");
        nameTextField.clear();
        passwordTextField.clear();
        passwordConfirmationTextField.clear();
        administratorCheckBox.setSelected(false);
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

