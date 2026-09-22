<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario Categoría</title>
     <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

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
        <div class="card shadow-sm" style="max-width: 500px; margin: auto;">
            <div class="card-body">
                <h3 class="card-title mb-3">
                    ${empty categoria ? "Nueva Categoría" : "Editar Categoría"}
                </h3>

                <form action="CategoriaServlet" method="post">

                    <!-- Campo oculto: si es edición, viaja el id. Si es nuevo, va vacío -->
                    <input type="hidden" name="idCategoria" value="${categoria.idCategoria}">

                    <div class="mb-3">
                        <label class="form-label">Nombre</label>
                        <input type="text" name="nombre" class="form-control"
                               value="${categoria.nombre}" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Descripción</label>
                        <textarea name="descripcion" class="form-control" rows="3">${categoria.descripcion}</textarea>
                    </div>

                    <button type="submit" class="btn btn-success">Guardar</button>
                    <a href="CategoriaServlet?accion=listar" class="btn btn-secondary">Cancelar</a>
                </form>
            </div>
        </div>
    </div>

</body>
</html>