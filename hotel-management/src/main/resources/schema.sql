CREATE DATABASE hotel_management
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE hotel_management;
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20),
    role ENUM('ADMIN','RECEPTIONIST') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    gender ENUM('Male','Female','Other'),
    date_of_birth DATE,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    identity_number VARCHAR(20) UNIQUE,
    address VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE room_types (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(50) NOT NULL,
    price DECIMAL(12,2) NOT NULL,
    capacity INT NOT NULL,
    description TEXT
);
CREATE TABLE rooms (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(10) UNIQUE NOT NULL,
    room_type_id BIGINT NOT NULL,
    floor INT,
    status ENUM('AVAILABLE','BOOKED','OCCUPIED','MAINTENANCE')
        DEFAULT 'AVAILABLE',
    description TEXT,

    CONSTRAINT fk_room_type
    FOREIGN KEY(room_type_id)
    REFERENCES room_types(id)
);
CREATE TABLE bookings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    customer_id BIGINT NOT NULL,

    room_id BIGINT NOT NULL,

    check_in DATE NOT NULL,

    check_out DATE NOT NULL,

    total_amount DECIMAL(12,2),

    status ENUM(
        'BOOKED',
        'CHECKED_IN',
        'CHECKED_OUT',
        'CANCELLED'
    ) DEFAULT 'BOOKED',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_booking_customer
        FOREIGN KEY(customer_id)
        REFERENCES customers(id),

    CONSTRAINT fk_booking_room
        FOREIGN KEY(room_id)
        REFERENCES rooms(id)
);
CREATE TABLE services (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    service_name VARCHAR(100) NOT NULL,

    price DECIMAL(12,2) NOT NULL,

    description TEXT
);
CREATE TABLE booking_services (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    booking_id BIGINT NOT NULL,

    service_id BIGINT NOT NULL,

    quantity INT DEFAULT 1,

    subtotal DECIMAL(12,2),

    CONSTRAINT fk_bs_booking
        FOREIGN KEY(booking_id)
        REFERENCES bookings(id),

    CONSTRAINT fk_bs_service
        FOREIGN KEY(service_id)
        REFERENCES services(id)
);
CREATE TABLE payments (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    booking_id BIGINT NOT NULL,

    payment_date DATETIME DEFAULT CURRENT_TIMESTAMP,

    payment_method ENUM(
        'CASH',
        'BANK_TRANSFER',
        'CREDIT_CARD',
        'MOMO'
    ),

    amount DECIMAL(12,2) NOT NULL,

    status ENUM(
        'PENDING',
        'PAID'
    ) DEFAULT 'PENDING',

    CONSTRAINT fk_payment_booking
        FOREIGN KEY(booking_id)
        REFERENCES bookings(id)
);
