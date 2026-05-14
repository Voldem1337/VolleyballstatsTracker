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

    public Match(String matchName, String date,String teamOneName, String teamTwoName,String fileName,String player1name,String player2name,String player3name,String player4name, String player1Position,String player2Position, String player3Position,String player4Position){
        this.matchName = matchName;
        this.date = date;
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;

         this.player1 = new Player(player1name,player1Position, teamOneName);
         this.player2 = new Player(player2name,player2Position, teamOneName);
         this.player3 = new Player(player3name, player3Position, teamTwoName);
         this.player4 = new Player(player4name, player4Position, teamTwoName);


        this.teamOneSetsWon = 0;
        this.teamTwoSetsWon = 0;
        this.CurrentSetNumber = 1;
        Set set1 = new Set(1);
        Set set2 = new Set(2);

        this.sets = new ArrayList<Set>();
        sets.add(set1);
        sets.add(set2);

        this.isFinished = false;
        this.whoWon = "Match not finished";

        this.fileName = fileName;

    }


    public Match(String matchName, String date, String teamOneName, String teamTwoName, int currentSetNumber, Player player1, Player player2, Player player3, Player player4, int teamOneSetsWon, int teamTwoSetsWon, List<Set> sets, boolean isFinished, String whoWon, String fileName) {
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
    }





    public void addSet() {
        Set set3 = new Set(3);
        this.sets.add(set3);
    }


    public void finishMatch(String team) {
        this.isFinished = true;
        this.whoWon = team;
    }
    public Set neededSet(int i){
        if (i < 1 || i > sets.size()) {
            throw new IllegalArgumentException("Set number does not exist: " + i);
        }
        return sets.get(i-1);
    }
    public void whowonaSet (int setnum, int winner ){
        Set set = neededSet(setnum);
        set.setWhoWon(winner);
    }

    public String getFileName() {
        return fileName;
    }

    public String getWhoWon() {
        return whoWon;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public List<Set> getSets() {
        return sets;
    }

    public int getTeamTwoSetsWon() {
        return teamTwoSetsWon;
    }

    public int getTeamOneSetsWon() {
        return teamOneSetsWon;
    }

    public Player getPlayer4() {
        return player4;
    }

    public Player getPlayer3() {
        return player3;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public String getTeamTwoName() {
        return teamTwoName;
    }

    public String getTeamOneName() {
        return teamOneName;
    }

    public String getDate() {
        return date;
    }

    public int getCurrentSetNumber() {
        return CurrentSetNumber;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public void setCurrentSetNumber(int currentSetNumber) {
        CurrentSetNumber = currentSetNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTeamOneName(String teamOneName) {
        this.teamOneName = teamOneName;
    }

    public void setTeamTwoName(String teamTwoName) {
        this.teamTwoName = teamTwoName;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public void setPlayer4(Player player4) {
        this.player4 = player4;
    }

    public void setTeamOneSetsWon(int teamOneSetsWon) {
        this.teamOneSetsWon = teamOneSetsWon;
    }

    public void setTeamTwoSetsWon(int teamTwoSetsWon) {
        this.teamTwoSetsWon = teamTwoSetsWon;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void setWhoWon(String whoWon) {
        this.whoWon = whoWon;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
