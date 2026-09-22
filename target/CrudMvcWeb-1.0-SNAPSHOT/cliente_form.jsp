<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario Cliente</title>
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
        <div class="card shadow-sm" style="max-width: 500px; margin: auto;">
            <div class="card-body">
                <h3 class="card-title mb-3">
                    ${empty cliente ? "Nuevo Cliente" : "Editar Cliente"}
                </h3>

                <form action="ClienteServlet" method="post">

                    <input type="hidden" name="idCliente" value="${cliente.idCliente}">

                    <div class="mb-3">
                        <label class="form-label">Nombre</label>
                        <input type="text" name="nombre" class="form-control"
                               value="${cliente.nombre}" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="email" name="email" class="form-control"
                               value="${cliente.email}">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Teléfono</label>
                        <input type="text" name="telefono" class="form-control"
                               value="${cliente.telefono}">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Dirección</label>
                        <textarea name="direccion" class="form-control" rows="2">${cliente.direccion}</textarea>
                    </div>

                    <button type="submit" class="btn btn-success">Guardar</button>
                    <a href="ClienteServlet?accion=listar" class="btn btn-secondary">Cancelar</a>
                </form>
            </div>
        </div>
    </div>

</body>
</html>