module com {
    requires javafx.fxml;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires bcrypt;
    requires com.jfoenix;
    requires javafx.controls;

    // Exporta o pacote do modelo para que o MongoDB PojoCodecProvider consiga acessá-lo
    opens com to org.mongodb.bson, javafx.fxml;
    opens com.controllers to javafx.fxml;

    exports com;
    exports com.util;
    exports com.model;
    exports com.controllers;
}