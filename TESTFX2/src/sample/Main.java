package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {


    private JInternalFrame stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button btn1 = new Button("Hello World!"); StackPane pane = new StackPane(); pane.getChildren().add(btn1);
        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("Test JavaFX");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
