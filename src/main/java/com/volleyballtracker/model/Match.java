package com.volleyballtracker.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Model class for one full match.
 *
 * Stores match information, players, teams, sets, score by sets,
 * file name and path for saving/exporting.
 */
public class Match {

    // Unique match ID, useful for file names and storage.
    private int matchId;

    // Example: Volõnski/Voltšihhin vs Korotkov/Tiisar
    private String matchName;

    private LocalDate date;

    private String teamOneName;
    private String teamTwoName;

    private String playerOneName;
    private String playerTwoName;
    private String playerThreeName;
    private String playerFourName;

    private int teamOneSetsWon;
    private int teamTwoSetsWon;

    private List<Set> sets;

    private boolean isFinished;

    // 0 = no winner yet, 1 = Team 1, 2 = Team 2.
    private int whoWon;

    private String fileName;
    private String filePath;

    /** Adds a new Set to this Match. */
    public void addSet() {
        // TODO: Add new Set object to sets list.
    }

    /** Returns current active Set. */
    public Set getCurrentSet() {
        // TODO: Return last unfinished set.
        return null;
    }

    /** Marks match as finished. */
    public void finishMatch() {
        // TODO: Set isFinished and whoWon.
    }

    /** Updates number of sets won by each team. */
    public void updateSetsScore() {
        // TODO: Count won sets.
    }
}
