package com.example.dilorenzoapp.Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    int id;
    int idCliente;
    int idTrabajador;
    Date fecha_pedido;
    Date fecha_entrega;
    Boolean entregado;
    Boolean pagado;
    int idFormaPago;
    double descuento;
    double monto;
    List<Producto> list_productos;

    public Pedido() {
    }

    public Pedido(int id) {
        this.id = id;
        this.idCliente = id;
        this.idTrabajador = id;
        this.fecha_pedido = null;
        this.fecha_entrega = null;
        this.entregado = true;
        this.pagado = false;
        this.idFormaPago = id;
        this.descuento = id;
        this.monto = id;
        this.list_productos = new ArrayList<>();
    }

    public Pedido(int id, int idCliente, int idTrabajador, Date fecha_pedido, Date fecha_entrega, Boolean entregado, Boolean pagado, int idFormaPago, double descuento, double monto, List<Producto> list_productos) {
        this.id = id;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
        this.fecha_pedido = fecha_pedido;
        this.fecha_entrega = fecha_entrega;
        this.entregado = entregado;
        this.pagado = pagado;
        this.idFormaPago = idFormaPago;
        this.descuento = descuento;
        this.monto = monto;
        this.list_productos = list_productos;
    }

    public List<Producto> getList_productos() {
        return list_productos;
    }

    public void setList_productos(List<Producto> list_productos) {
        this.list_productos = list_productos;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Boolean getEntregado() {
        return entregado;
    }

    public void setEntregado(Boolean entregado) {
        this.entregado = entregado;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public int getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
