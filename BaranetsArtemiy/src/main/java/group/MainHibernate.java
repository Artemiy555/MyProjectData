package group;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainHibernate extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("MySQL base");
        Parent view = FXMLLoader.load(getClass().getResource("/GroupFX/main.fxml"));

        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }
}
