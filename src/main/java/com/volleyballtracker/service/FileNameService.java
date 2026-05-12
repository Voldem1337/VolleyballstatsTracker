package com.volleyballtracker.service;

/**
 * Service for safe file names.
 *
 * Example:
 * Match name: Volõnski/Voltšihhin vs Korotkov/Tiisar
 * File name: 1_Volõnski-Voltšihhin_vs_Korotkov-Tiisar.json
 */
public class FileNameService {

    /** Generates match name from player names. */
    public String generateMatchName() {
        // TODO: Combine player names into match title.
        return null;
    }

    /** Creates file-safe name without forbidden characters like '/'. */
    public String generateSafeFileName() {
        // TODO: Replace / with -, spaces with _, add extension.
        return null;
    }

    /** Adds match ID to file name for uniqueness. */
    public String addMatchIdToFileName() {
        // TODO: Prefix file name with match ID.
        return null;
    }

    /** Validates file name. */
    public boolean validateFileName() {
        // TODO: Check empty name and forbidden symbols.
        return false;
    }
}
