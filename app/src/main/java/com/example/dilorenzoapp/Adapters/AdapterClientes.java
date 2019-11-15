package com.example.dilorenzoapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        for(Cliente.datos_facturacion e : listaClientes.get(i).getDatos_facturacion() ){
            holder.tvRazon.setText(e.getRazon_social());
        }
        if(listaClientes.get(i).getVerificado()){
            holder.img_estadoCliente.setBackgroundResource(R.drawable.estado_terminado);
        }else{
            holder.img_estadoCliente.setBackgroundResource(R.drawable.estado_cancelado);
        }
        holder.tvEstadoVenta.setText(listaClientes.get(i).getPuntaje().toString());
        holder.tvDireccion.setText(listaClientes.get(i).getDireccion());
    }
    @Override
    public int getItemCount() {
        return listaClientes.size();
    }



    public class ClienteViewHolder extends RecyclerView.ViewHolder {
        ImageView img_estadoCliente;
        TextView tvNombreCliente, tvRazon, tvEstadoVenta, tvDireccion;
        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombreCliente = itemView.findViewById(R.id.tvNombreCliente);
            tvRazon = itemView.findViewById(R.id.tvRazon);
            img_estadoCliente = itemView.findViewById(R.id.img_estadoCliente);
            tvEstadoVenta = itemView.findViewById(R.id.tvEstadoVenta);
            tvDireccion= itemView.findViewById(R.id.tvDireccion);
        }
    }
}
