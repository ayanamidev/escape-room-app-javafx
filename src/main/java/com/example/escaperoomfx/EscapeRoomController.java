package com.example.escaperoomfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class EscapeRoomController {
    public ImageView background;
    public Label numberOfAttempts;
    public Button tryButton;
    public TextField textField;
    public Label feedback;

    int numAttemps=6;
    int secretNumber;
    boolean guessed = false;

    @FXML
    public void initialize() {

        Image backgroundImage = new Image(String.valueOf(getClass().getResource("images/background.jpg")));
        background.setImage(backgroundImage);

        numberOfAttempts.setText(String.valueOf(numAttemps));
        Random random = new Random();
        secretNumber = random.nextInt(100)+1;

        System.out.println(secretNumber);
            tryButton.setDisable(true);
            //Method to prevent the tryButton from being pressed if the textField is empty.
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                tryButton.setDisable(newValue.trim().isEmpty() || !isNumeric(newValue));
            });


    }

    private boolean isNumeric(String newValue) {
        try {
            Integer.parseInt(newValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void onTryButtonClick(ActionEvent actionEvent) {

        numAttemps--;
        numberOfAttempts.setText(String.valueOf(numAttemps));

        if (numAttemps<=0){
            tryButton.setDisable(true);

        }

        int inputNumber = Integer.parseInt(textField.getText());
        textField.clear();
        if (inputNumber>secretNumber){
            feedback.setText("El número secreto es menor");
        } else if (inputNumber<secretNumber) {
            feedback.setText("El número secreto es mayor ");
        } else {
            feedback.setText("Has acertado en "+(6-numAttemps)+" intentos.");
            tryButton.setDisable(true);
            guessed = true;

        }


        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (tryButton.isDisabled()) return;

            tryButton.setDisable(newValue.trim().isEmpty() || numAttemps <= 0 || guessed);
        });

    }
}