package com.volleyballtracker.controller;

import com.volleyballtracker.view.EditStatsView;
import javafx.stage.Stage;

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

    public EditStatsController(EditStatsView view, Stage stage) {
        this.view = view;
        this.stage = stage;
        connectActions();
    }

    private void connectActions() {

        view.getSaveButton().setOnAction(actionEvent -> {
            System.out.println("Save clicked");
        });

        view.getBackButton().setOnAction(actionEvent -> {
            System.out.println("Back clicked");
        });

    }

    public void loadPlayer() {

    }

    /** Selects one action from action history. */
    public void onActionSelected() {
        // TODO: Store selected action.
    }

    /** Edits selected action. */
    public void onEditActionClicked() {
        // TODO: Change action type/result/player and recalculate statistics.
    }

    /** Deletes selected action. */
    public void onDeleteActionClicked() {
        // TODO: Remove action and recalculate score/statistics if needed.
    }

    /** Saves edited statistics. */
    public void onSaveClicked() {
        // TODO: Save match after changes.
    }

    /** Returns to Game Editor. */
    public void onBackClicked() {
        // TODO: Switch back to Game Editor screen.
    }
}
