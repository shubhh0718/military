#!/bin/bash

# ========================================
# Military Weapon Management System
# Compilation Script for Linux/Mac
# ========================================

echo ""
echo "========================================"
echo "Military Weapon Management System"
echo "========================================"
echo ""

PROJECT_DIR=$(pwd)
SRC_DIR="$PROJECT_DIR/src/main/java"
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

echo "Compiling Java files..."
echo ""

# Compile Java files
javac -cp "$MYSQL_JAR" -d "$PROJECT_DIR" "$SRC_DIR/com/military/weapon/DatabaseConnection.java"
javac -cp "$MYSQL_JAR" -d "$PROJECT_DIR" "$SRC_DIR/com/military/weapon/Weapon.java"
javac -cp "$MYSQL_JAR" -d "$PROJECT_DIR" "$SRC_DIR/com/military/weapon/WeaponDAO.java"
javac -cp "$MYSQL_JAR" -d "$PROJECT_DIR" "$SRC_DIR/com/military/weapon/MilitaryWeaponManagementGUI.java"

if [ $? -eq 0 ]; then
    echo ""
    echo "========================================"
    echo "Compilation Successful!"
    echo "========================================"
    echo ""
    echo "To run the application, execute: ./run.sh"
    echo ""
else
    echo ""
    echo "ERROR: Compilation failed!"
    echo ""
    exit 1
fi
