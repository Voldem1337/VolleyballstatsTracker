package com.volleyballtracker.model;

/**
 * Model class for a team.
 *
 * In beach volleyball this team normally has two players.
 */
public class Team {

    private int teamId;
    private String teamName;
    private Player playerOne;
    private Player playerTwo;
    private int score;
    private int setsWon;

    /** Adds one point to team score. */
    public void addPoint() {
        // TODO: Increase score.
    }

    /** Adds one won set to this team. */
    public void addSetWin() {
        // TODO: Increase setsWon.
    }
}
