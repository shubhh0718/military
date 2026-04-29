@echo off
REM ========================================
REM Military Weapon Management System
REM Compilation Script for Windows
REM ========================================

echo.
echo ========================================
echo Military Weapon Management System
echo ========================================
echo.

REM Set directory variables
set PROJECT_DIR=%CD%
set SRC_DIR=%PROJECT_DIR%\src\main\java
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

echo Compiling Java files...
echo.

REM Compile Java files
javac -cp "%MYSQL_JAR%" -d "%PROJECT_DIR%" "%SRC_DIR%\com\military\weapon\DatabaseConnection.java"
javac -cp "%MYSQL_JAR%" -d "%PROJECT_DIR%" "%SRC_DIR%\com\military\weapon\Weapon.java"
javac -cp "%MYSQL_JAR%" -d "%PROJECT_DIR%" "%SRC_DIR%\com\military\weapon\WeaponDAO.java"
javac -cp "%MYSQL_JAR%" -d "%PROJECT_DIR%" "%SRC_DIR%\com\military\weapon\MilitaryWeaponManagementGUI.java"

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo Compilation Successful!
    echo ========================================
    echo.
    echo To run the application, execute: run.bat
    echo.
) else (
    echo.
    echo ERROR: Compilation failed!
    echo.
    pause
    exit /b 1
)

pause
