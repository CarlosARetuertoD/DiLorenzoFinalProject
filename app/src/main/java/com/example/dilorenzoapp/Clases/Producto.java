package com.example.dilorenzoapp.Clases;

public class Producto {
    int id;
    Marca marca;
    Categoria categoria;
    String nombre;
    String tipo;
    String presentacion;
    double precio;
    String descripcion;

    public Producto() {
    }

    public Producto(int id, Marca marca, Categoria categoria, String nombre, String tipo, String presentacion, double precio, String descripcion) {
        this.id = id;
        this.marca = marca;
        this.categoria = categoria;
        this.nombre = nombre;
        this.tipo = tipo;
        this.presentacion = presentacion;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public class Marca{
        String descripcion;

        public Marca() {
        }

        public Marca(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }
    public class Categoria{
        String descripcion;

        public Categoria() {
        }

        public Categoria(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }
}
