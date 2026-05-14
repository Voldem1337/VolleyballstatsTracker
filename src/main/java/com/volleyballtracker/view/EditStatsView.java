package com.volleyballtracker.view;

import com.volleyballtracker.model.Player;
import com.volleyballtracker.model.TableRow;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.converter.NumberStringConverter;

import java.util.List;

/**
 * EditStatsView
 * <p>
 * Экран редактирования записанной статистики.
 * Здесь пользователь сможет выбрать действие и изменить или удалить его.
 */
public class EditStatsView {
    private VBox root;

    private Label titleLabel;
    private TableView<TableRow> statsTable;
    private HBox buttonsBox;

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

        statsTable = new TableView<>();
        statsTable.setEditable(true);


        tableAddColumns(statsTable);



        Player player1 = new Player("Alex", "Blocker", "Selver");
        Player player2 = new Player("Alex", "Blocker", "Selver");
        Player player3 = new Player("Alex", "Blocker", "Selver");
        Player player4 = new Player("Alex", "Blocker", "Selver");
        List<Player> players = List.of(player1, player2, player3, player4);

        for (Player p : players) {
            addPlayerToTable(p);
        }


        saveButton = new Button("Save");
        backButton = new Button("Back");

        setButtonSizeBig(saveButton);
        setButtonSizeBig(backButton);

        buttonsBox = new HBox(20);
        buttonsBox.setPadding(new Insets(10, 0, 0, 20));
        buttonsBox.getChildren().addAll(saveButton, backButton);

        root.getChildren().addAll(titleLabel, statsTable, buttonsBox);

    }

    public VBox getRoot() {
        return root;
    }

    public Label getTitleLabel() {
        return titleLabel;
    }

    public TableView<TableRow> getStatsTable() {

        return statsTable;
    }

    public HBox getButtonsBox() {
        return buttonsBox;
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

    public void addPlayerToTable(Player player) {
        TableRow row = new TableRow(
                player.getName(),
                player.getOverallAttack(),
                player.getOverallReceive(),
                player.getOverallDig(),
                player.getOverallBlock(),
                player.getTotalPoints(),
                player.getTotalErrors(),
                player.getFloatServe(),
                player.getJumpServe(),
                player.getAce(),
                player.getServeAttempt(),
                player.getServeError(),
                player.getReceiveForTheOption(),
                player.getGoodReceive(),
                player.getHardToSet(),
                player.getReceiveError(),
                player.getSpikeKill(),
                player.getSpikeError(),
                player.getCutShotKill(),
                player.getCutShotError(),
                player.getSpikeAttempt(),
                player.getCutShotAttempt(),
                player.getMonsterBlock(),
                player.getBlockTouch(),
                player.getBlockError(),
                player.getDig(),
                player.getDigError()
        );

        statsTable.getItems().add(row);
    }

    private void tableAddColumns(TableView<TableRow> table) {
        TableColumn<TableRow, String> playerNameColumn = new TableColumn<>("Player");
        playerNameColumn.setCellValueFactory(data -> data.getValue().playerNameProperty());

        TableColumn<TableRow, Number> overallAttackColumn = new TableColumn<>("Overall Attack");
        overallAttackColumn.setCellValueFactory(data -> data.getValue().overallAttackProperty());

        TableColumn<TableRow, Number> overallReceiveColumn = new TableColumn<>("Overall Receive");
        overallReceiveColumn.setCellValueFactory(data -> data.getValue().overallReceiveProperty());

        TableColumn<TableRow, Number> overallDigColumn = new TableColumn<>("Overall Dig");
        overallDigColumn.setCellValueFactory(data -> data.getValue().overallDigProperty());

        TableColumn<TableRow, Number> overallBlockColumn = new TableColumn<>("Overall Block");
        overallBlockColumn.setCellValueFactory(data -> data.getValue().overallBlockProperty());

        TableColumn<TableRow, Number> totalPointsColumn = new TableColumn<>("Total Points");
        totalPointsColumn.setCellValueFactory(data -> data.getValue().totalPointsProperty());

        TableColumn<TableRow, Number> totalErrorsColumn = new TableColumn<>("Total Errors");
        totalErrorsColumn.setCellValueFactory(data -> data.getValue().totalErrorsProperty());

        TableColumn<TableRow, Number> floatServeColumn = new TableColumn<>("Float Serve");
        floatServeColumn.setCellValueFactory(data -> data.getValue().floatServeProperty());

        TableColumn<TableRow, Number> jumpServeColumn = new TableColumn<>("Jump Serve");
        jumpServeColumn.setCellValueFactory(data -> data.getValue().jumpServeProperty());

        TableColumn<TableRow, Number> aceColumn = new TableColumn<>("Ace");
        aceColumn.setCellValueFactory(data -> data.getValue().aceProperty());

        TableColumn<TableRow, Number> serveAttemptColumn = new TableColumn<>("Serve Attempt");
        serveAttemptColumn.setCellValueFactory(data -> data.getValue().serveAttemptProperty());

        TableColumn<TableRow, Number> serveErrorColumn = new TableColumn<>("Serve Error");
        serveErrorColumn.setCellValueFactory(data -> data.getValue().serveErrorProperty());

        TableColumn<TableRow, Number> receiveForTheOptionColumn = new TableColumn<>("Receive Option");
        receiveForTheOptionColumn.setCellValueFactory(data -> data.getValue().receiveForTheOptionProperty());

        TableColumn<TableRow, Number> goodReceiveColumn = new TableColumn<>("Good Receive");
        goodReceiveColumn.setCellValueFactory(data -> data.getValue().goodReceiveProperty());

        TableColumn<TableRow, Number> hardToSetColumn = new TableColumn<>("Hard To Set");
        hardToSetColumn.setCellValueFactory(data -> data.getValue().hardToSetProperty());

        TableColumn<TableRow, Number> receiveErrorColumn = new TableColumn<>("Receive Error");
        receiveErrorColumn.setCellValueFactory(data -> data.getValue().receiveErrorProperty());

        TableColumn<TableRow, Number> spikeKillColumn = new TableColumn<>("Spike Kill");
        spikeKillColumn.setCellValueFactory(data -> data.getValue().spikeKillProperty());

        TableColumn<TableRow, Number> spikeErrorColumn = new TableColumn<>("Spike Error");
        spikeErrorColumn.setCellValueFactory(data -> data.getValue().spikeErrorProperty());

        TableColumn<TableRow, Number> cutShotKillColumn = new TableColumn<>("Cut Shot Kill");
        cutShotKillColumn.setCellValueFactory(data -> data.getValue().cutShotKillProperty());

        TableColumn<TableRow, Number> cutShotErrorColumn = new TableColumn<>("Cut Shot Error");
        cutShotErrorColumn.setCellValueFactory(data -> data.getValue().cutShotErrorProperty());

        TableColumn<TableRow, Number> spikeAttemptColumn = new TableColumn<>("Spike Attempt");
        spikeAttemptColumn.setCellValueFactory(data -> data.getValue().spikeAttemptProperty());

        TableColumn<TableRow, Number> cutShotAttemptColumn = new TableColumn<>("Cut Shot Attempt");
        cutShotAttemptColumn.setCellValueFactory(data -> data.getValue().cutShotAttemptProperty());

        TableColumn<TableRow, Number> monsterBlockColumn = new TableColumn<>("Monster Block");
        monsterBlockColumn.setCellValueFactory(data -> data.getValue().monsterBlockProperty());

        TableColumn<TableRow, Number> blockTouchColumn = new TableColumn<>("Block Touch");
        blockTouchColumn.setCellValueFactory(data -> data.getValue().blockTouchProperty());

        TableColumn<TableRow, Number> blockErrorColumn = new TableColumn<>("Block Error");
        blockErrorColumn.setCellValueFactory(data -> data.getValue().blockErrorProperty());

        TableColumn<TableRow, Number> digColumn = new TableColumn<>("Dig");
        digColumn.setCellValueFactory(data -> data.getValue().digProperty());

        TableColumn<TableRow, Number> digErrorColumn = new TableColumn<>("Dig Error");
        digErrorColumn.setCellValueFactory(data -> data.getValue().digErrorProperty());

        table.getColumns().addAll(
                playerNameColumn,
                overallAttackColumn,
                overallReceiveColumn,
                overallDigColumn,
                overallBlockColumn,
                totalPointsColumn,
                totalErrorsColumn,
                floatServeColumn,
                jumpServeColumn,
                aceColumn,
                serveAttemptColumn,
                serveErrorColumn,
                receiveForTheOptionColumn,
                goodReceiveColumn,
                hardToSetColumn,
                receiveErrorColumn,
                spikeKillColumn,
                spikeErrorColumn,
                cutShotKillColumn,
                cutShotErrorColumn,
                spikeAttemptColumn,
                cutShotAttemptColumn,
                monsterBlockColumn,
                blockTouchColumn,
                blockErrorColumn,
                digColumn,
                digErrorColumn
        );

        makeEditable(overallAttackColumn);
        makeEditable(overallReceiveColumn);
        makeEditable(overallDigColumn);
        makeEditable(overallBlockColumn);

        makeEditable(totalPointsColumn);
        makeEditable(totalErrorsColumn);

        makeEditable(floatServeColumn);
        makeEditable(jumpServeColumn);
        makeEditable(aceColumn);
        makeEditable(serveAttemptColumn);
        makeEditable(serveErrorColumn);

        makeEditable(receiveForTheOptionColumn);
        makeEditable(goodReceiveColumn);
        makeEditable(hardToSetColumn);
        makeEditable(receiveErrorColumn);

        makeEditable(spikeKillColumn);
        makeEditable(spikeErrorColumn);
        makeEditable(cutShotKillColumn);
        makeEditable(cutShotErrorColumn);
        makeEditable(spikeAttemptColumn);
        makeEditable(cutShotAttemptColumn);

        makeEditable(monsterBlockColumn);
        makeEditable(blockTouchColumn);
        makeEditable(blockErrorColumn);

        makeEditable(digColumn);
        makeEditable(digErrorColumn);
    }

    private void makeEditable(TableColumn<TableRow, Number> column) {
        column.setCellFactory(
                TextFieldTableCell.forTableColumn(new NumberStringConverter())
        );

        column.setOnEditCommit(event -> {
            Integer newValue = event.getNewValue().intValue();
        });
    }
}
