package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Main2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Регистрация.fxml"));
        primaryStage.setTitle("Game");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    /*public class Test extends Application {
        Button startgameK = new Button();
        public void start(final Stage stage) throws MalformedURLException {

            final WebView browser = new WebView();
            final WebEngine webEngine = browser.getEngine();

            startgameK.setOnAction(event -> {

                try {
                    File file = new File("src\\game\\index.html");
                 URL url = file.toURI().toURL();
                    webEngine.load(url.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }


            VBox root = new VBox();
            root.setPadding(new Insets(5));
            root.setSpacing(5);
            root.getChildren().addAll(browser);

            Scene scene = new Scene(root);

            stage.setTitle("JavaFX WebView ");
            stage.setScene(scene);
            stage.setWidth(600);
            stage.setHeight(600);
            stage.show();
        });}

        //public static void main(String[] args) {
            //launch(args);
        }*/}


// }

//}
