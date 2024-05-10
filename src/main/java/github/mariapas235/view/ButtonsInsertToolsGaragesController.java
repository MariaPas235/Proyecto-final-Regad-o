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

    PrincipalPageBoss2Controller parent;


    @FXML
    public void changeSceneToInsertGarageForm(){
        parent.changeScene(Scenes.INSERTGARAGEFORM);
    }
    @FXML
    public void changeSceneToInsertToolForm(){
        parent.changeScene(Scenes.INSERTTOOLFORM);
    }

    @Override
    public void onOpen(Object input) throws IOException {
       this.parent = (PrincipalPageBoss2Controller) input;

     }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
