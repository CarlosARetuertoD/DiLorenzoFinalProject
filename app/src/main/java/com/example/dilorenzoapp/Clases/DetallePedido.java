package com.example.dilorenzoapp.Clases;

public class DetallePedido {
    Producto producto;
    int cantidad;
    Double total;

    public DetallePedido() {
    }

    public DetallePedido(Producto producto, int cantidad, Double total) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
