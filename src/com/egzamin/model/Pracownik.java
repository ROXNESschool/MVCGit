package com.egzamin.model;

public class Pracownik {
    private final int id;
    private final String imie;
    private final String nazwisko;
    private final String stanowisko;

    public Pracownik(int id, String imie, String nazwisko, String stanowisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }
}
