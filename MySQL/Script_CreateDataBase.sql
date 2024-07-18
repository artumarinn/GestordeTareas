DROP DATABASE IF EXISTS task_manager;
CREATE DATABASE IF NOT EXISTS task_manager;
USE task_manager;

CREATE TABLE usuario (
id INT PRIMARY KEY AUTO_INCREMENT,
dni VARCHAR(50),
nombre_completo VARCHAR(50),
correo VARCHAR(50),
usuario VARCHAR(50),
contraseña VARCHAR(255)
);


