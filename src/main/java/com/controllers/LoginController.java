package com.controllers;



import com.App;
import com.model.User;
import com.util.Dao;
import com.util.GerenciadorDeSenhas;
import com.util.Notifier;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.lang.module.FindException;


public class LoginController {
    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwordTextField;

    private static User user;

    @FXML
    public void login(){
        if (nameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
            Notifier.notifyError("Os campos de usuário e senha devem estar preenchidos!");
            return;
        }

        Dao<User> dao = new Dao(User.class);
        user = dao.buscarPorChave("name", nameTextField.getText());

        if (user != null && GerenciadorDeSenhas.verificarSenha(passwordTextField.getText(), user.getPassword())) {
            try{
                App.trocarTela("menu.fxml");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } else{
            Notifier.notifywarning("Usuário e/ou senha incorretos!");
        }
    }

    public static User getUser() {
        return user;
    }
}
