<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Clientes</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="#">CrudMvcWeb</a>
            <div class="navbar-nav">
                <a class="nav-link" href="CategoriaServlet?accion=listar">Categorías</a>
                <a class="nav-link" href="ProductoServlet?accion=listar">Productos</a>
                <a class="nav-link active" href="ClienteServlet?accion=listar">Clientes</a>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2>Listado de Clientes</h2>
            <a href="ClienteServlet?accion=nuevo" class="btn btn-success">+ Nuevo Cliente</a>
        </div>

        <c:if test="${empty listaClientes}">
            <div class="alert alert-warning">No hay clientes registrados todavía.</div>
        </c:if>

        <c:if test="${not empty listaClientes}">
            <table class="table table-striped table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Email</th>
                        <th>Teléfono</th>
                        <th>Dirección</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cli" items="${listaClientes}">
                        <tr>
                            <td>${cli.idCliente}</td>
                            <td>${cli.nombre}</td>
                            <td>${cli.email}</td>
                            <td>${cli.telefono}</td>
                            <td>${cli.direccion}</td>
                            <td>
                                <a href="ClienteServlet?accion=editar&id=${cli.idCliente}" class="btn btn-sm btn-primary">Editar</a>
                                <a href="ClienteServlet?accion=eliminar&id=${cli.idCliente}" class="btn btn-sm btn-danger"
                                   onclick="return confirm('¿Seguro que deseas eliminar este cliente?');">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

</body>
</html>