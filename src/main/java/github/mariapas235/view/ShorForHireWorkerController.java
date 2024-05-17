package github.mariapas235.view;

import github.mariapas235.model.dao.PiecesDAO;
import github.mariapas235.model.dao.WorkersDAO;
import github.mariapas235.model.entity.ForHire;
import github.mariapas235.model.entity.Session;
import github.mariapas235.model.entity.Workers;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShorForHireWorkerController extends Controller implements Initializable {
    @FXML
    TableView showForHire;
    @FXML
    TableColumn <ForHire,String> showNamePiece;
    @FXML
    TableColumn <ForHire,String> showTake;
    @FXML
    TableColumn <ForHire,String> showBack;

    @Override
    public void onOpen(Object input) throws IOException {
        PiecesDAO.ForHireDAO fhDAO = new PiecesDAO.ForHireDAO();
        WorkersDAO wDAO = new WorkersDAO();
        String email= Session.getInstance().getUserLogged().getEmail();
        Workers worker2=  wDAO.findByEmailAll(email);
        ObservableList<ForHire> forHireObservableList = FXCollections.observableArrayList(fhDAO.findAllByIDWorker(worker2));
        showForHire.setItems(forHireObservableList);
    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showForHire.setEditable(true);
        showNamePiece.setCellValueFactory(ForHire ->
                new SimpleStringProperty(ForHire.getValue().getPieces().getName()));
        showTake.setCellValueFactory(ForHire ->
                new SimpleStringProperty(ForHire.getValue().getTake().toString()));
        showBack.setCellValueFactory(ForHire ->
                new SimpleStringProperty(ForHire.getValue().getBack().toString()));

    }

}
