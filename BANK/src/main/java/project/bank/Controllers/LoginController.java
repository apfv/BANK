package project.bank.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import project.bank.Model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> AccountSelector;
    public TextField UsernameField;
    public TextField PasswordField;
    public Button LoginButton;

    public void PressLoginButton() {
        if (UsernameField.getText().equals("") || PasswordField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("BANK");
            alert.setContentText("Complete all the filed 😐");
            alert.showAndWait();
        } else {
            Stage stage = (Stage) LoginButton.getScene().getWindow();
            stage.close();

            switch (Model.getNewModel().getViewFactory().getLoginAccountType()) {
                case Admin:
                    if (Model.getNewModel().getDatabase().adminSearchForLogin(UsernameField.getText(), PasswordField.getText())) {

                        Model.getNewModel().getViewFactory().showAdminWindow();

                        Model.getNewModel().getDatabase().getAccount().set(UsernameField.getText());
                        Model.getNewModel().getDatabase().getPassword().set(PasswordField.getText());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("BANK");
                        alert.setContentText("The Username Or Password Is Incorrect 😈");
                        alert.showAndWait();

                        Model.getNewModel().getViewFactory().showLoginWindow();
                    }
                    break;
                case Employee:
                    if (Model.getNewModel().getDatabase().employeeSearchForLogin(UsernameField.getText(), PasswordField.getText())) {

                        Model.getNewModel().getViewFactory().showEmployeeWindow();

                        Model.getNewModel().getDatabase().getAccount().set(UsernameField.getText());
                        Model.getNewModel().getDatabase().getPassword().set(PasswordField.getText());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("BANK");
                        alert.setContentText("The Username Or Password Is Incorrect 😈");
                        alert.showAndWait();

                        Model.getNewModel().getViewFactory().showLoginWindow();
                    }
                    break;
                case Client:
                    if (Model.getNewModel().getDatabase().clientSearchForLogin(UsernameField.getText(), PasswordField.getText())) {

                        Model.getNewModel().getDatabase().getAccount().set(UsernameField.getText());
                        Model.getNewModel().getDatabase().getPassword().set(PasswordField.getText());

                        Model.getNewModel().getViewFactory().showClientWindow();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("BANK");
                        alert.setContentText("The Username Or Password Is Incorrect 😈");
                        alert.showAndWait();

                        Model.getNewModel().getViewFactory().showLoginWindow();
                    }
                    break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AccountSelector.setItems(FXCollections.observableArrayList(AccountType.Admin, AccountType.Employee, AccountType.Client));
        AccountSelector.setValue(Model.getNewModel().getViewFactory().getLoginAccountType());
        AccountSelector.valueProperty().addListener(observable -> Model.getNewModel().getViewFactory().setLoginAccountType(AccountSelector.getValue()));
    }
}


