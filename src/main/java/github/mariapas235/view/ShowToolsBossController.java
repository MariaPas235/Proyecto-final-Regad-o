package github.mariapas235.view;

import github.mariapas235.model.dao.PiecesDAO;
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

public class ShowToolsBossController extends Controller implements Initializable {
    @FXML
    ImageView returnToButtons;
    PrincipalPageBoss2Controller parent;
    @FXML
    TableView showTools;
    @FXML
    TableColumn<Pieces, String> nameTool;
    @FXML
    TableColumn<Pieces, String> categoryTool;
    @FXML
    TableColumn<Pieces, Integer> quantityTool;
    @FXML
    TableColumn<Pieces, String> GarageTool;
    @FXML
    TableColumn<Pieces, Float> PrizeTool;

    private ObservableList<Pieces> pieces;


    /**
     * Returns to the previous scene when the corresponding button is clicked.
     */
    @FXML
    public void returnToButtons() {
        parent.changeScene(Scenes.BUTTONSINSERTTOOLSGARAGES);
    }

    /**
     * Called when the scene is opened. Retrieves all tool data from the database and populates the showTools TableView
     * with the data.
     *
     * @param input The input object, not used in this method.
     * @throws IOException If an I/O error occurs.
     */
    @Override
    public void onOpen(Object input) throws IOException {
        this.parent = (PrincipalPageBoss2Controller) input;
        PiecesDAO pDAO = new PiecesDAO();
        List<Pieces> piecesList = pDAO.findAll();
        pieces = FXCollections.observableArrayList(piecesList);
        showTools.setItems(pieces);
    }


    /**
     * Called when the scene is closed. Currently not implemented.
     *
     * @param output The output object, not used in this method.
     */
    @Override
    public void onClose(Object output) {

    }

    /**
     * Initializes the controller. Configures the showTools TableView to be editable and sets the cell value factories for the columns. Also, sets an event handler to delete a tool when double-clicked.
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showTools.setEditable(true);
        nameTool.setCellValueFactory(piece ->
                new SimpleStringProperty(piece.getValue().getName()));
        categoryTool.setCellValueFactory(piece ->
                new SimpleStringProperty(piece.getValue().getCategory().toString()));
        quantityTool.setCellValueFactory(piece ->
                new SimpleIntegerProperty(piece.getValue().getQuantity()).asObject());
        GarageTool.setCellValueFactory(piece ->
                new SimpleStringProperty(piece.getValue().getGarage().getName()));
        PrizeTool.setCellValueFactory(piece ->
                new SimpleFloatProperty(piece.getValue().getPrize()).asObject());


        showTools.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Pieces pieceSeleccionada = (Pieces) showTools.getSelectionModel().getSelectedItem();
                if (pieceSeleccionada != null) {
                    Pieces pieces = (Pieces) showTools.getSelectionModel().getSelectedItem();
                    PiecesDAO pDAO = new PiecesDAO();
                    Pieces axu=pDAO.findByName(pieces.getName());
                    pDAO.delete(axu);
                    AppController.alertWarning("La pieza ha sido eliminada con éxito");
                    parent.changeScene(Scenes.SHOWTOOLSBOSS);

                }
            }
        });

    }
}
