package github.mariapas235.view;

import github.mariapas235.App;
import github.mariapas235.model.dao.WorkersDAO;
import github.mariapas235.model.entity.Boss;
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


    /**
     * Collects data from the form to create a new Workers object.
     * @return a Workers object with the collected data.
     * @throws IOException if an I/O error occurs during data collection.
     */
    @FXML
    public Workers CollectDataWorker() throws IOException {
        Workers w= null;
        Object selectedPositionString = comboBoxPosition.getSelectionModel().getSelectedItem();
        Position selectedPosition = Position.valueOf(selectedPositionString.toString().toUpperCase());
        String email = TextFieldEmail.getText();
        String name = TextFieldName.getText();
        String password = TextFieldPassword.getText();

        if (!Person.validarContrasena(password)) {
            AppController.alertError("La contraseña no cumple con los requisitos citados abajo, por favor cree una nueva");

        }else {
            String passHas = Person.HashearContraseña(password);
            w = new Workers(name, email, passHas, selectedPosition);
        }


        return w;
    }

    /**
     * Inserts a new worker into the database after validating the collected data.
     * @throws IOException if an I/O error occurs during the insertion process.
     */
    @FXML
    public void InsertRegistrerWorker() throws IOException {
        Workers w = CollectDataWorker();
        WorkersDAO wDAO = new WorkersDAO();

        if (w.getName() == null || w.getName().isEmpty()) {
            AppController.alertWarning("El campo nombre se encuentra vacío, por favor rellénelo");
        } else if (w.getEmail() == null || w.getEmail().isEmpty()) {
            AppController.alertWarning("El campo email se encuentra vacío, por favor rellénelo");
        } else if (w.getPassword() == null || w.getPassword().isEmpty()) {
            AppController.alertWarning("El campo contraseña se encuentra vacío, por favor rellénelo");
        } else if (w.getPosition()==null) {
            AppController.alertWarning("El campo posición se encuentra vacío, por favor rellénelo");
        } else if (Person.validarCorreo(w.getEmail())) {
                if (wDAO.findByEmailAll(w.getEmail())!=null){
                    Person.HashearContraseña(w.getPassword());
                    wDAO.insert(w);
                    App.currentController.changeScene(Scenes.LOGINWORKER, null);
                }else {
                    AppController.alertWarning("Su email ya se encuentra registrado en nuestra base de datos");
                }

        } else {
            AppController.alertError("El email no es correcto, escríbalo correctamente");
        }


    }

    /**
     * Method to handle actions when the scene is opened.
     * @param input the input object for the scene.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void onOpen(Object input) throws IOException {

    }

    /**
     * Method to handle actions when the scene is closed.
     * @param output the output object for the scene.
     */
    @Override
    public void onClose(Object output) {

    }

    /**
     * Method to initialize the controller.
     * @param url the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxPosition.setItems(FXCollections.observableArrayList("Soldador", "Peon", "Electricista", "Transportista"));

    }
}
