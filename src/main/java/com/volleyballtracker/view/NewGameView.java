package com.volleyballtracker.view;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.control.Button;


public class NewGameView {
    private VBox root;
    private Button exitButton;
    private TextField matchNameField;
    private TextField player1Field;
    private TextField player2Field;
    private TextField player3Field;
    private TextField player4Field;
    private ComboBox<String> positionBox1;
    private ComboBox<String> positionBox2;
    private ComboBox<String> positionBox3;
    private ComboBox<String> positionBox4;
    private CheckBox autofillCheckBox;
    private TextField date;
    private TextField Import_file;
    private Button selectButton;

    public NewGameView(){
        createView();
    }


    public void createView() {

        root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        matchNameField = new TextField();
        matchNameField.setPromptText("Match Name");
        matchNameField.setPrefWidth(400);

        exitButton = new Button("Back");
        exitButton.setPrefWidth(50);

        HBox matchInfoRow = new HBox(20);
        matchInfoRow.setAlignment(Pos.CENTER);
        matchInfoRow.getChildren().addAll(matchNameField, exitButton);





        Label titleteam1 = new Label("TEAM 1");
        titleteam1.setFont(Font.font("Arial", 28));
        titleteam1.setAlignment(Pos.CENTER);

        player1Field = new TextField();
        player1Field.setPromptText("Player 1 Name");
        player1Field.setPrefSize(270, 45);


        positionBox1 = new ComboBox<>();
        positionBox1.getItems().addAll("Choose your position", "Defence", "Block", "Universal");
        positionBox1.setValue("Choose your position");
        positionBox1.setPrefSize(170, 45);

        HBox player1Row = new HBox(20);
        player1Row.setAlignment(Pos.CENTER);
        player1Row.getChildren().addAll(player1Field, positionBox1);


        player2Field = new TextField();
        player2Field.setPromptText("Player 2 Name");
        player2Field.setPrefSize(270, 45);

        positionBox2 = new ComboBox<>();
        positionBox2.getItems().addAll("Choose your position", "Defence", "Block", "Universal");
        positionBox2.setValue("Choose your position");
        positionBox2.setPrefSize(170, 45);

        HBox player2Row = new HBox(20);
        player2Row.setAlignment(Pos.CENTER);
        player2Row.getChildren().addAll(player2Field, positionBox2);


        Label autofillLabel = new Label("Autofill");
        autofillLabel.setFont(Font.font("Arial", 18));

        date = new TextField();
        date.setPromptText("Date: dd.mm.yyyy");
        date.setPrefWidth(150);

        autofillCheckBox = new CheckBox();
        autofillCheckBox.setPrefSize(30, 30);

        HBox autofillRow = new HBox(20);
        autofillRow.setAlignment(Pos.CENTER_LEFT);
        autofillRow.setMaxWidth(460);

        autofillRow.getChildren().addAll(
                autofillLabel,
                autofillCheckBox,
                date
        );

        String inputStyle =
                "-fx-background-color: white;" +
                        "-fx-border-color: black;" +
                        "-fx-border-radius: 6;" +
                        "-fx-background-radius: 6;" +
                        "-fx-font-size: 16px;";

        player1Field.setStyle(inputStyle);
        player2Field.setStyle(inputStyle);
        positionBox1.setStyle(inputStyle);
        positionBox2.setStyle(inputStyle);

        Label titleteam2 = new Label("TEAM 2");
        titleteam2.setFont(Font.font("Arial", 28));
        titleteam2.setAlignment(Pos.CENTER);

        player3Field = new TextField();
        player3Field.setPromptText("Player 3 Name");
        player3Field.setPrefSize(270, 45);


        positionBox3 = new ComboBox<>();
        positionBox3.getItems().addAll("Choose your position", "Defence", "Block", "Universal");
        positionBox3.setValue("Choose your position");
        positionBox3.setPrefSize(170, 45);

        HBox player3Row = new HBox(20);
        player3Row.setAlignment(Pos.CENTER);
        player3Row.getChildren().addAll(player3Field, positionBox3);

        player4Field = new TextField();
        player4Field.setPromptText("Player 4 Name");
        player4Field.setPrefSize(270, 45);


        positionBox4 = new ComboBox<>();
        positionBox4.getItems().addAll("Choose your position", "Defence", "Block", "Universal");
        positionBox4.setValue("Choose your position");
        positionBox4.setPrefSize(170, 45);


        HBox player4Row = new HBox(20);
        player4Row.setAlignment(Pos.CENTER);
        player4Row.getChildren().addAll(player4Field, positionBox4);

        Label title_importfile = new Label("Volleyball Stats Tracker");
        title_importfile.setFont(Font.font("Arial", 28));
        title_importfile.setAlignment(Pos.CENTER);

        Import_file = new TextField();
        Import_file.setPromptText("path/to/file");
        Import_file.setPrefWidth(350);

        selectButton = new Button("Create");
        selectButton.setPrefSize(180, 45);
        selectButton.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;"
        );

        player1Field.textProperty().addListener((observable, oldValue, newValue) -> {
            updateMatchName();
            updateFilename();
        });

        player2Field.textProperty().addListener((observable, oldValue, newValue) -> {
            updateMatchName();
            updateFilename();
        });

        player3Field.textProperty().addListener((observable, oldValue, newValue) -> {
            updateMatchName();
            updateFilename();
        });

        player4Field.textProperty().addListener((observable, oldValue, newValue) -> {
            updateMatchName();
            updateFilename();
        });

        date.textProperty().addListener((observable, oldValue, newValue) -> {
            updateMatchName();
            updateFilename();
        });


        root.getChildren().addAll(
                matchInfoRow,
                titleteam1,
                player1Row,
                player2Row,
                autofillRow,
                titleteam2,
                player3Row,
                player4Row,
                title_importfile,
                Import_file,
                selectButton
        );
    }

    public void setPlayer1Field(String text) {
        this.player1Field.setText(text);
    }

    public void setPlayer2Field(String text) {
        this.player2Field.setText(text);
    }

    public void setImport_file(String text) {
        this.Import_file.setText(text);
    }




    public Parent getRoot() {
        return root;
    }

    public String getMatchNameFieldString() {
        return this.matchNameField.getText();
    }

    public String getPlayer1FieldString() {
        return this.player1Field.getText();
    }

    public String getPlayer2FieldString() {
        return this.player2Field.getText();
    }

    public String getPlayer3FieldString() {
        return this.player3Field.getText();
    }

    public String getPlayer4FieldString() {
        return this.player4Field.getText();
    }

    public String getPositionBox1String() {
        return this.positionBox1.getValue();
    }

    public String getPositionBox2String() {
        return this.positionBox2.getValue();
    }

    public String getPositionBox3String() {
        return this.positionBox3.getValue();
    }

    public String getPositionBox4String() {
        return this.positionBox4.getValue();
    }

    public CheckBox getAutofillCheckBox() {
        return this.autofillCheckBox;
    }
    public boolean AutofillBoxiscliked(){
        return this.autofillCheckBox.isSelected();
    }

    public String getImport_file() {
        return this.Import_file.getText();
    }

    public Button getSelectButton() {
        return selectButton;
    }

    public Button getExitButton() {
        return exitButton;
    }

    public String getDate() {
        return this.date.getText();
    }
    public void clearAutofillFields() {
        player1Field.clear();
        player2Field.clear();
        player3Field.clear();
        player4Field.clear();
        positionBox1.setValue("Choose your position");
        positionBox2.setValue("Choose your position");
        positionBox3.setValue("Choose your position");
        positionBox4.setValue("Choose your position");
    }
    public void insertData(String Player1name,String Player2Name, String Player1Pos,
                           String Player2pos){

        player1Field.setText(Player1name);
        player2Field.setText(Player2Name);
        positionBox1.setValue(Player1Pos);
        positionBox2.setValue(Player2pos);
    }
    private void updateMatchName() {
        String player1 = player1Field.getText();
        String player2 = player2Field.getText();
        String player3 = player3Field.getText();
        String player4 = player4Field.getText();
        String matchDate = date.getText();

        String matchName = player1 + "/" + player2 + " vs " + player3 + "/" + player4;

        if (!matchDate.isBlank()) {
            matchName = matchName + " - " + matchDate;
        }

        matchNameField.setText(matchName);
    }
    private void updateFilename(){
        String player1 = player1Field.getText();
        String player2 = player2Field.getText();
        String player3 = player3Field.getText();
        String player4 = player4Field.getText();
        String matchDate = date.getText();

        String matchName = player1 + "_" + player2 + "_vs_" + player3 + "_" + player4;

        if (!matchDate.isBlank()) {
            matchName = matchName + "_" + matchDate;
        }

        matchName = matchName + ".json";
        Import_file.setText(matchName);
    }
}
