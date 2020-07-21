package idat.edu.pe.appjeanherrera.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import idat.edu.pe.appjeanherrera.R;
import idat.edu.pe.appjeanherrera.model.Cliente;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolder> {

    private List<Map<String,String>> lista;
    private Context context;

    public ClienteAdapter(Context conetxt) {
        this.context = conetxt;
        this.lista = new ArrayList<>();
    }

    @NonNull
    @Override
    public ClienteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cliente,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteAdapter.ViewHolder holder, int position) {
        holder.tvUserId.setText(lista.get(position).get("userId"));
        holder.tvId.setText(lista.get(position).get("id"));
        holder.tvTitle.setText(lista.get(position).get("title"));
        holder.tvCompleted.setText(lista.get(position).get("completed"));
    }

    public void agregarDatos(List<Map<String,String>> lista){
        this.lista.clear();
        this.lista.addAll(lista);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserId,tvId,tvTitle,tvCompleted;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserId = itemView.findViewById(R.id.tvUserId);
            tvId = itemView.findViewById(R.id.tvId);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvCompleted = itemView.findViewById(R.id.tvCompleted);
        }
    }
}
