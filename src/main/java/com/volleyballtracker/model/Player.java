package com.volleyballtracker.model;

/**
 * Model class for one player.
 *
 * Stores player name, team, position, overall stats,
 * total points and total errors.
 */
public class Player {

    private String name;
    private PlayerPosition position;
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
    private int veryGoodBlockTouch;
    private int blockTouch;
    private int blockOut;

    // Dig
    private int dig;
    private int digError;

    /** Updates overall player statistics. */
    public void updateOverallStats() {
        // TODO: Recalculate overall attack, receive, dig, and block values.
    }

    /** Returns success percentage for this player. */
    public double getSuccessPercentage() {
        // TODO: Calculate successful actions / total actions.
        return 0;
    }
}
