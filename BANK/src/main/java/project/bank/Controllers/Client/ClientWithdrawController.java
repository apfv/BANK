package project.bank.Controllers.Client;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import project.bank.Model.Model;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientWithdrawController implements Initializable {
    public ChoiceBox<ClientAccountType> SelectAccountBox;
    public Button WithdrawButton;
    public TextField WithdrawAmountField;

    public void PressWithdrawButton() {
        if (WithdrawAmountField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("BANK");
            alert.setContentText("Complete all the filed 😐");
            alert.showAndWait();
        } else {
            try {
                if (Double.parseDouble(WithdrawAmountField.getText()) > 0.0) {
                    String AccountNumber = Model.getNewModel().getDatabase().getAccount().get();

                    ResultSet resultSet = Model.getNewModel().getDatabase().searchClient(AccountNumber);

                    String nowVal = "";

                    String AccountType = String.valueOf(SelectAccountBox.getValue());

                    boolean temp = false;

                    try {
                        switch (AccountType) {
                            case "CurrentLoan" -> nowVal = resultSet.getString("CurrentLoanAccount");
                            case "SavingsLoan" -> nowVal = resultSet.getString("SavingsLoanAccount");
                            case "LongTermInvestment" -> nowVal = resultSet.getString("LongTermInvestmentAccount");
                            case "ShortTermInvestment" -> nowVal = resultSet.getString("ShortTermInvestmentAccount");
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    if (Double.parseDouble(WithdrawAmountField.getText()) <= Double.parseDouble(nowVal)) {
                        temp = Model.getNewModel().getDatabase().updateTheBalanceOfClientAccount(AccountNumber, AccountType, nowVal, "-" + WithdrawAmountField.getText());

                        Model.getNewModel().getDatabase().addTransactionToTransactionTable(AccountNumber, " [W] ", WithdrawAmountField.getText(), Model.getNewModel().getViewFactory().getDateTime());

                        Alert(temp);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("BANK");
                        alert.setContentText("Insufficient inventory 😕");
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

    public void Alert(boolean temp) {
        Alert alert;
        if (temp) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("BANK");
            alert.setContentText("Money has been successfully deposited into your checking account 😍 $$");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SelectAccountBox.setItems(FXCollections.observableArrayList(ClientAccountType.CurrentLoan, ClientAccountType.SavingsLoan, ClientAccountType.LongTermInvestment, ClientAccountType.ShortTermInvestment));
        SelectAccountBox.setValue(Model.getNewModel().getViewFactory().getClientAccountType());
        SelectAccountBox.valueProperty().addListener(observable -> Model.getNewModel().getViewFactory().setClientAccountType(SelectAccountBox.getValue()));
    }
}
