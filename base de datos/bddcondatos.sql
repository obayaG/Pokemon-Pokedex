CREATE DATABASE  IF NOT EXISTS `bdpokedex` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bdpokedex`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: bdpokedex
-- ------------------------------------------------------
-- Server version	5.7.34-log

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
-- Table structure for table `habilidad`
--

DROP TABLE IF EXISTS `habilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habilidad` (
  `idHabilidad` int(11) NOT NULL AUTO_INCREMENT,
  `habilidad` varchar(45) NOT NULL,
  `idPokemonDato` int(11) NOT NULL,
  PRIMARY KEY (`idHabilidad`),
  KEY `fk_pokedato_idx` (`idPokemonDato`),
  CONSTRAINT `fk_pokedato` FOREIGN KEY (`idPokemonDato`) REFERENCES `pokemondato` (`idPokemonDato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habilidad`
--

LOCK TABLES `habilidad` WRITE;
/*!40000 ALTER TABLE `habilidad` DISABLE KEYS */;
INSERT INTO `habilidad` VALUES (1,'ataquePichu1',1),(2,'ataquePichu2',1),(3,'ataquePichu3',1),(4,'ataquePikachu1',2),(5,'ataquePikachu2',2),(6,'ataqueRaichu1',3),(7,'ataqueRaichu2',3),(8,'ataquePidgey1',4),(9,'ataquePidgey2',4),(10,'ataquePidgeotto1',5),(11,'ataquePidgeotto2',5),(12,'ataquePidgeot1',6),(13,'ataquePidgeot2',6),(14,'ataqueWooper1',7),(15,'ataqueWooper2',7),(16,'ataqueQuagsire1',8),(17,'ataqueQuagsire2',8),(18,'ataqueCharmander1',9),(19,'ataqueCharmander2',9),(20,'ataqueCharmaleon1',10),(21,'ataqueCharmaleon2',10),(22,'ataqueCharizard1',11),(23,'ataqueCharizard2',11);
/*!40000 ALTER TABLE `habilidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemondato`
--

DROP TABLE IF EXISTS `pokemondato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemondato` (
  `idPokemonDato` int(11) NOT NULL,
  `nombrePokemon` varchar(45) NOT NULL,
  `nivelSiguienteEvolucion` int(11) NOT NULL,
  `idPokemonRaza` int(11) NOT NULL,
  `ordenEvolucion` int(11) DEFAULT NULL,
  `idTipo1` int(11) NOT NULL,
  `idTipo2` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPokemonDato`),
  KEY `fk_poke_raza_idx` (`idPokemonRaza`),
  KEY `fk_tipo_idx` (`idTipo1`),
  KEY `fk_tipo2_idx` (`idTipo2`),
  CONSTRAINT `fk_poke_raza` FOREIGN KEY (`idPokemonRaza`) REFERENCES `pokemonraza` (`idPokemonRaza`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo` FOREIGN KEY (`idTipo1`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo2` FOREIGN KEY (`idTipo2`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemondato`
--

LOCK TABLES `pokemondato` WRITE;
/*!40000 ALTER TABLE `pokemondato` DISABLE KEYS */;
INSERT INTO `pokemondato` VALUES (1,'Pichu',10,1,1,1,2),(2,'Pikachu',15,1,2,1,2),(3,'Raichu',20,1,3,1,2),(4,'Pidgey',18,2,1,4,5),(5,'Pidgeotto',36,2,2,4,5),(6,'Pidgeot',40,2,3,4,5),(7,'Wooper',20,3,1,6,7),(8,'Quagsire',40,3,2,6,7),(9,'Charmander',16,4,1,8,2),(10,'Charmaleon',36,4,2,8,2),(11,'Charizard',40,4,3,8,2);
/*!40000 ALTER TABLE `pokemondato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemonraza`
--

DROP TABLE IF EXISTS `pokemonraza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemonraza` (
  `idPokemonRaza` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idPokemonRaza`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemonraza`
--

LOCK TABLES `pokemonraza` WRITE;
/*!40000 ALTER TABLE `pokemonraza` DISABLE KEYS */;
INSERT INTO `pokemonraza` VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10);
/*!40000 ALTER TABLE `pokemonraza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemonusuario`
--

DROP TABLE IF EXISTS `pokemonusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemonusuario` (
  `idPokemonUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nivel` int(11) NOT NULL,
  `idPokemonDato` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPokemonUsuario`),
  KEY `fk_pokedato_idx` (`idPokemonDato`),
  KEY `fk_usuario_idx` (`idUsuario`),
  CONSTRAINT `fk_idPokemonDato` FOREIGN KEY (`idPokemonDato`) REFERENCES `pokemondato` (`idPokemonDato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemonusuario`
--

LOCK TABLES `pokemonusuario` WRITE;
/*!40000 ALTER TABLE `pokemonusuario` DISABLE KEYS */;
INSERT INTO `pokemonusuario` VALUES (1,5,1,1),(2,11,2,1),(3,18,3,1),(4,16,4,2),(5,38,11,4),(6,16,9,4),(7,20,10,4),(8,11,2,4);
/*!40000 ALTER TABLE `pokemonusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo` (
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'electrico'),(2,'no tiene segundo tipo'),(3,'psiquico'),(4,'normal'),(5,'volador'),(6,'agua'),(7,'tierra'),(8,'fuego'),(9,'planta'),(10,'roca'),(11,'veneno'),(12,'siniestro'),(13,'hielo'),(14,'hada'),(15,'fantasma'),(16,'dragon'),(17,'bicho'),(18,'acero');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Juan'),(2,'Ana'),(3,'Pedro'),(4,'Ash');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-07 17:06:41
