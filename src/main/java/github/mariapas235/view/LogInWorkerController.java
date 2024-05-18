package github.mariapas235.view;

import github.mariapas235.App;
import github.mariapas235.model.dao.WorkersDAO;
import github.mariapas235.model.entity.Person;
import github.mariapas235.model.entity.Session;
import github.mariapas235.model.entity.Workers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInWorkerController extends Controller implements Initializable {

    @FXML
    TextField TextFieldEmail;
    @FXML
    TextField TextFieldPassword;
    @FXML
    Button ButtonPrincipalPage;

    /**
     * Collects login data from the worker.
     * @return a Workers object containing the email and hashed password.
     */
    @FXML
    public Workers collectDataWorkerLogIn(){
        Workers w = new Workers();
        String email = TextFieldEmail.getText();
        String password = TextFieldPassword.getText();
        w.setEmail(email);
        String passHash = Person.HashearContraseña(password);
        w.setPassword(passHash);
        return w;
    }

    /**
     * Handles the worker login process.
     * @throws IOException if an I/O error occurs.
     */
    public void LogInWorker() throws IOException {
        Workers w = collectDataWorkerLogIn();
        WorkersDAO wDAO = new WorkersDAO();
        w=wDAO.findByEmailAll(w.getEmail());

        if ( verifyCredentials(w)){
            w= wDAO.findByEmailAll(w.getEmail());
            Session.getInstance().logIn(w);
            System.out.println(w);
            System.out.println(Session.getInstance().getUserLogged().toString());
            App.currentController.changeScene(Scenes.PRINCIPALPAGEWORKER,null);
        }else {
            AppController.alertError("Los datos introducidos no son válidos");
        }
    }


    /**
     * Verifies the worker's credentials.
     * @param workers the Workers object containing the login credentials.
     * @return true if the credentials are valid, false otherwise.
     */
    public boolean verifyCredentials(Workers workers){
        boolean aux = false;
        WorkersDAO wDAO = new WorkersDAO();
        Workers w = wDAO.verify(workers.getEmail());

        if (w.getEmail()!=null && w.getEmail().equals(workers.getEmail())&&w.getPassword()!=null && w.getPassword().equals(workers.getPassword())){
            aux = true;
        }
        return aux;

    }


    /**
     * Called when the controller is opened.
     * @param input the input data (not used in this method).
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void onOpen(Object input) throws IOException {

    }

    /**
     * Called when the controller is closed.
     * @param output the output data (not used in this method).
     */
    @Override
    public void onClose(Object output) {

    }


    /**
     * Initializes the controller.
     * @param url the location relative to the root of the FXML document being loaded.
     * @param resourceBundle the resources that may be needed to initialize the controller (not used in this method).
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
