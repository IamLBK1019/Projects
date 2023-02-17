package com.example.demo.View;

import com.example.demo.Model.Account;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Main class contains the methods that create the file and begin the game application
 *@author Boon Kah Lee
 */
public class Main extends Application {

    /**
     * This start() method is the main entry point to begin the application with menu page
     * Stage primaryStage is an objects as well as modification of scene graph operations.
     * throws Exception
     */
        @Override
    public void start(Stage primaryStage) throws Exception {
        CreateFile();
        Account.ReadFile();
        Parent control= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/Resources/menu.fxml")));
        primaryStage.setScene(new Scene(control));
        primaryStage.setTitle("Game 2048");
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    /**
     * This function is used to create the score.txt when the score.txt is not exists
     * It is also use to prevent the problem of unable to find the score.txt in the file which lead the crash of the application
     * @throws Exception when the file already exits
     */
    void CreateFile() throws Exception{
        try {
            File file = new File("src/main/java/com/example/demo/Database/Score.txt");
            if (file.createNewFile()) {
                PrintWriter Output = new PrintWriter("src/main/java/com/example/demo/Database/Score.txt", StandardCharsets.UTF_8);
                Output.println("Username,"+"Score");
                Output.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * The function launch the application
     * @param args takes in the argument,and it is an array of command line argument
     */
        public static void main(String[] args) {
        launch(args);
    }
}
