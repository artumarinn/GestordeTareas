DROP DATABASE IF EXISTS task_manager;
CREATE DATABASE IF NOT EXISTS task_manager;
USE task_manager;

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(50) UNIQUE NOT NULL,
    nombre_completo VARCHAR(50) NOT NULL,
    correo VARCHAR(50) UNIQUE NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL
);

CREATE TABLE task (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    descripcion TEXT,
    estado ENUM('Sin empezar', 'En proceso', 'Terminado'),
    responsable VARCHAR(255),
    fecha_limite DATE,
    prioridad ENUM('Baja', 'Media', 'Alta'),
    PRIMARY KEY (id)
);
