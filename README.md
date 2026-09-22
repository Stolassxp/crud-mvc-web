# CRUD MVC Web - Categorías, Productos y Clientes

Proyecto desarrollado para la práctica de CRUD MVC Web, integrando la arquitectura Modelo-Vista-Controlador (MVC) con Java Web (Servlets + JSP) y diseño visual con Bootstrap.

## 🎥 Video de demostración
[Ver video de funcionamiento](https://drive.google.com/file/d/1IT3ANBTRTZwCWmrY_up844f8kwWedrgj/view?usp=sharing)

## 🛠️ Tecnologías utilizadas
- Java (Servlets + JSP)
- Apache Tomcat 10
- MySQL
- Bootstrap 5
- Maven
- JSTL (JSP Standard Tag Library)

## 📦 Módulos / Entidades
1. **Categorías** — CRUD completo
2. **Productos** — CRUD completo (relacionado con Categorías)
3. **Clientes** — CRUD completo

## 🏗️ Arquitectura
El proyecto sigue estrictamente el patrón MVC:

- **Modelo** (`modelo/`): clases Java que representan las entidades (Categoria, Producto, Cliente)
- **DAO** (`dao/`): clases que gestionan la conexión y las operaciones SQL con MySQL
- **Controlador** (`controlador/`): Servlets que reciben las peticiones y coordinan el flujo de datos
- **Vista** (`Web Pages/`): archivos JSP estilizados con Bootstrap para la interfaz de usuario

## ⚙️ Configuración
Antes de ejecutar el proyecto, crear la base de datos ejecutando el script `crudmvcweb_db.sql` en MySQL Workbench, y configurar el usuario/contraseña en `Conexion.java`.
