package com.example.dilorenzoapp.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dilorenzoapp.Adapters.AdapterClientes;
import com.example.dilorenzoapp.Clases.Cliente;
import com.example.dilorenzoapp.InterfazServicios;
import com.example.dilorenzoapp.PageViewModel;
import com.example.dilorenzoapp.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class  PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static PlaceholderFragment placeholderFragment;
    RecyclerView recyclerView;
    AdapterClientes adapter;
    String cliente;
    SearchView sv_clientes;
    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cliente = "cliente_no_seleccionado";
        placeholderFragment = this;
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 0;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = root.findViewById(R.id.rvClientes);
        sv_clientes = root.findViewById(R.id.sv_clientes);
        ConexionRetrofit();
        sv_clientes.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return root;
    }
    void ConstruirRecycler(final List<Cliente> data){
        adapter = new AdapterClientes(getContext(),data, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    public void ConexionRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.URL_Conection) + "Codigo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfazServicios interfazServicios = retrofit.create(InterfazServicios.class);
        Call<List<Cliente>> listCliente = interfazServicios.listCliente();
        listCliente.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                ConstruirRecycler(response.body());
            }
            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {

            }
        });
    }

    static PlaceholderFragment getPlaceholderFragment(){
        return placeholderFragment;
    }
    public String getCliente(){
        return this.cliente;
    }
    public  void setCliente(String cliente){
        this.cliente = cliente;
        Log.e("cliente",cliente);
    }
}
