package com.volleyballtracker.model;

/**
 * Model class for one set.
 *
 * Stores score, set number, rally counter, second ball points,
 * and action statistics for Serve, Receive, Attack, Block, and Dig.
 */
public class Set {

    private int setNumber;

    private int teamOnePoints;
    private int teamTwoPoints;

    private boolean isFinished;

    // 0 = no winner yet, 1 = Team 1, 2 = Team 2.
    private int whoWon;

    private int rallyCounter;
    private int secondBallPoints;

    // Serve statistics
    private int floatServe;
    private int jumpServe;
    private int serveAce;
    private int serveAttempt;
    private int serveError;

    // Receive statistics
    private int receiveForTheOption;
    private int goodReceive;
    private int hardToSet;
    private int receiveError;

    // Attack statistics
    private int spikeKill;
    private int spikeError;
    private int cutShotKill;
    private int cutShotError;
    private int spikeAttempt;
    private int cutShotAttempt;

    // Block statistics
    private int monsterBlock;
    private int veryGoodBlockTouch;
    private int blockTouch;
    private int blockOut;

    // Dig statistics
    private int dig;
    private int digError;

    /** Adds one point to Team 1. */
    public void addPointToTeamOne() {
        // TODO: Increase teamOnePoints.
    }

    /** Adds one point to Team 2. */
    public void addPointToTeamTwo() {
        // TODO: Increase teamTwoPoints.
    }

    /** Checks whether this set is finished. */
    public boolean checkSetFinished() {
        // TODO: Apply set rules: first sets to 21, third set to 15, with 2-point difference.
        return false;
    }

    /** Resets the score to 0:0. */
    public void resetScore() {
        // TODO: Reset team points.
    }

    /** Increases rally counter. */
    public void increaseRallyCounter() {
        // TODO: Increase rallyCounter.
    }

    /** Increases second ball points counter. */
    public void increaseSecondBallPoints() {
        // TODO: Increase secondBallPoints.
    }
}
