/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50517
 Source Host           : localhost
 Source Database       : pibid

 Target Server Type    : MySQL
 Target Server Version : 50517
 File Encoding         : utf-8

 Date: 01/28/2013 17:07:15 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `atividades`
-- ----------------------------
DROP TABLE IF EXISTS `atividades`;
CREATE TABLE `atividades` (
  `ID` int(11) NOT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  `data_previsao_inicio` datetime DEFAULT NULL,
  `data_previsao_fim` datetime DEFAULT NULL,
  `data_efetiva_conclusao` datetime DEFAULT NULL,
  `situacao` varchar(45) DEFAULT NULL,
  `obs_gerais` varchar(45) DEFAULT NULL,
  `projetos_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_atividades_projetos1` (`projetos_ID`),
  KEY `FK752C844C75FCCFD2` (`projetos_ID`),
  CONSTRAINT `FK752C844C75FCCFD2` FOREIGN KEY (`projetos_ID`) REFERENCES `projetos` (`ID`),
  CONSTRAINT `fk_atividades_projetos1` FOREIGN KEY (`projetos_ID`) REFERENCES `projetos` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `bolsistas`
-- ----------------------------
DROP TABLE IF EXISTS `bolsistas`;
CREATE TABLE `bolsistas` (
  `matricula` varchar(45) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `email_principal` varchar(45) DEFAULT NULL,
  `email_secundario` varchar(45) DEFAULT NULL,
  `telefone_residencial` varchar(45) DEFAULT NULL,
  `telefone_celular` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `situacao` varchar(45) NOT NULL DEFAULT 'ativo',
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `bolsistas`
-- ----------------------------
BEGIN;
INSERT INTO `bolsistas` VALUES ('2009', 'Victor', 'teste', '', '', '', '', 'Ativo', '0');
COMMIT;

-- ----------------------------
--  Table structure for `escolas_parceiras`
-- ----------------------------
DROP TABLE IF EXISTS `escolas_parceiras`;
CREATE TABLE `escolas_parceiras` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `esfera` varchar(45) NOT NULL,
  `nome_diretor` varchar(45) NOT NULL,
  `nome_vice_diretor_manha` varchar(45) DEFAULT NULL,
  `nome_vice_diretor_tarde` varchar(45) DEFAULT NULL,
  `nome_vice_diretor_noite` varchar(45) DEFAULT NULL,
  `telefone_escola` varchar(45) DEFAULT NULL,
  `email_escola` varchar(45) DEFAULT NULL,
  `email_direcao` varchar(45) DEFAULT NULL,
  `email_vice_direcao` varchar(45) DEFAULT NULL,
  `situacao` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `papel`
-- ----------------------------
DROP TABLE IF EXISTS `papel`;
CREATE TABLE `papel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `papel`
-- ----------------------------
BEGIN;
INSERT INTO `papel` VALUES ('1', 'Master');
COMMIT;

-- ----------------------------
--  Table structure for `professores_colaboradores`
-- ----------------------------
DROP TABLE IF EXISTS `professores_colaboradores`;
CREATE TABLE `professores_colaboradores` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email_principal` varchar(45) DEFAULT NULL,
  `email_secundario` varchar(45) DEFAULT NULL,
  `telefone_residencial` varchar(45) DEFAULT NULL,
  `telefone_celular` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `instituicao` varchar(45) DEFAULT NULL,
  `situacao` varchar(45) NOT NULL DEFAULT 'ativo',
  `status` varchar(45) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `projetos`
-- ----------------------------
DROP TABLE IF EXISTS `projetos`;
CREATE TABLE `projetos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `titulo_projeto` varchar(45) DEFAULT NULL,
  `data_conclusao` date DEFAULT NULL,
  `curso` varchar(45) DEFAULT NULL,
  `nome_coordenador` varchar(45) DEFAULT NULL,
  `telefone_residencial_coordenador` varchar(45) DEFAULT NULL,
  `telefone_celular_coordenador` varchar(45) DEFAULT NULL,
  `email_principal_coordenador` varchar(45) DEFAULT NULL,
  `email_secundario_coordenador` varchar(45) DEFAULT NULL,
  `curriculo_lattes_coordenador` varchar(45) DEFAULT NULL,
  `apresentacao_proposta` varchar(45) DEFAULT NULL,
  `acoes_previstas` varchar(45) DEFAULT NULL,
  `resultados_pretendidos` varchar(45) DEFAULT NULL,
  `cronograma` varchar(45) DEFAULT NULL,
  `situacao` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `projetos_bolsistas`
-- ----------------------------
DROP TABLE IF EXISTS `projetos_bolsistas`;
CREATE TABLE `projetos_bolsistas` (
  `projetos_ID` int(11) NOT NULL,
  `bolsistas_matricula` varchar(45) NOT NULL,
  `data_entrada` datetime DEFAULT NULL,
  `data_saida` datetime DEFAULT NULL,
  PRIMARY KEY (`projetos_ID`,`bolsistas_matricula`),
  KEY `fk_projetos_has_bolsistas_bolsistas1` (`bolsistas_matricula`),
  KEY `fk_projetos_has_bolsistas_projetos` (`projetos_ID`),
  KEY `FKE6A5625975FCCFD2` (`projetos_ID`),
  KEY `FKE6A562591D878537` (`bolsistas_matricula`),
  CONSTRAINT `FKE6A562591D878537` FOREIGN KEY (`bolsistas_matricula`) REFERENCES `bolsistas` (`matricula`),
  CONSTRAINT `FKE6A5625975FCCFD2` FOREIGN KEY (`projetos_ID`) REFERENCES `projetos` (`ID`),
  CONSTRAINT `fk_projetos_has_bolsistas_bolsistas1` FOREIGN KEY (`bolsistas_matricula`) REFERENCES `bolsistas` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_projetos_has_bolsistas_projetos` FOREIGN KEY (`projetos_ID`) REFERENCES `projetos` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `projetos_escolas_parceiras`
-- ----------------------------
DROP TABLE IF EXISTS `projetos_escolas_parceiras`;
CREATE TABLE `projetos_escolas_parceiras` (
  `projetos_ID` int(11) NOT NULL,
  `escolas_parceiras_ID` int(11) NOT NULL,
  PRIMARY KEY (`projetos_ID`,`escolas_parceiras_ID`),
  KEY `fk_projetos_has_escolas_parceiras_escolas_parceiras1` (`escolas_parceiras_ID`),
  KEY `fk_projetos_has_escolas_parceiras_projetos1` (`projetos_ID`),
  KEY `FK98549AD475FCCFD2` (`projetos_ID`),
  KEY `FK98549AD41D2A9A49` (`escolas_parceiras_ID`),
  CONSTRAINT `FK98549AD41D2A9A49` FOREIGN KEY (`escolas_parceiras_ID`) REFERENCES `escolas_parceiras` (`ID`),
  CONSTRAINT `FK98549AD475FCCFD2` FOREIGN KEY (`projetos_ID`) REFERENCES `projetos` (`ID`),
  CONSTRAINT `fk_projetos_has_escolas_parceiras_escolas_parceiras1` FOREIGN KEY (`escolas_parceiras_ID`) REFERENCES `escolas_parceiras` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_projetos_has_escolas_parceiras_projetos1` FOREIGN KEY (`projetos_ID`) REFERENCES `projetos` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `projetos_professores_colaboradores`
-- ----------------------------
DROP TABLE IF EXISTS `projetos_professores_colaboradores`;
CREATE TABLE `projetos_professores_colaboradores` (
  `projetos_ID` int(11) NOT NULL,
  `professores_colaboradores_ID` int(11) NOT NULL,
  `data_inicio` datetime DEFAULT NULL,
  `data_fim` datetime DEFAULT NULL,
  PRIMARY KEY (`projetos_ID`,`professores_colaboradores_ID`),
  KEY `fk_projetos_has_professores_colaboradores_professores_colabor1` (`professores_colaboradores_ID`),
  KEY `fk_projetos_has_professores_colaboradores_projetos1` (`projetos_ID`),
  KEY `FKDD6867873C2B5317` (`professores_colaboradores_ID`),
  KEY `FKDD68678775FCCFD2` (`projetos_ID`),
  CONSTRAINT `FKDD68678775FCCFD2` FOREIGN KEY (`projetos_ID`) REFERENCES `projetos` (`ID`),
  CONSTRAINT `FKDD6867873C2B5317` FOREIGN KEY (`professores_colaboradores_ID`) REFERENCES `professores_colaboradores` (`ID`),
  CONSTRAINT `fk_projetos_has_professores_colaboradores_professores_colabor1` FOREIGN KEY (`professores_colaboradores_ID`) REFERENCES `professores_colaboradores` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_projetos_has_professores_colaboradores_projetos1` FOREIGN KEY (`projetos_ID`) REFERENCES `projetos` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `projetos_supervisores`
-- ----------------------------
DROP TABLE IF EXISTS `projetos_supervisores`;
CREATE TABLE `projetos_supervisores` (
  `projetos_ID` int(11) NOT NULL,
  `supervisores_ID` int(11) NOT NULL,
  `data_inicio` datetime DEFAULT NULL,
  `data_fim` datetime DEFAULT NULL,
  PRIMARY KEY (`projetos_ID`,`supervisores_ID`),
  KEY `fk_projetos_has_supervisores_supervisores1` (`supervisores_ID`),
  KEY `fk_projetos_has_supervisores_projetos1` (`projetos_ID`),
  KEY `FK7155364575FCCFD2` (`projetos_ID`),
  KEY `FK71553645EB44A212` (`supervisores_ID`),
  CONSTRAINT `FK71553645EB44A212` FOREIGN KEY (`supervisores_ID`) REFERENCES `supervisores` (`ID`),
  CONSTRAINT `FK7155364575FCCFD2` FOREIGN KEY (`projetos_ID`) REFERENCES `projetos` (`ID`),
  CONSTRAINT `fk_projetos_has_supervisores_projetos1` FOREIGN KEY (`projetos_ID`) REFERENCES `projetos` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_projetos_has_supervisores_supervisores1` FOREIGN KEY (`supervisores_ID`) REFERENCES `supervisores` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `supervisores`
-- ----------------------------
DROP TABLE IF EXISTS `supervisores`;
CREATE TABLE `supervisores` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `email_principal` varchar(45) DEFAULT NULL,
  `email_secundario` varchar(45) DEFAULT NULL,
  `telefone_residencial` varchar(45) DEFAULT NULL,
  `telefone_celular` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `situacao` varchar(45) DEFAULT 'ativo',
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `usuario`
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `login` varchar(255) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `papel_ID` int(11) NOT NULL,
  PRIMARY KEY (`login`),
  KEY `fk_usuario_papel1` (`papel_ID`),
  KEY `FKF814F32EE01936E2` (`papel_ID`),
  CONSTRAINT `FKF814F32EE01936E2` FOREIGN KEY (`papel_ID`) REFERENCES `papel` (`ID`),
  CONSTRAINT `fk_usuario_papel1` FOREIGN KEY (`papel_ID`) REFERENCES `papel` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `usuario`
-- ----------------------------
BEGIN;
INSERT INTO `usuario` VALUES ('klikli', '1234', '1'), ('victor', '123', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
