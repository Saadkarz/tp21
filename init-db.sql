-- Script d'initialisation des bases de données
-- Création des bases pour les microservices

CREATE DATABASE IF NOT EXISTS clientservicedb;
CREATE DATABASE IF NOT EXISTS carservicedb;

-- Attribution des permissions
GRANT ALL PRIVILEGES ON clientservicedb.* TO 'root'@'%';
GRANT ALL PRIVILEGES ON carservicedb.* TO 'root'@'%';
FLUSH PRIVILEGES;
