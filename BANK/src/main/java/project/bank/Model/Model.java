package project.bank.Model;

import project.bank.Database.Database;
import project.bank.View.ViewFactory;

public class Model {

    private static Model model;
    private final ViewFactory viewFactory;
    private final Database database;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.database = new Database();
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public Database getDatabase() {
        return database;
    }

    public static Model getNewModel() {
        if (model == null) {
            model = new Model();
        }

        return model;
    }
}
