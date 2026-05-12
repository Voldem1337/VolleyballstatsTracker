package com.volleyballtracker.view;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * MainMenuView
 *
 * Экран главного меню.
 * Здесь позже будут кнопки:
 * - New Game
 * - Open Game
 * - Export Stats
 * - Exit
 */
public class MainMenuView {
    private VBox root;

    private Button newGameButton;
    private Button openGameButton;
    private Button exitButton;


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
        root.getChildren().addAll(title,newGameButton, openGameButton, exitButton);
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
}
