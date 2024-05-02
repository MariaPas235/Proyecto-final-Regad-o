package github.mariapas235.view;

import github.mariapas235.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrerController extends Controller implements Initializable {
    @FXML
    ImageView imagenViewAtras;
    @FXML
    Button buttonRegistrerWorker;
    @FXML
    Button buttonRegistrerBoss;
    @FXML
    public void changeSceneToWelcome() throws IOException {
        App.currentController.changeScene(Scenes.WELCOME,null);
    }
    //@FXML
  //  public void changeSceneToRegistrerBoss() throws IOException {
   //     App.currentController.changeScene(Scenes., null);
   // }

    @FXML
    public void changeSceneToRegistrerWorker() throws IOException {
        App.currentController.changeScene(Scenes.REGISTRERWORKER, null);
    }

    @FXML
    public void changeSceneToRegistrerBoss() throws IOException {
        App.currentController.changeScene(Scenes.REGISTRERBOSS, null);
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
