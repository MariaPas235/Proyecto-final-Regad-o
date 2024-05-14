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
    @FXML
    public void returnToButtons() {
        parent.changeScene(Scenes.BUTTONSINSERTTOOLSGARAGES);
    }
    @Override
    public void onOpen(Object input) throws IOException {
        this.parent = (PrincipalPageBoss2Controller) input;
        GarageDAO gDAO = new GarageDAO();
        List<Garage> garageList = gDAO.findAll();
        garage = FXCollections.observableArrayList(garageList);
        showGarages.setItems(garage);
    }

    @Override
    public void onClose(Object output) {

    }

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
