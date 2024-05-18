package github.mariapas235.view;

import github.mariapas235.App;
import github.mariapas235.model.dao.BossDAO;
import github.mariapas235.model.entity.Boss;
import github.mariapas235.model.entity.Session;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalPageBoss2Controller extends Controller implements Initializable {
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
    Rectangle showGarages;

    /**
     * Handles the logout process.
     * @throws IOException if an I/O error occurs.
     */
    @FXML
    public void logOut() throws IOException {
        Session.getInstance().logOut();
        App.currentController.changeScene(Scenes.WELCOME,null);
    }

    Controller currentController;


    /**
     * Writes the logged-in user's name to the text field.
     */
    public void writeName(){
        textName.setText("Hola: "+ Session.getInstance().getUserLogged().getName());
    }


    /**
     * Writes the logged-in boss's ID to the text field.
     */
    public void writeID(){

        String email = Session.getInstance().getUserLogged().getEmail();
        BossDAO b = new BossDAO();

        Boss boss =  b.findByEmailAll(email);

        textID.setText("ID: "+boss.getIDBoss());
        System.out.println(boss.toString());
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
     * Changes the scene to the specified scene.
     * @param scene the scene to change to.
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
     * Changes the scene to show the tools for the boss.
     * @throws IOException if an I/O error occurs.
     */
    @FXML
    public void changeToShowTools() throws IOException {
        changeScene(Scenes.SHOWTOOLSBOSS);
    }

    /**
     * Changes the scene to show the garage for the boss.
     * @throws IOException if an I/O error occurs.
     */
    @FXML
    public void changeToShowGarage() throws IOException {
        changeScene(Scenes.SHOWGARAGEBOSS);
    }

    /**
     * Initializes the controller.
     * @param url the location relative to the root of the FXML document being loaded.
     * @param resourceBundle the resources that may be needed to initialize the controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        writeName();
        writeID();
        System.out.println("Cargando scene inicial");
        changeScene(Scenes.BUTTONSINSERTTOOLSGARAGES);
    }
}
