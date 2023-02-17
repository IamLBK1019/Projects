package com.example.demo.Model;

import com.example.demo.Controller.MenuController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

/**
 * This class controls the fixtures of the game scene and the backend mechanism of the game
 * @author Boon Kah Lee
 */
public class GameScene {
    /**
     * The HEIGHT variable is the height of the In game scene
     */
    private static final int HEIGHT = 700;
    /**
     *n is the board size value
     */
    public static int n =4;
    /**
     *This is the variable of the distance between the cell
     */
    private final static int distanceBetweenCells = 10;
    private static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    private TextMaker textMaker = TextMaker.getSingleInstance();
    private Cell[][] cells = new Cell[n][n];
    private int [][] CheckCells = new int[n][n];
    private int ValidMove =0;
    private Group root;
    private long score = 0;
    /**
     * check variable check the game win or lose and display the respective
     */
    boolean check =true;
    private Parent load;
    private Stage stage;

    private int NumberOf32Cell =0;

    private int CountMove=35;

    /**
     * This function is used to set the board size of the game and set the length of the cell in the game
     * @param number is the board size of the game
     * LENGTH variable is variable to change the length of the cell
     */
    public static void setN(int number) {
        n = number;
        if (n==3){
            LENGTH = ((HEIGHT - ((n + 10) * distanceBetweenCells)) / (double) 3)-20;
        }
        else if(n==4) {
            LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n + 2.5;
        } else if (n==5) {
            LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n + 2.5;
        }
    }

    /**
     * This function is a getter function to get the length which return the value of the LENGTH
     * @return value of the length
     */
    static double getLENGTH() {
        return LENGTH;
    }
    /**
     * This function is used to randomly fill number with 2 or 4 on array which is unfilled or filled with 0.
     * @param turn this parameter has never used, it is just an indicator for player
     */
    private void randomFillNumber(int turn) {

        Cell[][] emptyCells = new Cell[n][n];
        int a = 0;
        int b = 0;
        int aForBound=0,bForBound=0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0) {
                    emptyCells[a][b] = cells[i][j];
                    if (b < n-1) {
                        bForBound=b;
                        b++;

                    } else {
                        aForBound=a;
                        a++;
                        b = 0;
                        if(a==n)
                            break outer;
                    }
                }
            }
        }

        Text text;
        Random random = new Random();
        boolean putTwo = true;
        if (random.nextInt() % 2 == 0)
            putTwo = false;
        int xCell, yCell;
            xCell = random.nextInt(aForBound+1);
            yCell = random.nextInt(bForBound+1);
        if (putTwo) {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
        }
    }
    /**
     * This function is used to check the cell whether it has the empty cell,2048 cell in the 2d array and other that the empty and 2048 cell
     * @return 1 when there is the cell of 0 in the 2d array,
     * return 0 when there is 2048 in the 2d array
     * return -1 when the 2d array did not contain the empty cell and 2048 cell
     */
    private int  haveEmptyCell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0)
                    return 1;
                if(cells[i][j].getNumber() == 2048)
                    return 0;
            }
        }
        return -1;
    }

    /**
     * This function main purpose is to move the filled cells,not number 0 in the board, by 1 depending on the direction
     * @param i is the parameter that used to move the existed cells on the board in the up or down direction
     * @param j is the parameter that used to move the existed cells on the board in the left or right direction
     * @param direct is the parameter that used to determine what direction the user inputted
     * @return the coordinate of the board
     */
    private int passDestination(int i, int j, char direct) {
        int coordinate = j;
        if (direct == 'l') {
            for (int k = j - 1; k >= 0; k--) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        coordinate = j;
        if (direct == 'r') {
            for (int k = j + 1; k <= n - 1; k++) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k - 1;
                    break;
                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'd') {
            for (int k = i + 1; k <= n - 1; k++) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k - 1;
                    break;

                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'u') {
            for (int k = i - 1; k >= 0; k--) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        return -1;
    }

    /**
     * This function able the cells on the board to move in the left direction
     */

    private void moveLeft() {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                moveHorizontally(i, j, passDestination(i, j, 'l'), -1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    /**
     * This function is to let the cells that on the board to move in the right direction
     */

    private void moveRight() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                moveHorizontally(i, j, passDestination(i, j, 'r'), 1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    /**
     * This function is to let the cells that on the board to move in the up direction
     */
    private void moveUp() {
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                moveVertically(i, j, passDestination(i, j, 'u'), -1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }

    }

    /**
     * This function is to let the cells that on the board to move in the down direction
     */
    private void moveDown() {
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                moveVertically(i, j, passDestination(i, j, 'd'), 1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }
    }

    /**
     *This function is used to determine whether the cell's value and the adjacent cell's value can be combined to generate a new value in the horizontal direction
     * @param i is the x coordinate of cell
     * @param j is the y coordinate of cell
     * @param des is the destination coordinate in which the cell called
     * @param sign is to indicate the adjacent location of the cell that is called
     * @return ture when the cell and its adjacent cell can be combined, while false if both cells cannot be combined
     */
    private boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0) {
            if (cells[i][des + sign].getNumber() == cells[i][j].getNumber() && !cells[i][des + sign].getModify()
                    && cells[i][des + sign].getNumber() != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * This function is used to check the horizontal move of the cell and combine when there is the same cells moving in the same horizontal direction.
     * The score addition is implement in this function and there is the combination of the cells, the score will be added
     * @param i is the x coordinate of cell
     * @param j is the y coordinate of cell
     * @param des is the destination coordinate in which the cell called
     * @param sign is to indicate the adjacent location of the cell that is called
     */
    private void moveHorizontally(int i, int j, int des, int sign) {
        if (isValidDesH(i, j, des, sign)) {
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des+sign].setModify(true);
            sumCellNumbersToScore();
        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }

    /**
     *This function is used to determine whether the cell's value and the adjacent cell's value can be combined to generate a new value in the vertical direction
     * @param i is the x coordinate of cell
     * @param j is the y coordinate of cell
     * @param des is the destination coordinate in which the cell called
     * @param sign is to indicate the adjacent location of the cell that is called
     * @return ture when the cell and its adjacent cell can be combined, while false if both cells cannot be combined
     */
    private boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0)
            if (cells[des + sign][j].getNumber() == cells[i][j].getNumber() && !cells[des + sign][j].getModify()
                    && cells[des + sign][j].getNumber() != 0) {
                return true;
            }
        return false;
    }

    /**
     * This function is used to check the horizontal move of the cell and combine when there is the same cells moving in the same horizontal direction.
     * The score addition is implement in this function and there is the combination of the cells, the score will be added
     * @param i is the x coordinate of cell
     * @param j is the y coordinate of cell
     * @param des is the destination coordinate in which the cell called
     * @param sign is to indicate the adjacent location of the cell that is called
     */
    private void moveVertically(int i, int j, int des, int sign) {
        if (isValidDesV(i, j, des, sign)) {
            cells[i][j].adder(cells[des + sign][j]);
            cells[des+sign][j].setModify(true);
            sumCellNumbersToScore();
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }

    /**
     *This function is used to check there is the same number of cell nearly
     * @param i is the x coordinate of the cell
     * @param j is the y coordinate of the cell
     * @return true when there is the same number of cell nearly while return false when there is no same number of cell nearly
     */
    private boolean haveSameNumberNearly(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            if (cells[i][j + 1].getNumber() == cells[i][j].getNumber())
                return true;
        }
        return false;
    }

    /**
     * This function is used to check the cells on the board can still be able to move
     * @return true when the cells on the board unable to move and the hasSameNumberNearly function return false
     * return false when the cells on the board still able to move and hasSameNumberNearly function return true
     */
    private boolean canNotMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *This function is used to calculate the score of the user.The score will increase base on the number after the two cells being combined
     */
    private void sumCellNumbersToScore() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getModify()) {
                    score += cells[i][j].getNumber();
                }
            }
        }
    }

    /**
     * This function is used to get the cells on the board and duplicate them into the 2d array of variable CheckCell
     */
    private void GetCell() {
        for(int i=0; i<n;i++) {
            for (int j = 0; j < n; j++) {
                CheckCells[i][j] = cells[i][j].getNumber();
            }
        }
    }

    /**
     * This function is used to check the value in the 2d array
     * if there is the same cell in the same position, the value of the variable ValidMove will be increases one by one until it finished the double for loop
     */
    private void CheckValue(){
        for(int i=0; i<n;i++) {
            for (int j = 0; j < n; j++) {
                if(CheckCells[i][j] == cells[i][j].getNumber()){
                    ValidMove++;
                }
            }
        }
    }
    /**
     * This function is used to check the number of 32 cell in the 2d array for the Challenge Mode
     * if there is a 32 cell in the 2d array, the variable NumberOf32Cell will increase
     */
    private void CheckNumber32Cell(){
        NumberOf32Cell =0;
        for(int i=0; i<n;i++) {
            for (int j = 0; j < n; j++) {
                if( cells[i][j].getNumber()==32){
                    NumberOf32Cell++;
                    System.out.println(NumberOf32Cell);
                    }
            }
        }
    }

    /**
     * This function is used to adjust the padding of the game scene, control the movement of the cell and the spawning of the cell
     * @param gameScene is the parameter of the current game scene status
     * @param root is the parameter of collective bounds of the cell and is not directly resizable
     * @param primaryStage is a Stage object which is passed to the start method of the scene class
     * @param endGameScene the properties of the end game scene when the user loses the game
     * @param endGameRoot is the parameter which the group of the endGame scene
     */
    public void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(n==3) {
                    cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells + 145,
                            (i) * LENGTH + (i + 1) * distanceBetweenCells + 135, LENGTH, root);
                } else if (n==4) {
                    cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells + 70,
                            (i) * LENGTH + (i + 1) * distanceBetweenCells + 61, LENGTH, root);
                } else if (n==5) {
                    cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells + 70,
                            (i) * LENGTH + (i + 1) * distanceBetweenCells + 55, LENGTH, root);
                }
            }

        }
        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(23));
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.setFont(Font.font(23));
        scoreText.setText("0");
        Text NameText = new Text();
        root.getChildren().add(NameText);
        NameText.setText("Username : "+ MenuController.username);
        NameText.setFont(Font.font(23));
        Text ModeText = new Text();
        root.getChildren().add(ModeText);
        ModeText.setFont(Font.font(21));
        Text HighScore = new Text();
        root.getChildren().add(HighScore);
        Text HighScoreText = new Text();
        root.getChildren().add(HighScoreText);
        HighScoreText.setFont(Font.font(23));
        Text MoveText = new Text();
        MoveText.setFont(Font.font(18));
        root.getChildren().add(MoveText);
        Text NumberOfCell = new Text();
        NumberOfCell.setFont(Font.font(18));
        root.getChildren().add(NumberOfCell);

        if(Account.GetSize()>=1) {
            if(Account.GetLabelScore(0)>score) {
                HighScore.setText("HIGHEST SCORE :   " + Account.GetLabelScore(0));
            }
        }
        else if(Account.GetSize()==0) {
            HighScore.setText("HIGHEST SCORE :");
            HighScoreText.setText("0");
        }
        HighScore.setFont(Font.font(24));
        Button HomeButton = new Button("< Back");
        HomeButton.setStyle("-fx-text-fill: black");
        HomeButton.setFocusTraversable(false);
        root.getChildren().add(HomeButton);
            if(n==3 && !MenuController.ChallengeMode){
                text.relocate(515, 90);
                scoreText.relocate(618, 90);
                HighScore.relocate(410,61);
                HighScoreText.relocate(618,61);
                NameText.relocate(160, 90);
                HomeButton.relocate(10,5);
                HomeButton.setPrefSize(65,30);

            }else if(n==4 && !MenuController.ChallengeMode) {

                text.relocate(590, 38);
                scoreText.relocate(690, 38);
                HighScore.relocate(486,12);
                HighScoreText.relocate(690,12);
                NameText.relocate(100, 38);
                HomeButton.relocate(5,5);
                HomeButton.setPrefSize(65,30);

            }
            else if(n==5 && !MenuController.ChallengeMode){
                text.relocate(608, 29);
                scoreText.relocate(709, 31);
                HighScore.relocate(505,4);
                HighScoreText.relocate(709,4);
                NameText.relocate(100, 28);
                HomeButton.relocate(5,5);
                HomeButton.setPrefSize(65,30);
            }
            else if(n == 4){
                NameText.relocate(100, 38);
                ModeText.setText("Challenge Mode: ");
                ModeText.relocate(100, 5);
                MoveText.setText("Number of Move remaining : 35 ");
                MoveText.relocate(495,35);
                NumberOfCell.setText("Get three cells of 32: 0 ");
                NumberOfCell.relocate(495,15);
            }

            HomeButton.setOnAction(event -> {
                try {
                    load = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/Resources/menu.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                setN(4);
                MenuController.ChallengeMode=false;
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setTitle("Game 2048");
                stage.setScene(new Scene(load));
                stage.setResizable(false);
                stage.show();
            });

        randomFillNumber(1);
        randomFillNumber(1);

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
                Platform.runLater(() -> {
                    GetCell();
                    int haveEmptyCell;
                    switch (key.getCode()) {
                        case UP -> GameScene.this.moveUp();
                        case DOWN -> GameScene.this.moveDown();
                        case LEFT -> GameScene.this.moveLeft();
                        case RIGHT -> GameScene.this.moveRight();
                    }
                    CheckValue();
                    if(MenuController.ChallengeMode) {
                        CheckNumber32Cell();
                    }
                    scoreText.setText(score + "");
                    if(Account.GetSize()==0 && !MenuController.ChallengeMode){
                        HighScoreText.setText(score + "");
                    }
                    if(Account.GetSize()>=1&& !MenuController.ChallengeMode ){
                        if(Account.GetLabelScore(0)<score) {
                            HighScore.setText("HIGHEST SCORE :");
                            HighScoreText.setText(score + "");
                        }
                    }
                    if(MenuController.ChallengeMode){
                        MoveText.setText("Number of Move remaining: "+ CountMove);
                        NumberOfCell.setText("Number of 32 Cell: "+ NumberOf32Cell);
                    }
                    haveEmptyCell = GameScene.this.haveEmptyCell();
                    if (MenuController.ChallengeMode) {
                        if (CountMove==0 && NumberOf32Cell !=3 ) {
                                check = false;
                                primaryStage.setScene(endGameScene);
                                EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score, check);
                                root.getChildren().clear();
                                score = 0;
                        }
                        if (haveEmptyCell == 1 && key.getCode().isArrowKey()) {
                            if (ValidMove != (n * n)) {
                                GameScene.this.randomFillNumber(2);
                                CountMove--;
                            }
                        }
                        if (CountMove!=0 && NumberOf32Cell >=3) {
                                check = true;
                                primaryStage.setScene(endGameScene);
                                EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score, check);
                                root.getChildren().clear();
                                score = 0;
                        }
                    } else {
                        if (haveEmptyCell == -1) {
                            if (GameScene.this.canNotMove()) {
                                check = false;
                                primaryStage.setScene(endGameScene);
                                EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score, check);
                                Account.accountHaveBeenExist(MenuController.username, (int) score);
                                if (Account.accountHaveBeenExist(MenuController.username, (int) score) == null) {
                                    Account.makeNewAccount(MenuController.username, (int) score);
                                }
                                try {
                                    Account.Rewrite();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                root.getChildren().clear();
                                score = 0;
                            }
                        } else if (haveEmptyCell == 0) {
                                check = true;
                                primaryStage.setScene(endGameScene);
                                EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score, check);
                                Account.accountHaveBeenExist(MenuController.username, (int) score);
                                if (Account.accountHaveBeenExist(MenuController.username, (int) score) == null) {
                                    Account.makeNewAccount(MenuController.username, (int) score);
                                }
                                try {
                                    Account.Rewrite();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                root.getChildren().clear();
                                score = 0;

                        } else if (haveEmptyCell == 1 && key.getCode().isArrowKey()) {
                            if (ValidMove != (n * n)) {
                                GameScene.this.randomFillNumber(2);

                            }
                        }
                    }
                    ValidMove=0;
                });

            });
    }
}
