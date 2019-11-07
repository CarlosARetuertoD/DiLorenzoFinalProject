package com.example.dilorenzoapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dilorenzoapp.Adapters.PedidosAdapter;
import com.example.dilorenzoapp.Clases.Pedido;
import com.example.dilorenzoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class PedidosActivity extends AppCompatActivity {
    RecyclerView rv_pedidos;
    List<Pedido> listado_pedido;
    PedidosAdapter adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
        rv_pedidos = findViewById(R.id.rv_pedidos);
        listado_pedido = new ArrayList<>();
        for (int i = 0; i<10; i++)
            listado_pedido.add(new Pedido(i));
        ConstruirRecycler();

       fab = findViewById(R.id.fabGenerarPedido);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PedidosActivity.this, GenerarOperacion.class);
                startActivity(intent);
            }
        });
    }
    void ConstruirRecycler(){
        adapter = new PedidosAdapter(this, listado_pedido);
        rv_pedidos.setAdapter(adapter);
        rv_pedidos.setLayoutManager(new LinearLayoutManager(this));
    }
}
