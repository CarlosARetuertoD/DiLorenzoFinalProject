package com.example.dilorenzoapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dilorenzoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGenerarPedido extends Fragment {


    public FragmentGenerarPedido() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*FloatingActionButton fabUploadPedido = findViewById(R.id.fabUploadPedido);
        FloatingActionButton fabBorrar = findViewById(R.id.fabBorrar);
        FloatingActionButton fabCalendario = findViewById(R.id.fabCalendario);


        fabUploadPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pedido Generado! ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        fabBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Eliminado! ", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });



        fabCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Abrir Calendario! ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        return inflater.inflate(R.layout.fragment_fragment_generar_pedido, container, false);
    }

}
