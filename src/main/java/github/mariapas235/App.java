package github.mariapas235;

import github.mariapas235.view.AppController;
import github.mariapas235.view.Scenes;
import github.mariapas235.view.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    public static Scene scene ;
    public static Stage stage;
    public static AppController currentController;


    @Override
    public void start(Stage stage) throws IOException {
       View view = AppController.loadFXML(Scenes.ROOT);
      scene = new Scene(view.scene,1920,1080);
      currentController=(AppController) view.controller;
      currentController.onOpen(null);
      stage.setScene(scene);
      stage.show();


    }

    static void setRoot(String fxml) throws IOException {
       // scene.setRoot(loadFXML(fxml));
    }


    public static void main(String[] args) {
        launch();
    }

}