package github.mariapas235.view;

import github.mariapas235.App;
import github.mariapas235.model.dao.BossDAO;
import github.mariapas235.model.dao.WorkersDAO;
import github.mariapas235.model.entity.Boss;
import github.mariapas235.model.entity.Session;
import github.mariapas235.model.entity.Workers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalPageWorkerController extends Controller implements Initializable {
    @FXML
    AnchorPane anchorPaneChangeScene;
    @FXML
    Text textName;
    @FXML
    Text textID;
    @FXML
    Rectangle logOut;
    @FXML
    Rectangle showTools;
    @FXML
    Rectangle showForHire;



    /**
     * Logs out the current user and changes the scene to the welcome screen.
     * @throws IOException if an error occurs while changing the scene
     */
    @FXML
    public void logOut() throws IOException {
        Session.getInstance().logOut();
        App.currentController.changeScene(Scenes.WELCOME,null);
    }

    Controller currentController;


    /**
     * Writes the name of the currently logged-in user in the textName field.
     */
    @FXML
    public void writeName(){

        textName.setText("Hola: "+ Session.getInstance().getUserLogged().getName());
    }

    /**
     * Writes the ID of the currently logged-in user in the textID field.
     */
    @FXML
    public void writeID(){

        String email = Session.getInstance().getUserLogged().getEmail();
        WorkersDAO w = new WorkersDAO();
        Workers worker = w.findByEmailAll(email);
        textID.setText("ID: "+ worker.getIDWorker());

    }

    /**
            * Called when the controller is opened.
            * @param input the input data (not used in this method).
            * @throws IOException if an I/O error occurs.
     */
    @Override
    public void onOpen(Object input) throws IOException {

    }

    /**
     * Called when the controller is closed.
     * @param output the output data (not used in this method).
     */
    @Override
    public void onClose(Object output) {

    }

    /**
     * Changes the current scene to the specified scene.
     * @param scene the scene to change to
     */
    public void changeScene(Scenes scene){
        try {
            View view = AppController.loadFXML(scene);
            this.currentController=view.controller;
            view.controller.onOpen(this);
            while(anchorPaneChangeScene.getChildren().size()>0){
                anchorPaneChangeScene.getChildren().remove(0);
            }
            anchorPaneChangeScene.getChildren().add(view.scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Changes the scene to show the tools.
     * @throws IOException if an error occurs while changing the scene
     */
    @FXML
    public void changeToShowTools() throws IOException {
        changeScene(Scenes.SHOWTOOLWORKER);
    }

    /**
     * Changes the scene to show the items for hire.
     * @throws IOException if an error occurs while changing the scene
     */
    @FXML
    public void changeToShowForHIre() throws IOException {
       changeScene(Scenes.SHOWFORHIREWORKER);
    }


    /**
     * Initializes the controller. Called to initialize a controller after its root element has been completely processed.
     * @param url the location used to resolve relative paths for the root object, or null if the location is not known
     * @param resourceBundle the resources used to localize the root object, or null if no resources were specified
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        writeName();
        writeID();
    }
}
