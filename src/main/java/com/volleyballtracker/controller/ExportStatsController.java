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

import com.volleyballtracker.model.Match;
import com.volleyballtracker.model.MatchFileInfo;
import com.volleyballtracker.service.ExportService;
import com.volleyballtracker.storage.JsonMatchRepository;
import com.volleyballtracker.util.SceneManager;
import com.volleyballtracker.view.ExportStatsView;
import javafx.scene.control.Alert;

import java.util.List;

public class ExportStatsController {

    private final ExportStatsView view;
    private final SceneManager sceneManager;
    private final JsonMatchRepository repository;
    private final ExportService exportService;

    public ExportStatsController(ExportStatsView view, SceneManager sceneManager) {
        this.view = view;
        this.sceneManager = sceneManager;
        this.repository = new JsonMatchRepository();
        this.exportService = new ExportService();

        loadMatches();
        connectActions();
    }

    private void loadMatches() {
        try {
            List<MatchFileInfo> matches = repository.loadAllJsonMatches();
            view.setMatches(matches);
        } catch (RuntimeException e) {
            showError("Could not load matches", e.getMessage());
        }
    }

    private void connectActions() {
        view.getExportButton().setOnAction(event -> onExportClicked());
        view.getBackButton().setOnAction(event -> sceneManager.switchToMainMenu());
    }

    private void onExportClicked() {
        MatchFileInfo selected = view.getMatchComboBox().getValue();

        if (selected == null) {
            showError("No match selected", "Please select a match to export.");
            return;
        }

        try {
            Match match = repository.loadMatch(selected.getFileName());
            exportService.exportToPdf(match);

            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setTitle("Export successful");
            info.setHeaderText(null);
            info.setContentText("PDF saved to the exports folder.");
            info.showAndWait();

        } catch (RuntimeException e) {
            showError("Export failed", e.getMessage());
        }
    }

    private void showError(String header, String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }
}