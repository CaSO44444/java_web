-- MySQL dump 10.13  Distrib 5.7.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mojocebe
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `consultation`
--

DROP TABLE IF EXISTS `consultation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consultation` (
                                `consultation_id` int(11) NOT NULL AUTO_INCREMENT,
                                `type` varchar(50) DEFAULT NULL,
                                `con_num` int(11) DEFAULT NULL,
                                `patient` int(11) DEFAULT NULL,
                                `dept` int(11) DEFAULT NULL,
                                `bed_num` int(11) DEFAULT NULL,
                                `doctor` int(11) DEFAULT NULL,
                                `money` float(255,0) DEFAULT NULL,
                                `time` time DEFAULT NULL,
                                `medicine` int(11) DEFAULT NULL,
                                `pay` int(11) DEFAULT NULL,
                                `status` int(11) DEFAULT NULL,
                                PRIMARY KEY (`consultation_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultation`
--

LOCK TABLES `consultation` WRITE;
/*!40000 ALTER TABLE `consultation` DISABLE KEYS */;
INSERT INTO `consultation` VALUES (1,'门诊',20231122,1,1,81,1,1555,'16:27:32',1,1,0),(2,'门诊',20030314,2,2,24,2,2345,'09:38:49',1,1,0),(3,'急诊',2022222,3,3,1,2,122,'09:49:50',3,1,0),(4,'急诊',20323232,4,2,1,1,33,'09:49:52',2,1,0),(5,'门诊',2032332,5,1,1,1,27,'10:49:55',1,1,0);
/*!40000 ALTER TABLE `consultation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dept` (
                        `dept_id` int(11) NOT NULL AUTO_INCREMENT,
                        `dept_name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (1,'外科'),(2,'儿科'),(3,'精神科'),(4,'骨科'),(5,'妇科');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
                          `doctor_id` int(11) NOT NULL AUTO_INCREMENT,
                          `doctor_name` varchar(50) DEFAULT NULL,
                          PRIMARY KEY (`doctor_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'王医师'),(2,'陈大夫'),(3,'罗专家');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow`
--

DROP TABLE IF EXISTS `follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow`
--

LOCK TABLES `follow` WRITE;
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
INSERT INTO `follow` VALUES (1,'电话','2222',1,1,'2023-02-21','2023-02-23',1),(2,'电话','2231',1,2,'2023-02-21','2023-02-23',0),(10,'12345678910','024535',1,2,'2023-02-08','2023-02-16',0),(11,'12345','0324',1,1,NULL,NULL,1),(12,'123456789','0432',1,1,NULL,NULL,1),(13,'1','0',1,1,NULL,NULL,1),(14,'3','0',4,1,NULL,NULL,0);
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
                           `manager_id` int(11) NOT NULL AUTO_INCREMENT,
                           `manager_name` varchar(50) DEFAULT NULL,
                           PRIMARY KEY (`manager_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'刘女士'),(2,'李先生'),(3,'黄总');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,1,'布洛芬','M822','M92',12.00,1234,'支',1,1,0),(2,2,'999感冒灵','MED999','M43',23.00,3456,'袋',1,3,0),(3,2,'莲花清瘟','MED877','M90',11.00,1235,'盒',1,2,0),(4,0,'1','1','1',1.00,1,'1',1,2,1),(5,1,'1','1','1',1.00,1,'1',1,1,1),(6,1,'haom','2323','123123',122.00,32332,'1321',1,2,1),(7,1,'ghwu','dadw212','dsa',22.00,2332,'fds',1,1,0),(8,1,'大家思考','222','11',1.00,11,'1',1,3,0);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicinetype`
--

DROP TABLE IF EXISTS `medicinetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicinetype` (
                                `type_id` int(11) NOT NULL,
                                `type_name` varchar(255) DEFAULT NULL,
                                PRIMARY KEY (`type_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicinetype`
--

LOCK TABLES `medicinetype` WRITE;
/*!40000 ALTER TABLE `medicinetype` DISABLE KEYS */;
INSERT INTO `medicinetype` VALUES (1,'处方药'),(2,'非处方药');
/*!40000 ALTER TABLE `medicinetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'张三',1,59,'12208172103','511722200105282732','中国成都',1,1,0),(3,'李四',0,12,'12','21','12',1,12,1),(4,'王五',0,78,'13208172103','511172220010537373','四川成都十陵',1,1,0),(5,'小明',0,67,'13208172103','12355542','四川成都',1,23,0),(6,'小红',0,12,'123','1234','12345',1,123,1),(7,'1',0,1,'1','1','1',1,1,0),(8,'1',0,1,'1','1','1',1,1,1),(9,'1',0,1,'1','1','1',1,1,1),(10,'1',0,1,'1','1','1',1,1,1),(11,'小李',0,22,'3213213','3213213','321321',1,321,0);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,'甲',1,1,143,12,1),(2,'王五',2,2,34,34,1),(3,'唐卓',1,2,12,23,1),(4,'唐卓',2,1,12,2,1),(5,'lisi',2,2,22,12,1),(6,'乙',2,2,12,34,0),(7,'刘大',2,2,12,23,1),(8,'12',1,1,12,12,1),(9,'丙',1,1,12,12,0),(10,'丁',1,1,12,12,1),(11,'搁浅',1,1,2,12,1),(12,'七里香',5,2,14,15,1),(13,'1',1,1,12,12,1),(14,'王思聪',1,1,12,123,1),(15,'dsf',3,3,33,4,1),(16,'王专家',2,3,2,3,0),(17,'刘女士',2,2,2,3,0),(18,'小明',2,1,23,5,1),(19,'小红',4,3,33,21,1),(20,'明医生',2,3,7,2,0),(21,'小刚',2,2,33,2,0);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `username` varchar(255) DEFAULT NULL,
                          `password` varchar(255) DEFAULT NULL,
                          `status` int(11) DEFAULT NULL,
                          `roles` int(11) DEFAULT '0',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','admin',0,1),(3,'test','test',0,0),(4,'test2','test2',0,1);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `title`
--

DROP TABLE IF EXISTS `title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `title` (
                         `title_id` int(11) NOT NULL AUTO_INCREMENT,
                         `title_name` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`title_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `title`
--

LOCK TABLES `title` WRITE;
/*!40000 ALTER TABLE `title` DISABLE KEYS */;
INSERT INTO `title` VALUES (1,'院长'),(2,'主任医师'),(3,'专家');
/*!40000 ALTER TABLE `title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES (1,'政府','百信','5级',0,10000,'北京 北京','北京市西二旗中路西侧',1,1),(2,'私人','云南白药','7级',0,1990,'云南 昆明','昆明解放大街',1,1),(3,'私人','华润','6级',0,2880,'广东 深圳','深圳南山区',1,1),(10,'2','1','1',1,1,'1','1',1,2),(11,'1',NULL,NULL,1,0,NULL,NULL,0,2),(12,'1',NULL,NULL,1,0,NULL,NULL,0,1),(13,'1','1','1',1,1,'1','1',1,1),(14,'1','1','1',1,1,'1','1',1,1),(15,'甲甲','甲','6级',0,22,'江西','十陵街道成都大学',2,1);
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


CREATE TABLE `news`
(
    `Title`     varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `Publisher` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `Pub_time`  date                                                   DEFAULT NULL,
    `Origin`    varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `Times`     int                                                    DEFAULT NULL,
    `file`      varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    PRIMARY KEY (`Title`) USING BTREE
)
-- Dump completed on 2023-04-25 15:27:33