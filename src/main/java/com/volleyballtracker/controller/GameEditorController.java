package com.volleyballtracker.controller;

import com.volleyballtracker.model.ExportToPDF;
import com.volleyballtracker.model.Match;
import com.volleyballtracker.model.Player;
import com.volleyballtracker.model.Set;
import com.volleyballtracker.storage.JsonMatchRepository;
import com.volleyballtracker.util.SceneManager;
import com.volleyballtracker.view.GameEditorView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class GameEditorController {

    private GameEditorView view;
    private Stage stage;
    private Match match;

    public GameEditorController(GameEditorView view, Stage stage, Match match) {
        this.view = view;
        this.stage = stage;
        this.match = match;
        refreshScore();
        connectActions();
    }

    public void connectActions() {
        view.getPlayerOneAttackButton().setOnAction(event -> openAttackDialog(match.getPlayer1()));
        view.getPlayerOneReceiveButton().setOnAction(event -> openReceiveDialog(match.getPlayer1()));
        view.getPlayerOneBlockButton().setOnAction(event -> openBlockDialog(match.getPlayer1()));
        view.getPlayerOneDigButton().setOnAction(event -> openDigDialog(match.getPlayer1()));

        view.getPlayerTwoAttackButton().setOnAction(event -> openAttackDialog(match.getPlayer2()));
        view.getPlayerTwoReceiveButton().setOnAction(event -> openReceiveDialog(match.getPlayer2()));
        view.getPlayerTwoBlockButton().setOnAction(event -> openBlockDialog(match.getPlayer2()));
        view.getPlayerTwoDigButton().setOnAction(event -> openDigDialog(match.getPlayer2()));

        view.getPlayerThreeAttackButton().setOnAction(event -> openAttackDialog(match.getPlayer3()));
        view.getPlayerThreeReceiveButton().setOnAction(event -> openReceiveDialog(match.getPlayer3()));
        view.getPlayerThreeBlockButton().setOnAction(event -> openBlockDialog(match.getPlayer3()));
        view.getPlayerThreeDigButton().setOnAction(event -> openDigDialog(match.getPlayer3()));

        view.getPlayerFourAttackButton().setOnAction(event -> openAttackDialog(match.getPlayer4()));
        view.getPlayerFourReceiveButton().setOnAction(event -> openReceiveDialog(match.getPlayer4()));
        view.getPlayerFourBlockButton().setOnAction(event -> openBlockDialog(match.getPlayer4()));
        view.getPlayerFourDigButton().setOnAction(event -> openDigDialog(match.getPlayer4()));

        view.getNewSetButton().setOnAction(event -> onNewSetClicked());
        view.getEditStatsButton().setOnAction(event -> onEditStatsClicked());
        view.getExportButton().setOnAction(event -> onExportClicked());
        view.getExitButton().setOnAction(event -> onExitClicked());
        view.getRallyCounterButton().setOnAction(event -> onRallyCounterClicked());
        view.getEditScoreButton().setOnAction(event -> onEditScoreClicked());
        view.getSecondBallPointsButton().setOnAction(event -> onSecondBallPointsClicked());
    }

    private void openAttackDialog(Player player) {
        ChoiceDialog<String> dialog = new ChoiceDialog<>(
                "Spike kill",
                List.of(
                        "Spike kill",
                        "Spike error",
                        "Spike attempt",
                        "Cut shot kill",
                        "Cut shot error",
                        "Cut shot attempt"
                )
        );

        dialog.setTitle("Attack");
        dialog.setHeaderText("Choose attack result for " + player.getName());
        dialog.setContentText("Result:");

        dialog.showAndWait().ifPresent(result -> {
            processAttack(player, result);
            refreshScore();
        });
    }

    private void openReceiveDialog(Player player) {
        ChoiceDialog<String> dialog = new ChoiceDialog<>(
                "Good receive",
                List.of(
                        "For the option",
                        "Good receive",
                        "Hard to set",
                        "Receive error"
                )
        );

        dialog.setTitle("Receive");
        dialog.setHeaderText("Choose receive result for " + player.getName());
        dialog.setContentText("Result:");

        dialog.showAndWait().ifPresent(result -> {
            processReceive(player, result);
            refreshScore();
        });
    }

    private void openBlockDialog(Player player) {
        ChoiceDialog<String> dialog = new ChoiceDialog<>(
                "Monster block",
                List.of(
                        "Monster block",
                        "Very good block touch",
                        "Block touch",
                        "Block out"
                )
        );

        dialog.setTitle("Block");
        dialog.setHeaderText("Choose block result for " + player.getName());
        dialog.setContentText("Result:");

        dialog.showAndWait().ifPresent(result -> {
            processBlock(player, result);
            refreshScore();
        });
    }

    private void openDigDialog(Player player) {
        ChoiceDialog<String> dialog = new ChoiceDialog<>(
                "Dig",
                List.of(
                        "Dig",
                        "Dig error"
                )
        );

        dialog.setTitle("Dig");
        dialog.setHeaderText("Choose dig result for " + player.getName());
        dialog.setContentText("Result:");

        dialog.showAndWait().ifPresent(result -> {
            processDig(player, result);
            refreshScore();
        });
    }

    private void processAttack(Player player, String result) {
        player.setOverallAttack(player.getOverallAttack() + 1);

        switch (result) {
            case "Spike kill" -> {
                player.setSpikeKill(player.getSpikeKill() + 1);
                player.setSpikeAttempt(player.getSpikeAttempt() + 1);
                player.setTotalPoints(player.getTotalPoints() + 1);
                addPointToPlayerTeam(player);
            }
            case "Spike error" -> {
                player.setSpikeError(player.getSpikeError() + 1);
                player.setSpikeAttempt(player.getSpikeAttempt() + 1);
                player.setTotalErrors(player.getTotalErrors() + 1);
                addPointToOpponentTeam(player);
            }
            case "Spike attempt" -> player.setSpikeAttempt(player.getSpikeAttempt() + 1);
            case "Cut shot kill" -> {
                player.setCutShotKill(player.getCutShotKill() + 1);
                player.setCutShotAttempt(player.getCutShotAttempt() + 1);
                player.setTotalPoints(player.getTotalPoints() + 1);
                addPointToPlayerTeam(player);
            }
            case "Cut shot error" -> {
                player.setCutShotError(player.getCutShotError() + 1);
                player.setCutShotAttempt(player.getCutShotAttempt() + 1);
                player.setTotalErrors(player.getTotalErrors() + 1);
                addPointToOpponentTeam(player);
            }
            case "Cut shot attempt" -> player.setCutShotAttempt(player.getCutShotAttempt() + 1);
        }
    }

    private void processReceive(Player player, String result) {
        player.setOverallReceive(player.getOverallReceive() + 1);

        switch (result) {
            case "For the option" -> player.setReceiveForTheOption(player.getReceiveForTheOption() + 1);
            case "Good receive" -> player.setGoodReceive(player.getGoodReceive() + 1);
            case "Hard to set" -> player.setHardToSet(player.getHardToSet() + 1);
            case "Receive error" -> {
                player.setReceiveError(player.getReceiveError() + 1);
                player.setTotalErrors(player.getTotalErrors() + 1);
                addPointToOpponentTeam(player);
            }
        }
    }

    private void processBlock(Player player, String result) {
        player.setOverallBlock(player.getOverallBlock() + 1);

        switch (result) {
            case "Monster block" -> {
                player.setMonsterBlock(player.getMonsterBlock() + 1);
                player.setTotalPoints(player.getTotalPoints() + 1);
                addPointToPlayerTeam(player);
            }
            case "Very good block touch", "Block touch" -> player.setBlockTouch(player.getBlockTouch() + 1);
            case "Block out" -> {
                player.setBlockError(player.getBlockError() + 1);
                player.setTotalErrors(player.getTotalErrors() + 1);
                addPointToOpponentTeam(player);
            }
        }
    }

    private void processDig(Player player, String result) {
        player.setOverallDig(player.getOverallDig() + 1);

        switch (result) {
            case "Dig" -> player.setDig(player.getDig() + 1);
            case "Dig error" -> {
                player.setDigError(player.getDigError() + 1);
                player.setTotalErrors(player.getTotalErrors() + 1);
                addPointToOpponentTeam(player);
            }
        }
    }

    private Set getCurrentSet() {
        return match.getSets().get(match.getCurrentSetNumber() - 1);
    }

    private boolean isTeamOnePlayer(Player player) {
        return player == match.getPlayer1() || player == match.getPlayer2();
    }

    private void addPointToPlayerTeam(Player player) {
        if (isTeamOnePlayer(player)) {
            getCurrentSet().addPointToTeamOne();
        } else {
            getCurrentSet().addPointToTeamTwo();
        }
    }

    private void addPointToOpponentTeam(Player player) {
        if (isTeamOnePlayer(player)) {
            getCurrentSet().addPointToTeamTwo();
        } else {
            getCurrentSet().addPointToTeamOne();
        }
    }

    private void refreshScore() {
        Set set = getCurrentSet();
        view.setScore(set.getTeamOnePoints(), set.getTeamTwoPoints());
        view.setSetNumber(match.getCurrentSetNumber());
    }

    public void onNewSetClicked() {
        int nextSetNumber = match.getCurrentSetNumber() + 1;

        if (nextSetNumber > match.getSets().size()) {
            match.addSet();
        }

        match.setCurrentSetNumber(nextSetNumber);
        refreshScore();
    }

    public void onEditStatsClicked() {
        SceneManager sceneManager = new SceneManager(stage);
        sceneManager.switchToEditStats(match);
    }

    public void onExportClicked() {
        ExportToPDF exportToPDF = new ExportToPDF();
        exportToPDF.exportToPdf(match);
    }

    public void onExitClicked() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Save changes");
        alert.setHeaderText("Do you want to save changes?");
        alert.setContentText("Choose an option.");

        ButtonType saveButton = new ButtonType("Save");
        ButtonType dontSaveButton = new ButtonType("Don't save");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(saveButton, dontSaveButton, cancelButton);

        alert.showAndWait().ifPresent(result -> {
            if (result == saveButton || result == dontSaveButton) {
                if(result == saveButton) {
                    JsonMatchRepository jsonMatchRepository = new JsonMatchRepository();
                    jsonMatchRepository.saveToJson(match, match.getFileName());
                }
                SceneManager sceneManager = new SceneManager(stage);
                sceneManager.switchToMainMenu();
            }
        });
    }

    public void onRallyCounterClicked() {
        Set set = getCurrentSet();
        set.setRallyCounter(set.getRallyCounter() + 1);
    }
    public void onEditScoreClicked() {
        Stage editScoreStage = new Stage();
        editScoreStage.setTitle("Edit Score");

        ComboBox<Integer> setComboBox = new ComboBox<>();

        for (int i = 0; i < match.getSets().size(); i++) {
            setComboBox.getItems().add(i + 1);
        }

        setComboBox.setValue(match.getCurrentSetNumber());

        TextField teamOneScoreField = new TextField();
        TextField teamTwoScoreField = new TextField();

        final boolean[] isUpdating = {false};

        Runnable loadSelectedSet = () -> {
            Integer selectedSetNumber = setComboBox.getValue();

            if (selectedSetNumber == null) {
                return;
            }

            Set selectedSet = match.getSets().get(selectedSetNumber - 1);

            isUpdating[0] = true;
            teamOneScoreField.setText(String.valueOf(selectedSet.getTeamOnePoints()));
            teamTwoScoreField.setText(String.valueOf(selectedSet.getTeamTwoPoints()));
            isUpdating[0] = false;
        };

        loadSelectedSet.run();

        setComboBox.setOnAction(event -> {
            Integer selectedSetNumber = setComboBox.getValue();

            if (selectedSetNumber == null) {
                return;
            }

            match.setCurrentSetNumber(selectedSetNumber);
            loadSelectedSet.run();
            refreshScore();
        });

        teamOneScoreField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isUpdating[0] || newValue.isEmpty()) {
                return;
            }

            try {
                int score = Integer.parseInt(newValue);

                if (score < 0) {
                    teamOneScoreField.setText(oldValue);
                    return;
                }

                Set selectedSet = match.getSets().get(setComboBox.getValue() - 1);
                selectedSet.setTeamOnePoints(score);
                refreshScore();

            } catch (NumberFormatException e) {
                teamOneScoreField.setText(oldValue);
            }
        });

        teamTwoScoreField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isUpdating[0] || newValue.isEmpty()) {
                return;
            }

            try {
                int score = Integer.parseInt(newValue);

                if (score < 0) {
                    teamTwoScoreField.setText(oldValue);
                    return;
                }

                Set selectedSet = match.getSets().get(setComboBox.getValue() - 1);
                selectedSet.setTeamTwoPoints(score);
                refreshScore();

            } catch (NumberFormatException e) {
                teamTwoScoreField.setText(oldValue);
            }
        });

        Button backButton = new Button("Back");
        backButton.setPrefWidth(70);
        backButton.setOnAction(event -> editScoreStage.close());

        HBox setBox = new HBox(10);
        setBox.setAlignment(Pos.CENTER);
        setBox.getChildren().addAll(
                new Label("Set:"),
                setComboBox
        );

        HBox scoreBox = new HBox(10);
        scoreBox.setAlignment(Pos.CENTER);
        scoreBox.getChildren().addAll(
                new Label("Team 1:"),
                teamOneScoreField,
                new Label("Team 2:"),
                teamTwoScoreField
        );

        HBox backBox = new HBox();
        backBox.setAlignment(Pos.CENTER_LEFT);
        backBox.getChildren().add(backButton);

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        backBox.setAlignment(Pos.CENTER);
        root.getChildren().addAll(setBox, scoreBox, backBox);

        Scene scene = new Scene(root, 400, 180);
        editScoreStage.setScene(scene);
        editScoreStage.show();
    }

    public void onSecondBallPointsClicked() {
        List<Player> players = List.of(
                match.getPlayer1(),
                match.getPlayer2(),
                match.getPlayer3(),
                match.getPlayer4()
        );

        ChoiceDialog<Player> dialog = new ChoiceDialog<>(match.getPlayer1(), players);
        dialog.setTitle("Second ball point");
        dialog.setHeaderText("Choose player");
        dialog.setContentText("Player:");

        dialog.showAndWait().ifPresent(player -> {
            getCurrentSet().setSecondBallPoints(getCurrentSet().getSecondBallPoints() + 1);
            player.setTotalPoints(player.getTotalPoints() + 1);
            addPointToPlayerTeam(player);
            refreshScore();
        });
    }
}
