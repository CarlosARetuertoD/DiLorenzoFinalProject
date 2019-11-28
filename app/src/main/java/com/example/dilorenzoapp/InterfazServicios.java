package com.example.dilorenzoapp;

import com.example.dilorenzoapp.Clases.Cliente;
import com.example.dilorenzoapp.Clases.Pedido;
import com.example.dilorenzoapp.Clases.Producto;
import com.example.dilorenzoapp.Clases.Trabajador;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InterfazServicios {
    @GET("clientes/")
    Call<List<Cliente>> listCliente();
    @GET("productos/")
    Call<List<Producto>> listProductos();
    @GET("pedidos/{dni}/")
    Call<List<Pedido>> listPedidos(@Path("dni") String dni);
    @GET("trabajador/{dni}/")
    Call<Trabajador> ConsultarTrabajador(@Path("dni") String dni);

}
