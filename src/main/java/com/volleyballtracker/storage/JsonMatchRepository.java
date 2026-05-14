package com.volleyballtracker.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.volleyballtracker.model.Match;
import com.volleyballtracker.model.MatchFileInfo;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.net.URISyntaxException;


/**
 * JSON implementation of MatchRepository.
 *
 * Purpose:
 * - Save matches into resources/data/matches.
 * - Load matches from JSON files.
 */



public class JsonMatchRepository {
    private final ObjectMapper objectMapper;

    public JsonMatchRepository() {
        this.objectMapper = new ObjectMapper();
    }

    private Path getMatchesFolder() {
        try {
            var resource = getClass().getResource("/data/matches");
            if (resource != null) {
                return Path.of(resource.toURI());
            }
        } catch (URISyntaxException e) {
        }
        return Path.of("src", "main", "resources", "data", "matches");
    }

    public void saveToJson(Match match, String filename) {
        try {
            Path folderPath = getMatchesFolder();

            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
            }

            Path filepath = folderPath.resolve(filename);
            objectMapper.writeValue(filepath.toFile(), match);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Match loadMatch(String fileName) {
        try {
            Path filePath = getMatchesFolder().resolve(fileName);
            return objectMapper.readValue(filePath.toFile(), Match.class);

        } catch (IOException e) {
            throw new RuntimeException("Could not load match from JSON file", e);
        }
    }

    public List<MatchFileInfo> loadAllJsonMatches() {
        try {
            Path folderPath = getMatchesFolder();

            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
                return List.of();
            }

            List<MatchFileInfo> matches = new ArrayList<>();


            try (DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath, "*.json")) {
                for (Path filePath : stream) {
                    Match match = objectMapper.readValue(filePath.toFile(), Match.class);

                    String fileName = filePath.getFileName().toString();
                    String matchName = match.getMatchName();
                    System.out.println(fileName);
                    matches.add(new MatchFileInfo(fileName, matchName));
                }
            }

            return matches;

        } catch (IOException e) {
            throw new RuntimeException("Could not read match files", e);
        }
    }

    public void deleteMatch(String fileName) {
        try {
            System.out.println("Deleting: " + fileName);

            // Удаляем из target/classes (рабочая копия)
            Path targetFile = getMatchesFolder().resolve(fileName);
            Files.deleteIfExists(targetFile);

            // Удаляем из src/main/resources (оригинал)
            Path sourceFile = Path.of("src", "main", "resources", "data", "matches", fileName);
            Files.deleteIfExists(sourceFile);

            System.out.println("Deleted from both locations");

        } catch (IOException e) {
            throw new RuntimeException("Could not delete match file", e);
        }
    }
}