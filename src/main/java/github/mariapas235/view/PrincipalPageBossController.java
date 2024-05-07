package github.mariapas235.view;

import github.mariapas235.App;
import github.mariapas235.model.entity.Session;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalPageBossController extends Controller implements Initializable {
    @FXML
    Text buttonLogOut;
    @FXML
    Text textName;
    @FXML
    Text textID;

    @FXML
    public void writeName(){
        String name = Session.getInstance().getUserLogged().getName();
        textName.setText(name);
    }

    @FXML
    public void writeID(){
       // String id = Session.getInstance().getUserLogged().
    }

    @FXML
    public void LogOutBoss() throws IOException {
        Session.getInstance().logOut();
        App.currentController.changeScene(Scenes.WELCOME, null);
    }


    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        writeName();
    }
}
