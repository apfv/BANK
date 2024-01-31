// Importing my packages
package project.bank.Controllers.Admin;

// Importing my Classes
import project.bank.Model.Model;

// Importing java classes
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

// Importing java classes
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class AdminListEmployeesController implements Initializable {
    public ListView<String> ListEmployeesListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Get all employee information from the employees table of the bank database
        ResultSet resultSet = Model.getNewModel().getDatabase().listEmployees();

        ListEmployeesListView.getItems().clear();

        int i = 1;

        String FirstName;
        String LastName;
        String AccountNumber;
        String Password;

        // A while loop to get information one by one from the bank database employees table
        while (true) {
            // A condition to end the work of the while loop when all the rows of the employees table from the bank database are finished
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Getting all the information of each of the columns of the employees table from the bank database to set them with the relevant variables
            try {
                FirstName = resultSet.getString("FirstName");
                LastName = resultSet.getString("LastName");
                AccountNumber = resultSet.getString("AccountNumber");
                Password = resultSet.getString("Password");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Adding the information taken from the employees table of the bank database to each of the ListView rows of the List Employees page
            ListEmployeesListView.getItems().add("# " + i + " \n" +
                                                 "FirstName : " + FirstName + " \n" +
                                                 "LastName : " + LastName + " \n" +
                                                 "AccountNumber : " + AccountNumber + " \n" +
                                                 "Password : " + Password + " \n" +
                                                 " ");

            i++;
        }
    }
}
