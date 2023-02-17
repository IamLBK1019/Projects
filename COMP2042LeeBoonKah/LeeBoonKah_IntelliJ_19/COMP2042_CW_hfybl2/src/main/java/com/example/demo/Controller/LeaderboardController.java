package com.example.demo.Controller;

import com.example.demo.Model.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 *This class control all the function of the button which in the leaderboard page
 * @author Boon Kah Lee
 */
public class LeaderboardController implements Initializable {
    private Parent root;
    private Stage stage;
    @FXML
    private Label Rank1;

    @FXML
    private Label Rank2;

    @FXML
    private Label Rank3;

    @FXML
    private TableColumn<Account, Long> Score;

    @FXML
    private TableView<Account> Table;

    @FXML
    private TableColumn<Account, String> User;

    @FXML
    private Label Top1Score;

    @FXML
    private Label Top1User;

    @FXML
    private Label Top2Score;

    @FXML
    private Label Top2User;

    @FXML
    private Label Top3Score;

    @FXML
    private Label Top3User;
    /**
     * This function will switch the page from the Leaderboard page to the menu page
     * @param event is the action that act by the user on the score button
     * @throws IOException when there is the error occurs during the load of fxml file
     */
    @FXML
    void Leaderboard_to_Main(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/Resources/menu.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    /**
     * This function initialize are used when interact with thing injected with @FXML and call initialize interface after everything is set up
     * @param url is used to resolve relative paths for the root object, or null if the precise location is unknown
     * @param resourceBundle is used to localize the root object, or null if the precise location is unknown
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(User!=null) {
            ObservableList<Account> list2 = FXCollections.observableArrayList(Account.getAccounts());
            User.setCellValueFactory(new PropertyValueFactory<Account, String>("userName"));
            Score.setCellValueFactory(new PropertyValueFactory<Account, Long>("score"));
            Table.setItems(list2);

        }

        if(Top1User!=null) {
            int count;
            count = Account.GetSize();
            while (count != 0) {
                if (count == 1) {
                    Top1User.setText(Account.GetLabelName(0));
                    Top1Score.setText(String.valueOf(Account.GetLabelScore(0)));
                    Rank1.setText(Account.GetLabelName(0));
                } else if (count == 2) {
                    Top2User.setText(Account.GetLabelName(1));
                    Top2Score.setText(String.valueOf(Account.GetLabelScore(1)));
                    Rank2.setText(Account.GetLabelName(1));
                } else if (count == 3) {
                    Top3User.setText(Account.GetLabelName(2));
                    Top3Score.setText(String.valueOf(Account.GetLabelScore(2)));
                    Rank3.setText(Account.GetLabelName(2));
                }
                count--;
            }
        }

    }

}

