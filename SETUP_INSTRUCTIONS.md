# Quick Start Guide - Military Weapon Management System

## ⚡ 5-Minute Setup

### Step 1: Download MySQL JDBC Driver
1. Visit: https://dev.mysql.com/downloads/connector/j/
2. Download `mysql-connector-java-8.0.33.jar` (select Connector/J 8.0.33 or latest)
3. Extract and copy `mysql-connector-java-8.0.33.jar`
4. Paste it into the `lib/` folder in this project

### Step 2: Set Up MySQL Database
1. Open MySQL Command Line or MySQL Workbench
2. Copy all content from `database_schema.sql`
3. Paste and execute the SQL

**Or use this single command:**
```bash
mysql -u root -p < database_schema.sql
```

### Step 3: Verify Database Connection
Edit `src/main/java/com/military/weapon/DatabaseConnection.java`

Check these settings:
```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/military_weapon_db";
private static final String DB_USER = "root";
private static final String DB_PASSWORD = ""; // Change if you set a password
```

**If you set a MySQL password:**
```java
private static final String DB_PASSWORD = "your_password_here";
```

### Step 4: Compile & Run

**Windows:**
```batch
compile.bat
run.bat
```

**Linux/Mac:**
```bash
./compile.sh
./run.sh
```

## Manual Compilation & Run (if scripts don't work)

### Windows PowerShell:
```powershell
# Compile
javac -cp "lib/mysql-connector-java-8.0.33.jar" -d . src/main/java/com/military/weapon/*.java

# Run
java -cp "lib/mysql-connector-java-8.0.33.jar;." com.military.weapon.MilitaryWeaponManagementGUI
```

### Linux/Mac Terminal:
```bash
# Compile
javac -cp "lib/mysql-connector-java-8.0.33.jar" -d . src/main/java/com/military/weapon/*.java

# Run
java -cp "lib/mysql-connector-java-8.0.33.jar:." com.military.weapon.MilitaryWeaponManagementGUI
```

## Troubleshooting

| Problem | Solution |
|---------|----------|
| **"No suitable driver found"** | Add mysql-connector-java JAR to lib folder |
| **"Connection refused"** | Start MySQL server first |
| **"Unknown database"** | Run database_schema.sql to create database |
| **"Table doesn't exist"** | Verify database_schema.sql was executed fully |
| **Application won't start** | Check MySQL is running and credentials are correct |

## Features Quick Reference

### 📋 View Weapons Tab
- See all weapons in inventory
- Click Refresh to update

### ➕ Add Weapon Tab
- Fill in weapon details
- Click "Add Weapon" to save
- Types: Rifle, Pistol, Sniper, Grenade Launcher, Machine Gun, Rocket Launcher, Missile

### ✏️ Update Weapon Tab
1. Enter weapon ID
2. Click "Load Weapon"
3. Modify fields
4. Click "Update Weapon"

### 🗑️ Delete Weapon Tab
- Enter weapon ID
- Click "Delete Weapon"
- Confirm deletion

### 📊 Reports Tab
- **Total Inventory Value**: Sum of all weapon costs
- **Total Weapons Count**: Number of items in inventory
- **Low Stock Weapons**: Items with quantity < 5
- **Detailed Report**: Complete inventory listing

### 🔍 Search Tab
- **Search by Name**: Partial name matching
- **Filter by Type**: View weapons by category

## Database Schema Overview

```
weapons table:
├── weapon_id (Auto-increment ID)
├── weapon_name
├── weapon_type
├── manufacturer
├── quantity
├── unit_price
├── status (Active, Inactive, Maintenance, Retired)
├── date_acquired
├── created_at (Auto-timestamp)
└── updated_at (Auto-timestamp)
```

## Sample Weapons in Database

The database includes these sample weapons:
- M16 Rifle - 150 units
- Glock 19 - 200 units
- Barrett M82 Sniper - 25 units
- M320 Grenade Launcher - 50 units
- M249 SAW - 100 units
- FGM-148 Javelin - 30 units (Under Maintenance)
- Patriot Missile System - 10 units
- AK-47 - 80 units (Inactive)
- M4 Carbine - 120 units
- Sig Sauer P226 - 180 units

## File Structure

```
Military managemnt/
├── src/main/java/com/military/weapon/
│   ├── DatabaseConnection.java (DB connection handling)
│   ├── Weapon.java (Data model)
│   ├── WeaponDAO.java (Database operations)
│   └── MilitaryWeaponManagementGUI.java (Main application)
├── lib/
│   └── [Place mysql-connector-java-8.0.33.jar here]
├── database_schema.sql (Database setup script)
├── README.md (Full documentation)
├── SETUP_INSTRUCTIONS.md (This file)
├── compile.bat & compile.sh (Compile scripts)
└── run.bat & run.sh (Run scripts)
```

## Key Classes

### DatabaseConnection.java
- Manages JDBC connections
- Loads MySQL driver
- Provides connection pooling

### Weapon.java
- Model class for weapon data
- Getters and setters
- toString() for logging

### WeaponDAO.java
- Data Access Object
- CRUD operations (Create, Read, Update, Delete)
- Search and filter methods
- Report queries

### MilitaryWeaponManagementGUI.java
- Main GUI application
- Swing-based interface
- Tabbed interface (6 tabs)
- Menu bar
- Form validation

## Next Steps

1. ✅ Download MySQL JDBC driver
2. ✅ Create database from database_schema.sql
3. ✅ Verify database credentials
4. ✅ Compile using compile.bat (Windows) or compile.sh (Linux/Mac)
5. ✅ Run using run.bat (Windows) or run.sh (Linux/Mac)
6. ✅ Test with sample data
7. ✅ Add your own weapons

## Additional Notes

- The application uses JDBC for database connectivity
- All SQL queries use PreparedStatements for security
- Form validation prevents invalid data entry
- All timestamps are auto-managed by MySQL
- Indexes on weapon_type, status for fast queries

## Support

For detailed information, see **README.md**

Good luck with your Military Weapon Management System! 🚀
