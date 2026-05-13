package com.volleyballtracker.util;

import com.volleyballtracker.controller.GameEditorController;
import com.volleyballtracker.controller.MainMenuController;
import com.volleyballtracker.view.GameEditorView;
import com.volleyballtracker.view.MainMenuView;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Utility class for switching JavaFX scenes.
 */
public class SceneManager {
    private final Stage stage;

    public SceneManager(Stage stage) {
        this.stage = stage;
    }

    public void switchToMainMenu() {
        MainMenuView view = new MainMenuView();
        new MainMenuController(view,stage);

        Scene scene = new Scene(view.getRoot(),900,600);
        stage.setScene(scene);



        // TODO: Load Main Menu screen.
    }

    /** Opens New Game screen. */
    public void switchToNewGame() {
        // TODO: Load New Game screen.
    }

    /** Opens Open Game screen. */
    public void switchToOpenGame() {
        // TODO: Load Open Game screen.
    }

    /** Opens Game Editor screen. */
    public void switchToGameEditor() {
        // TODO: Load Game Editor screen.
        GameEditorView view = new GameEditorView();
        new GameEditorController(view, stage);
        Scene scene = new Scene(view.getRoot(), 900, 600);
        stage.setScene(scene);

    }

    /** Opens Export Stats screen. */
    public void switchToExportStats() {
        // TODO: Load Export Stats screen.
    }
}
