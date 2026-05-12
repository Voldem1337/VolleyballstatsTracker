package com.volleyballtracker.controller;

/**
 * Controller for Open Game screen.
 *
 * Purpose:
 * - Show all created matches.
 * - Allow user to select one match.
 * - Open selected match in Game Editor.
 */
public class OpenGameController {

    /** Loads all saved matches when the screen opens. */
    public void initialize() {
        // TODO: Load matches into ListView or scrollable container.
    }

    /** Gets match list from repository/storage. */
    private void loadMatches() {
        // TODO: Read all matches from JSON or database.
    }

    /** Stores selected match from the list. */
    public void onMatchSelected() {
        // TODO: Remember selected match ID.
    }

    /** Opens selected match in Game Editor. */
    public void onSelectClicked() {
        // TODO: Validate selection and switch to Game Editor screen.
    }

    /** Returns to Main Menu. */
    public void onBackClicked() {
        // TODO: Switch to Main Menu screen.
    }
}
