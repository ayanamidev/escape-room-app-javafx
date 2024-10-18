package com.example.escaperoomfx;

import javafx.fxml.FXML;
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
    @FXML
    private Label welcomeText;

    @FXML
    public void initialize() {
        /*
        Image image = new Image(String.valueOf(getClass().getResource("images/logoo.jpg")));
        logo.setImage(image);

        Rectangle clip = new Rectangle(
                logo.getFitWidth(), logo.getFitHeight()
        );
        clip.setArcWidth(30);
        clip.setArcHeight(30);
        logo.setClip(clip);*/

        Image backgroundImage = new Image(String.valueOf(getClass().getResource("images/background.jpg"))); // Cambia la ruta a tu imagen
        background.setImage(backgroundImage);
        /*
        AnchorPane.setTopAnchor(logo, 10.0);
        AnchorPane.setLeftAnchor(logo, 10.0);
        */

    }

    /*
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }*/
}