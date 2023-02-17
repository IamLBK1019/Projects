package com.example.demo.Controller;

import com.example.demo.Model.GameScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * The MenuController Class control all the function of the button which in the menu page.
 * @author Boon Kah Lee
 */
public class MenuController implements Initializable{
    /**
     * WIDTH variable is the Width of the game scene
     */
        static final int WIDTH = 850;
    /**
     * HEIGHT variable is the height of the game scene
     */
    static final int HEIGHT = 800;
        private Group gameRoot = new Group();
        private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
        //private static Scanner input= new Scanner(System.in);

    /**
     * Setter function to set and assign the game scene
     * @param gameScene is the current scene in the game
     */
        public void setGameScene(Scene gameScene) {
            this.gameScene = gameScene;
        }

    /**
     * Setter function to set and assign the game root
     * @param gameRoot is the group of the cell
     */
        public void setGameRoot(Group gameRoot) {
            this.gameRoot = gameRoot;
        }

    /**
     * Declare the stage
     */
    public static javafx.stage.Stage Stage;

    /**
     * Setter function to assign the stage to primary Stage
     * @param primaryStage is the stage
     */
        public void setStage(javafx.stage.Stage primaryStage){Stage=primaryStage;}
        @FXML
        private Button HelpButton;
        @FXML
        private Button QuitButton;
        @FXML
        private Button StartButton;
        @FXML
        private javafx.scene.control.TextField TextField;
    /**
     * The label with the word board size
     */
    @FXML
        private Label Board_Label;
        @FXML
        private Rectangle Box;
        @FXML
        private javafx.scene.control.ColorPicker ColorPicker;
        @FXML
        private Pane FrontPane;
        @FXML
        private Button PlayButton;
        @FXML
        private Label Label_In_Game;
        @FXML
        private ComboBox<String> BoardSize;
        private final String[] size ={"3x3","4x4","5x5","Challenge Mode"};
    /**
     * Variable ChallengeMode check the mode of the user
     */
    public static boolean ChallengeMode;
        @FXML
        private Label Title_Label;
        @FXML
        private Button BackButton;
    /**
     * Variable username is used to store the username that insert by the user.
     */
    public static String username;
        private Parent root;
        private Stage stage;
        @FXML
        private Button LeaderboardButton;
        /**
         * This function will switch the page from the Leaderboard page to the menu page
         * @param event is the action that act by the user on the score button
         * @throws IOException when there is the error occurs during the load of fxml file
         */
        @FXML
        void Leaderboard(ActionEvent event) throws IOException {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/Resources/Leaderboard.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Game 2048");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        }

    /**
     * The main purpose of the function is used to quit the game
     * @param event is action that act on the quit button on the menu page
     */
    @FXML
        void QuitGame(ActionEvent event) {
            Stage Close_Stage = (Stage)QuitButton.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Quit Dialog");
            alert.setHeaderText("Quit from this page");
            alert.setContentText("Are you sure?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Close_Stage.close();
            }
        }

    /**
     * This function is used to set the In game scene
     */
    void setScreen(){
            Group menuRoot = new Group();
            Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
            Group accountRoot = new Group();
            Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
            Group getAccountRoot = new Group();
            Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
            Group endgameRoot = new Group();
            Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, ColorPicker.getValue());
            Group rankRoot = new Group();
            Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
            BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
            Background background = new Background(background_fill);
            Stage stage = new Stage();
            setStage(stage);

            Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
            backgroundOfMenu.setX(WIDTH / 2 - 120);
            backgroundOfMenu.setY(180);
            menuRoot.getChildren().add(backgroundOfMenu);

            Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
            backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
            backgroundOfMenuForPlay.setY(180);
            accountRoot.getChildren().add(backgroundOfMenuForPlay);
            Group gameRoot = new Group();
            setGameRoot(gameRoot);
            Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, ColorPicker.getValue());
            setGameScene(gameScene);
            stage.setScene(gameScene);
            GameScene game = new GameScene();
            game.game(gameScene, gameRoot, stage, endGameScene, endgameRoot);
            stage.show();
            stage.setTitle("Game 2048");
            stage.setResizable(false);
            Stage Close_Stage = (Stage)StartButton.getScene().getWindow();
            Close_Stage.close();
        }

    /**
     * This function is sued to start game after the user set up all the in game setting
     * @param event is the action that the user act on the Start Button
     */
    @FXML
        void StartGame(ActionEvent event) {
            username = TextField.getText();
            if(username.isEmpty()){
                Alert MsgAlert = new Alert(Alert.AlertType.WARNING);
                MsgAlert.setTitle("Username Confirmation");
                MsgAlert.setHeaderText("Username field is empty !");
                MsgAlert.setContentText("Click ok to insert username");
                Optional<ButtonType> result = MsgAlert.showAndWait();
                if(result.get() == ButtonType.OK){
                    MsgAlert.close();
                }
            }

            if(username.length()>15){
                Alert MsgAlert = new Alert(Alert.AlertType.INFORMATION);
                MsgAlert.setTitle("Username Confirmation");
                MsgAlert.setHeaderText("Username should not more than 15 words!");
                MsgAlert.setContentText("Click ok to insert username again!");
                Optional<ButtonType> result = MsgAlert.showAndWait();
                if(result.get() == ButtonType.OK){
                    MsgAlert.close();
                }
            }
            if (!(username.isEmpty() )&&!(username.matches("^[a-zA-Z0-9]+$"))){
                Alert MsgAlert = new Alert(Alert.AlertType.INFORMATION);
                MsgAlert.setTitle("Username Confirmation");
                MsgAlert.setHeaderText("Insert number and letter only");
                MsgAlert.setContentText("Click ok to insert username again!");
                Optional<ButtonType> result = MsgAlert.showAndWait();
                if(result.get() == ButtonType.OK){
                    MsgAlert.close();
                }
            }

            if(username.length()<=15 && !username.isEmpty()&& (username.matches("^[a-zA-Z0-9]+$"))){
                setScreen();
            }


        }
    /**
     * This function will switch the page from the menu page to the Help page
     * @param event is the action that act by the user on the Help button
     * @throws IOException when there is the error occurs during the load of fxml file
     */
        @FXML
        void HelpPage(ActionEvent event) throws IOException {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/Resources/Help.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Game 2048");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        }

    /**
     * This function is used to change the background color of the menu page and the game scene background color by using the color picker
     * @param event is the action of the user that act on the color picker
     */
        public void ChangeBg(ActionEvent event) {

            Color MyColor = ColorPicker.getValue();
            Box.setFill(MyColor);
            FrontPane.setBackground(new Background(new BackgroundFill(MyColor,null,null)));
            gameScene.setFill(MyColor);
        }

    /**
     * This function is used to hide the button of the menu page and display all the in game setting label as well as button
     * @param actionEvent is the action that act on the PlayButton
     */
    public void PickMode(ActionEvent actionEvent) {
            PlayButton.setVisible(false);
            HelpButton.setVisible(false);
            QuitButton.setVisible(false);
            LeaderboardButton.setVisible(false);
            Label_In_Game.setVisible(true);
            Board_Label.setVisible(true);
            Box.setVisible(true);
            BoardSize.setVisible(true);
            ColorPicker.setVisible(true);
            Title_Label.setVisible(true);
            TextField.setVisible(true);
            StartButton.setVisible(true);
            BackButton.setVisible(true);
        }

    /**
     * This function is used to display the button of the menu page and hide all in game setting page
     * @param event is the action that act on the back button
     */
    public void Back_To_Main(ActionEvent event) {
            PlayButton.setVisible(true);
            HelpButton.setVisible(true);
            QuitButton.setVisible(true);
            LeaderboardButton.setVisible(true);
            Label_In_Game.setVisible(false);
            Board_Label.setVisible(false);
            Box.setVisible(false);
            BoardSize.setVisible(false);
            ColorPicker.setVisible(false);
            Title_Label.setVisible(false);
            TextField.setVisible(false);
            StartButton.setVisible(false);
            BackButton.setVisible(false);
        }

        /**
         * This function initialize are used when interact with thing injected with @FXML and call initialize interface after everything is set up.
         * The display of the leaderboard used this function to display at the leaderboard page
         * @param url is used to resolve relative paths for the root object, or null if the precise location is unknown
         * @param resourceBundle is used to localize the root object, or null if the precise location is unknown
         */
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            if(ColorPicker!=null) {
                ColorPicker.setValue(Color.rgb(189, 177, 92));
                gameScene.setFill(ColorPicker.getValue());
            }
            ObservableList<String> list = FXCollections.observableArrayList(size);
            if (BoardSize != null){
                BoardSize.setValue("4x4");
                BoardSize.setItems(list);
            }
        }

        /**
         * This function is used change the board size of the game by using the combo box
         * @param event is the action that done by the user
         */
        @FXML
        void ChangeBoard(ActionEvent event) {
            String getSize = BoardSize.getSelectionModel().getSelectedItem();
            switch (getSize){
                case "3x3":
                    GameScene.setN(3);

                    break;
                case "5x5":
                    GameScene.setN(5);

                    break;
                case "Challenge Mode":
                    GameScene.setN(4);
                    ChallengeMode = true;
                default:
                    GameScene.setN(4);

            }
        }


}
