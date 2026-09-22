package com.mycompany.crudmvcweb.controlador;

import com.mycompany.crudmvcweb.dao.CategoriaDAO;
import com.mycompany.crudmvcweb.modelo.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoriaServlet", urlPatterns = {"/CategoriaServlet"})
public class CategoriaServlet extends HttpServlet {

    private final CategoriaDAO dao = new CategoriaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {
            case "nuevo":
                // Muestra el formulario vacío
                request.getRequestDispatcher("categoria_form.jsp").forward(request, response);
                break;

            case "editar":
                // Busca la categoria y la manda al formulario para editar
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Categoria c = dao.buscarPorId(idEditar);
                request.setAttribute("categoria", c);
                request.getRequestDispatcher("categoria_form.jsp").forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("CategoriaServlet?accion=listar");
                break;

            case "listar":
            default:
                List<Categoria> lista = dao.listar();
                request.setAttribute("listaCategorias", lista);
                request.getRequestDispatcher("categoria_lista.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("idCategoria");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        if (idParam == null || idParam.isEmpty()) {
            // No hay id -> es un registro NUEVO
            Categoria c = new Categoria(nombre, descripcion);
            dao.insertar(c);
        } else {
            // Hay id -> es una ACTUALIZACION
            Categoria c = new Categoria();
            c.setIdCategoria(Integer.parseInt(idParam));
            c.setNombre(nombre);
            c.setDescripcion(descripcion);
            dao.actualizar(c);
        }

        response.sendRedirect("CategoriaServlet?accion=listar");
    }
}
