package project.bank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import project.bank.Model.Model;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientProfileController implements Initializable {
    public Label FirstNameLabel;
    public Label LastNameLabel;
    public Label PhoneNumberLabel;
    public Label AddressLabel;
    public Label AccountNumberLabel;
    public Label PasswordLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AccountNumberLabel.setText(Model.getNewModel().getDatabase().getAccount().get());
        PasswordLabel.setText(Model.getNewModel().getDatabase().getPassword().get());

        ResultSet resultSet = Model.getNewModel().getDatabase().searchClient(AccountNumberLabel.getText());

        try {
            if (resultSet.isBeforeFirst()) {
                FirstNameLabel.setText(resultSet.getString("FirstName"));
                LastNameLabel.setText(resultSet.getString("LastName"));
                PhoneNumberLabel.setText(resultSet.getString("PhoneNumber"));
                AddressLabel.setText(resultSet.getString("Address"));
                AccountNumberLabel.setText(resultSet.getString("AccountNumber"));
                PasswordLabel.setText(resultSet.getString("Password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
