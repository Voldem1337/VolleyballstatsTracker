package com.volleyballtracker.service;

/**
 * Main game logic service.
 *
 * Purpose:
 * - Process player action.
 * - Decide whether score should change.
 * - Save action record.
 */
public class GameLogicService {

    /** Processes selected player action and result. */
    public void processAction() {
        // TODO: Update statistics and score based on action result.
    }

    /** Checks if selected result gives point to player's team. */
    public boolean shouldAddPointToPlayerTeam() {
        // TODO: True for Ace, Spike kill, Cut shot kill, Monster Block, etc.
        return false;
    }

    /** Checks if selected result gives point to opponent team. */
    public boolean shouldAddPointToOpponentTeam() {
        // TODO: True for Serve error, Spike error, Cut shot error, Block out, Dig error, etc.
        return false;
    }

    /** Saves action into action history. */
    public void saveActionRecord() {
        // TODO: Add ActionRecord to current match history.
    }
}
