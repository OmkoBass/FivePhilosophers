module com.example.fivephilosophersgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.fivephilosophersgui to javafx.fxml;
    exports com.example.fivephilosophersgui;
}