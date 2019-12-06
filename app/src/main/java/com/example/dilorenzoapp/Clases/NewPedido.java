package com.example.dilorenzoapp.Clases;

import java.util.Date;

public class NewPedido {
    int id;
    String cliente;
    String trabajador;
    Date fecha_pedido;
    Date fecha_entrega;
    String entregado;
    String pagado;
    String formaPago;
    String descuento;
    String monto;

    public NewPedido() {
    }

    public NewPedido(int id, String cliente, String trabajador, Date fecha_pedido, Date fecha_entrega, String entregado, String pagado, String formaPago, String descuento, String monto) {
        this.id = id;
        this.cliente = cliente;
        this.trabajador = trabajador;
        this.fecha_pedido = fecha_pedido;
        this.fecha_entrega = fecha_entrega;
        this.entregado = entregado;
        this.pagado = pagado;
        this.formaPago = formaPago;
        this.descuento = descuento;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
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

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }
}
