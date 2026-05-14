package com.volleyballtracker.view;

import com.volleyballtracker.controller.MainMenuController;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class MainMenuView {
    private VBox root;
    private Button newGameButton;
    private Button openGameButton;
    private Button exitButton;
    private Button autfillButton;


    public MainMenuView() {
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        Label title = new Label("Volleyball Stats Tracker");
        title.setFont(Font.font("Arial", 28));

        newGameButton = new Button("New Game");
        openGameButton = new Button("Open Game");
        exitButton = new Button("Exit");
        newGameButton.setPrefWidth(200);
        openGameButton.setPrefWidth(200);
        exitButton.setPrefWidth(200);
        autfillButton = new Button("Autofill Edit");
        autfillButton.setPrefWidth(200);


        root.getChildren().addAll(title,newGameButton, openGameButton, autfillButton, exitButton);
    }

    public Parent getRoot() {
        return root;
    }

    public Button getNewGameButton() {
        return newGameButton;
    }

    public Button getOpenGameButton() {
        return openGameButton;
    }

    public Button getExitButton() {
        return exitButton;
    }

    public Button getAutfillButton() {
        return autfillButton;
    }
}
