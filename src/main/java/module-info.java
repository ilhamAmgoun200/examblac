module org.laboratory.examblanc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens org.laboratory.examblanc to javafx.fxml;
    exports org.laboratory.examblanc;
    exports org.laboratory.examblanc.models;
    opens org.laboratory.examblanc.models to javafx.fxml;
}