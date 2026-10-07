-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: dbprojectdata
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tblallocation`
--

DROP TABLE IF EXISTS `tblallocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblallocation` (
  `AllocationID` int NOT NULL AUTO_INCREMENT,
  `RootID` int NOT NULL,
  `DriverID` int DEFAULT NULL,
  `ConductorID` int DEFAULT NULL,
  `VehicleID` int DEFAULT NULL,
  `AllocationDayNo` int DEFAULT NULL,
  `AllocationMonthNo` int DEFAULT NULL,
  `AllocationYearNo` int DEFAULT NULL,
  PRIMARY KEY (`AllocationID`),
  KEY `RootID` (`RootID`),
  KEY `DriverID` (`DriverID`),
  KEY `ConductorID` (`ConductorID`),
  KEY `VehicleID` (`VehicleID`),
  CONSTRAINT `tblallocation_ibfk_1` FOREIGN KEY (`RootID`) REFERENCES `tblroot` (`RootID`),
  CONSTRAINT `tblallocation_ibfk_2` FOREIGN KEY (`DriverID`) REFERENCES `tblemployee` (`EmployeeID`),
  CONSTRAINT `tblallocation_ibfk_3` FOREIGN KEY (`ConductorID`) REFERENCES `tblemployee` (`EmployeeID`),
  CONSTRAINT `tblallocation_ibfk_4` FOREIGN KEY (`VehicleID`) REFERENCES `tblvehicle` (`VehicleID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblallocation`
--

LOCK TABLES `tblallocation` WRITE;
/*!40000 ALTER TABLE `tblallocation` DISABLE KEYS */;
INSERT INTO `tblallocation` VALUES (1,1,152,162,1,22,2,2025),(2,2,153,163,2,22,2,2025),(3,6,156,167,3,22,2,2025),(4,3,152,162,4,7,3,2025),(8,1,152,162,1,7,3,2025),(9,4,153,163,2,7,3,2025),(10,2,154,164,3,8,7,2025),(11,2,154,164,3,7,3,2025),(12,1,152,162,1,8,3,2025),(13,1,152,162,1,11,3,2025),(14,2,153,163,2,11,3,2025),(15,1,153,162,1,12,3,2025),(16,5,153,164,4,14,3,2025),(17,2,161,171,3,14,3,2025),(18,2,154,164,4,22,3,2025),(19,1,152,162,1,22,3,2025),(20,7,156,168,3,22,3,2025),(21,13,159,170,22,6,4,2025),(22,15,156,167,6,7,4,2025),(23,7,152,163,2,7,4,2025),(24,4,154,164,3,7,4,2025),(25,2,159,166,5,7,4,2025),(26,3,158,168,4,7,4,2025),(27,7,153,165,2,8,4,2025);
/*!40000 ALTER TABLE `tblallocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcountry`
--

DROP TABLE IF EXISTS `tblcountry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcountry` (
  `CountryID` int NOT NULL AUTO_INCREMENT,
  `CountryName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CountryID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcountry`
--

LOCK TABLES `tblcountry` WRITE;
/*!40000 ALTER TABLE `tblcountry` DISABLE KEYS */;
INSERT INTO `tblcountry` VALUES (1,'India'),(2,'China'),(3,'Pakistan'),(4,'Australia'),(5,'Bhutan'),(6,'Fineland'),(7,'Iceland'),(8,'Afghanistan'),(9,'Srilanka'),(10,'Germany'),(11,'England'),(12,'Assia'),(14,'Brazil'),(15,'Galaxy country');
/*!40000 ALTER TABLE `tblcountry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbldesignation`
--

DROP TABLE IF EXISTS `tbldesignation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbldesignation` (
  `DesignationID` int NOT NULL AUTO_INCREMENT,
  `DesignationName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`DesignationID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbldesignation`
--

LOCK TABLES `tbldesignation` WRITE;
/*!40000 ALTER TABLE `tbldesignation` DISABLE KEYS */;
INSERT INTO `tbldesignation` VALUES (1,'ATS'),(2,'TI'),(3,'TC'),(4,'TC - (T.B)'),(5,'Sr.Cleark'),(6,'Cleark'),(7,'Peon'),(8,'Sweeper'),(9,'T/C'),(10,'Accountant'),(11,'HM'),(12,'AWS'),(13,'ART - A'),(14,'VE'),(15,'Cleaner'),(16,'Asst'),(17,'Asst-ART'),(18,'Driver'),(19,'Counductor');
/*!40000 ALTER TABLE `tbldesignation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbldistrict`
--

DROP TABLE IF EXISTS `tbldistrict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbldistrict` (
  `DistrictID` int NOT NULL AUTO_INCREMENT,
  `DistrictName` varchar(50) DEFAULT NULL,
  `StateID` int DEFAULT NULL,
  PRIMARY KEY (`DistrictID`),
  KEY `StateID` (`StateID`),
  CONSTRAINT `tbldistrict_ibfk_1` FOREIGN KEY (`StateID`) REFERENCES `tblstate` (`StateID`)
) ENGINE=InnoDB AUTO_INCREMENT=668 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbldistrict`
--

LOCK TABLES `tbldistrict` WRITE;
/*!40000 ALTER TABLE `tbldistrict` DISABLE KEYS */;
INSERT INTO `tbldistrict` VALUES (1,'Anantapur',1),(2,'Chittoor',1),(3,'East Godavari',1),(4,'Guntur',1),(5,'Krishna',1),(6,'Kurnool',1),(7,'Prakasam',1),(8,'Srikakulam',1),(9,'Visakhapatnam',1),(10,'Vizianagaram',1),(11,'West Godavari',1),(12,'YSR Kadapa',1),(13,'Tawang',2),(14,'West Kameng',2),(15,'East Kameng',2),(16,'Papum Pare',2),(17,'West Siang',2),(18,'East Siang',2),(19,'Siang',2),(20,'Lower Subansiri',2),(21,'Upper Subansiri',2),(22,'Kurung Kumey',2),(23,'Kamle',2),(24,'Lower Dibang Valley',2),(25,'Upper Dibang Valley',2),(26,'Anjaw',2),(27,'Lohit',2),(28,'Namsai',2),(29,'Changlang',2),(30,'Tirap',2),(31,'Longding',2),(32,'Baksa',3),(33,'Barpeta',3),(34,'Bongaigaon',3),(35,'Cachar',3),(36,'Charaideo',3),(37,'Darrang',3),(38,'Dibrugarh',3),(39,'Dima Hasao',3),(40,'Goalpara',3),(41,'Golaghat',3),(42,'Hailakandi',3),(43,'Jorhat',3),(44,'Kamrup',3),(45,'Kamrup Metropolitan',3),(46,'Karbi Anglong',3),(47,'Karimganj',3),(48,'Kokrajhar',3),(49,'Lakhimpur',3),(50,'Majuli',3),(51,'Morigaon',3),(52,'Nagaon',3),(53,'Nalbari',3),(54,'Sivasagar',3),(55,'Sonitpur',3),(56,'South Salmara-Mankachar',3),(57,'Tinsukia',3),(58,'Udalguri',3),(59,'West Karbi Anglong',3),(60,'Araria',4),(61,'Arwal',4),(63,'Banka',4),(64,'Begusarai',4),(65,'Bhagalpur',4),(66,'Buxar',4),(67,'Darbhanga',4),(68,'East Champaran',4),(69,'Gaya',4),(70,'Gopalganj',4),(71,'Jamui',4),(72,'Jehanabad',4),(73,'Kaimur',4),(74,'Katihar',4),(75,'Khagaria',4),(76,'Kishanganj',4),(77,'Lakhisarai',4),(78,'Madhepura',4),(79,'Madhubani',4),(80,'Munger',4),(81,'Muzaffarpur',4),(82,'Nalanda',4),(83,'Nawada',4),(84,'Patna',4),(85,'Purnia',4),(86,'Rohtas',4),(87,'Saharsa',4),(88,'Samastipur',4),(89,'Saran',4),(90,'Sheikhpura',4),(91,'Sheohar',4),(92,'Sitamarhi',4),(93,'Siwan',4),(94,'Supaul',4),(95,'Vaishali',4),(96,'West Champaran',4),(97,'Balod',5),(98,'Baloda Bazar',5),(99,'Bastar',5),(100,'Bilaspur',5),(101,'Dantewada',5),(102,'Dhamtari',5),(103,'Durg',5),(104,'Gariaband',5),(105,'Gaurela-Pendra-Marwahi',5),(106,'Janjgir-Champa',5),(107,'Jashpur',5),(108,'Kabirdham',5),(109,'Kanker',5),(110,'Korba',5),(111,'Kondagaon',5),(112,'Mahasamund',5),(113,'Mungeli',5),(114,'Narayanpur',5),(115,'Raigarh',5),(116,'Raipur',5),(117,'Rajnandgaon',5),(118,'Sakti',5),(119,'Surajpur',5),(120,'Surguja',5),(121,'North Goa',6),(122,'South Goa',6),(123,'Ahmedabad',7),(124,'Amreli',7),(125,'Anand',7),(126,'Banaskantha',7),(127,'Bharuch',7),(128,'Bhavnagar',7),(129,'Botad',7),(130,'Chhota Udaipur',7),(131,'Dahod',7),(132,'Dang',7),(133,'Gandhinagar',7),(134,'Jamnagar',7),(135,'Junagadh',7),(136,'Kheda',7),(137,'Kutch',7),(138,'Mehsana',7),(139,'Morbi',7),(140,'Narmada',7),(141,'Navsari',7),(142,'Panchmahal',7),(143,'Patan',7),(144,'Porbandar',7),(145,'Rajkot',7),(146,'Sabarkantha',7),(147,'Surat',7),(148,'Surendranagar',7),(149,'Tapi',7),(150,'Vadodara',7),(151,'Valsad',7),(152,'Ambala',8),(153,'Bhiwani',8),(154,'Charkhi Dadri',8),(155,'Faridabad',8),(156,'Fatehabad',8),(157,'Gurugram',8),(158,'Hisar',8),(159,'Jhajjar',8),(160,'Jind',8),(161,'Kaithal',8),(162,'Karnal',8),(163,'Kurukshetra',8),(164,'Mahendragarh',8),(165,'Narnaul',8),(166,'Palwal',8),(167,'Panchkula',8),(168,'Panipat',8),(169,'Rewari',8),(170,'Rohtak',8),(171,'Sirsa',8),(172,'Sonipat',8),(173,'Yamunanagar',8),(175,'Chamba',9),(176,'Hamirpur',9),(177,'Kangra',9),(178,'Kullu',9),(179,'Lahaul and Spiti',9),(180,'Mandi',9),(181,'Shimla',9),(182,'Sirmaur',9),(183,'Solan',9),(184,'Una',9),(185,'Bokaro',10),(186,'Chatra',10),(187,'Deoghar',10),(188,'Dhanbad',10),(189,'Dumka',10),(190,'East Singhbhum',10),(191,'Garhwa',10),(192,'Giridih',10),(193,'Godda',10),(194,'Gumla',10),(195,'Hazaribagh',10),(196,'Jamtara',10),(197,'Khunti',10),(198,'Koderma',10),(199,'Latehar',10),(200,'Lohardaga',10),(201,'Pakur',10),(202,'Palamu',10),(203,'Ramgarh',10),(204,'Ranchi',10),(205,'Sahibganj',10),(206,'Seraikela-Kharsawan',10),(207,'Simdega',10),(208,'West Singhbhum',10),(209,'Alappuzha',12),(210,'Idukki',12),(211,'Ernakulam',12),(212,'Kottayam',12),(213,'Kozhikode',12),(214,'Malappuram',12),(215,'Palakkad',12),(216,'Pathanamthitta',12),(217,'Thiruvananthapuram',12),(218,'Thrissur',12),(219,'Wayanad',12),(220,'Kannur',12),(221,'Kasaragod',12),(222,'Bagalkot',11),(223,'Ballari',11),(224,'Belagavi',11),(225,'Bengaluru Rural',11),(226,'Bengaluru Urban',11),(227,'Bidar',11),(228,'Chamarajanagar',11),(229,'Chikballapur',11),(230,'Chikkamagaluru',11),(231,'Chitradurga',11),(232,'Dakshina Kannada',11),(233,'Davangere',11),(234,'Dharwad',11),(235,'Gadag',11),(236,'Hassan',11),(237,'Haveri',11),(238,'Kodagu',11),(239,'Kolar',11),(240,'Koppal',11),(241,'Mandya',11),(242,'Mysuru',11),(243,'Raichur',11),(244,'Ramanagara',11),(245,'Shivamogga',11),(246,'Tumakuru',11),(247,'Udupi',11),(248,'Uttara Kannada',11),(249,'Vijayapura',11),(250,'Yadgir',11),(251,'Alirajpur',13),(252,'Anuppur',13),(253,'Ashoknagar',13),(254,'Balaghat',13),(255,'Barwani',13),(256,'Betul',13),(257,'Bhind',13),(258,'Bhopal',13),(259,'Burhanpur',13),(260,'Chhatarpur',13),(261,'Chhindwara',13),(262,'Damoh',13),(263,'Datia',13),(264,'Dewas',13),(265,'Dhar',13),(266,'Dindori',13),(267,'Guna',13),(268,'Gwalior',13),(269,'Harda',13),(270,'Hoshangabad',13),(271,'Indore',13),(272,'Jabalpur',13),(273,'Jhabua',13),(274,'Katni',13),(275,'Khandwa',13),(276,'Khargone',13),(277,'Mandla',13),(278,'Mandsaur',13),(279,'Morena',13),(280,'Narsinghpur',13),(281,'Neemuch',13),(282,'Panchmahals',13),(283,'Panna',13),(284,'Rewa',13),(285,'Sagar',13),(286,'Satna',13),(287,'Sehore',13),(288,'Seoni',13),(289,'Shahdol',13),(290,'Shajapur',13),(291,'Sheopur',13),(292,'Shivpuri',13),(293,'Singrauli',13),(294,'Tikamgarh',13),(295,'Ujjain',13),(296,'Umaria',13),(297,'Vidisha',13),(298,'Ahilyanagar',14),(299,'Akola',14),(300,'Amravati',14),(301,'Aurangabad',14),(302,'Beed',14),(303,'Bhandara',14),(304,'Buldhana',14),(305,'Chandrapur',14),(306,'Dhule',14),(307,'Gadchiroli',14),(308,'Gondia',14),(309,'Hingoli',14),(310,'Jalgaon',14),(311,'Jalna',14),(312,'Kolhapur',14),(313,'Latur',14),(314,'Mumbai',14),(315,'Mumbai Suburban',14),(316,'Nanded',14),(317,'Nandurbar',14),(318,'Nagpur',14),(319,'Navi Mumbai',14),(320,'Osmanabad',14),(321,'Palghar',14),(322,'Parbhani',14),(323,'Pune',14),(324,'Raigad',14),(325,'Ratnagiri',14),(326,'Sangli',14),(327,'Satara',14),(328,'Sindhudurg',14),(329,'Solapur',14),(330,'Thane',14),(331,'Wardha',14),(332,'Washim',14),(333,'Yavatmal',14),(334,'Bishnupur',15),(335,'Chandel',15),(336,'Churachandpur',15),(337,'Imphal East',15),(338,'Imphal West',15),(339,'Jiribam',15),(340,'Kakching',15),(341,'Kamjong',15),(342,'Kangpokpi',15),(343,'Noney',15),(344,'Pherzawl',15),(345,'Senapati',15),(346,'Tamenglong',15),(347,'Thoubal',15),(348,'Tengnoupal',15),(349,'Ukhrul',15),(350,'East Garo Hills',16),(351,'East Khasi Hills',16),(352,'Jaintia Hills',16),(353,'Ri-Bhoi',16),(354,'South Garo Hills',16),(355,'South Khasi Hills',16),(356,'West Garo Hills',16),(357,'West Khasi Hills',16),(358,'Aizawl',17),(359,'Champhai',17),(360,'Kolasib',17),(361,'Lawngtlai',17),(362,'Lunglei',17),(363,'Mamit',17),(364,'Saitual',17),(365,'Serchhip',17),(366,'Dimapur',18),(367,'Kiphire',18),(368,'Kohima',18),(369,'Longleng',18),(370,'Mokokchung',18),(371,'Mon',18),(372,'Peren',18),(373,'Phek',18),(374,'Tuensang',18),(375,'Wokha',18),(376,'Zunheboto',18),(377,'Angul',19),(378,'Boudh',19),(379,'Cuttack',19),(380,'Deogarh',19),(381,'Dhenkanal',19),(382,'Gajapati',19),(383,'Ganjam',19),(384,'Jagatsinghpur',19),(385,'Jajpur',19),(386,'Jharsuguda',19),(387,'Kalahandi',19),(388,'Kandhamal',19),(389,'Kendrapara',19),(390,'Kendujhar',19),(391,'Koraput',19),(392,'Malkangiri',19),(393,'Mayurbhanj',19),(394,'Nabarangpur',19),(395,'Nayagarh',19),(396,'Puri',19),(397,'Rayagada',19),(398,'Sambalpur',19),(399,'Subarnapur',19),(400,'Sundargarh',19),(401,'Amritsar',20),(402,'Barnala',20),(403,'Bathinda',20),(404,'Faridkot',20),(405,'Fatehgarh Sahib',20),(406,'Firozpur',20),(407,'Gurdaspur',20),(408,'Hoshiarpur',20),(409,'Jalandhar',20),(410,'Kapurthala',20),(411,'Ludhiana',20),(412,'Mansa',20),(413,'Moga',20),(414,'Muktsar',20),(415,'Nawanshahr',20),(416,'Patiala',20),(417,'Rupnagar',20),(418,'Sangrur',20),(419,'Shaheed Bhagat Singh Nagar',20),(420,'Tarn Taran',20),(421,'Ajmer',21),(422,'Alwar',21),(423,'Banswara',21),(424,'Baran',21),(425,'Barmer',21),(426,'Bhilwara',21),(427,'Bikaner',21),(428,'Bundi',21),(429,'Chittorgarh',21),(430,'Churu',21),(431,'Dausa',21),(432,'Dholpur',21),(433,'Dungarpur',21),(434,'Hanumangarh',21),(435,'Jaipur',21),(436,'Jaisalmer',21),(437,'Jalore',21),(438,'Jhalawar',21),(439,'Jhunjhunu',21),(440,'Jodhpur',21),(441,'Karauli',21),(442,'Kota',21),(443,'Nagaur',21),(444,'Pali',21),(445,'Rajsamand',21),(446,'Sawai Madhopur',21),(447,'Sikar',21),(448,'Sirohi',21),(449,'Tonk',21),(450,'Udaipur',21),(451,'East Sikkim',22),(452,'North Sikkim',22),(453,'South Sikkim',22),(454,'West Sikkim',22),(455,'Ariyalur',23),(456,'Chengalpattu',23),(457,'Chennai',23),(458,'Coimbatore',23),(459,'Cuddalore',23),(460,'Dharmapuri',23),(461,'Dindigul',23),(462,'Erode',23),(463,'Kallakurichi',23),(464,'Kanchipuram',23),(465,'Kanyakumari',23),(466,'Karur',23),(467,'Krishnagiri',23),(468,'Madurai',23),(469,'Nagapattinam',23),(470,'Namakkal',23),(471,'Perambalur',23),(472,'Pudukkottai',23),(473,'Ramanathapuram',23),(474,'Ranipet',23),(475,'Salem',23),(476,'Sivaganga',23),(477,'Tenkasi',23),(478,'Thanjavur',23),(479,'The Nilgiris',23),(480,'Theni',23),(481,'Tiruvallur',23),(482,'Tirunelveli',23),(483,'Tirupathur',23),(484,'Tiruchirappalli',23),(485,'Tiruvannamalai',23),(486,'Vellore',23),(487,'Viluppuram',23),(488,'Virudhunagar',23),(489,'Adilabad',24),(490,'Bhadradri Kothagudem',24),(491,'Hyderabad',24),(492,'Jagtial',24),(493,'Jangaon',24),(494,'Jayashankar Bhupalapally',24),(495,'Jogulamba Gadwal',24),(496,'Kamareddy',24),(497,'Karimnagar',24),(498,'Khammam',24),(499,'Mahabubabad',24),(500,'Mahabubnagar',24),(501,'Mancherial',24),(502,'Medak',24),(503,'Medchal-Malkajgiri',24),(504,'Mulugu',24),(505,'Nalgonda',24),(506,'Nirmal',24),(507,'Nizamabad',24),(508,'Peddapalli',24),(509,'Rangareddy',24),(510,'Sangareddy',24),(511,'Siddipet',24),(512,'Suryapet',24),(513,'Vikarabad',24),(514,'Warangal (Urban)',24),(515,'Warangal (Rural)',24),(516,'Yadadri Bhuvanagiri',24),(517,'Dhalai',25),(518,'Gomati',25),(519,'Khowai',25),(520,'North Tripura',25),(521,'Sepahijala',25),(522,'South Tripura',25),(523,'Unakoti',25),(524,'West Tripura',25),(525,'Agra',26),(526,'Aligarh',26),(527,'Ambedkar Nagar',26),(528,'Amethi',26),(529,'Amroha',26),(530,'Auraiya',26),(531,'Azamgarh',26),(532,'Baghpat',26),(533,'Bahraich',26),(534,'Ballia',26),(535,'Balrampur',26),(536,'Banda',26),(537,'Barabanki',26),(538,'Bareilly',26),(539,'Basti',26),(540,'Bhadohi',26),(541,'Bijnor',26),(542,'Budaun',26),(543,'Bulandshahr',26),(544,'Chandauli',26),(545,'Chitrakoot',26),(546,'Deoria',26),(547,'Etah',26),(548,'Etawah',26),(549,'Faizabad',26),(550,'Farrukhabad',26),(551,'Fatehpur',26),(552,'Firozabad',26),(553,'Gautam Buddha Nagar',26),(554,'Ghaziabad',26),(555,'Gonda',26),(556,'Gorakhpur',26),(558,'Hapur',26),(559,'Hardoi',26),(560,'Hathras',26),(561,'Jhansi',26),(562,'Jalaun',26),(563,'Jaunpur',26),(564,'Kanpur Dehat',26),(565,'Kanpur Nagar',26),(566,'Kasganj',26),(567,'Kaushambi',26),(568,'Kushinagar',26),(569,'Lakhimpur Kheri',26),(570,'Lucknow',26),(571,'Maharajganj',26),(572,'Mahoba',26),(573,'Meerut',26),(574,'Mirzapur',26),(575,'Moradabad',26),(576,'Muzaffarnagar',26),(578,'Pilibhit',26),(579,'Pratapgarh',26),(580,'Rae Bareli',26),(581,'Rampur',26),(582,'Saharanpur',26),(583,'Sambhal',26),(584,'Sant Kabir Nagar',26),(585,'Shahjahanpur',26),(586,'Shamli',26),(587,'Siddharthnagar',26),(588,'Sitapur',26),(589,'Sonbhadra',26),(590,'Sultanpur',26),(591,'Unnao',26),(592,'Varanasi',26),(593,'Almora',27),(594,'Bageshwar',27),(595,'Chamoli',27),(596,'Champawat',27),(597,'Dehradun',27),(598,'Haridwar',27),(599,'Nainital',27),(600,'Pauri Garhwal',27),(601,'Pithoragarh',27),(602,'Rudraprayag',27),(603,'Tehri Garhwal',27),(604,'Udham Singh Nagar',27),(605,'Uttarkashi',27),(606,'Alipurduar',28),(607,'Bankura',28),(608,'Birbhum',28),(609,'Cooch Behar',28),(610,'Dakshin Dinajpur',28),(611,'Darjeeling',28),(612,'Hooghly',28),(613,'Howrah',28),(614,'Jalpaiguri',28),(615,'Jhargram',28),(616,'Kolkata',28),(617,'Malda',28),(618,'Murshidabad',28),(619,'Nadia',28),(620,'North 24 Parganas',28),(621,'Paschim Bardhaman',28),(622,'Paschim Medinipur',28),(623,'Purba Bardhaman',28),(624,'Purba Medinipur',28),(625,'Purulia',28),(626,'South 24 Parganas',28),(627,'Uttar Dinajpur',28),(628,'Andaman',29),(629,'Nicobar',29),(630,'Chandigarh',30),(631,'Dadra',31),(632,'Nagar Haveli',31),(633,'Daman',31),(634,'Diu',31),(635,'Agatti',32),(636,'Amini',32),(637,'Andrott',32),(638,'Bangaram',32),(639,'Bithra',32),(640,'Chethlat',32),(641,'Kiltan',32),(642,'Kavaratti',32),(643,'Minicoy',32),(644,'Suheli Par',32),(645,'Central Delhi',33),(646,'East Delhi',33),(647,'New Delhi',33),(648,'North Delhi',33),(649,'North East Delhi',33),(650,'North West Delhi',33),(651,'Shahdara',33),(652,'South Delhi',33),(653,'South West Delhi',33),(654,'West Delhi',33),(655,'Aravalli',7),(656,'Devbhoomi Dwarka',7),(658,'Gir Somnath',7),(659,'Mahisagar',7),(661,'Nashik',14);
/*!40000 ALTER TABLE `tbldistrict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblemployee`
--

DROP TABLE IF EXISTS `tblemployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblemployee` (
  `EmployeeID` int NOT NULL AUTO_INCREMENT,
  `EmployeeName` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `PinCode` varchar(50) DEFAULT NULL,
  `AreaID` int DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Gender` int DEFAULT NULL,
  `ContactNo` varchar(15) DEFAULT NULL,
  `EmailID` varchar(500) DEFAULT NULL,
  `DesignationID` int DEFAULT NULL,
  `BillaNo` varchar(50) DEFAULT NULL,
  `LicenceNo` varchar(50) DEFAULT NULL,
  `Villagian` int DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`),
  KEY `DesignationID` (`DesignationID`),
  CONSTRAINT `tblemployee_ibfk_1` FOREIGN KEY (`DesignationID`) REFERENCES `tbldesignation` (`DesignationID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=186 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblemployee`
--

LOCK TABLES `tblemployee` WRITE;
/*!40000 ALTER TABLE `tblemployee` DISABLE KEYS */;
INSERT INTO `tblemployee` VALUES (121,'N B Sonawane','Chopda','425107',9,31,1,'1234567890','temporarymailid@gmail.com',1,'12345','0000000000',0),(122,'S H Savant','Chopda','425107',9,48,1,'321567964','mailid@gmail.com',2,'56321','1222222222222',0),(123,'P D Borse','Chopda','425107',9,32,1,'963852074','temporarymailid@gmail.com',2,'89654','0000000000',0),(124,'M U Baviskar','Chopda','425107',9,49,1,'1234567890','temporarymailid@gmail.com',4,'12345','0000000000',0),(125,'R D Sove','Chopda','425107',9,36,0,'1234567890','temporarymailid@gmail.com',4,'23654','0000000000',0),(126,'A N Tadvi','Chopda','425107',9,41,1,'1234567890','temporarymailid@gmail.com',4,'78963','0000000000',0),(127,'S R Karankal','Chopda','425107',9,45,0,'1234567890','temporarymailid@gmail.com',4,'21453','0000000000',0),(128,'D D Chaware','Chopda','425107',9,46,0,'1234567890','temporarymailid@gmail.com',5,'25469','0000000000',0),(129,'R A Pardeshi','Chopda','425107',9,47,1,'1234567890','temporarymailid@gmail.com',5,'85369','0000000000',0),(130,'K Y Shaikh','Chopda','425107',9,31,0,'1234567890','temporarymailid@gmail.com',5,'45632','0000000000',0),(131,'P S Patil','Chopda','425107',9,32,1,'1234567890','temporarymailid@gmail.com',5,'15935','0000000000',0),(132,'G R wagh','Chopda','425107',9,33,0,'1234567890','temporarymailid@gmail.com',6,'75395','0000000000',0),(133,'A S Mahajan','Chopda','425107',9,34,0,'1234567890','temporarymailid@gmail.com',6,'85698','0000000000',0),(134,'A S Koli','Chopda','425107',9,35,1,'1234567890','temporarymailid@gmail.com',6,'45963','0000000000',0),(135,'S B koli','Chopda','425107',9,36,1,'7896541232','temporarymailid@gmail.com',6,'15932','0000000000',0),(136,'N V Sonavne','Chopda','425107',9,37,0,'4598794651','temporarymailid@gmail.com',7,'78963','0000000000',0),(137,'P T Biwalkar','Chopda','425107',9,56,1,'7896314524','temporarymailid@gmail.com',8,'45693','0000000000',0),(138,'M S Biwalkar','Chopda','425107',9,47,1,'7418596389','temporarymailid@gmail.com',8,'78965','0000000000',0),(139,'I D Chaudhari','Chopda','425107',9,42,1,'789641235','temporarymailid@gmail.com',10,'12369','0000000000',0),(140,'A B Bavisker','Chopda','425107',9,31,1,'741852969','temporarymailid@gmail.com',11,'58964','0000000000',0),(141,'S M chandankar','Chopda','425107',9,32,1,'789741852','temporarymailid@gmail.com',12,'78236','0000000000',0),(142,'D S Surve','Chopda','425107',9,34,1,'123963852','temporarymailid@gmail.com',13,'41965','0000000000',0),(143,'S C Borse','Chopda','425107',9,35,0,'789637415','temporarymailid@gmail.com',13,'78235','0000000000',0),(144,'P R Patil','Chopda','425107',9,36,1,'741456789','temporarymailid@gmail.com',13,'96321','0000000000',0),(145,'M N Shaikh','Chopda','425107',9,37,0,'852963789','temporarymailid@gmail.com',14,'89652','0000000000',0),(146,'G M Sapkade','Chopda','425107',9,38,1,'78974189','temporarymailid@gmail.com',14,'54123','0000000000',0),(147,'P D Baviskar','Chopda','425107',9,39,1,'741896562','temporarymailid@gmail.com',16,'21365','0000000000',0),(148,'R P Lohar','Chopda','425107',9,40,0,'78965412','temporarymailid@gmail.com',17,'54632','0000000000',0),(149,'S S Sonavne','Chopda','425107',9,41,1,'54896321','temporarymailid@gmail.com',17,'78963','0000000000',0),(150,'S O Dhole','Chopda','425107',9,31,1,'78965412','temporarymailid@gmail.com',17,'45236','0000000000',0),(151,'S M Pathan','Chopda','425107',9,33,0,'96547852','temporarymailid@gmail.com',15,'85694','0000000000',0),(152,'S V Sulatne','Chopda','425107',9,34,1,'56255555','temporarymailid@gmail.com',18,'85694','0000000000',0),(153,'J P Baviskar','Chopda','425107',9,44,1,'852963789','temporarymailid@gmail.com',18,'85694','0000000000',0),(154,'K G Guraw','Chopda','425107',9,55,1,'852963789','temporarymailid@gmail.com',18,'85694','0000000000',0),(155,'F R Shaik','Chopda','425107',9,66,1,'852963789','temporarymailid@gmail.com',18,'85694','0000000000',0),(156,'V M Mahajan','Chopda','425107',9,77,1,'852963789','temporarymailid@gmail.com',18,'85694','0000000000',0),(157,'S S Dhangar','Chopda','425107',9,34,1,'852963789','temporarymailid@gmail.com',18,'85694','0000000000',0),(158,'B M Koli','Chopda','425107',9,35,1,'852963789','temporarymailid@gmail.com',18,'85694','0000000000',0),(159,'V K Pawar','Chopda','425107',9,32,1,'852963789','temporarymailid@gmail.com',18,'85694','0000000000',0),(160,'P S Joshi','Chopda','425107',9,31,1,'852963789','temporarymailid@gmail.com',18,'85694','0000000000',0),(161,'S P Thakur','Chopda','425107',9,32,1,'852963789','temporarymailid@gmail.com',18,'85694','0000000000',0),(162,'G C Pardhi','Chopda','425107',9,34,1,'852963789','temporarymailid@gmail.com',19,'85694','0000000000',0),(163,'P B Baviskar','Chopda','425107',9,44,1,'852963789','temporarymailid@gmail.com',19,'85694','0000000000',0),(164,'M L Baviskar','Chopda','425107',9,56,0,'852963789','temporarymailid@gmail.com',19,'85694','0000000000',0),(165,'B N Patil','Chopda','425107',9,76,1,'852963789','temporarymailid@gmail.com',19,'85694','0000000000',0),(166,'S B Saindane','Chopda','425107',9,56,1,'852963789','temporarymailid@gmail.com',19,'85694','0000000000',0),(167,'Y L Sonwane ','Chopda','425107',9,54,0,'852963789','temporarymailid@gmail.com',19,'85694','0000000000',0),(168,'A H Patil','Chopda','425107',9,34,1,'852963789','temporarymailid@gmail.com',19,'85694','0000000000',0),(169,'V G Bagul','Chopda','425107',9,32,0,'852963789','temporarymailid@gmail.com',19,'85694','0000000000',0),(170,'I S Baviskar','Chopda','425107',9,23,1,'852963789','temporarymailid@gmail.com',19,'85694','0000000000',0),(171,'S D Mahajan','Chopda','425107',9,32,0,'852963789','temporarymailid@gmail.com',19,'85694','0000000000',0),(172,'S A Pardeshi','Narmada Nagar ','425107',7,19,0,'9363746443','temporymailid@gmail.com',10,'32334','0000000000',0),(173,'M B Bhat','Chopda','425107',9,31,1,'9648754682','notvalidemail@gmail.com',1,'64987','3625149875',0),(174,'M N Bhat','Chopda','425107',9,19,0,'9648754000','mnbhatemail@gmail.com',1,'56987','1254987635',0),(175,'K N Bhat','Chopda','425107',9,19,0,'9648754000','mnbhatemail@gmail.com',1,'56987','1254987635',0),(176,'K D Badgujar','Chopda','425107',9,19,1,'9648224000','kdbadgujar@gmail.com',1,'65498','1254987200',0),(177,'P B Chaudhari','Chopda','425107',9,31,0,'982356741','pbchaudhri@gmail.com',1,'45600','3895149875',0),(180,'D N Agrawal','Chopda','425107',9,19,1,'9638225020','dnagrawal@gmail.com',1,'95598','1254987102',0),(181,'K N Bhat','Chopda','425107',9,19,0,'9865749502','knbhat2006@gmail.com',1,'96556','3356897458',0),(182,'N S Sushir','Pankaj Nagar','425107',9,19,1,'9089785643','nayan2006@gmail.com',5,'56543','6675564576',0),(184,'T K Mali','Chincha Chauk Chopda','425107',9,45,0,'8010363704','tanisk123@gmail.com',3,'4555','12345678910',0),(185,'Mr. R. D. Sharma','Nagalwadi','425107',9,42,1,'9658742311','rdsharma@gmail.com',19,'95185','7569841254',0);
/*!40000 ALTER TABLE `tblemployee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblroot`
--

DROP TABLE IF EXISTS `tblroot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblroot` (
  `RootID` int NOT NULL AUTO_INCREMENT,
  `RootName` varchar(50) NOT NULL,
  `SourceStationID` int DEFAULT NULL,
  `Villagian` int DEFAULT NULL,
  `DestinationStationID` int DEFAULT NULL,
  `StartTime` varchar(50) DEFAULT NULL,
  `TimeShift` int DEFAULT NULL,
  PRIMARY KEY (`RootID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblroot`
--

LOCK TABLES `tblroot` WRITE;
/*!40000 ALTER TABLE `tblroot` DISABLE KEYS */;
INSERT INTO `tblroot` VALUES (1,'Chopda To Vashi',612,0,809,'3:45',0),(2,'Chopda To Nashik',612,0,585,'5:30',0),(3,'Chopda To Kalyan',612,0,566,'9:35',0),(4,'Chopda To Pune',612,0,836,'1:30',1),(5,'Chopda to Jalgaon via Dharangaon',612,0,610,'6:00',0),(6,'Chopda To Sakri',612,0,137,'11:00',0),(7,'Chopda To Akola',612,0,872,'12:30',0),(8,'Chopda to Shirpur',612,0,886,'6:30',0),(9,'Chopda To Chalisgaon via Erandol',612,0,606,'6:00',0),(10,'Chopda To Navapur',612,0,888,'1:30',0),(11,'Chopda to Vapi via Dhule',612,0,510,'8:30',1),(12,'Chopda To Vapi via Shirpur',612,0,510,'9:00',0),(13,'Chopda To Ankaleshwar',612,0,281,'10:00',0),(14,'Chopda To Vadodara',612,0,497,'8:10',0),(15,'Chopda To Nagpur',612,0,654,'12:30',1),(16,'Chopda to Vashiiii',0,0,0,'3:45',0);
/*!40000 ALTER TABLE `tblroot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblrootstop`
--

DROP TABLE IF EXISTS `tblrootstop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblrootstop` (
  `RootStopID` int NOT NULL AUTO_INCREMENT,
  `RootID` int DEFAULT NULL,
  `StationID` int DEFAULT NULL,
  `StopTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`RootStopID`),
  KEY `RootID` (`RootID`),
  CONSTRAINT `tblrootstop_ibfk_1` FOREIGN KEY (`RootID`) REFERENCES `tblroot` (`RootID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblrootstop`
--

LOCK TABLES `tblrootstop` WRITE;
/*!40000 ALTER TABLE `tblrootstop` DISABLE KEYS */;
INSERT INTO `tblrootstop` VALUES (1,1,612,'10 '),(2,1,607,'10'),(3,1,133,'5'),(5,1,594,'15'),(6,1,585,'15'),(7,1,589,'10'),(8,1,568,'5'),(9,1,565,'15'),(10,1,809,'10'),(11,2,612,'10'),(12,2,607,'5'),(13,2,596,'10'),(14,2,585,'10'),(15,3,612,'10'),(16,3,607,'5'),(17,3,133,'10'),(18,3,594,'10'),(19,3,585,'15'),(20,3,566,'15'),(21,4,612,'10'),(22,4,607,'5'),(23,4,133,'10'),(24,4,78,'5'),(25,4,836,'15'),(26,9,612,'10'),(27,9,609,'5'),(28,9,617,'10'),(29,9,611,'10'),(30,9,606,'10'),(31,14,612,'10'),(32,14,886,'5'),(33,14,598,'5'),(34,14,887,'5'),(35,14,497,'10'),(36,6,612,'10'),(37,6,886,'10'),(38,6,625,'10'),(39,6,137,'10'),(40,7,612,'10'),(41,7,614,'5'),(42,7,620,'10'),(43,7,609,'5'),(44,7,118,'5'),(45,7,634,'5'),(46,7,811,'10'),(47,7,872,'10'),(48,13,612,'10'),(49,13,886,'5'),(50,13,598,'5'),(51,13,887,'10'),(52,13,281,'10'),(53,10,612,'10'),(54,10,886,'5'),(55,10,885,'5'),(56,10,888,'10');
/*!40000 ALTER TABLE `tblrootstop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblstate`
--

DROP TABLE IF EXISTS `tblstate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblstate` (
  `StateID` int NOT NULL AUTO_INCREMENT,
  `StateName` varchar(50) DEFAULT NULL,
  `CountryID` int DEFAULT NULL,
  PRIMARY KEY (`StateID`),
  KEY `CountryID` (`CountryID`),
  CONSTRAINT `tblstate_ibfk_1` FOREIGN KEY (`CountryID`) REFERENCES `tblcountry` (`CountryID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblstate`
--

LOCK TABLES `tblstate` WRITE;
/*!40000 ALTER TABLE `tblstate` DISABLE KEYS */;
INSERT INTO `tblstate` VALUES (1,'Andhra Pradesh',1),(2,'Arunachal Pradesh',1),(3,'Assam',1),(4,'Bihar',1),(5,'Chhattisgarh',1),(6,'Goa',1),(7,'Gujarat',1),(8,'Haryana',1),(9,'Himachal Pradesh',1),(10,'Jharkhand',1),(11,'Karnataka',1),(12,'Kerala',1),(13,'Madhya Pradesh',1),(14,'Maharashtra',1),(15,'Manipur',1),(16,'Meghalaya',1),(17,'Mizoram',1),(18,'Nagaland',1),(19,'Odisha',1),(20,'Punjab',1),(21,'Rajasthan',1),(22,'Sikkim',1),(23,'Tamil Nadu',1),(24,'Telangana',1),(25,'Tripura',1),(26,'Uttar Pradesh',1),(27,'Uttarakhand',1),(28,'West Bengal',1),(29,'Andaman and Nicobar Islands',1),(30,'Chandigarh',1),(31,'Dadra and Nagar Haveli and Daman and Diu',1),(32,'Lakshadweep',1),(33,'Delhi',1),(34,'Daman and Diu',1),(35,'Jammu & Kashmir',1),(36,'Puducherry',NULL);
/*!40000 ALTER TABLE `tblstate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltaluka`
--

DROP TABLE IF EXISTS `tbltaluka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltaluka` (
  `TalukaID` int NOT NULL AUTO_INCREMENT,
  `TalukaName` varchar(50) DEFAULT NULL,
  `DistrictID` int DEFAULT NULL,
  PRIMARY KEY (`TalukaID`),
  KEY `DistrictID` (`DistrictID`),
  CONSTRAINT `tbltaluka_ibfk_1` FOREIGN KEY (`DistrictID`) REFERENCES `tbldistrict` (`DistrictID`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltaluka`
--

LOCK TABLES `tbltaluka` WRITE;
/*!40000 ALTER TABLE `tbltaluka` DISABLE KEYS */;
INSERT INTO `tbltaluka` VALUES (1,'Anantapur',1),(2,'Atmakur',1),(3,'Dharmavaram',1),(4,'Penukonda',1),(5,'Puttaparthi',1),(6,'Rayadurg',1),(7,'Tadipatri',1),(8,'Uravakonda',1),(10,'Baireddipalle',2),(11,'Chandragiri',2),(12,'Chittoor',2),(13,'Irala',2),(14,'Madanapalle',2),(15,'Peddamudiam',2),(16,'Peddapalle',2),(17,'East Godavari',3),(18,'Amalapuram',3),(19,'Rajahmundry',3),(20,'Kakinada',3),(21,'Gokavaram',3),(22,'Kothapeta',3),(23,'Mandapeta',3),(24,'Peddapuram',3),(27,'Guntur',4),(28,'Narasaraopet',4),(29,'Ponnur',4),(30,'Repalle',4),(31,'Tenali',4),(32,'Krishna',5),(33,'Mylavaram',5),(34,'Nuzvid',5),(35,'Vijayawada',5),(36,'Jaggayyapeta',5),(37,'Gannavaram',5),(38,'Kankipadu',5),(40,'Adoni',6),(41,'Nandyal',6),(42,'Kurnool',6),(43,'Peddakadubur',6),(44,'Pusapatirega',6),(45,'Prakasam',7),(46,'Chirala',7),(47,'Markapur',7),(48,'Ongole',7),(49,'Peddaraveedu',7),(50,'Srisailam',7),(52,'Amadalavalasa',8),(53,'Etcherla',8),(54,'Rajam',8),(55,'Srikakulam',8),(56,'Tekkali',8),(58,'Anakapalle',9),(59,'Narsipatnam',9),(60,'Pendurthi',9),(61,'Visakhapatnam',9),(62,'Chodavaram',9),(63,'Vizianagaram',10),(64,'Bhamini',10),(65,'Dattirajeru',10),(67,'Parvathipuram',10),(68,'Ramabhadrapuram',10),(69,'Ahilyanagar (Ahemadnagar)',298),(70,'Shevgaon',298),(73,'Pathardi',298),(74,'Parner',298),(75,'Rahuri',298),(76,'Jamkhed',298),(78,'Sangamner',298),(80,'Murtijapur',299),(81,'Barshitakli',299),(87,'Achalpur',300),(88,'Morshi',300),(89,'Chandur Bazar',300),(90,'Chandur Railway',300),(91,'Nandgaon Khandeshwar',300),(93,'Warud',300),(94,'Dhamangaon Railway',300),(117,'Sangrampur',304),(118,'Nandura',304),(119,'Mehkar',304),(120,'Patur',304),(121,'Deulgaon Raja',304),(123,'Chandrapur',305),(126,'Rajura',305),(127,'Sindewahi',305),(129,'Gadchandur',305),(130,'Pombhurna',305),(133,'Dhule',306),(137,'Sakri',306),(141,'Gadchiroli',307),(144,'Bhamragad',307),(145,'Dhanora',307),(147,'Etapalli',307),(148,'Kurkheda',307),(150,'Korchi',307),(154,'Deori',308),(157,'Sakhari',308),(227,'Daskroi',123),(229,'Vejalpur',123),(230,'Nikol',123),(231,'Bavla',123),(232,'Mandal',123),(234,'Aslali',123),(236,'Amreli',124),(237,'Rajula',124),(239,'Jaffrabad',124),(241,'Vallabhipur',124),(242,'Kunkavav',124),(244,'Khambha',124),(245,'Khijadiya',124),(248,'Anand',125),(249,'Borsad',125),(250,'Khambhat',125),(251,'Petlad',125),(252,'Sojitra',125),(254,'Vallabh Vidyanagar',125),(257,'Umreth',125),(258,'Mahemdavad',125),(259,'Aravalli',655),(261,'Malpur',655),(264,'Garbeta',655),(265,'Shamlaji',655),(266,'Pethapur',655),(267,'Limbdi',655),(269,'Banaskantha',126),(271,'Tharad',126),(272,'Palanpur',126),(273,'Vav',126),(274,'Danta',126),(275,'Amirgadh',126),(277,'Bhinmal',126),(279,'Siyal',126),(280,'Bharuch',127),(281,'Ankaleshwar',127),(282,'Jambusar',127),(283,'Valia',127),(284,'Vagra',127),(289,'Bhavnagar',128),(290,'Bhavnagar Rural',128),(291,'Gariadhar',128),(294,'Palitana',128),(296,'Talaja',128),(298,'Lathi',128),(299,'Botad',129),(300,'Barwala',129),(301,'Gadhada',129),(304,'Chhota Udaipur',130),(305,'Bodeli',130),(308,'Shahera',130),(309,'Rathod',130),(311,'Dahod',131),(312,'Jhalod',131),(313,'Fatepura',131),(314,'Limkheda',131),(316,'Zalod',131),(318,'Dang',132),(319,'Ahwa',132),(320,'Waghai',132),(321,'Subir',132),(322,'Chorvad',132),(323,'Devbhoomi Dwarka',656),(324,'Dwarka',656),(325,'Khambhaliya',656),(328,'Panchbhadi',656),(331,'Gir Somnath',658),(332,'Veraval',658),(333,'Somnath',658),(337,'Bantva',658),(338,'Shihor',658),(339,'Gandhinagar',133),(340,'Kalol',133),(342,'Dehgam',133),(344,'Sanand',133),(345,'Gandhinagar Rural',133),(346,'Ahmedabad',133),(347,'Jamnagar',134),(348,'Jodiya',134),(349,'Kalavad',134),(350,'Dhrol',134),(351,'Khambhalia',134),(354,'Rajkot',134),(356,'Junagadh',135),(357,'Mendarda',135),(359,'Keshod',135),(361,'Gir Gadhada',135),(362,'Manavadar',135),(363,'Sihor',135),(364,'Visavadar',135),(365,'Kundla',135),(367,'Nadiad',136),(368,'Mahudha',136),(369,'Matar',136),(370,'Thasra',136),(372,'Vijapur',136),(373,'Kathlal',136),(374,'Derol',136),(375,'Kutch',137),(376,'Bhuj',137),(378,'Anjar',137),(379,'Bachau',137),(380,'Nakhatrana',137),(381,'Abdasa',137),(382,'Lakhpat',137),(383,'Mundra',137),(384,'Rapar',137),(385,'Kalyanpur',137),(386,'Mehsana',138),(387,'Visnagar',138),(388,'Kadi',138),(389,'Unjha',138),(390,'Patan',138),(391,'Bechraji',138),(392,'Mahesana Rural',138),(394,'Malekpur',138),(395,'Mahisagar',659),(398,'Balasinor',659),(401,'Santrampur',659),(402,'Pavi Jetpur',659),(404,'Morbi',139),(405,'Wankaner',139),(406,'Maliya',139),(407,'Narayangarh',139),(408,'Tankara',139),(409,'Halvad',139),(410,'Rangpur',139),(411,'Narmada',140),(412,'Rajpipla',140),(413,'Dediapada',140),(414,'Tilakwada',140),(415,'Sagbara',140),(416,'Shukhtivav',140),(417,'Navsari',141),(421,'Vankal',141),(422,'Dharampur',141),(424,'Panchmahal',142),(425,'Godhra',142),(426,'Halol',142),(427,'Jambughoda',142),(428,'Kheda',142),(430,'Lunawada',142),(432,'Morwa',142),(433,'Kadana',142),(435,'Radhanpur',143),(436,'Sidhpur',143),(438,'Deesa',143),(440,'Harij',143),(441,'Kankrej',143),(442,'Porbandar',144),(443,'Kutiyana',144),(444,'Madhavpur',144),(445,'Bhanvad',144),(446,'Ranavav',144),(448,'Jasdan',145),(449,'Paddhari',145),(450,'Upleta',145),(451,'Bokhira',145),(452,'Dhoraji',145),(453,'Kankot',145),(454,'Lodhika',145),(455,'Padadhari',145),(456,'Jetpur',145),(457,'Kotda Sangani',145),(458,'Sabarkantha',146),(459,'Himmatnagar',146),(460,'Idar',146),(461,'Prantij',146),(462,'Vadali',146),(463,'Khedbrahma',146),(465,'Modasa',146),(466,'Abu Road',146),(467,'Mansa',146),(468,'Surat',147),(469,'Olpad',147),(470,'Choryasi',147),(471,'Kosamba',147),(473,'Mangrol',147),(474,'Gopi',147),(476,'Ichhpur',147),(477,'Palsana',147),(478,'Sayan',147),(479,'Kamrej',147),(480,'Udhna',147),(481,'Surendranagar',148),(482,'Wadhwan',148),(483,'Chotila',148),(484,'Muli',148),(485,'Lakhtar',148),(486,'Dhrangadhra',148),(487,'Sayla',148),(488,'Vadhvan',148),(489,'Dasada',148),(490,'Viramgam',148),(491,'Tapi',149),(492,'Vyara',149),(493,'Mandvi',149),(494,'Songadh',149),(495,'Nizar',149),(497,'Vadodara',150),(498,'Karjan',150),(499,'Savli',150),(500,'Vaghodia',150),(501,'Waghodia',150),(502,'Padra',150),(503,'Kavant',150),(505,'Kevadia',150),(506,'Jambuva',150),(507,'Madhura',150),(508,'Sankheda',150),(509,'Valsad',151),(510,'Vapi',151),(512,'Pardi',151),(513,'Umbergaon',151),(514,'Khergam',151),(515,'Abrama',151),(517,'Gandevi',151),(519,'Malwan',328),(520,'Kudal',328),(521,'Vengurla',328),(522,'Sawantwadi',328),(523,'Devgad',328),(524,'Dodamarg',328),(525,'Kankavli',328),(527,'Sindhudurg',328),(528,'Ratnagiri',325),(529,'Rajapur',325),(530,'Chiplun',325),(531,'Guhagar',325),(532,'Khed',325),(533,'Dapoli',325),(534,'Lanja',325),(535,'Sangmeshwar',325),(536,'Mandangad',325),(538,'Alibag',324),(539,'Pen',324),(540,'Murud',324),(541,'Mahad',324),(542,'Khalapur',324),(543,'Karjat',324),(544,'Sudhagad',324),(545,'Roha',324),(546,'Uran',324),(547,'Mumbai',314),(561,'Kurla',315),(565,'Thane',330),(566,'Kalyan',330),(568,'Bhiwandi',330),(569,'Murbad',330),(570,'Ambarnath',330),(571,'Ulhasnagar',330),(577,'Palghar',321),(578,'Vikramgad',321),(579,'Vasai',321),(580,'Wada',321),(581,'Jawhar',321),(582,'Dahanu',321),(583,'Mokhada',321),(584,'Talasari',321),(585,'Nashik',661),(586,'Trimbakeshwar',661),(587,'Sinnar',661),(588,'Devla',661),(589,'Igatpuri',661),(591,'Dindori',661),(592,'Nandgaon',661),(593,'Peth',661),(594,'Malegaon',661),(595,'Chandwad',661),(596,'Kalwan',661),(597,'Nandurbar',317),(598,'Shahada',317),(599,'Akrani',317),(600,'Taloda',317),(602,'Rajpur',317),(606,'Chalisgaon',310),(607,'Amalner',310),(608,'Bodwad',310),(609,'Dharangaon',310),(610,'Jalgaon',310),(611,'Bhadgaon',310),(612,'Chopda',310),(613,'Raver',310),(614,'Yawal',310),(615,'Parola',310),(616,'Muktainagar',310),(617,'Erandol',310),(618,'Jamner',310),(619,'Pachora',310),(620,'Bhusawal',310),(621,'Buldhana',304),(622,'Chikhli',304),(623,'Malkapur',304),(625,'Sindkheda',304),(626,'Jalgaon Jamod',304),(629,'Pimpalgaon',304),(630,'Shegaon',304),(631,'Khamgaon',304),(633,'Akot',299),(634,'Balapur',299),(636,'Washim',332),(637,'Malegaon',332),(638,'Risod',332),(639,'Mangrulpir',332),(640,'Manora',332),(641,'Amravati',300),(642,'Bhatukali',300),(644,'Dharni',300),(645,'Chikhaldara',300),(646,'Wardha',331),(647,'Deoli',331),(648,'Seloo',331),(649,'Arvi',331),(650,'Ashti',331),(651,'Karanja',331),(652,'Hinganghat',331),(653,'Samudrapur',331),(654,'Nagpur',318),(655,'Nagpur Rural ',318),(657,'Kamathi',318),(660,'Hingna',318),(661,'Katol',318),(662,'Narkhed',318),(663,'Savner',318),(664,'Kalameshwar',318),(665,'Ramtek',318),(666,'Mouda',318),(667,'Parshivani',318),(668,'Umred',318),(670,'Bhiwapur',318),(678,'Gondia',308),(679,'Goregaon',308),(680,'Salekasa',308),(681,'Tiroda',308),(682,'Amgaon',308),(684,'Arjuni-Morgaon',308),(685,'Sadak-Arjuni',308),(689,'Chamorshi',307),(690,'Mulchera',307),(691,'Aheri',307),(692,'Sironcha',307),(703,'Bhadravati',305),(704,'Varora',305),(705,'Chimur',305),(706,'Nagbhid',305),(707,'Bramhapuri',305),(709,'Mool',305),(710,'Sawli',305),(711,'Gondpimpri',305),(713,'Korpana',305),(715,'Ballarpur',305),(716,'Jivati',305),(718,'Yavatmal',333),(719,'Arni',333),(720,'Babhulgaon',333),(721,'Darwha',333),(722,'Digras',333),(723,'Ghatanji',333),(724,'Kalamb',333),(725,'Mahagaon',333),(726,'Maregaon',333),(727,'Ner',333),(728,'Pandharkawada',333),(729,'Pusad',333),(730,'Ralegaon',333),(731,'Umarkhed',333),(732,'Wani',333),(733,'Zari Jamani',333),(734,'Ardhapur',316),(736,'Biloli',316),(737,'Deglur',316),(738,'Dharmabad',316),(739,'Hadgaon',316),(741,'Kandhar',316),(742,'Kinwat',316),(743,'Loha',316),(744,'Mahur',316),(745,'Mudkhed',316),(746,'Mukhed',316),(747,'Naigaon (Khairgaon)',316),(748,'Nanded',316),(749,'Umri',316),(750,'Hingoli',309),(752,'Kalamnuri',309),(753,'Sengaon',309),(754,'Aundha Nagnath',309),(755,'Parbhani',322),(756,'Gangakhed',322),(757,'Sonpeth',322),(758,'Pathari',322),(759,'Manwath',322),(760,'Palam',322),(761,'Selu',322),(762,'Jintur',322),(763,'Poorna',322),(764,'Jalna',311),(765,'Ambad',311),(766,'Bhokardan',311),(767,'Badnapur',311),(768,'Ghansawangi',311),(769,'Partur',311),(770,'Mantha',311),(771,'Jafrabad',311),(772,'Aurangabad',301),(773,'Paithan',301),(774,'Vaijapur',301),(775,'Gangapur',301),(776,'Khuldabad',301),(777,'Phulambri',301),(778,'Kannad',301),(779,'Sillod',301),(780,'Soegaon',301),(781,'Beed',302),(783,'Gevrai',302),(784,'Ambajogai',302),(785,'Kaij',302),(786,'Parli (Vaijnath)',302),(787,'Majalgaon',302),(788,'Patoda',302),(789,'Shirur Kasar',302),(790,'Wadwani',302),(791,'Dharur',302),(792,'Latur',313),(793,'Ausa',313),(794,'Chakur',313),(795,'Devani',313),(796,'Jalkot',313),(797,'Nilanga',313),(798,'Renapur',313),(799,'Ahmedpur',313),(800,'Shirur Anantpal',313),(801,'Udgir',313),(802,'Osmanabad',320),(803,'Bhoom',320),(805,'Lohara',320),(806,'Omerga',320),(807,'Paranda',320),(808,'Tuljapur',320),(809,'Vashi',320),(810,'Sangola',329),(811,'Akkalkot',329),(812,'Barshi',329),(813,'Karmala',329),(814,'Mangalvedhe',329),(815,'Madha',329),(816,'Mohol',329),(818,'South Solapur',329),(819,'Pandharpur',329),(820,'Malshiras',329),(836,'Pune',323),(837,'Ambegaon',323),(838,'Baramati',323),(839,'Bhor',323),(840,'Daund',323),(841,'Haveli',323),(842,'Indapur',323),(843,'Junnar',323),(844,'Khed',323),(845,'Maval',323),(846,'Mulshi',323),(848,'Purandar',323),(850,'Rajgad',323),(852,'Shahuwadi',312),(854,'Hatkanangale',312),(855,'Shirol',312),(856,'Karveer',312),(857,'Gaganbawada',312),(859,'Kagal',312),(860,'Bhudargad',312),(861,'Azra',312),(862,'Gadhinglaj',312),(863,'Chandgad',312),(864,'Kopargaon',298),(865,'Shrirampur',298),(866,'Nevasa',298),(867,'Rahata',298),(868,'Shrigonda',298),(870,'Vaibhavwadi',328),(871,'Patur',299),(872,'Akola',299),(873,'	Telhara',299),(874,'Daryapur',300),(875,'Tivasa',300),(876,'Anjangaon Surji',300),(879,'Karjat',298),(880,'Nagar',298),(881,'Panhala',312),(882,'Radhanagari',312),(883,'Armory',307),(884,'Desaiganj',307),(885,'Shindkheda',306),(886,'Shirpur',306),(887,'Akkalkuwa',317),(888,'Navapur',317),(889,'Bhokar',316),(890,'Himayatnaga',316),(891,'Some',318),(892,'Niphad',661),(893,'Satana',661),(894,'Surgana',661),(895,'Yeola',661),(896,'Humanat',NULL),(897,'Shirur',323),(898,'Ashti',302),(899,'Cage',302),(900,'Lonar',304),(901,'Motata',304),(902,'Borivali',315),(903,'Andheri ',315),(904,'Arni',NULL),(905,'Babhulgaon',NULL),(906,'	Darwah',NULL),(907,'Digras',NULL),(908,'Ghatji ',NULL),(909,'Jari Jamni',NULL),(910,'Arni ',303),(911,'Babhulgaon',303),(912,'	Darwah',303),(913,'Digras',303),(914,'Ghatji',303),(915,'Jari Jamni',303),(916,'Kalamba',303),(917,'Kelapur',303),(918,'Mahagav',303),(919,'Maregaon',303),(920,'Ner ',303),(921,'Pusad',303),(922,'Ralegaon',303),(923,'Umarkheed',303),(924,'Wani',303),(925,'Yavatmal',303),(926,'Mangaon',324),(927,'Mhasla',324),(928,'Panvel',324),(929,'Poladur',324),(930,'Shrivardhan',324),(932,'Tala',324),(934,'Karanja Lad',332),(945,'Jat',332),(946,'Kavthemahankal',332),(947,'Miraj ',332),(948,'Tasgaon',332),(949,'Atpadi ',332),(950,'Khanapur (Vita)',332),(951,'	Kadegaon',332),(952,'Palus',332),(953,'Valwa',332),(954,'Shirala',332),(955,NULL,332),(956,'Kavthemahankal',332),(957,'Jat',326),(958,'Kavthemahankal',326),(959,'Miraj',326),(960,'Tasgaon',326),(961,'Atpadi',326),(962,'Khanapur (Vita)',326),(963,'Kadegaon',326),(964,'Palus',326),(965,'Valwa',326),(966,'Shirala',326),(989,'Karad',327),(990,'Patan ',327),(991,'Jawli',327),(992,'Satara',327),(993,'Koregaon',327),(994,'Khatav',327),(995,'Maan',327),(996,'Phaltan',327),(997,'Khandala',327),(998,'Wai',327),(999,'Mahabaleshwar',327),(1000,'North  Solapur',329),(1001,'Vasmat',309);
/*!40000 ALTER TABLE `tbltaluka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltalukaarea`
--

DROP TABLE IF EXISTS `tbltalukaarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltalukaarea` (
  `TalukaAreaID` int NOT NULL AUTO_INCREMENT,
  `TalukaAreaName` varchar(50) DEFAULT NULL,
  `TalukaID` int DEFAULT NULL,
  PRIMARY KEY (`TalukaAreaID`),
  KEY `TalukaID` (`TalukaID`),
  CONSTRAINT `tbltalukaarea_ibfk_1` FOREIGN KEY (`TalukaID`) REFERENCES `tbltaluka` (`TalukaID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltalukaarea`
--

LOCK TABLES `tbltalukaarea` WRITE;
/*!40000 ALTER TABLE `tbltalukaarea` DISABLE KEYS */;
INSERT INTO `tbltalukaarea` VALUES (1,'Agresen Colony ',612),(2,'Hareshwar Colony',612),(3,'Gujjar Ali',612),(4,'Bhat Galli',612),(7,'Narmada nagar',612),(9,'Chopda',612);
/*!40000 ALTER TABLE `tbltalukaarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbluserlogin`
--

DROP TABLE IF EXISTS `tbluserlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbluserlogin` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbluserlogin`
--

LOCK TABLES `tbluserlogin` WRITE;
/*!40000 ALTER TABLE `tbluserlogin` DISABLE KEYS */;
INSERT INTO `tbluserlogin` VALUES ('Admin','12345');
/*!40000 ALTER TABLE `tbluserlogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblvehicle`
--

DROP TABLE IF EXISTS `tblvehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblvehicle` (
  `VehicleID` int NOT NULL AUTO_INCREMENT,
  `VehicleName` varchar(50) NOT NULL,
  `VehicleTypeID` int DEFAULT NULL,
  `ChessisNo` varchar(50) NOT NULL,
  `InwardYear` int DEFAULT NULL,
  PRIMARY KEY (`VehicleID`),
  KEY `VehicleTypeID` (`VehicleTypeID`),
  CONSTRAINT `tblvehicle_ibfk_1` FOREIGN KEY (`VehicleTypeID`) REFERENCES `tblvehicletype` (`VehicleTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblvehicle`
--

LOCK TABLES `tblvehicle` WRITE;
/*!40000 ALTER TABLE `tblvehicle` DISABLE KEYS */;
INSERT INTO `tblvehicle` VALUES (1,'MH-20-BL-1956',1,'2',2001),(2,'MH-20-BL-0954',2,'4',2001),(3,'MH-20-BL-0955',3,'5',2001),(4,'MH-20-BL-0956',4,'6',2001),(5,'MH-20-BL-1204',5,'7',2001),(6,'MH-20-BL-1205',6,'8',2002),(7,'MH-14-BT-1323',7,'9',2002),(8,'MH-14-BT-1324',8,'10',2002),(9,'MH-20-BL-1407',9,'11',2002),(10,'MH-20-BL-1408',10,'12',2002),(11,'MH-20-BL-1637',11,'13',2003),(12,'MH-14-BT-1809',12,'14',2003),(13,'MH-14-BT-1851',1,'15',2003),(14,'MH-14-BT-1855',2,'16',2003),(15,'MH-14-BT-1875',3,'17',2003),(16,'MH-14-BT-1876',4,'18',2004),(17,'MH-14-BT-2081',5,'19',2004),(18,'MH-14-BT-2083',6,'20',2004),(19,'MH-14-BT-2142',7,'21',2004),(20,'MH-14-BT-2145',8,'22',2004),(21,'MH-14-BT-2146',9,'23',2005),(22,'MH-14-BT-2176',10,'24',2005),(23,'MH-14-BT-2213',11,'25',2005),(24,'MH-20-BL-0950',12,'26',2001);
/*!40000 ALTER TABLE `tblvehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblvehicletype`
--

DROP TABLE IF EXISTS `tblvehicletype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblvehicletype` (
  `VehicleTypeID` int NOT NULL AUTO_INCREMENT,
  `VehicleTypeName` varchar(50) NOT NULL,
  PRIMARY KEY (`VehicleTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblvehicletype`
--

LOCK TABLES `tblvehicletype` WRITE;
/*!40000 ALTER TABLE `tblvehicletype` DISABLE KEYS */;
INSERT INTO `tblvehicletype` VALUES (1,'Ac - Shivneri'),(2,'Semi Luxuary'),(3,'Ordinary'),(4,'Ordinary Interstate Express'),(5,'Slepper Seater Ordinary'),(6,'Shivshahi'),(7,'Electric Shivai'),(8,'AJ - Shivneri'),(9,'City Bus'),(10,'Electric Bus'),(11,'Slepper Ordinary'),(12,'Medi');
/*!40000 ALTER TABLE `tblvehicletype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblvillage`
--

DROP TABLE IF EXISTS `tblvillage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblvillage` (
  `VillageID` int NOT NULL AUTO_INCREMENT,
  `VillageName` varchar(50) DEFAULT NULL,
  `TalukaID` int DEFAULT NULL,
  PRIMARY KEY (`VillageID`),
  KEY `TalukaID` (`TalukaID`),
  CONSTRAINT `tblvillage_ibfk_1` FOREIGN KEY (`TalukaID`) REFERENCES `tbltaluka` (`TalukaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblvillage`
--

LOCK TABLES `tblvillage` WRITE;
/*!40000 ALTER TABLE `tblvillage` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblvillage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblvillagearea`
--

DROP TABLE IF EXISTS `tblvillagearea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblvillagearea` (
  `VillageAreaID` int NOT NULL AUTO_INCREMENT,
  `VillageAreaName` varchar(50) DEFAULT NULL,
  `VillageID` int DEFAULT NULL,
  PRIMARY KEY (`VillageAreaID`),
  KEY `VillageID` (`VillageID`),
  CONSTRAINT `tblvillagearea_ibfk_1` FOREIGN KEY (`VillageID`) REFERENCES `tblvillage` (`VillageID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblvillagearea`
--

LOCK TABLES `tblvillagearea` WRITE;
/*!40000 ALTER TABLE `tblvillagearea` DISABLE KEYS */;
INSERT INTO `tblvillagearea` VALUES (1,'SSP School',1),(2,'Jhadan Chauk',1),(3,'Kothari Nagar',3),(4,'Upper Maliwada',3),(5,'Kazi Park',3);
/*!40000 ALTER TABLE `tblvillagearea` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-19 10:26:43
