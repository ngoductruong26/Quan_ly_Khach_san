CREATE DATABASE IF NOT EXISTS quan_ly_khach_san;

USE quan_ly_khach_san;

-- =========================
-- DROP OLD INCOMPATIBLE TABLES IF THEY EXIST
-- =========================
DROP TABLE IF EXISTS payments;
DROP TABLE IF EXISTS booking_services;
DROP TABLE IF EXISTS bookings;
DROP TABLE IF EXISTS hotel_services;
DROP TABLE IF EXISTS services;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS rooms;
DROP TABLE IF EXISTS room_types;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS employees;

-- =========================
-- 1. NGƯỜI DÙNG (USERS)
-- =========================
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- =========================
-- 2. LOẠI PHÒNG (ROOM_TYPES)
-- =========================
CREATE TABLE room_types (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL,
    capacity INT NOT NULL,
    description TEXT
);

-- =========================
-- 3. PHÒNG (ROOMS)
-- =========================
CREATE TABLE rooms (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(20) NOT NULL UNIQUE,
    floor VARCHAR(20),
    status VARCHAR(50),
    room_type_id BIGINT,
    CONSTRAINT fk_rooms_room_type
        FOREIGN KEY (room_type_id) REFERENCES room_types(id)
        ON DELETE SET NULL
);

-- =========================
-- 4. KHÁCH HÀNG (CUSTOMERS)
-- =========================
CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL,
    address TEXT,
    identity_number VARCHAR(50) NOT NULL
);

-- =========================
-- 5. DỊCH VỤ (HOTEL_SERVICES)
-- =========================
CREATE TABLE hotel_services (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(100) NOT NULL,
    price DECIMAL(15,2) NOT NULL,
    description TEXT
);

-- =========================
-- 6. ĐẶT PHÒNG (BOOKINGS)
-- =========================
CREATE TABLE bookings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    check_in_date DATE,
    check_out_date DATE,
    number_of_guests INT,
    status VARCHAR(50),
    customer_id BIGINT,
    room_id BIGINT,
    CONSTRAINT fk_booking_customer
        FOREIGN KEY (customer_id) REFERENCES customers(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_booking_room
        FOREIGN KEY (room_id) REFERENCES rooms(id)
        ON DELETE CASCADE
);

-- =========================
-- 7. CHI TIẾT DỊCH VỤ ĐẶT PHÒNG (BOOKING_SERVICES)
-- =========================
CREATE TABLE booking_services (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    quantity INT,
    booking_id BIGINT,
    service_id BIGINT,
    CONSTRAINT fk_bs_booking
        FOREIGN KEY (booking_id) REFERENCES bookings(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_bs_service
        FOREIGN KEY (service_id) REFERENCES hotel_services(id)
        ON DELETE CASCADE
);

-- =========================
-- 8. THANH TOÁN (PAYMENTS)
-- =========================
CREATE TABLE payments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(15,2),
    payment_method VARCHAR(50),
    payment_date DATE,
    payment_status VARCHAR(50),
    booking_id BIGINT UNIQUE,
    CONSTRAINT fk_payment_booking
        FOREIGN KEY (booking_id) REFERENCES bookings(id)
        ON DELETE CASCADE
);

-- =========================
-- SAMPLE DATA
-- =========================
-- USERS
INSERT INTO users (username, password, full_name, role) VALUES
     ('admin', '123456', 'Quản Trị Viên', 'ADMIN'),
        ('receptionist', '123456', 'Lễ Tân', 'RECEPTIONIST'),
        ('manager', '123456', 'Nguyễn Minh Quản', 'MANAGER'),
        ('staff01', '123456', 'Lê Văn Hải', 'STAFF'),
        ('staff02', '123456', 'Phạm Thanh Tùng', 'STAFF');

-- ROOM TYPES
INSERT INTO room_types (type_name, price, capacity, description) VALUES
        ('Phòng Đơn Tiêu Chuẩn', 300000, 1, 'Phòng 1 giường đơn đầy đủ tiện nghi'),
        ('Phòng Đơn VIP', 450000, 1, 'Phòng đơn cao cấp'),
        ('Phòng Đôi Tiêu Chuẩn', 500000, 2, 'Phòng đôi đầy đủ tiện nghi'),
        ('Phòng Đôi VIP', 600000, 2, 'Phòng đôi cao cấp view biển'),
        ('Phòng Gia Đình', 900000, 4, 'Phòng dành cho gia đình'),
        ('Suite Tổng Thống', 2500000, 6, 'Phòng cao cấp nhất của khách sạn');

-- ROOMS
INSERT INTO rooms (room_number, floor, status, room_type_id) VALUES
        ('101', 'Tầng 1', 'AVAILABLE', 1),
        ('102', 'Tầng 1', 'AVAILABLE', 1),
        ('103', 'Tầng 1', 'AVAILABLE', 2),
        ('104', 'Tầng 1', 'MAINTENANCE', 2),
        ('105', 'Tầng 1', 'AVAILABLE', 3),

        ('201', 'Tầng 2', 'OCCUPIED', 4),
        ('202', 'Tầng 2', 'AVAILABLE', 4),
        ('203', 'Tầng 2', 'OCCUPIED', 3),
        ('204', 'Tầng 2', 'AVAILABLE', 5),
        ('205', 'Tầng 2', 'AVAILABLE', 5),

        ('301', 'Tầng 3', 'AVAILABLE', 6),
        ('302', 'Tầng 3', 'AVAILABLE', 6),
        ('303', 'Tầng 3', 'OCCUPIED', 6),
        ('304', 'Tầng 3', 'AVAILABLE', 5),
        ('305', 'Tầng 3', 'AVAILABLE', 5),

        ('401', 'Tầng 4', 'AVAILABLE', 6),
        ('402', 'Tầng 4', 'AVAILABLE', 6),
        ('403', 'Tầng 4', 'AVAILABLE', 5),
        ('404', 'Tầng 4', 'MAINTENANCE', 3),
        ('405', 'Tầng 4', 'AVAILABLE', 2);

-- CUSTOMERS
INSERT INTO customers (full_name, email, phone, address, identity_number) VALUES
         ('Nguyễn Văn A', 'nguyenvana@gmail.com', '0901234567', 'Hà Nội', '001099123456'),
         ('Trần Thị B', 'tranthib@gmail.com', '0987654321', 'TP Hồ Chí Minh', '079099654321'),
         ('Lê Văn C', 'c@gmail.com', '0901111111', 'Đà Nẵng', '111111111111'),
         ('Phạm Thị D', 'd@gmail.com', '0902222222', 'Huế', '222222222222'),
         ('Hoàng Văn E', 'e@gmail.com', '0903333333', 'Cần Thơ', '333333333333'),
         ('Đỗ Thị F', 'f@gmail.com', '0904444444', 'Nghệ An', '444444444444'),
         ('Nguyễn Văn G', 'g@gmail.com', '0905555555', 'Quảng Nam', '555555555555'),
         ('Lý Văn H', 'h@gmail.com', '0906666666', 'Hải Phòng', '666666666666'),
         ('Trần Văn I', 'i@gmail.com', '0907777777', 'Hà Nội', '777777777777'),
         ('Mai Thị K', 'k@gmail.com', '0908888888', 'TP Hồ Chí Minh', '888888888888');

-- HOTEL SERVICES
INSERT INTO hotel_services (service_name, price, description) VALUES
      ('Giặt ủi quần áo', 50000, 'Dịch vụ giặt ủi nhanh'),
        ('Nước suối chai', 15000, 'Nước suối 500ml'),
       ('Ăn sáng buffet', 100000, 'Buffet sáng'),
       ('Đưa đón sân bay', 300000, 'Xe đưa đón sân bay'),
       ('Spa', 500000, 'Massage thư giãn'),
       ('Thuê xe máy', 200000, 'Thuê theo ngày'),
        ('Karaoke', 250000, 'Giải trí karaoke'),
        ('Giặt khô', 80000, 'Giặt khô quần áo'),
        ('Ăn trưa buffet', 180000, 'Buffet trưa'),
        ('Ăn tối buffet', 250000, 'Buffet tối');

-- BOOKINGS
INSERT INTO bookings
(check_in_date, check_out_date, number_of_guests, status, customer_id, room_id)
VALUES
    ('2026-08-01','2026-08-03',2,'CONFIRMED',1,6),
    ('2026-08-02','2026-08-04',1,'CHECKED_IN',2,2),
    ('2026-08-05','2026-08-08',2,'CONFIRMED',3,5),
    ('2026-08-10','2026-08-12',4,'CONFIRMED',4,9),
    ('2026-08-15','2026-08-18',2,'CHECKED_OUT',5,10),
    ('2026-08-20','2026-08-25',6,'CONFIRMED',6,11),
    ('2026-08-21','2026-08-23',2,'CANCELLED',7,15),
    ('2026-08-22','2026-08-24',1,'CHECKED_IN',8,16),
    ('2026-08-25','2026-08-28',2,'CONFIRMED',9,18),
    ('2026-08-28','2026-08-30',4,'CONFIRMED',10,20);

-- BOOKING SERVICES
INSERT INTO booking_services (quantity, booking_id, service_id) VALUES
    (2,1,2),
    (1,1,3),
    (1,2,1),
    (2,2,5),
    (3,3,8),
    (1,4,4),
    (2,5,6),
     (2,6,10),
     (4,7,7),
     (1,8,5),
     (2,9,3),
     (3,10,9);

-- PAYMENTS
INSERT INTO payments
(amount, payment_method, payment_date, payment_status, booking_id)
VALUES
    (1330000,'CASH','2026-08-01','PAID',1),
    (350000,'CASH','2026-08-02','PAID',2),
    (1200000,'BANKING','2026-08-05','PAID',3),
    (1800000,'CARD','2026-08-10','PAID',4),
    (2200000,'BANKING','2026-08-15','PAID',5),
    (5200000,'BANKING','2026-08-20','UNPAID',6),
    (400000,'CASH','2026-08-22','PAID',8),
    (1700000,'CARD','2026-08-25','PAID',9),
    (2600000,'BANKING','2026-08-28','UNPAID',10);