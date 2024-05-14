package github.mariapas235.view;

import github.mariapas235.App;
import github.mariapas235.model.dao.BossDAO;
import github.mariapas235.model.dao.GarageDAO;
import github.mariapas235.model.dao.PiecesDAO;
import github.mariapas235.model.entity.*;
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

    public Pieces CollectDataTool() {
        String selectedCategoryString = comboBoxCategory.getSelectionModel().getSelectedItem();
        Category selectedCategory = Category.valueOf(selectedCategoryString.toString().toUpperCase());
        String name = textFieldName.getText();
        String prize = textFieldPrize.getText();
        String quantity = textFieldQuantity.getText();
        String GarageNumber = textFieldGarageNumber.getText();
        int quantityInt = Integer.parseInt(quantity);
        float prizeFloat = Float.parseFloat(prize);
        int garageNumberInt = Integer.parseInt(GarageNumber);


        //buscar en la base de datos un garage que exista con ese GarageNumber, si es true, crea la pieza y la guarda en el array de ese garage
        GarageDAO g = new GarageDAO();
        Garage garageDataBase = g.findById(garageNumberInt);

        String email = Session.getInstance().getUserLogged().getEmail();

        BossDAO b = new BossDAO();

        Boss boss = b.findByEmailAll(email);
        Pieces p = null;


        if (garageDataBase.getGarageNumber() == garageNumberInt) {
            //busco piezaq por nombre y me la traigo, comparo esa pieza con la nueva y si la categoria y el precio son iguales, suma cantidad4

            PiecesDAO pDAO = new PiecesDAO();
            Pieces pieceDatabase = pDAO.findByName(name);
            if (pieceDatabase == null) {
                p = new Pieces(name, selectedCategory, prizeFloat, quantityInt, garageDataBase, boss);
                pDAO.insert(p);
                AppController.alertEmptyEmail();
            } else if (pieceDatabase.getName().equals(name) && pieceDatabase.getCategory().equals(selectedCategory) && pieceDatabase.getPrize() == prizeFloat) {
                pieceDatabase.setQuantity(pieceDatabase.getQuantity() + quantityInt);
                pDAO.update(pieceDatabase);
                p = pieceDatabase;
            }

            }
            return p;
        }


        @FXML
        public void ReturnToButtons () {
            parent.changeScene(Scenes.BUTTONSINSERTTOOLSGARAGES);
        }


        @Override
        public void onOpen (Object input) throws IOException {
            this.parent = (PrincipalPageBoss2Controller) input;
        }

        @Override
        public void onClose (Object output){

        }

        @Override
        public void initialize (URL url, ResourceBundle resourceBundle){
            comboBoxCategory.setItems(FXCollections.observableArrayList("HERRAMIENTAS_ELECTRICAS", "HERRAMIENTAS_MANUALES", "FERRETERIA"));
        }
    }
