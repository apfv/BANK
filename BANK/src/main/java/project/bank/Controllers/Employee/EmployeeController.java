// Importing my packages
package project.bank.Controllers.Employee;

// Importing my Classes
import project.bank.Model.Model;

// Importing java classes
import java.net.URL;
import java.util.ResourceBundle;

// Importing javafx classes
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class EmployeeController implements Initializable {
    public BorderPane employee_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Create a listener for the (getEmployeeSelectedMenuItem) method
        // The purpose of putting this listener is to change the output of the item in the middle of the admin page as soon as the admin menu buttons are clicked.
        Model.getNewModel().getViewFactory().getEmployeeSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case "Create" -> employee_parent.setCenter(Model.getNewModel().getViewFactory().getEmployeeCreateView());
                case "Delete" -> employee_parent.setCenter(Model.getNewModel().getViewFactory().getEmployeeDeleteView());
                case "ListClients" -> employee_parent.setCenter(Model.getNewModel().getViewFactory().getListClientsView());
                case "Profile" -> employee_parent.setCenter(Model.getNewModel().getViewFactory().getEmployeeProfileView());
            }
        });
    }
}
