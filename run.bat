@echo off
REM ========================================
REM Military Weapon Management System
REM Run Script for Windows
REM ========================================

echo.
echo ========================================
echo Military Weapon Management System
echo ========================================
echo.

REM Set directory variables
set PROJECT_DIR=%CD%
set LIB_DIR=%PROJECT_DIR%\lib
set MYSQL_JAR=%LIB_DIR%\mysql-connector-java-8.0.33.jar

REM Check if MySQL JAR exists
if not exist "%MYSQL_JAR%" (
    echo.
    echo ERROR: MySQL JDBC Driver not found!
    echo Please download mysql-connector-java-8.0.33.jar and place it in the lib folder.
    echo Download from: https://dev.mysql.com/downloads/connector/j/
    echo.
    pause
    exit /b 1
)

echo Starting Military Weapon Management System...
echo.
echo Note: Make sure MySQL is running and the database is set up.
echo.

REM Run the application
java -cp "%MYSQL_JAR%;%PROJECT_DIR%" com.military.weapon.MilitaryWeaponManagementGUI

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ERROR: Failed to start the application!
    echo Make sure:
    echo 1. MySQL server is running
    echo 2. Database is created using database_schema.sql
    echo 3. Database credentials are correct in DatabaseConnection.java
    echo.
    pause
)
