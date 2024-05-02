package github.mariapas235.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

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
