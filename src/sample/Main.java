package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.PrimitiveIterator;

public class Main extends Application {
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage= primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("El tiempo");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
