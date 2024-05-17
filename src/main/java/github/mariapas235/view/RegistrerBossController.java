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


    @FXML
    public Boss CollectDataBoss() {
        String email = TextFieldEmailBoss.getText();
        String password = TextFieldPasswordBoss.getText();
        Boss b = null;
        if (!Person.validarContrasena(password)) {
            AppController.alertErrorPassword();


        }else {
            String passHas = Person.HashearContraseña(password);
            b = new Boss(TextFieldNameBoss.getText(), email, passHas);
        }

        return b;

    }

    @FXML
    public void InsertRegistrerBoss() throws IOException {

        Boss b = CollectDataBoss();
        BossDAO bDAO = new BossDAO();

        if (b.getName() == null || b.getName().isEmpty()) {
            AppController.alertEmptyName();
        } else if (b.getEmail() == null || b.getEmail().isEmpty()) {
            AppController.alertEmptyEmail();
        } else if (b.getPassword() == null || b.getPassword().isEmpty()) {
            AppController.alertEmptyPassword();
        } else if (Person.validarCorreo(b.getEmail())) {
                bDAO.insert(b);
                b.setIDBoss( bDAO.findByEmailAll(b.getEmail()).getIDBoss());
                Session.getInstance().logIn(b);
                System.out.println(Session.getInstance().getUserLogged());
                App.currentController.changeScene(Scenes.LOGINBOSS, null);
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

    }
}
