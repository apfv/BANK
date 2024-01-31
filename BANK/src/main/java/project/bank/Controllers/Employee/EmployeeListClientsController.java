// Importing my packages
package project.bank.Controllers.Employee;

// Importing my Classes
import project.bank.Model.Model;

// Importing java classes
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

// Importing java classes
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeListClientsController implements Initializable {
    public ListView<String> ListClientsListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Get all client information from the clients table of the bank database
        ResultSet resultSet = Model.getNewModel().getDatabase().listClients();

        ListClientsListView.getItems().clear();

        int i = 1;

        String FirstName;
        String LastName;
        String PhoneNumber;
        String Address;
        String AccountNumber;
        String Password;
        String CurrentLoanAccount;
        String SavingsLoanAccount;
        String LongTermInvestmentAccount;
        String ShortTermInvestmentAccount;
        String DateTime;

        // A while loop to get information one by one from the bank database clients table
        while (true) {
            // A condition to end the work of the while loop when all the rows of the clients table from the bank database are finished
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Getting all the information of each of the columns of the clients table from the bank database to set them with the relevant variables
            try {
                FirstName = resultSet.getString("FirstName");
                LastName = resultSet.getString("LastName");
                PhoneNumber = resultSet.getString("PhoneNumber");
                Address = resultSet.getString("Address");
                AccountNumber = resultSet.getString("AccountNumber");
                Password = resultSet.getString("Password");
                CurrentLoanAccount = resultSet.getString("CurrentLoanAccount");
                SavingsLoanAccount = resultSet.getString("SavingsLoanAccount");
                LongTermInvestmentAccount = resultSet.getString("LongTermInvestmentAccount");
                ShortTermInvestmentAccount = resultSet.getString("ShortTermInvestmentAccount");
                DateTime = resultSet.getString("DateTime");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Adding the information taken from the clients table of the bank database to each of the ListView rows of the List clients page
            ListClientsListView.getItems().add("# " + i + " \n" +
                                               "FirstName : " + FirstName + " \n" +
                                               "LastName : " + LastName + " \n" +
                                               "PhoneNumber : " + PhoneNumber + " \n" +
                                               "Address : " + Address + " \n" +
                                               "AccountNumber : " + AccountNumber + " \n" +
                                               "Password : " + Password + " \n" +
                                               "CurrentLoanAccount : " + CurrentLoanAccount + " \n" +
                                               "SavingsLoanAccount : " + SavingsLoanAccount + " \n" +
                                               "LongTermInvestmentAccount : " + LongTermInvestmentAccount + " \n" +
                                               "ShortTermInvestmentAccount : " + ShortTermInvestmentAccount + " \n" +
                                               "DateTime : " + DateTime + " \n" +
                                               " ");
            i++;
        }
    }
}
