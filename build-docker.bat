@echo off
echo Building Spring Boot application...
call mvn clean package -DskipTests

if %ERRORLEVEL% NEQ 0 (
    echo Build failed!
    pause
    exit /b 1
)

echo Building Docker image...
docker build -t welder-fabrication .

if %ERRORLEVEL% NEQ 0 (
    echo Docker build failed!
    pause
    exit /b 1
)

echo Build successful!
echo To run with Docker Compose: docker-compose up
echo To run standalone: docker run -p 8080:8080 welder-fabrication
pause 