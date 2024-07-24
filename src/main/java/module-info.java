module com.example.assignment2java {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;


    opens com.example.assignment2java to com.google.gson,javafx.fxml;
    exports com.example.assignment2java;
}