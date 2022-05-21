package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Main extends Application {

    private final int ANIMATION_PANEL_START_X = 14;
    private final int ANIMATION_PANEL_START_Y = 14;
    private final int ANIMATION_PANEL_WIDTH = 870;
    private final int ANIMATION_PANEL_HEIGHT = 700;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);

        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

    }
}
