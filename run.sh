#!/bin/bash

# ========================================
# Military Weapon Management System
# Run Script for Linux/Mac
# ========================================

echo ""
echo "========================================"
echo "Military Weapon Management System"
echo "========================================"
echo ""

PROJECT_DIR=$(pwd)
LIB_DIR="$PROJECT_DIR/lib"
MYSQL_JAR="$LIB_DIR/mysql-connector-java-8.0.33.jar"

# Check if MySQL JAR exists
if [ ! -f "$MYSQL_JAR" ]; then
    echo ""
    echo "ERROR: MySQL JDBC Driver not found!"
    echo "Please download mysql-connector-java-8.0.33.jar and place it in the lib folder."
    echo "Download from: https://dev.mysql.com/downloads/connector/j/"
    echo ""
    exit 1
fi

echo "Starting Military Weapon Management System..."
echo ""
echo "Note: Make sure MySQL is running and the database is set up."
echo ""

# Run the application
java -cp "$MYSQL_JAR:$PROJECT_DIR" com.military.weapon.MilitaryWeaponManagementGUI

if [ $? -ne 0 ]; then
    echo ""
    echo "ERROR: Failed to start the application!"
    echo "Make sure:"
    echo "1. MySQL server is running"
    echo "2. Database is created using database_schema.sql"
    echo "3. Database credentials are correct in DatabaseConnection.java"
    echo ""
fi
