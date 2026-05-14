package com.volleyballtracker.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Model class for one set.
 *
 * Stores score, set number, rally counter, second ball points,
 * and action statistics for Serve, Receive, Attack, Block, and Dig.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Set {

    private int setNumber;

    private int teamOnePoints;
    private int teamTwoPoints;

    private boolean isFinished;

    // 0 = no winner yet, 1 = Team 1, 2 = Team 2.
    private int whoWon;

    private int rallyCounter;
    private int secondBallPoints;

    public Set() {}


    public Set(int set) {
            this.setNumber = set;
            this.teamOnePoints = 0;
            this.teamTwoPoints = 0;
            this.isFinished = false;
            this.whoWon = 0;
            this.rallyCounter = 0;
            this.secondBallPoints = 0;
        }


    public Set(int setNumber, int teamOnePoints, int teamTwoPoints, boolean isFinished, int whoWon, int rallyCounter, int secondBallPoints) {
        this.setNumber = setNumber;
        this.teamOnePoints = teamOnePoints;
        this.teamTwoPoints = teamTwoPoints;
        this.isFinished = isFinished;
        this.whoWon = whoWon;
        this.rallyCounter = rallyCounter;
        this.secondBallPoints = secondBallPoints;
    }

    public void setTeamOnePoints(int teamOnePoints) {
        this.teamOnePoints = teamOnePoints;
    }

    public void setTeamTwoPoints(int teamTwoPoints) {
        this.teamTwoPoints = teamTwoPoints;
    }


    public void setWhoWon(int whoWon) {
        this.whoWon = whoWon;
    }

    public void setRallyCounter(int rallyCounter) {
        this.rallyCounter = rallyCounter;
    }

    public void setSecondBallPoints(int secondBallPoints) {
        this.secondBallPoints = secondBallPoints;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public int getTeamOnePoints() {
        return teamOnePoints;
    }

    public int getTeamTwoPoints() {
        return teamTwoPoints;
    }

    public void addPointToTeamOne() {
        this.teamOnePoints +=1;
    }


    public void addPointToTeamTwo() {
        this.teamTwoPoints +=1;
    }
    public void removePointFromTeamOne() {
        this.teamOnePoints -= 1;
    }

    public void removePointFromTeamTwo() {
        this.teamTwoPoints -= 1;
    }


    public boolean checkSetFinished() {
        if(this.setNumber == 1 || this.setNumber == 2 ){
            if(getTeamOnePoints() >= 21 && getTeamTwoPoints() <= 19){return true;}
            if(getTeamTwoPoints() >= 21 && getTeamOnePoints() <= 19){return true;}
            if(getTeamOnePoints() >= 21 && getTeamTwoPoints() >= 21 && ((getTeamOnePoints() - getTeamTwoPoints()) == 2 || (getTeamTwoPoints() - getTeamOnePoints() == 2))){return true;}
        }
        if (this.setNumber == 3){if(getTeamOnePoints() >= 15 && getTeamTwoPoints() <= 13){return true;}
            if(getTeamTwoPoints() >= 15 && getTeamOnePoints() <= 13){return true;}
            if(getTeamOnePoints() >= 15 && getTeamTwoPoints() >= 15 && ((getTeamOnePoints() - getTeamTwoPoints()) == 2 || (getTeamTwoPoints() - getTeamOnePoints() == 2))){return true;}
        }
        return false;
    }

    public void increaseRallyCounter() {
        this.rallyCounter +=1;
    }

    public void increaseSecondBallPoints() {
        this.secondBallPoints +=1;
    }



    public int getWhoWon() {
        return whoWon;
    }

    public int getRallyCounter() {
        return rallyCounter;
    }

    public int getSecondBallPoints() {
        return secondBallPoints;
    }
    @JsonProperty("isFinished")
    public boolean isFinished() {
        return isFinished;
    }

    @JsonProperty("isFinished")
    public void setFinished(boolean finished) {
        isFinished = finished;
    }

}
