package com.mycompany.crudmvcweb.controlador;

import com.mycompany.crudmvcweb.dao.CategoriaDAO;
import com.mycompany.crudmvcweb.dao.ProductoDAO;
import com.mycompany.crudmvcweb.modelo.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    private final ProductoDAO dao = new ProductoDAO();
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {
            case "nuevo":
                // Manda la lista de categorias para llenar el <select>
                request.setAttribute("listaCategorias", categoriaDAO.listar());
                request.getRequestDispatcher("producto_form.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Producto p = dao.buscarPorId(idEditar);
                request.setAttribute("producto", p);
                request.setAttribute("listaCategorias", categoriaDAO.listar());
                request.getRequestDispatcher("producto_form.jsp").forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("ProductoServlet?accion=listar");
                break;

            case "listar":
            default:
                List<Producto> lista = dao.listar();
                request.setAttribute("listaProductos", lista);
                request.getRequestDispatcher("producto_lista.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("idProducto");
        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));

        if (idParam == null || idParam.isEmpty()) {
            Producto p = new Producto(nombre, precio, stock, idCategoria);
            dao.insertar(p);
        } else {
            Producto p = new Producto();
            p.setIdProducto(Integer.parseInt(idParam));
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setStock(stock);
            p.setIdCategoria(idCategoria);
            dao.actualizar(p);
        }

        response.sendRedirect("ProductoServlet?accion=listar");
    }
}