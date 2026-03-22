# Actividad 3.3.3 — CRUD con Spring Boot y H2 (Entidad Producto)

Este proyecto es una API RESTful construida con Spring Boot que implementa las operaciones CRUD (Crear, Leer, Actualizar y Eliminar) para una entidad `Producto`. Utiliza Spring Data JPA y una base de datos en memoria H2.

## Requisitos Previos
Para poder ejecutar este proyecto, necesitas tener instalado lo siguiente en tu sistema:
* **Java:** JDK 17 o superior.
* **Maven:** Versión 3.6+ (El proyecto incluye el wrapper `mvnw` que gestiona esto automáticamente).

## 🚀 Pasos de Ejecución

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/AngelitoMix1/tu-repositorio.git
   cd tu-repositorio
   ```

2. **Ejecutar la aplicación:**
   Abre tu terminal en la raíz del proyecto y ejecuta el siguiente comando para levantar el servidor:
   ```bash
   ./mvnw spring-boot:run
   ```
   *El servidor se iniciará en el puerto 8080.*

3. **Acceder a la base de datos H2:**
   Mientras la aplicación esté corriendo, abre un navegador y dirígete a: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   * **JDBC URL:** `jdbc:h2:mem:productosdb`
   * **User Name:** `sa`
   * **Password:** *(dejar en blanco)*

> **⚠️ Nota Importante:** Al utilizar una base de datos en memoria (`h2:mem`), todos los registros creados se perderán al detener la aplicación. Esto es el comportamiento esperado para este entorno de pruebas.

##  Pruebas de la API (cURL)

Abre una nueva terminal (sin cerrar la que corre Spring Boot) y ejecuta los siguientes comandos para probar los endpoints:

**1. Crear un producto (POST):**
```bash
curl -X POST http://localhost:8080/api/productos \
-H "Content-Type:application/json" \
-d '{"nombre":"Libreta","precio":4.5}'
```

**2. Listar todos los productos (GET):**
```bash
curl http://localhost:8080/api/productos
```

**3. Actualizar un producto (PUT):**
```bash
curl -X PUT http://localhost:8080/api/productos/1 \
-H "Content-Type:application/json" \
-d '{"nombre":"Libreta A5","precio":5.0}'
```

**4. Eliminar un producto (DELETE):**
```bash
curl -X DELETE http://localhost:8080/api/productos/1
```

## 📁 Estructura del Proyecto
El proyecto sigue una arquitectura de capas estándar de Spring Boot: `Model` (Entidad), `Repository` (Acceso a datos) y `Controller` (Manejo de peticiones HTTP).
