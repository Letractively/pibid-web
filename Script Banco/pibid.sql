-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 27/02/2013 às 13h48min
-- Versão do Servidor: 5.5.29
-- Versão do PHP: 5.3.10-1ubuntu3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `pibid`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_colaborador`
--

DROP TABLE IF EXISTS `aluno_colaborador`;
CREATE TABLE IF NOT EXISTS `aluno_colaborador` (
  `projeto` int(11) NOT NULL,
  `discente` int(11) NOT NULL,
  `data_entrada` date DEFAULT NULL,
  `data_saida` date DEFAULT NULL,
  `descricao` text,
  PRIMARY KEY (`projeto`,`discente`),
  KEY `fk_projeto_has_discente_discente1_idx` (`discente`),
  KEY `fk_projeto_has_discente_projeto1_idx` (`projeto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `atividade`
--

DROP TABLE IF EXISTS `atividade`;
CREATE TABLE IF NOT EXISTS `atividade` (
  `id` int(11) NOT NULL,
  `projeto` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `descricao` text NOT NULL,
  `cadastro` date NOT NULL,
  `data_ini` date NOT NULL,
  `data_fim` date NOT NULL,
  `data_conclusao` date NOT NULL,
  `obs_gerais` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_atividade_projeto_idx` (`projeto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `bolsista`
--

DROP TABLE IF EXISTS `bolsista`;
CREATE TABLE IF NOT EXISTS `bolsista` (
  `projeto` int(11) NOT NULL,
  `discente` int(11) NOT NULL,
  `data_entrada` date DEFAULT NULL,
  `data_saida` date DEFAULT NULL,
  `descricao` text,
  PRIMARY KEY (`projeto`,`discente`),
  KEY `fk_bolsista_projeto1_idx` (`projeto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cronograma`
--

DROP TABLE IF EXISTS `cronograma`;
CREATE TABLE IF NOT EXISTS `cronograma` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projeto` int(11) NOT NULL,
  `codigo` varchar(45) NOT NULL COMMENT 'O código da atividade é referente a ordenação apenas.',
  `atividade` varchar(45) NOT NULL,
  `data_ini` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE IF NOT EXISTS `curso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `curso` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`id`, `curso`) VALUES
(1, 'Bacharelado em Informática Agrária'),
(2, 'Bacharelado em Sistemas de Informação');

-- --------------------------------------------------------

--
-- Estrutura da tabela `discente`
--

DROP TABLE IF EXISTS `discente`;
CREATE TABLE IF NOT EXISTS `discente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `instituicao` int(11) NOT NULL,
  `matricula` varchar(25) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email_principal` varchar(100) NOT NULL,
  `email_secudario` varchar(100) DEFAULT NULL,
  `tel_residencial` varchar(15) NOT NULL,
  `tel_celular` varchar(15) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `lattes` varchar(100) DEFAULT NULL,
  `situacao` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_discente_instituicao1_idx` (`instituicao`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `discente`
--

INSERT INTO `discente` (`id`, `instituicao`, `matricula`, `nome`, `email_principal`, `email_secudario`, `tel_residencial`, `tel_celular`, `endereco`, `lattes`, `situacao`) VALUES
(1, 1, '20096046', 'Stélio dos Santos Corrêa', 'stelio.correa@ufra.edu.br', '', '(33) 3333-3333', '(99) 9999-9999', 'Ananindeua-PA', 'http://lattes.cnpq.br/3361138114046962', 'Ativo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `docente_ens_basico`
--

DROP TABLE IF EXISTS `docente_ens_basico`;
CREATE TABLE IF NOT EXISTS `docente_ens_basico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email_principal` varchar(100) NOT NULL,
  `email_secudario` varchar(100) DEFAULT NULL,
  `tel_residencial` varchar(15) DEFAULT NULL,
  `tel_celular` varchar(15) DEFAULT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  `escola` int(11) NOT NULL,
  `situacao` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supervisor_escola1_idx` (`escola`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `docente_ens_basico`
--

INSERT INTO `docente_ens_basico` (`id`, `nome`, `email_principal`, `email_secudario`, `tel_residencial`, `tel_celular`, `endereco`, `escola`, `situacao`) VALUES
(1, 'Fulano de Tal da Silva', 'fulano.silva@npi.edu.br', '', '(99) 9999-9999', '(99) 9999-9999', 'Belém-PA', 1, 'Ativo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `docente_ens_superior`
--

DROP TABLE IF EXISTS `docente_ens_superior`;
CREATE TABLE IF NOT EXISTS `docente_ens_superior` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `instituicao` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email_principal` varchar(100) NOT NULL,
  `email_secudario` varchar(100) DEFAULT NULL,
  `tel_residencial` varchar(15) NOT NULL,
  `tel_celular` varchar(15) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `lattes` varchar(100) DEFAULT NULL,
  `situacao` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_docente_instituicao1_idx` (`instituicao`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `docente_ens_superior`
--

INSERT INTO `docente_ens_superior` (`id`, `instituicao`, `nome`, `email_principal`, `email_secudario`, `tel_residencial`, `tel_celular`, `endereco`, `lattes`, `situacao`) VALUES
(1, 1, 'Klissiomara Dias', 'klissiomara.dias@ufra.edu.br', '', '(99) 9999-9999', '(99) 9999-9999', 'Belém-PA', 'http://lattes.cnpq.br/2717200348115740', 'Ativo'),
(2, 1, 'Fábio de Lima Bezerra', 'fabio.bezerra@ufra.edu.br', '', '(99) 9999-9999', '(99) 9999-9999', 'Belém-PA', 'http://lattes.cnpq.br/6943688979099010', 'Ativo'),
(3, 1, 'Emerson Cordeiro Morais', 'emerson.moraes@ufra.edu.br', '', '(99) 9999-9999', '(99) 9999-9999', 'Belém-PA', 'http://lattes.cnpq.br/8291688787214146', 'Ativo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `instituicao`
--

DROP TABLE IF EXISTS `instituicao`;
CREATE TABLE IF NOT EXISTS `instituicao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `sigla` varchar(35) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `instituicao`
--

INSERT INTO `instituicao` (`id`, `nome`, `sigla`) VALUES
(1, 'Universidade Federal Rural da Amazônia', 'UFRA'),
(2, 'Universidade Federal do Pará', 'UFPA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `instituicao_ens_basico`
--

DROP TABLE IF EXISTS `instituicao_ens_basico`;
CREATE TABLE IF NOT EXISTS `instituicao_ens_basico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `matricula` varchar(25) NOT NULL,
  `esfera` varchar(50) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `diretor` varchar(100) NOT NULL,
  `vice_diretor_manha` varchar(100) NOT NULL,
  `vice_diretor_tarde` varchar(100) NOT NULL,
  `vice_diretor_noite` varchar(100) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `email_escola` varchar(100) DEFAULT NULL,
  `email_direcao` varchar(100) DEFAULT NULL,
  `email_vice_direcao` varchar(100) DEFAULT NULL,
  `situacao` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `instituicao_ens_basico`
--

INSERT INTO `instituicao_ens_basico` (`id`, `nome`, `matricula`, `esfera`, `endereco`, `diretor`, `vice_diretor_manha`, `vice_diretor_tarde`, `vice_diretor_noite`, `telefone`, `email_escola`, `email_direcao`, `email_vice_direcao`, `situacao`) VALUES
(1, 'Núcleo Pedagógico Integrado', '12345', 'Federal', 'Av. Perimetral, 1000 - Belém - PA, 66077-830, Brasil', 'Lilian Simone Amorin Brito', 'Paulo Sérgio Coelho Moreira ', 'Paulo Sérgio Coelho Moreira ', 'Paulo Sérgio Coelho Moreira ', '(91) 3274-3520', '', '', '', 'Ativo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `papel`
--

DROP TABLE IF EXISTS `papel`;
CREATE TABLE IF NOT EXISTS `papel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor_colaborador`
--

DROP TABLE IF EXISTS `professor_colaborador`;
CREATE TABLE IF NOT EXISTS `professor_colaborador` (
  `projeto` int(11) NOT NULL,
  `docente` int(11) NOT NULL,
  `data_entrada` date DEFAULT NULL,
  `data_saida` date DEFAULT NULL,
  `descricao` text,
  PRIMARY KEY (`projeto`,`docente`),
  KEY `fk_projeto_has_docente_docente1_idx` (`docente`),
  KEY `fk_projeto_has_docente_projeto1_idx` (`projeto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `projeto`
--

DROP TABLE IF EXISTS `projeto`;
CREATE TABLE IF NOT EXISTS `projeto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `instituicao` int(11) NOT NULL,
  `curso` int(11) NOT NULL,
  `coordenador` int(11) NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `data_ini` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `apresentacao_proposta` text,
  `acoes_prevista` text,
  `resultados_pretendido` text,
  `situacao` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_projeto_docente1_idx` (`coordenador`),
  KEY `fk_projeto_instituicao1_idx` (`instituicao`),
  KEY `fk_projeto_curso1_idx` (`curso`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `projeto`
--

INSERT INTO `projeto` (`id`, `instituicao`, `curso`, `coordenador`, `titulo`, `data_ini`, `data_fim`, `apresentacao_proposta`, `acoes_prevista`, `resultados_pretendido`, `situacao`) VALUES
(1, 1, 1, 1, 'Pibid-web', '2013-02-26', '2014-02-26', 'Projeto avaliativo academico.', 'Projeto', 'Produto', 'Ativo'),
(2, 1, 1, 2, 'Projeto Húmus', '2013-12-31', '2014-12-31', 'Teste', 'Teste', 'Teste', 'Ativo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `responsavel_atividade`
--

DROP TABLE IF EXISTS `responsavel_atividade`;
CREATE TABLE IF NOT EXISTS `responsavel_atividade` (
  `atividade` int(11) NOT NULL,
  `discente` int(11) NOT NULL DEFAULT '0',
  `bolsista` int(11) NOT NULL DEFAULT '0',
  `docente` int(11) NOT NULL DEFAULT '0',
  `supervisor` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`atividade`,`discente`,`bolsista`,`docente`,`supervisor`),
  KEY `fk_discente_has_atividade_atividade1_idx` (`atividade`),
  KEY `fk_discente_has_atividade_discente1_idx` (`discente`),
  KEY `fk_responsavel_atividade_discente1_idx` (`bolsista`),
  KEY `fk_responsavel_atividade_docente1_idx` (`docente`),
  KEY `fk_responsavel_atividade_supervisor1_idx` (`supervisor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `supervisor`
--

DROP TABLE IF EXISTS `supervisor`;
CREATE TABLE IF NOT EXISTS `supervisor` (
  `supervisor` int(11) NOT NULL,
  `projeto` int(11) NOT NULL,
  `data_ini` date NOT NULL,
  `date_fim` date DEFAULT NULL,
  `descricao` text,
  PRIMARY KEY (`supervisor`,`projeto`),
  KEY `fk_supervisor_has_projeto_projeto1_idx` (`projeto`),
  KEY `fk_supervisor_has_projeto_supervisor1_idx` (`supervisor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `papel` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_usuario_papel1_idx` (`papel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `aluno_colaborador`
--
ALTER TABLE `aluno_colaborador`
  ADD CONSTRAINT `fk_projeto_has_discente_projeto1` FOREIGN KEY (`projeto`) REFERENCES `projeto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_projeto_has_discente_discente1` FOREIGN KEY (`discente`) REFERENCES `discente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `atividade`
--
ALTER TABLE `atividade`
  ADD CONSTRAINT `fk_atividade_projeto` FOREIGN KEY (`projeto`) REFERENCES `projeto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `bolsista`
--
ALTER TABLE `bolsista`
  ADD CONSTRAINT `fk_bolsista_discente1` FOREIGN KEY (`discente`) REFERENCES `discente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_bolsista_projeto1` FOREIGN KEY (`projeto`) REFERENCES `projeto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `cronograma`
--
ALTER TABLE `cronograma`
  ADD CONSTRAINT `fk_cronograma_projeto1` FOREIGN KEY (`projeto`) REFERENCES `projeto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `discente`
--
ALTER TABLE `discente`
  ADD CONSTRAINT `fk_discente_instituicao1` FOREIGN KEY (`instituicao`) REFERENCES `instituicao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `docente_ens_basico`
--
ALTER TABLE `docente_ens_basico`
  ADD CONSTRAINT `fk_supervisor_escola1` FOREIGN KEY (`escola`) REFERENCES `instituicao_ens_basico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `docente_ens_superior`
--
ALTER TABLE `docente_ens_superior`
  ADD CONSTRAINT `fk_docente_instituicao1` FOREIGN KEY (`instituicao`) REFERENCES `instituicao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `professor_colaborador`
--
ALTER TABLE `professor_colaborador`
  ADD CONSTRAINT `fk_projeto_has_docente_projeto1` FOREIGN KEY (`projeto`) REFERENCES `projeto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_projeto_has_docente_docente1` FOREIGN KEY (`docente`) REFERENCES `docente_ens_superior` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `projeto`
--
ALTER TABLE `projeto`
  ADD CONSTRAINT `fk_projeto_curso1` FOREIGN KEY (`curso`) REFERENCES `curso` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_projeto_docente1` FOREIGN KEY (`coordenador`) REFERENCES `docente_ens_superior` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_projeto_instituicao1` FOREIGN KEY (`instituicao`) REFERENCES `instituicao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `responsavel_atividade`
--
ALTER TABLE `responsavel_atividade`
  ADD CONSTRAINT `fk_discente_has_atividade_atividade1` FOREIGN KEY (`atividade`) REFERENCES `atividade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `supervisor`
--
ALTER TABLE `supervisor`
  ADD CONSTRAINT `fk_supervisor_has_projeto_supervisor1` FOREIGN KEY (`supervisor`) REFERENCES `docente_ens_basico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_supervisor_has_projeto_projeto1` FOREIGN KEY (`projeto`) REFERENCES `projeto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_papel1` FOREIGN KEY (`papel`) REFERENCES `papel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
