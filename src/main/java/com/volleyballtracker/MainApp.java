package com.volleyballtracker;

///**
// * Main JavaFX application class.
// *
// * Purpose:
// * - Starts the application.
// * - Loads the first screen: Main Menu.
// * - Initializes global services if needed later.
// */
//public class MainApp {
//
//    /**
//     * JavaFX start method will be placed here later.
//     * It should load Main Menu screen and show the main window.
//     */
//    public void start() {
//        // TODO: Load Main Menu scene.
//    }
//
//    /**
//     * Application entry point.
//     */
//    public static void main(String[] args) {
//        // TODO: Launch JavaFX application.
//    }
//}



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        Button newGameButton = new Button("New Game");
        Button openGameButton = new Button("Open Game");
        Button exitButton = new Button("Exit");

        exitButton.setOnAction(event -> stage.close());

        VBox root = new VBox(15);
        root.getChildren().addAll(newGameButton, openGameButton, exitButton);

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Volleyball Stats Tracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}