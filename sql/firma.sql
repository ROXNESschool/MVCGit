CREATE DATABASE IF NOT EXISTS firma CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci;
USE firma;
CREATE TABLE IF NOT EXISTS pracownicy (
    id INT AUTO_INCREMENT PRIMARY KEY,
    imie VARCHAR(50) NOT NULL,
    nazwisko VARCHAR(50) NOT NULL,
    stanowisko VARCHAR(50) NOT NULL
);
INSERT INTO pracownicy (imie, nazwisko, stanowisko) VALUES
('Jan', 'Kowalski', 'Programista'),
('Anna', 'Nowak', 'Tester');
