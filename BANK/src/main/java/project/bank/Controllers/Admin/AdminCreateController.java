// Importing my packages
package project.bank.Controllers.Admin;

// Importing my Classes
import project.bank.Model.Model;
import project.bank.Roles.Employee;

// Importing javafx classes
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.concurrent.ThreadLocalRandom;

public class AdminCreateController {
    public TextField FirstNameField;
    public TextField LastNameField;
    public TextField AccountNumberField;
    public TextField PasswordField;
    public Button CreateButton;

    public void PressCreateButton() {
        // Check that the required fields are not empty
        if (FirstNameField.getText().equals("") || LastNameField.getText().equals("")) {
            // Giving WARNING to users when all or some fields are not filled
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("BANK");
            alert.setContentText("Complete all the filed 😐");
            alert.showAndWait();
        } else {
            AccountNumberField.setText("@" + String.valueOf(FirstNameField.getText().charAt(0)).toLowerCase() + String.valueOf(LastNameField.getText()).toUpperCase() + Model.getNewModel().getDatabase().uniqueNumberForCreateEmployee());

            int number2 = ThreadLocalRandom.current().nextInt(1000000, 1000000000);
            PasswordField.setText("" + number2 + "");

            // Creating an object from the employee class to send the data taken from the user to the database,
            // to store them in the database as a new bank employee.
            Employee employee = new Employee();

            // Setting the data taken from the user with the properties of the employee class
            employee.setAccountNumber(AccountNumberField.getText());
            employee.setPassword(PasswordField.getText());
            employee.setFirstName(FirstNameField.getText());
            employee.setLastName(LastNameField.getText());

            // Sending the object created from the employee class to the database to store them in the database as a new employee
            if (Model.getNewModel().getDatabase().createEmployee(employee)) {
                // Giving an INFORMATION message to the user if saving a new employee in the bank database is successful
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("BANK");
                alert.setContentText("Employee added successfully 😍");
                alert.showAndWait();
            } else {
                // Giving an ERROR message to the user if there is a problem saving a new employee in the bank database
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("BANK");
                alert.setContentText("The employee was not added 😔");
                alert.showAndWait();
            }
        }
    }
}
