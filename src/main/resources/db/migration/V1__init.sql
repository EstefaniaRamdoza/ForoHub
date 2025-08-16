-- =========================================
-- Migración inicial ForoHub (V1)
-- =========================================

CREATE TABLE usuarios (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  rol VARCHAR(50) NOT NULL
);

CREATE TABLE topicos (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(200) NOT NULL,
  mensaje TEXT NOT NULL,
  fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  estado VARCHAR(20) NOT NULL,
  autor_id BIGINT NOT NULL,
  CONSTRAINT fk_topico_autor FOREIGN KEY (autor_id) REFERENCES usuarios (id)
);

-- Insert de prueba opcional para verificar datos
INSERT INTO usuarios (nombre, email, password, rol)
VALUES ('Admin', 'admin@forohub.com', '123456', 'ADMIN');

INSERT INTO topicos (titulo, mensaje, estado, autor_id)
VALUES ('Bienvenida a ForoHub', 'Este es el primer tema del foro', 'ABIERTO', 1);