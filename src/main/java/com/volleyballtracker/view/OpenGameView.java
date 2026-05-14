package com.volleyballtracker.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.Parent;

/**
 * OpenGameView
 *
 * Screen for opening an already created match.
 * This view displays the list of all saved matches
 * and contains Back / Select buttons.
 */


public class OpenGameView {

    private VBox root;
    private VBox matchListBox;
    private ScrollPane scrollPane;
    private Button backButton;
    private Button deleteButton;

    public OpenGameView() {
        createView();
    }

    public void createView() {
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        Label title = new Label("Open Game");
        title.setFont(Font.font("Arial", 28));

        matchListBox = new VBox(10);
        matchListBox.setAlignment(Pos.CENTER);

        scrollPane = new ScrollPane(matchListBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(400);
        scrollPane.setMaxWidth(500);

        backButton = new Button("Back");
        deleteButton = new Button("Delete Game");

        deleteButton.setPrefWidth(120);
        backButton.setPrefWidth(120);
        HBox bottomRow = new HBox(20);
        bottomRow.setAlignment(Pos.CENTER);
        bottomRow.getChildren().addAll(backButton, deleteButton);



        root.getChildren().addAll(title, scrollPane, bottomRow);

    }

    public void addMatchButton(String matchName, Runnable action) {
        Button button = new Button(matchName);
        button.setPrefWidth(400);
        button.setPrefHeight(40);

        button.setOnAction(event -> action.run());

        matchListBox.getChildren().add(button);
    }

    public Parent getRoot() {
        return root;
    }

    public Button getBackButton() {
        return backButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }
}