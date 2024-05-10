package github.mariapas235.view;

import github.mariapas235.model.entity.Category;
import github.mariapas235.model.entity.Position;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InsertToolFormController extends Controller implements Initializable {

    @FXML
    TextField textFieldName;
    @FXML
    TextField textFieldPrize;
    @FXML
    TextField textFieldQuantity;
    @FXML
    TextField textFieldGarageNumber;
    @FXML
    ImageView returnToButtons;
    @FXML
    Button buttonInsertTool;
    @FXML
    ComboBox<String> comboBoxCategory;
    PrincipalPageBoss2Controller parent;
    public void CollectDataTool(){
        Object selectedCategoryString = comboBoxCategory.getSelectionModel().getSelectedItem();
        Category selectedCategory = Category.valueOf(selectedCategoryString.toString().toUpperCase());
        String name = textFieldName.getText();
        String prize = textFieldPrize.getText();
        String quantity = textFieldQuantity.getText();
        String GarageNumber = textFieldGarageNumber.getText();


    }
    @FXML
    public void ReturnToButtons(){
        parent.changeScene(Scenes.BUTTONSINSERTTOOLSGARAGES);
    }



    @Override
    public void onOpen(Object input) throws IOException {
        this.parent = (PrincipalPageBoss2Controller) input;
    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxCategory.setItems(FXCollections.observableArrayList("Herramientas eléctricas", "Herramientas manuales", "Ferretería"));
    }
}
