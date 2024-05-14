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


    @FXML
    public void logOut() throws IOException {
        Session.getInstance().logOut();
        App.currentController.changeScene(Scenes.WELCOME,null);
    }

    Controller currentController;

    @FXML
    public void writeName(){
        textName.setText("Hola: "+ Session.getInstance().getUserLogged().getName());
    }
    @FXML
    public void writeID(){

        String email = Session.getInstance().getUserLogged().getEmail();
        WorkersDAO w = new WorkersDAO();
        Workers worker = w.findByEmailAll(email);
        textID.setText("ID: "+ worker.getIDWorker());

    }

    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

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

    @FXML
    public void changeToShowTools() throws IOException {
       // changeScene(Scenes.SHOWTOOLSWORKER);
    }

    @FXML
    public void changeToShowForHIre() throws IOException {
       // changeScene(Scenes.SHOWFORHIRE);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        writeName();
        writeID();
    }
}
