module project.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
//    requires sqlite.jdbc;

    opens project.bank to javafx.fxml;
    exports project.bank;
    exports project.bank.View;
    exports project.bank.Model;
    exports project.bank.Roles;
    exports project.bank.Database;
    exports project.bank.Controllers;
    exports project.bank.Controllers.Admin;
    exports project.bank.Controllers.Client;
    exports project.bank.Controllers.Employee;
}
