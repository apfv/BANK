package project.bank.Roles;

public class Employee extends Admin implements Human {

    private String accountNumber;
    private String password;
    private String firstName;
    private String lastName;

    public Employee(String accountNumber, String password, String firstName, String lastName) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee() {
        this("", "", "", "");
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
}
