// Importing my packages
package project.bank.Controllers.Admin;

// Importing my Classes
import project.bank.Model.Model;

// Importing javafx classes
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class AdminMenuController {
    public Button CreateButton;
    public Button DeleteButton;
    public Button LotteryButton;
    public Button ListEmployeesButton;
    public Button ProfileButton;
    public Button LogoutButton;

    // As soon as the button (CreateButton) is clicked, this function is called
    public void PressCreateButton() {
        // Changing the parameter (AdminSelectedMenuItem) by changing the method (getAdminSelectedMenuItem) causes the (Listener) in the class (AdminController) to set a new page for the central item of the page according to the type of the new value.
        Model.getNewModel().getViewFactory().getAdminSelectedMenuItem().set("Create");
    }

    // As soon as the button (DeleteButton) is clicked, this function is called
    public void PressDeleteButton() {
        // Changing the parameter (AdminSelectedMenuItem) by changing the method (getAdminSelectedMenuItem) causes the (Listener) in the class (AdminController) to set a new page for the central item of the page according to the type of the new value.
        Model.getNewModel().getViewFactory().getAdminSelectedMenuItem().set("Delete");
    }

    // As soon as the button (LotteryButton) is clicked, this function is called
    public void PressLotteryButton() {
        // Changing the parameter (AdminSelectedMenuItem) by changing the method (getAdminSelectedMenuItem) causes the (Listener) in the class (AdminController) to set a new page for the central item of the page according to the type of the new value.
        Model.getNewModel().getViewFactory().getAdminSelectedMenuItem().set("Lottery");
    }

    // As soon as the button (ListEmployeesButton) is clicked, this function is called
    public void PressListEmployeesButton() {
        // Changing the parameter (AdminSelectedMenuItem) by changing the method (getAdminSelectedMenuItem) causes the (Listener) in the class (AdminController) to set a new page for the central item of the page according to the type of the new value.
        Model.getNewModel().getViewFactory().getAdminSelectedMenuItem().set("ListEmployees");
    }

    // As soon as the button (ProfileButton) is clicked, this function is called
    public void PressProfileButton() {
        // // Changing the parameter (AdminSelectedMenuItem) by changing the method (getAdminSelectedMenuItem) causes the (Listener) in the class (AdminController) to set a new page for the central item of the page according to the type of the new value.
        Model.getNewModel().getViewFactory().getAdminSelectedMenuItem().set("Profile");
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
