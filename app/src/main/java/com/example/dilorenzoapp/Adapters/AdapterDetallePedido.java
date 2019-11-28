package com.example.dilorenzoapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dilorenzoapp.Clases.Cliente;
import com.example.dilorenzoapp.Fragments.FragmentProductos;
import com.example.dilorenzoapp.Fragments.PlaceholderFragment;
import com.example.dilorenzoapp.R;

import java.util.List;

public class AdapterDetallePedido extends RecyclerView.Adapter<AdapterDetallePedido.HolderDetallePedido> {
    Context context;
    private List<FragmentProductos.ProductoPedido> detalleProducto;

    public AdapterDetallePedido(Context context, List<FragmentProductos.ProductoPedido> detalleProducto ){
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
        holder.txt_descripcion.setText(detalleProducto.get(position).getProducto());
        holder.txt_cantidad.setText(detalleProducto.get(position).getCantidad()+"");
    }

    @Override
    public int getItemCount() {
        return detalleProducto.size();
    }

    class HolderDetallePedido extends RecyclerView.ViewHolder {
        TextView txt_descripcion, txt_cantidad;
        public HolderDetallePedido(@NonNull View itemView) {
            super(itemView);
            txt_descripcion = itemView.findViewById(R.id.txt_descripcion);
            txt_cantidad = itemView.findViewById(R.id.txt_cantidad);
        }
    }
}
