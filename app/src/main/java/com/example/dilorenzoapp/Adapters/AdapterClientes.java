package com.example.dilorenzoapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dilorenzoapp.Clases.Cliente;
import com.example.dilorenzoapp.R;

import java.util.List;

public class AdapterClientes extends RecyclerView.Adapter<AdapterClientes.ClienteViewHolder> {

    Context context;
    private List<Cliente> listaClientes;

    public AdapterClientes(Context context, List<Cliente> listaClientes){
        this.listaClientes = listaClientes;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterClientes.ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.content_cliente_card, parent, false);
        return new ClienteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClientes.ClienteViewHolder holder, int i) {
        holder.tvNombreCliente.setText(listaClientes.get(i).getApellidos()+" "+listaClientes.get(i).getNombre());
        holder.tvRazon.setText(listaClientes.get(i).getRazonSocial());
        holder.tvEstadoCliente.setText(listaClientes.get(i).getEstadoCliente());
        holder.tvEstadoVenta.setText(listaClientes.get(i).getEstadoVentaCliente());
        holder.tvDireccion.setText(listaClientes.get(i).getDireccion());
    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }



    public class ClienteViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombreCliente, tvRazon, tvEstadoCliente, tvEstadoVenta, tvDireccion;
        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombreCliente = itemView.findViewById(R.id.tvNombreCliente);
            tvRazon = itemView.findViewById(R.id.tvRazon);
            tvEstadoCliente = itemView.findViewById(R.id.tvEstadoCliente);
            tvEstadoVenta = itemView.findViewById(R.id.tvEstadoVenta);
            tvDireccion= itemView.findViewById(R.id.tvDireccion);
        }
    }
}
