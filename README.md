ForoHub es una plataforma interactiva que fomenta el intercambio de ideas y debates entre usuarios. Permite a los participantes iniciar conversaciones sobre diversos temas, interactuar mediante publicaciones y comentarios, y participar activamente en discusiones dinámicas.

Características ⚙️

Registro y autenticación de usuarios.
Creación, edición y eliminación de tópicos.
Respuesta a tópicos existentes.
Listado de usuarios y tópicos.
Autenticación mediante JWT.

Tecnologías utilizadas ⚒️

Java
Spring Boot
Spring Security
JWT (JSON Web Tokens)
JPA (Java Persistence API)
H2 Database (para desarrollo y pruebas)
Postman (para pruebas de API)
Swagger (para documentación de API)

Estructura del proyecto 🖥️

Entities: Clases de entidad que representan las tablas de la base de datos.
Dto: Clases de Data Transfer Object utilizadas para transferir datos entre el cliente y el servidor.
Repository: Interfaces que extienden JpaRepository para realizar operaciones CRUD en las entidades.
Service: Clases de servicio que contienen la lógica de negocio.
Controller: Clases de controlador que manejan las solicitudes HTTP.
Security: Clases relacionadas con la configuración de seguridad y la autenticación.
