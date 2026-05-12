package com.volleyballtracker.controller;

/**
 * Controller for Edit Stats screen.
 *
 * Purpose:
 * - Show recorded action history.
 * - Allow user to edit or delete wrong action records.
 */
public class EditStatsController {

    /** Loads all recorded actions of the current match. */
    public void loadActionHistory() {
        // TODO: Fill table/list with ActionRecord items.
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
