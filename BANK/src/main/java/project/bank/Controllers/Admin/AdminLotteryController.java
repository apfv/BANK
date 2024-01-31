// Importing my packages
package project.bank.Controllers.Admin;

// Importing my Classes
import project.bank.Model.Model;

// Importing java classes
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// Importing javafx classes
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class AdminLotteryController {
    public Label WinnerAccountNumber;
    public Button StartLotteryButton;

    private final ArrayList<String> listAccountNumber = new ArrayList<>();
    private final ArrayList<String> listNowVal = new ArrayList<>();

    // As soon as the button (StartLotteryButton) is clicked, this function is called
    public void PressStartLotteryButton() {
        ResultSet resultSet = Model.getNewModel().getDatabase().listClients();

        String accountNumber;
        String nowVal;

        int number = 0;

        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                accountNumber = resultSet.getString("AccountNumber");
                nowVal = resultSet.getString("CurrentLoanAccount");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            listAccountNumber.add(accountNumber);
            listNowVal.add(nowVal);

            number++;
        }

        int winningNumber = ThreadLocalRandom.current().nextInt(0, number);

        for (int i = 0; i < listAccountNumber.size(); i++) {
            if (i == winningNumber) {
                String newVal = String.valueOf(Double.parseDouble(listNowVal.get(i)) * 0.1);

                if (Model.getNewModel().getDatabase().updateTheBalanceOfClientAccount(listAccountNumber.get(i), "CurrentLoan", listNowVal.get(i), newVal)) {
                    Model.getNewModel().getDatabase().addTransactionToTransactionTable(" [Lottery] ", listAccountNumber.get(i), newVal, Model.getNewModel().getViewFactory().getDateTime());
                    WinnerAccountNumber.setText(listAccountNumber.get(i));
                }
            }
        }
    }
}
