package com.mycompany.crudmvcweb.dao;

import com.mycompany.crudmvcweb.modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    // LISTAR todas las categorias
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("id_categoria"));
                c.setNombre(rs.getString("nombre"));
                c.setDescripcion(rs.getString("descripcion"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    // BUSCAR una categoria por su id (para editar)
    public Categoria buscarPorId(int id) {
        Categoria c = null;
        String sql = "SELECT * FROM categorias WHERE id_categoria = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Categoria();
                    c.setIdCategoria(rs.getInt("id_categoria"));
                    c.setNombre(rs.getString("nombre"));
                    c.setDescripcion(rs.getString("descripcion"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return c;
    }

    // INSERTAR una nueva categoria
    public boolean insertar(Categoria c) {
        String sql = "INSERT INTO categorias (nombre, descripcion) VALUES (?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    // ACTUALIZAR una categoria existente
    public boolean actualizar(Categoria c) {
        String sql = "UPDATE categorias SET nombre = ?, descripcion = ? WHERE id_categoria = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getIdCategoria());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR una categoria
    public boolean eliminar(int id) {
        String sql = "DELETE FROM categorias WHERE id_categoria = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}