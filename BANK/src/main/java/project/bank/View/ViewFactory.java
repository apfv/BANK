package project.bank.View;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.bank.Controllers.AccountType;

import project.bank.Controllers.Admin.AdminController;
import project.bank.Controllers.Client.*;
import project.bank.Controllers.Employee.EmployeeController;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ViewFactory {

    public ViewFactory() {
        this.LoginAccountType = AccountType.Admin;
        this.ClientAccountType = project.bank.Controllers.Client.ClientAccountType.CurrentLoan;
        this.adminSelectedMenuItem = new SimpleStringProperty("");
        this.employeeSelectedMenuItem = new SimpleStringProperty("");
        this.clientSelectedMenuItem = new SimpleStringProperty("");

    }

    private final NumberFormat numberFormat = NumberFormat.getNumberInstance();

    public NumberFormat getNumberFormat() {
        numberFormat.setGroupingUsed(true);
        numberFormat.setMaximumFractionDigits(2);

        return numberFormat;
    }

    // ----------[ Date and Time ]----------

    private final Date date = new Date(System.currentTimeMillis());
    private final SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
    private final SimpleDateFormat formatterDate = new SimpleDateFormat("yy/MM/dd");
    public String getDateTime() {
        return "20" + formatterDate.format(date) + "  " + formatterTime.format(Calendar.getInstance().getTime());
    }

    // ----------[ Login ]----------

    private AccountType LoginAccountType;

    public void setLoginAccountType(AccountType LoginAccountType) {
        this.LoginAccountType = LoginAccountType;
    }

    public AccountType getLoginAccountType() {
        return LoginAccountType;
    }

    public void showLoginWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(fxmlLoader);
    }


    // ----------[ Admin ]----------

    private final StringProperty adminSelectedMenuItem;

    public StringProperty getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }

    private AnchorPane AdminCreateView;

    public AnchorPane getAdminCreateView() {
        try {
            AdminCreateView = new FXMLLoader(getClass().getResource("/Fxml/Admin/AdminCreate.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return AdminCreateView;
    }

    private AnchorPane AdminDeleteView;

    public AnchorPane getAdminDeleteView() {
        try {
            AdminDeleteView = new FXMLLoader(getClass().getResource("/Fxml/Admin/AdminDelete.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return AdminDeleteView;
    }

    private AnchorPane AdminLotteryView;

    public AnchorPane getAdminLotteryView() {
        try {
            AdminLotteryView = new FXMLLoader(getClass().getResource("/Fxml/Admin/AdminLottery.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return AdminLotteryView;
    }

    private AnchorPane AdminListEmployeesView;

    public AnchorPane getAdminListEmployeesView() {
        try {
            AdminListEmployeesView = new FXMLLoader(getClass().getResource("/Fxml/Admin/AdminListEmployees.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return AdminListEmployeesView;
    }

    private AnchorPane AdminProfileView;

    public AnchorPane getAdminProfileView() {
        try {
            AdminProfileView = new FXMLLoader(getClass().getResource("/Fxml/Admin/AdminProfile.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return AdminProfileView;
    }

    public AdminController adminController = new AdminController();

    public void showAdminWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        fxmlLoader.setController(adminController);
        createStage(fxmlLoader);
    }

    // ----------[ Employee ]----------

    public EmployeeController employeeController = new EmployeeController();

    private final StringProperty employeeSelectedMenuItem;

    public StringProperty getEmployeeSelectedMenuItem() {
        return employeeSelectedMenuItem;
    }

    private AnchorPane EmployeeCreateView;

    public AnchorPane getEmployeeCreateView() {
        try {
            EmployeeCreateView = new FXMLLoader(getClass().getResource("/Fxml/Employee/EmployeeCreate.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return EmployeeCreateView;
    }

    private AnchorPane EmployeeDeleteView;

    public AnchorPane getEmployeeDeleteView() {
        try {
            EmployeeDeleteView = new FXMLLoader(getClass().getResource("/Fxml/Employee/EmployeeDelete.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return EmployeeDeleteView;
    }

    private AnchorPane ListClientsView;

    public AnchorPane getListClientsView() {
        try {
            ListClientsView = new FXMLLoader(getClass().getResource("/Fxml/Employee/EmployeeListClients.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListClientsView;
    }

    private AnchorPane EmployeeProfileView;

    public AnchorPane getEmployeeProfileView() {
        try {
            EmployeeProfileView = new FXMLLoader(getClass().getResource("/Fxml/Employee/EmployeeProfile.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return EmployeeProfileView;
    }

    public void showEmployeeWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Employee/Employee.fxml"));
        fxmlLoader.setController(employeeController);
        createStage(fxmlLoader);
    }


    // ----------[ Client ]----------

    public ClientController clientController = new ClientController();
    public ClientWithdrawController clientWithdrawController = new ClientWithdrawController();

    private final StringProperty clientSelectedMenuItem;

    public StringProperty getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    private ClientAccountType ClientAccountType;

    public void setClientAccountType(ClientAccountType clientAccountType) {
        ClientAccountType = clientAccountType;
    }

    public ClientAccountType getClientAccountType() {
        return ClientAccountType;
    }

    private AnchorPane HomeView;

    public AnchorPane getHomeView() {
        try {
            HomeView = new FXMLLoader(getClass().getResource("/Fxml/Client/ClientHome.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return HomeView;
    }

    private AnchorPane DepositView;

    public AnchorPane getDepositView() {
        try {
            DepositView = new FXMLLoader(getClass().getResource("/Fxml/Client/ClientDeposit.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  DepositView;
    }

    private AnchorPane WithdrawView;

    public AnchorPane getWithdrawView() {
        try {
            WithdrawView = new FXMLLoader(getClass().getResource("/Fxml/Client/ClientWithdraw.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return WithdrawView;
    }

    private AnchorPane TransferView;

    public AnchorPane getTransferView() {
        try {
            TransferView = new FXMLLoader(getClass().getResource("/Fxml/Client/ClientTransfer.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return TransferView;
    }


    private AnchorPane TransactionsView;

    public AnchorPane getTransactionsView() {
        try {
            TransactionsView = new FXMLLoader(getClass().getResource("/Fxml/Client/ClientTransactions.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return TransactionsView;
    }

    private AnchorPane ProfileView;

    public AnchorPane getProfileView() {
        try {
            ProfileView = new FXMLLoader(getClass().getResource("/Fxml/Client/ClientProfile.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ProfileView;
    }

    public void showClientWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
        fxmlLoader.setController(clientController);
        createStage(fxmlLoader);
    }

    private void createStage(FXMLLoader fxmlLoader) {
        Scene scene = null;

        try {
            scene = new Scene(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BANK");
        stage.getIcons().add(new Image("file:src\\main\\resources\\Image\\logo.png"));
        stage.setResizable(false);
        stage.show();
    }
}
