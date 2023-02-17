package com.example.demo.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
/**
 *This class control all the function of the button which in the Help page
 *@author Boon Kah Lee
 */
public class HelpController implements Initializable {
    private Parent root;
    private Stage stage;
    private final String[] size ={"3x3","4x4","5x5","Challenge Mode"};

    @FXML
    private ComboBox<String> Help_Board;

    @FXML
    private ColorPicker Help_ColorPicker;

    @FXML
    private Rectangle Help_Rectangle;

    @FXML
    private ImageView Pic_Size_3x3;

    @FXML
    private ImageView Pic_Size_4x4;

    @FXML
    private ImageView Pic_Size_5x5;
    @FXML
    private ImageView Pic_Challenge;

    /**
     *This function is the let the user preview the board size of the game and the game mode
     * @param event is the action that the suer act on the combo box in the help page
     */
    @FXML
    void Get_Help_Board(ActionEvent event) {
        String Size = Help_Board.getSelectionModel().getSelectedItem();
        switch (Size){
            case "3x3":
                Pic_Size_3x3.setVisible(true);
                Pic_Size_4x4.setVisible(false);
                Pic_Size_5x5.setVisible(false);
                Pic_Challenge.setVisible(false);
                break;
            case "4x4":
                Pic_Size_3x3.setVisible(false);
                Pic_Size_4x4.setVisible(true);
                Pic_Size_5x5.setVisible(false);
                Pic_Challenge.setVisible(false);
                break;
            case "5x5":
                Pic_Size_3x3.setVisible(false);
                Pic_Size_4x4.setVisible(false);
                Pic_Size_5x5.setVisible(true);
                Pic_Challenge.setVisible(false);
                break;
            case "Challenge Mode":
                System.out.println("Yes");
                Pic_Challenge.setVisible(true);
                Pic_Size_3x3.setVisible(false);
                Pic_Size_4x4.setVisible(false);
                Pic_Size_5x5.setVisible(false);
            default:
                Pic_Size_4x4.setVisible(true);
        }
    }
    /**
     * This function will switch the page from the Help page to the menu page
     * @param event is the action that act by the user on the button
     * @throws IOException when there is the error occurs during the load of fxml file
     */
    @FXML
    void Help_To_Main(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/Resources/menu.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * This function is used to change the color of the rectangle in the help by using the color picker
     * @param event is the action that act by the user on the button
     */
    @FXML
    void Testing_change(ActionEvent event) {
        Color HelpColor =Help_ColorPicker.getValue();
        Help_Rectangle.setFill(HelpColor);
    }

    /**
     * This function initialize are used when interact with thing injected with @FXML and call initialize interface after everything is set up
     * The display of the leaderboard used this function to display at the leaderboard page
     * @param url is used to resolve relative paths for the root object, or null if the precise location is unknown
     * @param resourceBundle is used to localize the root object, or null if the precise location is unknown
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList(size);
        if (Help_Board != null){
            Help_Board.setValue("4x4");
            Help_Board.setItems(list);
        }

    }
}
