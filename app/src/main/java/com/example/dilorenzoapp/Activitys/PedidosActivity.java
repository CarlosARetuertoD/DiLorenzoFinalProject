package com.example.dilorenzoapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.dilorenzoapp.Adapters.PedidosAdapter;
import com.example.dilorenzoapp.Clases.Pedido;
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

public class PedidosActivity extends AppCompatActivity {
    RecyclerView rv_pedidos;
    PedidosAdapter adapter;
    FloatingActionButton fab;
    String user_dni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
        ObtenerDni();
        Inicializadores();
        ConexionRetrofit();
    }
    void Inicializadores(){
        rv_pedidos = findViewById(R.id.rv_pedidos);
        fab = findViewById(R.id.fabGenerarPedido);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PedidosActivity.this, GenerarOperacion.class);
                startActivity(intent);
            }
        });
    }
    void ObtenerDni(){
        SharedPreferences preferences = this.getSharedPreferences("user_data", MODE_PRIVATE);
        user_dni = preferences.getString("user_dni","0000000");
    }
    void ConstruirRecycler(List<Pedido> listado_pedido){
        adapter = new PedidosAdapter(this, listado_pedido);
        rv_pedidos.setAdapter(adapter);
        rv_pedidos.setLayoutManager(new LinearLayoutManager(this));
    }
    public void ConexionRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.URL_Conection) + "Codigo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfazServicios interfazServicios = retrofit.create(InterfazServicios.class);
        Call<List<Pedido>> listPedidos = interfazServicios.listPedidos(user_dni);
        listPedidos.enqueue(new Callback<List<Pedido>>() {
            @Override
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {
                ConstruirRecycler(response.body());
            }

            @Override
            public void onFailure(Call<List<Pedido>> call, Throwable t) {

            }
        });

    }
}
