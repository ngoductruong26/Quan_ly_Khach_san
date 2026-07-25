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
CREATE TABLE phong (
                       so_phong VARCHAR(20) PRIMARY KEY,
                       loai_phong VARCHAR(50),
                       mo_ta_phong TEXT,
                       gia_phong DECIMAL(15,2)
);
CREATE TABLE dat_phong (
                           dat_phong_id INT AUTO_INCREMENT PRIMARY KEY,

                           khach_hang_id INT,
                           so_phong VARCHAR(20),
                           nhan_vien_id INT,

                           ngay_dat DATETIME,
                           ngay_nhan_phong DATETIME,
                           ngay_tra_phong DATETIME,
                           so_ngay_o INT
);
CREATE TABLE thanh_toan (
                            thanh_toan_id INT AUTO_INCREMENT PRIMARY KEY,

                            dat_phong_id INT,

                            loai_thanh_toan VARCHAR(50),
                            ngay_thanh_toan DATETIME,
                            so_tien_thanh_toan DECIMAL(15,2),

                            so_the_tin_dung VARCHAR(20),
                            ngay_het_han_the DATE
);
ALTER TABLE dat_phong
    ADD CONSTRAINT fk_dp_khach_hang
        FOREIGN KEY (khach_hang_id)
            REFERENCES khach_hang(khach_hang_id);
ALTER TABLE dat_phong
    ADD CONSTRAINT fk_dp_phong
        FOREIGN KEY (so_phong)
            REFERENCES phong(so_phong);
ALTER TABLE dat_phong
    ADD CONSTRAINT fk_dp_nhan_vien
        FOREIGN KEY (nhan_vien_id)
            REFERENCES nhan_vien(nhan_vien_id);
ALTER TABLE thanh_toan
    ADD CONSTRAINT fk_tt_dat_phong
        FOREIGN KEY (dat_phong_id)
            REFERENCES dat_phong(dat_phong_id);
CREATE TABLE khach_hang_dich_vu (
                                     khach_hang_id INT,
                                    dich_vu_id INT,

                                    PRIMARY KEY(khach_hang_id,dich_vu_id),

                                    FOREIGN KEY(khach_hang_id)
                                        REFERENCES khach_hang(khach_hang_id),

                                    FOREIGN KEY(dich_vu_id)
                                        REFERENCES dich_vu(dich_vu_id)
);
CREATE TABLE nhan_vien_dich_vu (

                                   nhan_vien_id INT,
                                   dich_vu_id INT,

                                   PRIMARY KEY(nhan_vien_id,dich_vu_id),

                                   FOREIGN KEY(nhan_vien_id)
                                       REFERENCES nhan_vien(nhan_vien_id),

                                   FOREIGN KEY(dich_vu_id)
                                       REFERENCES dich_vu(dich_vu_id)
);