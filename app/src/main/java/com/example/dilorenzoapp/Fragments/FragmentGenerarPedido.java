package com.example.dilorenzoapp.Fragments;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dilorenzoapp.Adapters.AdapterDetallePedido;
import com.example.dilorenzoapp.Adapters.AdapterProductos;
import com.example.dilorenzoapp.Clases.Producto;
import com.example.dilorenzoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGenerarPedido extends Fragment {
    TextView txt_dni;
    RecyclerView rvProductos;
    List<FragmentProductos.ProductoPedido> data;
    AdapterDetallePedido adapter;
    public static FragmentGenerarPedido fragmentGenerarPedido;
    public FragmentGenerarPedido() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_generar_pedido, container, false);
        txt_dni = view.findViewById(R.id.txt_dni);
        fragmentGenerarPedido = this;
        rvProductos = view.findViewById(R.id.rvProductos);
        data = new ArrayList<>();
        data.add(new FragmentProductos.ProductoPedido("PRUEBAS", 4));
        data = FragmentProductos.getFragmentProductos().getDetallePedido();
        txt_dni.setText(PlaceholderFragment.getPlaceholderFragment().getCliente());
        ConstruirRecycler(data);
        return view;
    }
    void ConstruirRecycler(List<FragmentProductos.ProductoPedido> data){
        adapter = new AdapterDetallePedido(getContext(),data);
        rvProductos.setAdapter(adapter);
        rvProductos.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    static FragmentGenerarPedido getFragmentGenerarPedido(){
        return fragmentGenerarPedido;
    }
    public void ActualizarAdapter(){
        adapter.notifyDataSetChanged();
    }

}
