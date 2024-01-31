// Importing my packages
package project.bank.Controllers.Admin;

// Importing my Classes
import project.bank.Model.Model;

// Importing javafx classes
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminDeleteController {
    public TextField EmployeeAccountNumberField;
    public Button DeleteButton;

    // This function is called as soon as the (DeleteButton) is clicked
    public void PressDeleteButton() {
        // Checking that the (EmployeeAccountNumberField) is empty
        if (EmployeeAccountNumberField.getText().equals("")) {
            // Giving a WARNING message to the user to fill in all the fields
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("BANK");
            alert.setContentText("Complete all the filed 😐");
            alert.showAndWait();
        } else {
            if (Model.getNewModel().getDatabase().searchEmployeeForDeleteAndTransfer(EmployeeAccountNumberField.getText())) {
                // Checking the success of sending the data taken from the user to the database to target an employee from the bank database
                if (Model.getNewModel().getDatabase().deleteEmployee(EmployeeAccountNumberField.getText())) {
                    // Giving the user the message of successful removal of an employee from the bank database
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("BANK");
                    alert.setContentText("The employee was successfully deleted 😍");
                    alert.showAndWait();
                } else {
                    // Giving a message to the user about the failure to delete an employee from the bank database
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("BANK");
                    alert.setContentText("The employee was not removed 😔");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("BANK");
                alert.setContentText("Client has not been into database bank !!!");
                alert.showAndWait();
            }
        }
    }
}
