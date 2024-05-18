package github.mariapas235.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ButtonsInsertToolsGaragesController extends Controller implements Initializable {
    @FXML
    Rectangle insertToolsButton;
    @FXML
    Rectangle insertGarageButton;

    /**
     * Reference to the parent controller.
     * Allows accessing methods in the parent controller.
     */
    PrincipalPageBoss2Controller parent;


    /**
     * Changes the scene to the insert garage form.
     * Called when the corresponding button is clicked in the UI.
     */
    @FXML
    public void changeSceneToInsertGarageForm(){
        parent.changeScene(Scenes.INSERTGARAGEFORM);
    }

    /**
     * Changes the scene to the insert tool form.
     * Called when the corresponding button is clicked in the UI.
     */
    @FXML
    public void changeSceneToInsertToolForm(){
        parent.changeScene(Scenes.INSERTTOOLFORM);
    }

    /**
     * Called when the controller is opened.
     * Initializes the reference to the parent controller.
     * @param input the parent controller passed as input
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void onOpen(Object input) throws IOException {
       this.parent = (PrincipalPageBoss2Controller) input;

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
     * Currently, no initialization is performed in this method.
     * @param url the location relative to the root of the FXML document being loaded
     * @param resourceBundle the resources that may be needed to initialize the controller (not used in this method)
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
