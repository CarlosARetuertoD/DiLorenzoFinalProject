package com.example.dilorenzoapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dilorenzoapp.Clases.Pedido;
import com.example.dilorenzoapp.R;

import java.util.List;

public class PedidosAdapter extends RecyclerView.Adapter<PedidoHolder>{
    LayoutInflater inflater;
    List<Pedido> data;
    Context c;
    private View.OnClickListener listener;
    public PedidosAdapter(Context c, List<Pedido> data) {
        this.c = c;
        inflater = LayoutInflater.from(c);
        this.data = data;
    }
    @NonNull
    @Override
    public PedidoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_listado_pedidos, parent, false);
        return new PedidoHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoHolder holder, int position) {
        holder.txt_numero_pedido.setText(String.valueOf(data.get(position).getId()));
        holder.txt_nombre_cliente.setText(data.get(position).getCliente().getApellidos() + " " +data.get(position).getCliente().getNombre());
        holder.txt_monto_pedido.setText(String.valueOf(data.get(position).getMonto()));
        if(data.get(position).getPagado()){
            holder.txt_estadoPago.setText("Pago Cancelado");
            holder.img_estadoPago.setBackgroundResource(R.drawable.estado_terminado);
        }else{
            holder.txt_estadoPago.setText("Pago no Cancelado");
            holder.img_estadoPago.setBackgroundResource(R.drawable.estado_pendiente);
        }
        if(data.get(position).getEntregado()){
            holder.txt_estadoEntrega.setText("Entregado");
            holder.img_estadoEntrega.setBackgroundResource(R.drawable.estado_terminado);
        }else{
            holder.txt_estadoEntrega.setText("No Entregado");
            holder.img_estadoEntrega.setBackgroundResource(R.drawable.estado_pendiente);
        }
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

}
class PedidoHolder extends RecyclerView.ViewHolder {
    TextView txt_numero_pedido, txt_nombre_cliente, txt_monto_pedido,
            txt_estadoPago, txt_estadoEntrega;
    ImageView img_estadoPago, img_estadoEntrega;
    public PedidoHolder(@NonNull View itemView) {
        super(itemView);
        txt_numero_pedido = itemView.findViewById(R.id.txt_numero_pedido);
        txt_nombre_cliente = itemView.findViewById(R.id.txt_nombre_cliente);
        txt_monto_pedido = itemView.findViewById(R.id.txt_monto_pedido);
        txt_estadoPago = itemView.findViewById(R.id.txt_estadoPago);
        txt_estadoEntrega = itemView.findViewById(R.id.txt_estadoEntrega);

        img_estadoPago = itemView.findViewById(R.id.img_estadoPago);
        img_estadoEntrega = itemView.findViewById(R.id.img_estadoEntrega);

    }
}