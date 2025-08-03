# Welder & Fabrication Workshop

A Spring Boot web application for managing a welding and fabrication workshop's products/services and customer inquiries.

## 🎯 Features

### For Customers (Public)
- **Home Page**: Browse available products and services
- **Get Quote**: Select services and submit contact information
- **Responsive Design**: Mobile-friendly interface

### For Administrators
- **Product Management**: Add, edit, delete, and view products/services
- **Contact Management**: View and manage customer inquiries
- **Admin Dashboard**: Easy access to all management functions

## 🛠 Technology Stack

- **Backend**: Spring Boot 3.5.4, Java 21
- **Database**: H2 (in-memory for development)
- **Frontend**: Thymeleaf, Bootstrap 5, Font Awesome
- **Build Tool**: Maven
- **Dependencies**: Spring Data JPA, Spring Web, Lombok

## 🚀 Getting Started

### Prerequisites
- Java 21 or higher
- Maven 3.6 or higher

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd CrudOperation
   ```

2. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

3. **Access the application**
   - Main website: http://localhost:8080
   - Admin panel: http://localhost:8080/admin/products
   - H2 Database Console: http://localhost:8080/h2-console
     - JDBC URL: `jdbc:h2:mem:testdb`
     - Username: `sa`
     - Password: `password`

## 📋 Application Structure

```
src/main/java/com/example/CrudOperation/
├── Controller/
│   ├── ProductController.java    # Product management endpoints
│   └── ContactController.java    # Contact form handling
├── Service/
│   ├── ProductService.java       # Product business logic
│   └── ContactService.java       # Contact business logic
├── Repostaries/
│   ├── ProductRepo.java          # Product data access
│   └── ContactRepo.java          # Contact data access
├── Model/
│   ├── Product.java              # Product entity
│   └── Contact.java              # Contact entity
├── DataInitializer.java          # Sample data population
└── CrudOperationApplication.java # Main application class
```

## 🗄 Database Schema

### Product Table
- `id` (Primary Key)
- `name` (Product/Service name)
- `description` (Detailed description)
- `price` (Price in USD, nullable for "price on request")
- `category` (Welding, Gates, Grills, Fabrication, Repair, Custom)
- `imageUrl` (Optional image URL)
- `available` (Boolean availability status)

### Contact Table
- `id` (Primary Key)
- `name` (Customer name)
- `email` (Customer email)
- `phone` (Customer phone)
- `message` (Project details)
- `selectedProducts` (Comma-separated product IDs)
- `submittedAt` (Timestamp)
- `processed` (Boolean processing status)

## 🎨 User Interface

### Public Pages
1. **Home Page** (`/`)
   - Hero section with call-to-action
   - Product/service cards with categories
   - Features section highlighting workshop capabilities

2. **Quote Page** (`/cart`)
   - Product selection with checkboxes
   - Contact form (name, email, phone, message)
   - Real-time selected products display

### Admin Pages
1. **Products Management** (`/admin/products`)
   - Table view of all products
   - Add, edit, delete functionality
   - Link to contact submissions

2. **Add Product** (`/admin/products/add`)
   - Form for adding new products
   - Category dropdown
   - Price and availability options

3. **Edit Product** (`/admin/products/edit/{id}`)
   - Pre-populated form for editing
   - Same fields as add product

4. **Contact Submissions** (`/contact/admin/contacts`)
   - Table view of all submissions
   - Mark as processed functionality
   - View detailed contact information

## 🔧 Configuration

### Application Properties
- **Database**: H2 in-memory database
- **Port**: 8080
- **JPA**: Auto-create tables, show SQL
- **Thymeleaf**: Disabled cache for development

### Sample Data
The application automatically populates the database with sample products on first run:
- Welding services (Steel, Aluminum)
- Gates (Security, Driveway)
- Grills (Security, Decorative)
- Fabrication (Railings, Furniture)
- Repair services (Equipment, Structural)
- Custom work (Metal Art, Specialty)

## 📱 Features in Detail

### Product Management
- **CRUD Operations**: Full create, read, update, delete functionality
- **Categories**: Organized by service type
- **Pricing**: Support for fixed prices and "price on request"
- **Availability**: Toggle product availability

### Contact Form
- **Product Selection**: Checkbox-based product selection
- **Contact Information**: Name, email, phone, project details
- **Form Validation**: Required field validation
- **Success Feedback**: User-friendly success messages

### Admin Features
- **Contact Processing**: Mark inquiries as processed
- **Data Management**: View and manage all submissions
- **Product Catalog**: Complete product lifecycle management

## 🎯 Business Requirements Met

✅ **Product CRUD**: Full product management capabilities  
✅ **Home Page**: Displays available products/services  
✅ **Cart/Quote Page**: Product selection and contact form  
✅ **Contact Storage**: All submissions saved to database  
✅ **Admin Interface**: Complete management dashboard  
✅ **Responsive Design**: Mobile-friendly interface  
✅ **Simple Setup**: H2 database for easy deployment  

## 🔮 Future Enhancements

- User authentication and authorization
- Email notifications for new contacts
- Product image upload functionality
- Advanced search and filtering
- Quote generation and PDF export
- Payment integration
- Customer account management

## 📞 Support

For questions or issues, please contact the development team.

---

**Built with ❤️ using Spring Boot** 