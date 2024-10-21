package com.example.escaperoomfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class EscapeRoomApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EscapeRoomApplication.class.getResource("escape-room-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Image icon = new Image(String.valueOf(getClass().getResource("images/icon.png")), 100, 100, true, true);
        stage.getIcons().add(icon);
        stage.setTitle("Escape Room");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}