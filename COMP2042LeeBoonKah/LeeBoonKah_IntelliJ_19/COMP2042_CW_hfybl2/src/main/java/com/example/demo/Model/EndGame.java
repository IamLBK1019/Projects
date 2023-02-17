package com.example.demo.Model;

import com.example.demo.Controller.MenuController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * This class contains the function to display the end game scene
 * @author Boon Kah Lee
 */
public class EndGame {
    private Parent control;
    private Stage stage;
    private static EndGame singleInstance = null;
    private EndGame(){
    }

    /**
     * Getter function to get the instance of the game
     * @return instance of the game
     */
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    /**
     *This function is used to display the end game scene based on the performance of the user
     * @param endGameScene the properties of the end game scene
     * @param root the group of the gameScene
     * @param primaryStage is an objects as well as modification of scene graph operations
     * @param score is the score after the game
     * @param check is the parameter to check the win of the gam
     */

    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage,long score,boolean check) {
        Text text;
        if (!check) {
            text = new Text("GAME OVER");
        } else  {
            text = new Text("Game Win");
        }
        text.relocate(150, 250);
        text.setFont(Font.font(100));
        root.getChildren().add(text);
        Text scoreText = new Text("Score: "+ score );
            scoreText.setFill(Color.BLACK);
            scoreText.relocate(250, 400);
            scoreText.setFont(Font.font(70));
            root.getChildren().add(scoreText);
            Button quitButton = new Button("QUIT");
            quitButton.setPrefSize(90, 30);
            quitButton.setTextFill(Color.BLACK);
            root.getChildren().add(quitButton);
            quitButton.relocate(490, 500);
            Button MainMenuButton = new Button("MAIN MENU");
            MainMenuButton.setPrefSize(90, 30);
            MainMenuButton.setTextFill(Color.BLACK);
            root.getChildren().add(MainMenuButton);
            MainMenuButton.relocate(270, 500);
            quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Quit Dialog");
                    alert.setHeaderText("Quit from this page");
                    alert.setContentText("Are you sure?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        root.getChildren().clear();
                        System.exit(0);
                    }
                }
            });

        MainMenuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    control = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/Resources/menu.fxml")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                GameScene.setN(4);
                MenuController.ChallengeMode = false;
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setTitle("Game 2048");
                stage.setScene(new Scene(control));
                stage.setResizable(false);
                stage.show();
                }

        });

    }
}
