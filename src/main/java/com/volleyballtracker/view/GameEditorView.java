package com.volleyballtracker.view;

import com.volleyballtracker.model.Match;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameEditorView {
    private Match match;
    private BorderPane root;

    private HBox headerBox;
    private Label matchNameLabel;
    private Label teamOneScoreLabel;
    private Label scoreSeparatorLabel;
    private Label teamTwoScoreLabel;
    private Label setNumberLabel;

    private GridPane actionsGrid;

    private Label playerOneLabel;
    private Label playerTwoLabel;
    private Label playerThreeLabel;
    private Label playerFourLabel;

    private Button playerOneAttackButton;
    private Button playerOneReceiveButton;
    private Button playerOneBlockButton;
    private Button playerOneDigButton;

    private Button playerTwoAttackButton;
    private Button playerTwoReceiveButton;
    private Button playerTwoBlockButton;
    private Button playerTwoDigButton;

    private Button playerThreeAttackButton;
    private Button playerThreeReceiveButton;
    private Button playerThreeBlockButton;
    private Button playerThreeDigButton;

    private Button playerFourAttackButton;
    private Button playerFourReceiveButton;
    private Button playerFourBlockButton;
    private Button playerFourDigButton;

    private VBox bottomBox;
    private Button newSetButton;

    private GridPane bottomButtonsGrid;
    private Button editStatsButton;
    private Button exportButton;
    private Button exitButton;
    private Button rallyCounterButton;
    private Button editScoreButton;
    private Button secondBallPointsButton;

    public GameEditorView(Match match) {
        this.match = match;
        createView(match);
    }

    public void createView(Match match) {
        root = new BorderPane();
        root.setPadding(new Insets(20));

        headerBox = new HBox(20);
        headerBox.setAlignment(Pos.CENTER);

        matchNameLabel = new Label(match.getTeamOneName() + " vs " + match.getTeamTwoName());
        teamOneScoreLabel = new Label(String.valueOf(match.getSets().get(match.getCurrentSetNumber() - 1).getTeamOnePoints()));
        teamTwoScoreLabel = new Label(String.valueOf(match.getSets().get(match.getCurrentSetNumber() - 1).getTeamTwoPoints()));
        scoreSeparatorLabel = new Label(":");
        setNumberLabel = new Label("Set: " + match.getCurrentSetNumber());

        headerBox.getChildren().addAll(matchNameLabel, teamOneScoreLabel, scoreSeparatorLabel, teamTwoScoreLabel, setNumberLabel);

        actionsGrid = new GridPane();
        actionsGrid.setAlignment(Pos.CENTER);
        actionsGrid.setHgap(70);
        actionsGrid.setVgap(15);

        playerOneLabel = new Label(match.getPlayer1().getName());
        playerTwoLabel = new Label(match.getPlayer2().getName());
        playerThreeLabel = new Label(match.getPlayer3().getName());
        playerFourLabel = new Label(match.getPlayer4().getName());

        playerOneAttackButton = new Button("Attack");
        playerOneReceiveButton = new Button("Receive");
        playerOneBlockButton = new Button("Block");
        playerOneDigButton = new Button("Dig");

        playerTwoAttackButton = new Button("Attack");
        playerTwoReceiveButton = new Button("Receive");
        playerTwoBlockButton = new Button("Block");
        playerTwoDigButton = new Button("Dig");

        playerThreeAttackButton = new Button("Attack");
        playerThreeReceiveButton = new Button("Receive");
        playerThreeBlockButton = new Button("Block");
        playerThreeDigButton = new Button("Dig");

        playerFourAttackButton = new Button("Attack");
        playerFourReceiveButton = new Button("Receive");
        playerFourBlockButton = new Button("Block");
        playerFourDigButton = new Button("Dig");

        actionsGrid.add(playerOneLabel, 0, 0);
        actionsGrid.add(playerTwoLabel, 1, 0);
        actionsGrid.add(playerThreeLabel, 2, 0);
        actionsGrid.add(playerFourLabel, 3, 0);

        actionsGrid.add(playerOneAttackButton, 0, 1);
        actionsGrid.add(playerTwoAttackButton, 1, 1);
        actionsGrid.add(playerThreeAttackButton, 2, 1);
        actionsGrid.add(playerFourAttackButton, 3, 1);

        actionsGrid.add(playerOneReceiveButton, 0, 2);
        actionsGrid.add(playerTwoReceiveButton, 1, 2);
        actionsGrid.add(playerThreeReceiveButton, 2, 2);
        actionsGrid.add(playerFourReceiveButton, 3, 2);

        actionsGrid.add(playerOneBlockButton, 0, 3);
        actionsGrid.add(playerTwoBlockButton, 1, 3);
        actionsGrid.add(playerThreeBlockButton, 2, 3);
        actionsGrid.add(playerFourBlockButton, 3, 3);

        actionsGrid.add(playerOneDigButton, 0, 4);
        actionsGrid.add(playerTwoDigButton, 1, 4);
        actionsGrid.add(playerThreeDigButton, 2, 4);
        actionsGrid.add(playerFourDigButton, 3, 4);

        bottomBox = new VBox(10);
        bottomBox.setAlignment(Pos.CENTER);

        newSetButton = new Button("New Set");

        bottomButtonsGrid = new GridPane();
        bottomButtonsGrid.setAlignment(Pos.CENTER);
        bottomButtonsGrid.setHgap(100);
        bottomButtonsGrid.setVgap(20);

        editStatsButton = new Button("Edit Stats");
        exportButton = new Button("Export");
        exitButton = new Button("Exit");
        rallyCounterButton = new Button("Long Rally");
        editScoreButton = new Button("Edit Score");
        secondBallPointsButton = new Button("Second ball point");

        bottomBox.getChildren().addAll(newSetButton, bottomButtonsGrid);

        bottomButtonsGrid.add(editStatsButton, 0, 0);
        bottomButtonsGrid.add(exportButton, 1, 0);
        bottomButtonsGrid.add(exitButton, 2, 0);
        bottomButtonsGrid.add(rallyCounterButton, 0, 1);
        bottomButtonsGrid.add(editScoreButton, 1, 1);
        bottomButtonsGrid.add(secondBallPointsButton, 2, 1);

        root.setTop(headerBox);
        root.setCenter(actionsGrid);
        root.setBottom(bottomBox);

        setButtonSizeBig(playerOneAttackButton);
        setButtonSizeBig(playerOneReceiveButton);
        setButtonSizeBig(playerOneBlockButton);
        setButtonSizeBig(playerOneDigButton);
        setButtonSizeBig(playerTwoAttackButton);
        setButtonSizeBig(playerTwoReceiveButton);
        setButtonSizeBig(playerTwoBlockButton);
        setButtonSizeBig(playerTwoDigButton);
        setButtonSizeBig(playerThreeAttackButton);
        setButtonSizeBig(playerThreeReceiveButton);
        setButtonSizeBig(playerThreeBlockButton);
        setButtonSizeBig(playerThreeDigButton);
        setButtonSizeBig(playerFourAttackButton);
        setButtonSizeBig(playerFourReceiveButton);
        setButtonSizeBig(playerFourBlockButton);
        setButtonSizeBig(playerFourDigButton);
        setButtonSizeBig(newSetButton);
        setButtonSizeBig(editScoreButton);
        setButtonSizeBig(editStatsButton);
        setButtonSizeBig(exitButton);
        setButtonSizeBig(exportButton);
        setButtonSizeBig(rallyCounterButton);
        setButtonSizeBig(secondBallPointsButton);
    }

    public BorderPane getRoot() {
        return root;
    }

    public Button getPlayerOneAttackButton() {
        return playerOneAttackButton;
    }

    public Button getPlayerOneReceiveButton() {
        return playerOneReceiveButton;
    }

    public Button getPlayerOneBlockButton() {
        return playerOneBlockButton;
    }

    public Button getPlayerOneDigButton() {
        return playerOneDigButton;
    }

    public Button getPlayerTwoAttackButton() {
        return playerTwoAttackButton;
    }

    public Button getPlayerTwoReceiveButton() {
        return playerTwoReceiveButton;
    }

    public Button getPlayerTwoBlockButton() {
        return playerTwoBlockButton;
    }

    public Button getPlayerTwoDigButton() {
        return playerTwoDigButton;
    }

    public Button getPlayerThreeAttackButton() {
        return playerThreeAttackButton;
    }

    public Button getPlayerThreeReceiveButton() {
        return playerThreeReceiveButton;
    }

    public Button getPlayerThreeBlockButton() {
        return playerThreeBlockButton;
    }

    public Button getPlayerThreeDigButton() {
        return playerThreeDigButton;
    }

    public Button getPlayerFourAttackButton() {
        return playerFourAttackButton;
    }

    public Button getPlayerFourReceiveButton() {
        return playerFourReceiveButton;
    }

    public Button getPlayerFourBlockButton() {
        return playerFourBlockButton;
    }

    public Button getPlayerFourDigButton() {
        return playerFourDigButton;
    }

    public Button getRallyCounterButton() {
        return rallyCounterButton;
    }

    public Button getExitButton() {
        return exitButton;
    }

    public Button getExportButton() {
        return exportButton;
    }

    public Button getEditStatsButton() {
        return editStatsButton;
    }

    public Button getEditScoreButton() {
        return editScoreButton;
    }

    public Button getSecondBallPointsButton() {
        return secondBallPointsButton;
    }

    public Button getNewSetButton() {
        return newSetButton;
    }

    public void setScore(int teamOneScore, int teamTwoScore) {
        teamOneScoreLabel.setText(String.valueOf(teamOneScore));
        teamTwoScoreLabel.setText(String.valueOf(teamTwoScore));
    }

    public void setSetNumber(int setNumber) {
        setNumberLabel.setText("Set: " + setNumber);
    }

    public void setTeamOneScoreLabel(String text) {
        teamOneScoreLabel.setText(text);
    }

    public void setTeamTwoScoreLabel(String text) {
        teamTwoScoreLabel.setText(text);
    }

    public void setTeamOneScoreText(String score) {
        teamOneScoreLabel.setText(score);
    }

    public void setTeamTwoScoreText(String score) {
        teamTwoScoreLabel.setText(score);
    }

    private void setButtonSizeBig(Button button) {
        button.setPrefWidth(120);
        button.setPrefHeight(50);
    }
}
