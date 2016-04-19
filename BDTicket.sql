CREATE DATABASE  IF NOT EXISTS `ticket` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ticket`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: ticket
-- ------------------------------------------------------
-- Server version	5.6.26

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
-- Table structure for table `tb_departamento`
--

DROP TABLE IF EXISTS `tb_departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_departamento` (
  `codDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_departamento`
--

LOCK TABLES `tb_departamento` WRITE;
/*!40000 ALTER TABLE `tb_departamento` DISABLE KEYS */;
INSERT INTO `tb_departamento` VALUES (1,'ServiceDesk'),(2,'HelpDesk'),(3,'Suporte Corporativo'),(4,'Suporta Pessoa Fisica'),(5,'Vendas Web'),(6,'Implantação'),(7,'Financeiro'),(8,'Comercial');
/*!40000 ALTER TABLE `tb_departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tecnico`
--

DROP TABLE IF EXISTS `tb_tecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tecnico` (
  `codTecnico` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `departamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`codTecnico`),
  KEY `FK_dt2hfexxfthpjs1tvuhl3i9xi` (`departamento`),
  CONSTRAINT `FK_dt2hfexxfthpjs1tvuhl3i9xi` FOREIGN KEY (`departamento`) REFERENCES `tb_departamento` (`codDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tecnico`
--

LOCK TABLES `tb_tecnico` WRITE;
/*!40000 ALTER TABLE `tb_tecnico` DISABLE KEYS */;
INSERT INTO `tb_tecnico` VALUES (1,'eliseumcd@gmail.com','Eliseu Macedo','',1),(2,'marcoantonio@gmail.com','Marco Antonio','',1),(3,'isabelmacedo@gmsolucoes.com.br','Isabel Macedo','',2);
/*!40000 ALTER TABLE `tb_tecnico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ticket`
--

DROP TABLE IF EXISTS `tb_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_ticket` (
  `codTicket` int(11) NOT NULL AUTO_INCREMENT,
  `assunto` varchar(255) DEFAULT NULL,
  `dataAbertura` datetime DEFAULT NULL,
  `dataFechamento` datetime DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nomeResponsavel` varchar(255) DEFAULT NULL,
  `osBeany` int(11) DEFAULT NULL,
  `prioridade` varchar(255) DEFAULT NULL,
  `situacao` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `tecnico` int(11) DEFAULT NULL,
  PRIMARY KEY (`codTicket`),
  KEY `FK_ta2tadppu1ru29r5af9tuyqfk` (`tecnico`),
  CONSTRAINT `FK_ta2tadppu1ru29r5af9tuyqfk` FOREIGN KEY (`tecnico`) REFERENCES `tb_tecnico` (`codTecnico`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ticket`
--

LOCK TABLES `tb_ticket` WRITE;
/*!40000 ALTER TABLE `tb_ticket` DISABLE KEYS */;
INSERT INTO `tb_ticket` VALUES (1,'Problemas ao acessar o site de compras','2016-04-18 22:30:01',NULL,'Ao tentar realizar login no site ocorreu o erro OleDB','joquim@gmail.com','Joaquim Jose da Silva Xavier',1234,'alta','aberto','',1);
/*!40000 ALTER TABLE `tb_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ticket'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-19  0:13:27
