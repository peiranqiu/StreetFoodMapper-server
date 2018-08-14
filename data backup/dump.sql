-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: us-cdbr-iron-east-04.cleardb.net    Database: heroku_6aeb01a5095da02
-- ------------------------------------------------------
-- Server version	5.5.56-log

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
-- Table structure for table `favorite`
--

DROP TABLE IF EXISTS `favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `schedule_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7j2gijcugwbn2wihg0ahyxrit` (`schedule_id`),
  KEY `FKh3f2dg11ibnht4fvnmx60jcif` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=413 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite`
--

LOCK TABLES `favorite` WRITE;
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
INSERT INTO `favorite` VALUES (232,2212,112),(142,12,2),(212,2282,112),(252,2532,12),(262,2452,12),(272,2462,2),(282,2312,2),(292,2122,2),(362,2472,2),(372,2372,2),(332,2522,2),(342,2412,2),(382,2382,2),(392,2532,2);
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holiday`
--

DROP TABLE IF EXISTS `holiday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `holiday` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` int(11) NOT NULL,
  `truck_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbo8fkk14iayx5wygqs2o2f4ey` (`truck_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1723 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holiday`
--

LOCK TABLES `holiday` WRITE;
/*!40000 ALTER TABLE `holiday` DISABLE KEYS */;
INSERT INTO `holiday` VALUES (2,704,2),(12,1130,2),(22,1231,2),(32,101,12),(42,214,12),(52,308,12),(1662,1129,3302),(1682,1224,3302),(1702,1231,3302),(1712,1129,3322),(1722,1224,3322);
/*!40000 ALTER TABLE `holiday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `open_time`
--

DROP TABLE IF EXISTS `open_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `open_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` int(11) NOT NULL,
  `end_time` int(11) NOT NULL,
  `start_time` int(11) NOT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa6hmlpyfj2najvllkgeet2i6` (`schedule_id`)
) ENGINE=MyISAM AUTO_INCREMENT=16573 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `open_time`
--

LOCK TABLES `open_time` WRITE;
/*!40000 ALTER TABLE `open_time` DISABLE KEYS */;
INSERT INTO `open_time` VALUES (2,1,2100,1030,2),(12,2,2100,1030,2),(22,3,2100,1030,2),(32,4,2100,1030,2),(42,5,2000,1030,2),(52,1,2000,900,12),(62,2,2000,900,12),(72,3,2000,900,12),(82,4,2000,900,12),(92,5,2000,800,12),(102,6,2000,800,12),(112,7,2000,1000,12),(122,1,1500,1100,22),(132,2,1500,1100,22),(142,3,1500,1100,22),(152,4,1500,1100,22),(162,5,1500,1100,22),(172,1,2100,1030,32),(182,2,2100,1030,32),(192,3,2100,1030,32),(202,4,2100,1030,32),(212,5,2100,1030,32),(222,6,2100,1030,32),(232,7,2100,1030,32),(242,1,2100,1030,42),(252,2,2100,1030,42),(262,3,2100,1030,42),(272,4,2100,1030,42),(282,5,2100,1030,42),(292,6,2100,1030,42),(302,7,2100,1030,42),(312,1,2000,1030,52),(322,2,2000,1030,52),(332,3,2000,1030,52),(342,4,2000,1030,52),(352,5,2000,1030,52),(362,6,2000,1100,52),(372,7,2000,1100,52),(382,1,2000,1100,62),(392,2,2000,1100,62),(402,3,2000,1100,62),(412,4,2000,1100,62),(422,5,2000,1100,62),(432,6,2000,1100,62),(442,7,2000,1100,62),(452,1,2030,1030,72),(462,2,2030,1030,72),(472,3,2030,1030,72),(482,4,2030,1030,72),(492,5,2030,1030,72),(502,6,2030,1030,72),(512,7,2030,1030,72),(522,6,0,0,2),(532,7,0,0,2),(542,6,0,0,22),(552,7,0,0,22),(9022,2,0,0,1452),(9032,4,0,0,1452),(9042,1,0,0,1452),(9052,3,0,0,1452),(9062,5,0,0,1452),(9072,6,0,0,1452),(9082,7,0,0,1452),(9922,6,0,0,1622),(9912,4,1530,1000,1622),(9902,1,1530,1000,1622),(9892,3,1530,1000,1622),(9882,5,1530,1000,1622),(9872,2,1530,1000,1622),(9862,7,0,0,1622),(10202,7,0,0,1682),(10192,4,1430,1030,1682),(10182,1,1430,1030,1682),(10172,2,1430,1030,1682),(10162,3,1430,1030,1682),(10152,6,0,0,1682),(10142,5,1430,1030,1682),(10482,7,0,0,1722),(10472,5,0,0,1722),(10462,6,0,0,1722),(10452,4,0,0,1722),(10442,3,0,0,1722),(10432,2,0,0,1722),(10422,1,1430,1030,1722),(10552,7,0,0,1732),(10542,5,1430,1030,1732),(10532,6,0,0,1732),(10522,4,1430,1030,1732),(10512,3,1430,1030,1732),(10502,1,1430,1030,1732),(10492,2,1430,1030,1732),(10972,7,0,0,1792),(10962,5,0,0,1792),(10952,4,0,0,1792),(10942,6,0,0,1792),(10932,3,1430,1030,1792),(10922,2,0,0,1792),(10912,1,0,0,1792),(10902,7,0,0,1782),(10892,2,1430,1030,1782),(10882,6,0,0,1782),(10872,1,0,0,1782),(10862,4,0,0,1782),(10852,5,0,0,1782),(10842,3,0,0,1782),(10832,7,0,0,1772),(10822,6,0,0,1772),(10812,5,0,0,1772),(10802,4,1430,1030,1772),(10792,3,0,0,1772),(10782,2,0,0,1772),(10772,1,0,0,1772),(10982,4,0,0,1802),(10992,5,0,0,1802),(11002,2,0,0,1802),(11012,1,0,0,1802),(11022,3,1430,1030,1802),(11032,6,0,0,1802),(11042,7,0,0,1802),(11052,1,1430,1030,1812),(11062,2,1430,1030,1812),(11072,6,0,0,1812),(11082,3,1430,1030,1812),(11092,5,0,0,1812),(11102,7,0,0,1812),(11112,4,0,0,1812),(11122,2,0,0,1822),(11132,3,0,0,1822),(11142,1,1400,1100,1822),(11152,6,0,0,1822),(11162,5,0,0,1822),(11172,4,0,0,1822),(11182,7,0,0,1822),(11192,5,0,0,1832),(11202,3,0,0,1832),(11212,1,1400,1100,1832),(11222,2,0,0,1832),(11232,4,0,0,1832),(11242,7,0,0,1832),(11252,6,0,0,1832),(11262,2,0,0,1842),(11272,1,1330,1100,1842),(11282,4,0,0,1842),(11292,3,0,0,1842),(11302,6,0,0,1842),(11312,5,0,0,1842),(11322,1,0,0,1852),(11332,7,0,0,1842),(11342,2,2000,1400,1852),(11352,4,0,0,1852),(11362,3,0,0,1852),(11372,5,0,0,1852),(11382,6,0,0,1852),(11392,2,1330,1100,1862),(11402,1,0,0,1862),(11412,7,0,0,1862),(11422,4,0,0,1862),(11432,5,0,0,1862),(11442,7,0,0,1852),(11452,3,0,0,1862),(11462,6,0,0,1862),(11472,3,0,0,1872),(11482,4,0,0,1872),(11492,1,0,0,1872),(11502,2,1430,1100,1872),(11512,5,0,0,1872),(11522,7,0,0,1872),(11532,1,0,0,1882),(11542,6,0,0,1872),(11552,2,1330,1100,1882),(11562,3,0,0,1882),(11572,5,0,0,1882),(11582,6,0,0,1882),(11592,1,0,0,1892),(11602,4,0,0,1882),(11612,7,0,0,1882),(11622,2,0,0,1892),(11632,4,0,0,1892),(11642,3,1400,1100,1892),(11652,5,0,0,1892),(11662,6,0,0,1892),(11672,1,0,0,1902),(11682,7,0,0,1892),(11692,2,0,0,1902),(11702,3,0,0,1902),(11712,7,0,0,1902),(11722,4,1330,1100,1902),(11732,5,0,0,1902),(11742,6,0,0,1902),(11752,3,1330,1100,1912),(11762,4,0,0,1912),(11772,2,0,0,1912),(11782,6,0,0,1912),(11792,1,0,0,1912),(11802,7,0,0,1912),(11812,5,0,0,1912),(11822,1,0,0,1922),(11832,2,0,0,1922),(11842,5,0,0,1922),(11852,3,1330,1100,1922),(11862,4,0,0,1922),(11872,7,0,0,1922),(11882,6,0,0,1922),(11892,1,0,0,1932),(11902,4,0,0,1932),(11912,2,0,0,1932),(11922,3,1400,1100,1932),(11932,6,0,0,1932),(11942,5,0,0,1932),(11952,7,0,0,1932),(11962,5,0,0,1942),(11972,1,0,0,1942),(11982,2,0,0,1942),(11992,4,1330,1100,1942),(12002,3,0,0,1942),(12012,6,0,0,1942),(12022,7,0,0,1942),(12032,1,0,0,1952),(12042,5,0,0,1952),(12052,3,0,0,1952),(12062,2,0,0,1952),(12072,4,1400,1100,1952),(12082,1,0,0,1962),(12092,7,0,0,1952),(12102,2,0,0,1962),(12112,6,0,0,1952),(12122,4,1330,1100,1962),(12132,3,0,0,1962),(12142,6,0,0,1962),(12152,7,0,0,1962),(12162,5,0,0,1962),(12172,1,0,0,1982),(12182,3,0,0,1982),(12192,2,0,0,1982),(12202,4,0,0,1982),(12212,6,0,0,1982),(12222,5,1400,1100,1982),(12232,7,0,0,1982),(12242,1,0,0,1972),(12252,2,0,0,1972),(12262,5,1430,1100,1972),(12272,3,0,0,1972),(12282,4,0,0,1972),(12292,7,0,0,1972),(12302,6,0,0,1972),(12312,1,0,0,1992),(12322,2,2100,1100,1992),(12332,3,2100,1100,1992),(12342,4,2100,1100,1992),(12352,5,2200,1100,1992),(12362,6,2200,1100,1992),(12372,7,2200,1100,1992),(12382,3,0,0,2002),(12392,4,0,0,2002),(12402,2,1400,1100,2002),(12412,5,0,0,2002),(12422,6,0,0,2002),(12432,1,0,0,2002),(12442,1,1400,1100,2012),(12452,7,0,0,2002),(12462,3,0,0,2012),(12472,2,0,0,2012),(12482,4,0,0,2012),(12492,5,0,0,2012),(12502,6,0,0,2012),(12512,1,0,0,2022),(12522,3,0,0,2022),(12532,2,0,0,2022),(12542,7,0,0,2012),(12552,4,0,0,2022),(12562,5,1430,1130,2022),(12572,6,0,0,2022),(12582,7,0,0,2022),(12592,5,0,0,2032),(12602,1,0,0,2032),(12612,3,1000,700,2032),(12622,4,1000,700,2032),(12632,2,1000,700,2032),(12642,1,0,0,2042),(12652,6,0,0,2032),(12662,3,0,0,2042),(12672,2,1400,1130,2042),(12682,7,0,0,2032),(12692,5,0,0,2042),(12702,6,0,0,2042),(12712,2,1400,1130,2062),(12722,4,0,0,2042),(12732,7,0,0,2042),(12742,1,0,0,2062),(12752,3,0,0,2062),(12762,4,0,0,2062),(12772,6,0,0,2062),(12782,5,0,0,2062),(12792,7,0,0,2062),(12802,1,0,0,2052),(12812,2,0,0,2052),(12822,7,0,0,2052),(12832,3,1400,1100,2052),(12842,6,0,0,2052),(12852,5,0,0,2052),(12862,4,0,0,2052),(12872,1,0,0,2082),(12882,4,0,0,2082),(12892,6,0,0,2082),(12902,3,0,0,2082),(12912,2,0,0,2082),(12922,5,1400,1100,2082),(12932,7,0,0,2082),(12942,6,0,0,2072),(12952,1,0,0,2072),(12962,3,1500,1100,2072),(12972,2,0,0,2072),(12982,4,0,0,2072),(12992,5,0,0,2072),(13002,7,0,0,2072),(13012,4,1000,700,2092),(13022,1,0,0,2092),(13032,3,1000,700,2092),(13042,2,1000,700,2092),(13052,5,0,0,2092),(13062,6,0,0,2092),(13072,7,0,0,2092),(13082,2,1500,1100,2102),(13092,3,0,0,2102),(13102,1,0,0,2102),(13112,5,1500,1100,2102),(13122,4,1500,1100,2102),(13132,6,0,0,2102),(13142,7,0,0,2102),(13152,3,1900,1100,2112),(13162,2,1900,1100,2112),(13172,1,0,0,2112),(13182,4,0,0,2112),(13192,5,1900,1100,2112),(13202,7,1900,1100,2112),(13212,1,0,0,2132),(13222,2,0,0,2132),(13232,6,1900,1100,2112),(13242,1,1900,1100,2122),(13252,4,1500,1100,2132),(13262,3,0,0,2132),(13272,6,0,0,2132),(13282,2,1900,1100,2122),(13292,5,0,0,2132),(13302,3,1900,1100,2122),(13312,7,0,0,2132),(13322,4,1900,1100,2122),(13332,5,1900,1100,2122),(13342,6,1900,1100,2122),(13352,3,1900,1100,2142),(13362,2,1900,1500,2142),(13372,7,1900,1100,2122),(13382,1,1900,1100,2142),(13392,4,1900,1500,2142),(13402,5,0,0,2142),(13412,6,0,0,2142),(13422,7,0,0,2142),(13432,2,0,0,2152),(13442,1,0,0,2152),(13452,3,0,0,2152),(13462,7,0,0,2152),(13472,4,1900,1500,2152),(13482,5,0,0,2152),(13492,1,0,0,2172),(13502,6,0,0,2152),(13512,2,0,0,2172),(13522,6,1500,1100,2172),(13532,4,0,0,2172),(13542,3,0,0,2172),(13552,5,0,0,2172),(13562,7,0,0,2172),(13572,1,0,0,2162),(13582,2,0,0,2162),(13592,3,0,0,2162),(13602,5,1900,1500,2162),(13612,6,0,0,2162),(13622,4,0,0,2162),(13632,7,0,0,2162),(13642,2,0,0,2182),(13652,3,0,0,2182),(13662,2,0,0,2192),(13672,1,0,0,2182),(13682,5,0,0,2182),(13692,4,0,0,2182),(13702,7,1600,1100,2182),(13712,6,0,0,2182),(13722,3,0,0,2192),(13732,1,0,0,2192),(13742,4,0,0,2192),(13752,5,0,0,2192),(13762,6,1900,1500,2192),(13772,7,0,0,2192),(13782,1,2200,1100,2202),(13792,2,2200,1100,2202),(13802,3,2200,1100,2202),(13812,4,2200,1100,2202),(13822,6,2300,1100,2202),(13832,5,2300,1100,2202),(13842,7,2200,1100,2202),(13852,1,2300,1100,2212),(13862,2,2300,1100,2212),(13872,5,2330,1100,2212),(13882,3,2300,1100,2212),(13892,4,2300,1100,2212),(13902,6,2400,1100,2212),(13912,7,2400,1100,2212),(13922,1,1500,1100,2222),(13932,4,0,0,2222),(13942,5,0,0,2222),(13952,3,0,0,2222),(13962,2,0,0,2222),(13972,6,0,0,2222),(13982,7,0,0,2222),(13992,1,0,0,2232),(14002,2,1500,1100,2232),(14012,4,0,0,2232),(14022,5,0,0,2232),(14032,3,0,0,2232),(14042,6,0,0,2232),(14052,7,0,0,2232),(14062,4,1500,1100,2242),(14072,1,0,0,2242),(14082,2,0,0,2242),(14092,5,0,0,2242),(14102,3,0,0,2242),(14112,2,0,0,2252),(14122,1,0,0,2252),(14132,6,0,0,2242),(14142,7,0,0,2242),(14152,4,0,0,2252),(14162,3,1500,1100,2252),(14172,5,0,0,2252),(14182,1,0,0,2262),(14192,6,0,0,2252),(14202,7,0,0,2252),(14212,2,0,0,2262),(14222,3,0,0,2262),(14232,4,0,0,2262),(14242,6,0,0,2262),(14252,5,1500,1100,2262),(14262,7,0,0,2262),(14272,1,0,0,2272),(14282,2,0,0,2272),(14292,3,0,0,2272),(14302,4,1430,1100,2272),(14312,5,0,0,2272),(14322,6,0,0,2272),(14332,1,1430,1100,2292),(14342,7,0,0,2272),(14352,2,0,0,2292),(14362,4,0,0,2292),(14372,3,0,0,2292),(14382,5,0,0,2292),(14392,6,0,0,2292),(14402,1,0,0,2282),(14412,7,0,0,2292),(14422,2,0,0,2282),(14432,3,1430,1100,2282),(14442,5,0,0,2282),(14452,4,0,0,2282),(14462,6,0,0,2282),(14472,7,0,0,2282),(14482,1,0,0,2302),(14492,2,0,0,2302),(14502,4,0,0,2302),(14512,3,0,0,2302),(14522,6,2400,2000,2302),(14532,5,0,0,2302),(14542,1,0,0,2312),(14552,3,0,0,2312),(14562,7,0,0,2302),(14572,2,0,0,2312),(14582,7,0,0,2312),(14592,5,1430,1100,2312),(14602,4,0,0,2312),(14612,6,0,0,2312),(14752,7,0,0,2342),(14742,6,0,0,2342),(14732,5,0,0,2342),(14722,4,0,0,2342),(14712,2,1430,1130,2342),(14702,3,0,0,2342),(14692,1,0,0,2342),(14762,1,2200,1100,2332),(14772,2,2200,1100,2332),(14782,3,2200,1100,2332),(14792,6,2200,1100,2332),(14802,4,2200,1100,2332),(14812,1,0,0,2352),(14822,5,2200,1100,2332),(14832,2,0,0,2352),(14842,7,1900,1200,2332),(14852,4,0,0,2352),(14862,3,0,0,2352),(14872,5,2000,1130,2352),(14882,6,0,0,2352),(14892,7,0,0,2352),(14902,1,0,0,2362),(14912,2,0,0,2362),(14922,3,1430,1130,2362),(14932,4,0,0,2362),(14942,5,0,0,2362),(14952,6,0,0,2362),(14962,7,0,0,2362),(14972,3,0,0,2382),(14982,2,1400,1130,2382),(14992,1,0,0,2382),(15002,4,0,0,2382),(15012,7,0,0,2382),(15022,1,1400,1130,2372),(15032,5,0,0,2382),(15042,6,0,0,2382),(15052,2,0,0,2372),(15062,3,0,0,2372),(15072,5,0,0,2372),(15082,1,0,0,2392),(15092,6,0,0,2372),(15102,7,0,0,2372),(15112,4,1400,1130,2372),(15122,2,0,0,2392),(15132,7,0,0,2392),(15142,4,0,0,2392),(15152,6,0,0,2392),(15162,5,0,0,2392),(15172,3,1430,1100,2392),(15182,5,1030,700,2402),(15192,3,1030,700,2402),(15202,2,1030,700,2402),(15212,4,1030,700,2402),(15222,6,0,0,2402),(15232,1,1030,700,2402),(15242,7,0,0,2402),(15252,6,0,0,2412),(15262,1,1500,1100,2412),(15272,2,1500,1100,2412),(15282,4,1500,1100,2412),(15292,5,1500,1100,2412),(15302,7,0,0,2412),(15312,3,1500,1100,2412),(16012,5,0,0,2512),(16002,7,0,0,2512),(15992,4,0,0,2512),(15982,6,0,0,2512),(15972,3,0,0,2512),(15962,1,0,0,2512),(15952,2,0,0,2512),(15942,7,0,0,2502),(15932,4,0,0,2502),(15922,6,0,0,2502),(15912,5,0,0,2502),(15902,1,0,0,2502),(15892,3,0,0,2502),(15882,2,0,0,2502),(15532,1,0,0,2452),(15542,4,0,0,2452),(15552,2,1400,1100,2452),(15562,6,0,0,2452),(15572,3,0,0,2452),(15582,7,0,0,2452),(15592,2,0,0,2462),(15602,5,0,0,2452),(15612,1,1400,1100,2462),(15622,3,0,0,2462),(15632,4,0,0,2462),(15642,5,0,0,2462),(15652,7,0,0,2462),(15662,6,0,0,2462),(15672,1,0,0,2472),(15682,2,0,0,2472),(15692,3,1400,1100,2472),(15702,5,0,0,2472),(15712,7,0,0,2472),(15722,4,0,0,2472),(15732,6,0,0,2472),(16022,1,0,0,2522),(16032,2,2100,1500,2522),(16042,3,0,0,2522),(16052,5,0,0,2522),(16062,4,0,0,2522),(16072,7,0,0,2522),(16082,1,0,0,2532),(16092,6,2100,1300,2522),(16102,2,2100,1500,2532),(16112,3,0,0,2532),(16122,4,0,0,2532),(16132,6,0,0,2532),(16142,7,2000,1500,2532),(16152,5,0,0,2532),(16162,2,0,0,2542),(16172,1,0,0,2542),(16182,3,0,0,2542),(16192,4,0,0,2542),(16202,5,0,0,2542),(16212,6,0,0,2542),(16222,1,2000,1100,2552),(16232,7,1600,1300,2542),(16242,2,0,0,2552),(16252,5,2100,1100,2552),(16262,7,0,0,2552),(16272,6,0,0,2552),(16282,3,2000,1100,2552),(16292,4,0,0,2552),(16302,2,2100,1500,2562),(16312,1,0,0,2562),(16322,3,0,0,2562),(16332,6,2100,1300,2562),(16342,7,0,0,2562),(16352,2,2100,1500,2572),(16362,5,0,0,2562),(16372,1,0,0,2572),(16382,4,0,0,2562),(16392,3,0,0,2572),(16402,6,0,0,2572),(16412,4,0,0,2572),(16422,5,0,0,2572),(16432,7,2000,1500,2572),(16442,1,2000,1100,2592),(16452,3,2000,1100,2592),(16462,4,0,0,2592),(16472,6,0,0,2592),(16482,2,0,0,2592),(16492,5,2100,1100,2592),(16502,7,0,0,2592),(16512,5,0,0,2582),(16522,3,0,0,2582),(16532,1,0,0,2582),(16542,2,0,0,2582),(16552,4,0,0,2582),(16562,6,0,0,2582),(16572,7,1600,1300,2582);
/*!40000 ALTER TABLE `open_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `owner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (2,'vendor@bonme.com','foodtruckmapper'),(12,'vendor@grilledcheesenation.com','foodtruckmapper'),(72,'vendor@roxys.com','foodtruckmapper'),(32,'test@test.com','testtest'),(82,'vendor@riceburg.com','foodtruckmapper'),(92,'vendor@diningcar.com','foodtruckmapper'),(102,'vendor@tacoparty.com','foodtruckmapper'),(112,'vendor@pennypacker.com','foodtruckmapper'),(122,'joannfeng.89@gmail.com','3053228399FeSr!');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `href` varchar(255) DEFAULT NULL,
  `truck_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKahp7mqe5di7d17t0lpnkuqr99` (`truck_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4613 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
INSERT INTO `photo` VALUES (2,'https://s3-media2.fl.yelpcdn.com/bphoto/wTyJBhEJI6q71y_dQYNg3g/o.jpg',2),(12,'https://s3-media2.fl.yelpcdn.com/bphoto/oz91m5KZr6fvCEqZdfx5lg/o.jpg',2),(22,'https://s3-media2.fl.yelpcdn.com/bphoto/nQsIejxBTaufnfpV5Pwd8A/o.jpg',2),(32,'https://s3-media2.fl.yelpcdn.com/bphoto/OIzXjk2uA5cIURPywDoi0g/o.jpg',12),(42,'https://s3-media1.fl.yelpcdn.com/bphoto/c50M_4VCkJXiyNdzxfwzfw/o.jpg',12),(52,'https://s3-media3.fl.yelpcdn.com/bphoto/mHZ_uzdxz05H_kOfCacARA/o.jpg',12),(4072,'https://cnrguys.com/wp-content/uploads/2016/03/FoodTruck1.jpg',3312),(4062,'https://s3-media2.fl.yelpcdn.com/bphoto/HHvHlVsj1fktTfF1GUTLBQ/o.jpg',3312),(4052,'https://s3-media3.fl.yelpcdn.com/bphoto/VwjYD3TSwRg98GpZIIw6Iw/o.jpg',3312),(4042,'https://s3-media1.fl.yelpcdn.com/bphoto/eWgP5rN9PRxtuV_6tS-JFw/o.jpg',3302),(4032,'https://s3-media4.fl.yelpcdn.com/bphoto/9kegbzA8jIaPkAluNtBUNA/o.jpg',3302),(4022,'https://s3-media2.fl.yelpcdn.com/bphoto/oC1pAL-7bw1C8JR4W7TNYg/o.jpg',3302),(4082,'https://s3-media4.fl.yelpcdn.com/bphoto/hxF2Wfxw2bJAh9APLex71w/o.jpg',3322),(4092,'https://s3-media1.fl.yelpcdn.com/bphoto/i-3iSoWZ5_Gyd_2J0ehD9w/o.jpg',3322),(4102,'https://s3-media2.fl.yelpcdn.com/bphoto/HO-xEZjYVajyFWD7HpuBOw/o.jpg',3322),(4112,'https://s3-media3.fl.yelpcdn.com/bphoto/NIGvkAS9mS2sYu-HZvYmjw/o.jpg',3332),(4122,'https://s3-media2.fl.yelpcdn.com/bphoto/WbAt1ggL2Z1FePnAtctm6Q/o.jpg',3332),(4132,'https://s3-media4.fl.yelpcdn.com/bphoto/vU_Mhqz125wXVJcwNEnxtw/o.jpg',3332),(4142,'https://s3-media1.fl.yelpcdn.com/bphoto/WQbd1Rr2aw9N85WAexk9vw/o.jpg',3342),(4152,'https://s3-media1.fl.yelpcdn.com/bphoto/rbqH_GF3gl3T6nUg3J6yVA/o.jpg',3342),(4162,'https://s3-media2.fl.yelpcdn.com/bphoto/WYWLz3bOiZVRZPusorv8Yw/o.jpg',3342),(4172,'https://s3-media4.fl.yelpcdn.com/bphoto/F-3P13D1kfpHzfj5PxuB5A/o.jpg',3352),(4182,'https://s3-media3.fl.yelpcdn.com/bphoto/Nr0tyIBQdKkXD8iaDEYHAg/o.jpg',3352),(4192,'https://s3-media3.fl.yelpcdn.com/bphoto/pUuWBTos5qjrtlFeWjnSwg/o.jpg',3352),(4202,'https://s3-media1.fl.yelpcdn.com/bphoto/XyuOTCRU_ncKP2sA16910g/o.jpg',3362),(4212,'https://s3-media3.fl.yelpcdn.com/bphoto/Rl3Mk5fXpn9X-zQLudhrUA/o.jpg',3362),(4222,'https://s3-media2.fl.yelpcdn.com/bphoto/rqRWaWSep7IPOc5O99-TZA/o.jpg',3362),(4232,'https://s3-media2.fl.yelpcdn.com/bphoto/2tlKHYQJU4fQ1voA2Dp8pw/o.jpg',3372),(4242,'https://s3-media2.fl.yelpcdn.com/bphoto/cyN3OsbKgHoj5-zgJnogSA/o.jpg',3372),(4252,'https://s3-media3.fl.yelpcdn.com/bphoto/NN7ScO5ZIOmxIPKPEa6Rkw/o.jpg',3372),(4262,'https://s3-media1.fl.yelpcdn.com/bphoto/zays7GiNfDT6NG5frz__gg/o.jpg',3382),(4272,'https://s3-media4.fl.yelpcdn.com/bphoto/xxDEunf0_25XH1N-c9XbWA/o.jpg',3382),(4282,'https://s3-media2.fl.yelpcdn.com/bphoto/maoFjNQUxpbEZkWzD6Q1zQ/o.jpg',3382),(4292,'https://s3-media2.fl.yelpcdn.com/bphoto/KwL4zMXVA4qj-aDKqNmrjw/o.jpg',3392),(4302,'https://s3-media3.fl.yelpcdn.com/bphoto/MX2j2xAL4WFo1k9Of4VIQA/o.jpg',3392),(4312,'https://s3-media4.fl.yelpcdn.com/bphoto/5jDDsXsdOgF0sivx7H5maA/o.jpg',3392),(4322,'https://s3-media2.fl.yelpcdn.com/bphoto/Dxl_KV1bLPC1isOKenSIkw/o.jpg',3402),(4332,'https://s3-media3.fl.yelpcdn.com/bphoto/RkcExydvsu1JuGt5lq0T1Q/o.jpg',3402),(4342,'https://s3-media2.fl.yelpcdn.com/bphoto/BFgH23awnql68sJTWj8rjw/o.jpg',3402),(4352,'https://rctom.hbs.org/wp-content/uploads/sites/4/2015/12/Clover-Logo.png',3412),(4362,'https://i.pinimg.com/736x/14/d8/5c/14d85c096fa92534e64e0c17788ff288.jpg',3412),(4372,'https://farm5.static.flickr.com/4083/5041074682_e3accb5435_b.jpg',3412),(4432,'http://i1.wp.com/gogiontheblock.com/wp-content/uploads/2016/02/Business-Card-Pic-1-e1456192923175.jpg?zoom=2&resize=1180%2C610',3432),(4412,'https://s3-media1.fl.yelpcdn.com/bphoto/jqPCFC2VP8c0YqVPHO4jog/o.jpg',3432),(4422,'https://s3-media4.fl.yelpcdn.com/bphoto/jFi5Z5MlS_2rzWhmPNrLOw/o.jpg',3432),(4562,'http://www.bostonteastation.com/images/page3_pic3.jpg',3482),(4572,'http://www.bostonteastation.com/images/page3_pic2.jpg',3482),(4582,'https://pbs.twimg.com/media/Bl2quM8IAAAN8zw.jpg',3482),(4592,'http://www.bostonteastation.com/images/page3_pic3.jpg',3492),(4602,'https://pbs.twimg.com/media/Bl2quM8IAAAN8zw.jpg',3492),(4612,'http://www.bostonteastation.com/images/page3_pic2.jpg',3492);
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rating` int(11) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `time_created` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `truck_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiwtvcg8rqlbeai853sdalrkvq` (`truck_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2273 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (2,4,'If it\'s a quick and consistent lunch, then Bon Me is the perfect spot to hit up in the area. I still recall my very first time trying their menu from their...','2018-02-23 05:27:04','Park G.',2),(12,5,'I\'ve been a fan of Bon Me for years - it\'s great for a quick lunch.  You pick your type (Sandwich, Rice, noodle) and then a protein and a sauce.  \n\nI love...','2018-01-23 09:09:21','Shannon V.',2),(22,5,'I experienced Bon Me this afternoon with my 10 month old daughter. My daughter and I loved the brown rice bowl with pork and the veggie viet sandwich ......','2018-07-17 13:20:55','Aneisa C.',2),(32,3,'The guys who work here are incredibly friendly and accommodating. The girls ahead of me in line were conference-goers from Alabama who seemed out of their...','2013-05-28 06:29:25','Marcus W.',12),(42,2,'I was very excited to finally get a chance to try the GNC truck while at SoWa open market recently, especially considering the competition that Roxy\'s...','2011-11-09 16:11:48','Marcus W.',12),(52,3,'I\'d love to see more sandwich varieties on their menu, since grilled cheese is supposed to be their bag. But I have to give them some credit for their punny...','2011-10-13 11:31:11','Jessica W.',12),(2002,5,'These guys are at the 101 Hartwell location on Tuesdays. \n\nThey serve simple, reliable, and delicious eats - its just fresh cooked rice with meat and sauce....','2014-02-03 13:15:32','pete k.',3312),(1992,5,'These guys came to my campus for the first time, and the food is great, they charge $7 for chicken and lamb over rice combo. I really wanna request them to...','2016-06-15 09:25:14','Kunal G.',3312),(1982,5,'Yum!! These guys offer a perfect lunch for hungry foodies on the go. The dishes are simple--seasoned white rice, chicken/lamb/tofu, iceberg lettuce, and...','2016-08-02 16:22:27','Elizabeth S.',3312),(1972,4,'I first found out about this place from my coworker. It is super hidden! It\'s near the South Station T stop and inside of an office building. \n\nWhenever I...','2017-12-06 20:51:39','June-Young C.',3302),(1962,1,'Maybe I came on the wrong day? Monday. Maybe I ordered the wrong thing? Pork over egg noodles. But this place was awful. I wanted to try something new so I...','2018-05-11 18:32:59','Aaron R.',3302),(1952,3,'The foods is cheap, its served fast, they give you a good portion, and its conveniently located in the financial district.\n\nThe flavor and taste? Nothing...','2017-09-19 09:33:53','Rina T.',3302),(2012,3,'I found Mei Mei to be a decent lunch truck.  The food was certainly tasty, it just had a few flaws that give this truck an \"A-OK\" rating in my book.\n\nThe...','2017-10-11 18:35:51','Mike D.',3322),(2022,5,'Mei Mei!!  \nThe food is excellent, consistent and creative whole the staff of warm and friendly. I eat lunch at Mei Mei two days a week at minimum so i can...','2018-03-02 12:15:17','Beth N.',3322),(2032,5,'Such a good Asian fusion restaurant!!! It has a great atmosphere, friendly staff, and best of all it is very sustainable - sourcing from local farms (no...','2018-03-17 15:36:19','Tina L.',3322),(2042,3,'I love bacon! I hate waiting though... I\'ve entered this line at the same time a co-worker entered the other line and even though the Bacon truck\'s line was...','2018-07-16 14:01:41','Hanna G.',3332),(2052,5,'I got the Turkey Avo and to be honest I was really impressed. Both the flavors and presentation were perfect for my money. I\'m definitely going to be going...','2018-07-28 20:39:07','Cody O.',3332),(2062,3,'I was walking by this truck and decided I must try something- it\'s called The Bacon Truck after all. \n\nI ordered the BLT and was expecting something...','2018-06-20 18:57:48','Nav D.',3332),(2072,5,'The service at this food truck is incredibly warm and kind- truly great!\n\nI had the grass-fed beef sliders, which were served on toasty, butter baguette...','2017-03-29 03:31:28','Paige A.',3342),(2082,5,'I marvel at how seemingly healthy food can be so delicious. I would wait in line for a tuna melt. And fresh cut fries? Yup, they have those, too. Just an...','2017-09-27 12:11:34','John W.',3342),(2092,4,'Tried this when they were at Turtle Swamp Brewery and it was delicious. The fries are fantastic! I\'ll look forward to them being there again!','2018-05-18 15:47:53','K M.',3342),(2102,5,'What a happy moment it was stumbling across the Cookie Monstah in Boston Common on a hot day. The name gave me a chuckle, but the cookie and ice cream...','2018-08-04 21:27:24','Gabriel N.',3352),(2112,5,'I\'m careful to say when I\'ve had life changing desserts. The kind that make you want to immediately go buy the same thing again. And then go the next day...','2018-05-30 13:39:36','Nick B.',3352),(2122,4,'Nothing small here, the Cookie Monstah serves up gigantic ice cream sandwiches made to order. A variety of different cookies and different ice creams in...','2018-04-23 13:09:12','Bruce K.',3352),(2132,5,'SO GOOD\n\nNothing but awesome things to say about this place. The Mighty Rib Melt is my absolute fave. So much flavor and a perfect size for the price. The...','2018-04-13 07:37:40','Matt S.',3362),(2142,4,'Roxy\'s is a fun place that does a few spins on grilled cheese. There are limited tables inside but there are seats facing the window along the perimeter- I...','2018-07-06 14:19:11','Sherrin M.',3362),(2152,3,'I want to love everything about this place. But I can\'t give it more than 3 stars. \n\nFirst: the Barcade- it\'s great, but you could end up waiting for hours...','2018-04-01 09:43:58','Daniel T.',3362),(2162,4,'Rice Burg is my favorite food truck in the city. I don\'t actually like the \"rice burg\". The rice bun is tough and extremely messy to eat. I prefer the rice...','2018-04-30 10:29:40','Chilly P.',3372),(2172,1,'I had the Mala spicy chicken and rice bowl from their food truck. The meal consisted of tough-rubbery chicken, rice, and mixed spring leaves and nothing...','2018-07-23 09:52:53','James G.',3372),(2182,2,'Pretty neat idea with rice as the bun. Rice burg came into my work for catering and I was really looking forward to this for quite awhile since it was an...','2018-01-12 21:31:44','Eric D.',3372),(2192,4,'When you have to stand in the sun to order and wait for your sandwich on a hot and humid day and have no regrets, you know a place is worth a visit. They...','2018-08-06 03:21:57','Kate W.',3382),(2202,4,'Tried the Dining Car today while at SOWA. I\'m not sure what happened but the number of food trucks parked at the market has been cut in almost half since...','2018-07-29 13:25:58','Nav D.',3382),(2212,4,'First time trying this food truck, and it won\'t be my last. I got the Grilled Chicken Sandwich. I love how the chicken breast and cucumbers were thinly...','2018-08-06 10:47:02','Valerie S.',3382),(2222,2,'¡Que insípido! I\'m a vegan which is why I decided to give their food truck a try and I wasn\'t impressed at all. I ordered the fried tofu taco and the...','2018-05-22 11:24:47','James I.',3392),(2232,4,'Wow...I just stumped upon this place. I was starving and this spot hit it on the nose, well stomach. For 10 bucks, 2 vegan tacos, rice and black beans. LOTS...','2018-06-17 12:49:10','L T.',3392),(2242,5,'Quality over Quantity\n\nThe portions are not huge, but they are big enough to make a meal.\nThe prices aren\'t cheap, but they won\'t break the bank.\nThe menu...','2018-05-08 14:09:43','Ted Q.',3392),(2252,5,'Had a Pennypacker lunch and it was excellent.  I had a Porchetta sandwich and I couldn\'t get enough.  I am a foody and very picky but this is the best...','2018-03-16 14:45:58','Thomas F.',3402),(2262,4,'First time eating here and I was skeptical but glad I gave it a shot! I ordered the fried chicken sandwich Lebanese style it said on the board where the...','2018-08-10 18:42:37','Kassy B.',3402),(2272,5,'Cranberry and orange relish, Apple/pear butter, lemon pickled fennel....step away from the kitchen and let the sandwich artists cook their works of art! You...','2016-12-18 06:04:19','Donald S.',3402);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_open` bit(1) NOT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `truck_id` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5q80gofkukla8fl45ugl3d88a` (`truck_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2593 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (2,'\0','42.348551','-71.076101',2,'441 Stuart Street, Boston, MA 02116'),(12,'\0','42.362053','-71.057044',2,'100 Hanover St, Boston, MA 02108'),(22,'\0','42.348715','-71.101138',12,'602 Commonwealth Ave, Boston, MA 02215'),(32,'\0','42.318765','-71.175904',2,'210 Boylston St, Newton, MA 02467'),(42,'\0','42.390047','-71.142948',2,'201 Alewife Brook Pkwy, Cambridge, MA 02138'),(52,'\0','42.351259','-71.050148',2,'313 Congress St, Boston, MA 02210'),(62,'\0','42.366101','-71.090971',2,'1 Kendall Square #3105, Cambridge, MA 02139'),(72,'\0','42.365026','-71.079815',2,'60 Binney Street, Cambridge MA 02142'),(1722,'\0','42.3496344','-71.07469100000003',3302,'Clarendon St, Boston, MA, USA'),(1622,'\0','42.361176','-71.09017970000002',3302,'20 Vassar Street, Cambridge, MA, USA'),(1682,'\0','42.3565703','-71.05271800000003',3302,'Howl at the Moon Boston, High Street, Boston, MA, USA'),(1732,'\0','42.3518218','-71.05748389999997',3302,'89 South Street, Boston, MA, USA'),(1782,'\0','42.3407797','-71.0891704',3302,'Opera Place, Boston, MA, USA'),(1772,'\0','42.3938235','-71.14364469999998',3302,'36 Cambridgepark Drive, Cambridge, MA, USA'),(1792,'\0','42.3496816','-71.10421459999998',3302,'Boston University East, Boston, MA, USA'),(1802,'\0','42.3632901','-71.16701009999997',3302,'athenahealth, Arsenal Street, Watertown, MA, USA'),(1812,'\0','42.3534245','-71.05469819999996',3302,'Dewey Square, Boston, MA, USA'),(1822,'\0','42.3552215','-71.0540282',3312,'High Street, Boston, MA, USA'),(1832,'\0','42.3632901','-71.16701009999997',3312,'athenahealth, Arsenal Street, Watertown, MA, USA'),(1842,'\0','42.3659955','-71.08444179999998',3312,'Binney Street, Cambridge, MA, USA'),(1852,'\0','42.3407797','-71.0891704',3312,'Opera Place, Boston, MA, USA'),(1862,'\0','42.4656576','-71.26375580000001',3312,'101 Hartwell Avenue, Lexington, MA, USA'),(1872,'\0','42.3485918','-71.07537049999996',3312,'Trinity Place, Boston, MA, USA'),(1882,'\0','42.3938235','-71.14364469999998',3312,'36 Cambridge Park Drive, Cambridge, MA, USA'),(1892,'\0','42.3571232','-71.05031050000002',3312,'Rowes Wharf, Boston, MA, USA'),(1902,'\0','42.4171049','-71.2584501',3312,'1601 Trapelo Rd, Waltham, MA, USA'),(1912,'\0','42.28105739999999','-71.237596',3312,'Needham Center, Needham, MA, USA'),(1922,'\0','42.3931969','-71.255764',3312,'100 5th Avenue, Waltham, MA, USA'),(1932,'\0','42.3659955','-71.08444179999998',3312,'Binney Street, Cambridge, MA, USA'),(1942,'\0','42.2315003','-71.0142573',3312,'400 Crown Colony Drive, Quincy, MA, USA'),(1952,'\0','42.3605401','-71.05274220000001',3312,'The Greenway Carousel, Rose Kennedy Greenway, Boston, MA, USA'),(1962,'\0','42.4870737','-71.2057006',3312,'44 Mall Road, Burlington, MA, USA'),(1972,'\0','42.3534245','-71.05469819999996',3312,'Dewey Square, Boston, MA, USA'),(1982,'\0','42.3470027','-71.0493568',3312,'27 Wormwood St, Boston, MA, USA'),(1992,'\0','42.3474997','-71.10600039999997',3322,'506 Park Drive, Boston, MA, USA'),(2002,'\0','42.3486838','-71.0395623',3332,'South Boston Maritime Park, South Boston, Boston, MA, USA'),(2012,'\0','42.3568819','-71.0576489',3332,'Milk Street Cafe, Milk Street, Boston, MA, USA'),(2022,'\0','42.3534245','-71.05469819999996',3332,'Dewey Square, Boston, MA, USA'),(2032,'','42.3534245','-71.05469819999996',3342,'Dewey Square, Boston, MA, USA'),(2042,'\0','42.3944274','-71.14610490000001',3342,'150 Cambridgepark Drive, Cambridge, MA, USA'),(2052,'\0','42.357446','-71.05474349999997',3342,'Milk St, Boston, MA, USA'),(2062,'\0','42.3499608','-71.07640850000001',3342,'Copley Square, Boston, MA, Boston, MA, USA'),(2072,'\0','42.3763452','-71.1166043',3342,'Harvard University Science Center, Oxford Street, Cambridge, MA, USA'),(2082,'\0','42.3938235','-71.14364469999998',3342,'36 Cambridge Park Drive, Cambridge, MA, USA'),(2092,'','42.3519404','-71.05507979999999',3342,'South Station, Atlantic Avenue, Boston, MA, USA'),(2102,'\0','42.3500641','-71.0624052',3352,'Chinatown, Boston, MA, USA'),(2112,'\0','42.3549544','-71.06548859999998',3352,'Boston Common, Tremont Street, Boston, MA, USA'),(2122,'\0','42.3605401','-71.05274220000001',3352,'The Greenway Carousel, Rose Kennedy Greenway, Boston, MA, USA'),(2132,'\0','42.241031','-71.003354',3352,'Franklin St @ Pearl St, Quincy, MA, USA'),(2142,'\0','42.3534245','-71.05469819999996',3352,'Dewey Square, Boston, MA, USA'),(2152,'\0','42.3524809','-71.0468732',3352,'Seaport Boulevard, Boston, MA, USA'),(2162,'\0','42.3571232','-71.05031050000002',3352,'Rowes Wharf, Boston, MA, USA'),(2172,'\0','42.3496344','-71.07469100000003',3352,'Clarendon Street, Boston, MA, USA'),(2182,'\0','42.342125','-71.06381599999997',3352,'SoWa Open Market, Harrison Avenue, Boston, MA, USA'),(2192,'\0','42.3407797','-71.0891704',3352,'Opera Place, Boston, MA, USA'),(2202,'\0','42.371826','-71.08437700000002',3362,'485 Cambridge Street, Cambridge, MA, USA'),(2212,'\0','42.3620629','-71.09839390000002',3362,'292 Massachusetts Avenue, Cambridge, MA, USA'),(2222,'\0','42.3496816','-71.10421459999998',3372,'Boston University East, Boston, MA, USA'),(2232,'\0','42.3552215','-71.0540282',3372,'High Street, Boston, MA, USA'),(2242,'\0','42.2809285','-71.2377548',3372,'Needham, MA, USA'),(2252,'\0','42.3595761','-71.10771569999997',3372,'Cambridgeport, Cambridge, MA, USA'),(2262,'\0','42.3628741','-71.09009709999998',3372,'Kendall Square, Cambridge, MA, USA'),(2272,'\0','42.3486838','-71.0395623',3382,'South Boston Maritime Park, Boston, MA, USA'),(2282,'\0','42.3571232','-71.05031050000002',3382,'Rowes Wharf, Boston, MA, USA'),(2292,'\0','42.3496291','-71.0718319',3382,'Stuart Street, Boston, MA, USA'),(2302,'\0','42.3671354','-71.10564920000002',3382,'Cambridge City Hall, Massachusetts Avenue, Cambridge, MA, USA'),(2312,'\0','42.3351204','-71.07346619999998',3382,'Boston Medical Center Place, Boston, MA, USA'),(2332,'\0','42.4001506','-71.112323',3392,'711 Broadway, Somerville, MA, USA'),(2342,'\0','42.3565143','-71.0558474',3392,'Post Office Square, Boston, MA, USA'),(2352,'\0','42.376431','-71.11691819999999',3392,'1 Oxford Street, Cambridge, MA, USA'),(2362,'\0','42.3534245','-71.05469819999996',3392,'Dewey Square, Boston, MA, USA'),(2372,'\0','42.3597924','-71.05158210000002',3402,'Aquarium, State Street, Boston, MA, USA'),(2382,'\0','42.3524809','-71.0468732',3402,'Seaport Blvd, Boston, MA, USA'),(2392,'\0','42.3534245','-71.05469819999996',3402,'Dewey Square, Boston, MA, USA'),(2402,'','42.3534245','-71.05469819999996',3412,'Dewey Square, Boston, MA, USA'),(2412,'\0','42.3534245','-71.05469819999996',3412,'Dewey Square, Boston, MA, USA'),(2522,'\0','42.3500641','-71.0624052',3482,'Chinatown, Boston, MA, USA'),(2452,'\0','42.3944274','-71.14610490000001',3432,'150 Cambridgepark Drive, Cambridge, MA, USA'),(2462,'\0','42.3541199','-71.0541111',3432,'219-235 Congress St, Boston, MA, USA'),(2472,'\0','42.3565805','-71.05112859999997',3432,'The Trillium Garden on The Greenway, High Street, Boston, MA, USA'),(2532,'\0','42.3499608','-71.07640850000001',3482,'Copley Square, Boston, MA, Boston, MA, USA'),(2542,'\0','42.34124629999999','-71.06686869999999',3482,'540 Harrison Avenue, Boston, MA, USA'),(2552,'\0','42.3587725','-71.05189639999998',3482,'Greenway Open Market, Boston, MA, USA');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `truck`
--

DROP TABLE IF EXISTS `truck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `truck` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `twitter` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `yelp_id` varchar(255) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `category1` varchar(255) DEFAULT NULL,
  `category2` varchar(255) DEFAULT NULL,
  `category3` varchar(255) DEFAULT NULL,
  `is_open` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbj0xrta7n3uxfgk10vl5hxil9` (`owner_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3493 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `truck`
--

LOCK TABLES `truck` WRITE;
/*!40000 ALTER TABLE `truck` DISABLE KEYS */;
INSERT INTO `truck` VALUES (2,'http://www.bonmetruck.com/menu','Bon Me','+16176528462',4,'https://twitter.com/bonme','https://www.yelp.com/biz/bon-me-boston?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','http://www.bonmetruck.com','saXIDQwa1XWroW-qGrMtvQ',2,'VIETNAMESE','CHINESE','SANDWICHES',NULL),(12,'https://www.grilledcheesenation.net/menu/','Grilled Cheese Nation','+16174610176',3,'https://twitter.com/gcnboston','https://www.yelp.com/biz/grilled-cheese-nation-boston?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','https://www.grilledcheesenation.net/','hOFIR5nn_7Ks7i7uEohjGg',12,'CHEESE','SANDWICHES','AMERICAN',NULL),(3312,'https://cnrguys.com/menu-and-locations/#our-menu','Chicken & Rice Guys','+16179038538',5,'https://twitter.com/cnrguys','https://www.yelp.com/biz/chicken-and-rice-guys-2-lexington?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','https://cnrguys.com/','ir5TqpRABBNn3eVPFu9YsA',32,'AMERICAN','SANDWICHES','CHEESE',NULL),(3302,'http://sategrill.com/menu/','Saté Asian Grill','+16176156264',4,'https://twitter.com/SateTweets','https://www.yelp.com/biz/sat%C3%A9-asian-grill-boston-4?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','http://sategrill.com/','Lo7JgnZVBlMSSVfYbKzHrA',32,'AMERICAN','ASIAN','BREAKFAST',NULL),(3322,'http://www.meimeiboston.com/menu','Mei Mei Street Kitchen','+18572504959',4,'https://twitter.com/meimeiboston','https://www.yelp.com/biz/mei-mei-street-kitchen-boston-4?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','http://www.meimeiboston.com/','SRxyxADqvY3gb8f76nDRTQ',32,'AMERICAN','ASIAN','BREAKFAST',NULL),(3332,'http://bostonbacontruck.com/menu.html','The Bacon Truck','+12016949060',4,'https://twitter.com/BaconTruckBOS','https://www.yelp.com/biz/the-bacon-truck-boston?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','http://bostonbacontruck.com/','p3CawT4AVQ3LOiq4OQoTaA',32,'AMERICAN','CHEESE','SANDWICHES',NULL),(3342,'https://www.complimentsfood.com/our-foods','Compliments Food','+16178956058',4,'https://twitter.com/complimentsfood','https://www.yelp.com/biz/compliments-food-cambridge?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','https://www.complimentsfood.com/','qytlbr87dHjrWr5t-pRMIA',32,'HALAL','BREAKFAST','DRINKS',NULL),(3352,'http://www.thecookiemonstah.com/ox_portfolio/portfolio/','Cookie Monstah','+16176156595',4,'https://twitter.com/MonstahTruck','https://www.yelp.com/biz/cookie-monstah-food-truck-boston?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','http://www.thecookiemonstah.com/','Dvw7FkVuMqzUzrv-CQpMpg',32,'AMERICAN','ICECREAM','DRINKS',NULL),(3362,'https://www.roxysgrilledcheese.com/#new-page-section','Roxy\'s Grilled Cheese','+16179457244',4,'https://twitter.com/RoxysGrilledChz','https://www.yelp.com/biz/roxys-grilled-cheese-cambridge-3?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','https://www.roxysgrilledcheese.com','WFq2lgglSCBETcfoedvbzA',72,'AMERICAN','CHEESE','SANDWICHES',NULL),(3372,'http://www.riceburg1.com/catering-menu.html','Rice Burg','+16463716531',3,'https://twitter.com/Riceburg1','https://www.yelp.com/biz/rice-burg-boston?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','http://www.riceburg1.com/','CwGXGWKENxJ6XsvuSPs5oQ',82,'JAPANESE','SANDWICHES','ASIAN',NULL),(3382,'http://diningcar.net/menu/','The Dining Car','+19086923531',3,'https://twitter.com/thediningcar','https://www.yelp.com/biz/the-dining-car-boston-4?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','http://diningcar.net/','T16IHgu69RrBf4-XaF7B3w',92,'AMERICAN','SANDWICHES','BURGERS',NULL),(3392,'http://www.tacopartytruck.com/tacopress/#menu','Taco Party','+16177640683',4,'https://twitter.com/tacopartytruck','https://www.yelp.com/biz/taco-party-somerville-4?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','http://www.tacopartytruck.com/','ht4FgeAhWVjj4aY7ZMlKzg',102,'TACOS','CHEESE','BREAKFAST',NULL),(3402,'http://pennypackersfinefoods.com/#menus-section','Pennypackers Fine Food','+18575238053',4,'https://twitter.com/pennypackers','https://www.yelp.com/biz/pennypackers-fine-food-somerville-2?adjust_creative=BwJ3CMFRDnSBshLJ21wwrg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=BwJ3CMFRDnSBshLJ21wwrg','http://pennypackersfinefoods.com/','IBjXi7rUmGpCGBjftd3dcw',112,'SALADS','SANDWICHES','AMERICAN',NULL),(3412,'https://www.cloverfoodlab.com/locations/','Clover Food Lab','+16175622435',1,'https://twitter.com/cloverfoodlab','not provided','https://www.cloverfoodlab.com/',NULL,122,'VEGETARIAN','SALADS','SANDWICHES',NULL),(3432,'http://gogiontheblock.com/menu/foodtruckmenu/','Goji on the Block','+16178179079',1,'https://twitter.com/gogiontheblock','not provided','http://gogiontheblock.com/',NULL,122,'AMERICAN','ASIAN','BREAKFAST',NULL),(3482,'http://www.bostonteastation.com/menu.html','Tea Station','not provided',1,'https://twitter.com/teastationbosto','','http://www.bostonteastation.com/',NULL,32,'ASIAN','DRINKS','DESSERT',NULL);
/*!40000 ALTER TABLE `truck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'user@gmail.com','foodtruckmapper'),(12,'admin','admin'),(112,'joannfeng.89@gmail.com','3053228399FeSr!');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'heroku_6aeb01a5095da02'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-14 10:20:27
