package com.example.dilorenzoapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dilorenzoapp.Adapters.AdapterClientes;
import com.example.dilorenzoapp.Clases.Cliente;
import com.example.dilorenzoapp.PageViewModel;
import com.example.dilorenzoapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class  PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";


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
        final RecyclerView recyclerView = root.findViewById(R.id.rvClientes);
        List <Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Visitado", "Raul", "Valdivia", "Coop VAB i3 yanahuara","Las Graditas", "deuda"));
        AdapterClientes adapter = new AdapterClientes(getContext(),clientes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }
}