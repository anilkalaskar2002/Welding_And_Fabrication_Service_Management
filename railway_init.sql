-- Railway Database Initialization
USE railway;

-- Create tables
CREATE TABLE IF NOT EXISTS Admin (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    reset_token VARCHAR(255),
    reset_token_expiry DATETIME,
    last_login DATETIME,
    active BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS Product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10,2),
    category VARCHAR(100),
    imageUrl VARCHAR(500),
    available BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS Contact (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    message TEXT,
    selectedProducts VARCHAR(1000),
    submittedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    processed BOOLEAN DEFAULT FALSE
);

-- Insert default admin
INSERT INTO Admin (username, password, active) VALUES ('admin', 'admin123', TRUE);

-- Insert sample products
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