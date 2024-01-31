// Importing my packages
package project.bank.Controllers.Admin;

// Importing my Classes
import project.bank.Model.Model;

// Importing java classes
import java.net.URL;
import java.util.ResourceBundle;

// Importing javafx classes
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class AdminController implements Initializable {
    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Create a listener for the (getAdminSelectedMenuItem) method
        // The purpose of putting this listener is to change the output of the item in the middle of the admin page as soon as the admin menu buttons are clicked.
        Model.getNewModel().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case "Create" -> admin_parent.setCenter(Model.getNewModel().getViewFactory().getAdminCreateView());
                case "Delete" -> admin_parent.setCenter(Model.getNewModel().getViewFactory().getAdminDeleteView());
                case "Lottery" -> admin_parent.setCenter(Model.getNewModel().getViewFactory().getAdminLotteryView());
                case "ListEmployees" -> admin_parent.setCenter(Model.getNewModel().getViewFactory().getAdminListEmployeesView());
                case "Profile" -> admin_parent.setCenter(Model.getNewModel().getViewFactory().getAdminProfileView());
            }
        });
    }
}
