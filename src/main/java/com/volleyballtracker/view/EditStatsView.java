package com.volleyballtracker.view;

import com.volleyballtracker.model.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * EditStatsView
 * <p>
 * Экран редактирования записанной статистики.
 * Здесь пользователь сможет выбрать действие и изменить или удалить его.
 */
public class EditStatsView {
    private VBox root;

    private Label titleLabel;
    private ListView<Player> statsOfPlayers;
    private HBox buttonsBox;

    private Button editButton;
    private Button deleteButton;
    private Button saveButton;
    private Button backButton;

    public EditStatsView() {
        createView();
    }

    /**
     * Создаёт визуальную часть страницы Edit Stats.
     */
    private void createView() {
        // TODO: Создать список действий, кнопки Edit, Delete, Save и Back.
        root = new VBox(15);

        titleLabel = new Label("Edit Stats");
        titleLabel.setPadding(new Insets(20,0,0,30));
        titleLabel.setFont(Font.font(30));

        statsOfPlayers = new ListView<>();

        editButton = new Button("Edit");
        deleteButton = new Button("Delete");
        saveButton = new Button("Save");
        backButton = new Button("Back");

        setButtonSizeBig(editButton);
        setButtonSizeBig(deleteButton);
        setButtonSizeBig(saveButton);
        setButtonSizeBig(backButton);



        buttonsBox = new HBox(20);
        buttonsBox.setPadding(new Insets(10, 0, 0, 20));
        buttonsBox.getChildren().addAll(editButton, deleteButton, saveButton, backButton);

        root.getChildren().addAll(titleLabel, statsOfPlayers, buttonsBox);

    }

    public VBox getRoot() {
        return root;
    }

    public Label getTitleLabel() {
        return titleLabel;
    }

    public ListView<Player> getStatsOfPlayers() {

        return statsOfPlayers;
    }

    public HBox getButtonsBox() {
        return buttonsBox;
    }

    public Button getEditButton() {
        return editButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getBackButton() {
        return backButton;
    }

    private void setButtonSizeBig(Button button) {
        button.setPrefWidth(120);
        button.setPrefHeight(50);
    }
}
