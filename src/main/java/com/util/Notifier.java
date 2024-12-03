package com.util;

import javafx.scene.control.Alert;

public class Notifier {
    public static void notifyError(String error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText("Ocorreu um erro!");
        alert.setContentText(error);
        alert.show();
    }

    public static void notifywarning(String error){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso!");
        alert.setHeaderText(null);
        alert.setContentText(error);
        alert.show();
    }

    public static void notifySuccess(String error){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tudo certo!");
        alert.setHeaderText("A operação foi um sucesso.");
        alert.setContentText(error);
        alert.show();
    }
}
