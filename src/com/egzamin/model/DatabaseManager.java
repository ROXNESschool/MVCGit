package com.egzamin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/firma?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Pracownik> pobierzWszystkich() throws SQLException {
        List<Pracownik> lista = new ArrayList<>();
        String sql = "SELECT id, imie, nazwisko, stanowisko FROM pracownicy ORDER BY id";
        try (Connection c = connect();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Pracownik(
                        rs.getInt("id"),
                        rs.getString("imie"),
                        rs.getString("nazwisko"),
                        rs.getString("stanowisko")));
            }
        }
        return lista;
    }

    public void dodaj(String imie, String nazwisko, String stanowisko) throws SQLException {
        String sql = "INSERT INTO pracownicy (imie, nazwisko, stanowisko) VALUES (?, ?, ?)";
        try (Connection c = connect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, imie);
            ps.setString(2, nazwisko);
            ps.setString(3, stanowisko);
            ps.executeUpdate();
        }
    }
}
