package com.example.dilorenzoapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dilorenzoapp.Adapters.AdapterClientes;
import com.example.dilorenzoapp.Adapters.AdapterProductos;
import com.example.dilorenzoapp.Clases.Cliente;
import com.example.dilorenzoapp.Clases.Producto;
import com.example.dilorenzoapp.InterfazServicios;
import com.example.dilorenzoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProductos extends Fragment {
    RecyclerView recyclerView;
    List<ProductoPedido> detallePedido;
    static FragmentProductos fragmentProductos;
    public FragmentProductos() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_productos, container, false);
        recyclerView = v.findViewById(R.id.rvProductos);
        detallePedido = new ArrayList<>();
        fragmentProductos = this;
        ConexionRetrofit();
        return v;
    }
    void ConstruirRecycler(final List<Producto> data){
        AdapterProductos adapter = new AdapterProductos(getContext(),data,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    public void ConexionRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.URL_Conection) + "Codigo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfazServicios interfazServicios = retrofit.create(InterfazServicios.class);
        Call<List<Producto>> listProducto = interfazServicios.listProductos();
        listProducto.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                ConstruirRecycler(response.body());
            }
            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });
    }
    public static class ProductoPedido{
        String producto;
        int cantidad;

        public ProductoPedido() {
        }

        public ProductoPedido(String producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }

        public String getProducto() {
            return producto;
        }

        public void setProducto(String producto) {
            this.producto = producto;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }

    static FragmentProductos getFragmentProductos(){
        return fragmentProductos;
    }
    public List<ProductoPedido> getDetallePedido(){
        if(detallePedido == null ){
            return new ArrayList<>();
        }else{
            return detallePedido;
        }

    }
    public void ActualizarDetallePedido(String descripcion, int operacion){
        int pos = ConsultarProducto(descripcion);
        if(pos != -1){
            if(operacion == 0){
                detallePedido.get(pos).setCantidad(detallePedido.get(pos).getCantidad()+1);
            }if(operacion == 1){
                detallePedido.get(pos).setCantidad(detallePedido.get(pos).getCantidad()-1);
            }if(operacion == 2){
                detallePedido.remove(pos);
            }
        }else{
            if(operacion == 0){
                detallePedido.add(new FragmentProductos.ProductoPedido(descripcion,1));
            }
        }
        FragmentGenerarPedido.getFragmentGenerarPedido().ActualizarAdapter();
    }
    int ConsultarProducto(String descripcion){
        for(int i = 0 ; i<detallePedido.size(); i++) {
            if (detallePedido.get(i).getProducto().equals(descripcion)){
                return i;
            }
        }
        return -1;
    }
}
