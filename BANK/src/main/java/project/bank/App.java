// Importing my packages
package project.bank;

// Importing my Classes
import project.bank.Model.Model;

// Importing javafx classes
import javafx.stage.Stage;
import javafx.application.Application;

public class App extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Model.getNewModel().getViewFactory().showLoginWindow();
    }
}

// ((Object)(10.2)).getClass().getSimpleName().equals("Double")
