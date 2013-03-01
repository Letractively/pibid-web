SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `pibid` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `pibid` ;

-- -----------------------------------------------------
-- Table `pibid`.`instituicao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`instituicao` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`instituicao` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `sigla` VARCHAR(35) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`discente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`discente` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`discente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `instituicao` INT(11) NOT NULL ,
  `matricula` VARCHAR(25) NOT NULL ,
  `nome` VARCHAR(100) NOT NULL ,
  `email_principal` VARCHAR(100) NOT NULL ,
  `email_secudario` VARCHAR(100) NULL ,
  `tel_residencial` VARCHAR(15) NOT NULL ,
  `tel_celular` VARCHAR(15) NOT NULL ,
  `endereco` VARCHAR(200) NOT NULL ,
  `lattes` VARCHAR(100) NULL ,
  `situacao` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_discente_instituicao1_idx` (`instituicao` ASC) ,
  CONSTRAINT `fk_discente_instituicao1`
    FOREIGN KEY (`instituicao` )
    REFERENCES `pibid`.`instituicao` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`instituicao_ens_basico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`instituicao_ens_basico` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`instituicao_ens_basico` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `matricula` VARCHAR(25) NOT NULL ,
  `esfera` VARCHAR(50) NOT NULL ,
  `endereco` VARCHAR(200) NOT NULL ,
  `diretor` VARCHAR(100) NOT NULL ,
  `vice_diretor_manha` VARCHAR(100) NOT NULL ,
  `vice_diretor_tarde` VARCHAR(100) NOT NULL ,
  `vice_diretor_noite` VARCHAR(100) NOT NULL ,
  `telefone` VARCHAR(15) NOT NULL ,
  `email_escola` VARCHAR(100) NULL ,
  `email_direcao` VARCHAR(100) NULL ,
  `email_vice_direcao` VARCHAR(100) NULL ,
  `situacao` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`docente_ens_superior`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`docente_ens_superior` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`docente_ens_superior` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `instituicao` INT(11) NOT NULL ,
  `nome` VARCHAR(100) NOT NULL ,
  `email_principal` VARCHAR(100) NOT NULL ,
  `email_secudario` VARCHAR(100) NULL ,
  `tel_residencial` VARCHAR(15) NOT NULL ,
  `tel_celular` VARCHAR(15) NOT NULL ,
  `endereco` VARCHAR(200) NOT NULL ,
  `lattes` VARCHAR(100) NULL ,
  `situacao` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_docente_instituicao1_idx` (`instituicao` ASC) ,
  CONSTRAINT `fk_docente_instituicao1`
    FOREIGN KEY (`instituicao` )
    REFERENCES `pibid`.`instituicao` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`curso` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`curso` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `curso` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`projeto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`projeto` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`projeto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `instituicao` INT(11) NOT NULL ,
  `curso` INT(11) NOT NULL ,
  `coordenador` INT(11) NOT NULL ,
  `titulo` VARCHAR(100) NULL ,
  `data_ini` DATE NULL ,
  `data_fim` DATE NULL ,
  `apresentacao_proposta` TEXT NULL ,
  `acoes_prevista` TEXT NULL ,
  `resultados_pretendido` TEXT NULL ,
  `situacao` VARCHAR(10) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_projeto_docente1_idx` (`coordenador` ASC) ,
  INDEX `fk_projeto_instituicao1_idx` (`instituicao` ASC) ,
  INDEX `fk_projeto_curso1_idx` (`curso` ASC) ,
  CONSTRAINT `fk_projeto_docente1`
    FOREIGN KEY (`coordenador` )
    REFERENCES `pibid`.`docente_ens_superior` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_instituicao1`
    FOREIGN KEY (`instituicao` )
    REFERENCES `pibid`.`instituicao` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_curso1`
    FOREIGN KEY (`curso` )
    REFERENCES `pibid`.`curso` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`atividade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`atividade` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`atividade` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `projeto` INT(11) NOT NULL ,
  `titulo` VARCHAR(100) NOT NULL ,
  `descricao` TEXT NOT NULL ,
  `cadastro` DATE NOT NULL ,
  `data_ini` DATE NOT NULL ,
  `data_fim` DATE NULL ,
  `data_conclusao` DATE NULL ,
  `obs_gerais` TEXT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_atividade_projeto_idx` (`projeto` ASC) ,
  CONSTRAINT `fk_atividade_projeto`
    FOREIGN KEY (`projeto` )
    REFERENCES `pibid`.`projeto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`professor_colaborador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`professor_colaborador` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`professor_colaborador` (
  `projeto` INT(11) NOT NULL ,
  `docente` INT(11) NOT NULL ,
  `data_entrada` DATE NULL ,
  `data_saida` DATE NULL ,
  `descricao` TEXT NULL ,
  PRIMARY KEY (`projeto`, `docente`) ,
  INDEX `fk_projeto_has_docente_docente1_idx` (`docente` ASC) ,
  INDEX `fk_projeto_has_docente_projeto1_idx` (`projeto` ASC) ,
  CONSTRAINT `fk_projeto_has_docente_projeto1`
    FOREIGN KEY (`projeto` )
    REFERENCES `pibid`.`projeto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_has_docente_docente1`
    FOREIGN KEY (`docente` )
    REFERENCES `pibid`.`docente_ens_superior` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`aluno_colaborador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`aluno_colaborador` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`aluno_colaborador` (
  `projeto` INT(11) NOT NULL ,
  `discente` INT(11) NOT NULL ,
  `data_entrada` DATE NULL ,
  `data_saida` DATE NULL ,
  `descricao` TEXT NULL ,
  PRIMARY KEY (`projeto`, `discente`) ,
  INDEX `fk_projeto_has_discente_discente1_idx` (`discente` ASC) ,
  INDEX `fk_projeto_has_discente_projeto1_idx` (`projeto` ASC) ,
  CONSTRAINT `fk_projeto_has_discente_projeto1`
    FOREIGN KEY (`projeto` )
    REFERENCES `pibid`.`projeto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_has_discente_discente1`
    FOREIGN KEY (`discente` )
    REFERENCES `pibid`.`discente` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`bolsista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`bolsista` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`bolsista` (
  `projeto` INT(11) NOT NULL ,
  `discente` INT(11) NOT NULL ,
  `data_entrada` DATE NULL ,
  `data_saida` DATE NULL ,
  `descricao` TEXT NULL ,
  PRIMARY KEY (`projeto`, `discente`) ,
  INDEX `fk_bolsista_projeto1_idx` (`projeto` ASC) ,
  CONSTRAINT `fk_bolsista_discente1`
    FOREIGN KEY (`discente` )
    REFERENCES `pibid`.`discente` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bolsista_projeto1`
    FOREIGN KEY (`projeto` )
    REFERENCES `pibid`.`projeto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`docente_ens_basico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`docente_ens_basico` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`docente_ens_basico` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `email_principal` VARCHAR(100) NOT NULL ,
  `email_secudario` VARCHAR(100) NULL ,
  `tel_residencial` VARCHAR(15) NULL ,
  `tel_celular` VARCHAR(15) NULL ,
  `endereco` VARCHAR(200) NULL ,
  `escola` INT(11) NOT NULL ,
  `situacao` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_supervisor_escola1_idx` (`escola` ASC) ,
  CONSTRAINT `fk_supervisor_escola1`
    FOREIGN KEY (`escola` )
    REFERENCES `pibid`.`instituicao_ens_basico` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`responsavel_atividade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`responsavel_atividade` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`responsavel_atividade` (
  `atividade` INT(11) NOT NULL ,
  `discente` INT(11) NULL ,
  `bolsista` INT(11) NULL ,
  `docente` INT(11) NULL ,
  `supervisor` INT(11) NULL ,
  PRIMARY KEY (`atividade`, `discente`, `bolsista`, `docente`, `supervisor`) ,
  INDEX `fk_discente_has_atividade_atividade1_idx` (`atividade` ASC) ,
  INDEX `fk_discente_has_atividade_discente1_idx` (`discente` ASC) ,
  INDEX `fk_responsavel_atividade_discente1_idx` (`bolsista` ASC) ,
  INDEX `fk_responsavel_atividade_docente1_idx` (`docente` ASC) ,
  INDEX `fk_responsavel_atividade_supervisor1_idx` (`supervisor` ASC) ,
  CONSTRAINT `fk_discente_has_atividade_discente1`
    FOREIGN KEY (`discente` )
    REFERENCES `pibid`.`discente` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_discente_has_atividade_atividade1`
    FOREIGN KEY (`atividade` )
    REFERENCES `pibid`.`atividade` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_responsavel_atividade_discente1`
    FOREIGN KEY (`bolsista` )
    REFERENCES `pibid`.`discente` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_responsavel_atividade_docente1`
    FOREIGN KEY (`docente` )
    REFERENCES `pibid`.`docente_ens_superior` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_responsavel_atividade_supervisor1`
    FOREIGN KEY (`supervisor` )
    REFERENCES `pibid`.`docente_ens_basico` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`supervisor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`supervisor` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`supervisor` (
  `supervisor` INT(11) NOT NULL ,
  `projeto` INT(11) NOT NULL ,
  `data_ini` DATE NOT NULL ,
  `date_fim` DATE NULL ,
  `descricao` TEXT NULL ,
  PRIMARY KEY (`supervisor`, `projeto`) ,
  INDEX `fk_supervisor_has_projeto_projeto1_idx` (`projeto` ASC) ,
  INDEX `fk_supervisor_has_projeto_supervisor1_idx` (`supervisor` ASC) ,
  CONSTRAINT `fk_supervisor_has_projeto_supervisor1`
    FOREIGN KEY (`supervisor` )
    REFERENCES `pibid`.`docente_ens_basico` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_supervisor_has_projeto_projeto1`
    FOREIGN KEY (`projeto` )
    REFERENCES `pibid`.`projeto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`cronograma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`cronograma` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`cronograma` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `projeto` INT(11) NOT NULL ,
  `codigo` VARCHAR(45) NOT NULL COMMENT 'O código da atividade é referente a ordenação apenas.' ,
  `atividade` VARCHAR(45) NOT NULL ,
  `data_ini` DATE NULL ,
  `data_fim` DATE NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_cronograma_projeto1`
    FOREIGN KEY (`projeto` )
    REFERENCES `pibid`.`projeto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `pibid`.`papel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`papel` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`papel` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pibid`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pibid`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `pibid`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `senha` VARCHAR(100) NOT NULL ,
  `papel` INT(11) NOT NULL ,
  INDEX `fk_usuario_papel1_idx` (`papel` ASC) ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) ,
  CONSTRAINT `fk_usuario_papel1`
    FOREIGN KEY (`papel` )
    REFERENCES `pibid`.`papel` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
