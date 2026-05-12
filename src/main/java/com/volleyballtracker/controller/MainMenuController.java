package com.volleyballtracker.controller;

import com.volleyballtracker.view.MainMenuView;
import javafx.stage.Stage;

/**
 * Controller for Main Menu screen.
 *
 * Screen buttons:
 * - New Game
 * - Open Game
 * - Export Stats
 * - Exit
 */
public class MainMenuController {
    private MainMenuView view;
    private Stage stage;

    public MainMenuController(MainMenuView view, Stage stage) {
        this.view = view;
        this.stage = stage;
        connectActions();

    }

    private void connectActions(){
        view.getNewGameButton().setOnAction(event -> {
            System.out.println("New game clicked");
        });
        view.getOpenGameButton().setOnAction(event -> {
            System.out.println("Oppen game");
        });
        view.getExitButton().setOnAction(event -> {
            stage.close();
        });
    }
}
