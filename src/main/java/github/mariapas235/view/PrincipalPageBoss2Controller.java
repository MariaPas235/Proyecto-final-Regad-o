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




    @FXML
    public void logOut() throws IOException {
        Session.getInstance().logOut();
        App.currentController.changeScene(Scenes.WELCOME,null);
    }

    Controller currentController;


    public void writeName(){
        textName.setText("Hola: "+ Session.getInstance().getUserLogged().getName());
    }


    public void writeID(){

        String email = Session.getInstance().getUserLogged().getEmail();
        BossDAO b = new BossDAO();

        Boss boss =  b.findByEmailAll(email);

        textID.setText("ID: "+boss.getIDBoss());
        System.out.println(boss.toString());
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
        changeScene(Scenes.SHOWTOOLSBOSS);
    }
    @FXML
    public void changeToShowGarage() throws IOException {
        changeScene(Scenes.SHOWGARAGEBOSS);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        writeName();
        writeID();
        System.out.println("Cargando scene inicial");
        changeScene(Scenes.BUTTONSINSERTTOOLSGARAGES);
    }
}
