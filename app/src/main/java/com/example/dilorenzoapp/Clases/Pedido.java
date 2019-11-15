package com.example.dilorenzoapp.Clases;

import java.util.Date;

public class Pedido {
    int id;
    Cliente cliente;
    Trabajador trabajador;
    Date fecha_pedido;
    Date fecha_entrega;
    Boolean entregado;
    Boolean pagado;
    FormaPago formaPago;
    Double descuento;
    Double monto;

    public Pedido() {
    }

    public Pedido(int id, Cliente cliente, Trabajador trabajador, Date fecha_pedido, Date fecha_entrega, Boolean entregado, Boolean pagado, FormaPago formaPago, Double descuento, Double monto) {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
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

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public class FormaPago{
        String descripcion;

        public FormaPago() {
        }

        public FormaPago(String descripcion) {
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
