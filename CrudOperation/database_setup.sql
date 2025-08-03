-- Welder & Fabrication Workshop Database Setup
-- Run this script in MySQL to set up the database and sample data

-- Create database (if not exists)
CREATE DATABASE IF NOT EXISTS welder_fabrication;
USE welder_fabrication;

-- Drop tables if they exist (for clean setup)
DROP TABLE IF EXISTS Contact;
DROP TABLE IF EXISTS Product;

-- Create Product table
CREATE TABLE Product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10,2),
    category VARCHAR(100),
    imageUrl VARCHAR(500),
    available BOOLEAN DEFAULT TRUE
);

-- Create Contact table
CREATE TABLE Contact (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    message TEXT,
    selectedProducts VARCHAR(1000),
    submittedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    processed BOOLEAN DEFAULT FALSE
);

-- Insert sample products (prices in Rupees)
INSERT INTO Product (name, description, price, category, available) VALUES
('Steel Welding', 'Professional steel welding services for structural components, machinery repairs, and custom fabrication projects.', 5625.00, 'Welding', TRUE),
('Aluminum Welding', 'Specialized aluminum welding for automotive parts, marine equipment, and lightweight structures.', 6375.00, 'Welding', TRUE),
('Security Gate', 'Custom security gates made from high-quality steel with various locking mechanisms and finishes.', 33750.00, 'Gates', TRUE),
('Driveway Gate', 'Automated driveway gates with remote control operation, perfect for residential and commercial properties.', 90000.00, 'Gates', TRUE),
('Security Grill', 'Window and door security grills with decorative patterns, available in various sizes and designs.', 13500.00, 'Grills', TRUE),
('Decorative Grill', 'Ornamental grills for balconies, staircases, and architectural features with custom designs.', 18750.00, 'Grills', TRUE),
('Custom Railing', 'Custom metal railings for stairs, balconies, and decks with various styles and finishes.', 26250.00, 'Fabrication', TRUE),
('Metal Furniture', 'Custom metal furniture including tables, chairs, and outdoor furniture with powder coating.', 21000.00, 'Fabrication', TRUE),
('Equipment Repair', 'Repair and maintenance services for industrial equipment, machinery, and tools.', 4875.00, 'Repair', TRUE),
('Structural Repair', 'Structural steel repairs for buildings, bridges, and industrial structures.', 7125.00, 'Repair', TRUE),
('Custom Metal Art', 'Custom metal artwork and sculptures for residential and commercial spaces.', NULL, 'Custom', TRUE),
('Specialty Fabrication', 'Specialty metal fabrication for unique projects and custom requirements.', NULL, 'Custom', TRUE);

-- Insert sample contact submissions (optional)
INSERT INTO Contact (name, email, phone, message, selectedProducts, processed) VALUES
('John Smith', 'john.smith@email.com', '+91-98765-43210', 'I need a security gate for my property. Can you provide a quote?', '3', FALSE),
('Sarah Johnson', 'sarah.j@email.com', '+91-98765-43211', 'Looking for custom metal furniture for my outdoor patio.', '8', FALSE),
('Mike Wilson', 'mike.wilson@email.com', '+91-98765-43212', 'Need aluminum welding for my boat trailer. Urgent repair needed.', '2', TRUE);

-- Create indexes for better performance
CREATE INDEX idx_product_category ON Product(category);
CREATE INDEX idx_product_available ON Product(available);
CREATE INDEX idx_contact_submitted_at ON Contact(submittedAt);
CREATE INDEX idx_contact_processed ON Contact(processed);

-- Show the created data
SELECT 'Products:' as info;
SELECT id, name, category, price, available FROM Product;

SELECT 'Contacts:' as info;
SELECT id, name, email, phone, processed, submittedAt FROM Contact;

-- Grant permissions (if needed)
-- GRANT ALL PRIVILEGES ON welder_fabrication.* TO 'root'@'localhost';
-- FLUSH PRIVILEGES; 