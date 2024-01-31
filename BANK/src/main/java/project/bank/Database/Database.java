package project.bank.Database;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import project.bank.Model.Model;
import project.bank.Roles.Client;
import project.bank.Roles.Employee;

import java.sql.*;


public class Database {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public Database() {
        this.account = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Bank.db");

        } catch (Exception e) {
            System.exit(0);
        }
    }

    private final StringProperty account;

    public StringProperty getAccount() {
        return account;
    }

    private final StringProperty password;

    public StringProperty getPassword() {
        return password;
    }


    // ====================[ Search For Login ]====================


    // Search for login admin
    public boolean adminSearchForLogin(String AccountNumber, String Password) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT * FROM Admins ;" );

            while (resultSet.next()) {
                if (resultSet.getString("AccountNumber").equals(AccountNumber) && resultSet.getString("Password").equals(Password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Search for login employee
    public boolean employeeSearchForLogin(String AccountNumber, String Password) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT * FROM Employees;" );

            while (resultSet.next()) {
                if (resultSet.getString("AccountNumber").equals(AccountNumber) && resultSet.getString("Password").equals(Password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    // Search for login client
    public boolean clientSearchForLogin(String AccountNumber, String Password) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT * FROM Clients;" );

            while (resultSet.next()) {
                if (resultSet.getString("AccountNumber").equals(AccountNumber) && resultSet.getString("Password").equals(Password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ====================[ Search Employee For Delete And Transfer ]====================

    public boolean searchEmployeeForDeleteAndTransfer(String AccountNumber) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT * FROM Employees;" );

            while (resultSet.next()) {
                if (resultSet.getString("AccountNumber").equals(AccountNumber)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ====================[ Search Client For Delete And Transfer ]====================

    public boolean searchClientForDeleteAndTransfer(String AccountNumber) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT * FROM Clients;" );

            while (resultSet.next()) {
                if (resultSet.getString("AccountNumber").equals(AccountNumber)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ====================[ Search ]====================

    // Search employee
    public ResultSet searchEmployee(String AccountNumber, String Password) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT * FROM Employees WHERE AccountNumber='" + AccountNumber + "' AND Password='" + Password + "';" );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    // Search client
    public ResultSet searchClient(String AccountNumber) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT * FROM Clients WHERE AccountNumber='" + AccountNumber + "';" );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    // ====================[ Create And Delete ]====================

    // Create employee
    public boolean createEmployee(Employee employee) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Employees (FirstName, LastName, AccountNumber, Password) VALUES ('" + employee.getFirstName() + "', '" + employee.getLastName() + "', '" + employee.getAccountNumber() + "', '" + employee.getPassword() + "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete employee
    public boolean deleteEmployee(String AccountNumber) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Employees WHERE AccountNumber = '"+ AccountNumber +"';");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Create client
    public boolean createClient(Client client) {
        double number = 0.0;

        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Clients (FirstName," +
                    " LastName," +
                    " PhoneNumber," +
                    " Address," +
                    " AccountNumber," +
                    " Password," +
                    " CurrentLoanAccount," +
                    " SavingsLoanAccount," +
                    " LongTermInvestmentAccount," +
                    " ShortTermInvestmentAccount," +
                    " DateTime) VALUES ('" + client.getFirstName() + "', '" +
                                             client.getLastName() + "', '" +
                                             client.getPhoneNumber() + "', '" +
                                             client.getAddress() + "', '" +
                                             client.getAccountNumber() + "', '" +
                                             client.getPassword() + "', '" +
                                             client.getCurrentLoanAccount() + "', '" +
                                             number + "', '" +
                                             number + "', '" +
                                             number + "', '" +
                                             Model.getNewModel().getViewFactory().getDateTime() + "');");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete client
    public boolean deleteClient(String AccountNumber) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Clients WHERE AccountNumber = '"+ AccountNumber +"';");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // ====================[ Updating the balance of client accounts ]====================

    public boolean updateTheBalanceOfClientAccount(String AccountNumber, String AccountType, String nowVal, String newVal) {
        double money = Double.parseDouble(nowVal) + Double.parseDouble(newVal); // + or - => newVal

        try {
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE Clients SET  " + AccountType + "Account='" + money + "' WHERE AccountNumber='"+ AccountNumber +"';");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ====================[ Transactions Table ]====================

    public ResultSet transactionTable() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT * FROM Transactions ;" );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public void addTransactionToTransactionTable(String FromThisClient, String ToThisClient, String AmountOfMoney, String DateTime) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Transactions (FromThisClient, ToThisClient, AmountOfMoney, DateTime) VALUES ('" + FromThisClient + "', '" + ToThisClient + "', '" + AmountOfMoney + "', '" + DateTime + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ====================[ List Employees ]====================

    public ResultSet listEmployees() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT * FROM Employees ;" );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    // ====================[ List Clients ]====================

    public ResultSet listClients() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT * FROM Clients;" );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    // unique number

    public String uniqueNumberForCreateEmployee() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT COUNT(*) FROM Employees ;" );
            int number = Integer.parseInt(String.valueOf(resultSet.getInt(1))) + 1;
            return String.valueOf(number);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public String uniqueNumberForCreateClient() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT COUNT(*) FROM Clients ;" );
            int number = Integer.parseInt(String.valueOf(resultSet.getInt(1))) + 1;
            return String.valueOf(number);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
