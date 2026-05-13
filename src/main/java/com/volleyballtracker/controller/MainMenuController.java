package com.volleyballtracker.controller;

import com.volleyballtracker.util.SceneManager;
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

    private final MainMenuView view;
    private final SceneManager sceneManager;

    public MainMenuController(MainMenuView view, SceneManager sceneManager) {
        this.view = view;
        this.sceneManager = sceneManager;

        connectActions();
    }

    private void connectActions() {
        view.getNewGameButton().setOnAction(event -> {
            sceneManager.switchToNewGame();
        });

        view.getExitButton().setOnAction(event -> {
            sceneManager.closeApp();
        });
    }
}
