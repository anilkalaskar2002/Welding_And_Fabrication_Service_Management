# Installation Guide - Welder & Fabrication Workshop

## 🚀 Quick Setup (Without Maven)

Since you don't have Maven installed, here are the easiest ways to run the application:

### Option 1: Use an IDE (Recommended)

#### IntelliJ IDEA (Free Community Edition)
1. **Download IntelliJ IDEA**: https://www.jetbrains.com/idea/download/
2. **Open the project**:
   - Open IntelliJ IDEA
   - Click "Open" and select the `CrudOperation` folder
   - Wait for the project to load and dependencies to download
3. **Run the application**:
   - Find `CrudOperationApplication.java` in the project explorer
   - Right-click on it and select "Run 'CrudOperationApplication'"
   - The application will start on http://localhost:8080

#### Eclipse (Free)
1. **Download Eclipse**: https://www.eclipse.org/downloads/
2. **Open the project**:
   - Open Eclipse
   - File → Import → Existing Maven Projects
   - Select the `CrudOperation` folder
3. **Run the application**:
   - Right-click on `CrudOperationApplication.java`
   - Run As → Java Application

### Option 2: Install Maven (Advanced)

#### Windows
1. **Download Maven**: https://maven.apache.org/download.cgi
2. **Extract** to `C:\Program Files\Apache\maven`
3. **Add to PATH**:
   - Open System Properties → Environment Variables
   - Add `C:\Program Files\Apache\maven\bin` to PATH
4. **Test**: Open Command Prompt and type `mvn -version`
5. **Run**: `mvn spring-boot:run`

#### Using Chocolatey (Windows)
```bash
choco install maven
```

#### Using Homebrew (Mac)
```bash
brew install maven
```

## 🗄 Database Setup

### 1. Run the SQL Script
Execute the `database_setup.sql` file in your MySQL client:

**MySQL Workbench:**
1. Open MySQL Workbench
2. Connect to your MySQL server (root/root)
3. File → Open SQL Script → Select `database_setup.sql`
4. Click the lightning bolt to execute

**phpMyAdmin:**
1. Open phpMyAdmin
2. Go to SQL tab
3. Copy and paste the contents of `database_setup.sql`
4. Click "Go"

**Command Line:**
```bash
mysql -u root -p < database_setup.sql
```

### 2. Verify Database
Check that the database `welder_fabrication` was created with tables:
- `Product` (sample products)
- `Contact` (sample contacts)

## 🔧 Configuration

The application is configured to use:
- **Database**: MySQL (`welder_fabrication`)
- **Username**: `root`
- **Password**: `root`
- **Port**: 8080

## 🎯 Testing the Application

### 1. Start the Application
Using your chosen method (IDE or Maven)

### 2. Test Basic Functionality
Visit these URLs to test:

- **Home Page**: http://localhost:8080/
- **Admin Panel**: http://localhost:8080/admin/products
- **Get Quote**: http://localhost:8080/cart

### 3. Expected Results
- **Home Page**: Should display available products
- **Admin Panel**: Should show product management interface
- **Get Quote**: Should show product selection and contact form

## 🐛 Troubleshooting

### Common Issues:

#### 1. "Maven not found" Error
- **Solution**: Use an IDE instead of command line
- **Alternative**: Install Maven following the guide above

#### 2. Database Connection Error
- **Check**: MySQL is running on port 3306
- **Verify**: Username `root` and password `root`
- **Test**: Try connecting with MySQL Workbench

#### 3. 500 Error on Pages
- **Check**: Database tables exist
- **Verify**: Sample data was inserted
- **Test**: Visit home page first to verify basic functionality

#### 4. Port 8080 Already in Use
- **Solution**: Change port in `application.properties`
- **Alternative**: Stop other applications using port 8080

### Error Messages:

#### "Table 'welder_fabrication.Product' doesn't exist"
- Run the SQL script again
- Check database name is correct

#### "Access denied for user 'root'@'localhost'"
- Verify MySQL credentials
- Check MySQL is running

#### "Could not create connection to database server"
- Ensure MySQL is started
- Check port 3306 is available

## 📞 Support

If you encounter issues:
1. Check the troubleshooting section above
2. Verify MySQL is running and accessible
3. Try the home page first: http://localhost:8080/
4. Check application logs for specific error messages

## 🎉 Success!

Once everything is working, you should be able to:
- ✅ View products on the home page
- ✅ Add/edit/delete products in admin panel
- ✅ Submit contact forms
- ✅ View contact submissions

The application is now ready for your welding and fabrication business! 🚀 