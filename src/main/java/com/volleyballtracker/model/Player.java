package com.volleyballtracker.model;

public class Player {

    private String name;
    private String position;
    private String teamName;

    private int overallAttack;
    private int overallReceive;
    private int overallDig;
    private int overallBlock;

    private int totalPoints;
    private int totalErrors;

    // Serve
    private int floatServe;
    private int jumpServe;
    private int ace;
    private int serveAttempt;
    private int serveError;

    // Receive
    private int receiveForTheOption;
    private int goodReceive;
    private int hardToSet;
    private int receiveError;

    // Attack
    private int spikeKill;
    private int spikeError;
    private int cutShotKill;
    private int cutShotError;
    private int spikeAttempt;
    private int cutShotAttempt;

    // Block
    private int monsterBlock;
    private int blockTouch;
    private int blockError;

    // Dig
    private int dig;
    private int digError;

    public Player(String name, String position, String teamName) {
        this.name = name;
        this.position = position;
        this.teamName = teamName;

        this.overallAttack = 0;
        this.overallReceive = 0;
        this.overallDig = 0;
        this.overallBlock = 0;

        this.totalPoints = 0;
        this.totalErrors = 0;

        this.floatServe = 0;
        this.jumpServe = 0;
        this.ace = 0;
        this.serveAttempt = 0;
        this.serveError = 0;

        this.receiveForTheOption = 0;
        this.goodReceive = 0;
        this.hardToSet = 0;
        this.receiveError = 0;

        this.spikeKill = 0;
        this.spikeError = 0;
        this.cutShotKill = 0;
        this.cutShotError = 0;
        this.spikeAttempt = 0;
        this.cutShotAttempt = 0;

        this.monsterBlock = 0;
        this.blockTouch = 0;
        this.blockError = 0;

        this.dig = 0;
        this.digError = 0;

    }

    public Player(String name, String position, String teamName, int overallAttack, int overallReceive, int overallDig, int overallBlock, int totalPoints, int totalErrors, int floatServe, int jumpServe, int ace, int serveAttempt, int serveError, int receiveForTheOption, int goodReceive, int hardToSet, int receiveError, int spikeKill, int spikeError, int cutShotKill, int cutShotError, int spikeAttempt, int cutShotAttempt, int monsterBlock, int blockTouch, int blockError, int dig, int digError) {
        this.name = name;
        this.position = position;
        this.teamName = teamName;
        this.overallAttack = overallAttack;
        this.overallReceive = overallReceive;
        this.overallDig = overallDig;
        this.overallBlock = overallBlock;
        this.totalPoints = totalPoints;
        this.totalErrors = totalErrors;
        this.floatServe = floatServe;
        this.jumpServe = jumpServe;
        this.ace = ace;
        this.serveAttempt = serveAttempt;
        this.serveError = serveError;
        this.receiveForTheOption = receiveForTheOption;
        this.goodReceive = goodReceive;
        this.hardToSet = hardToSet;
        this.receiveError = receiveError;
        this.spikeKill = spikeKill;
        this.spikeError = spikeError;
        this.cutShotKill = cutShotKill;
        this.cutShotError = cutShotError;
        this.spikeAttempt = spikeAttempt;
        this.cutShotAttempt = cutShotAttempt;
        this.monsterBlock = monsterBlock;
        this.blockTouch = blockTouch;
        this.blockError = blockError;
        this.dig = dig;
        this.digError = digError;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getTeamName() {
        return teamName;
    }


    public void setOverallAttack(int overallAttack) {
        this.overallAttack = overallAttack;
    }

    public void setOverallReceive(int overallReceive) {
        this.overallReceive = overallReceive;
    }

    public void setOverallDig(int overallDig) {
        this.overallDig = overallDig;
    }

    public void setOverallBlock(int overallBlock) {
        this.overallBlock = overallBlock;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setTotalErrors(int totalErrors) {
        this.totalErrors = totalErrors;
    }

    public void setFloatServe(int floatServe) {
        this.floatServe = floatServe;
    }

    public void setJumpServe(int jumpServe) {
        this.jumpServe = jumpServe;
    }

    public void setAce(int ace) {
        this.ace = ace;
    }

    public void setServeAttempt(int serveAttempt) {
        this.serveAttempt = serveAttempt;
    }

    public void setServeError(int serveError) {
        this.serveError = serveError;
    }

    public void setReceiveForTheOption(int receiveForTheOption) {
        this.receiveForTheOption = receiveForTheOption;
    }

    public void setGoodReceive(int goodReceive) {
        this.goodReceive = goodReceive;
    }

    public void setHardToSet(int hardToSet) {
        this.hardToSet = hardToSet;
    }

    public void setReceiveError(int receiveError) {
        this.receiveError = receiveError;
    }

    public void setSpikeKill(int spikeKill) {
        this.spikeKill = spikeKill;
    }

    public void setSpikeError(int spikeError) {
        this.spikeError = spikeError;
    }

    public void setCutShotKill(int cutShotKill) {
        this.cutShotKill = cutShotKill;
    }

    public void setCutShotError(int cutShotError) {
        this.cutShotError = cutShotError;
    }

    public void setSpikeAttempt(int spikeAttempt) {
        this.spikeAttempt = spikeAttempt;
    }

    public void setCutShotAttempt(int cutShotAttempt) {
        this.cutShotAttempt = cutShotAttempt;
    }

    public void setMonsterBlock(int monsterBlock) {
        this.monsterBlock = monsterBlock;
    }

    public void setBlockTouch(int blockTouch) {
        this.blockTouch = blockTouch;
    }

    public void setBlockError(int blockError) {
        this.blockError = blockError;
    }

    public void setDig(int dig) {
        this.dig = dig;
    }

    public void setDigError(int digError) {
        this.digError = digError;
    }

    public int getOverallAttack() {
        return overallAttack;
    }

    public int getOverallReceive() {
        return overallReceive;
    }

    public int getOverallDig() {
        return overallDig;
    }

    public int getOverallBlock() {
        return overallBlock;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getTotalErrors() {
        return totalErrors;
    }

    public int getFloatServe() {
        return floatServe;
    }

    public int getJumpServe() {
        return jumpServe;
    }

    public int getAce() {
        return ace;
    }

    public int getServeAttempt() {
        return serveAttempt;
    }

    public int getServeError() {
        return serveError;
    }

    public int getReceiveForTheOption() {
        return receiveForTheOption;
    }

    public int getGoodReceive() {
        return goodReceive;
    }

    public int getHardToSet() {
        return hardToSet;
    }

    public int getReceiveError() {
        return receiveError;
    }

    public int getSpikeKill() {
        return spikeKill;
    }

    public int getSpikeError() {
        return spikeError;
    }

    public int getCutShotKill() {
        return cutShotKill;
    }

    public int getCutShotError() {
        return cutShotError;
    }

    public int getSpikeAttempt() {
        return spikeAttempt;
    }

    public int getCutShotAttempt() {
        return cutShotAttempt;
    }

    public int getMonsterBlock() {
        return monsterBlock;
    }

    public int getBlockTouch() {
        return blockTouch;
    }

    public int getBlockError() {
        return blockError;
    }

    public int getDig() {
        return dig;
    }

    public int getDigError() {
        return digError;
    }

    /** Updates overall player statistics. */
    public void updateOverallStats() {
        // TODO: Recalculate overall attack, receive, dig, and block values.
    }

    /** Returns success percentage for this player. */
    public double getSuccessPercentage() {
        // TODO: Calculate successful actions / total actions.
        return 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
