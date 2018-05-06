package javafx.controller;

import javafx.ListPeople;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.domian.User;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import jdbc.SelectAllUsers;

public class MainController {
    @FXML private BorderPane mainPanel;
    @FXML private ListView<User> listViewUsers;
    private ObservableList<User> observableList;

    @FXML private void initialize() {
        for (User u : SelectAllUsers.getUsers()) {
            System.out.println(u);
        }

        observableList = FXCollections.observableList(SelectAllUsers.getUsers());
        listViewUsers.setItems(observableList);
    }

    @FXML private void btnDoAddUser() throws Exception {
        ListPeople lp = new ListPeople();
        lp.dialogAddUser(mainPanel,listViewUsers,observableList);
    }
}
