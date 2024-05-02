package github.mariapas235.view;

import github.mariapas235.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController extends Controller implements Initializable {
    @FXML
    Button buttonLogin;
    @FXML
    Button buttonRegistrer;
    @FXML
    public void changeSceneToLogin() throws IOException {
        App.currentController.changeScene(Scenes.LOGIN,null);
    }
    @FXML
    public void changeSceneToRegistrer() throws IOException {
        App.currentController.changeScene(Scenes.REGISTRER,null);
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
