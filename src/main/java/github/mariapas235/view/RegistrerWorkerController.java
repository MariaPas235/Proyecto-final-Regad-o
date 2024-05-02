package github.mariapas235.view;

import github.mariapas235.App;
import github.mariapas235.model.dao.WorkersDAO;
import github.mariapas235.model.entity.Person;
import github.mariapas235.model.entity.Position;
import github.mariapas235.model.entity.Workers;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrerWorkerController extends Controller implements Initializable {
    @FXML
    TextField TextFieldName;
    @FXML
    TextField TextFieldEmail;
    @FXML
    TextField TextFieldPassword;
    @FXML
    ComboBox<String> comboBoxPosition;

    @FXML
    Button ButtonRegistrerWorker;


    @FXML
    public Workers CollectDataWorker() throws IOException {
        Object selectedPositionString = comboBoxPosition.getSelectionModel().getSelectedItem();
        Position selectedPosition = Position.valueOf(selectedPositionString.toString().toUpperCase()) ;
        String email = TextFieldEmail.getText();
        if (Person.validarCorreo(email)){
            email = TextFieldEmail.getText();
        }else {
            email="puto";
        }
        Workers w = new Workers(TextFieldName.getText(),email,TextFieldPassword.getText(), selectedPosition);
        return w;
    }
    @FXML
    public void InsertRegistrerWorker() throws IOException {
        Workers w = CollectDataWorker();
        WorkersDAO wDAO = new WorkersDAO();
        wDAO.insert(w);
        App.currentController.changeScene(Scenes.LOGINWORKER, null);

    }
   
    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxPosition.setItems(FXCollections.observableArrayList("Soldador","Peon","Electricista","Transportista"));

    }
}
