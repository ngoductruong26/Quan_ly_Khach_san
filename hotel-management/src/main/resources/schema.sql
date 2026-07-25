CREATE DATABASE IF NOT EXISTS quan_ly_khach_san;
USE quan_ly_khach_san
CREATE TABLE dich_vu (
                         dich_vu_id INT AUTO_INCREMENT PRIMARY KEY,
                         loai_dich_vu VARCHAR(100) NOT NULL,
                         gia_dich_vu DECIMAL(15,2) NOT NULL
);
CREATE TABLE khach_hang (
                            khach_hang_id INT AUTO_INCREMENT PRIMARY KEY,
                            ten_khach_hang VARCHAR(50) NOT NULL,
                            ho_khach_hang VARCHAR(50) NOT NULL,
                            dia_chi TEXT,
                            ngay_sinh DATE,
                            email VARCHAR(100)
);
CREATE TABLE nhan_vien (
                           nhan_vien_id INT AUTO_INCREMENT PRIMARY KEY,
                           ten_nhan_vien VARCHAR(50) NOT NULL,
                           ho_nhan_vien VARCHAR(50) NOT NULL,
                           dia_chi TEXT,
                           phong_ban VARCHAR(50),
                           chuc_vu VARCHAR(50),
                           ten_dang_nhap VARCHAR(50) UNIQUE,
                           mat_khau VARCHAR(255)
);

