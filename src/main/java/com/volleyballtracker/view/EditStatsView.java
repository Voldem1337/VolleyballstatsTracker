package com.volleyballtracker.view;

import com.volleyballtracker.model.ActionRecord;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDateTime;

import static com.volleyballtracker.model.ActionResult.SPIKE_KILL;
import static com.volleyballtracker.model.ActionType.ATTACK;

/**
 * EditStatsView
 * <p>
 * Экран редактирования записанной статистики.
 * Здесь пользователь сможет выбрать действие и изменить или удалить его.
 */
public class EditStatsView {
    private VBox root;

    private Label titleLabel;
    private ListView<ActionRecord> actionRecordListView;
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
        actionRecordListView = new ListView<>();


        editButton = new Button("Edit");
        deleteButton = new Button("Delete");
        saveButton = new Button("Save");
        backButton = new Button("Back");

        buttonsBox = new HBox(15);
        buttonsBox.getChildren().addAll(editButton, deleteButton, saveButton, backButton);

        root.getChildren().addAll(titleLabel, actionRecordListView, buttonsBox);
        ActionRecord actionRecord = new ActionRecord(1,
                1,
                "Demjan",
                "Aleksei/Demjan",
                ATTACK,
                SPIKE_KILL,
                true,
                1,
                LocalDateTime.now());
        actionRecordListView.getItems().add(actionRecord);

    }

    public VBox getRoot() {
        return root;
    }

    public Label getTitleLabel() {
        return titleLabel;
    }

    public ListView<ActionRecord> getActionRecordListView() {

        return actionRecordListView;
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
}
