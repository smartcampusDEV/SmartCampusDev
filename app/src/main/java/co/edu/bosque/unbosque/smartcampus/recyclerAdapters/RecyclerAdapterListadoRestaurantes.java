package co.edu.bosque.unbosque.smartcampus.recyclerAdapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.bosque.unbosque.smartcampus.classes.Restaurante;
import co.edu.bosque.unbosque.smartcampus.R;

/**
 * Created by SYSTEM on 20/07/2018.
 */

public class RecyclerAdapterListadoRestaurantes extends RecyclerView.Adapter<RecyclerAdapterListadoRestaurantes.ViewHolder> {

    private ArrayList<Restaurante> listadoRestaurantes;

    public RecyclerAdapterListadoRestaurantes(ArrayList<Restaurante> pListadoRestaurantes){
        listadoRestaurantes = pListadoRestaurantes;

    }

    @NonNull
    @Override
    public RecyclerAdapterListadoRestaurantes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Relaciona el adaptador con el Holder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_listadorestaurantes,null,false);
        return new RecyclerAdapterListadoRestaurantes.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterListadoRestaurantes.ViewHolder holder, int position) {
        holder.asignarDatos(listadoRestaurantes.get(position));
    }

    @Override
    public int getItemCount() {
        return listadoRestaurantes.size();
    }

    private TextView tituloRestaurante,contenidoRestaurante;
    private ImageView imagenRestaurante;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);

            tituloRestaurante = itemView.findViewById(R.id.tv_tituloRestaurante);
            imagenRestaurante = itemView.findViewById(R.id.imageView);
            contenidoRestaurante = itemView.findViewById(R.id.tv_contenidoRestaurante);
        }

        public void asignarDatos(Restaurante restaurante) {
            tituloRestaurante.setText(restaurante.darTituloRestaurante());
            contenidoRestaurante.setText(restaurante.darInformacionRestaurante());
            if(tituloRestaurante.getText().equals("Empanadas típicas")){
                imagenRestaurante.setImageResource(R.drawable.tipicaslogo);
            }else if(tituloRestaurante.getText().equals("Oma")){
                imagenRestaurante.setImageResource(R.drawable.omalogo);
            }else if(tituloRestaurante.getText().equals("Don Perro")){
                imagenRestaurante.setImageResource(R.drawable.donperrologo);
            }
        }
    }
}
