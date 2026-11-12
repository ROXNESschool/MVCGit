package com.egzamin.view;

import com.egzamin.model.Pracownik;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {
    private final JTextField tfImie = new JTextField(10);
    private final JTextField tfNazwisko = new JTextField(10);
    private final JTextField tfStanowisko = new JTextField(10);
    private final JButton btnDodaj = new JButton("Dodaj");
    private final DefaultTableModel tableModel =
            new DefaultTableModel(new Object[]{"ID", "Imię", "Nazwisko", "Stanowisko"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

    public MainFrame() {
        super("Pracownicy");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT));
        form.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        form.add(new JLabel("Imię:"));
        form.add(tfImie);
        form.add(new JLabel("Nazwisko:"));
        form.add(tfNazwisko);
        form.add(new JLabel("Stanowisko:"));
        form.add(tfStanowisko);
        form.add(btnDodaj);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(new JTable(tableModel)), BorderLayout.CENTER);
    }

    public String getImie() {
        return tfImie.getText().trim();
    }

    public String getNazwisko() {
        return tfNazwisko.getText().trim();
    }

    public String getStanowisko() {
        return tfStanowisko.getText().trim();
    }

    public void addDodajListener(ActionListener listener) {
        btnDodaj.addActionListener(listener);
    }

    public void setPracownicy(List<Pracownik> lista) {
        tableModel.setRowCount(0);
        for (Pracownik p : lista) {
            tableModel.addRow(new Object[]{p.getId(), p.getImie(), p.getNazwisko(), p.getStanowisko()});
        }
    }

    public void wyczyscPola() {
        tfImie.setText("");
        tfNazwisko.setText("");
        tfStanowisko.setText("");
    }

    public void pokazBlad(String tresc) {
        JOptionPane.showMessageDialog(this, tresc, "Błąd", JOptionPane.ERROR_MESSAGE);
    }

    public void pokazInfo(String tresc) {
        JOptionPane.showMessageDialog(this, tresc, "Informacja", JOptionPane.INFORMATION_MESSAGE);
    }
}
