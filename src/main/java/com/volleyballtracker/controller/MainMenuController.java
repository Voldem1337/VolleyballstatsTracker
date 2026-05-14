package com.volleyballtracker.controller;


import com.volleyballtracker.util.SceneManager;
import com.volleyballtracker.view.MainMenuView;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Controller for Main Menu screen.
 *
 * Screen buttons:
 * - New Game
 * - Open Game
 * - Export Stats
 * - Exit
 */


public class MainMenuController {

    private final MainMenuView view;
    private final SceneManager sceneManager;

    public MainMenuController(MainMenuView view, SceneManager sceneManager) {
        this.view = view;
        this.sceneManager = sceneManager;

        connectActions();
    }


    private void connectActions() {
        view.getNewGameButton().setOnAction(event -> {
            sceneManager.switchToNewGame();
        });
        view.getOpenGameButton().setOnAction(event -> {
            sceneManager.switchToOpenGame();
        });

        view.getExitButton().setOnAction(event -> {
            sceneManager.closeApp();
        });
        view.getAutfillButton().setOnAction(event -> {
            Stage popup = new Stage();
            popup.setTitle("Autofill Editor");

            Label title = new Label("Autofill edit");
            title.setFont(Font.font("Arial", 20));
            Button saveButton = new Button("Save");
            saveButton.setPrefWidth(200);

            TextField player1Field = new TextField();
            player1Field.setPromptText("Player 1 Name");
            player1Field.setPrefSize(270, 45);

            ComboBox<String> positionBox1 = new ComboBox<>();
            positionBox1.getItems().addAll("Choose your position", "Defence", "Block", "Universal");
            positionBox1.setValue("Choose your position");
            positionBox1.setPrefSize(170, 45);

            HBox player1Row = new HBox(20);
            player1Row.setAlignment(Pos.CENTER);
            player1Row.getChildren().addAll(player1Field, positionBox1);

            TextField player2Field = new TextField();
            player2Field.setPromptText("Player 2 Name");
            player2Field.setPrefSize(270, 45);

            ComboBox<String> positionBox2 = new ComboBox<>();
            positionBox2.getItems().addAll("Choose your position", "Defence", "Block", "Universal");
            positionBox2.setValue("Choose your position");
            positionBox2.setPrefSize(170, 45);

            HBox player2Row = new HBox(20);
            player2Row.setAlignment(Pos.CENTER);
            player2Row.getChildren().addAll(player2Field, positionBox2);

            VBox root = new VBox(20);
            root.setAlignment(Pos.CENTER);
            root.setPadding(new Insets(20));
            root.getChildren().addAll(title, player1Row, player2Row,saveButton);

            saveButton.setOnAction(event1 -> {
                String player1name = player1Field.getText();
                String player2name = player2Field.getText();
                String player1position = positionBox1.getValue();
                String player2position = positionBox2.getValue();

                if(isFormValid(player1name, player2name, player1position, player2position)){

                    try {
                        WritetoFile(player1name,player2name, player1position, player2position);
                        popup.close();
                    } catch (IOException e) {
                        showError("Save error", "Could not save autofill data.");
                    }
                }
            });

            Scene scene = new Scene(root, 550, 250);
            popup.setScene(scene);

            popup.showAndWait();
        });

    }
    private boolean isFormValid(String player1Field,String player2Field, String positionBox1, String positionBox2 ) {

        if (player1Field.isBlank()) {
            showError("Missing data", "Please enter Player 1 name.");
            return false;
        }

        if (player2Field.isBlank()) {
            showError("Missing data", "Please enter Player 2 name.");
            return false;
        }
        if (positionBox1.equals("Choose your position")) {
            showError(
                    "Missing player position",
                    "Please choose a position for Player 1."
            );
            return false;
        }
        if (positionBox2.equals("Choose your position")) {
            showError(
                    "Missing player position",
                    "Please choose a position for Player 2."
            );
            return false;
        }
        return true;
    }
    private void showError(String header, String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }
    private void WritetoFile(String player1name, String player2name, String player1Position,String player2Position) throws IOException {
        Path path = Path.of("src", "main", "resources", "data", "autofill_players.txt");
        String content = player1name + "\n" + player1Position + "\n" + player2name+ "\n" + player2Position;
        Files.writeString(path,content);

    }



}
