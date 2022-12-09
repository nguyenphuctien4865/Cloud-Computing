-- ----------------------------
-- Records of sinhvien
-- ----------------------------
BEGIN;
INSERT INTO `sinhvien` VALUES (20110573, 'Nguyen Phuc Tien','2001-09-22',1,1);
INSERT INTO `sinhvien` VALUES (20110111, 'Nguyen Minh Anh','2002-01-29',1,2);
INSERT INTO `sinhvien` VALUES (20110112, 'Tran Nhat Thai','2002-12-1',1,3);
INSERT INTO `sinhvien` VALUES (19110111, 'Le Hong Quan','2001-4-1',1,4);
INSERT INTO `sinhvien` VALUES (18110573, 'Nguyen Le My','2000-5-7',1,5);
INSERT INTO `sinhvien` VALUES (21110115, 'Bui Minh Khang','2003-6-12',1,6);
INSERT INTO `sinhvien` VALUES (22110555, 'Nguyen Tra Tien','2004-2-16',1,7);
COMMIT;

-- ----------------------------
-- Records of khoa
-- ----------------------------
BEGIN;
INSERT INTO `khoa` (`tenKhoa`) VALUES ("Công nghệ thông tin");
INSERT INTO `khoa` (`tenKhoa`) VALUES ("Cơ khí");
INSERT INTO `khoa` (`tenKhoa`) VALUES ("Điện-Điện tử");
INSERT INTO `khoa` (`tenKhoa`) VALUES ("Kinh tế");
INSERT INTO `khoa` (`tenKhoa`) VALUES ("Xây dựng");
INSERT INTO `khoa` (`tenKhoa`) VALUES ("Công nghệ thực phẩm");
INSERT INTO `khoa` (`tenKhoa`) VALUES ("Khoa học ứng dụng");
INSERT INTO `khoa` (`tenKhoa`) VALUES ("Viện sư phạm kỹ thuật");
COMMIT;

-- ----------------------------
-- Records of khoa
-- ----------------------------
BEGIN;
INSERT INTO `giangvien`  VALUES ("CNTT01","Nguyen Minh A","1985-10-2",1,"CH");
INSERT INTO `giangvien`  VALUES ("CNTT02","Le Minh T","1980-6-22",1,"TG");
INSERT INTO `giangvien`  VALUES ("CK01","Tran Nhut A","1981-10-2",2,"CH");
INSERT INTO `giangvien`  VALUES ("XD22","Le Thi Thuy D","1988-3-2",5,"TG");
INSERT INTO `giangvien`  VALUES ("VSP01","DƯƠNG THỊ KIM OANH","1976-09-21",8,"CH");
INSERT INTO `giangvien`  VALUES ("CNTT03","Tran Le Minh","1980-6-22",1,"TG");
INSERT INTO `giangvien`  VALUES ("CNTT04","Truong Quynh Chi","1985-4-2",1,"CH");
INSERT INTO `giangvien`  VALUES ("CNTT05","Nguyen Duc Dung","1982-7-9",1,"TG");
COMMIT;

-- ----------------------------
-- Records of sinhvien
-- ----------------------------
BEGIN;
INSERT INTO `account`(`username`,`password`,`type`) VALUES ("20110573","123","student");
INSERT INTO `account`(`username`,`password`,`type`)VALUES ("20110111","123","student");
INSERT INTO `account`(`username`,`password`,`type`) VALUES ("20110112","123","student");
INSERT INTO `account`(`username`,`password`,`type`) VALUES ("19110111","123","student");
INSERT INTO `account`(`username`,`password`,`type`) VALUES ("18110573","123","student");
INSERT INTO `account`(`username`,`password`,`type`) VALUES ("21110115","123","student");
INSERT INTO `account`(`username`,`password`,`type`) VALUES ("22110555","123","student");
INSERT INTO `account`(`username`,`password`,`type`) VALUES ("admin","admin","admin");
COMMIT;

-- ----------------------------
-- Records of monhoc
-- ----------------------------
BEGIN;
INSERT INTO `monhoc` VALUES ("CNTT01","Nhập môn ngành CNTT","BB",3,1);
INSERT INTO `monhoc` VALUES ("NMLT01","Nhập môn lập trình","BB",3,1);
INSERT INTO `monhoc` VALUES ("MATH01","Đại số tuyến tính và cấu trúc đại số","BB",3,1);
INSERT INTO `monhoc` VALUES ("TDHT01","Tư duy hệ thống","TC",3,8);
INSERT INTO `monhoc` VALUES ("KTLT01","Kỹ thuật lập trình","BB",3,1);
INSERT INTO `monhoc` VALUES ("CTDL01","Cấu trúc dữ liệu và giải thuật","BB",3,1);
INSERT INTO `monhoc` VALUES ("CSDL01","Cơ sở dữ liệu","BB",3,1);
INSERT INTO `monhoc` VALUES ("OPSY01","OPSY330280","BB",3,1);
INSERT INTO `monhoc` VALUES ("ENPS01","Tâm lý học kỹ sư","TC",3,1);
COMMIT;

-- ----------------------------
-- Records of sinhvien
-- ----------------------------
BEGIN;
INSERT INTO `daymon` VALUES ("CNTT01","CNTT03");
INSERT INTO `daymon` VALUES ("NMLT01","CNTT05");
INSERT INTO `daymon` VALUES ("MATH01","CNTT03");
INSERT INTO `daymon` VALUES ("NMLT01","CNTT02");
INSERT INTO `daymon` VALUES ("MATH01","CNTT04");
INSERT INTO `daymon` VALUES ("CTDL01","CNTT04");
INSERT INTO `daymon` VALUES ("OPSY01","CNTT01");
INSERT INTO `daymon` VALUES ("CTDL01","CNTT01");
COMMIT;