package com.mycompany.crudmvcweb.dao;

import com.mycompany.crudmvcweb.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setEmail(rs.getString("email"));
                c.setTelefono(rs.getString("telefono"));
                c.setDireccion(rs.getString("direccion"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return lista;
    }

    public Cliente buscarPorId(int id) {
        Cliente c = null;
        String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Cliente();
                    c.setIdCliente(rs.getInt("id_cliente"));
                    c.setNombre(rs.getString("nombre"));
                    c.setEmail(rs.getString("email"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setDireccion(rs.getString("direccion"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar cliente: " + e.getMessage());
        }
        return c;
    }

    public boolean insertar(Cliente c) {
        String sql = "INSERT INTO clientes (nombre, email, telefono, direccion) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getDireccion());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Cliente c) {
        String sql = "UPDATE clientes SET nombre = ?, email = ?, telefono = ?, direccion = ? WHERE id_cliente = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getDireccion());
            ps.setInt(5, c.getIdCliente());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
}