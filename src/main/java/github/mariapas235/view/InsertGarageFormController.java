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

    /**
     * Reference to the parent controller.
     * Allows accessing methods in the parent controller.
     */
    PrincipalPageBoss2Controller parent;


    /**
     * Collects data from the input fields to create a new Garage object.
     * @return the Garage object with collected data
     */
    public Garage collectDataGarage(){
        String name = textFieldName.getText();
        String location = textFieldLocalitation.getText();
        String garageNumber = textFieldGarageNumber.getText();
        int garageNumberInt = Integer.parseInt(garageNumber);

        Garage g = new Garage(garageNumberInt,name,location);
        return g;

    }

    /**
     * Inserts a new garage into the database and switches the scene to the buttons insert tools/garages scene.
     * Called when the insert garage button is clicked in the UI.
     */
    @FXML
    public void insertGarage(){
       Garage g = collectDataGarage();
        GarageDAO gDAO = new GarageDAO();
        gDAO.insert(g);
        AppController.alertWarning("El garage ha sido insertado correctamente.");
        parent.changeScene(Scenes.BUTTONSINSERTTOOLSGARAGES);
    }

    /**
     * Inserts a new garage into the database and switches the scene to the buttons insert tools/garages scene.
     * Called when the insert garage button is clicked in the UI.
     */
    @FXML
    public void returnButtons(){

        parent.changeScene(Scenes.BUTTONSINSERTTOOLSGARAGES);
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
