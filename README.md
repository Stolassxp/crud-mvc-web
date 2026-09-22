# CRUD MVC Web - Categorías, Productos y Clientes

Este es un proyecto de práctica que implementa un sistema CRUD (Crear, Leer, Actualizar, Eliminar) usando la arquitectura MVC (Modelo-Vista-Controlador) en Java Web. Se desarrolló con Servlets y JSP para la lógica del servidor, MySQL como base de datos, y Bootstrap para darle estilo a la interfaz.

El sistema maneja tres entidades: Categorías, Productos y Clientes. Cada una cuenta con su propio módulo completo de registro, listado, edición y eliminación. Los Productos están relacionados con las Categorías mediante una llave foránea.

La separación de responsabilidades sigue el patrón MVC de la siguiente manera: los Modelos (carpeta modelo) representan los datos de cada entidad, los DAO (carpeta dao) se encargan de la conexión y las consultas a MySQL, los Controladores (carpeta controlador) son los Servlets que reciben las peticiones del usuario y deciden qué hacer, y las Vistas son los archivos JSP que muestran la información al usuario con estilo Bootstrap.

Video de demostración del funcionamiento: https://drive.google.com/file/d/1IT3ANBTRTZwCWmrY_up844f8kwWedrgj/view?usp=sharing

Tecnologías utilizadas: Java, Servlets, JSP, Apache Tomcat 10, MySQL, Maven, Bootstrap 5 y JSTL.

Para ejecutar el proyecto, primero hay que crear la base de datos con el script crudmvcweb_db.sql en MySQL Workbench, y luego configurar el usuario y contraseña en el archivo Conexion.java.
