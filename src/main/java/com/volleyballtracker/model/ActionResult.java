package com.volleyballtracker.model;

/**
 * Possible action results for all action types.
 */
public enum ActionResult {
    // Serve
    FLOAT_SERVE,
    JUMP_SERVE,
    ACE,
    ATTEMPT,
    ERROR,

    // Receive
    FOR_THE_OPTION,
    GOOD_RECEIVE,
    HARD_TO_SET,
    RECEIVE_ERROR,

    // Attack
    SPIKE_KILL,
    SPIKE_ERROR,
    CUT_SHOT_KILL,
    CUT_SHOT_ERROR,
    SPIKE_ATTEMPT,
    CUT_SHOT_ATTEMPT,

    // Block
    MONSTER_BLOCK,
    VERY_GOOD_BLOCK_TOUCH,
    BLOCK_TOUCH,
    BLOCK_OUT,

    // Dig
    DIG,
    DIG_ERROR
}
