package com.volleyballtracker.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class for one full match.
 *
 * Stores match information, players, teams, sets, score by sets,
 * file name and path for saving/exporting.
 */
public class Match {


    // Example: Volõnski/Voltšihhin vs Korotkov/Tiisar
    private String matchName;

    private String date;

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
    private String whoWon;

    private String fileName;
    private String filePath;

    public Match(String matchName, String date,String teamOneName, String teamTwoName,String playerOneName, String playerTwoName, String playerThreeName, String playerFourName,String fileName, String filePath){
        this.matchName = matchName;
        this.date = date;
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;

        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.playerThreeName = playerThreeName;
        this.playerFourName = playerFourName;

        this.teamOneSetsWon = 0;
        this.teamTwoSetsWon = 0;
        Set set1 = new Set(1);
        Set set2 = new Set(2);

        this.sets = new ArrayList<Set>();
        sets.add(set1);
        sets.add(set2);

        this.isFinished = false;
        this.whoWon = "Match not finished";

        this.fileName = fileName;
        this.filePath = filePath;

    }


    public Match(String matchName, String date, String teamOneName, String teamTwoName, String playerOneName, String playerTwoName, String playerThreeName, String playerFourName, int teamOneSetsWon, int teamTwoSetsWon, List<Set> sets, boolean isFinished, String whoWon, String fileName, String filePath) {
        this.matchName = matchName;
        this.date = date;
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.playerThreeName = playerThreeName;
        this.playerFourName = playerFourName;
        this.teamOneSetsWon = teamOneSetsWon;
        this.teamTwoSetsWon = teamTwoSetsWon;
        this.sets = sets;
        this.isFinished = isFinished;
        this.whoWon = whoWon;
        this.fileName = fileName;
        this.filePath = filePath;
    }





    /** Adds a new Set to this Match. */
    public void addSet() {
        Set set3 = new Set(3);
        this.sets.add(set3);
    }


    public void finishMatch(String team) {
        this.isFinished = true;
        this.whoWon = team;
    }


}
