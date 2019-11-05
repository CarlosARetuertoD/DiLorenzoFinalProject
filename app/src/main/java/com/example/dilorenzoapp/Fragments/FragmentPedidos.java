package com.example.dilorenzoapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dilorenzoapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPedidos extends Fragment {


    public FragmentPedidos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_pedidos, container, false);
    }

}
