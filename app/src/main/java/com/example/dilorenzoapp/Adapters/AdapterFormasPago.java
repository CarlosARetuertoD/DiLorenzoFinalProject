package com.example.dilorenzoapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dilorenzoapp.Clases.FormaPago;
import com.example.dilorenzoapp.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class AdapterFormasPago extends BaseAdapter {
    Context c;
    List<FormaPago> data;
    int layout;

    public AdapterFormasPago(Context c, List<FormaPago> data, int layout) {
        this.c = c;
        this.data = data;
        this.layout = layout;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(c);
        view = inflater.inflate(layout, null);
        TextView txt_forma_pago = view.findViewById(R.id.txt_forma_pago);
        txt_forma_pago.setText(data.get(i).getDescripcion());
        return view;
    }
}
