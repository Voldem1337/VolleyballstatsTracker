package com.volleyballtracker.controller;

/**
 * Controller for Edit Score screen.
 *
 * Purpose:
 * - Allow manual score correction for Team 1 and Team 2.
 */
public class EditScoreController {

    /** Shows current score in input fields. */
    public void setCurrentScore() {
        // TODO: Load current set score into fields.
    }

    /** Saves new manually entered score. */
    public void onSaveScoreClicked() {
        // TODO: Validate score and update current set.
    }

    /** Checks if score values are correct. */
    private boolean validateScore() {
        // TODO: Check that score contains non-negative numbers.
        return false;
    }

    /** Cancels editing and closes screen/window. */
    public void onCancelClicked() {
        // TODO: Return without changes.
    }
}
