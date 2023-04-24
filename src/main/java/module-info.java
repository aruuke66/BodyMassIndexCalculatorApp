module com.example.bodymassindexcalculatorapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.bodymassindexcalculatorapp to javafx.fxml;
    exports com.example.bodymassindexcalculatorapp;
}