package com.example.escaperoomfx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

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

        Image backgroundImage = new Image(String.valueOf(getClass().getResource("images/bg2.jpg")));
        background.setImage(backgroundImage);

        Random random = new Random();
        secretNumber = random.nextInt(100)+1;

        System.out.println(secretNumber);
        tryButton.setDisable(true);

            //Method to prevent the tryButton from being pressed if the textField is empty.
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            tryButton.setDisable(newValue.trim().isEmpty() || !isNumeric(newValue)||numAttemps<=0||guessed);
        });
    }

    //Compruebo que el valor de textfield es un numero que se entre 1 y 100
    private boolean isNumeric(String newValue) {
        try {
            int value= Integer.parseInt(newValue);

            if (value>0&&value<=100) {
                return true;
            }else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void onTryButtonClick(ActionEvent actionEvent) {

        numAttemps--;
        numberOfAttempts.setText("Intentos restantes: "+ numAttemps);


        int inputNumber = Integer.parseInt(textField.getText());
        textField.clear();
        int difference= Math.abs(secretNumber - inputNumber);

        if (inputNumber>secretNumber){
            feedback.setText("El número secreto es menor");
        } else if (inputNumber<secretNumber) {
            feedback.setText("El número secreto es mayor ");
        } else {
            feedback.setText("Has encontrado el número secreto en "+(6-numAttemps)+" intentos.");
            tryButton.setDisable(true);
            guessed = true;

        }
        if (guessed){
            feedback.setTextFill(Color.BROWN);
            feedback.setStyle("-fx-font-size: 20px;-fx-font-family: 'Tahoma';-fx-font-weight: bold;");
        }else {
            if (difference >= 20) {
                feedback.setTextFill(Color.BLUE);
            } else if (difference >= 10) {
                feedback.setTextFill(Color.ORANGE);
            } else {
                feedback.setTextFill(Color.RED);
            }
        }
    }
}