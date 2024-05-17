package github.mariapas235.view;

import github.mariapas235.App;
import github.mariapas235.model.dao.BossDAO;
import github.mariapas235.model.dao.WorkersDAO;
import github.mariapas235.model.entity.Boss;
import github.mariapas235.model.entity.Person;
import github.mariapas235.model.entity.Session;
import github.mariapas235.model.entity.Workers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInBossController extends Controller implements Initializable {
    @FXML
    TextField TextFieldEmail;
    @FXML
    TextField TextFieldPassword;
    @FXML
    Button ButtonPrincipalPage;


    @FXML
    public Boss collectDataBossLogIn(){
        Boss b = new Boss();
        String email = TextFieldEmail.getText();
        String password = TextFieldPassword.getText();


        String PassHash = Person.HashearContraseña(password);

        b.setEmail(email);
        b.setPassword(PassHash);
        return b;
    }

    public void LogInBoss() throws IOException {
        Boss b = collectDataBossLogIn();
        BossDAO bDAO = new BossDAO();

        if ( verifyCredentials(b)){
            b= bDAO.findByEmailAll(b.getEmail());

            Session.getInstance().logIn(b);
            System.out.println( );
            System.out.println(Session.getInstance().getUserLogged().toString());
            App.currentController.changeScene(Scenes.PINCIPALPAGEBOSS, null);
        }else {
            AppController.notLogIn();
        }
    }



    public boolean verifyCredentials(Boss boss){
        boolean aux = false;
        BossDAO bDAO = new BossDAO();

        Boss b = bDAO.verify(boss.getEmail());

        if (b.getEmail()!=null && b.getEmail().equals(boss.getEmail())&&b.getPassword()!=null && b.getPassword().equals(boss.getPassword())){
            aux = true;
        }
        return aux;

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
