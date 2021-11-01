package com.example.fivephilosophersgui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FivePhilosophers extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FivePhilosophers.class.getResource("FivePhilosophers.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        stage.setOnCloseRequest((ae) -> {
            Platform.exit();
            System.exit(0);
        });

        stage.setTitle("Five Philosophers!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}