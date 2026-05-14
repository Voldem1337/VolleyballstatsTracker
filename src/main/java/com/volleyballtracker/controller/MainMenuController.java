package com.volleyballtracker.controller;


import com.volleyballtracker.model.MatchFileInfo;
import com.volleyballtracker.util.SceneManager;
import com.volleyballtracker.view.MainMenuView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
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
        view.getOpenGameButton().setOnAction(event -> {
            sceneManager.switchToOpenGame();
        });

        view.getExitButton().setOnAction(event -> {
            sceneManager.closeApp();
        });
        view.getAutfillButton().setOnAction(event -> {
            Stage popup = new Stage();
            popup.setTitle("Delete match");

            Label title = new Label("Choose match to delete");
            title.setFont(Font.font("Arial", 20));


        });
    }
//    private boolean isFormValid() {
//        if (view.getMatchNameFieldString().isBlank()) {
//            showError("Missing data", "Please enter match name.");
//            return false;
//        }
//        if (view.getPlayer1FieldString().isBlank()) {
//            showError("Missing data", "Please enter Player 1 name.");
//            return false;
//        }
//
//        if (view.getPlayer2FieldString().isBlank()) {
//            showError("Missing data", "Please enter Player 2 name.");
//            return false;
//        }
//        if (view.getPositionBox1String().equals("Choose your position")) {
//            showError(
//                    "Missing player position",
//                    "Please choose a position for Player 1."
//            );
//        }
//        if (view.getPositionBox2String().equals("Choose your position")) {
//            showError(
//                    "Missing player position",
//                    "Please choose a position for Player 2."
//            );
//        }
//        return true;
//    }
}
