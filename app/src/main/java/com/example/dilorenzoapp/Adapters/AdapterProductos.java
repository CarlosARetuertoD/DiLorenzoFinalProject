package com.example.dilorenzoapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dilorenzoapp.Clases.Producto;
import com.example.dilorenzoapp.R;

import java.util.List;

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.HolderProductos> {

    Context context;
    private List<Producto> productos;

    public AdapterProductos(Context context, List<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    @NonNull
    @Override
    public AdapterProductos.HolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.content_producto_card, parent, false);
        return new HolderProductos(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProductos.HolderProductos holder, int position) {
        holder.tvDescripcion.setText(productos.get(position).getDescripcion());
        holder.tvPresentacion.setText(productos.get(position).getPresentacion());
        holder.tvMarca.setText(productos.get(position).getMarca().getDescripcion());
        holder.tvPrecio.setText("Precio S/."+ productos.get(position).getPrecio());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class HolderProductos extends RecyclerView.ViewHolder {

        TextView tvDescripcion, tvPresentacion, tvMarca, tvPrecio, tvBoton;

        public HolderProductos(@NonNull View itemView) {
            super(itemView);
            tvBoton =itemView.findViewById(R.id.tvBoton);
            tvPrecio =itemView.findViewById(R.id.tvPrecio);
            tvPresentacion =itemView.findViewById(R.id.tvPresentacion);
            tvMarca =itemView.findViewById(R.id.tvMarca);
            tvDescripcion =itemView.findViewById(R.id.tvDescripcion);
        }
    }
}
