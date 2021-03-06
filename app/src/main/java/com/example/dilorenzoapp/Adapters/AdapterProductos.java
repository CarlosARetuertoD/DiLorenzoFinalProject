package com.example.dilorenzoapp.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dilorenzoapp.Clases.Cliente;
import com.example.dilorenzoapp.Clases.Producto;
import com.example.dilorenzoapp.Fragments.FragmentProductos;
import com.example.dilorenzoapp.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.HolderProductos> implements Filterable {
    Context context;
    private List<Producto> productos;
    private List<Producto> productosFiltered;
    FragmentProductos fragmentProductos;
    public AdapterProductos(Context context, List<Producto> productos, FragmentProductos fragmentProductos) {
        this.context = context;
        this.productos = productos;
        this.productosFiltered = productos;
        this.fragmentProductos = fragmentProductos;
    }

    @NonNull
    @Override
    public AdapterProductos.HolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.content_producto_card, parent, false);
        return new HolderProductos(v,fragmentProductos);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProductos.HolderProductos holder, int position) {
        holder.tvDescripcion.setText(productosFiltered.get(position).getDescripcion());
        holder.tvPresentacion.setText(productosFiltered.get(position).getPresentacion());
        holder.tvMarca.setText(productosFiltered.get(position).getMarca().getDescripcion());
        holder.tvPrecio.setText("Precio S/."+ productosFiltered.get(position).getPrecio());
        holder.tvIdProducto.setText(productosFiltered.get(position).getId()+"");
        holder.producto = productosFiltered.get(position);
    }

    @Override
    public int getItemCount() {
        return productosFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    productosFiltered = productos;
                } else {
                    List<Producto> filteredList = new ArrayList<>();
                    for (Producto row : productos) {
                        if (row.getCategoria().getDescripcion().toLowerCase().contains(charString.toLowerCase()) ||
                                row.getMarca().getDescripcion().toLowerCase().contains(charString.toLowerCase()) ||
                                row.getDescripcion().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    productosFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = productosFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                productosFiltered = (ArrayList<Producto>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class HolderProductos extends RecyclerView.ViewHolder {
        CardView cardProducto;
        TextView tvDescripcion, tvPresentacion, tvMarca, tvPrecio, tvCantidad, tvIdProducto;
        ImageButton tvMas, tvMenos;
        Producto producto ;
        public HolderProductos(@NonNull View itemView, final FragmentProductos fragmentProductos) {
            super(itemView);

            tvIdProducto = itemView.findViewById(R.id.tvIdProducto);
            tvMas = itemView.findViewById(R.id.tvMas);
            tvMenos = itemView.findViewById(R.id.tvMenos);
            cardProducto = itemView.findViewById(R.id.cardProducto);
            tvCantidad =itemView.findViewById(R.id.tvBoton);
            tvPrecio =itemView.findViewById(R.id.tvPrecio);
            tvPresentacion =itemView.findViewById(R.id.tvPresentacion);
            tvMarca =itemView.findViewById(R.id.tvMarca);
            tvDescripcion =itemView.findViewById(R.id.tvDescripcion);

            tvMas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int cantidad = Integer.valueOf(tvCantidad.getText().toString());
                    tvCantidad.setText((cantidad+1)+"");
                    fragmentProductos.ActualizarDetallePedido(producto, 0);
                    cardProducto.setBackgroundColor(context.getColor(R.color.colorBackgroundItem));
                }
            });
            tvMenos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int cantidad = Integer.valueOf(tvCantidad.getText().toString());
                    if(cantidad > 1){
                        tvCantidad.setText((cantidad -1)+"");
                        fragmentProductos.ActualizarDetallePedido(producto, 1);
                    }if(cantidad == 1){
                        tvCantidad.setText("0");
                        fragmentProductos.ActualizarDetallePedido(producto, 2);
                        cardProducto.setBackgroundColor(context.getColor(R.color.colorTextBlanco));
                    }
                }
            });
        }

    }
}
