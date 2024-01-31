// Importing my packages
package project.bank.Controllers.Admin;

// Importing my Classes
import project.bank.Model.Model;

// Importing java classes
import java.net.URL;
import java.util.ResourceBundle;

// Importing javafx classes
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class AdminProfileController implements Initializable {
    public Label AccountNumberLabel;
    public Label PasswordLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Setting the user's Account Number and Password when displaying the user's profile page
        AccountNumberLabel.setText(Model.getNewModel().getDatabase().getAccount().get());
        PasswordLabel.setText(Model.getNewModel().getDatabase().getPassword().get());
    }
}
