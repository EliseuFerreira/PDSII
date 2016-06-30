use ticket;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_departamento`
--

LOCK TABLES `tb_departamento` WRITE;
/*!40000 ALTER TABLE `tb_departamento` DISABLE KEYS */;
INSERT INTO `tb_departamento` VALUES (1,'ServiceDesk'),(2,'HelpDesk'),(4,'Suporta Pessoa Fisica'),(5,'Vendas Web'),(6,'Implantação'),(8,'Comercial'),(10,'Financeiro');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tecnico`
--

LOCK TABLES `tb_tecnico` WRITE;
/*!40000 ALTER TABLE `tb_tecnico` DISABLE KEYS */;
INSERT INTO `tb_tecnico` VALUES (1,'eliseumcd@gmail.com','Eliseu Macedo','\0',1),(2,'marcoantonio@gmail.com','Marco Antonio','',1),(3,'isabelmacedo@gmsolucoes.com.br','Isabel Macedo','',2),(4,'dhenrique@hotmai.com','Diego Henrique','',8),(5,'dribeiro@gmsolucoes.com.br','Diego Modesto','',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ticket`
--

LOCK TABLES `tb_ticket` WRITE;
/*!40000 ALTER TABLE `tb_ticket` DISABLE KEYS */;
INSERT INTO `tb_ticket` VALUES (1,'Problemas ao acessar o site de compras','2016-05-23 18:02:37','2016-06-10 17:12:49','Ao tentar realizar login no site ocorreu o erro OleDB','joquim@gmail.com','Joaquim Jose da Silva Xavier',1234,'2','0','\0',5),(2,'Erro na agecia de venda, no arquivo QTKPrinter','2016-05-23 01:17:16',NULL,'Ao tentar logar no sistema ocorre o erro no arquivo QKTPrinter informando que o número do arquivo de controle é diferente do da impressora.','mjuina@gmail.com.br','Viação Juina - Marlos',123456,'3','0','\0',1),(3,'Problemas ao realizar a impressão do bilhete de passagem.','2016-05-23 01:19:39','2016-05-23 19:39:59','Erro no arquivo de controle da impressora.','eliseumcd@gmail.com','Eliseu Ferreira Macedo',123456,'2','0','\0',2),(4,'finality','2016-05-23 18:11:31',NULL,'finality','jgomes@gmail.com','Jeziel Gomes',1000000,'3','0','\0',2),(5,'Problemas ao realizar acesso a internet','2016-06-10 16:26:54',NULL,'tyestestestsetsaet','jalves@gmail.com','José Alvez',123456,'3','0','',3),(6,'Erro ao acessar o painel do netviagem','2016-06-10 16:32:25',NULL,'Tentei acessar o painel do netviagem para recarregar os trechos que foram criados no sistema de vendas, porém não foi possível por que não consigo lembrar minha senha, e o botão de enviar a senha por email não está liberado.','jsoliveira','José Silveira de oliveira',3216545,'3','0','',4),(35,'Problemas com a licença da agência','2016-06-10 16:39:12',NULL,'Boa tarde gostaria de solicitar se possível a troca da licença da agência de Sigla para a agência de sigla\nOu seja, a agencia JRA que encontra-se licenciada, ser removida a licença da mesma para utilizar na','agolveia@hotmail.com','Alex Golveia',321654987,'2','0','',1),(36,'Erro ao habilitar cadastro do Órgão','2016-06-10 16:40:30',NULL,'Fomos  habilitar o cadastro do órgão, para exigir o preenchimento da carteirinha no cadastro vip, porém o sistema não está salvando quando inserido.','suporte@viacaojuina.com.br','Viação Juina -Thiago',3167,'1','0','',NULL),(37,'Solicitação de licença','2016-06-10 16:45:10','2016-06-10 17:13:07','Olá, gostaria de solicitar novamente a licença abaixo o mais rápido possível.\nCOMA - COBRADORES E MOTORISTAS DA EMP\n\nFico no aguardo. Obrigado\nHailson Almeida\nSuporte CPD - Boa Esperança','cpd@boaesp.com.br','Boa Esperança - Hailson',3155,'0',NULL,'\0',1),(38,'Problema na licença boa esperança','2016-06-10 17:04:38',NULL,'Olá, gostaria de solicitar novamente a licença abaixo o mais rápido possível.\nCOMA - COBRADORES E MOTORISTAS DA EMP\n\nFico no aguardo. Obrigado\nHailson Almeida\nSuporte CPD - Boa Esperança','cpd@boaesp.com.br','Boa esperança - Lucas',3166,'2','0','',4),(39,'Problemas no estoque de passagens','2016-06-10 17:20:28',NULL,'Neste relatório de estoque as passagens da agência TR ICEM, da numeração 457690 à 457700, série UN8 constam como não utilizadas e elas estão vendidas no caixa 3160, conforme anexo.\nGostaria de saber o que aconteceu ?','ccelico@viacaosaoraphael.com.br','São Raphael - Christianne',3138,'3','0','',1);
/*!40000 ALTER TABLE `tb_ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-10 18:05:35
