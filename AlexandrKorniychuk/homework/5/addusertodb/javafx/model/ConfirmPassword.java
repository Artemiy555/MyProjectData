package javafx.model;

import javafx.ListPeople;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ConfirmPassword {
    private final String login = "Alex";
    private final String password = " ";

    public ConfirmPassword(TextField log, PasswordField pass) {

        if (log.getText().equals(login)&&pass.getText().equals(password)) {
            System.out.println("OK");
            ListPeople.live = false;
            ListPeople lp = new ListPeople();
            try {
                lp.listUsers();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("FAIL");
            log.clear();
            pass.clear();
        }
    }
}
