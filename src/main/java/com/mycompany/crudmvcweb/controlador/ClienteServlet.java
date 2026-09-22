package com.mycompany.crudmvcweb.controlador;

import com.mycompany.crudmvcweb.dao.ClienteDAO;
import com.mycompany.crudmvcweb.modelo.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    private final ClienteDAO dao = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {
            case "nuevo":
                request.getRequestDispatcher("cliente_form.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Cliente c = dao.buscarPorId(idEditar);
                request.setAttribute("cliente", c);
                request.getRequestDispatcher("cliente_form.jsp").forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("ClienteServlet?accion=listar");
                break;

            case "listar":
            default:
                List<Cliente> lista = dao.listar();
                request.setAttribute("listaClientes", lista);
                request.getRequestDispatcher("cliente_lista.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("idCliente");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        if (idParam == null || idParam.isEmpty()) {
            Cliente c = new Cliente(nombre, email, telefono, direccion);
            dao.insertar(c);
        } else {
            Cliente c = new Cliente();
            c.setIdCliente(Integer.parseInt(idParam));
            c.setNombre(nombre);
            c.setEmail(email);
            c.setTelefono(telefono);
            c.setDireccion(direccion);
            dao.actualizar(c);
        }

        response.sendRedirect("ClienteServlet?accion=listar");
    }
}