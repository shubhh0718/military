package com.military.weapon;

/**
 * Weapon Model Class
 * Represents a weapon in the military system
 */
public class Weapon {
    private int weaponId;
    private String weaponName;
    private String weaponType;
    private String manufacturer;
    private int quantity;
    private double unitPrice;
    private String status;
    private String dateAcquired;
    
    // Default Constructor
    public Weapon() {
    }
    
    // Full Constructor
    public Weapon(int weaponId, String weaponName, String weaponType, 
                  String manufacturer, int quantity, double unitPrice, 
                  String status, String dateAcquired) {
        this.weaponId = weaponId;
        this.weaponName = weaponName;
        this.weaponType = weaponType;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.status = status;
        this.dateAcquired = dateAcquired;
    }
    
    // Constructor for insert (without ID)
    public Weapon(String weaponName, String weaponType, String manufacturer,
                  int quantity, double unitPrice, String status, String dateAcquired) {
        this.weaponName = weaponName;
        this.weaponType = weaponType;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.status = status;
        this.dateAcquired = dateAcquired;
    }
    
    // Getters and Setters
    public int getWeaponId() {
        return weaponId;
    }
    
    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }
    
    public String getWeaponName() {
        return weaponName;
    }
    
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
    
    public String getWeaponType() {
        return weaponType;
    }
    
    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDateAcquired() {
        return dateAcquired;
    }
    
    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }
    
    @Override
    public String toString() {
        return "Weapon{" +
                "weaponId=" + weaponId +
                ", weaponName='" + weaponName + '\'' +
                ", weaponType='" + weaponType + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", status='" + status + '\'' +
                ", dateAcquired='" + dateAcquired + '\'' +
                '}';
    }
}
