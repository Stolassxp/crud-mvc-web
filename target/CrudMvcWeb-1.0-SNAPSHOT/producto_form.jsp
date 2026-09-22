<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario Producto</title>
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
        <div class="card shadow-sm" style="max-width: 500px; margin: auto;">
            <div class="card-body">
                <h3 class="card-title mb-3">
                    ${empty producto ? "Nuevo Producto" : "Editar Producto"}
                </h3>

                <form action="ProductoServlet" method="post">

                    <input type="hidden" name="idProducto" value="${producto.idProducto}">

                    <div class="mb-3">
                        <label class="form-label">Nombre</label>
                        <input type="text" name="nombre" class="form-control"
                               value="${producto.nombre}" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Precio</label>
                        <input type="number" step="0.01" name="precio" class="form-control"
                               value="${producto.precio}" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Stock</label>
                        <input type="number" name="stock" class="form-control"
                               value="${producto.stock}" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Categoría</label>
                        <select name="idCategoria" class="form-select" required>
                            <option value="">-- Selecciona una categoría --</option>
                            <c:forEach var="cat" items="${listaCategorias}">
                                <option value="${cat.idCategoria}"
                                    ${cat.idCategoria == producto.idCategoria ? "selected" : ""}>
                                    ${cat.nombre}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-success">Guardar</button>
                    <a href="ProductoServlet?accion=listar" class="btn btn-secondary">Cancelar</a>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
