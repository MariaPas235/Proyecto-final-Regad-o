package github.mariapas235.view;

import github.mariapas235.App;
import github.mariapas235.model.dao.BossDAO;
import github.mariapas235.model.dao.WorkersDAO;
import github.mariapas235.model.entity.Boss;
import github.mariapas235.model.entity.Person;
import github.mariapas235.model.entity.Position;
import github.mariapas235.model.entity.Workers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        Boss b = new Boss(TextFieldNameBoss.getText(), email, TextFieldPasswordBoss.getText());
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
            if (Person.validarContrasena(b.getPassword())) {
                bDAO.insert(b);
                App.currentController.changeScene(Scenes.LOGINBOSS, null);
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

    }
}
