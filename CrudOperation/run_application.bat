@echo off
echo Starting Welder & Fabrication Workshop Application...
echo.
echo Make sure MySQL is running with:
echo - Username: root
echo - Password: root
echo - Database: welder_fabrication
echo.
echo The application will be available at:
echo - Main website: http://localhost:8080
echo - Admin panel: http://localhost:8080/admin/products
echo.
echo Press any key to start the application...
pause > nul

mvn spring-boot:run

pause 