package com.military.weapon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for Weapon operations
 * Handles all database operations for weapons
 */
public class WeaponDAO {
    
    /**
     * Add a new weapon to the database
     */
    public static boolean addWeapon(Weapon weapon) {
        String sql = "INSERT INTO weapons (weapon_name, weapon_type, manufacturer, quantity, unit_price, status, date_acquired) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, weapon.getWeaponName());
            pstmt.setString(2, weapon.getWeaponType());
            pstmt.setString(3, weapon.getManufacturer());
            pstmt.setInt(4, weapon.getQuantity());
            pstmt.setDouble(5, weapon.getUnitPrice());
            pstmt.setString(6, weapon.getStatus());
            pstmt.setString(7, weapon.getDateAcquired());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Update an existing weapon
     */
    public static boolean updateWeapon(Weapon weapon) {
        String sql = "UPDATE weapons SET weapon_name=?, weapon_type=?, manufacturer=?, quantity=?, " +
                     "unit_price=?, status=?, date_acquired=? WHERE weapon_id=?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, weapon.getWeaponName());
            pstmt.setString(2, weapon.getWeaponType());
            pstmt.setString(3, weapon.getManufacturer());
            pstmt.setInt(4, weapon.getQuantity());
            pstmt.setDouble(5, weapon.getUnitPrice());
            pstmt.setString(6, weapon.getStatus());
            pstmt.setString(7, weapon.getDateAcquired());
            pstmt.setInt(8, weapon.getWeaponId());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Delete a weapon by ID
     */
    public static boolean deleteWeapon(int weaponId) {
        String sql = "DELETE FROM weapons WHERE weapon_id=?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, weaponId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Get a weapon by ID
     */
    public static Weapon getWeaponById(int weaponId) {
        String sql = "SELECT * FROM weapons WHERE weapon_id=?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, weaponId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Weapon(
                    rs.getInt("weapon_id"),
                    rs.getString("weapon_name"),
                    rs.getString("weapon_type"),
                    rs.getString("manufacturer"),
                    rs.getInt("quantity"),
                    rs.getDouble("unit_price"),
                    rs.getString("status"),
                    rs.getString("date_acquired")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Get all weapons
     */
    public static List<Weapon> getAllWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        String sql = "SELECT * FROM weapons";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                weapons.add(new Weapon(
                    rs.getInt("weapon_id"),
                    rs.getString("weapon_name"),
                    rs.getString("weapon_type"),
                    rs.getString("manufacturer"),
                    rs.getInt("quantity"),
                    rs.getDouble("unit_price"),
                    rs.getString("status"),
                    rs.getString("date_acquired")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weapons;
    }
    
    /**
     * Search weapons by name
     */
    public static List<Weapon> searchWeaponByName(String name) {
        List<Weapon> weapons = new ArrayList<>();
        String sql = "SELECT * FROM weapons WHERE weapon_name LIKE ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                weapons.add(new Weapon(
                    rs.getInt("weapon_id"),
                    rs.getString("weapon_name"),
                    rs.getString("weapon_type"),
                    rs.getString("manufacturer"),
                    rs.getInt("quantity"),
                    rs.getDouble("unit_price"),
                    rs.getString("status"),
                    rs.getString("date_acquired")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weapons;
    }
    
    /**
     * Get weapons by type
     */
    public static List<Weapon> getWeaponsByType(String type) {
        List<Weapon> weapons = new ArrayList<>();
        String sql = "SELECT * FROM weapons WHERE weapon_type=?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                weapons.add(new Weapon(
                    rs.getInt("weapon_id"),
                    rs.getString("weapon_name"),
                    rs.getString("weapon_type"),
                    rs.getString("manufacturer"),
                    rs.getInt("quantity"),
                    rs.getDouble("unit_price"),
                    rs.getString("status"),
                    rs.getString("date_acquired")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weapons;
    }
    
    /**
     * Get low stock weapons (quantity < threshold)
     */
    public static List<Weapon> getLowStockWeapons(int threshold) {
        List<Weapon> weapons = new ArrayList<>();
        String sql = "SELECT * FROM weapons WHERE quantity < ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, threshold);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                weapons.add(new Weapon(
                    rs.getInt("weapon_id"),
                    rs.getString("weapon_name"),
                    rs.getString("weapon_type"),
                    rs.getString("manufacturer"),
                    rs.getInt("quantity"),
                    rs.getDouble("unit_price"),
                    rs.getString("status"),
                    rs.getString("date_acquired")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weapons;
    }
    
    /**
     * Get total inventory value
     */
    public static double getTotalInventoryValue() {
        String sql = "SELECT SUM(quantity * unit_price) as total_value FROM weapons";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getDouble("total_value");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    
    /**
     * Count total weapons
     */
    public static int getTotalWeaponCount() {
        String sql = "SELECT COUNT(*) as count FROM weapons";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
