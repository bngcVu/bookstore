-- Flyway V1 baseline schema for bookstore v5
-- Lưu ý: Không tạo DATABASE/USE ở đây. Bảng đặt tên UPPERCASE để khớp mapping JPA

-- ROLES
CREATE TABLE IF NOT EXISTS ROLES (
    role_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(100) NOT NULL UNIQUE
);

-- PERMISSIONS
CREATE TABLE IF NOT EXISTS PERMISSIONS (
    permission_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    permission_name VARCHAR(150) NOT NULL UNIQUE
);

-- ROLE_PERMISSIONS (join table)
CREATE TABLE IF NOT EXISTS ROLE_PERMISSIONS (
    role_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    PRIMARY KEY (role_id, permission_id),
    CONSTRAINT fk_rp_role FOREIGN KEY (role_id) REFERENCES ROLES(role_id),
    CONSTRAINT fk_rp_perm FOREIGN KEY (permission_id) REFERENCES PERMISSIONS(permission_id)
);

-- USERS
CREATE TABLE IF NOT EXISTS USERS (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    full_name VARCHAR(150),
    date_of_birth DATE,
    gender VARCHAR(20),
    phone_number VARCHAR(50),
    avatar_url VARCHAR(500),
    status VARCHAR(50) DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    role_id BIGINT,
    CONSTRAINT fk_users_role FOREIGN KEY (role_id) REFERENCES ROLES(role_id)
);

-- USER_ADDRESSES
CREATE TABLE IF NOT EXISTS USER_ADDRESSES (
    address_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    recipient_name VARCHAR(150) NOT NULL,
    phone_number VARCHAR(50),
    address_line VARCHAR(255) NOT NULL,
    city VARCHAR(100),
    province VARCHAR(100),
    postal_code VARCHAR(20),
    is_default BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_addr_user FOREIGN KEY (user_id) REFERENCES USERS(user_id)
);

-- AUTHORS
CREATE TABLE IF NOT EXISTS AUTHORS (
    author_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- CATEGORIES
CREATE TABLE IF NOT EXISTS CATEGORIES (
    category_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- PUBLISHERS
CREATE TABLE IF NOT EXISTS PUBLISHERS (
    publisher_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- BOOKS
CREATE TABLE IF NOT EXISTS BOOKS (
    book_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(15,2) NOT NULL,
    stock_quantity INT NOT NULL DEFAULT 0,
    author_id BIGINT,
    category_id BIGINT,
    publisher_id BIGINT,
    CONSTRAINT fk_books_author FOREIGN KEY (author_id) REFERENCES AUTHORS(author_id),
    CONSTRAINT fk_books_category FOREIGN KEY (category_id) REFERENCES CATEGORIES(category_id),
    CONSTRAINT fk_books_publisher FOREIGN KEY (publisher_id) REFERENCES PUBLISHERS(publisher_id)
);

-- BOOK_IMAGES
CREATE TABLE IF NOT EXISTS BOOK_IMAGES (
    image_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    book_id BIGINT NOT NULL,
    image_url VARCHAR(1000) NOT NULL,
    CONSTRAINT fk_images_book FOREIGN KEY (book_id) REFERENCES BOOKS(book_id)
);

-- CARTS
CREATE TABLE IF NOT EXISTS CARTS (
    cart_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_carts_user FOREIGN KEY (user_id) REFERENCES USERS(user_id)
);

-- CART_ITEMS
CREATE TABLE IF NOT EXISTS CART_ITEMS (
    cart_item_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cart_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    CONSTRAINT fk_cartitems_cart FOREIGN KEY (cart_id) REFERENCES CARTS(cart_id),
    CONSTRAINT fk_cartitems_book FOREIGN KEY (book_id) REFERENCES BOOKS(book_id)
);

-- ORDERS
CREATE TABLE IF NOT EXISTS ORDERS (
    order_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    total_amount DECIMAL(15,2) NOT NULL,
    CONSTRAINT fk_orders_user FOREIGN KEY (user_id) REFERENCES USERS(user_id)
);

-- ORDER_DETAILS
CREATE TABLE IF NOT EXISTS ORDER_DETAILS (
    order_detail_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(15,2) NOT NULL,
    CONSTRAINT fk_orderdetails_order FOREIGN KEY (order_id) REFERENCES ORDERS(order_id),
    CONSTRAINT fk_orderdetails_book FOREIGN KEY (book_id) REFERENCES BOOKS(book_id)
);

-- REVIEWS
CREATE TABLE IF NOT EXISTS REVIEWS (
    review_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    rating INT NOT NULL,
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_reviews_user FOREIGN KEY (user_id) REFERENCES USERS(user_id),
    CONSTRAINT fk_reviews_book FOREIGN KEY (book_id) REFERENCES BOOKS(book_id)
);

-- PROMOTIONS
CREATE TABLE IF NOT EXISTS PROMOTIONS (
    promotion_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    discount_percent DECIMAL(5,2) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);

-- BOOK_PROMOTIONS (join table)
CREATE TABLE IF NOT EXISTS BOOK_PROMOTIONS (
    book_id BIGINT NOT NULL,
    promotion_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, promotion_id),
    CONSTRAINT fk_bp_book FOREIGN KEY (book_id) REFERENCES BOOKS(book_id),
    CONSTRAINT fk_bp_promo FOREIGN KEY (promotion_id) REFERENCES PROMOTIONS(promotion_id)
);

-- NOTIFICATIONS
CREATE TABLE IF NOT EXISTS NOTIFICATIONS (
    notification_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    message TEXT NOT NULL,
    is_read BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_notifications_user FOREIGN KEY (user_id) REFERENCES USERS(user_id)
);

-- INVENTORY_LOGS
CREATE TABLE IF NOT EXISTS INVENTORY_LOGS (
    log_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    book_id BIGINT NOT NULL,
    change_type VARCHAR(50) NOT NULL,
    quantity_change INT NOT NULL,
    created_by VARCHAR(150),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_inventory_book FOREIGN KEY (book_id) REFERENCES BOOKS(book_id)
);

-- Indexes for performance
CREATE INDEX idx_users_role ON USERS(role_id);
CREATE INDEX idx_books_author ON BOOKS(author_id);
CREATE INDEX idx_books_category ON BOOKS(category_id);
CREATE INDEX idx_books_publisher ON BOOKS(publisher_id);
CREATE INDEX idx_cartitems_cart ON CART_ITEMS(cart_id);
CREATE INDEX idx_cartitems_book ON CART_ITEMS(book_id);
CREATE INDEX idx_orderdetails_order ON ORDER_DETAILS(order_id);
CREATE INDEX idx_orderdetails_book ON ORDER_DETAILS(book_id);
CREATE INDEX idx_reviews_user ON REVIEWS(user_id);
CREATE INDEX idx_reviews_book ON REVIEWS(book_id);
CREATE INDEX idx_notifications_user ON NOTIFICATIONS(user_id);
CREATE INDEX idx_inventory_book ON INVENTORY_LOGS(book_id);
