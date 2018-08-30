package co.edu.bosque.unbosque.smartcampus.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import co.edu.bosque.unbosque.smartcampus.classes.Restaurante;
import co.edu.bosque.unbosque.smartcampus.R;
import co.edu.bosque.unbosque.smartcampus.recyclerAdapters.RecyclerAdapterListadoRestaurantes;
import co.edu.bosque.unbosque.smartcampus.recyclerAdapters.RecyclerAdapterRestaurantesImportantes;

public class ScrollingActivity extends AppCompatActivity {

    private ArrayList<String> listadoRestaurantesImportantes;
    private ArrayList<Restaurante> listadoRestaurantes;
    private RecyclerView recyclerViewListadoRestaurantesImportantes,recyclerViewListadoRestaurantes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        listadoRestaurantesImportantes = new ArrayList<String>();
        listadoRestaurantes = new ArrayList<Restaurante>();

        recyclerViewListadoRestaurantesImportantes = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewListadoRestaurantesImportantes.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        listadoRestaurantesImportantes.add("Información");
        listadoRestaurantesImportantes.add("Don perro");
        listadoRestaurantesImportantes.add("Don Juan");

        RecyclerAdapterRestaurantesImportantes recyclerAdapter = new RecyclerAdapterRestaurantesImportantes(listadoRestaurantesImportantes);
        recyclerViewListadoRestaurantesImportantes.setAdapter(recyclerAdapter);

        recyclerViewListadoRestaurantes = (RecyclerView) findViewById(R.id.recyclerViewListadoRestaurantes);
        recyclerViewListadoRestaurantes.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        listadoRestaurantes.add(new Restaurante("Empanadas típicas","Empanadas típicas informacion"));
        listadoRestaurantes.add(new Restaurante("Oma","Todo contenido importante"));
        listadoRestaurantes.add(new Restaurante("Don Perro","Deliciosos perros"));

        RecyclerAdapterListadoRestaurantes recyclerAdapterListadoRestaurantes = new RecyclerAdapterListadoRestaurantes(listadoRestaurantes);
        recyclerViewListadoRestaurantes.setAdapter(recyclerAdapterListadoRestaurantes);
    }
}
