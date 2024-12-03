package com.controllers;

import com.App;
import com.model.Cow;
import com.model.User;
import com.util.Dao;
import com.util.Notifier;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class NewCowController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField eartagTextField;

    @FXML
    private TextField breedTextField;


    @FXML
    public void register(){
        if (nameTextField.getText().isEmpty() || eartagTextField.getText().isEmpty() || breedTextField.getText().isEmpty()) {
            Notifier.notifywarning("Todos os campos devem estar preenchidos.");
            return;
        }

        Dao<Cow> dao = new Dao<Cow>(Cow.class);

        Cow cow = dao.buscarPorChave("eartag", eartagTextField.getText());

        if(cow != null){
            Notifier.notifyError("Já existe uma vaca cadastrada com esse brinco!");
            return;
        }

        cow = new Cow(eartagTextField.getText(), nameTextField.getText(), breedTextField.getText());
        dao.inserir(cow);
        Notifier.notifySuccess("O cadastro da vaca ocorreu com sucesso!");

        nameTextField.clear();
        eartagTextField.clear();
        breedTextField.clear();
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
