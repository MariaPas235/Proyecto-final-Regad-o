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


    /**
     * Collects data from the input fields to create a new Pieces object.
     * Checks if a piece with the same name, category, and prize exists in the database.
     * If not, inserts a new piece. If yes, updates the quantity of the existing piece.
     * @return the Pieces object created or updated
     */
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

        GarageDAO g = new GarageDAO();
        Garage garageDataBase = g.findById(garageNumberInt);

        String email = Session.getInstance().getUserLogged().getEmail();

        BossDAO b = new BossDAO();

        Boss boss = b.findByEmailAll(email);
        Pieces p = null;


        if (garageDataBase.getGarageNumber() == garageNumberInt) {


            PiecesDAO pDAO = new PiecesDAO();
            Pieces pieceDatabase = pDAO.findByName(name);
            if (pieceDatabase == null) {
                p = new Pieces(name, selectedCategory, prizeFloat, quantityInt, garageDataBase, boss);
                pDAO.insert(p);
                AppController.alertWarning("La nueva pieza ha sido insertada correctamente.");
            } else if (pieceDatabase.getName().equals(name) && pieceDatabase.getCategory().equals(selectedCategory) && pieceDatabase.getPrize() == prizeFloat) {
                pieceDatabase.setQuantity(pieceDatabase.getQuantity() + quantityInt);
                pDAO.update(pieceDatabase);
                p = pieceDatabase;
                AppController.alertWarning("Ya se ha encontrado una pieza igual en la base de datos, por tanto se ha incrementado la cantidad.");
            }

            }
            return p;
        }


    /**
     * Switches the scene to the buttons insert tools/garages scene in the parent controller.
     * Called when the return to buttons button is clicked in the UI.
     */
        @FXML
        public void ReturnToButtons () {
            parent.changeScene(Scenes.BUTTONSINSERTTOOLSGARAGES);
        }


    /**
     * Called when the controller is opened.
     * Initializes the reference to the parent controller.
     * @param input the parent controller passed as input
     * @throws IOException if an I/O error occurs
     */
        @Override
        public void onOpen (Object input) throws IOException {
            this.parent = (PrincipalPageBoss2Controller) input;
        }


    /**
     * Called when the controller is closed.
     * Currently, no action is performed when the controller is closed.
     * @param output the output data (not used in this method)
     */
        @Override
        public void onClose (Object output){

        }

    /**
     * Initializes the controller.
     * Sets the items in the combo box for selecting the category.
     * @param url the location relative to the root of the FXML document being loaded
     * @param resourceBundle the resources that may be needed to initialize the controller (not used in this method)
     */
        @Override
        public void initialize (URL url, ResourceBundle resourceBundle){
            comboBoxCategory.setItems(FXCollections.observableArrayList("HERRAMIENTAS_ELECTRICAS", "HERRAMIENTAS_MANUALES", "FERRETERIA"));
        }
    }
