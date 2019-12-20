package com.example.dilorenzoapp.Fragments;


import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dilorenzoapp.Adapters.AdapterDetallePedido;
import com.example.dilorenzoapp.Adapters.AdapterFormasPago;
import com.example.dilorenzoapp.Adapters.AdapterProductos;
import com.example.dilorenzoapp.Clases.DetallePedido;
import com.example.dilorenzoapp.Clases.FormaPago;
import com.example.dilorenzoapp.Clases.NewDetallePedido;
import com.example.dilorenzoapp.Clases.NewPedido;
import com.example.dilorenzoapp.Clases.Producto;
import com.example.dilorenzoapp.InterfazServicios;
import com.example.dilorenzoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGenerarPedido extends Fragment {
    TextView txt_dni;
    RecyclerView rvProductos;
    AdapterDetallePedido adapter;

    TextInputEditText edit_descuento,edit_total, edit_subtotal;
    FloatingActionButton fabCalendario;
    FloatingActionButton fabCrearPedido;
    Spinner sp_forma_pago;

    List<DetallePedido> detallePedidoList;
    String dni_cliente;
    String dni_trabajador;
    Boolean entregado, pagado;
    String fecha_entrega;
    int formaPago;
    Double sub_total, total;

    Retrofit retrofit;
    InterfazServicios interfazServicios;

    public static FragmentGenerarPedido fragmentGenerarPedido;
    public FragmentGenerarPedido() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_generar_pedido, container, false);

        txt_dni = view.findViewById(R.id.txt_dni);
        edit_descuento = view.findViewById(R.id.edit_descuento);
        edit_total = view.findViewById(R.id.edit_total);
        edit_subtotal= view.findViewById(R.id.edit_subtotal);
        rvProductos = view.findViewById(R.id.rvProductos);
        fabCrearPedido = view.findViewById(R.id.fabCrearPedido);
        fabCrearPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CrearPedido();
            }
        });
        fabCalendario = view.findViewById(R.id.fabCalendario);
        fabCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MostrarDialogFecha(view);
            }
        });
        sp_forma_pago = view.findViewById(R.id.sp_formas_pago);

        fragmentGenerarPedido = this;
        detallePedidoList = FragmentProductos.getFragmentProductos().getDetallePedido();
        dni_cliente = PlaceholderFragment.getPlaceholderFragment().getCliente();
        dni_trabajador = ObtenerDni();
        retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.URL_Conection) + "Codigo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        interfazServicios = retrofit.create(InterfazServicios.class);
        ConstruirRecycler(detallePedidoList);
        CargarDataFormaPago();
        edit_descuento.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                CalcularTotal();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }
    void ConstruirSpinner(List<FormaPago> data){
        AdapterFormasPago adapter = new AdapterFormasPago(getContext(), data,R.layout.item_spinner_forma_pago);
        sp_forma_pago.setAdapter(adapter);
    }
    void ConstruirRecycler(List<DetallePedido> data){
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
                        fecha_entrega = year+"-"+(monthOfYear+1)+"-"+dayOfMonth;
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    String ObtenerFechaActual(){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR)+"-"+ (c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH);
    }
    public void CrearPedido(){
        FormaPago f = (FormaPago) sp_forma_pago.getSelectedItem();
        if(f.getDescripcion().equals("Contado")){
            formaPago = 1;
        }else if(f.getDescripcion().equals("Credito")){
            formaPago = 2;
        }
        Call<NewPedido> crearPedido = interfazServicios.CrearPedido(
                dni_cliente,
                dni_trabajador,
                ObtenerFechaActual(),
                fecha_entrega,
                false,
                false,
                formaPago,
                Double.valueOf(edit_descuento.getText().toString()),
                Double.valueOf(edit_total.getText().toString()));
        crearPedido.enqueue(new Callback<NewPedido>() {
            @Override
            public void onResponse(Call<NewPedido> call, Response<NewPedido> response) {
                CrearDetallePedido(response.body().getId());
            }

            @Override
            public void onFailure(Call<NewPedido> call, Throwable t) {

            }
        });

    }
    public void CrearDetallePedido(int idCabeceraPedido){
        for(DetallePedido e: detallePedidoList){
            Call<NewDetallePedido> crearDetallePedido = interfazServicios.CrearDetallePedido(
                    idCabeceraPedido,
                    Integer.valueOf(e.getProducto().getId()),
                    e.getCantidad()
            );
            crearDetallePedido.enqueue(new Callback<NewDetallePedido>() {
                @Override
                public void onResponse(Call<NewDetallePedido> call, Response<NewDetallePedido> response) {
                }

                @Override
                public void onFailure(Call<NewDetallePedido> call, Throwable t) {

                }
            });
        }
    }
    void CargarDataFormaPago(){
        Call<List<FormaPago>> listFormaPago = interfazServicios.listFormaPago();
        listFormaPago.enqueue(new Callback<List<FormaPago>>() {
            @Override
            public void onResponse(Call<List<FormaPago>> call, Response<List<FormaPago>> response) {
                ConstruirSpinner(response.body());
            }

            @Override
            public void onFailure(Call<List<FormaPago>> call, Throwable t) {

            }
        });
    }
    void CalcularSubTotal() {
        sub_total = 0.0;
        total = 0.0;
        for (DetallePedido e : detallePedidoList) {
            sub_total += e.getTotal();
        }
        edit_subtotal.setText(sub_total.toString());
        CalcularTotal();
    }
    void CalcularTotal(){
        if(edit_descuento.getText().toString().length() <= 0){
            edit_total.setText(edit_subtotal.getText().toString());
        }else{
            total = (Double.valueOf(edit_subtotal.getText().toString()) - Double.valueOf(edit_descuento.getText().toString()));
            edit_total.setText(total.toString());
        }
    }
    void ActualizarAdapter(){
        adapter.notifyDataSetChanged();
        CalcularSubTotal();
    }
}
