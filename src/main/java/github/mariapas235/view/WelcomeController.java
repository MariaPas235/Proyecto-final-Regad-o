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

    /**
     * Changes the scene to the login scene.
     *
     * @throws IOException If an I/O error occurs.
     */
    @FXML
    public void changeSceneToLogin() throws IOException {
        App.currentController.changeScene(Scenes.LOGIN,null);
    }


    /**
     * Changes the scene to the register scene.
     *
     * @throws IOException If an I/O error occurs.
     */
    @FXML
    public void changeSceneToRegistrer() throws IOException {
        App.currentController.changeScene(Scenes.REGISTRER,null);
    }

    /**
     * Called when the scene is opened. Currently not implemented.
     *
     * @param input The input object, not used in this method.
     * @throws IOException If an I/O error occurs.
     */
    @Override
    public void onOpen(Object input) throws IOException {

    }

    /**
     * Called when the scene is closed. Currently not implemented.
     *
     * @param output The output object, not used in this method.
     */
    @Override
    public void onClose(Object output) {

    }

    /**
     * Initializes the controller. Currently not implemented.
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
