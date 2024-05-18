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
    /**
     * Changes the scene to the welcome page.
     * @throws IOException if an I/O error occurs
     */
    @FXML
    public void changeSceneToWelcome() throws IOException {
        App.currentController.changeScene(Scenes.WELCOME,null);
    }
    /**
     * Changes the scene to the worker login page.
     * @throws IOException if an I/O error occurs
     */
    @FXML
    public void changeSceneToLogInWorker() throws IOException {
        App.currentController.changeScene(Scenes.LOGINWORKER,null);
    }
    /**
     * Changes the scene to the boss login page.
     * @throws IOException if an I/O error occurs
     */
    @FXML
    public void changeSceneToLogInBoss() throws IOException {
        App.currentController.changeScene(Scenes.LOGINBOSS,null);
    }

    /**
     * Called when the controller is opened.
     * Currently, no action is performed when the controller is opened.
     * @param input the input data (not used in this method)
     * @throws IOException if an I/O error occurs
     */

    @Override
    public void onOpen(Object input) throws IOException {

    }

    /**
     * Called when the controller is closed.
     * Currently, no action is performed when the controller is closed.
     * @param output the output data (not used in this method)
     */
    @Override
    public void onClose(Object output) {

    }

    /**
     * Initializes the controller.
     * Currently, no initialization is performed.
     * @param url the location relative to the root of the FXML document being loaded
     * @param resourceBundle the resources that may be needed to initialize the controller (not used in this method)
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
