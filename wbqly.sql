-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: wbqly
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Article`
--

DROP TABLE IF EXISTS `Article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) NOT NULL,
  `publishTime` datetime NOT NULL,
  `lmt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Article`
--

LOCK TABLES `Article` WRITE;
/*!40000 ALTER TABLE `Article` DISABLE KEYS */;
INSERT INTO `Article` VALUES (1,'Linux之父Linus的8个趣闻轶事','2018-08-01 00:00:00','2018-08-15 05:58:18'),(2,'从小说家到思想家——读《安·兰德和她创造的世界》','2018-08-01 00:00:00','2018-08-15 05:58:18'),(3,'new','2018-08-17 16:37:48','2018-08-17 08:37:48');
/*!40000 ALTER TABLE `Article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ArticleCategory`
--

DROP TABLE IF EXISTS `ArticleCategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ArticleCategory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `articleId` bigint(20) NOT NULL,
  `categoryId` bigint(20) NOT NULL,
  `lmt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `ArticleCategory_Article_FK` (`articleId`),
  KEY `ArticleCategory_Category_FK` (`categoryId`),
  CONSTRAINT `ArticleCategory_Article_FK` FOREIGN KEY (`articleId`) REFERENCES `Article` (`id`),
  CONSTRAINT `ArticleCategory_Category_FK` FOREIGN KEY (`categoryId`) REFERENCES `Category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ArticleCategory`
--

LOCK TABLES `ArticleCategory` WRITE;
/*!40000 ALTER TABLE `ArticleCategory` DISABLE KEYS */;
INSERT INTO `ArticleCategory` VALUES (1,1,1,'2018-07-31 16:00:00'),(2,2,2,'2018-07-31 16:00:00'),(4,1,2,'2018-09-04 02:21:03'),(5,2,1,'2018-09-04 02:25:13');
/*!40000 ALTER TABLE `ArticleCategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `lmt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
INSERT INTO `Category` VALUES (1,'Linus','2018-07-31 16:00:00'),(2,'Ayn','2018-08-31 16:00:00'),(5,'Spring','2018-09-04 08:40:33');
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Qlyuser`
--

DROP TABLE IF EXISTS `Qlyuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Qlyuser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `authority` varchar(1000) NOT NULL DEFAULT 'USER',
  `expireDate` date DEFAULT NULL,
  `enabled` binary(1) NOT NULL DEFAULT '1',
  `lmt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `username_2` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Qlyuser`
--

LOCK TABLES `Qlyuser` WRITE;
/*!40000 ALTER TABLE `Qlyuser` DISABLE KEYS */;
INSERT INTO `Qlyuser` VALUES (27,'gjj','$2a$10$0fMuc2caOtgNZWY7XLqbge.vLvEEk/XGRwdDqvs6TsKbZ8XfEahMO','USER',NULL,'1','2018-09-06 08:38:54'),(33,'wsy','$2a$10$Sj6S6TEgkhRiF4ZeSfkML.1l1eFEPauFL18X2thWOmkStk5SOsbSS','USER',NULL,'1','2018-09-06 09:15:35');
/*!40000 ALTER TABLE `Qlyuser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-08  5:33:52
