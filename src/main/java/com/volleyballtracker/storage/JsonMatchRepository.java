package com.volleyballtracker.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.volleyballtracker.model.Match;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * JSON implementation of MatchRepository.
 *
 * Purpose:
 * - Save matches into resources/data/matches.
 * - Load matches from JSON files.
 */
public class JsonMatchRepository {
    private ObjectMapper objectMapper;

    /**
     * Saves match into JSON file.
     */
    public void saveToJson(Match match, String filename) {
        objectMapper = new ObjectMapper();
        try {
            Path folderPath = Path.of("data", "matches");
            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
            }
            Path filepath = folderPath.resolve(filename);
            objectMapper.writeValue(filepath.toFile(), match);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads one match from JSON file.
     */
    public Match loadMatch(String fileName) {
        try {
            Path filePath = Path.of("data", "matches", fileName);

            return objectMapper.readValue(filePath.toFile(), Match.class);

        } catch (IOException e) {
            throw new RuntimeException("Could not load match from JSON file", e);
        }
    }

    /**
     * Loads all JSON match files from folder.
     */
    public List<String> loadAllJsonMatches() {
        try {
            Path folderPath = Path.of("data", "matches");

            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
                return List.of();
            }

            List<String> matchNames = new ArrayList<>();

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath, "*.json")) {
                for (Path filePath : stream) {
                    Match match = objectMapper.readValue(filePath.toFile(), Match.class);
                    matchNames.add(match.getMatchName());
                }
            }

            return matchNames;

        } catch (IOException e) {
            throw new RuntimeException("Could not read match files", e);
        }

    }

    public void deleteMatch(String fileName) {
        try {
            Path filePath = Path.of("data", "matches", fileName);

            boolean deleted = Files.deleteIfExists(filePath);

            if (deleted) {
                System.out.println("Deleted match file: " + filePath.toAbsolutePath());
            } else {
                System.out.println("File not found: " + filePath.toAbsolutePath());
            }

        } catch (IOException e) {
            throw new RuntimeException("Could not delete match file", e);
        }
    }
}