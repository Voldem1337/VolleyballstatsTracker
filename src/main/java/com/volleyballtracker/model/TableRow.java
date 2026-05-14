package com.volleyballtracker.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableRow {
    private final SimpleStringProperty playerName;
    private final SimpleIntegerProperty overallAttack;
    private final SimpleIntegerProperty overallReceive;
    private final SimpleIntegerProperty overallDig;
    private final SimpleIntegerProperty overallBlock;

    private final SimpleIntegerProperty totalPoints;
    private final SimpleIntegerProperty totalErrors;

    private final SimpleIntegerProperty floatServe;
    private final SimpleIntegerProperty jumpServe;
    private final SimpleIntegerProperty ace;
    private final SimpleIntegerProperty serveAttempt;
    private final SimpleIntegerProperty serveError;

    private final SimpleIntegerProperty receiveForTheOption;
    private final SimpleIntegerProperty goodReceive;
    private final SimpleIntegerProperty hardToSet;
    private final SimpleIntegerProperty receiveError;

    private final SimpleIntegerProperty spikeKill;
    private final SimpleIntegerProperty spikeError;
    private final SimpleIntegerProperty cutShotKill;
    private final SimpleIntegerProperty cutShotError;
    private final SimpleIntegerProperty spikeAttempt;
    private final SimpleIntegerProperty cutShotAttempt;

    private final SimpleIntegerProperty monsterBlock;
    private final SimpleIntegerProperty blockTouch;
    private final SimpleIntegerProperty blockError;

    private final SimpleIntegerProperty dig;
    private final SimpleIntegerProperty digError;

    public TableRow(
            String playerName, int overallAttack,
            int overallReceive,
            int overallDig,
            int overallBlock,
            int totalPoints,
            int totalErrors,
            int floatServe,
            int jumpServe,
            int ace,
            int serveAttempt,
            int serveError,
            int receiveForTheOption,
            int goodReceive,
            int hardToSet,
            int receiveError,
            int spikeKill,
            int spikeError,
            int cutShotKill,
            int cutShotError,
            int spikeAttempt,
            int cutShotAttempt,
            int monsterBlock,
            int blockTouch,
            int blockError,
            int dig,
            int digError
    ) {
        this.playerName = new SimpleStringProperty(playerName);
        this.overallAttack = new SimpleIntegerProperty(overallAttack);
        this.overallReceive = new SimpleIntegerProperty(overallReceive);
        this.overallDig = new SimpleIntegerProperty(overallDig);
        this.overallBlock = new SimpleIntegerProperty(overallBlock);

        this.totalPoints = new SimpleIntegerProperty(totalPoints);
        this.totalErrors = new SimpleIntegerProperty(totalErrors);

        this.floatServe = new SimpleIntegerProperty(floatServe);
        this.jumpServe = new SimpleIntegerProperty(jumpServe);
        this.ace = new SimpleIntegerProperty(ace);
        this.serveAttempt = new SimpleIntegerProperty(serveAttempt);
        this.serveError = new SimpleIntegerProperty(serveError);

        this.receiveForTheOption = new SimpleIntegerProperty(receiveForTheOption);
        this.goodReceive = new SimpleIntegerProperty(goodReceive);
        this.hardToSet = new SimpleIntegerProperty(hardToSet);
        this.receiveError = new SimpleIntegerProperty(receiveError);

        this.spikeKill = new SimpleIntegerProperty(spikeKill);
        this.spikeError = new SimpleIntegerProperty(spikeError);
        this.cutShotKill = new SimpleIntegerProperty(cutShotKill);
        this.cutShotError = new SimpleIntegerProperty(cutShotError);
        this.spikeAttempt = new SimpleIntegerProperty(spikeAttempt);
        this.cutShotAttempt = new SimpleIntegerProperty(cutShotAttempt);

        this.monsterBlock = new SimpleIntegerProperty(monsterBlock);
        this.blockTouch = new SimpleIntegerProperty(blockTouch);
        this.blockError = new SimpleIntegerProperty(blockError);

        this.dig = new SimpleIntegerProperty(dig);
        this.digError = new SimpleIntegerProperty(digError);
    }

    public SimpleStringProperty playerNameProperty() {
        return playerName;
    }

    public SimpleIntegerProperty overallAttackProperty() {
        return overallAttack;
    }

    public SimpleIntegerProperty overallReceiveProperty() {
        return overallReceive;
    }

    public SimpleIntegerProperty overallDigProperty() {
        return overallDig;
    }

    public SimpleIntegerProperty overallBlockProperty() {
        return overallBlock;
    }

    public SimpleIntegerProperty totalPointsProperty() {
        return totalPoints;
    }

    public SimpleIntegerProperty totalErrorsProperty() {
        return totalErrors;
    }

    public SimpleIntegerProperty floatServeProperty() {
        return floatServe;
    }

    public SimpleIntegerProperty jumpServeProperty() {
        return jumpServe;
    }

    public SimpleIntegerProperty aceProperty() {
        return ace;
    }

    public SimpleIntegerProperty serveAttemptProperty() {
        return serveAttempt;
    }

    public SimpleIntegerProperty serveErrorProperty() {
        return serveError;
    }

    public SimpleIntegerProperty receiveForTheOptionProperty() {
        return receiveForTheOption;
    }

    public SimpleIntegerProperty goodReceiveProperty() {
        return goodReceive;
    }

    public SimpleIntegerProperty hardToSetProperty() {
        return hardToSet;
    }

    public SimpleIntegerProperty receiveErrorProperty() {
        return receiveError;
    }

    public SimpleIntegerProperty spikeKillProperty() {
        return spikeKill;
    }

    public SimpleIntegerProperty spikeErrorProperty() {
        return spikeError;
    }

    public SimpleIntegerProperty cutShotKillProperty() {
        return cutShotKill;
    }

    public SimpleIntegerProperty cutShotErrorProperty() {
        return cutShotError;
    }

    public SimpleIntegerProperty spikeAttemptProperty() {
        return spikeAttempt;
    }

    public SimpleIntegerProperty cutShotAttemptProperty() {
        return cutShotAttempt;
    }

    public SimpleIntegerProperty monsterBlockProperty() {
        return monsterBlock;
    }

    public SimpleIntegerProperty blockTouchProperty() {
        return blockTouch;
    }

    public SimpleIntegerProperty blockErrorProperty() {
        return blockError;
    }

    public SimpleIntegerProperty digProperty() {
        return dig;
    }

    public SimpleIntegerProperty digErrorProperty() {
        return digError;
    }

    public String getPlayerName() {
        return playerName.get();
    }

    public int getOverallAttack() {
        return overallAttack.get();
    }

    public int getOverallReceive() {
        return overallReceive.get();
    }

    public int getOverallDig() {
        return overallDig.get();
    }

    public int getOverallBlock() {
        return overallBlock.get();
    }

    public int getTotalPoints() {
        return totalPoints.get();
    }

    public int getTotalErrors() {
        return totalErrors.get();
    }

    public int getFloatServe() {
        return floatServe.get();
    }

    public int getJumpServe() {
        return jumpServe.get();
    }

    public int getAce() {
        return ace.get();
    }

    public int getServeAttempt() {
        return serveAttempt.get();
    }

    public int getServeError() {
        return serveError.get();
    }

    public int getReceiveForTheOption() {
        return receiveForTheOption.get();
    }

    public int getGoodReceive() {
        return goodReceive.get();
    }

    public int getHardToSet() {
        return hardToSet.get();
    }

    public int getReceiveError() {
        return receiveError.get();
    }

    public int getSpikeKill() {
        return spikeKill.get();
    }

    public int getSpikeError() {
        return spikeError.get();
    }

    public int getCutShotKill() {
        return cutShotKill.get();
    }

    public int getCutShotError() {
        return cutShotError.get();
    }

    public int getSpikeAttempt() {
        return spikeAttempt.get();
    }

    public int getCutShotAttempt() {
        return cutShotAttempt.get();
    }

    public int getMonsterBlock() {
        return monsterBlock.get();
    }

    public int getBlockTouch() {
        return blockTouch.get();
    }

    public int getBlockError() {
        return blockError.get();
    }

    public int getDig() {
        return dig.get();
    }

    public int getDigError() {
        return digError.get();
    }
}
