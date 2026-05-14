package com.volleyballtracker.controller;

import com.volleyballtracker.model.Match;
import com.volleyballtracker.model.MatchFileInfo;
import com.volleyballtracker.storage.JsonMatchRepository;
import com.volleyballtracker.util.SceneManager;
import com.volleyballtracker.view.OpenGameView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class OpenGameController {
    private OpenGameView openGameView;
    private SceneManager sceneManager;
    private List<MatchFileInfo> matches;
    private JsonMatchRepository jsonMatchRepository;

    public OpenGameController(OpenGameView openGameView, SceneManager sceneManager) {
        this.openGameView = openGameView;
        this.sceneManager = sceneManager;
        this.jsonMatchRepository = new JsonMatchRepository();

        try {
            this.matches = jsonMatchRepository.loadAllJsonMatches();
        } catch (RuntimeException e) {
            showError("Could not load matches", e.getMessage());
            this.matches = List.of();
        }

        connectActions();
    }

    private void connectActions() {
        for (MatchFileInfo matchInfo : matches) {
            openGameView.addMatchButton(matchInfo.getMatchName(), () -> {
                try {
                    Match match = jsonMatchRepository.loadMatch(matchInfo.getFileName());
                    sceneManager.switchToGameEditor(match);
                } catch (RuntimeException e) {
                    showError("Could not open match", e.getMessage());
                }
            });
        }

        openGameView.getBackButton().setOnAction(event -> {
            sceneManager.switchToMainMenu();
        });

        openGameView.getDeleteButton().setOnAction(event -> {
            openDeleteMatchWindow();
        });
    }

    private void openDeleteMatchWindow() {
        Stage popup = new Stage();
        popup.setTitle("Delete match");

        Label title = new Label("Choose match to delete");
        title.setFont(Font.font("Arial", 20));

        ComboBox<MatchFileInfo> matchComboBox = new ComboBox<>();
        matchComboBox.getItems().addAll(matches);
        matchComboBox.setPrefWidth(400);

        matchComboBox.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(MatchFileInfo item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getMatchName());
                }
            }
        });

        matchComboBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(MatchFileInfo item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText("Choose match");
                } else {
                    setText(item.getMatchName());
                }
            }
        });

        Button deleteButton = new Button("Delete");
        Button closeButton = new Button("Close");

        HBox buttonRow = new HBox(20);
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.getChildren().addAll(deleteButton, closeButton);

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20.5));
        root.getChildren().addAll(title, matchComboBox, buttonRow);

        deleteButton.setOnAction(event -> {
            MatchFileInfo selectedMatch = matchComboBox.getValue();

            if (selectedMatch == null) {
                showError("No match selected", "Please choose a match to delete.");
                return;
            }

            boolean confirmed = showConfirm(
                    "Delete match",
                    "Are you sure you want to delete this match?"
            );

            if (confirmed) {
                try {
                    jsonMatchRepository.deleteMatch(selectedMatch.getFileName());
                    popup.close();
                    sceneManager.switchToOpenGame();
                } catch (RuntimeException e) {
                    showError("Could not delete match", e.getMessage());
                }
            }
        });

        closeButton.setOnAction(event -> popup.close());

        Scene scene = new Scene(root, 500, 250);
        popup.setScene(scene);
        popup.showAndWait();
    }

    private void showError(String header, String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }

    private boolean showConfirm(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm");
        alert.setHeaderText(header);
        alert.setContentText(message);

        return alert.showAndWait()
                .filter(button -> button == ButtonType.OK)
                .isPresent();
    }
}
