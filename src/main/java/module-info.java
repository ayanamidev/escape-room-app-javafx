module com.example.escaperoomfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.escaperoomfx to javafx.fxml;
    exports com.example.escaperoomfx;
}