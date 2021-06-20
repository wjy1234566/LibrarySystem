/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : lms

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 07/06/2020 14:46:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `admin_id` char(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_password` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `AdminID_UNIQUE`(`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('admin', '1');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publisher` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quantity` int(100) NOT NULL,
  `book_class` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_surface` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('9787111213826', '《Java编程思想 （第4版）》', 'Bruce Eckel', '108', '机械工业出版社', 2, '计算机', NULL);
INSERT INTO `book` VALUES ('9787115216878', '《代码整洁之道》', 'Robert C. Martin', '59', '人民邮电出版社', 3, '计算机', NULL);
INSERT INTO `book` VALUES ('9787115221704', '《重构：改善既有代码的设计》', 'Martin Fowler', '69', '人民邮电出版社', 2, '计算机', NULL);
INSERT INTO `book` VALUES ('9787115428028', '《Python Crash Course》', '埃里克·马瑟斯', '89', '人民邮电出版社', 5, '计算机', NULL);
INSERT INTO `book` VALUES ('9787121155352', '《C++ Primer 中文版（第 5 版）》', 'Stanley B. Lippman', '128', '电子工业出版社', 0, '计算机', NULL);
INSERT INTO `book` VALUES ('9787535690265', '《老鼠洞的大姐猫》', '安东尼娅·巴伯', '52', '湖南美术出版社', 1, '文学', NULL);

-- ----------------------------
-- Table structure for book_reservation
-- ----------------------------
DROP TABLE IF EXISTS `book_reservation`;
CREATE TABLE `book_reservation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reservation_date` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_reservation
-- ----------------------------
INSERT INTO `book_reservation` VALUES (5, '2017141482088', '9787121155352', '2020-06-07');

-- ----------------------------
-- Table structure for borrow_book
-- ----------------------------
DROP TABLE IF EXISTS `borrow_book`;
CREATE TABLE `borrow_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` char(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `borrow_date` date NOT NULL,
  `return_date` date NULL DEFAULT NULL,
  `due_date` date NULL DEFAULT NULL,
  `renew` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow_book
-- ----------------------------
INSERT INTO `borrow_book` VALUES (1, '2017141482088', '9787535690265', '2020-05-28', '2020-05-28', '2020-07-27', 0);
INSERT INTO `borrow_book` VALUES (2, '2017141482088', '9787535690265', '2020-05-28', NULL, '2020-10-25', 0);
INSERT INTO `borrow_book` VALUES (3, '2017141482088', '9787115221704', '2020-05-31', '2020-06-07', '2020-08-29', 1);
INSERT INTO `borrow_book` VALUES (10, '2017141482088', '9787115221704', '2020-06-07', '2020-06-07', '2020-07-07', 1);
INSERT INTO `borrow_book` VALUES (11, '2017141482088', '9787121155352', '2020-06-07', NULL, '2020-07-07', 1);

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comments` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comments_date` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (1, '增加图书种类', '2020-06-05');
INSERT INTO `feedback` VALUES (2, '123', '2020-06-07');
INSERT INTO `feedback` VALUES (3, '123', '2020-06-07');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `stu_id` char(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_password` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123456',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `major` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`stu_id`) USING BTREE,
  UNIQUE INDEX `reader_stu_id_uindex`(`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('2017141482080', 'w', '123456', 'w', 'w', 'w');
INSERT INTO `reader` VALUES ('2017141482088', '马鸣骏', '1', '男', '临床', '眼视光');

SET FOREIGN_KEY_CHECKS = 1;
