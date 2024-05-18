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


    /**
     * Collects data entered by the user from the email and password fields for boss login.
     * @return Boss object containing the collected email and password
     */
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

    /**
     * Attempts to log in the boss by verifying the entered credentials.
     * If the credentials are valid, logs in the boss and switches to the principal page.
     * If the credentials are invalid, displays an error message.
     * @throws IOException if an I/O error occurs
     */
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
            AppController.alertError("Los datos introducidos no son válidos");
        }
    }



    /**
     * Verifies the entered credentials against the stored boss data in the database.
     * @param boss the Boss object containing the entered email and password
     * @return true if the credentials are valid, false otherwise
     */
    public boolean verifyCredentials(Boss boss){
        boolean aux = false;
        BossDAO bDAO = new BossDAO();

        Boss b = bDAO.verify(boss.getEmail());

        if (b.getEmail()!=null && b.getEmail().equals(boss.getEmail())&&b.getPassword()!=null && b.getPassword().equals(boss.getPassword())){
            aux = true;
        }
        return aux;

    }

    /**
     * Called when the controller is opened.
     * Currently, no action is performed when the controller is opened.
     * @param input the input data (not used in this method)
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void onOpen(Object input) throws IOException {

    }

    /**
     * Called when the controller is closed.
     * Currently, no action is performed when the controller is closed.
     * @param output the output data (not used in this method)
     */
    @Override
    public void onClose(Object output) {

    }

    /**
     * Initializes the controller.
     * Currently, no initialization is performed.
     * @param url the location relative to the root of the FXML document being loaded
     * @param resourceBundle the resources that may be needed to initialize the controller (not used in this method)
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
