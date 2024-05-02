package github.mariapas235.view;

import github.mariapas235.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController extends Controller implements Initializable {
    @FXML
    ImageView imagenViewAtras;
    @FXML
    Button ButtonLogInWorker;
    @FXML
    Button ButtonLogInBoss;
    @FXML
    public void changeSceneToWelcome() throws IOException {
        App.currentController.changeScene(Scenes.WELCOME,null);
    }
    @FXML
    public void changeSceneToLogInWorker() throws IOException {
        App.currentController.changeScene(Scenes.LOGINWORKER,null);
    }
    @FXML
    public void changeSceneToLogInBoss() throws IOException {
        App.currentController.changeScene(Scenes.LOGINBOSS,null);
    }

    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
