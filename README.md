# Welder & Fabrication Workshop

A Spring Boot web application for managing a welding and fabrication workshop's products/services and customer inquiries.

## 🎯 Features

### For Customers (Public)
- **Home Page**: Browse available products and services with images
- **Search & Filter**: Search by name/description and filter by category
- **Get Quote**: Select services and submit contact information
- **Responsive Design**: Mobile-friendly interface

### For Administrators
- **Secure Login**: Admin authentication with username/password
- **Password Reset**: Forgot password functionality with token-based reset
- **Product Management**: Add, edit, delete, and view products/services
- **Advanced Search**: Search products by name/description and filter by category
- **Image Upload**: Upload product images directly from device or use URLs
- **Contact Management**: View detailed contact submissions with selected products
- **Admin Dashboard**: Easy access to all management functions

## 🛠 Technology Stack

- **Backend**: Spring Boot 3.5.4, Java 21
- **Database**: MySQL 8.0
- **Frontend**: Thymeleaf, Bootstrap 5, Font Awesome
- **Build Tool**: Maven
- **Dependencies**: Spring Data JPA, Spring Web, Lombok
- **File Upload**: Spring Multipart support with local storage

## 🚀 Getting Started

### Prerequisites
- Java 21 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher (optional - can use IDE or direct Java execution)

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd CrudOperation
   ```

2. **Database Setup**
   - Create MySQL database: `welder_fabrication`
   - Update `application.properties` with your MySQL credentials
   - Run the SQL script: `database_setup.sql`

3. **Run the application**
   
   **Option 1: Using Maven**
   ```bash
   mvn spring-boot:run
   ```
   
   **Option 2: Using IDE**
   - Open in IntelliJ IDEA or Eclipse
   - Run `CrudOperationApplication.java`
   
   **Option 3: Direct Java execution**
   ```bash
   # First build the JAR
   mvn clean package
   # Then run
   java -jar target/CrudOperation-0.0.1-SNAPSHOT.jar
   ```

4. **Access the application**
   - Main website: http://localhost:8080
   - Admin panel: http://localhost:8080/admin/products
   - Contact submissions: http://localhost:8080/contact/admin/contacts

## 📋 Application Structure

```
src/main/java/com/example/CrudOperation/
├── Controller/
│   ├── ProductController.java    # Product management endpoints
│   └── ContactController.java    # Contact form handling
├── Service/
│   ├── ProductService.java       # Product business logic
│   ├── ContactService.java       # Contact business logic
│   └── FileUploadService.java    # File upload handling
├── Repostaries/
│   ├── ProductRepo.java          # Product data access
│   └── ContactRepo.java          # Contact data access
├── Model/
│   ├── Product.java              # Product entity
│   └── Contact.java              # Contact entity
└── Config/
    └── WebConfig.java            # Static resource configuration
```

## 🖼️ File Upload Features

### Product Images
- **Direct Upload**: Admins can upload image files (JPG, PNG, GIF, WebP) directly from their device
- **URL Option**: Alternative option to use external image URLs
- **Automatic Storage**: Uploaded files are stored in the `uploads/` directory
- **Unique Naming**: Files are renamed with UUID to prevent conflicts
- **Preview**: Real-time image preview in admin forms
- **Cleanup**: Old images are automatically deleted when products are updated/deleted

### File Management
- **Max File Size**: 10MB per file
- **Supported Formats**: All common image formats
- **Storage Location**: `uploads/` directory in project root
- **URL Access**: Files accessible via `/uploads/filename`

## 📊 Database Schema

### Product Table
- `id` (Primary Key)
- `name` (Product/Service name)
- `description` (Detailed description)
- `price` (Price in Rupees)
- `category` (Welding, Gates, Grills, etc.)
- `imageUrl` (Image file path or URL)
- `available` (Boolean for availability)

### Contact Table
- `id` (Primary Key)
- `name` (Customer name)
- `email` (Customer email)
- `phone` (Customer phone)
- `message` (Project details)
- `selectedProducts` (Comma-separated product IDs)
- `submittedAt` (Submission timestamp)
- `processed` (Admin processing status)

## 🎨 UI Features

### Public Pages
- **Home Page**: Hero section with professional design, product cards with images
- **Search & Filter**: Advanced search by name/description with category filtering
- **Cart/Quote Page**: Interactive product selection with real-time updates and search
- **Responsive Design**: Works on all device sizes

### Admin Pages
- **Secure Login**: Professional login interface with authentication
- **Password Reset**: Token-based password reset with email-like flow
- **Product Management**: Full CRUD with image upload support and advanced search
- **Search Functionality**: Search products by name/description and filter by category
- **Contact Submissions**: Detailed view with selected products information
- **Status Management**: Mark contacts as processed
- **Image Preview**: Real-time preview for uploaded images
- **Session Management**: Secure logout and session handling

## 🔧 Configuration

### Application Properties
```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/welder_fabrication
<<<<<<< HEAD
spring.datasource.username=root
spring.datasource.password=root
=======
spring.datasource.username=
spring.datasource.password=
>>>>>>> cc3d822a5f5583006994759f9ca0331a6666b423

# File Upload
spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=10MB
app.upload.dir=uploads
```

### Admin Authentication
- **Default Admin**: username: `admin`, password: `admin123`
- **Password Reset**: Token-based reset with 24-hour expiry
- **Session Management**: Automatic session timeout and secure logout
- **Route Protection**: All admin routes require authentication

## 🚨 Troubleshooting

### Common Issues
1. **Maven not found**: Use IDE or direct Java execution
2. **Database connection**: Ensure MySQL is running and credentials are correct
3. **File upload errors**: Check `uploads/` directory permissions
4. **Image not displaying**: Verify file exists and URL is correct

### File Upload Issues
- Ensure `uploads/` directory has write permissions
- Check file size (max 10MB)
- Verify image format is supported
- Clear browser cache if images don't update

## 📝 License

<<<<<<< HEAD
This project is for educational and business use. 
=======
This project is for educational and business use. 
>>>>>>> cc3d822a5f5583006994759f9ca0331a6666b423
