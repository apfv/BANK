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

public class ClientTransferController implements Initializable {
    public ChoiceBox<ClientAccountType> SelectAccountBox;
    public Button TransferButton;
    public TextField AccountNumberField;
    public TextField TransferAmountField;

    public void PressTransferButton() {
        if (AccountNumberField.getText().equals("") || TransferAmountField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("BANK");
            alert.setContentText("Complete all the filed 😐");
            alert.showAndWait();
        } else {
            try {
                if (Double.parseDouble(TransferAmountField.getText()) > 0.0) {
                    if (Model.getNewModel().getDatabase().searchClientForDeleteAndTransfer(AccountNumberField.getText())) {
                        String AccountNumber = Model.getNewModel().getDatabase().getAccount().get();

                        ResultSet resultSet1 = Model.getNewModel().getDatabase().searchClient(AccountNumber);
                        ResultSet resultSet2 = Model.getNewModel().getDatabase().searchClient(AccountNumberField.getText());


                        String nowVal1 = "";
                        String nowVal2 = "";

                        String AccountType = String.valueOf(SelectAccountBox.getValue());

                        boolean temp1 = false;
                        boolean temp2 = false;

                        try {

                            nowVal2 = resultSet2.getString("CurrentLoanAccount");

                            switch (AccountType) {
                                case "CurrentLoan" -> nowVal1 = resultSet1.getString("CurrentLoanAccount");
                                case "SavingsLoan" -> nowVal1 = resultSet1.getString("SavingsLoanAccount");
                                case "LongTermInvestment" -> nowVal1 = resultSet1.getString("LongTermInvestmentAccount");
                                case "ShortTermInvestment" -> nowVal1 = resultSet1.getString("ShortTermInvestmentAccount");
                            }

                            if (Double.parseDouble(TransferAmountField.getText()) <= Double.parseDouble(nowVal1)) {
                                temp1 = Model.getNewModel().getDatabase().updateTheBalanceOfClientAccount(AccountNumber, AccountType, nowVal1, "-" + TransferAmountField.getText());
                                temp2 = Model.getNewModel().getDatabase().updateTheBalanceOfClientAccount(AccountNumberField.getText(), "CurrentLoan", nowVal2, TransferAmountField.getText());
                            } else {
                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("BANK");
                                alert.setContentText("Insufficient inventory 😕");
                                alert.showAndWait();
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                        if (temp1 && temp2) {

                            Model.getNewModel().getDatabase().addTransactionToTransactionTable(AccountNumber, AccountNumberField.getText(), TransferAmountField.getText(), Model.getNewModel().getViewFactory().getDateTime());

                            Model.getNewModel().getViewFactory().clientWithdrawController.Alert(true);
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("BANK");
                        alert.setContentText("Client has not been into database bank !!!");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SelectAccountBox.setItems(FXCollections.observableArrayList(ClientAccountType.CurrentLoan, ClientAccountType.SavingsLoan, ClientAccountType.LongTermInvestment, ClientAccountType.ShortTermInvestment));
        SelectAccountBox.setValue(Model.getNewModel().getViewFactory().getClientAccountType());
        SelectAccountBox.valueProperty().addListener(observable -> Model.getNewModel().getViewFactory().setClientAccountType(SelectAccountBox.getValue()));
    }
}
