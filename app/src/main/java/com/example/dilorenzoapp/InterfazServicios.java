package com.example.dilorenzoapp;

import com.example.dilorenzoapp.Clases.Cliente;
import com.example.dilorenzoapp.Clases.NewPedido;
import com.example.dilorenzoapp.Clases.Pedido;
import com.example.dilorenzoapp.Clases.Producto;
import com.example.dilorenzoapp.Clases.Trabajador;
import com.example.dilorenzoapp.Clases.ZonaTrabajador;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
    @GET("zonatrabajador/{dni}/")
    Call<List<ZonaTrabajador>> ConsultarZonas(@Path("dni") String dni);

    @FormUrlEncoded
    @POST("addpedido/")
    Call<NewPedido> CrearPedido(@Field("cliente") String cliente,
                                @Field("trabajador") String trabajador,
                                @Field("fecha_pedido") String fecha_pedido,
                                @Field("fecha_entrega") String fecha_entrega,
                                @Field("entregado") Boolean entregado,
                                @Field("pagado") Boolean pagado,
                                @Field("formaPago") int formaPago,
                                @Field("descuento") Double descuento,
                                @Field("monto") Double monto);
}
