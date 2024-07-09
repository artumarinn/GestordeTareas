DROP DATABASE IF EXISTS gestor_de_tareas;
CREATE DATABASE IF NOT EXISTS gestor_de_tareas;
USE gestor_de_tareas;

CREATE TABLE usuario (
id INT PRIMARY KEY AUTO_INCREMENT,
dni VARCHAR(50),
nombre_completo VARCHAR(50),
correo VARCHAR(50),
usuario VARCHAR(50),
contraseña VARCHAR(255)
);


