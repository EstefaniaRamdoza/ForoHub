ForoHub.
Practicando Spring Framework, API REST y SOLID: Challenge Foro Hub

La API esta centrada específicamente en los tópicos, y debe permitir a los usuarios:

Crear un nuevo tópico;
Mostrar todos los tópicos creados;
Mostrar un tópico específico;
Actualizar un tópico;
Eliminar un tópico.
Los objetivo con este challenge es implementar una API REST con las siguientes funcionalidades:

API con rutas implementadas siguiendo las mejores prácticas del modelo REST.
Validaciones realizadas según las reglas de negocio.
Implementación de una base de datos relacional para la persistencia de la información.
Servicio de autenticación/autorización por medio de JWT.
Documentación con Swagger
rutas extra:

/usuario
/respuestas
Versiones
_Java: version 17
Maven: versión 4 en adelante
Spring: versión 3.2.3
MySQL: versión 8 en adelante
Postgres: versión 16 en adelante
Dependencias:

Lombok
Spring Web
Spring Boot DevTools
Spring Data JPA
Flyway Migration
MySQL Driver
Validation
Spring Security
Spring Doc
Auth0 (Java jwt)
Ejemplos

Endpoints
<img width="1357" height="557" alt="image" src="https://github.com/user-attachments/assets/f98619e2-9275-4755-b622-d781fa74c209" />


CREAR TOKEN
<img width="1322" height="797" alt="image" src="https://github.com/user-attachments/assets/a60711e1-4b6a-4989-9e21-08ebef62fecd" />

Authorize con token
<img width="617" height="248" alt="image" src="https://github.com/user-attachments/assets/f332fb52-0d21-4cb5-a85a-3152a602ce64" />

POST /topicos 3er prueba
<img width="526" height="217" alt="image" src="https://github.com/user-attachments/assets/2ba24b51-98ba-4858-8389-2add5786df51" />

Listar todo GET /topicos
<img width="558" height="415" alt="image" src="https://github.com/user-attachments/assets/c20917ba-ec77-4b7d-adec-cd0746625267" />

Actualizar PUT /topicos/{id}
<img width="522" height="212" alt="image" src="https://github.com/user-attachments/assets/51b0cc64-de7d-451c-b540-d76a2e14a930" />

Eliminar DELETE /topicos/{id}
<img width="550" height="236" alt="image" src="https://github.com/user-attachments/assets/c1843d14-7cc6-46d9-8e32-dfb37da15736" />

Confirmar la eliminación GET /topicos
<img width="423" height="287" alt="image" src="https://github.com/user-attachments/assets/13ea7d56-e540-4493-8865-5e4cf7451d65" />

Probar seguridad
candado Authorize → Logout para quitar el token.
<img width="482" height="227" alt="image" src="https://github.com/user-attachments/assets/6b6b7faf-a988-4826-9bdc-df7ec5608b93" />








