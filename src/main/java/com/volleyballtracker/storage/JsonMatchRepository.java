package com.volleyballtracker.storage;

/**
 * JSON implementation of MatchRepository.
 *
 * Purpose:
 * - Save matches into resources/data/matches.
 * - Load matches from JSON files.
 */
public class JsonMatchRepository implements MatchRepository {

    /** Saves match into JSON file. */
    public void saveToJson() {
        // TODO: Serialize match to JSON.
    }

    /** Loads one match from JSON file. */
    public void loadFromJson() {
        // TODO: Deserialize match from JSON.
    }

    /** Loads all JSON match files from folder. */
    public void loadAllJsonMatches() {
        // TODO: Scan matches folder and load files.
    }

    @Override
    public void save() {
        // TODO: Implement repository save.
    }

    @Override
    public void findById() {
        // TODO: Implement repository findById.
    }

    @Override
    public void findAll() {
        // TODO: Implement repository findAll.
    }

    @Override
    public void delete() {
        // TODO: Implement repository delete.
    }

    @Override
    public void update() {
        // TODO: Implement repository update.
    }
}
