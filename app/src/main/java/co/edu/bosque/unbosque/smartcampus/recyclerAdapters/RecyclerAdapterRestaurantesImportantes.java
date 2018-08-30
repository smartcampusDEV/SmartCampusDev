package co.edu.bosque.unbosque.smartcampus.recyclerAdapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.bosque.unbosque.smartcampus.R;

/**
 * Created by SYSTEM on 19/07/2018.
 */
public class RecyclerAdapterRestaurantesImportantes extends RecyclerView.Adapter<RecyclerAdapterRestaurantesImportantes.MyViewHolder> {
    private ArrayList<String> datos;

    public RecyclerAdapterRestaurantesImportantes(ArrayList<String> datos){
    this.datos = datos;
    }

    @NonNull
    @Override
    public RecyclerAdapterRestaurantesImportantes.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Relaciona el adaptador con el Holder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_adapter,null,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterRestaurantesImportantes.MyViewHolder holder, int position) {
        holder.asignarDatos(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    private TextView tituloNoticia;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
            tituloNoticia = itemView.findViewById(R.id.cardView_tituloNoticia);
        }

        public void asignarDatos(String datoActual) {
            tituloNoticia.setText(datoActual);
        }
    }
}
