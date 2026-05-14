package com.volleyballtracker.controller;

import com.volleyballtracker.model.Match;
import com.volleyballtracker.util.SceneManager;
import com.volleyballtracker.view.NewGameView;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class NewGameController {
    private NewGameView view;
    private SceneManager sceneManager;

    public NewGameController(NewGameView view, SceneManager sceneManager) {
        this.view = view;
        this.sceneManager = sceneManager;

        connectActions();
    }
    private void connectActions() {
        view.getSelectButton().setOnAction(event -> {
            if (isFormValid()){
                List<String> teams_name = List.of(view.getMatchNameFieldString().split("vs"));
                Match new_match = new Match(view.getMatchNameFieldString(), view.getDate(), teams_name.get(0),teams_name.get(1),view.getImport_file(),
                        view.getPlayer1FieldString(), view.getPlayer2FieldString(), view.getPlayer3FieldString(), view.getPlayer4FieldString(), view.getPositionBox1String(), view.getPositionBox2String(),
                        view.getPositionBox3String(), view.getPositionBox4String());

                sceneManager.switchToGameEditor(new_match);
            }
        });

        view.getAutofillCheckBox().setOnAction(event -> {
            if(view.AutofillBoxiscliked()){

                List<String> loetud = readAutofillFile();
                if (loetud.size() >= 4){
                    String player1Name = loetud.get(0);



                String player1Position = loetud.get(1);

                String player2Name = loetud.get(2);
                String player2Position = loetud.get(3);
                view.insertData(player1Name,player2Name,player1Position,player2Position);}
                else {
                    showError("AUTOFILL ERROR", "File does not have enough data.");
                    view.getAutofillCheckBox().setSelected(false);
                }
            }
            else {
                view.clearAutofillFields();
            }

        });

        view.getExitButton().setOnAction(event -> {

            sceneManager.switchToMainMenu();
        });
    }

    private void showError( String Error , String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(Error);
        alert.setContentText(text);
        alert.showAndWait();
    }

    public List<String> readAutofillFile() {
        List<String> lines = new ArrayList<>();


            InputStream inputStream = getClass()
                    .getResourceAsStream("/data/autofill_players.txt");

            if (inputStream == null) {
                throw new IllegalArgumentException("Autofill file not found");
            }

            lines = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8)
            ).lines().toList();

            if (lines.size() < 4) {
                return List.of();
            }

        return lines;
    }
    private boolean isFormValid() {
        if (view.getMatchNameFieldString().isBlank()) {
            showError("Missing data", "Please enter match name.");
            return false;
        }
        if (view.getPlayer1FieldString().isBlank()) {
            showError("Missing data", "Please enter Player 1 name.");
            return false;
        }

        if (view.getPlayer2FieldString().isBlank()) {
            showError("Missing data", "Please enter Player 2 name.");
            return false;
        }

        if (view.getPlayer3FieldString().isBlank()) {
            showError("Missing data", "Please enter Player 3 name.");
            return false;
        }

        if (view.getPlayer4FieldString().isBlank()) {
            showError("Missing data", "Please enter Player 4 name.");
            return false;
        }

        if (view.getDate().isBlank()) {
            showError("Missing data", "Please enter date.");
            return false;
        }

        if (view.getImport_file().isBlank()) {
            showError("Missing data", "Please enter import file.");
            return false;
        }
        if(view.getPositionBox1String().equals("Choose your position")){
            showError(
                    "Missing player position",
                    "Please choose a position for Player 1."
            );
            return false;
        }
        if(view.getPositionBox2String().equals("Choose your position")){
            showError(
                    "Missing player position",
                    "Please choose a position for Player 2."
            );
            return false;
        }
        if(view.getPositionBox3String().equals("Choose your position")){
            showError(
                    "Missing player position",
                    "Please choose a position for Player 3."
            );
            return false;
        }
        if(view.getPositionBox4String().equals("Choose your position")){
            showError(
                    "Missing player position",
                    "Please choose a position for Player 4."
            );
            return false;
        }


        return true;
    }

}
