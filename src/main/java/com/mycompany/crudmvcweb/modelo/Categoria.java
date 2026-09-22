package com.mycompany.crudmvcweb.modelo;

public class Categoria {
    
    private int idCategoria;
    private String nombre;
    private String descripcion;

    // Constructor vacío (necesario)
    public Categoria() {
    }

    // Constructor con todos los campos (útil para crear objetos rápido)
    public Categoria(int idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Constructor sin id (útil al insertar, porque el id lo genera MySQL)
    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // ---- Getters y Setters ----
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}