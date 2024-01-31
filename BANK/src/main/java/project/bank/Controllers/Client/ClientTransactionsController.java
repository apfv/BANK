package project.bank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import project.bank.Model.Model;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientTransactionsController implements Initializable {

    public ListView<String> TransactionsListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TransactionsListView.getItems().clear();

        String AccountNumber = Model.getNewModel().getDatabase().getAccount().get();

        String FromThisClient;
        String ToThisClient;
        String AmountOfMoney;
        String DateTime;

        ResultSet resultSet = Model.getNewModel().getDatabase().transactionTable();

        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                FromThisClient = resultSet.getString("FromThisClient");
                ToThisClient = resultSet.getString("ToThisClient");
                AmountOfMoney = resultSet.getString("AmountOfMoney");
                DateTime = resultSet.getString("DateTime");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (FromThisClient.equals(AccountNumber) || ToThisClient.equals(AccountNumber)) {
                TransactionsListView.getItems().addAll(" " + "\n" + "$ " + Model.getNewModel().getViewFactory().getNumberFormat().format(Double.parseDouble(AmountOfMoney)) + " ,   " + FromThisClient + "   >>>   " + ToThisClient + "\n" + "Transaction date and time : " + DateTime + "\n" +" ");
            }
        }
    }
}
