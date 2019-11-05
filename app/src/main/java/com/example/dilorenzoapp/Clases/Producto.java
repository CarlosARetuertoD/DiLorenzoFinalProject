package com.example.dilorenzoapp.Clases;

public class Producto {
    private String nombre;
    private String tipo;
    private String presentacion;
    private String precio;
    private String descripcion;
    private String marca;
    private String descuento;

    public Producto() {
    }

    public Producto(String nombre, String tipo, String presentacion, String precio, String descripcion, String marca, String descuento) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.presentacion = presentacion;
        this.precio = precio;
        this.descripcion = descripcion;
        this.marca = marca;
        this.descuento = descuento;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
