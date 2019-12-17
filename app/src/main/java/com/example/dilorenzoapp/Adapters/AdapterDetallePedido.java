package com.example.dilorenzoapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dilorenzoapp.Clases.Cliente;
import com.example.dilorenzoapp.Clases.DetallePedido;
import com.example.dilorenzoapp.Fragments.FragmentProductos;
import com.example.dilorenzoapp.Fragments.PlaceholderFragment;
import com.example.dilorenzoapp.R;

import java.util.List;

public class AdapterDetallePedido extends RecyclerView.Adapter<AdapterDetallePedido.HolderDetallePedido> {
    Context context;
    private List<DetallePedido> detalleProducto;

    public AdapterDetallePedido(Context context, List<DetallePedido> detalleProducto ){
        this.detalleProducto = detalleProducto;
        this.context = context;
    }
    @NonNull
    @Override
    public HolderDetallePedido onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_detalle_producto, parent, false);
        return new HolderDetallePedido(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDetallePedido holder, int position) {
        holder.txt_descripcion.setText(detalleProducto.get(position).getProducto().getDescripcion());
        holder.txt_marca.setText(detalleProducto.get(position).getProducto().getMarca().getDescripcion());
        holder.txt_cantidad.setText(detalleProducto.get(position).getCantidad()+"");
        holder.txt_precioxU.setText(detalleProducto.get(position).getProducto().getPrecio()+"");
        holder.txt_total.setText(detalleProducto.get(position).getTotal()+"");
    }

    @Override
    public int getItemCount() {
        return detalleProducto.size();
    }

    class HolderDetallePedido extends RecyclerView.ViewHolder {
        TextView txt_descripcion, txt_marca,txt_precioxU, txt_cantidad,txt_total;
        public HolderDetallePedido(@NonNull View itemView) {
            super(itemView);
            txt_descripcion = itemView.findViewById(R.id.txt_descripcion);
            txt_marca = itemView.findViewById(R.id.txt_marca);
            txt_precioxU = itemView.findViewById(R.id.txt_precioxU);
            txt_cantidad = itemView.findViewById(R.id.txt_cantidad);
            txt_total = itemView.findViewById(R.id.txt_total);
        }
    }
}
