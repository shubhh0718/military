package com.military.weapon;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Military Weapon Management System - Main GUI
 * A comprehensive menu-driven application for managing military weapons inventory
 */
public class MilitaryWeaponManagementGUI extends JFrame {
    
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JTable weaponTable;
    private DefaultTableModel tableModel;
    
    // Constructor
    public MilitaryWeaponManagementGUI() {
        setTitle("Military Weapon Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(true);
        
        // Create main panel
        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create menu bar
        setJMenuBar(createMenuBar());
        
        // Create tabbed pane
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("View Weapons", createViewPanel());
        tabbedPane.addTab("Add Weapon", createAddPanel());
        tabbedPane.addTab("Update Weapon", createUpdatePanel());
        tabbedPane.addTab("Delete Weapon", createDeletePanel());
        tabbedPane.addTab("Reports", createReportsPanel());
        tabbedPane.addTab("Search", createSearchPanel());
        
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        
        add(mainPanel);
        setVisible(true);
    }
    
    /**
     * Create menu bar with various options
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        
        // Weapon Menu
        JMenu weaponMenu = new JMenu("Weapon");
        JMenuItem addItem = new JMenuItem("Add Weapon");
        addItem.addActionListener(e -> tabbedPane.setSelectedIndex(1));
        JMenuItem viewItem = new JMenuItem("View All Weapons");
        viewItem.addActionListener(e -> {
            refreshWeaponTable();
            tabbedPane.setSelectedIndex(0);
        });
        JMenuItem updateItem = new JMenuItem("Update Weapon");
        updateItem.addActionListener(e -> tabbedPane.setSelectedIndex(2));
        JMenuItem deleteItem = new JMenuItem("Delete Weapon");
        deleteItem.addActionListener(e -> tabbedPane.setSelectedIndex(3));
        
        weaponMenu.add(addItem);
        weaponMenu.add(viewItem);
        weaponMenu.add(updateItem);
        weaponMenu.add(deleteItem);
        
        // Report Menu
        JMenu reportMenu = new JMenu("Reports");
        JMenuItem inventoryReport = new JMenuItem("Inventory Report");
        inventoryReport.addActionListener(e -> tabbedPane.setSelectedIndex(4));
        reportMenu.add(inventoryReport);
        
        // Search Menu
        JMenu searchMenu = new JMenu("Search");
        JMenuItem searchItem = new JMenuItem("Search Weapons");
        searchItem.addActionListener(e -> tabbedPane.setSelectedIndex(5));
        searchMenu.add(searchItem);
        
        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> showAboutDialog());
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(weaponMenu);
        menuBar.add(reportMenu);
        menuBar.add(searchMenu);
        menuBar.add(helpMenu);
        
        return menuBar;
    }
    
    /**
     * Create View Weapons Panel
     */
    private JPanel createViewPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create table
        String[] columnNames = {"ID", "Name", "Type", "Manufacturer", "Quantity", "Unit Price", "Status", "Date Acquired"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        weaponTable = new JTable(tableModel);
        weaponTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        weaponTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        JScrollPane scrollPane = new JScrollPane(weaponTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.addActionListener(e -> refreshWeaponTable());
        
        buttonPanel.add(refreshBtn);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Load weapons on panel creation
        refreshWeaponTable();
        
        return panel;
    }
    
    /**
     * Create Add Weapon Panel
     */
    private JPanel createAddPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Labels and TextFields
        JLabel nameLabel = new JLabel("Weapon Name:");
        JTextField nameField = new JTextField(20);
        
        JLabel typeLabel = new JLabel("Weapon Type:");
        JComboBox<String> typeCombo = new JComboBox<>(
            new String[]{"Rifle", "Pistol", "Sniper", "Grenade Launcher", "Machine Gun", "Rocket Launcher", "Missile", "Other"}
        );
        
        JLabel manufacturerLabel = new JLabel("Manufacturer:");
        JTextField manufacturerField = new JTextField(20);
        
        JLabel quantityLabel = new JLabel("Quantity:");
        JSpinner quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 0, 10000, 1));
        
        JLabel priceLabel = new JLabel("Unit Price:");
        JTextField priceField = new JTextField(20);
        
        JLabel statusLabel = new JLabel("Status:");
        JComboBox<String> statusCombo = new JComboBox<>(
            new String[]{"Active", "Inactive", "Maintenance", "Retired"}
        );
        
        JLabel dateLabel = new JLabel("Date Acquired (YYYY-MM-DD):");
        JTextField dateField = new JTextField(20);
        
        // Add components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(typeLabel, gbc);
        gbc.gridx = 1;
        panel.add(typeCombo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(manufacturerLabel, gbc);
        gbc.gridx = 1;
        panel.add(manufacturerField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(quantityLabel, gbc);
        gbc.gridx = 1;
        panel.add(quantitySpinner, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(priceLabel, gbc);
        gbc.gridx = 1;
        panel.add(priceField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(statusLabel, gbc);
        gbc.gridx = 1;
        panel.add(statusCombo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(dateLabel, gbc);
        gbc.gridx = 1;
        panel.add(dateField, gbc);
        
        // Buttons
        JButton addBtn = new JButton("Add Weapon");
        JButton resetBtn = new JButton("Reset");
        
        addBtn.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String type = (String) typeCombo.getSelectedItem();
                String manufacturer = manufacturerField.getText().trim();
                int quantity = (int) quantitySpinner.getValue();
                double price = Double.parseDouble(priceField.getText().trim());
                String status = (String) statusCombo.getSelectedItem();
                String date = dateField.getText().trim();
                
                if (name.isEmpty() || manufacturer.isEmpty() || date.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Weapon weapon = new Weapon(name, type, manufacturer, quantity, price, status, date);
                
                if (WeaponDAO.addWeapon(weapon)) {
                    JOptionPane.showMessageDialog(panel, "Weapon added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    nameField.setText("");
                    manufacturerField.setText("");
                    priceField.setText("");
                    dateField.setText("");
                    quantitySpinner.setValue(1);
                } else {
                    JOptionPane.showMessageDialog(panel, "Failed to add weapon!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid price format!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        resetBtn.addActionListener(e -> {
            nameField.setText("");
            manufacturerField.setText("");
            priceField.setText("");
            dateField.setText("");
            quantitySpinner.setValue(1);
        });
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(addBtn);
        btnPanel.add(resetBtn);
        panel.add(btnPanel, gbc);
        
        return panel;
    }
    
    /**
     * Create Update Weapon Panel
     */
    private JPanel createUpdatePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // ID field
        JLabel idLabel = new JLabel("Weapon ID:");
        JSpinner idSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        
        // Other fields
        JLabel nameLabel = new JLabel("Weapon Name:");
        JTextField nameField = new JTextField(20);
        
        JLabel typeLabel = new JLabel("Weapon Type:");
        JComboBox<String> typeCombo = new JComboBox<>(
            new String[]{"Rifle", "Pistol", "Sniper", "Grenade Launcher", "Machine Gun", "Rocket Launcher", "Missile", "Other"}
        );
        
        JLabel manufacturerLabel = new JLabel("Manufacturer:");
        JTextField manufacturerField = new JTextField(20);
        
        JLabel quantityLabel = new JLabel("Quantity:");
        JSpinner quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 0, 10000, 1));
        
        JLabel priceLabel = new JLabel("Unit Price:");
        JTextField priceField = new JTextField(20);
        
        JLabel statusLabel = new JLabel("Status:");
        JComboBox<String> statusCombo = new JComboBox<>(
            new String[]{"Active", "Inactive", "Maintenance", "Retired"}
        );
        
        JLabel dateLabel = new JLabel("Date Acquired (YYYY-MM-DD):");
        JTextField dateField = new JTextField(20);
        
        // Add components
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);
        gbc.gridx = 1;
        panel.add(idSpinner, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(typeLabel, gbc);
        gbc.gridx = 1;
        panel.add(typeCombo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(manufacturerLabel, gbc);
        gbc.gridx = 1;
        panel.add(manufacturerField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(quantityLabel, gbc);
        gbc.gridx = 1;
        panel.add(quantitySpinner, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(priceLabel, gbc);
        gbc.gridx = 1;
        panel.add(priceField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(statusLabel, gbc);
        gbc.gridx = 1;
        panel.add(statusCombo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(dateLabel, gbc);
        gbc.gridx = 1;
        panel.add(dateField, gbc);
        
        // Buttons
        JButton loadBtn = new JButton("Load Weapon");
        JButton updateBtn = new JButton("Update Weapon");
        
        loadBtn.addActionListener(e -> {
            try {
                int id = (int) idSpinner.getValue();
                Weapon weapon = WeaponDAO.getWeaponById(id);
                
                if (weapon != null) {
                    nameField.setText(weapon.getWeaponName());
                    typeCombo.setSelectedItem(weapon.getWeaponType());
                    manufacturerField.setText(weapon.getManufacturer());
                    quantitySpinner.setValue(weapon.getQuantity());
                    priceField.setText(String.valueOf(weapon.getUnitPrice()));
                    statusCombo.setSelectedItem(weapon.getStatus());
                    dateField.setText(weapon.getDateAcquired());
                } else {
                    JOptionPane.showMessageDialog(panel, "Weapon not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error loading weapon: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        updateBtn.addActionListener(e -> {
            try {
                int id = (int) idSpinner.getValue();
                String name = nameField.getText().trim();
                String type = (String) typeCombo.getSelectedItem();
                String manufacturer = manufacturerField.getText().trim();
                int quantity = (int) quantitySpinner.getValue();
                double price = Double.parseDouble(priceField.getText().trim());
                String status = (String) statusCombo.getSelectedItem();
                String date = dateField.getText().trim();
                
                if (name.isEmpty() || manufacturer.isEmpty() || date.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Weapon weapon = new Weapon(id, name, type, manufacturer, quantity, price, status, date);
                
                if (WeaponDAO.updateWeapon(weapon)) {
                    JOptionPane.showMessageDialog(panel, "Weapon updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Failed to update weapon!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input format!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(loadBtn);
        btnPanel.add(updateBtn);
        panel.add(btnPanel, gbc);
        
        return panel;
    }
    
    /**
     * Create Delete Weapon Panel
     */
    private JPanel createDeletePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        JLabel idLabel = new JLabel("Weapon ID to Delete:");
        JSpinner idSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);
        gbc.gridx = 1;
        panel.add(idSpinner, gbc);
        
        JButton deleteBtn = new JButton("Delete Weapon");
        deleteBtn.addActionListener(e -> {
            int id = (int) idSpinner.getValue();
            int confirm = JOptionPane.showConfirmDialog(panel, 
                "Are you sure you want to delete weapon ID " + id + "?", 
                "Confirm Delete", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                if (WeaponDAO.deleteWeapon(id)) {
                    JOptionPane.showMessageDialog(panel, "Weapon deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    refreshWeaponTable();
                } else {
                    JOptionPane.showMessageDialog(panel, "Failed to delete weapon!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        JPanel deletePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        deletePanel.add(deleteBtn);
        panel.add(deletePanel, gbc);
        
        return panel;
    }
    
    /**
     * Create Reports Panel
     */
    private JPanel createReportsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setFont(new Font("Courier New", Font.PLAIN, 12));
        
        JScrollPane scrollPane = new JScrollPane(reportArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Button panel
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JButton inventoryBtn = new JButton("Total Inventory Value");
        inventoryBtn.addActionListener(e -> {
            double value = WeaponDAO.getTotalInventoryValue();
            reportArea.setText("Total Inventory Value: $" + String.format("%.2f", value));
        });
        
        JButton countBtn = new JButton("Total Weapons Count");
        countBtn.addActionListener(e -> {
            int count = WeaponDAO.getTotalWeaponCount();
            reportArea.setText("Total Weapons: " + count);
        });
        
        JButton lowStockBtn = new JButton("Low Stock Weapons");
        lowStockBtn.addActionListener(e -> {
            List<Weapon> weapons = WeaponDAO.getLowStockWeapons(5);
            StringBuilder report = new StringBuilder("Low Stock Weapons (< 5):\n\n");
            if (weapons.isEmpty()) {
                report.append("No low stock weapons found.");
            } else {
                for (Weapon w : weapons) {
                    report.append("ID: ").append(w.getWeaponId())
                          .append(" | Name: ").append(w.getWeaponName())
                          .append(" | Quantity: ").append(w.getQuantity()).append("\n");
                }
            }
            reportArea.setText(report.toString());
        });
        
        JButton detailedBtn = new JButton("Detailed Report");
        detailedBtn.addActionListener(e -> {
            List<Weapon> weapons = WeaponDAO.getAllWeapons();
            StringBuilder report = new StringBuilder("DETAILED INVENTORY REPORT\n");
            report.append("=".repeat(80)).append("\n\n");
            
            if (weapons.isEmpty()) {
                report.append("No weapons in inventory.");
            } else {
                for (Weapon w : weapons) {
                    report.append("ID: ").append(w.getWeaponId()).append("\n")
                          .append("Name: ").append(w.getWeaponName()).append("\n")
                          .append("Type: ").append(w.getWeaponType()).append("\n")
                          .append("Manufacturer: ").append(w.getManufacturer()).append("\n")
                          .append("Quantity: ").append(w.getQuantity()).append("\n")
                          .append("Unit Price: $").append(String.format("%.2f", w.getUnitPrice())).append("\n")
                          .append("Total Value: $").append(String.format("%.2f", w.getQuantity() * w.getUnitPrice())).append("\n")
                          .append("Status: ").append(w.getStatus()).append("\n")
                          .append("Date Acquired: ").append(w.getDateAcquired()).append("\n")
                          .append("-".repeat(80)).append("\n");
                }
            }
            reportArea.setText(report.toString());
        });
        
        btnPanel.add(inventoryBtn);
        btnPanel.add(countBtn);
        btnPanel.add(lowStockBtn);
        btnPanel.add(detailedBtn);
        
        panel.add(btnPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    /**
     * Create Search Panel
     */
    private JPanel createSearchPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel searchLabel = new JLabel("Search by Name:");
        JTextField searchField = new JTextField(20);
        JButton searchBtn = new JButton("Search");
        
        JLabel typeLabel = new JLabel("Or Filter by Type:");
        JComboBox<String> typeCombo = new JComboBox<>(
            new String[]{"All", "Rifle", "Pistol", "Sniper", "Grenade Launcher", "Machine Gun", "Rocket Launcher", "Missile", "Other"}
        );
        JButton filterBtn = new JButton("Filter");
        
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);
        searchPanel.add(new JSeparator(SwingConstants.VERTICAL));
        searchPanel.add(typeLabel);
        searchPanel.add(typeCombo);
        searchPanel.add(filterBtn);
        
        // Results table
        String[] columnNames = {"ID", "Name", "Type", "Manufacturer", "Quantity", "Unit Price", "Status", "Date Acquired"};
        DefaultTableModel searchTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable searchTable = new JTable(searchTableModel);
        JScrollPane scrollPane = new JScrollPane(searchTable);
        
        searchBtn.addActionListener(e -> {
            String searchTerm = searchField.getText().trim();
            if (searchTerm.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "Enter a search term!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            List<Weapon> results = WeaponDAO.searchWeaponByName(searchTerm);
            searchTableModel.setRowCount(0);
            
            for (Weapon w : results) {
                searchTableModel.addRow(new Object[]{
                    w.getWeaponId(), w.getWeaponName(), w.getWeaponType(),
                    w.getManufacturer(), w.getQuantity(), 
                    String.format("%.2f", w.getUnitPrice()),
                    w.getStatus(), w.getDateAcquired()
                });
            }
            
            if (results.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "No weapons found!", "No Results", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        filterBtn.addActionListener(e -> {
            String type = (String) typeCombo.getSelectedItem();
            searchTableModel.setRowCount(0);
            
            if (type.equals("All")) {
                List<Weapon> weapons = WeaponDAO.getAllWeapons();
                for (Weapon w : weapons) {
                    searchTableModel.addRow(new Object[]{
                        w.getWeaponId(), w.getWeaponName(), w.getWeaponType(),
                        w.getManufacturer(), w.getQuantity(),
                        String.format("%.2f", w.getUnitPrice()),
                        w.getStatus(), w.getDateAcquired()
                    });
                }
            } else {
                List<Weapon> results = WeaponDAO.getWeaponsByType(type);
                for (Weapon w : results) {
                    searchTableModel.addRow(new Object[]{
                        w.getWeaponId(), w.getWeaponName(), w.getWeaponType(),
                        w.getManufacturer(), w.getQuantity(),
                        String.format("%.2f", w.getUnitPrice()),
                        w.getStatus(), w.getDateAcquired()
                    });
                }
            }
        });
        
        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    /**
     * Refresh weapon table
     */
    private void refreshWeaponTable() {
        tableModel.setRowCount(0);
        List<Weapon> weapons = WeaponDAO.getAllWeapons();
        
        for (Weapon w : weapons) {
            tableModel.addRow(new Object[]{
                w.getWeaponId(),
                w.getWeaponName(),
                w.getWeaponType(),
                w.getManufacturer(),
                w.getQuantity(),
                String.format("%.2f", w.getUnitPrice()),
                w.getStatus(),
                w.getDateAcquired()
            });
        }
    }
    
    /**
     * Show About Dialog
     */
    private void showAboutDialog() {
        JOptionPane.showMessageDialog(this,
            "Military Weapon Management System\n\n" +
            "Version 1.0\n\n" +
            "A comprehensive GUI application for managing military weapons inventory.\n\n" +
            "Technologies:\n" +
            "- Java Swing (GUI)\n" +
            "- JDBC (Database)\n" +
            "- MySQL (Database)\n\n" +
            "© 2026 Military Management",
            "About",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Main method
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MilitaryWeaponManagementGUI());
    }
}
