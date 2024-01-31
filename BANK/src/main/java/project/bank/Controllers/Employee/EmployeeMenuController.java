// Importing my packages
package project.bank.Controllers.Employee;

// Importing my Classes
import project.bank.Model.Model;

// Importing javafx classes
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class EmployeeMenuController {
    public Button CreateButton;
    public Button DeleteButton;
    public Button ListClientsButton;
    public Button ProfileButton;
    public Button LogoutButton;

    // As soon as the button (CreateButton) is clicked, this function is called
    public void PressCreateButton() {
        // Changing the parameter (EmployeeSelectedMenuItem) by changing the method (getEmployeeSelectedMenuItem) causes the (Listener) in the class (EmployeeController) to set a new page for the central item of the page according to the type of the new value.
        Model.getNewModel().getViewFactory().getEmployeeSelectedMenuItem().set("Create");
    }

    // As soon as the button (DeleteButton) is clicked, this function is called
    public void PressDeleteButton() {
        // Changing the parameter (EmployeeSelectedMenuItem) by changing the method (getEmployeeSelectedMenuItem) causes the (Listener) in the class (EmployeeController) to set a new page for the central item of the page according to the type of the new value.
        Model.getNewModel().getViewFactory().getEmployeeSelectedMenuItem().set("Delete");
    }

    // As soon as the button (ListClientsButton) is clicked, this function is called
    public void PressListClientsButton() {
        // Changing the parameter (EmployeeSelectedMenuItem) by changing the method (getEmployeeSelectedMenuItem) causes the (Listener) in the class (EmployeeController) to set a new page for the central item of the page according to the type of the new value.
        Model.getNewModel().getViewFactory().getEmployeeSelectedMenuItem().set("ListClients");
    }

    // As soon as the button (ProfileButton) is clicked, this function is called
    public void PressProfileButton() {
        // Changing the parameter (EmployeeSelectedMenuItem) by changing the method (getEmployeeSelectedMenuItem) causes the (Listener) in the class (EmployeeController) to set a new page for the central item of the page according to the type of the new value.
        Model.getNewModel().getViewFactory().getEmployeeSelectedMenuItem().set("Profile");
    }

    // As soon as the button (LogoutButton) is clicked, this function is called
    public void PressLogoutButton() {
        // Close the window that is currently open
        Stage stage = (Stage) LogoutButton.getScene().getWindow();
        stage.close();

        // Open the login window
        Model.getNewModel().getViewFactory().showLoginWindow();
    }
}
