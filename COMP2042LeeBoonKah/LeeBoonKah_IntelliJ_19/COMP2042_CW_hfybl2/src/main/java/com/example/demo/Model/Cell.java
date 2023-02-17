package com.example.demo.Model;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * This class contains the size and color's design of the cell in the game
 * @author Boon Kah Lee
 */
public class Cell {
    /**
     *Variable rectangle specifies a rectangle
     */
    private final Rectangle rectangle;
    /**
     **variable root is parameter to constructs a group
     */
    private final Group root;
    /**
     *variable textClass denotes a node displaying text.
     */
    private Text textClass;
    /**
     * variable modify is to determine the change of the cell
     */
    private boolean modify = false;

    /**
     * Setter function to assign the boolean value of modify
     * @param modify is the boolean value of modify
     */
    void setModify(boolean modify) {
        this.modify = modify;
    }

    /**
     *Getter function to get the boolean value of modify which use to determine the change of the cell
     * @return the value of modify
     */
    boolean getModify() {
        return modify;
    }

    /**
     * This function specifies a rectangle with the given dimensions and color
     * @param x is the x coordinate of the top left corner of the rectangle
     * @param y is the y coordinate of the top left corner of the rectangle
     * @param scale is the width and height of the rectangle
     * @param root is parameter to constructs a group
     */
    Cell(double x, double y, double scale, Group root) {
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        rectangle.setArcHeight(50);
        rectangle.setArcWidth(50);
        this.root = root;
        rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(rectangle);
    }

    /**
     * THis function is the setter function to set the text class
     * @param textClass assign the text class
     */
    void setTextClass(Text textClass) {
        this.textClass = textClass;
    }

    /**
     * Change the color and text of the cell after two cells are combined into one cell
     * @param cell is the cell called
     */

    void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass);

        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }
        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }

    /**
     *Add the cells together and convert them into one cell with the value undergo addition
     * @param cell is the cell on the board
     */
    void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }

    /**
     * Set the color of the cell with the respective number and color
     * @param number is the number of the cell
     */
    void setColorByNumber(int number) {
        switch (number) {
            case 0 -> rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
            case 2 -> rectangle.setFill(Color.rgb(232, 255, 100, 0.5));
            case 4 -> rectangle.setFill(Color.rgb(232, 220, 50, 0.5));
            case 8 -> rectangle.setFill(Color.rgb(232, 200, 44, 0.8));
            case 16 -> rectangle.setFill(Color.rgb(232, 170, 44, 0.8));
            case 32 -> rectangle.setFill(Color.rgb(180, 120, 44, 0.7));
            case 64 -> rectangle.setFill(Color.rgb(180, 100, 44, 0.7));
            case 128 -> rectangle.setFill(Color.rgb(180, 80, 44, 0.7));
            case 256 -> rectangle.setFill(Color.rgb(180, 60, 44, 0.8));
            case 512 -> rectangle.setFill(Color.rgb(180, 30, 44, 0.8));
            case 1024 -> rectangle.setFill(Color.rgb(250, 0, 44, 0.8));
            case 2048 -> rectangle.setFill(Color.rgb(250, 0, 0, 1));
        }
    }

    /**
     * Getter function to get the value of the x coordinate
     * @return the x coordinate of the cell
     */
    double getX() {
        return rectangle.getX();
    }
    /**
     * Getter function to get the value of the y coordinate
     * @return the y coordinate of the cell
     */
    double getY() {
        return rectangle.getY();
    }

    /**
     * Getter function to get the number of the text
     * @return the text
     */
    int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    /**
     * Getter function to get the text class
     * @return the text text class
     */
    private Text getTextClass() {
        return textClass;
    }

}
