package project.bank.Controllers.Client;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import project.bank.Model.Model;

public class ClientMenuController {
    public Button HomeButton;
    public Button DepositButton;
    public Button WithdrawButton;
    public Button TransferButton;
    public Button TransactionsButton;
    public Button ProfileButton;
    public Button LogoutButton;

    public void PressHomeButton() {
        Model.getNewModel().getViewFactory().getClientSelectedMenuItem().set("Home");
    }

    public void PressDepositButton() {
        Model.getNewModel().getViewFactory().getClientSelectedMenuItem().set("Deposit");
    }

    public void PressWithdrawButton() {
        Model.getNewModel().getViewFactory().getClientSelectedMenuItem().set("Withdraw");
    }

    public void PressTransferButton() {
        Model.getNewModel().getViewFactory().getClientSelectedMenuItem().set("Transfer");
    }

    public void PressTransactionsButton() {
        Model.getNewModel().getViewFactory().getClientSelectedMenuItem().set("Transactions");
    }

    public void PressProfileButton() {
        Model.getNewModel().getViewFactory().getClientSelectedMenuItem().set("Profile");
    }

    public void PressLogoutButton() {
        Stage stage = (Stage) LogoutButton.getScene().getWindow();
        stage.close();

        Model.getNewModel().getViewFactory().showLoginWindow();
    }
}
