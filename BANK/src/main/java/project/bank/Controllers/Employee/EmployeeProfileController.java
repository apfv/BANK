// Importing my packages
package project.bank.Controllers.Employee;

// Importing my Classes
import project.bank.Model.Model;

// Importing java classes
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

// Importing javafx classes
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class EmployeeProfileController implements Initializable {
    public Label FirstNameLabel;
    public Label LastNameLabel;
    public Label AccountNumberLabel;
    public Label PasswordLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Setting the user's Account Number and Password when displaying the user's profile page
        AccountNumberLabel.setText(Model.getNewModel().getDatabase().getAccount().get());
        PasswordLabel.setText(Model.getNewModel().getDatabase().getPassword().get());

        // Receive the information of the entered employee by sending the account number and password to the (searchEmployee) method in the bank database class.
        ResultSet resultSet = Model.getNewModel().getDatabase().searchEmployee(AccountNumberLabel.getText(), PasswordLabel.getText());

        // Setting the employee's information taken from the bank's database to display it on the employee's profile page
        try {
            if (resultSet.isBeforeFirst()) {
                FirstNameLabel.setText(resultSet.getString("FirstName"));
                LastNameLabel.setText(resultSet.getString("LastName"));
                AccountNumberLabel.setText(resultSet.getString("AccountNumber"));
                PasswordLabel.setText(resultSet.getString("Password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
