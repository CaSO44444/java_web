/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50739 (5.7.39)
 Source Host           : localhost:3306
 Source Schema         : mojocebe

 Target Server Type    : MySQL
 Target Server Version : 50739 (5.7.39)
 File Encoding         : 65001

 Date: 25/04/2023 19:18:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consultation
-- ----------------------------
DROP TABLE IF EXISTS `consultation`;
CREATE TABLE `consultation` (
                                `consultation_id` int(11) NOT NULL AUTO_INCREMENT,
                                `type` varchar(50) DEFAULT NULL,
                                `con_num` int(11) DEFAULT NULL,
                                `patient` int(11) DEFAULT NULL,
                                `dept` int(11) DEFAULT NULL,
                                `bed_num` int(11) DEFAULT NULL,
                                `doctor` int(11) DEFAULT NULL,
                                `money` float(255,0) DEFAULT NULL,
                                `time` date DEFAULT NULL,
                                `medicine` int(11) DEFAULT NULL,
                                `pay` int(11) DEFAULT NULL,
                                `status` int(11) DEFAULT NULL,
                                PRIMARY KEY (`consultation_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of consultation
-- ----------------------------
BEGIN;
INSERT INTO `consultation` (`consultation_id`, `type`, `con_num`, `patient`, `dept`, `bed_num`, `doctor`, `money`, `time`, `medicine`, `pay`, `status`) VALUES (1, '门诊', 20231122, 1, 1, 81, 1, 1555, '16:27:32', 1, 1, 0);
INSERT INTO `consultation` (`consultation_id`, `type`, `con_num`, `patient`, `dept`, `bed_num`, `doctor`, `money`, `time`, `medicine`, `pay`, `status`) VALUES (2, '门诊', 20030314, 2, 2, 24, 2, 2345, '09:38:49', 1, 1, 0);
INSERT INTO `consultation` (`consultation_id`, `type`, `con_num`, `patient`, `dept`, `bed_num`, `doctor`, `money`, `time`, `medicine`, `pay`, `status`) VALUES (3, '急诊', 2022222, 3, 3, 1, 2, 122, '09:49:50', 3, 1, 0);
INSERT INTO `consultation` (`consultation_id`, `type`, `con_num`, `patient`, `dept`, `bed_num`, `doctor`, `money`, `time`, `medicine`, `pay`, `status`) VALUES (4, '急诊', 20323232, 4, 2, 1, 1, 33, '09:49:52', 2, 1, 0);
INSERT INTO `consultation` (`consultation_id`, `type`, `con_num`, `patient`, `dept`, `bed_num`, `doctor`, `money`, `time`, `medicine`, `pay`, `status`) VALUES (5, '门诊', 2032332, 5, 1, 1, 1, 27, '10:49:55', 1, 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
                        `dept_id` int(11) NOT NULL AUTO_INCREMENT,
                        `dept_name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dept
-- ----------------------------
BEGIN;
INSERT INTO `dept` (`dept_id`, `dept_name`) VALUES (1, '外科');
INSERT INTO `dept` (`dept_id`, `dept_name`) VALUES (2, '儿科');
INSERT INTO `dept` (`dept_id`, `dept_name`) VALUES (3, '精神科');
INSERT INTO `dept` (`dept_id`, `dept_name`) VALUES (4, '骨科');
INSERT INTO `dept` (`dept_id`, `dept_name`) VALUES (5, '妇科');
COMMIT;

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
                          `doctor_id` int(11) NOT NULL AUTO_INCREMENT,
                          `doctor_name` varchar(50) DEFAULT NULL,
                          PRIMARY KEY (`doctor_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of doctor
-- ----------------------------
BEGIN;
INSERT INTO `doctor` (`doctor_id`, `doctor_name`) VALUES (1, '王医师');
INSERT INTO `doctor` (`doctor_id`, `doctor_name`) VALUES (2, '陈大夫');
INSERT INTO `doctor` (`doctor_id`, `doctor_name`) VALUES (3, '罗专家');
COMMIT;

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `type` varchar(50) DEFAULT NULL,
                          `title` varchar(50) DEFAULT NULL,
                          `patient` int(11) DEFAULT NULL,
                          `doctor` int(11) DEFAULT NULL,
                          `follow_date` date DEFAULT NULL,
                          `next_follow` date DEFAULT NULL,
                          `status` int(11) DEFAULT NULL,
                          PRIMARY KEY (`id`) USING BTREE,
                          KEY `doctor` (`doctor`) USING BTREE,
                          KEY `follow` (`patient`) USING BTREE,
                          CONSTRAINT `follow` FOREIGN KEY (`patient`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of follow
-- ----------------------------
BEGIN;
INSERT INTO `follow` (`id`, `type`, `title`, `patient`, `doctor`, `follow_date`, `next_follow`, `status`) VALUES (1, '电话', '2222', 1, 1, '2023-02-21', '2023-02-23', 1);
INSERT INTO `follow` (`id`, `type`, `title`, `patient`, `doctor`, `follow_date`, `next_follow`, `status`) VALUES (2, '电话', '2231', 1, 2, '2023-02-21', '2023-02-23', 0);
INSERT INTO `follow` (`id`, `type`, `title`, `patient`, `doctor`, `follow_date`, `next_follow`, `status`) VALUES (10, '12345678910', '024535', 1, 2, '2023-02-08', '2023-02-16', 0);
INSERT INTO `follow` (`id`, `type`, `title`, `patient`, `doctor`, `follow_date`, `next_follow`, `status`) VALUES (11, '12345', '0324', 1, 1, NULL, NULL, 1);
INSERT INTO `follow` (`id`, `type`, `title`, `patient`, `doctor`, `follow_date`, `next_follow`, `status`) VALUES (12, '123456789', '0432', 1, 1, NULL, NULL, 1);
INSERT INTO `follow` (`id`, `type`, `title`, `patient`, `doctor`, `follow_date`, `next_follow`, `status`) VALUES (13, '1', '0', 1, 1, NULL, NULL, 1);
INSERT INTO `follow` (`id`, `type`, `title`, `patient`, `doctor`, `follow_date`, `next_follow`, `status`) VALUES (14, '3', '0', 4, 1, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
                           `manager_id` int(11) NOT NULL AUTO_INCREMENT,
                           `manager_name` varchar(50) DEFAULT NULL,
                           PRIMARY KEY (`manager_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of manager
-- ----------------------------
BEGIN;
INSERT INTO `manager` (`manager_id`, `manager_name`) VALUES (1, '刘女士');
INSERT INTO `manager` (`manager_id`, `manager_name`) VALUES (2, '李先生');
INSERT INTO `manager` (`manager_id`, `manager_name`) VALUES (3, '黄总');
COMMIT;

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
                            `medicine_id` int(11) NOT NULL AUTO_INCREMENT,
                            `type` int(11) DEFAULT NULL,
                            `medicine_name` varchar(50) DEFAULT NULL,
                            `medicine_card` varchar(50) DEFAULT NULL,
                            `model` varchar(50) DEFAULT NULL,
                            `price` float(10,2) DEFAULT NULL,
                            `medicine_num` int(11) DEFAULT NULL,
                            `unit` varchar(255) DEFAULT NULL,
                            `manager` int(11) DEFAULT NULL,
                            `vendor` int(11) DEFAULT NULL,
                            `status` int(11) DEFAULT NULL,
                            PRIMARY KEY (`medicine_id`) USING BTREE,
                            KEY `medicine` (`vendor`) USING BTREE,
                            CONSTRAINT `medicine` FOREIGN KEY (`vendor`) REFERENCES `vendor` (`vendor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of medicine
-- ----------------------------
BEGIN;
INSERT INTO `medicine` (`medicine_id`, `type`, `medicine_name`, `medicine_card`, `model`, `price`, `medicine_num`, `unit`, `manager`, `vendor`, `status`) VALUES (1, 1, '布洛芬', 'M822', 'M92', 12.00, 1234, '支', 1, 1, 0);
INSERT INTO `medicine` (`medicine_id`, `type`, `medicine_name`, `medicine_card`, `model`, `price`, `medicine_num`, `unit`, `manager`, `vendor`, `status`) VALUES (2, 2, '999感冒灵', 'MED999', 'M43', 23.00, 3456, '袋', 1, 3, 0);
INSERT INTO `medicine` (`medicine_id`, `type`, `medicine_name`, `medicine_card`, `model`, `price`, `medicine_num`, `unit`, `manager`, `vendor`, `status`) VALUES (3, 2, '莲花清瘟', 'MED877', 'M90', 11.00, 1235, '盒', 1, 2, 0);
INSERT INTO `medicine` (`medicine_id`, `type`, `medicine_name`, `medicine_card`, `model`, `price`, `medicine_num`, `unit`, `manager`, `vendor`, `status`) VALUES (4, 0, '1', '1', '1', 1.00, 1, '1', 1, 2, 1);
INSERT INTO `medicine` (`medicine_id`, `type`, `medicine_name`, `medicine_card`, `model`, `price`, `medicine_num`, `unit`, `manager`, `vendor`, `status`) VALUES (5, 1, '1', '1', '1', 1.00, 1, '1', 1, 1, 1);
INSERT INTO `medicine` (`medicine_id`, `type`, `medicine_name`, `medicine_card`, `model`, `price`, `medicine_num`, `unit`, `manager`, `vendor`, `status`) VALUES (6, 1, 'haom', '2323', '123123', 122.00, 32332, '1321', 1, 2, 1);
INSERT INTO `medicine` (`medicine_id`, `type`, `medicine_name`, `medicine_card`, `model`, `price`, `medicine_num`, `unit`, `manager`, `vendor`, `status`) VALUES (7, 1, 'ghwu', 'dadw212', 'dsa', 22.00, 2332, 'fds', 1, 1, 0);
INSERT INTO `medicine` (`medicine_id`, `type`, `medicine_name`, `medicine_card`, `model`, `price`, `medicine_num`, `unit`, `manager`, `vendor`, `status`) VALUES (8, 1, '大家思考', '222', '11', 1.00, 11, '1', 1, 3, 0);
INSERT INTO `medicine` (`medicine_id`, `type`, `medicine_name`, `medicine_card`, `model`, `price`, `medicine_num`, `unit`, `manager`, `vendor`, `status`) VALUES (9, 1, 'alert(1)', '1', 'alert(1)', 1.00, 1, '1', 1, 2, 0);
COMMIT;

-- ----------------------------
-- Table structure for medicinetype
-- ----------------------------
DROP TABLE IF EXISTS `medicinetype`;
CREATE TABLE `medicinetype` (
                                `type_id` int(11) NOT NULL,
                                `type_name` varchar(255) DEFAULT NULL,
                                PRIMARY KEY (`type_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of medicinetype
-- ----------------------------
BEGIN;
INSERT INTO `medicinetype` (`type_id`, `type_name`) VALUES (1, '处方药');
INSERT INTO `medicinetype` (`type_id`, `type_name`) VALUES (2, '非处方药');
COMMIT;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
                        `Title` varchar(50) NOT NULL,
                        `Publisher` varchar(50) DEFAULT NULL,
                        `Pub_time` date DEFAULT NULL,
                        `Origin` varchar(50) DEFAULT NULL,
                        `Times` int(11) DEFAULT NULL,
                        `file` varchar(50) DEFAULT NULL,
                        PRIMARY KEY (`Title`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
BEGIN;
INSERT INTO `news` (`Title`, `Publisher`, `Pub_time`, `Origin`, `Times`, `file`) VALUES ('JAVA', 'DawnT0wn', '2023-04-25', 'D1no', 3, 'CaSO4');
COMMIT;

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(50) DEFAULT NULL,
                           `gender` int(11) DEFAULT NULL,
                           `age` int(11) DEFAULT NULL,
                           `tel` varchar(50) DEFAULT NULL,
                           `id_card` varchar(50) DEFAULT NULL,
                           `address` varchar(50) DEFAULT NULL,
                           `doctor` int(11) DEFAULT NULL,
                           `follow` int(11) DEFAULT NULL,
                           `status` int(11) DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE,
                           KEY `doctor` (`doctor`) USING BTREE,
                           CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`doctor`) REFERENCES `doctor` (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of patient
-- ----------------------------
BEGIN;
INSERT INTO `patient` (`id`, `name`, `gender`, `age`, `tel`, `id_card`, `address`, `doctor`, `follow`, `status`) VALUES (1, '张三', 1, 59, '12208172103', '511722200105282732', '中国成都', 1, 1, 0);
INSERT INTO `patient` (`id`, `name`, `gender`, `age`, `tel`, `id_card`, `address`, `doctor`, `follow`, `status`) VALUES (3, '李四', 0, 12, '12', '21', '12', 1, 12, 1);
INSERT INTO `patient` (`id`, `name`, `gender`, `age`, `tel`, `id_card`, `address`, `doctor`, `follow`, `status`) VALUES (4, '王五', 0, 78, '13208172103', '511172220010537373', '四川成都十陵', 1, 1, 0);
INSERT INTO `patient` (`id`, `name`, `gender`, `age`, `tel`, `id_card`, `address`, `doctor`, `follow`, `status`) VALUES (5, '小明', 0, 67, '13208172103', '12355542', '四川成都', 1, 23, 0);
INSERT INTO `patient` (`id`, `name`, `gender`, `age`, `tel`, `id_card`, `address`, `doctor`, `follow`, `status`) VALUES (6, '小红', 0, 12, '123', '1234', '12345', 1, 123, 1);
INSERT INTO `patient` (`id`, `name`, `gender`, `age`, `tel`, `id_card`, `address`, `doctor`, `follow`, `status`) VALUES (7, '1', 0, 1, '1', '1', '1', 1, 1, 0);
INSERT INTO `patient` (`id`, `name`, `gender`, `age`, `tel`, `id_card`, `address`, `doctor`, `follow`, `status`) VALUES (8, '1', 0, 1, '1', '1', '1', 1, 1, 1);
INSERT INTO `patient` (`id`, `name`, `gender`, `age`, `tel`, `id_card`, `address`, `doctor`, `follow`, `status`) VALUES (9, '1', 0, 1, '1', '1', '1', 1, 1, 1);
INSERT INTO `patient` (`id`, `name`, `gender`, `age`, `tel`, `id_card`, `address`, `doctor`, `follow`, `status`) VALUES (10, '1', 0, 1, '1', '1', '1', 1, 1, 1);
INSERT INTO `patient` (`id`, `name`, `gender`, `age`, `tel`, `id_card`, `address`, `doctor`, `follow`, `status`) VALUES (11, '小李', 0, 22, '3213213', '3213213', '321321', 1, 321, 0);
COMMIT;

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `doctorName` varchar(255) DEFAULT NULL,
                               `dept` int(11) DEFAULT NULL,
                               `title` int(11) DEFAULT NULL,
                               `day` int(11) DEFAULT NULL,
                               `size` int(11) DEFAULT NULL,
                               `status` int(11) DEFAULT NULL,
                               PRIMARY KEY (`id`) USING BTREE,
                               KEY `dept` (`dept`) USING BTREE,
                               KEY `title` (`title`) USING BTREE,
                               CONSTRAINT `reservation` FOREIGN KEY (`dept`) REFERENCES `dept` (`dept_id`),
                               CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`title`) REFERENCES `title` (`title_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of reservation
-- ----------------------------
BEGIN;
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (1, '甲', 1, 1, 143, 12, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (2, '王五', 2, 2, 34, 34, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (3, '唐卓', 1, 2, 12, 23, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (4, '唐卓', 2, 1, 12, 2, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (5, 'lisi', 2, 2, 22, 12, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (6, '乙', 2, 2, 12, 34, 0);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (7, '刘大', 2, 2, 12, 23, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (8, '12', 1, 1, 12, 12, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (9, '丙', 1, 1, 12, 12, 0);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (10, '丁', 1, 1, 12, 12, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (11, '搁浅', 1, 1, 2, 12, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (12, '七里香', 5, 2, 14, 15, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (13, '1', 1, 1, 12, 12, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (14, '王思聪', 1, 1, 12, 123, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (15, 'dsf', 3, 3, 33, 4, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (16, '王专家', 2, 3, 2, 3, 0);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (17, '刘女士', 2, 2, 2, 3, 0);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (18, '小明', 2, 1, 23, 5, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (19, '小红', 4, 3, 33, 21, 1);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (20, '明医生', 2, 3, 7, 2, 0);
INSERT INTO `reservation` (`id`, `doctorName`, `dept`, `title`, `day`, `size`, `status`) VALUES (21, '小刚', 2, 2, 33, 2, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `username` varchar(255) DEFAULT NULL,
                          `password` varchar(255) DEFAULT NULL,
                          `status` int(11) DEFAULT NULL,
                          `roles` int(11) DEFAULT 2,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` (`id`, `username`, `password`, `status`,`roles`) VALUES (1, 'chenlong', '123', 0,2);
INSERT INTO `t_user` (`id`, `username`, `password`, `status`,`roles`) VALUES (2, 'lisi', '32425 ', 0,1);
INSERT INTO `t_user` (`id`, `username`, `password`, `status`,`roles`) VALUES (3, 'admin', 'admin', 0,0);
COMMIT;

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title` (
                         `title_id` int(11) NOT NULL AUTO_INCREMENT,
                         `title_name` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`title_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of title
-- ----------------------------
BEGIN;
INSERT INTO `title` (`title_id`, `title_name`) VALUES (1, '院长');
INSERT INTO `title` (`title_id`, `title_name`) VALUES (2, '主任医师');
INSERT INTO `title` (`title_id`, `title_name`) VALUES (3, '专家');
COMMIT;

-- ----------------------------
-- Table structure for vendor
-- ----------------------------
DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor` (
                          `vendor_id` int(11) NOT NULL AUTO_INCREMENT,
                          `type` varchar(50) DEFAULT NULL,
                          `vendor_name` varchar(50) DEFAULT NULL,
                          `level` varchar(255) DEFAULT NULL,
                          `status` int(11) DEFAULT NULL,
                          `num` int(11) DEFAULT NULL,
                          `province` varchar(50) DEFAULT NULL,
                          `address` varchar(255) DEFAULT NULL,
                          `manager` int(11) DEFAULT NULL,
                          `doctor` int(11) DEFAULT NULL,
                          PRIMARY KEY (`vendor_id`) USING BTREE,
                          KEY `vendor` (`manager`) USING BTREE,
                          KEY `doctor` (`doctor`) USING BTREE,
                          CONSTRAINT `vendor_ibfk_1` FOREIGN KEY (`doctor`) REFERENCES `doctor` (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of vendor
-- ----------------------------
BEGIN;
INSERT INTO `vendor` (`vendor_id`, `type`, `vendor_name`, `level`, `status`, `num`, `province`, `address`, `manager`, `doctor`) VALUES (1, '政府', '百信', '5级', 0, 10000, '北京 北京', '北京市西二旗中路西侧', 1, 1);
INSERT INTO `vendor` (`vendor_id`, `type`, `vendor_name`, `level`, `status`, `num`, `province`, `address`, `manager`, `doctor`) VALUES (2, '私人', '云南白药', '7级', 0, 1990, '云南 昆明', '昆明解放大街', 1, 1);
INSERT INTO `vendor` (`vendor_id`, `type`, `vendor_name`, `level`, `status`, `num`, `province`, `address`, `manager`, `doctor`) VALUES (3, '私人', '华润', '6级', 0, 2880, '广东 深圳', '深圳南山区', 1, 1);
INSERT INTO `vendor` (`vendor_id`, `type`, `vendor_name`, `level`, `status`, `num`, `province`, `address`, `manager`, `doctor`) VALUES (10, '2', '1', '1', 1, 1, '1', '1', 1, 2);
INSERT INTO `vendor` (`vendor_id`, `type`, `vendor_name`, `level`, `status`, `num`, `province`, `address`, `manager`, `doctor`) VALUES (11, '1', NULL, NULL, 1, 0, NULL, NULL, 0, 2);
INSERT INTO `vendor` (`vendor_id`, `type`, `vendor_name`, `level`, `status`, `num`, `province`, `address`, `manager`, `doctor`) VALUES (12, '1', NULL, NULL, 1, 0, NULL, NULL, 0, 1);
INSERT INTO `vendor` (`vendor_id`, `type`, `vendor_name`, `level`, `status`, `num`, `province`, `address`, `manager`, `doctor`) VALUES (13, '1', '1', '1', 1, 1, '1', '1', 1, 1);
INSERT INTO `vendor` (`vendor_id`, `type`, `vendor_name`, `level`, `status`, `num`, `province`, `address`, `manager`, `doctor`) VALUES (14, '1', '1', '1', 1, 1, '1', '1', 1, 1);
INSERT INTO `vendor` (`vendor_id`, `type`, `vendor_name`, `level`, `status`, `num`, `province`, `address`, `manager`, `doctor`) VALUES (15, '甲甲', '甲', '6级', 0, 22, '江西', '二仙桥成都理工大学', 2, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
