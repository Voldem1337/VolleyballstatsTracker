package com.volleyballtracker.controller;

/**
 * Controller for Export Stats screen.
 *
 * Purpose:
 * - Select match.
 * - Select export format.
 * - Enter file name.
 * - Export statistics.
 */
public class ExportStatsController {

    /** Loads matches and available export formats. */
    public void initialize() {
        // TODO: Fill match list and format selector.
    }

    /** Loads all saved matches. */
    private void loadMatches() {
        // TODO: Read matches from repository.
    }

    /** Stores selected match. */
    public void onMatchSelected() {
        // TODO: Remember selected match for export.
    }

    /** Stores selected format: PDF, Excel, Document, JSON. */
    public void onFormatSelected() {
        // TODO: Remember chosen export format.
    }

    /** Starts export process. */
    public void onExportClicked() {
        // TODO: Validate input and call ExportService.
    }

    /** Checks file name, selected match, and selected format. */
    private boolean validateExportInput() {
        // TODO: Validate export form.
        return false;
    }

    /** Returns to Main Menu. */
    public void onBackClicked() {
        // TODO: Switch to Main Menu screen.
    }
}
