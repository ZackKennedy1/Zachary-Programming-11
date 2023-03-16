module com.example.project2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample to javafx.fxml;
    exports sample;
}