CREATE TABLE `authentification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `motDePasse` varchar(255) DEFAULT NULL,
  `utilisateur` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `patrimoinehistorique` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `codePostal` varchar(255) DEFAULT NULL,
  `commune` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `geoTag` varchar(255) DEFAULT NULL,
  `horaires` varchar(255) DEFAULT NULL,
  `lienAudio` varchar(255) DEFAULT NULL,
  `lienImage` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `tarif` varchar(255) DEFAULT NULL,
  `tarifMax` varchar(255) DEFAULT NULL,
  `tarifMin` varchar(255) DEFAULT NULL,
  `telephone` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;