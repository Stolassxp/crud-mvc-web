<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Categorías</title>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <!-- Barra de navegación -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="#">CrudMvcWeb</a>
            <div class="navbar-nav">
                <a class="nav-link active" href="CategoriaServlet?accion=listar">Categorías</a>
                <a class="nav-link" href="ProductoServlet?accion=listar">Productos</a>
                <a class="nav-link" href="ClienteServlet?accion=listar">Clientes</a>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2>Listado de Categorías</h2>
            <a href="CategoriaServlet?accion=nuevo" class="btn btn-success">+ Nueva Categoría</a>
        </div>

        <c:if test="${empty listaCategorias}">
            <div class="alert alert-warning">No hay categorías registradas todavía.</div>
        </c:if>

        <c:if test="${not empty listaCategorias}">
            <table class="table table-striped table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cat" items="${listaCategorias}">
                        <tr>
                            <td>${cat.idCategoria}</td>
                            <td>${cat.nombre}</td>
                            <td>${cat.descripcion}</td>
                            <td>
                                <a href="CategoriaServlet?accion=editar&id=${cat.idCategoria}" class="btn btn-sm btn-primary">Editar</a>
                                <a href="CategoriaServlet?accion=eliminar&id=${cat.idCategoria}" class="btn btn-sm btn-danger"
                                   onclick="return confirm('¿Seguro que deseas eliminar esta categoría?');">Eliminar</a>
                            </td>
                        </tr>
                        
                    </c:forEach>
                  </tbody>
                   </table>
        </c:if> 
    </div> 
</body> 
</html>