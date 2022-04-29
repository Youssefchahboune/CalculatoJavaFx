module com.example.lab10java {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;


    opens com.example.lab10java to javafx.fxml;
    exports com.example.lab10java;
}