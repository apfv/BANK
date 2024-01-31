package project.bank.Roles;

public class Client extends Employee {

    private String accountNumber;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String currentLoanAccount;

    public Client(String accountNumber, String password, String firstName, String lastName, String phoneNumber, String address, String currentLoanAccount) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.currentLoanAccount = currentLoanAccount;
    }

    public Client() {
        this("", "", "", "", "", "", "");
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrentLoanAccount() {
        return currentLoanAccount;
    }

    public void setCurrentLoanAccount(String currentLoanAccount) {
        this.currentLoanAccount = currentLoanAccount;
    }
}
