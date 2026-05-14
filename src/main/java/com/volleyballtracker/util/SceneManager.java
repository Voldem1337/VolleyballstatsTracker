package com.volleyballtracker.util;

import com.volleyballtracker.controller.*;
import com.volleyballtracker.model.Match;
import com.volleyballtracker.view.*;
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
        OpenGameView view = new OpenGameView();

        new OpenGameController(view,this);
        Scene scene = new Scene(view.getRoot(), 900, 600);
        stage.setScene(scene);
    }

    /** Opens Game Editor screen. */
    public void switchToGameEditor(Match match) {
        GameEditorView view = new GameEditorView(match);

        new GameEditorController(view, stage,match);
        Scene scene = new Scene(view.getRoot(), 900, 600);
        stage.setScene(scene);
    }

    /** Opens Edit Stats screen. */
    public void switchToEditStats(Match match) {
        EditStatsView view = new EditStatsView(match);

        new EditStatsController(view, stage, match);
        Scene scene = new Scene(view.getRoot(), 900, 600);
        stage.setScene(scene);
    }


}
