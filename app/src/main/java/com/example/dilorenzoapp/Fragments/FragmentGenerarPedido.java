package com.example.dilorenzoapp.Fragments;


import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dilorenzoapp.Adapters.AdapterDetallePedido;
import com.example.dilorenzoapp.Adapters.AdapterProductos;
import com.example.dilorenzoapp.Clases.Producto;
import com.example.dilorenzoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGenerarPedido extends Fragment {
    TextView txt_dni;
    RecyclerView rvProductos;
    AdapterDetallePedido adapter;

    FloatingActionButton fabCalendario;

    List<FragmentProductos.ProductoPedido> data;
    String dni_cliente;
    String dni_trabajador;
    Boolean entregado, pagado;
    Date fecha_pedido, fecha_entrega;
    int formaPago;
    Double descuento,monto;

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
        fabCalendario = view.findViewById(R.id.fabCalendario);
        fabCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MostrarDialogFecha(view);
            }
        });
        data = new ArrayList<>();
        data = FragmentProductos.getFragmentProductos().getDetallePedido();
        dni_cliente = PlaceholderFragment.getPlaceholderFragment().getCliente();
        dni_trabajador = ObtenerDni();
        ConstruirRecycler(data);

        return view;
    }
    void ConstruirRecycler(List<FragmentProductos.ProductoPedido> data){
        adapter = new AdapterDetallePedido(getContext(),data);
        rvProductos.setAdapter(adapter);
        rvProductos.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    String ObtenerDni(){
        SharedPreferences preferences = this.getActivity().getSharedPreferences("user_data", MODE_PRIVATE);
        return preferences.getString("user_dni","0000000");
    }
    static FragmentGenerarPedido getFragmentGenerarPedido(){
        return fragmentGenerarPedido;
    }
    public void ActualizarAdapter(){
        adapter.notifyDataSetChanged();
    }
    void MostrarDialogFecha(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        ObtenerFechaEntrega(year,monthOfYear+1,dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    void ObtenerFechaEntrega(int i, int i1, int i2){
        txt_dni.setText(i+" " +i1+ " "+i2);
    }
    void ObtenerFechaActual(){
        fecha_pedido = Calendar.getInstance().getTime();
    }

}
