-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04-Jul-2023 às 03:10
-- Versão do servidor: 10.4.28-MariaDB
-- versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `school`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefone` char(13) DEFAULT NULL,
  `data_nasc` date DEFAULT NULL,
  `sexo` varchar(20) DEFAULT NULL,
  `distincao` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`matricula`, `nome`, `email`, `telefone`, `data_nasc`, `sexo`, `distincao`) VALUES
(1, 'Everton', 'tteverton75@gmail.com', '88981999999', '2004-08-14', 'M', NULL),
(2, 'José Maria', 'jose.maria44@gmail.com', '88988889999', '2001-12-12', 'M', 'Magna Cum Laude'),
(3, 'Maria Julieta', 'mariaJu99@gmail.com', '85999999999', '2001-09-12', 'F', 'Magna Cum Laude'),
(4, 'Antonio ', 'antonio.33@gmail.com', '85985858585', '2005-01-30', 'M', 'Magna Cum Laude'),
(5, 'Francisco', 'francisco@gmail.com', '88999999999', '2001-09-14', 'M', 'Summa Cum Laude'),
(6, 'Andre', 'andre@crateus', '92837423', '1987-06-20', 'M', 'Summa Cum Laude');

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `alunos_info`
-- (Veja abaixo para a view atual)
--
CREATE TABLE `alunos_info` (
`matricula` int(11)
,`nome` varchar(255)
,`email` varchar(255)
,`telefone` char(13)
,`data_nasc` date
,`sexo` varchar(20)
,`media` double
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_disciplina`
--

CREATE TABLE `aluno_disciplina` (
  `aluno_matr` int(11) NOT NULL,
  `disciplina_cod` int(11) NOT NULL,
  `periodo` varchar(50) NOT NULL,
  `nota` float DEFAULT NULL,
  `frequencia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `aluno_disciplina`
--

INSERT INTO `aluno_disciplina` (`aluno_matr`, `disciplina_cod`, `periodo`, `nota`, `frequencia`) VALUES
(1, 1, '2023.1', 10, 100),
(1, 2, '2022.2', 9, 99),
(1, 2, '2023.1', 3, 70),
(1, 4, '2006.1', 8, 100),
(1, 4, '2008.1', 10, 100),
(1, 4, '2023.1', 6, 100),
(2, 2, '2022.2', 8, 90),
(2, 2, '2023.1', 10, 100),
(2, 4, '2004.1', 10, 100),
(3, 1, '2022.1', 9, 100),
(3, 1, '2022.2', 10, 90),
(4, 1, '2005.1', 0, 0),
(4, 1, '2022.1', 9.8, 100),
(4, 2, '2022.2', 10, 100),
(4, 2, '2023.1', 10, 100),
(4, 4, '2020.1', 0, 0),
(4, 4, '2023.1', 9, 90),
(5, 4, '2023.1', 10, 100),
(6, 4, '2002.1', 10, 100);

--
-- Acionadores `aluno_disciplina`
--
DELIMITER $$
CREATE TRIGGER `atualizar_distincao` AFTER INSERT ON `aluno_disciplina` FOR EACH ROW BEGIN
    DECLARE media FLOAT;
    
    -- Calcula a média das notas do aluno
    SELECT AVG(nota) INTO media
    FROM aluno_disciplina
    WHERE aluno_matr = NEW.aluno_matr;
    
    -- Atualiza a coluna "distincao" com base na média das notas
    IF media = 10 THEN
        UPDATE aluno SET distincao = 'Summa Cum Laude' WHERE matricula = NEW.aluno_matr;
    ELSEIF media >= 9 AND media < 10 THEN
        UPDATE aluno SET distincao = 'Magna Cum Laude' WHERE matricula = NEW.aluno_matr;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `creditos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`codigo`, `nome`, `creditos`) VALUES
(1, 'POO', 4),
(2, 'Banco de Dados', 4),
(4, 'PI 1', 4);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `turmas_info`
-- (Veja abaixo para a view atual)
--
CREATE TABLE `turmas_info` (
`disciplina` varchar(255)
,`periodo` varchar(50)
,`quantidade_estudantes` bigint(21)
,`maior_nota` float
,`menor_nota` float
,`media_notas` double
);

-- --------------------------------------------------------

--
-- Estrutura para vista `alunos_info`
--
DROP TABLE IF EXISTS `alunos_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `alunos_info`  AS SELECT `a`.`matricula` AS `matricula`, `a`.`nome` AS `nome`, `a`.`email` AS `email`, `a`.`telefone` AS `telefone`, `a`.`data_nasc` AS `data_nasc`, `a`.`sexo` AS `sexo`, sum(`ad`.`nota`) / count(`ad`.`nota`) AS `media` FROM (`aluno` `a` join `aluno_disciplina` `ad` on(`a`.`matricula` = `ad`.`aluno_matr`)) GROUP BY `a`.`matricula`, `a`.`nome`, `a`.`email`, `a`.`telefone`, `a`.`data_nasc`, `a`.`sexo` ;

-- --------------------------------------------------------

--
-- Estrutura para vista `turmas_info`
--
DROP TABLE IF EXISTS `turmas_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `turmas_info`  AS SELECT `d`.`nome` AS `disciplina`, `ad`.`periodo` AS `periodo`, count(`ad`.`aluno_matr`) AS `quantidade_estudantes`, max(`ad`.`nota`) AS `maior_nota`, min(`ad`.`nota`) AS `menor_nota`, avg(`ad`.`nota`) AS `media_notas` FROM (`aluno_disciplina` `ad` join `disciplina` `d` on(`ad`.`disciplina_cod` = `d`.`codigo`)) GROUP BY `d`.`nome`, `ad`.`periodo` ;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`matricula`);

--
-- Índices para tabela `aluno_disciplina`
--
ALTER TABLE `aluno_disciplina`
  ADD PRIMARY KEY (`aluno_matr`,`disciplina_cod`,`periodo`),
  ADD KEY `disciplina_cod` (`disciplina_cod`);

--
-- Índices para tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `disciplina`
--
ALTER TABLE `disciplina`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aluno_disciplina`
--
ALTER TABLE `aluno_disciplina`
  ADD CONSTRAINT `aluno_disciplina_ibfk_1` FOREIGN KEY (`aluno_matr`) REFERENCES `aluno` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aluno_disciplina_ibfk_2` FOREIGN KEY (`disciplina_cod`) REFERENCES `disciplina` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
