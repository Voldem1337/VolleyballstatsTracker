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
    private int CurrentSetNumber;

    private String date;

    private String teamOneName;
    private String teamTwoName;

    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    private int teamOneSetsWon;
    private int teamTwoSetsWon;

    private List<Set> sets;

    private boolean isFinished;

    // 0 = no winner yet, 1 = Team 1, 2 = Team 2.
    private String whoWon;

    private String fileName;
    private String filePath;

    public Match(String matchName, String date,String teamOneName, String teamTwoName,String fileName, String filePath,String player1name,String player2name,String player3name,String player4name, String player1Position,String player2Position, String player3Position,String player4Position){
        this.matchName = matchName;
        this.date = date;
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;
        List<String> teams_name = List.of(matchName.split("vs"));

         this.player1 = new Player(player1name,player1Position, teams_name.get(0));
         this.player2 = new Player(player2name,player2Position, teams_name.get(0));
         this.player3 = new Player(player3name, player3Position, teams_name.get(1));
         this.player4 = new Player(player4name, player4Position, teams_name.get(1));


        this.teamOneSetsWon = 0;
        this.teamTwoSetsWon = 0;
        this.CurrentSetNumber = 0;
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


    public Match(String matchName, String date, String teamOneName, String teamTwoName, int currentSetNumber, Player player1, Player player2, Player player3, Player player4, int teamOneSetsWon, int teamTwoSetsWon, List<Set> sets, boolean isFinished, String whoWon, String fileName, String filePath) {
        this.matchName = matchName;
        this.date = date;
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.teamOneSetsWon = teamOneSetsWon;
        this.teamTwoSetsWon = teamTwoSetsWon;
        this.CurrentSetNumber = currentSetNumber;
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
