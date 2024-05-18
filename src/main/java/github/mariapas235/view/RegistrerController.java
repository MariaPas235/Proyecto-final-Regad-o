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


    /**
     * Changes the scene to the Welcome scene.
     * @throws IOException if an I/O error occurs during the scene change.
     */
    @FXML
    public void changeSceneToWelcome() throws IOException {
        App.currentController.changeScene(Scenes.WELCOME,null);
    }


    /**
     * Changes the scene to the Register Worker scene.
     * @throws IOException if an I/O error occurs during the scene change.
     */
    @FXML
    public void changeSceneToRegistrerWorker() throws IOException {
        App.currentController.changeScene(Scenes.REGISTRERWORKER, null);
    }

    /**
     * Changes the scene to the Register Boss scene.
     * @throws IOException if an I/O error occurs during the scene change.
     */
    @FXML
    public void changeSceneToRegistrerBoss() throws IOException {
        App.currentController.changeScene(Scenes.REGISTRERBOSS, null);
    }

    /**
     * Method to handle actions when the scene is opened.
     * @param input the input object for the scene.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void onOpen(Object input) throws IOException {

    }


    /**
     * Method to handle actions when the scene is closed.
     * @param output the output object for the scene.
     */
    @Override
    public void onClose(Object output) {

    }

    /**
     * Method to initialize the controller.
     * @param url the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
