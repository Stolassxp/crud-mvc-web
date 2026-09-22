package com.mycompany.crudmvcweb.dao;

import com.mycompany.crudmvcweb.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // LISTAR con JOIN para traer tambien el nombre de la categoria
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT p.*, c.nombre AS nombre_categoria "
                + "FROM productos p "
                + "JOIN categorias c ON p.id_categoria = c.id_categoria";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                p.setNombreCategoria(rs.getString("nombre_categoria"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }
        return lista;
    }

    public Producto buscarPorId(int id) {
        Producto p = null;
        String sql = "SELECT * FROM productos WHERE id_producto = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new Producto();
                    p.setIdProducto(rs.getInt("id_producto"));
                    p.setNombre(rs.getString("nombre"));
                    p.setPrecio(rs.getDouble("precio"));
                    p.setStock(rs.getInt("stock"));
                    p.setIdCategoria(rs.getInt("id_categoria"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }
        return p;
    }

    public boolean insertar(Producto p) {
        String sql = "INSERT INTO productos (nombre, precio, stock, id_categoria) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getIdCategoria());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Producto p) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ?, id_categoria = ? WHERE id_producto = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getIdCategoria());
            ps.setInt(5, p.getIdProducto());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id_producto = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }
}
