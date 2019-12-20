package com.example.dilorenzoapp.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dilorenzoapp.Clases.Cliente;
import com.example.dilorenzoapp.Fragments.PlaceholderFragment;
import com.example.dilorenzoapp.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterClientes extends RecyclerView.Adapter<AdapterClientes.ClienteViewHolder> implements Filterable {

    Context context;
    private List<Cliente> listaClientes;
    private List<Cliente> listaClientesFiltered;
    PlaceholderFragment placeholderFragment;
    public AdapterClientes(Context context, List<Cliente> listaClientes, PlaceholderFragment placeholderFragment){
        this.listaClientes = listaClientes;
        this.listaClientesFiltered = listaClientes;
        this.context = context;
        this.placeholderFragment = placeholderFragment;
    }

    @NonNull
    @Override
    public AdapterClientes.ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.content_cliente_card, parent, false);
        return new ClienteViewHolder(v, placeholderFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClientes.ClienteViewHolder holder, int i) {
        holder.tvNombreCliente.setText(listaClientesFiltered.get(i).getApellidos()+" "+listaClientesFiltered.get(i).getNombre());
        holder.txt_dni_cliente.setText(listaClientesFiltered.get(i).getDni()+"");
        for(Cliente.datos_facturacion e : listaClientesFiltered.get(i).getDatos_facturacion() ){
            holder.tvRazon.setText(e.getRazon_social());
        }
        if(listaClientesFiltered.get(i).getVerificado()){
            holder.img_estadoCliente.setBackgroundResource(R.drawable.estado_terminado);
        }else{
            holder.img_estadoCliente.setBackgroundResource(R.drawable.estado_cancelado);
        }
        holder.tvEstadoVenta.setText(listaClientesFiltered.get(i).getPuntaje().toString());
        holder.tvDireccion.setText(listaClientesFiltered.get(i).getDireccion());
    }
    @Override
    public int getItemCount() {
        return listaClientesFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    listaClientesFiltered = listaClientes;
                } else {
                    List<Cliente> filteredList = new ArrayList<>();
                    for (Cliente row : listaClientes) {
                        if (row.getNombre().toLowerCase().contains(charString.toLowerCase()) ||
                                row.getDni().contains(charString) ||
                                row.getApellidos().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    listaClientesFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listaClientesFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listaClientesFiltered = (ArrayList<Cliente>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ClienteViewHolder extends RecyclerView.ViewHolder {
        CardView card_cliente;
        ImageView img_estadoCliente;
        TextView tvNombreCliente, tvRazon, tvEstadoVenta, tvDireccion, txt_dni_cliente;
        public ClienteViewHolder(@NonNull View itemView, final PlaceholderFragment placeholderFragment) {
            super(itemView);
            txt_dni_cliente = itemView.findViewById(R.id.txt_dni_cliente);
            card_cliente = itemView.findViewById(R.id.card_cliente);
            tvNombreCliente = itemView.findViewById(R.id.tvNombreCliente);
            tvRazon = itemView.findViewById(R.id.tvRazon);
            img_estadoCliente = itemView.findViewById(R.id.img_estadoCliente);
            tvEstadoVenta = itemView.findViewById(R.id.tvEstadoVenta);
            tvDireccion= itemView.findViewById(R.id.tvDireccion);
            card_cliente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    placeholderFragment.setCliente(txt_dni_cliente.getText().toString());
                }
            });
        }
    }
}
