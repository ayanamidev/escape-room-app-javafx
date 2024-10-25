package com.example.escaperoomfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class EscapeRoomController {
    public ImageView background;
    public Label numberOfAttempts;
    public Button tryButton;

    int numAttemps=6;
    int secretNumber;

    @FXML
    public void initialize() {

        Image backgroundImage = new Image(String.valueOf(getClass().getResource("images/background.jpg")));
        background.setImage(backgroundImage);

        numberOfAttempts.setText(String.valueOf(numAttemps));

        Random random = new Random();
        secretNumber = random.nextInt(100)+1;

        System.out.println(secretNumber);
    }

    public void onTryButtonClick(ActionEvent actionEvent) {

        numAttemps--;
        numberOfAttempts.setText(String.valueOf(numAttemps));

        if (numAttemps<=0){
            tryButton.setDisable(true);
        }

    }
}