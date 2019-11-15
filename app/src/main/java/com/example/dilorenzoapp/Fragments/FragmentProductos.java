package com.example.dilorenzoapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dilorenzoapp.Adapters.AdapterClientes;
import com.example.dilorenzoapp.Adapters.AdapterProductos;
import com.example.dilorenzoapp.Clases.Cliente;
import com.example.dilorenzoapp.Clases.Producto;
import com.example.dilorenzoapp.InterfazServicios;
import com.example.dilorenzoapp.R;

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
    public FragmentProductos() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_productos, container, false);
        recyclerView = v.findViewById(R.id.rvProductos);
        ConexionRetrofit();
        return v;
    }
    void ConstruirRecycler(final List<Producto> data){
        AdapterProductos adapter = new AdapterProductos(getContext(),data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    public void ConexionRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.8.78:8000/Codigo/")
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
}
