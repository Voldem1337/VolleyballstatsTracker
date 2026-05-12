package com.volleyballtracker.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Model class for one recorded action.
 *
 * Needed for Edit Stats:
 * - show history of actions;
 * - edit wrong action;
 * - delete wrong action;
 * - recalculate score/statistics later.
 */
public class ActionRecord {

    private int actionId;
    private int setNumber;
    private String playerName;
    private String teamName;
    private ActionType actionType;
    private ActionResult actionResult;
    private boolean pointsChanged;

    // 0 = no point, 1 = Team 1, 2 = Team 2.
    private int pointAddedToTeam;

    private LocalDateTime time;

    public ActionRecord(int actionId, int setNumber, String playerName,
                        String teamName, ActionType actionType,
                        ActionResult actionResult, boolean pointsChanged,
                        int pointAddedToTeam, LocalDateTime time) {

        this.actionId = actionId;
        this.setNumber = setNumber;
        this.playerName = playerName;
        this.teamName = teamName;
        this.actionType = actionType;
        this.actionResult = actionResult;
        this.pointsChanged = pointsChanged;
        this.pointAddedToTeam = pointAddedToTeam;
        this.time = time;
    }

    /** Changes this recorded action. */
    public void editAction() {
        // TODO: Change player/action/result and recalculate match if needed.
    }

    /** Marks or removes this action from history. */
    public void deleteAction() {
        // TODO: Delete action from match history.
    }

    @Override
    public String toString() {
        String pointText;

        if (pointsChanged) {
            pointText = " | point to Team " + pointAddedToTeam;
        } else {
            pointText = " | no point";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String timeText = time.format(formatter);

        return "Set " + setNumber +
                " | " + playerName +
                " (" + teamName + ")" +
                " | " + actionType +
                " --> " + actionResult +
                pointText +
                " | " + timeText;
    }
}
