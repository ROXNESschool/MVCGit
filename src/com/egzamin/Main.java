package com.egzamin;

import com.egzamin.controller.AppController;
import com.egzamin.model.DatabaseManager;
import com.egzamin.view.MainFrame;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame view = new MainFrame();
            DatabaseManager model = new DatabaseManager();
            new AppController(view, model);
            view.setVisible(true);
        });
    }
}
