-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 13 juil. 2019 à 12:52
-- Version du serveur :  5.7.11-log
-- Version de PHP :  7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `denonce`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

DROP TABLE IF EXISTS `administrateur`;
CREATE TABLE IF NOT EXISTS `administrateur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKra7blnuofulbcrc78vvv8rj57` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`id`, `email`, `nom`, `password`, `tel`, `role_id`) VALUES
(3, 'admin3@gmail.com', 'admin3', '$2a$10$zEgw0PvnWqpHEZCVenZ1neUkcwTyOhP/8PkfUMtrSS06ZSkpBfGRC', '65356798', 8),
(4, 'admin4@gmail.com', 'admin4', '$2a$10$8fN7O8qP1fXrKeShzleGH.OBlndktX5hq714HEzXXWsYjTHaahc2q', '65356798', 7),
(6, 'admin6@gmail.com', 'admin6', '$2a$10$nOZFZdFKxp766IBhzSYi5e/i0BctXyCHHygAG9dOg/hL/GsbmdaAu', '65356798', 10),
(5, 'admin5@gmail.com', 'admin5', '$2a$10$YHyVQdGbXczFzYNRTO0cCuk9KbXUwKZAasfU.sI5tPhPbmfVK0Adq', '65356798', 9),
(8, 'admin7@gmail.com', 'admin7', '$2a$10$i3rEVcLtWsmGsrGm/VYQfuPYSV7Aw5Z8SUW4qKNtYVeFOikDOIjlC', '65356798', 11),
(22, 'user@gmail.com', 'user1', '$2a$10$hC863hk9IegH0/VW07d3DuzJUmuDHKNvoZBNylyKNtWzTTZH1K6bO', '222222222222222222', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `administrateur_roles`
--

DROP TABLE IF EXISTS `administrateur_roles`;
CREATE TABLE IF NOT EXISTS `administrateur_roles` (
  `administrateurs_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  KEY `FKjmfsxkd34qlix860f3chmet2w` (`roles_id`),
  KEY `FKgbjd9s86mmlkksggpuxsrnh19` (`administrateurs_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `administrateur_roles`
--

INSERT INTO `administrateur_roles` (`administrateurs_id`, `roles_id`) VALUES
(3, 3),
(7, 2),
(5, 4),
(6, 5),
(8, 6);

-- --------------------------------------------------------

--
-- Structure de la table `couverture`
--

DROP TABLE IF EXISTS `couverture`;
CREATE TABLE IF NOT EXISTS `couverture` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `chef_lieu` varchar(255) DEFAULT NULL,
  `nom_en` varchar(255) DEFAULT NULL,
  `nom_fr` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `ville_id` bigint(20) DEFAULT NULL,
  `region_id` bigint(20) DEFAULT NULL,
  `quartier_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7fmircj3p552brvi1lofi8847` (`ville_id`),
  KEY `FK5i7qd0yor8e1ia4sgxsih3s54` (`region_id`),
  KEY `FK4ptx704ji70efxqc338o0bggd` (`quartier_id`)
) ENGINE=MyISAM AUTO_INCREMENT=143 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `couverture`
--

INSERT INTO `couverture` (`dtype`, `id`, `nom`, `chef_lieu`, `nom_en`, `nom_fr`, `email`, `tel`, `ville_id`, `region_id`, `quartier_id`) VALUES
('region', 1, NULL, 'Bafoussam', 'West', 'Ouest', NULL, NULL, NULL, NULL, NULL),
('region', 2, NULL, 'Bertoua', 'East', 'Est', NULL, NULL, NULL, NULL, NULL),
('region', 3, NULL, 'Ngaoundéré', 'Adamawa', 'Adamaoua', NULL, NULL, NULL, NULL, NULL),
('region', 4, NULL, 'Yaounde', 'Central', 'Centre', NULL, NULL, NULL, NULL, NULL),
('region', 5, NULL, 'Maroua', 'Far North', 'Extrême-Nord', NULL, NULL, NULL, NULL, NULL),
('region', 6, NULL, 'Douala', 'Littoral', 'Littoral', NULL, NULL, NULL, NULL, NULL),
('region', 7, NULL, 'Garoua', 'North', 'Nord', NULL, NULL, NULL, NULL, NULL),
('region', 8, NULL, 'Bamenda', 'NorthWest', 'Nord-Ouest', NULL, NULL, NULL, NULL, NULL),
('region', 9, NULL, 'Ebolowa', 'South', 'Sud', NULL, NULL, NULL, NULL, NULL),
('region', 10, NULL, 'Buea', 'SouthWest', 'Sud-Ouest', NULL, NULL, NULL, NULL, NULL),
('ville', 11, 'Bafoussam', NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL),
('ville', 12, 'Yaounde', NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL),
('ville', 14, 'Ebolowa', NULL, NULL, NULL, NULL, NULL, NULL, 9, NULL),
('quartier', 17, 'Etoudi', NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
('quartier', 18, 'Biyem-Assi', NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
('quartier', 19, 'Kodengui', NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
('etablissement', 24, 'Lycee d\'etoudi', NULL, NULL, NULL, 'etoudilycee@gmail.om', '3428328732', NULL, NULL, 17),
('region', 0, '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('etablissement', 22, 'Lycee biyem', NULL, NULL, NULL, 'lyceebiyem@gmail.com', '9883871199', NULL, NULL, 18),
('etablissement', 23, 'Lyceee biyem 2', NULL, NULL, NULL, 'admin9@gmail.com', '7867223344', NULL, NULL, 18),
('ville', 54, 'Bertoua', NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL),
('quartier', 68, 'uiu', NULL, NULL, NULL, NULL, NULL, 54, NULL, NULL),
('quartier', 69, 'uiujf', NULL, NULL, NULL, NULL, NULL, 54, NULL, NULL),
('quartier', 74, 'bafqu', NULL, NULL, NULL, NULL, NULL, 11, NULL, NULL),
('quartier', 75, 'toirtr', NULL, NULL, NULL, NULL, NULL, 54, NULL, NULL),
('ville', 76, 'Bandjoun', NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL),
('etablissement', 79, 'Lyceee badkk', NULL, NULL, NULL, 'admin9@gmail.com', '7867223344', NULL, NULL, 74),
('quartier', 122, 'admin3', NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
('etablissement', 123, 'admin1', NULL, NULL, NULL, 'admin9@gmail.com', '78673333333333333', NULL, NULL, 19),
('etablissement', 124, 'admin3', NULL, NULL, NULL, 'admin9@gmail.com', '7867333333', NULL, NULL, 17),
('quartier', 133, 'Dschangd', NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
('ville', 140, 'iiiiiiiiiiiiiiiityrty', NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `denonciation`
--

DROP TABLE IF EXISTS `denonciation`;
CREATE TABLE IF NOT EXISTS `denonciation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `personne_concerne` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `statut` bit(1) DEFAULT NULL,
  `etablissement_id` bigint(20) DEFAULT NULL,
  `niveau_scolaire_id` bigint(20) DEFAULT NULL,
  `type_denonciation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKibwof1ivkllnu3454yy0xqqs1` (`etablissement_id`),
  KEY `FKgstrkojs5tknk2d0nusr90sis` (`niveau_scolaire_id`),
  KEY `FKqqx1mb4nmj7fafkdfry12msrv` (`type_denonciation_id`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `denonciation`
--

INSERT INTO `denonciation` (`id`, `age`, `date`, `message`, `personne_concerne`, `sexe`, `statut`, `etablissement_id`, `niveau_scolaire_id`, `type_denonciation_id`) VALUES
(1, 9, '2019-05-07', 'Mon message', 'Prof', 'masculin', b'0', 24, 3, 2),
(2, 16, '2019-05-07', 'Mon message 1', 'camarade', 'feminin', b'1', 24, 4, 4),
(3, 0, '2019-05-15', 'ddddd', 'cama', '', b'0', NULL, NULL, NULL),
(4, 0, '2019-05-15', 'dddddioioio', 'camauiui', '', b'0', NULL, NULL, NULL),
(5, 0, '2019-05-15', 'dddddioioio', 'camauiui', '', b'0', NULL, NULL, 3),
(6, 0, '2019-05-15', 'dddddioioio', 'camauiui', '', b'0', NULL, NULL, 3),
(7, 0, '2019-05-15', '', '', '', b'0', NULL, NULL, NULL),
(8, 0, '2019-05-15', '', '', '', b'0', NULL, NULL, 6),
(9, 0, '2019-05-15', '', '', '', b'0', NULL, NULL, NULL),
(10, 0, '2019-05-15', '', '', '', b'0', NULL, NULL, NULL),
(11, 0, '2019-05-15', '', '', '', b'0', NULL, NULL, NULL),
(12, 0, '2019-05-15', '', '', '', b'0', NULL, NULL, NULL),
(13, 0, '2019-05-15', '', '', '', b'0', NULL, NULL, 2),
(14, 17, '2019-05-15', 'yurtrtrtyruyy', 'jjjjj', 'masculin', b'0', NULL, 3, 4),
(15, 17, '2019-05-15', 'yurtrtrtyruyy', 'jjjjj', 'masculin', b'0', NULL, 3, 4),
(16, 11, '2019-05-15', 'yruyuyfu', 'jkuutuig', 'masculin', b'1', 23, 5, 4),
(17, 20, '2019-05-17', 'yfgyufvi', 'yyugyu', 'masculin', b'0', 23, 3, 2),
(18, 8, '2019-05-17', 'uituituitouiuityuu-ty', NULL, 'masculin', b'0', 23, 3, 2),
(19, 11, '2019-05-17', 'hryurè-yrfyuy', 'Camarade', 'masculin', b'0', 23, 5, 3),
(20, 0, '2019-05-17', '', '', '', b'0', NULL, NULL, NULL),
(21, 13, '2019-05-18', 'momo ', 'Professeur', 'masculin', b'1', 23, 3, 2),
(22, 11, '2019-05-24', 'truytitui', 'uzezyuir', 'masculin', b'0', 79, 3, 1),
(23, 21, '2019-05-25', 'yutyutytuytyu', 'Professeur', 'masculin', b'0', 79, 3, 2),
(24, 16, '2019-05-25', 'message', 'autre', 'masculin', b'0', 79, 5, 2),
(25, 17, '2019-06-03', 'Un membre de l\'administration m\'harcele', 'Administration', 'masculin', b'0', 24, 3, 3),
(26, 16, '2019-06-03', 'mon sms', 'Administration', 'masculin', b'0', 123, 3, 2),
(27, 19, '2019-06-03', 'Mon message', 'Vendeur', 'masculin', b'0', 24, 2, 4),
(28, 14, '2019-06-03', 'yjtyurtyrtytyr', 'Professeur', 'masculin', b'0', 79, 3, 6),
(29, 10, '2019-06-03', 'ktyutyuyuttu', 'Professeur', 'masculin', b'0', 79, 3, 3),
(30, 16, '2019-06-03', 'gdghgfgfg', 'Camarade', 'masculin', b'0', 79, 4, 3),
(31, 14, '2019-06-03', 'yyyty', 'Administration', 'feminin', b'0', 79, 2, 3),
(32, 13, '2019-06-05', 'uuu', 'Administration', 'masculin', b'0', 23, 2, 3),
(33, 15, '2019-06-15', 'uituytyut', 'Camarade', 'masculin', b'0', 79, 3, 3),
(34, 17, '2019-06-19', 'Mon message', 'Administration', 'masculin', b'0', 24, 5, 4),
(35, 15, '2019-06-19', 'mmmmmmmmmmmmmmmmm', 'Camarade', 'masculin', b'0', 24, 5, 3),
(36, 17, '2019-07-01', 'harcelement', 'Camarade', 'masculin', b'1', 24, 4, 3),
(37, 11, '2019-07-09', 'JYTYUTYUTYUTUH', 'Camarade', 'masculin', b'0', 79, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `niveau_scolaire`
--

DROP TABLE IF EXISTS `niveau_scolaire`;
CREATE TABLE IF NOT EXISTS `niveau_scolaire` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `niveau_scolaire`
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
-- Structure de la table `region`
--

DROP TABLE IF EXISTS `region`;
CREATE TABLE IF NOT EXISTS `region` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `chef_lieu` varchar(255) DEFAULT NULL,
  `nom_en` varchar(255) DEFAULT NULL,
  `nom_fr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `region`
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
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `couverture_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq4xl6vh60cworl23cocrfnior` (`couverture_id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `couverture_id`) VALUES
(3, 12),
(4, 22),
(5, 24),
(6, 0),
(7, 12),
(8, 4),
(9, 18),
(10, 22),
(11, 0),
(12, 11),
(14, 7),
(15, 5),
(16, 23),
(17, 2),
(18, 6),
(19, 9);

-- --------------------------------------------------------

--
-- Structure de la table `type_denonciation`
--

DROP TABLE IF EXISTS `type_denonciation`;
CREATE TABLE IF NOT EXISTS `type_denonciation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `type_denonciation`
--

INSERT INTO `type_denonciation` (`id`, `nom`) VALUES
(1, 'Drogue'),
(2, 'Arme Blanche'),
(3, 'Harcelement'),
(4, 'Argent'),
(6, 'Autres');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
