package github.mariapas235.view;

import github.mariapas235.App;
import github.mariapas235.model.dao.BossDAO;
import github.mariapas235.model.dao.WorkersDAO;
import github.mariapas235.model.entity.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrerBossController extends Controller implements Initializable {

    @FXML
    TextField TextFieldNameBoss;
    @FXML
    TextField TextFieldEmailBoss;
    @FXML
    TextField TextFieldPasswordBoss;
    @FXML
    Button ButtonRegistrerBoss;


    /**
     * Collects data from the input fields to create a Boss object.
     * @return a Boss object with the data from the input fields.
     */
    @FXML
    public Boss CollectDataBoss() {
        String email = TextFieldEmailBoss.getText();
        String password = TextFieldPasswordBoss.getText();
        Boss b = null;
        if (!Person.validarContrasena(password)) {
            AppController.alertError("La contraseña no cumple con los requisitos citados abajo, por favor cree una nueva");


        }else {
            String passHas = Person.HashearContraseña(password);
            b = new Boss(TextFieldNameBoss.getText(), email, passHas);
        }

        return b;

    }

    /**
     * Handles the registration and insertion of a new Boss.
     * @throws IOException if an I/O error occurs.
     */
    @FXML
    public void InsertRegistrerBoss() throws IOException {

        Boss b = CollectDataBoss();
        BossDAO bDAO = new BossDAO();

        if (b.getName() == null || b.getName().isEmpty()) {
            AppController.alertWarning("El campo nombre se encuentra vacío, por favor rellénelo");
        } else if (b.getEmail() == null || b.getEmail().isEmpty()) {
            AppController.alertWarning("El campo email se encuentra vacío, por favor rellénelo");
        } else if (b.getPassword() == null || b.getPassword().isEmpty()) {
            AppController.alertWarning("El campo contraseña se encuentra vacío, por favor rellénelo");
        } else if (Person.validarCorreo(b.getEmail())) {
                bDAO.insert(b);
                b.setIDBoss( bDAO.findByEmailAll(b.getEmail()).getIDBoss());
                Session.getInstance().logIn(b);
                System.out.println(Session.getInstance().getUserLogged());
                App.currentController.changeScene(Scenes.LOGINBOSS, null);
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

    }
}
