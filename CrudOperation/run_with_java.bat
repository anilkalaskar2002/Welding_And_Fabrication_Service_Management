@echo off
echo Starting Welder & Fabrication Workshop Application...
echo.

echo Checking if Java is installed...
java -version >nul 2>&1
if errorlevel 1 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 21 or higher and try again
    pause
    exit /b 1
)

echo Java found! Starting application...
echo.
echo The application will be available at: http://localhost:8080
echo Press Ctrl+C to stop the application
echo.

java -jar target/CrudOperation-0.0.1-SNAPSHOT.jar

pause 