package com.example.dilorenzoapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dilorenzoapp.Adapters.AdapterProductos;
import com.example.dilorenzoapp.Clases.Producto;
import com.example.dilorenzoapp.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProductos extends Fragment {

    public FragmentProductos() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_productos, container, false);
        final RecyclerView r = v.findViewById(R.id.rvProductos);
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("unidad","35.00","Saco de Detergente","Bolivar","1"));
        productos.add(new Producto("unidad","35.00","Saco de Detergente","Bolivar","1"));
        productos.add(new Producto("unidad","35.00","Saco de Detergente","Bolivar","1"));
        productos.add(new Producto("unidad","35.00","Saco de Detergente","Bolivar","1"));
        productos.add(new Producto("unidad","35.00","Saco de Detergente","Bolivar","1"));
        productos.add(new Producto("unidad","35.00","Saco de Detergente","Bolivar","1"));
        productos.add(new Producto("unidad","35.00","Saco de Detergente","Bolivar","1"));
        AdapterProductos adapter = new AdapterProductos(getContext(),productos);
        r.setAdapter(adapter);
        r.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
}
