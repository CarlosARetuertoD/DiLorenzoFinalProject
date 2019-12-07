package com.example.dilorenzoapp.Clases;

public class NewDetallePedido {
    int id;
    int cabeceraPedido;
    int producto;
    int cantidad;

    public NewDetallePedido() {
    }

    public NewDetallePedido(int id, int cabeceraPedido, int producto, int cantidad) {
        this.id = id;
        this.cabeceraPedido = cabeceraPedido;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCabeceraPedido() {
        return cabeceraPedido;
    }

    public void setCabeceraPedido(int cabeceraPedido) {
        this.cabeceraPedido = cabeceraPedido;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
