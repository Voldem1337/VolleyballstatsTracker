package com.volleyballtracker;


import com.volleyballtracker.util.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        SceneManager sceneManager = new SceneManager(stage);

        stage.setTitle("Volleyball Stats Tracker");
        stage.setResizable(false);

        sceneManager.switchToMainMenu();
        sceneManager.switchToEditStats();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}