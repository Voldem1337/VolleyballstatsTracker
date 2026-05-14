package com.volleyballtracker.controller;

import com.volleyballtracker.model.Match;
import com.volleyballtracker.util.SceneManager;
import com.volleyballtracker.view.EditStatsView;
import javafx.stage.Stage;

import java.util.List;

/**
 * Controller for Edit Stats screen.
 *
 * Purpose:
 * - Show recorded action history.
 * - Allow user to edit or delete wrong action records.
 */
public class EditStatsController {

    private EditStatsView view;
    private Stage stage;
    private Match match;

    public EditStatsController(EditStatsView view, Stage stage, Match match) {
        this.view = view;
        this.stage = stage;
        this.match = match;
        connectActions();
    }

    private void connectActions() {

        view.getSaveButton().setOnAction(actionEvent -> {
            onSaveClicked();
        });

        view.getBackButton().setOnAction(actionEvent -> {
            onBackClicked();
            System.out.println("Returned back to the Game Editor");
        });

    }

    /** Saves edited statistics. */
    public void onSaveClicked() {
        view.saveTableDataToPlayers(List.of(match.getPlayer1(), match.getPlayer2(), match.getPlayer3(), match.getPlayer4()));
        System.out.println("Stats saved to players");
    }

    /** Returns to Game Editor. */
    public void onBackClicked() {
        SceneManager sceneManager = new SceneManager(stage);
        sceneManager.switchToGameEditor(match);
    }
}
