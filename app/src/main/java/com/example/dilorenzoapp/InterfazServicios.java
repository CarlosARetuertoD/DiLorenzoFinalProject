package com.example.dilorenzoapp;

import com.example.dilorenzoapp.Clases.Cliente;
import com.example.dilorenzoapp.Clases.Pedido;
import com.example.dilorenzoapp.Clases.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfazServicios {
    @GET("clientes/")
    Call<List<Cliente>> listCliente();
    @GET("productos/")
    Call<List<Producto>> listProductos();
    @GET("pedidos/")
    Call<List<Pedido>> listPedidos();
}
