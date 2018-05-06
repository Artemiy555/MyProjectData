package javafx.controller;

import javafx.ListPeople;
import javafx.fxml.FXML;
import javafx.model.ConfirmPassword;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DialogController {

    @FXML private VBox panelVBox;
    @FXML private TextField fldLogin;
    @FXML private PasswordField fldPassword;

    @FXML private void initialize()  {

        if(!ListPeople.live) {

            try {
                new ListPeople();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ListPeople.live = false;

            Stage first = (Stage) panelVBox.getScene().getWindow();
//            first.getOnCloseRequest().handle(new WindowEvent(first,WindowEvent.WINDOW_CLOSE_REQUEST));
            first.close();
        }
    }

    @FXML private void btnDoEnter() {
        new ConfirmPassword(fldLogin, fldPassword);
        initialize();
    }


}
