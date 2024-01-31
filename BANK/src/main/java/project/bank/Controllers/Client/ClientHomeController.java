package project.bank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import project.bank.Model.Model;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientHomeController implements Initializable {
    public Label FirstNameLabel;
    public Label DateLabel;
    public Label IncomeLabel;
    public Label ExpensesLabel;
    public Label CurrentLoanLabel;
    public Label SavingsLoanLabel;
    public Label LongTermLabel;
    public Label ShortTermLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String AccountNumber = Model.getNewModel().getDatabase().getAccount().get();
//        String Password = Model.getNewModel().getDatabase().getPassword().get();

        ResultSet resultSet = Model.getNewModel().getDatabase().searchClient(AccountNumber);

        try {
            if (resultSet.isBeforeFirst()) {
                FirstNameLabel.setText("Hi, " + resultSet.getString("FirstName"));
                CurrentLoanLabel.setText(Model.getNewModel().getViewFactory().getNumberFormat().format(Double.parseDouble(resultSet.getString("CurrentLoanAccount"))));
                SavingsLoanLabel.setText(Model.getNewModel().getViewFactory().getNumberFormat().format(Double.parseDouble(resultSet.getString("SavingsLoanAccount"))));
                LongTermLabel.setText(Model.getNewModel().getViewFactory().getNumberFormat().format(Double.parseDouble(resultSet.getString("LongTermInvestmentAccount"))));
                ShortTermLabel.setText(Model.getNewModel().getViewFactory().getNumberFormat().format(Double.parseDouble(resultSet.getString("ShortTermInvestmentAccount"))));
                DateLabel.setText("Account creating date :  " + resultSet.getString("DateTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        double Income = 0;
        double Expenses = 0;

        String FromThisClient;
        String ToThisClient;
        String AmountOfMoney;

        ResultSet resultSetTransactions = Model.getNewModel().getDatabase().transactionTable();

        while (true) {
            try {
                if (!resultSetTransactions.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                FromThisClient = resultSetTransactions.getString("FromThisClient");
                ToThisClient = resultSetTransactions.getString("ToThisClient");
                AmountOfMoney = resultSetTransactions.getString("AmountOfMoney");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (FromThisClient.equals(AccountNumber)) {
                Expenses += Double.parseDouble(AmountOfMoney);
            }

            if (ToThisClient.equals(AccountNumber)) {
                Income += Double.parseDouble(AmountOfMoney);
            }
        }

        IncomeLabel.setText("+ $ " + Model.getNewModel().getViewFactory().getNumberFormat().format(Income));
        ExpensesLabel.setText("- $ " + Model.getNewModel().getViewFactory().getNumberFormat().format(Expenses));
    }
}
