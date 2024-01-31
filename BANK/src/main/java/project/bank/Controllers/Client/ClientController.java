package project.bank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import project.bank.Model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    public BorderPane client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getNewModel().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case "Home" -> client_parent.setCenter(Model.getNewModel().getViewFactory().getHomeView());
                case "Deposit" -> client_parent.setCenter(Model.getNewModel().getViewFactory().getDepositView());
                case "Withdraw" -> client_parent.setCenter(Model.getNewModel().getViewFactory().getWithdrawView());
                case "Transfer" -> client_parent.setCenter(Model.getNewModel().getViewFactory().getTransferView());
                case "Transactions" -> client_parent.setCenter(Model.getNewModel().getViewFactory().getTransactionsView());
                case "Profile" -> client_parent.setCenter(Model.getNewModel().getViewFactory().getProfileView());
            }
        });
    }
}
