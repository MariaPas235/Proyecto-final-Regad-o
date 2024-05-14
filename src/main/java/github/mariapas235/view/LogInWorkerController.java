package github.mariapas235.view;

import github.mariapas235.App;
import github.mariapas235.model.dao.WorkersDAO;
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

    @FXML
    public Workers collectDataWorkerLogIn(){
        Workers w = new Workers();
        String email = TextFieldEmail.getText();
        String password = TextFieldPassword.getText();
        w.setEmail(email);
        w.setPassword(password);
        return w;
    }

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
            AppController.notLogIn();
        }
    }



    public boolean verifyCredentials(Workers workers){
        boolean aux = false;
        WorkersDAO wDAO = new WorkersDAO();
        Workers w = wDAO.verify(workers.getEmail());

        if (w.getEmail()!=null && w.getEmail().equals(workers.getEmail())&&w.getPassword()!=null && w.getPassword().equals(workers.getPassword())){
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
