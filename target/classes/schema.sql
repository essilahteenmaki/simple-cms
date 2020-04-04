DROP TABLE premise;
DROP TABLE type;
DROP TABLE user;
DROP TABLE file;

CREATE TABLE premise (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
address VARCHAR(50) NOT NULL,
city VARCHAR(50) NOT NULL,
description VARCHAR(200),
img VARCHAR(500),
myynnissa BIGINT,
typeid BIGINT
);

CREATE TABLE type (
typeid BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL
);

CREATE TABLE user (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
tunnus VARCHAR(50) NOT NULL,
salasana VARCHAR(200) NOT NULL,
rooli VARCHAR(50) NOT NULL
);

CREATE TABLE file (
fileid BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(200),
type VARCHAR(50),
file LONGBLOB NOT NULL
);

INSERT INTO type (name) VALUES ('Liiketila'), ('Toimistotila'), ('Varasto');

INSERT INTO user (tunnus, salasana, rooli) VALUES ('admin', '$2a$10$xcZy2lQBZmWkZTqdV6CvHeL5nvwbLMNrGcOmAKuyrmsoqRJtd61qG', 'ADMIN'), 
('user', '$2a$10$Hqk/G4yd/14tTNvcTxDOReKzKcSiU4FNLsXSBbjac5.MxgEEh7lgK', 'USER');

INSERT INTO premise (address, city, description, img, myynnissa, typeid) VALUES ('Ulvilantie', 'Ulvila', 'Kaunis toimisto hyvalla paikalla', 'https://icon-library.net/images/placeholder-image-icon/placeholder-image-icon-7.jpg', 1, 1),
('Kaupintie', 'Helsinki', 'Kaunis liiketila hyvalla paikalla', 'https://icon-library.net/images/placeholder-image-icon/placeholder-image-icon-7.jpg', 1, 2);