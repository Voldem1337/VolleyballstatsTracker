package com.volleyballtracker.model;

import java.time.LocalDateTime;

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

    /** Changes this recorded action. */
    public void editAction() {
        // TODO: Change player/action/result and recalculate match if needed.
    }

    /** Marks or removes this action from history. */
    public void deleteAction() {
        // TODO: Delete action from match history.
    }
}
