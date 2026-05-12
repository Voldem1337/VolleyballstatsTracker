package com.volleyballtracker.model;

/**
 * Model class for one player.
 *
 * Stores player name, team, position, overall stats,
 * total points and total errors.
 */
public class Player {

    private int playerId;
    private String name;
    private PlayerPosition position;
    private String teamName;

    private int ovlAttack;
    private int ovlReceive;
    private int ovlDig;
    private int ovlBlock;

    private int totalPoints;
    private int totalErrors;

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
