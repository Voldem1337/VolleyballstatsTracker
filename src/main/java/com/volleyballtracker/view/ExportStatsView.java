package com.volleyballtracker.view;

import com.volleyballtracker.model.MatchFileInfo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

/**
 * ExportStatsView
 *
 * Экран экспорта статистики.
 * Пользователь выбирает матч и нажимает Export.
 */
public class ExportStatsView {

    private final VBox root;
    private final ComboBox<MatchFileInfo> matchComboBox;
    private final Button exportButton;
    private final Button backButton;

    public ExportStatsView() {
        Label title = new Label("Export Statistics");
        title.setFont(Font.font("Arial", 28));

        Label matchLabel = new Label("Select match:");
        matchLabel.setFont(Font.font("Arial", 14));

        matchComboBox = new ComboBox<>();
        matchComboBox.setPrefWidth(400);
        matchComboBox.setPromptText("Choose match");

        matchComboBox.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(MatchFileInfo item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getMatchName());
            }
        });

        matchComboBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(MatchFileInfo item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "Choose match" : item.getMatchName());
            }
        });

        exportButton = new Button("Export to PDF");
        exportButton.setPrefSize(200, 45);
        exportButton.setFont(Font.font("Arial", 14));

        backButton = new Button("Back");
        backButton.setPrefSize(120, 40);

        HBox buttonRow = new HBox(20, exportButton, backButton);
        buttonRow.setAlignment(Pos.CENTER);

        root = new VBox(20, title, matchLabel, matchComboBox, buttonRow);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
    }

    public VBox getRoot() {
        return root;
    }

    public ComboBox<MatchFileInfo> getMatchComboBox() {
        return matchComboBox;
    }

    public Button getExportButton() {
        return exportButton;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setMatches(List<MatchFileInfo> matches) {
        matchComboBox.getItems().setAll(matches);
    }
}
