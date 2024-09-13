CREATE TABLE app_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);




-- Create the product table
CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(19, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);

-- Insert initial data into product table
INSERT INTO product (name, price) VALUES
    ('Laptop', 799.99),
    ('Smartphone', 499.99),
    ('Tablet', 299.99),
    ('Headphones', 89.99),
    ('Smartwatch', 149.99),
    ('Camera', 599.99),
    ('Keyboard', 49.99),
    ('Mouse', 29.99),
    ('Monitor', 199.99),
    ('Printer', 129.99);
-- Create the cart table
CREATE TABLE cart (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL
);

-- Create the orders table
CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    total_amount DECIMAL(19, 2) NOT NULL,
    status VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);

-- No need to create the order_items table separately, as it's used as a class representation. Instead, you can store order items in a different way if required, or use an existing table like `order_items` to hold such data.
    CREATE TABLE order_item (
    product_id BIGINT PRIMARY KEY,
    quantity INT NOT NULL
);
    CREATE TABLE inventory (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    location VARCHAR(255),
    last_updated TIMESTAMP NOT NULL
);
    
 