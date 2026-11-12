package com.egzamin.controller;

import com.egzamin.model.DatabaseManager;
import com.egzamin.view.MainFrame;

import java.sql.SQLException;

public class AppController {
    private final MainFrame view;
    private final DatabaseManager model;

    public AppController(MainFrame view, DatabaseManager model) {
        this.view = view;
        this.model = model;
        this.view.addDodajListener(e -> dodajPracownika());
        odswiez();
    }

    private void dodajPracownika() {
        String imie = view.getImie();
        String nazwisko = view.getNazwisko();
        String stanowisko = view.getStanowisko();

        if (imie.isEmpty() || nazwisko.isEmpty() || stanowisko.isEmpty()) {
            view.pokazBlad("Wszystkie pola są wymagane.");
            return;
        }
        if (!imie.matches("\\p{L}+") || !nazwisko.matches("\\p{L}+(-\\p{L}+)?")) {
            view.pokazBlad("Imię i nazwisko mogą zawierać tylko litery.");
            return;
        }

        try {
            model.dodaj(imie, nazwisko, stanowisko);
            view.wyczyscPola();
            odswiez();
            view.pokazInfo("Dodano pracownika.");
        } catch (SQLException ex) {
            view.pokazBlad("Błąd bazy danych: " + ex.getMessage());
        }
    }

    private void odswiez() {
        try {
            view.setPracownicy(model.pobierzWszystkich());
        } catch (SQLException ex) {
            view.pokazBlad("Błąd bazy danych: " + ex.getMessage());
        }
    }
}
