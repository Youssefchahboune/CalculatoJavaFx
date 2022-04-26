module com.example.lab10java {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab10java to javafx.fxml;
    exports com.example.lab10java;
}