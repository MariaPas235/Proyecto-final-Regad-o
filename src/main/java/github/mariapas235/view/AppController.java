package github.mariapas235.view;

import github.mariapas235.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.lang.annotation.Inherited;
import java.net.URL;
import java.util.ResourceBundle;



public class AppController extends Controller implements Initializable {
    @FXML
    private BorderPane borderPane;
    private Controller centerController;
    @Override
    public void onOpen(Object input) throws IOException {
        changeScene(Scenes.WELCOME,null);
    }
    public void changeScene(Scenes scene,Object data) throws IOException{
        View view = loadFXML(scene);
        borderPane.setCenter(view.scene);
        this.centerController= view.controller;
        this.centerController.onOpen(data);
    }

    public static void alertErrorEmail(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Email incorrecto, por favor introduzcalo bien. ");
        alert.setWidth(300);
        alert.setHeight(300);
        alert.showAndWait();

    }
    public static void alertErrorPassword(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("La contraseña no cumple con los requisitos citados abajo, por favor cree una nueva");
        alert.setWidth(300);
        alert.setHeight(300);
        alert.showAndWait();
    }
    public static void alertEmptyName(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("El campo 'Nombre' se encuentra vacío, porfavor rellenelo");
        alert.setWidth(300);
        alert.setHeight(300);
        alert.showAndWait();
    }

    public static void alertEmptyEmail(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("El campo 'Email' se encuentra vacío, porfavor rellenelo");
        alert.setWidth(300);
        alert.setHeight(300);
        alert.showAndWait();
    }
    public static void alertEmptyPassword(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("El campo 'Contraseña' se encuentra vacío, porfavor rellenelo");
        alert.setWidth(300);
        alert.setHeight(300);
        alert.showAndWait();
    }

    public static void alertEmptyPosition(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("El campo 'Position' se encuentra vacío, porfavor seleccione una opción");
        alert.setWidth(300);
        alert.setHeight(300);
        alert.showAndWait();
    }
    public static void notLogIn(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("mira perdona que es que nooo es asiin ");
        alert.setWidth(300);
        alert.setHeight(300);
        alert.showAndWait();
    }

    public static void EmailRepeat(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("El correo introducido ya se encuentra registrado en nuestra base de datos, porfavor use otro ");
        alert.setWidth(300);
        alert.setHeight(300);
        alert.showAndWait();
    }





    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public static View loadFXML(Scenes scene )throws IOException{
        String url = scene.getUrl();
        System.out.println(url);
        FXMLLoader loader = new FXMLLoader(App.class.getResource(url));
        Parent p = loader.load();
        Controller c = loader.getController();
        View view = new View();
        view.scene=p;
        view.controller=c;
        return view;

    }
}
