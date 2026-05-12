package com.volleyballtracker.storage;

/**
 * Repository interface for saving, loading, updating, and deleting matches.
 *
 * Later implementations can be:
 * - JsonMatchRepository
 * - DatabaseMatchRepository
 */
public interface MatchRepository {

    /** Saves match. */
    void save();

    /** Finds match by ID. */
    void findById();

    /** Returns all matches. */
    void findAll();

    /** Deletes match. */
    void delete();

    /** Updates match. */
    void update();
}
