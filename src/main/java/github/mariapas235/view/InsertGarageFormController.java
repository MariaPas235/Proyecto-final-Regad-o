package github.mariapas235.view;

import github.mariapas235.model.dao.GarageDAO;
import github.mariapas235.model.entity.Garage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InsertGarageFormController extends Controller implements Initializable {
    @FXML
    TextField textFieldName;
    @FXML
    TextField textFieldLocalitation;
    @FXML
    TextField textFieldGarageNumber;
    @FXML
    Button buttonInsertGarage;
    @FXML
    ImageView returnToButtons;

    PrincipalPageBoss2Controller parent;


    public Garage collectDataGarage(){
        String name = textFieldName.getText();
        String location = textFieldLocalitation.getText();
        String garageNumber = textFieldGarageNumber.getText();
        int garageNumberInt = Integer.parseInt(garageNumber);

        Garage g = new Garage(garageNumberInt,name,location);
        return g;

    }

    @FXML
    public void insertGarage(){
       Garage g = collectDataGarage();
        GarageDAO gDAO = new GarageDAO();
        gDAO.insert(g);
        AppController.alertEmptyEmail();
        parent.changeScene(Scenes.BUTTONSINSERTTOOLSGARAGES);
    }

    @FXML
    public void returnButtons(){
        parent.changeScene(Scenes.BUTTONSINSERTTOOLSGARAGES);
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
