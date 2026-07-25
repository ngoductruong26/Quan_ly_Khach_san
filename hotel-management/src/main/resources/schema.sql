CREATE DATABASE IF NOT EXISTS quan_ly_khach_san;
USE quan_ly_khach_san
CREATE TABLE dich_vu (
                         dich_vu_id INT AUTO_INCREMENT PRIMARY KEY,
                         loai_dich_vu VARCHAR(100) NOT NULL,
                         gia_dich_vu DECIMAL(15,2) NOT NULL
);