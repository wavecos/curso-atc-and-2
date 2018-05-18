package bo.com.cognos.topmusic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bo.com.cognos.topmusic.domain.Cancion;
import bo.com.cognos.topmusic.domain.Resultado;
import bo.com.cognos.topmusic.service.ItunesAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private EditText editTextArtista;

    List<Cancion> canciones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Buscamos el Recycler View
        recyclerView = findViewById(R.id.recyclerViewCancion);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CancionAdapter(canciones, this);
        recyclerView.setAdapter(adapter);

        editTextArtista = findViewById(R.id.editTextArtista);

        Log.d("TEST", "despues de la llamada al servicio web");
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


    private void obtenerCanciones(String artista) {
        Call<Resultado> resultadoCall = ItunesAPI.getItunesService().getCanciones(artista, "song");

        resultadoCall.enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                Resultado body = response.body();
                List<Cancion> results = body.getResults();

                canciones.clear();
                canciones.addAll(results);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ha ocurrido un error", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void buscarCanciones(View view) {
        String criterio = editTextArtista.getText().toString();

        Log.d(TAG, "el criterio de busqueda es : " + criterio);

        obtenerCanciones(criterio);
    }
}
