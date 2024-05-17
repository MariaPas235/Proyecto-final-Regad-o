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

    @Override
    public void onOpen(Object input) throws IOException {
        this.parent = (PrincipalPageWorkerController) input;
        PiecesDAO pDAO = new PiecesDAO();
        List<Pieces> piecesList = pDAO.findAll();
        pieces = FXCollections.observableArrayList(piecesList);
        showTools.setItems(pieces);
    }



    @Override
    public void onClose(Object output) {

    }

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
                    String email = Session.getInstance().getUserLogged().getEmail();
                    WorkersDAO w = new WorkersDAO();
                    Workers worker = w.findByEmailAll(email);


                    System.out.println( fhDAO.findByIDWorker(worker));

                    System.out.println(axu);

                    System.out.println("Pieza seleccionada: " + pieceSeleccionada.getName());

                    System.out.println("------------------------------------------------------------");
                    System.out.println(fhDAO.findAll());
                }
            }
        });

    }


}
