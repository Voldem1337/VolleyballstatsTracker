package com.volleyballtracker.controller;

/**
 * Controller for New Game screen.
 *
 * Purpose:
 * - Create a new match.
 * - Enter match name, players, teams, positions, and file path.
 * - Support Autofill for user's team.
 */
public class NewGameController {

    /** Prepares input fields, position selectors, and default values. */
    public void initialize() {
        // TODO: Fill position selectors: Choose your position, Defence, Attack, Multi.
    }

    /** Automatically fills user's team player names. */
    public void onAutofillClicked() {
        // TODO: Fill Team 1 players with preset names.
    }

    /** Creates and saves a new Match object from user input. */
    public void onCreateGameClicked() {
        // TODO: Validate input, create Match, save match, open Game Editor.
    }

    /** Returns to Main Menu. */
    public void onBackClicked() {
        // TODO: Switch to Main Menu screen.
    }

    /** Checks whether all required input fields are valid. */
    private boolean validateInput() {
        // TODO: Check match name, player names, file path, positions.
        return false;
    }

    /** Builds a Match object from the screen input fields. */
    private void createMatchFromInput() {
        // TODO: Create Match model object.
    }

    /** Generates a safe default file name from match name. */
    private String generateDefaultFileName() {
        // TODO: Replace / with -, add match ID, add extension.
        return null;
    }
}
