package com.example.escaperoomfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class EscapeRoomController {
    public ImageView logo;
    public ImageView background;
    public StackPane logoContainer;
    public AnchorPane logoPosition;
    public Label numberOfAttempts;
    public Button tryButton;
    @FXML
    private Label welcomeText;
    int numAttemps=6;

    @FXML
    public void initialize() {
        /*
        Image image = new Image(String.valueOf(getClass().getResource("images/logo.jpg")));
        logo.setImage(image);

        Rectangle clip = new Rectangle(
                logo.getFitWidth(), logo.getFitHeight()
        );
        clip.setArcWidth(30);
        clip.setArcHeight(30);
        logo.setClip(clip);
        */

        Image backgroundImage = new Image(String.valueOf(getClass().getResource("images/background.jpg"))); // Cambia la ruta a tu imagen
        background.setImage(backgroundImage);

        numberOfAttempts.setText(String.valueOf(numAttemps));
        /*
        AnchorPane.setTopAnchor(logo, 15.0);
        AnchorPane.setLeftAnchor(logo, 15.0);
        */

    }

    public void onTryButtonClick(ActionEvent actionEvent) {

        numAttemps--;
        numberOfAttempts.setText(String.valueOf(numAttemps));

        if (numAttemps<=0){
            tryButton.setDisable(true);
        }

    }

    /*
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }*/
}