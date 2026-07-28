CREATE DATABASE IF NOT EXISTS quan_ly_khach_san;

USE quan_ly_khach_san;


-- =========================
-- LOẠI PHÒNG
-- =========================

CREATE TABLE IF NOT EXISTS room_types (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    description TEXT,
    price DECIMAL(15,2)
    );



-- =========================
-- PHÒNG
-- =========================

CREATE TABLE IF NOT EXISTS rooms (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    room_number VARCHAR(20) NOT NULL UNIQUE,

    floor VARCHAR(20),

    status VARCHAR(50),

    room_type_id BIGINT,

    CONSTRAINT fk_rooms_room_type
    FOREIGN KEY(room_type_id)
    REFERENCES room_types(id)

    );



-- =========================
-- KHÁCH HÀNG
-- =========================

CREATE TABLE IF NOT EXISTS customers (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    first_name VARCHAR(50),

    last_name VARCHAR(50),

    address TEXT,

    birth_date DATE,

    email VARCHAR(100)

    );



-- =========================
-- NHÂN VIÊN
-- =========================

CREATE TABLE IF NOT EXISTS employees (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

     first_name VARCHAR(50),

    last_name VARCHAR(50),

    address TEXT,

    department VARCHAR(50),

    position VARCHAR(50),

    username VARCHAR(50) UNIQUE,

    password VARCHAR(255)

    );



-- =========================
-- ĐẶT PHÒNG
-- =========================

CREATE TABLE IF NOT EXISTS bookings (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT,
    room_id BIGINT,
    employee_id BIGINT,
    booking_date DATETIME,
    check_in DATETIME,
    check_out DATETIME,
    total_days INT,


     CONSTRAINT fk_booking_customer
    FOREIGN KEY(customer_id)
    REFERENCES customers(id),
    CONSTRAINT fk_booking_room
    FOREIGN KEY(room_id)
    REFERENCES rooms(id),

    CONSTRAINT fk_booking_employee
    FOREIGN KEY(employee_id)
    REFERENCES employees(id)

    );



-- =========================
-- DỊCH VỤ
-- =========================

CREATE TABLE IF NOT EXISTS services (

   id BIGINT AUTO_INCREMENT PRIMARY KEY,
     service_name VARCHAR(100),
    price DECIMAL(15,2)

    );



-- =========================
-- THANH TOÁN
-- =========================

CREATE TABLE IF NOT EXISTS payments (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT,
    payment_type VARCHAR(50),
    payment_date DATETIME,
    amount DECIMAL(15,2),


    CONSTRAINT fk_payment_booking
    FOREIGN KEY(booking_id)
    REFERENCES bookings(id)

    );



-- =========================
-- DATA SAMPLE
-- =========================


INSERT INTO room_types(name, description, price)
VALUES
    ('Phòng đơn','Phòng tiêu chuẩn',300000);



INSERT INTO rooms(room_number,floor,status,room_type_id)
VALUES
    ('101','1','AVAILABLE',1);



INSERT INTO customers(first_name,last_name,email)
VALUES
    ('Nguyen','Van A','a@gmail.com');



INSERT INTO employees(first_name,last_name,username,password)
VALUES
    ('Admin','Hotel','admin','123456');
