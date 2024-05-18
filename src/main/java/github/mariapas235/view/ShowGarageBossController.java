package github.mariapas235.view;

import github.mariapas235.model.dao.GarageDAO;
import github.mariapas235.model.dao.PiecesDAO;
import github.mariapas235.model.entity.Garage;
import github.mariapas235.model.entity.Pieces;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowGarageBossController extends Controller implements Initializable {
    @FXML
    ImageView returnToButtons;
    PrincipalPageBoss2Controller parent;
    @FXML
    TableView showGarages;
    @FXML
    TableColumn<Garage, String> nameGarage;
    @FXML
    TableColumn<Garage, Integer> numberGarage;
    @FXML
    TableColumn<Garage, String> locationGarage;

    private ObservableList<Garage> garage;


    /**
     * Returns to the previous scene when the corresponding button is clicked.
     */
    @FXML
    public void returnToButtons() {
        parent.changeScene(Scenes.BUTTONSINSERTTOOLSGARAGES);
    }

    /**
     * Called when the scene is opened. Retrieves all garage data from the database and populates the showGarages ListView
     * with the data.
     * @param input The input object, not used in this method.
     * @throws IOException If an I/O error occurs.
     */
    @Override
    public void onOpen(Object input) throws IOException {
        this.parent = (PrincipalPageBoss2Controller) input;
        GarageDAO gDAO = new GarageDAO();
        List<Garage> garageList = gDAO.findAll();
        garage = FXCollections.observableArrayList(garageList);
        showGarages.setItems(garage);
    }


    /**
     * Called when the scene is closed. Currently not implemented.
     * @param output The output object, not used in this method.
     */
    @Override
    public void onClose(Object output) {

    }

    /**
     * Initializes the controller. Configures the showGarages ListView to be editable and sets the cell value factories for the columns.
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showGarages.setEditable(true);
        nameGarage.setCellValueFactory(garage ->
                new SimpleStringProperty(garage.getValue().getName()));
        numberGarage.setCellValueFactory(garage ->
                new SimpleIntegerProperty(garage.getValue().getGarageNumber()).asObject());
        locationGarage.setCellValueFactory(garage ->
                new SimpleStringProperty(garage.getValue().getLocation()));

    }
}
