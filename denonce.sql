-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 13, 2020 at 03:02 PM
-- Server version: 8.0.21-0ubuntu0.20.04.4
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `denonce`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrateur`
--

CREATE TABLE `administrateur` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `administrateur`
--

INSERT INTO `administrateur` (`id`, `email`, `nom`, `password`, `tel`, `role_id`) VALUES
(1, 'admin1@gmail.com', 'admin1', '$2a$10$1AlC2vxCj9oegzH5oSGPVec0nqHi7ynzBmzVpkHcFyviOGxBfSIem', '697456833', 1);

-- --------------------------------------------------------

--
-- Table structure for table `administrateur_roles`
--

CREATE TABLE `administrateur_roles` (
  `administrateurs_id` bigint NOT NULL,
  `roles_id` bigint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `administrateur_roles`
--

INSERT INTO `administrateur_roles` (`administrateurs_id`, `roles_id`) VALUES
(1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `couverture`
--

CREATE TABLE `couverture` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `chef_lieu` varchar(255) DEFAULT NULL,
  `nom_en` varchar(255) DEFAULT NULL,
  `nom_fr` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `ville_id` bigint DEFAULT NULL,
  `region_id` bigint DEFAULT NULL,
  `quartier_id` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `couverture`
--

INSERT INTO `couverture` (`dtype`, `id`, `nom`, `chef_lieu`, `nom_en`, `nom_fr`, `email`, `tel`, `ville_id`, `region_id`, `quartier_id`) VALUES
('region', 0, '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `denonciation`
--

CREATE TABLE `denonciation` (
  `id` bigint NOT NULL,
  `age` int NOT NULL,
  `date` date DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `personne_concerne` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `statut` bit(1) DEFAULT NULL,
  `etablissement_id` bigint DEFAULT NULL,
  `niveau_scolaire_id` bigint DEFAULT NULL,
  `type_denonciation_id` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `niveau_scolaire`
--

CREATE TABLE `niveau_scolaire` (
  `id` bigint NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `niveau_scolaire`
--

INSERT INTO `niveau_scolaire` (`id`, `nom`) VALUES
(1, '6éme'),
(2, '5éme'),
(3, '4éme'),
(4, '3éme'),
(5, '2nd'),
(6, '1ére'),
(7, 'Tle');

-- --------------------------------------------------------

--
-- Table structure for table `region`
--

CREATE TABLE `region` (
  `id` bigint NOT NULL,
  `chef_lieu` varchar(255) DEFAULT NULL,
  `nom_en` varchar(255) DEFAULT NULL,
  `nom_fr` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `region`
--

INSERT INTO `region` (`id`, `chef_lieu`, `nom_en`, `nom_fr`) VALUES
(1, 'Bafoussam', 'West', 'Ouest'),
(2, 'Bertoua', 'East', 'Est'),
(3, 'Ngaoundéré', 'Adamawa', 'Adamaoua'),
(4, 'Yaounde', 'Central', 'Centre'),
(5, 'Maroua', 'Far North', 'Extrême-Nord'),
(6, 'Douala', 'Littoral', 'Littoral'),
(7, 'Garoua', 'North', 'Nord'),
(8, 'Bamenda', 'Northwest', 'Nord-Ouest'),
(9, 'Ebolowa', 'South', 'Sud'),
(10, 'Buea', 'Southwest', 'Sud-Ouest');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint NOT NULL,
  `couverture_id` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `couverture_id`) VALUES
(1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `type_denonciation`
--

CREATE TABLE `type_denonciation` (
  `id` bigint NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `type_denonciation`
--

INSERT INTO `type_denonciation` (`id`, `nom`) VALUES
(1, 'Drogue'),
(2, 'Arme Blanche'),
(3, 'Harcelement'),
(4, 'Argent'),
(6, 'Autres');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKra7blnuofulbcrc78vvv8rj57` (`role_id`);

--
-- Indexes for table `administrateur_roles`
--
ALTER TABLE `administrateur_roles`
  ADD KEY `FKjmfsxkd34qlix860f3chmet2w` (`roles_id`),
  ADD KEY `FKgbjd9s86mmlkksggpuxsrnh19` (`administrateurs_id`);

--
-- Indexes for table `couverture`
--
ALTER TABLE `couverture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7fmircj3p552brvi1lofi8847` (`ville_id`),
  ADD KEY `FK5i7qd0yor8e1ia4sgxsih3s54` (`region_id`),
  ADD KEY `FK4ptx704ji70efxqc338o0bggd` (`quartier_id`);

--
-- Indexes for table `denonciation`
--
ALTER TABLE `denonciation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKibwof1ivkllnu3454yy0xqqs1` (`etablissement_id`),
  ADD KEY `FKgstrkojs5tknk2d0nusr90sis` (`niveau_scolaire_id`),
  ADD KEY `FKqqx1mb4nmj7fafkdfry12msrv` (`type_denonciation_id`);

--
-- Indexes for table `niveau_scolaire`
--
ALTER TABLE `niveau_scolaire`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq4xl6vh60cworl23cocrfnior` (`couverture_id`);

--
-- Indexes for table `type_denonciation`
--
ALTER TABLE `type_denonciation`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrateur`
--
ALTER TABLE `administrateur`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `couverture`
--
ALTER TABLE `couverture`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `denonciation`
--
ALTER TABLE `denonciation`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `niveau_scolaire`
--
ALTER TABLE `niveau_scolaire`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `region`
--
ALTER TABLE `region`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `type_denonciation`
--
ALTER TABLE `type_denonciation`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
