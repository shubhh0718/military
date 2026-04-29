# Military Weapon Management System

A comprehensive GUI-based application for managing military weapons inventory using Java, Swing, JDBC, and MySQL.

## Features

✅ **Complete Weapon Management**
- Add new weapons to inventory
- View all weapons in a table format
- Update existing weapon details
- Delete weapons from inventory
- Search weapons by name
- Filter weapons by type

✅ **Inventory Reports**
- Total inventory value calculation
- Total weapons count
- Low stock weapon alerts (less than 5 units)
- Detailed inventory report with all weapon details

✅ **Database Integration**
- MySQL database backend
- JDBC connectivity
- Prepared statements for secure SQL execution
- Connection pooling

✅ **User-Friendly GUI**
- Tabbed interface for different operations
- Menu-driven navigation
- Form validation
- Confirmation dialogs
- Error handling and user feedback

## System Requirements

- **Java**: JDK 8 or higher
- **MySQL**: 5.7 or higher
- **MySQL JDBC Driver**: mysql-connector-java-8.0.33 (or latest)

## Installation Steps

### 1. Set Up MySQL Database

- **Install MySQL** (if not already installed)
- **Open MySQL Command Line** or MySQL Workbench
- **Run the database schema**:
  ```sql
  -- Copy and paste the contents of database_schema.sql file
  ```
  Or from command line:
  ```bash
  mysql -u root -p < database_schema.sql
  ```

### 2. Download MySQL JDBC Driver

- Download `mysql-connector-java-8.0.33.jar` from [MySQL Official Site](https://dev.mysql.com/downloads/connector/j/)
- Place the JAR file in the `lib/` folder of the project

### 3. Configure Database Connection

Edit the file: `src/main/java/com/military/weapon/DatabaseConnection.java`

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/military_weapon_db";
private static final String DB_USER = "root";
private static final String DB_PASSWORD = ""; // Enter your password if set
```

Change the password if you have set one for your MySQL root user.

### 4. Compile the Project

Navigate to the project directory and run:

```bash
cd "c:\Users\Utkarsh vatshayan\Downloads\Military managemnt"

# Compile all Java files
javac -d src/main/java -cp lib/mysql-connector-java-8.0.33.jar src/main/java/com/military/weapon/*.java
```

Or compile with this command (Windows):

```powershell
javac -cp lib/mysql-connector-java-8.0.33.jar -d . src/main/java/com/military/weapon/*.java
```

### 5. Run the Application

```bash
java -cp lib/mysql-connector-java-8.0.33.jar:. com.military.weapon.MilitaryWeaponManagementGUI
```

Or on Windows PowerShell:

```powershell
java -cp "lib/mysql-connector-java-8.0.33.jar;." com.military.weapon.MilitaryWeaponManagementGUI
```

## Project Structure

```
Military managemnt/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── military/
│       │           └── weapon/
│       │               ├── DatabaseConnection.java     (Database connection handler)
│       │               ├── Weapon.java                  (Model class)
│       │               ├── WeaponDAO.java               (Data Access Object)
│       │               └── MilitaryWeaponManagementGUI.java (Main GUI Application)
│       └── resources/
│
├── lib/
│   └── mysql-connector-java-8.0.33.jar (Add MySQL driver here)
│
├── database_schema.sql                 (Database setup script)
└── README.md                           (This file)
```

## Usage Guide

### Main Menu Bar
- **File**: Exit application
- **Weapon**: Quick access to weapon operations
- **Reports**: View inventory reports
- **Search**: Search and filter weapons
- **Help**: About the application

### Tabs Overview

#### 1. View Weapons Tab
- Displays all weapons in the inventory
- Shows weapon details: ID, Name, Type, Manufacturer, Quantity, Price, Status, Date
- Refresh button to update the list

#### 2. Add Weapon Tab
- Form to add new weapons to inventory
- Fields: Name, Type, Manufacturer, Quantity, Price, Status, Date Acquired
- Validation for empty fields
- Confirmation message on successful addition

#### 3. Update Weapon Tab
- Load weapon details by ID
- Modify any field
- Update button to save changes
- Confirmation on successful update

#### 4. Delete Weapon Tab
- Enter weapon ID to delete
- Confirmation dialog before deletion
- Automatic table refresh after deletion

#### 5. Reports Tab
- **Total Inventory Value**: Sum of all weapon quantities × unit prices
- **Total Weapons Count**: Total number of weapons in inventory
- **Low Stock Weapons**: Shows weapons with quantity less than 5
- **Detailed Report**: Complete inventory report with all details

#### 6. Search Tab
- **Search by Name**: Find weapons by partial name match
- **Filter by Type**: View weapons by type (Rifle, Pistol, Sniper, etc.)
- Results displayed in a table

## Database Schema

### weapons Table
- `weapon_id`: Auto-increment primary key
- `weapon_name`: Name of the weapon
- `weapon_type`: Type (Rifle, Pistol, Sniper, etc.)
- `manufacturer`: Manufacturing company
- `quantity`: Number of units in stock
- `unit_price`: Price per unit
- `status`: Active, Inactive, Maintenance, Retired
- `date_acquired`: Date when acquired
- `created_at`: Timestamp of creation
- `updated_at`: Timestamp of last update

## Sample Data

The database comes with 10 sample weapons including:
- M16 Rifle
- Glock 19
- Barrett M82 Sniper
- M320 Grenade Launcher
- M249 SAW
- FGM-148 Javelin
- Patriot Missile System
- AK-47
- M4 Carbine
- Sig Sauer P226

## Weapon Types

The system supports these weapon types:
- Rifle
- Pistol
- Sniper
- Grenade Launcher
- Machine Gun
- Rocket Launcher
- Missile
- Other

## Status Options

- **Active**: Currently in use
- **Inactive**: Not in use
- **Maintenance**: Under maintenance
- **Retired**: Out of service

## Troubleshooting

### "No suitable driver found"
- Ensure mysql-connector-java JAR is in the `lib/` folder
- Check the classpath when compiling and running

### "Connection refused"
- Verify MySQL server is running
- Check database credentials in DatabaseConnection.java
- Ensure database name is correct

### "Database not found"
- Run the database_schema.sql file to create the database
- Verify you're using the correct database name

### "Table not found"
- Run database_schema.sql file
- Check database connection details

## Security Notes

⚠️ **Important**:
- This is a demo application. For production use:
  - Use environment variables for database credentials
  - Implement proper authentication
  - Add user roles and permissions
  - Enable database encryption
  - Use connection pooling (HikariCP, C3P0)
  - Implement audit logging

## Future Enhancements

- User authentication and role-based access
- Weapon maintenance schedule tracking
- Export reports to PDF/Excel
- Real-time inventory sync
- Multi-user support with conflict resolution
- Backup and restore functionality
- Advanced search with date range filters
- Barcode/QR code support

## License

This project is for educational purposes.

## Support

For issues or questions, ensure:
1. MySQL is running
2. Database is created with schema
3. JDBC driver is properly configured
4. Classpath includes the MySQL JAR file

## Version

**Version**: 1.0  
**Release Date**: 2026  
**Last Updated**: April 2026
