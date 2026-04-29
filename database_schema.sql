-- Military Weapon Management System Database Schema
-- Create Database
CREATE DATABASE IF NOT EXISTS military_weapon_db;
USE military_weapon_db;

-- Create Weapons Table
CREATE TABLE IF NOT EXISTS weapons (
    weapon_id INT AUTO_INCREMENT PRIMARY KEY,
    weapon_name VARCHAR(100) NOT NULL,
    weapon_type VARCHAR(50) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    unit_price DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'Active',
    date_acquired DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_weapon_type (weapon_type),
    INDEX idx_status (status),
    INDEX idx_date_acquired (date_acquired)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert Sample Data
INSERT INTO weapons (weapon_name, weapon_type, manufacturer, quantity, unit_price, status, date_acquired) VALUES
('M16 Rifle', 'Rifle', 'Colt Manufacturing Company', 150, 1200.00, 'Active', '2020-01-15'),
('Glock 19', 'Pistol', 'Glock GmbH', 200, 500.00, 'Active', '2019-06-20'),
('Barrett M82', 'Sniper', 'Barrett Firearms', 25, 12000.00, 'Active', '2021-03-10'),
('M320 Grenade Launcher', 'Grenade Launcher', 'Heckler & Koch', 50, 3000.00, 'Active', '2020-07-22'),
('M249 SAW', 'Machine Gun', 'FN Herstal', 100, 5000.00, 'Active', '2019-11-05'),
('FGM-148 Javelin', 'Missile', 'Raytheon', 30, 178000.00, 'Maintenance', '2018-08-30'),
('Patriot Missile System', 'Missile', 'Raytheon', 10, 3000000.00, 'Active', '2015-02-14'),
('AK-47', 'Rifle', 'Izhmash', 80, 1500.00, 'Inactive', '2021-09-12'),
('M4 Carbine', 'Rifle', 'Colt Manufacturing', 120, 900.00, 'Active', '2022-01-08'),
('Sig Sauer P226', 'Pistol', 'Sig Sauer', 180, 800.00, 'Active', '2020-04-17');

-- Create Index on frequently searched columns
CREATE INDEX idx_weapon_name ON weapons(weapon_name);
