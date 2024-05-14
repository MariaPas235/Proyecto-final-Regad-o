package github.mariapas235.view;

import github.mariapas235.App;
import github.mariapas235.model.dao.WorkersDAO;
import github.mariapas235.model.entity.Person;
import github.mariapas235.model.entity.Position;
import github.mariapas235.model.entity.Workers;
import javafx.collections.FXCollections;
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
        Position selectedPosition = Position.valueOf(selectedPositionString.toString().toUpperCase());
        String email = TextFieldEmail.getText();
        String password = TextFieldPassword.getText();
        String name = TextFieldName.getText();
        Workers w = new Workers(name, email, password, selectedPosition);
        return w;
    }

    @FXML
    public void InsertRegistrerWorker() throws IOException {
        Workers w = CollectDataWorker();
        WorkersDAO wDAO = new WorkersDAO();

        if (w.getName() == null || w.getName().isEmpty()) {
            AppController.alertEmptyName();
        } else if (w.getEmail() == null || w.getEmail().isEmpty()) {
            AppController.alertEmptyEmail();
        } else if (w.getPassword() == null || w.getPassword().isEmpty()) {
            AppController.alertEmptyPassword();
        } else if (w.getPosition()==null) {
            AppController.alertEmptyPosition();
    } else if (Person.validarCorreo(w.getEmail())) {
            if (Person.validarContrasena(w.getPassword())) {
                if (wDAO.findByEmailAll(w.getEmail())!=null){
                    wDAO.insert(w);
                    App.currentController.changeScene(Scenes.LOGINWORKER, null);
                }else {
                    AppController.EmailRepeat();
                }

            } else {
                AppController.alertErrorPassword();
            }


        } else {
            AppController.alertErrorEmail();
        }


    }

    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxPosition.setItems(FXCollections.observableArrayList("Soldador", "Peon", "Electricista", "Transportista"));

    }
}
