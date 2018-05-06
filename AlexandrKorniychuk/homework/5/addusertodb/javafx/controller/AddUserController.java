package javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import jdbc.SelectAllUsers;

public class AddUserController {
    @FXML private TextField fldName;
    @FXML private TextField fldSurname;
    @FXML private Button btnAddUser;

    @FXML private void btnDoAddUser() {
        SelectAllUsers.getID ++;
        SelectAllUsers.insertNewUserToDB(SelectAllUsers.getID,fldName.getText(),fldSurname.getText());
    }


}
