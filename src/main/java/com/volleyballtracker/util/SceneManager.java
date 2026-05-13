package com.volleyballtracker.util;

import com.volleyballtracker.controller.EditStatsController;
import com.volleyballtracker.controller.GameEditorController;
import com.volleyballtracker.controller.MainMenuController;
import com.volleyballtracker.controller.NewGameController;
import com.volleyballtracker.view.EditStatsView;
import com.volleyballtracker.view.GameEditorView;
import com.volleyballtracker.view.MainMenuView;
import com.volleyballtracker.view.NewGameView;
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

            new MainMenuController(view, this);

            Scene scene = new Scene(view.getRoot(), 900, 600);
            stage.setScene(scene);
        }

        public void switchToNewGame() {
            NewGameView view = new NewGameView();

            new NewGameController(view, this);

            Scene scene = new Scene(view.getRoot(), 900, 600);
            stage.setScene(scene);
        }

        public void closeApp() {
            stage.close();
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

    /** Opens Edit Stats screen. */
    public void switchToEditStats() {
        // TODO: Load Game Editor screen.
        EditStatsView view = new EditStatsView();

        new EditStatsController(view, stage);
        Scene scene = new Scene(view.getRoot(), 900, 600);
        stage.setScene(scene);
    }

    /** Opens Export Stats screen. */
    public void switchToExportStats() {
        // TODO: Load Export Stats screen.
    }
}
