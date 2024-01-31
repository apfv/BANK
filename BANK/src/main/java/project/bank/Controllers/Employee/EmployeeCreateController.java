// Importing my packages
package project.bank.Controllers.Employee;

// Importing my Classes
import project.bank.Model.Model;
import project.bank.Roles.Client;

// Importing javafx classes
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.concurrent.ThreadLocalRandom;

public class EmployeeCreateController {
    public TextField FirstNameField;
    public TextField LastNameField;
    public TextField PhoneNumberField;
    public TextField AddressField;
    public TextField AmountOfMoneyField;
    public TextField AccountNumberField;
    public TextField PasswordField;
    public Button CreateButton;

    public void PressCreateButton() {
        // Check that the required fields are not empty
        if (FirstNameField.getText().equals("") || LastNameField.getText().equals("") || PhoneNumberField.getText().equals("") || AddressField.getText().equals("") || AmountOfMoneyField.getText().equals("")) {
            // Giving WARNING to users when all or some fields are not filled
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("BANK");
            alert.setContentText("Complete all the filed 😐");
            alert.showAndWait();
        } else {
            try {
                if (Double.parseDouble(AmountOfMoneyField.getText()) > 0.0) {

                    AccountNumberField.setText("@" + String.valueOf(FirstNameField.getText().charAt(0)).toLowerCase() + String.valueOf(LastNameField.getText()).toUpperCase() + Model.getNewModel().getDatabase().uniqueNumberForCreateClient());

                    int number2 = ThreadLocalRandom.current().nextInt(1000000, 1000000000);
                    PasswordField.setText("" + number2 + "");

                    // Creating an object from the employee class to send the data taken from the user to the database,
                    // to store them in the database as a new bank employee.
                    Client client = new Client();

                    // Setting the data taken from the user with the properties of the clients class
                    client.setFirstName(FirstNameField.getText());
                    client.setLastName(LastNameField.getText());
                    client.setPhoneNumber(PhoneNumberField.getText());
                    client.setAddress(AddressField.getText());
                    client.setCurrentLoanAccount(AmountOfMoneyField.getText());
                    client.setAccountNumber(AccountNumberField.getText());
                    client.setPassword(PasswordField.getText());

                    // Sending the object created from the client class to the database to store them in the database as a new client
                    if (Model.getNewModel().getDatabase().createClient(client)) {
                        // Giving an INFORMATION message to the user if saving a new client in the bank database is successful
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("BANK");
                        alert.setContentText("Employee added successfully 😍");
                        alert.showAndWait();
                    } else {
                        // Giving an ERROR message to the user if there is a problem saving a new client in the bank database
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("BANK");
                        alert.setContentText("The employee was not added 😔");
                        alert.showAndWait();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("BANK");
                    alert.setContentText("Do not enter a negative number !!! 😠");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("BANK");
                alert.setContentText("This is not a number !!! 😠");
                alert.showAndWait();
            }
        }
    }
}
