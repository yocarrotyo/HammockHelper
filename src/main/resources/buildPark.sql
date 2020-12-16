-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: hammock
-- ------------------------------------------------------
-- Server version	8.0.22-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `park`
--

DROP TABLE IF EXISTS `park`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `park` (
  `park_id` int NOT NULL AUTO_INCREMENT,
  `pk_name` varchar(50) DEFAULT NULL,
  `pk_state` varchar(2) DEFAULT NULL,
  `pk_lat` decimal(9,6) DEFAULT NULL,
  `pk_long` decimal(9,6) DEFAULT NULL,
  `pk_ZIP` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`park_id`),
  KEY `park_id_index` (`park_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `park`
--

LOCK TABLES `park` WRITE;
/*!40000 ALTER TABLE `park` DISABLE KEYS */;
INSERT INTO `park` (`park_id`, `pk_name`, `pk_state`, `pk_lat`, `pk_long`, `pk_ZIP`) VALUES (1,'Amnicon Falls','WI',41.000000,27.000000,'54874'),(2,'Aztalan','WI',41.000000,27.000000,'53549'),(3,'Belmont Mound','WI',41.000000,27.000000,'53818'),(4,'Big Bay','WI',41.000000,27.000000,'54850'),(5,'Big Foot Beach','WI',41.000000,27.000000,'53147'),(6,'Blue Mound','WI',41.000000,27.000000,'53517'),(7,'Brunet Island','WI',41.000000,27.000000,'54732'),(8,'Buckhorn','WI',41.000000,27.000000,'54646'),(9,'Cambellsport Drumlins','WI',41.000000,27.000000,'53010'),(10,'Copper Falls','WI',41.000000,27.000000,'54546'),(11,'Council Grounds','WI',41.000000,27.000000,'54452'),(12,'Cross Plains','WI',41.000000,27.000000,'53528'),(13,'Devil\'s Lake','WI',41.000000,27.000000,'53913'),(14,'Grand Traverse Island','WI',41.000000,27.000000,'54246'),(15,'Governor Dodge','WI',41.000000,27.000000,'53533'),(16,'Governor Nelson','WI',41.000000,27.000000,'53597'),(17,'Governor Thompson','WI',41.000000,27.000000,'54114'),(18,'Harrington Beach','WI',41.000000,27.000000,'53004'),(19,'Hartman Creek','WI',41.000000,27.000000,'54981'),(20,'High Cliff','WI',41.000000,27.000000,'54169'),(21,'Interstate','WI',41.000000,27.000000,'54024'),(22,'Kohler-Andrae','WI',41.000000,27.000000,'53081'),(23,'Lake Kegonsa','WI',41.000000,27.000000,'53589'),(24,'Lake Wissota','WI',41.000000,27.000000,'54729'),(25,'Merrick','WI',41.000000,27.000000,'54629'),(26,'Mill Bluff','WI',41.000000,27.000000,'54618'),(27,'Mirror Lake','WI',41.000000,27.000000,'53913'),(28,'Natural Bridge','WI',41.000000,27.000000,'53951'),(29,'Nelson Dewey','WI',41.000000,27.000000,'53806'),(30,'New Glarus Woods','WI',41.000000,27.000000,'53754'),(31,'Newport','WI',41.000000,27.000000,'54210'),(32,'Pattison','WI',41.000000,27.000000,'54880'),(33,'Peninsula','WI',41.000000,27.000000,'54212'),(34,'Perrot','WI',41.000000,27.000000,'54661'),(35,'Potawatomi','WI',41.000000,27.000000,'54235'),(36,'Rib Mountain','WI',41.000000,27.000000,'54401'),(37,'Richard Bong','WI',41.000000,27.000000,'53139'),(38,'Roche-a-Cri','WI',41.000000,27.000000,'53934'),(39,'Rock Island','WI',41.000000,27.000000,'54246'),(40,'Rocky Arbor','WI',41.000000,27.000000,'53965'),(41,'Straight Lake','WI',41.000000,27.000000,'54853'),(42,'Tower Hill','WI',41.000000,27.000000,'53588'),(43,'Wildcat Mountain','WI',41.000000,27.000000,'54651'),(44,'Willow River','WI',41.000000,27.000000,'54016'),(45,'Wyalusing','WI',41.000000,27.000000,'53801'),(46,'Yellowstone Lake','WI',41.000000,27.000000,'53516'),(47,'Glaical Drumlin State Trail','WI',41.000000,27.000000,'53551'),(48,'Elroy-Sparta State Trail','WI',41.000000,27.000000,'54656'),(49,'Brule River State Forest','WI',41.000000,27.000000,'54820'),(50,'Black River State Forest','WI',41.000000,27.000000,'54615'),(51,'Flambeau River State Forest','WI',41.000000,27.000000,'54896'),(52,'Governor Knowles State Forest','WI',41.000000,27.000000,'54840'),(53,'Governor Earl Peshtigo State Forest','WI',41.000000,27.000000,'54114'),(54,'Kettle Moraine State Forest - North','WI',41.000000,27.000000,'53010'),(55,'Kettle Moraine State Forest - South','WI',41.000000,27.000000,'53119'),(56,'Kettle Moraine State Forest - Pike','WI',41.000000,27.000000,'53027'),(57,'Kettle Moraine State Forest - Lapham Peak','WI',41.000000,27.000000,'53018');
/*!40000 ALTER TABLE `park` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-15 22:36:36
