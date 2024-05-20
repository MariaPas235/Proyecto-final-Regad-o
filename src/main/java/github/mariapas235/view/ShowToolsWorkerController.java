package github.mariapas235.view;

import github.mariapas235.model.dao.PiecesDAO;
import github.mariapas235.model.dao.WorkersDAO;
import github.mariapas235.model.entity.ForHire;
import github.mariapas235.model.entity.Pieces;
import github.mariapas235.model.entity.Session;
import github.mariapas235.model.entity.Workers;
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

public class ShowToolsWorkerController extends Controller implements Initializable {

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

    PrincipalPageWorkerController parent;

    private ObservableList<Pieces> pieces;

    /**
     * Called when the scene is opened. Retrieves all tool data from the database and populates the showTools TableView
     * with the data.
     * @param input The input object containing the parent controller.
     * @throws IOException If an I/O error occurs.
     */
    @Override
    public void onOpen(Object input) throws IOException {
        this.parent = (PrincipalPageWorkerController) input;
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
     * Initializes the controller. Sets the cell value factories for the columns in the showTools TableView and adds an
     * event handler to insert a tool for hire when double-clicked.
     *
     * @param url  The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTool.setCellValueFactory(piece ->
                new SimpleStringProperty(piece.getValue().getName()));
        categoryTool.setCellValueFactory(piece ->
                new SimpleStringProperty(piece.getValue().getCategory().toString()));
        quantityTool.setCellValueFactory(piece ->
                new SimpleIntegerProperty(piece.getValue().getQuantity()).asObject());
        GarageTool.setCellValueFactory(piece ->
                new SimpleStringProperty(piece.getValue().getGarage().getName()));


        showTools.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Pieces pieceSeleccionada = (Pieces) showTools.getSelectionModel().getSelectedItem();
                if (pieceSeleccionada != null) {
                    Pieces pieces = (Pieces) showTools.getSelectionModel().getSelectedItem();
                    PiecesDAO pDAO = new PiecesDAO();
                    Pieces axu=pDAO.findByName(pieces.getName());
                    PiecesDAO.ForHireDAO fhDAO = new PiecesDAO.ForHireDAO();
                    ForHire fh = new ForHire();
                    fhDAO.insert(axu,fh);
                    AppController.alertWarning("Se ha creado un nuevo préstamo, ya puede consultarlo en la pestaña de Préstamos");
                    String email = Session.getInstance().getUserLogged().getEmail();
                    WorkersDAO w = new WorkersDAO();
                    Workers worker = w.findByEmailAll(email);
                }
            }
        });

    }


}
