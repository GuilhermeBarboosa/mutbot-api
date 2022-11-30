-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 30-Nov-2022 às 15:48
-- Versão do servidor: 8.0.29
-- versão do PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `dbmutbot`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_questions`
--

DROP TABLE IF EXISTS `tb_questions`;
CREATE TABLE IF NOT EXISTS `tb_questions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `question` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `active` tinyint(1) NOT NULL,
  `created_date` timestamp NOT NULL,
  `author_id` bigint NOT NULL,
  `last_updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `author_id` (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `tb_questions`
--

INSERT INTO `tb_questions` (`id`, `question`, `active`, `created_date`, `author_id`, `last_updated_date`) VALUES
(6, 'asd', 1, '2022-11-30 15:39:44', 6, '2022-11-30 12:39:43.660548'),
(7, 'sadsa', 1, '2022-11-30 15:39:57', 6, '2022-11-30 12:39:56.965725');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_response_questions`
--

DROP TABLE IF EXISTS `tb_response_questions`;
CREATE TABLE IF NOT EXISTS `tb_response_questions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `response` varchar(255) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `created_date` timestamp NOT NULL,
  `author_id` bigint NOT NULL,
  `question_id` bigint NOT NULL,
  `last_updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_response_questions_fk` (`author_id`),
  KEY `tb_response_questions_question_fk` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_users`
--

DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE IF NOT EXISTS `tb_users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `created_date` timestamp NOT NULL,
  `password` varchar(255) NOT NULL,
  `last_updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `tb_users`
--

INSERT INTO `tb_users` (`id`, `name`, `email`, `username`, `active`, `created_date`, `password`, `last_updated_date`) VALUES
(5, 'adm', 'adm', 'adm', 1, '2022-11-30 15:36:22', '$2a$10$Hv00jBPx3FoTcgIQYaUWYez/NDEaYylcfLKA1pBh88QM522FE37JW$2a$10$XWbjjPXlHDzXUdKEqlSHJ.MwKbA5cilhHQN6DXizrx20pAhWqrb4a$2a$10$PgvI3g.3jhlxHEk3dyZ9TOH5D8s.Dd7QLSdtNM863Q4gLm6/euV2e', '2022-11-30 12:36:22.276104'),
(6, 'g', 'g', 'g', 1, '2022-11-30 15:37:38', '$2a$10$PgvI3g.3jhlxHEk3dyZ9TOH5D8s.Dd7QLSdtNM863Q4gLm6/euV2e', '2022-11-30 12:37:38.131069'),
(7, 'w', 'w', 'w', 1, '2022-11-30 15:41:12', '$2a$10$fKfXtSX0z7MqxVUJiScCyOW151RPp/UfBK9RwSUUtXe8vU1kwH9qO', '2022-11-30 12:41:12.351727');

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_questions`
--
ALTER TABLE `tb_questions`
  ADD CONSTRAINT `tb_questions_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `tb_users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limitadores para a tabela `tb_response_questions`
--
ALTER TABLE `tb_response_questions`
  ADD CONSTRAINT `tb_response_questions_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `tb_users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `tb_response_questions_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `tb_questions` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
