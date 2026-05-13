package com.volleyballtracker.controller;

import com.volleyballtracker.model.Match;
import com.volleyballtracker.view.GameEditorView;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

/**
 * Controller for Game Editor screen.
 *
 * Purpose:
 * - Main live match screen.
 * - Shows match title, score, players, action buttons, and utility buttons.
 * - Handles Attack, Receive, Block, Dig actions for each player.
 */
public class GameEditorController {

    private GameEditorView view;
    private Stage stage;

    public GameEditorController(GameEditorView view, Stage stage) {
        this.view = view;
        this.stage = stage;
        connectActions();
    }

    public void connectActions() {
        view.getPlayerOneAttackButton().setOnAction(actionEvent -> {
            openAttackDialog("Player 1");
            System.out.println("Player 1 Attack clicked");
        });

        view.getPlayerOneReceiveButton().setOnAction(actionEvent -> {
            openReceiveDialog("Player 1");
            System.out.println("Player 1 Receive clicked");
        });

        view.getPlayerOneBlockButton().setOnAction(actionEvent -> {
            openBlockDialog("Player 1");
            System.out.println("Player 1 Block clicked");
        });

        view.getPlayerOneDigButton().setOnAction(actionEvent -> {
            openDigDialog("Player 1");
            System.out.println("Player 1 Dig clicked");
        });


        view.getPlayerTwoAttackButton().setOnAction(actionEvent -> {
            openAttackDialog("Player 2");
            System.out.println("Player 2 Attack clicked");
        });

        view.getPlayerTwoReceiveButton().setOnAction(actionEvent -> {
            openReceiveDialog("Player 2");
            System.out.println("Player 2 Receive clicked");
        });

        view.getPlayerTwoBlockButton().setOnAction(actionEvent -> {
            openBlockDialog("Player 2");
            System.out.println("Player 2 Block clicked");
        });

        view.getPlayerTwoDigButton().setOnAction(actionEvent -> {
            openDigDialog("Player 2");
            System.out.println("Player 2 Dig clicked");
        });


        view.getPlayerThreeAttackButton().setOnAction(actionEvent -> {
            openAttackDialog("Player 3");
            System.out.println("Player 3 Attack clicked");
        });

        view.getPlayerThreeReceiveButton().setOnAction(actionEvent -> {
            openReceiveDialog("Player 3");
            System.out.println("Player 3 Receive clicked");
        });

        view.getPlayerThreeBlockButton().setOnAction(actionEvent -> {
            openBlockDialog("Player 3");
            System.out.println("Player 3 Block clicked");
        });

        view.getPlayerThreeDigButton().setOnAction(actionEvent -> {
            openDigDialog("Player 3");
            System.out.println("Player 3 Dig clicked");
        });


        view.getPlayerFourAttackButton().setOnAction(actionEvent -> {
            openAttackDialog("Player 4");
            System.out.println("Player 4 Attack clicked");
        });

        view.getPlayerFourReceiveButton().setOnAction(actionEvent -> {
            openReceiveDialog("Player 4");
            System.out.println("Player 4 Receive clicked");
        });

        view.getPlayerFourBlockButton().setOnAction(actionEvent -> {
            openBlockDialog("Player 4");
            System.out.println("Player 4 Block clicked");
        });

        view.getPlayerFourDigButton().setOnAction(actionEvent -> {
            openDigDialog("Player 4");
            System.out.println("Player 4 Dig clicked");
        });

        view.getNewSetButton().setOnAction(actionEvent -> {
            System.out.println("New Set clicked");
        });

        view.getEditStatsButton().setOnAction(actionEvent -> {
            System.out.println("Edit Stats clicked");
        });

        view.getExportButton().setOnAction(actionEvent -> {
            System.out.println("Export clicked");
        });

        view.getExitButton().setOnAction(actionEvent -> {
            System.out.println("Exit clicked");
        });

        view.getRallyCounterButton().setOnAction(actionEvent -> {
            System.out.println("Long Rally clicked");
        });

        view.getEditScoreButton().setOnAction(actionEvent -> {
            System.out.println("Edit Score clicked");
        });

        view.getSecondBallPointsButton().setOnAction(actionEvent -> {
            System.out.println("Second Ball Point clicked");
        });
    }


    private void openAttackDialog(String playerName) {
        ChoiceDialog<String> dialog = new ChoiceDialog<>(
                "Spike kill",
                "Spike kill",
                "Spike error",
                "Spike attempt",
                "Cut shot kill",
                "Cut shot error",
                "Cut shot attempt");

        dialog.setTitle("Attack");
        dialog.setHeaderText("Choose attack result for " + playerName);
        dialog.setContentText("Result:");


        dialog.showAndWait().ifPresent(result -> {
            System.out.println(playerName + " selected: " + result);
        });
    }

    private void openReceiveDialog(String playerName) {
        ChoiceDialog<String> dialog = new ChoiceDialog<>(
                "Good receive",
                "Good receive",
                "For the option",
                "Good receive",
                "Hard to set",
                "Receive error"
        );

        dialog.setTitle("Receive");
        dialog.setHeaderText("Choose receive result for " + playerName);
        dialog.setContentText("Result:");

        dialog.showAndWait().ifPresent(result -> {
            System.out.println(playerName + " receive result: " + result);
        });
    }

    private void openBlockDialog(String playerName) {
        ChoiceDialog<String> dialog = new ChoiceDialog<>(
                "Monster block",
                "Monster block",
                "Very good block touch",
                "Block touch",
                "Block out"
        );

        dialog.setTitle("Block");
        dialog.setHeaderText("Choose block result for " + playerName);
        dialog.setContentText("Result:");

        dialog.showAndWait().ifPresent(result -> {
            System.out.println(playerName + " block result: " + result);
        });
    }

    private void openDigDialog(String playerName) {
        ChoiceDialog<String> dialog = new ChoiceDialog<>(
                "Dig",
                "Dig",
                "Dig error"
        );

        dialog.setTitle("Dig");
        dialog.setHeaderText("Choose dig result for " + playerName);
        dialog.setContentText("Result:");

        dialog.showAndWait().ifPresent(result -> {
            System.out.println(playerName + " dig result: " + result);
        });
    }

    /** Receives selected match from Open Game or New Game screen. */
    public void setMatch() {
        // TODO: Store current Match object.
        //
    }

    /** Refreshes score, current set, player names, and visual state. */
    private void refreshScreen() {
        // TODO: Update all UI elements.
    }

    /** Handles Attack button for selected player. */
    public void onAttackClicked() {
        // TODO: Ask result: Spike kill, Spike error, Cut shot kill, Cut shot error, Spike attempt, Cut shot attempt.
    }

    /** Handles Receive button for selected player. */
    public void onReceiveClicked() {
        // TODO: Ask result: For the option, Good receive, Hard to set, Receive error.
    }

    /** Handles Block button for selected player. */
    public void onBlockClicked() {
        // TODO: Ask result: Monster Block, Very good Block touch, Block touch, Block out.
    }

    /** Handles Dig button for selected player. */
    public void onDigClicked() {
        // TODO: Ask result: Dig or Dig error.
    }

    /** Creates a new set and resets score to 0:0. */
    public void onNewSetClicked() {
        // TODO: Finish current set if needed, create new set, reset score.
    }

    /** Opens Edit Stats screen. */
    public void onEditStatsClicked() {
        // TODO: Switch to Edit Stats screen.
    }

    /** Opens Export screen for current match. */
    public void onExportClicked() {
        // TODO: Switch to Export Stats screen with selected match.
    }

    /** Handles exit from current game. */
    public void onExitClicked() {
        // TODO: Ask Save and exit / Exit without saving / Cancel.
    }

    /** Increases rally counter. */
    public void onRallyCounterClicked() {
        // TODO: Increase rally count and save rally length if needed.
    }

    /** Opens manual score editor. */
    public void onEditScoreClicked() {
        // TODO: Open Edit Score screen or modal window.
    }

    /** Adds point from second ball action. */
    public void onSecondBallPointsClicked() {
        // TODO: Choose player, add second ball point, update score/statistics.
    }
}
