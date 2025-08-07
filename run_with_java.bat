@echo off
echo ========================================
echo Welder & Fabrication Workshop Application
echo ========================================
echo.

echo Checking if Java is installed...
java -version >nul 2>&1
if errorlevel 1 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 21 or higher and try again
    echo.
    echo Download from: https://adoptium.net/
    pause
    exit /b 1
)

echo Java found! 
echo.

echo IMPORTANT: This application requires a JAR file to run.
echo.
echo To create the JAR file, you need to:
echo 1. Install Maven (https://maven.apache.org/download.cgi)
echo 2. Run: mvn clean package
echo 3. Then run this batch file again
echo.
echo OR use an IDE like IntelliJ IDEA or Eclipse:
echo 1. Open the project in your IDE
echo 2. Run CrudOperationApplication.java
echo.
echo The application will be available at: http://localhost:8080
echo.
echo Press any key to continue...
pause >nul

echo.
echo Attempting to run the application...
echo.

if exist "target\CrudOperation-0.0.1-SNAPSHOT.jar" (
    echo JAR file found! Starting application...
    java -jar target/CrudOperation-0.0.1-SNAPSHOT.jar
) else (
    echo ERROR: JAR file not found!
    echo Please build the project first using Maven or an IDE.
    echo.
    echo Expected location: target\CrudOperation-0.0.1-SNAPSHOT.jar
)

echo.
pause 