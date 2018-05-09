package bo.com.cognos.topmusic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import bo.com.cognos.topmusic.domain.Cancion;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lista de Canciones
        List<Cancion> canciones = new ArrayList<>();

        Cancion cancion1 = new Cancion();
        cancion1.setNombreArtista("Shakira");
        cancion1.setGenero("Latino");
        cancion1.setNombreAlbum("En vivo 2016");

        canciones.add(cancion1);

        Cancion cancion2 = new Cancion();
        cancion2.setNombreArtista("Pablo Milanes");
        cancion2.setGenero("Latino");
        cancion2.setNombreAlbum("Donde jugaran los comunistas");

        canciones.add(cancion2);

        Cancion cancion3 = new Cancion();
        cancion3.setNombreArtista("Jhon Lennon");
        cancion3.setGenero("Rock");
        cancion3.setNombreAlbum("Image");

        canciones.add(cancion3);


        // Buscamos el Recycler View
        recyclerView = findViewById(R.id.recyclerViewCancion);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CancionAdapter(canciones);
        recyclerView.setAdapter(adapter);

    }

    public void verDetalle(View view) {
        Intent intent = new Intent(this, CancionActivity.class);
        startActivity(intent);
    }

    public void verPagina(View view) {
        Uri uri = Uri.parse("http://www.cognos.com.bo");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
