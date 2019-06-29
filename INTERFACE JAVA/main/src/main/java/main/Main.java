package main;

import model.Model;
import view.View;

public abstract class Main {

    public static void main(final String[] args) {
        final Model model = new Model();
        final View view = new View(model);
    }
}
