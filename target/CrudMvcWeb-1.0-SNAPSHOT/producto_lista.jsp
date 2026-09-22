<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Productos</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="#">CrudMvcWeb</a>
            <div class="navbar-nav">
                <a class="nav-link" href="CategoriaServlet?accion=listar">Categorías</a>
                <a class="nav-link active" href="ProductoServlet?accion=listar">Productos</a>
                <a class="nav-link" href="ClienteServlet?accion=listar">Clientes</a>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2>Listado de Productos</h2>
            <a href="ProductoServlet?accion=nuevo" class="btn btn-success">+ Nuevo Producto</a>
        </div>

        <c:if test="${empty listaProductos}">
            <div class="alert alert-warning">No hay productos registrados todavía.</div>
        </c:if>

        <c:if test="${not empty listaProductos}">
            <table class="table table-striped table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Stock</th>
                           <th>Categoría</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="prod" items="${listaProductos}">
                        <tr>
                            <td>${prod.idProducto}</td>
                            <td>${prod.nombre}</td>
                            <td>Q ${prod.precio}</td>
                            <td>${prod.stock}</td>
                            <td><span class="badge bg-info text-dark">${prod.nombreCategoria}</span></td>
                            <td>
                                <a href="ProductoServlet?accion=editar&id=${prod.idProducto}" class="btn btn-sm btn-primary">Editar</a>
                                <a href="ProductoServlet?accion=eliminar&id=${prod.idProducto}" class="btn btn-sm btn-danger"
                                   onclick="return confirm('¿Seguro que deseas eliminar este producto?');">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

</body>
</html>