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
  `id` int NOT NULL AUTO_INCREMENT,
  `pk_name` varchar(50) DEFAULT NULL,
  `pk_state` varchar(2) DEFAULT NULL,
  `pk_lat` decimal(9,6) DEFAULT NULL,
  `pk_long` decimal(9,6) DEFAULT NULL,
  `pk_ZIP` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `park_id_index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `park`
--

LOCK TABLES `park` WRITE;
/*!40000 ALTER TABLE `park` DISABLE KEYS */;
INSERT INTO `park` (park_id, `pk_name`, `pk_state`, `pk_lat`, `pk_long`, `pk_ZIP`) VALUES (1,'Blue Mound','WI',NULL,NULL,'53517');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (1,'Amnicon Falls','WI','54874');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (2,'Aztalan','WI','53549');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (3,'Belmont Mound','WI','53818');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (4,'Big Bay','WI','54850');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (5,'Big Foot Beach','WI','53147');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (6,'Blue Mound','WI','53517');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (7,'Brunet Island','WI','54732');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (8,'Buckhorn','WI','54646');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (9,'Cambellsport Drumlins','WI','53010');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (10,'Copper Falls','WI','54546');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (11,'Council Grounds','WI','54452');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (12,'Cross Plains','WI','53528');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (13,'Devil\'s Lake','WI','53913');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (14,'Grand Traverse Island','WI','54246');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (15,'Governor Dodge','WI','53533');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (16,'Governor Nelson','WI','53597');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (17,'Governor Thompson','WI','54114');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (18,'Harrington Beach','WI','53004');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (19,'Hartman Creek','WI','54981');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (20,'High Cliff','WI','54169');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (21,'Interstate','WI','54024');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (22,'Kohler-Andrae','WI','53081');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (23,'Lake Kegonsa','WI','53589');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (24,'Lake Wissota','WI','54729');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (25,'Merrick','WI','54629');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (26,'Mill Bluff','WI','54618');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (27,'Mirror Lake','WI','53913');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (28,'Natural Bridge','WI','53951');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (29,'Nelson Dewey','WI','53806');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (30,'New Glarus Woods','WI','53754');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (31,'Newport','WI','54210');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (32,'Pattison','WI','54880');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (33,'Peninsula','WI','54212');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (34,'Perrot','WI','54661');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (35,'Potawatomi','WI','54235');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (36,'Rib Mountain','WI','54401');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (37,'Richard Bong','WI','53139');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (38,'Roche-a-Cri','WI','53934');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (39,'Rock Island','WI','54246');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (40,'Rocky Arbor','WI','53965');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (41,'Straight Lake','WI','54853');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (42,'Tower Hill','WI','53588');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (43,'Wildcat Mountain','WI','54651');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (44,'Willow River','WI','54016');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (45,'Wyalusing','WI','53801');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (46,'Yellowstone Lake','WI','53516');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (47,'Glaical Drumlin State Trail','WI','53551');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (48,'Elroy-Sparta State Trail','WI','54656');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (49,'Brule River State Forest','WI','54820');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (50,'Black River State Forest','WI','54615');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (51,'Flambeau River State Forest','WI','54896');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (52,'Governor Knowles State Forest','WI','54840');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (53,'Governor Earl Peshtigo State Forest','WI','54114');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (54,'Kettle Moraine State Forest - North','WI','53010');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (55,'Kettle Moraine State Forest - South','WI','53119');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (56,'Kettle Moraine State Forest - Pike','WI','53027');
INSERT INTO `park` (park_id,`pk_name`,`pk_state`,`pk_ZIP`) VALUES (57,'Kettle Moraine State Forest - Lapham Peak','WI','53018');
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

-- Dump completed on 2020-12-01 19:55:02
