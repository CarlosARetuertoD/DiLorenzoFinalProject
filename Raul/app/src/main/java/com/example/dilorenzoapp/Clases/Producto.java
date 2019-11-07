package com.example.dilorenzoapp.Clases;

public class Producto {
    private String tipo;
    private String presentacion;
    private String precio;
    private String descripcion;
    private String marca;
    private String descuento;

    public Producto() {
    }

    public Producto(String tipo, String presentacion, String precio, String descripcion, String marca, String descuento) {
        this.tipo = tipo;
        this.presentacion = presentacion;
        this.precio = precio;
        this.descripcion = descripcion;
        this.marca = marca;
        this.descuento = descuento;
    }

    public Producto(String presentacion, String precio, String descripcion, String marca, String descuento) {
        this.presentacion = presentacion;
        this.precio = precio;
        this.descripcion = descripcion;
        this.marca = marca;
        this.descuento = descuento;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
}

