package com.example.demo.Model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This class is used to modify the text in the cell
 * @author Boon Kah Lee
 */
class TextMaker {
    private static TextMaker singleInstance = null;

    private TextMaker() {

    }

    /**
     * Setter function to get the instance
     * @return text maker
     */
    static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }

    /**
     *This function is used to generate text of the cell
     * @param input the text of the cell
     * @param xCell the x coordinate of the cell
     * @param yCell the y coordinate of the cell
     * @param root the group of the gameScene
     * @return the text of the cell
     */
    Text madeText(String input, double xCell, double yCell, Group root) {
        double length = GameScene.getLENGTH();
        double fontSize = (2.5 * length) / 7.0;
        Text text = new Text(input);
        text.setFont(Font.font(fontSize));
        text.relocate((xCell + (1.2)* length / 7.0), (yCell + 2 * length / 7.0));
        text.setFill(Color.WHITE);

        return text;
    }

    /**
     * Change the text after the cell begin combine
     * @param first is the first cell
     * @param second is the second cell
     */
    static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        double tempNumber;
        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);

    }

}
