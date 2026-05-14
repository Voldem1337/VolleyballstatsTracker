package com.volleyballtracker.model;

public class MatchFileInfo {

    private String fileName;
    private String matchName;

    public MatchFileInfo(String fileName, String matchName) {
        this.fileName = fileName;
        this.matchName = matchName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMatchName() {
        return matchName;
    }
}