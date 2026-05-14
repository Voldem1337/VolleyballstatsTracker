package com.volleyballtracker.storage;

import com.volleyballtracker.model.Match;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * JSON implementation of MatchRepository.
 *
 * Purpose:
 * - Save matches into resources/data/matches.
 * - Load matches from JSON files.
 */
public class JsonMatchRepository {



    /** Saves match into JSON file. */
    public void saveToJson(Match match, String filename) {
        try{
            Path folderPath = Path.of("data", "matches");
            if (!Files.exists(folderPath)){
                Files.createDirectories(folderPath);
            }
            Path filepath = folderPath.resolve(filename);




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Loads one match from JSON file. */
    public void loadFromJson() {
        // TODO: Deserialize match from JSON.
    }

    /** Loads all JSON match files from folder. */
    public void loadAllJsonMatches() {
        // TODO: Scan matches folder and load files.
    }

    public void save() {
        // TODO: Implement repository save.
    }

    public void findById() {
        // TODO: Implement repository findById.
    }

    public void findAll() {
        // TODO: Implement repository findAll.
    }

    public void delete() {
        // TODO: Implement repository delete.
    }

    public void update() {
        // TODO: Implement repository update.
    }
}
