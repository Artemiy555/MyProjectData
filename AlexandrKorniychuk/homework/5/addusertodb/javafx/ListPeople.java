package javafx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jdbc.SelectAllUsers;


public class ListPeople extends Application {
    public static volatile boolean live = true;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Authorization");
        primaryStage.setResizable(false);
        Parent wind = FXMLLoader.load(getClass().getResource("/resources/view/authorization.fxml"));
        primaryStage.setScene(new Scene(wind));

        primaryStage.setOnCloseRequest(event -> System.exit(0));

        primaryStage.show();

        
    }

    public void listUsers() throws Exception {
        Stage dialog = new Stage();
        dialog.setTitle("List");
        dialog.setResizable(false);
        Parent wind = FXMLLoader.load(getClass().getResource("/resources/view/list.fxml"));
        dialog.setScene(new Scene(wind));

        dialog.setOnCloseRequest(event -> System.exit(0));

        dialog.show();
    }

    public void dialogAddUser(BorderPane mainPanel, ListView list, ObservableList observableList) throws Exception {
        Stage dialog = new Stage();
        dialog.setTitle("input user data");
        Parent dilWin = FXMLLoader.load(getClass().getResource("/resources/view/dialogadduser.fxml"));


        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(mainPanel.getScene().getWindow());

        dialog.setOnCloseRequest(event -> {
            observableList.setAll(SelectAllUsers.getUsers());
            list.refresh();
        });

        dialog.setScene(new Scene(dilWin));
        dialog.show();
    }
}
