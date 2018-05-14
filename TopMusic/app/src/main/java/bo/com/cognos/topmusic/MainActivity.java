package bo.com.cognos.topmusic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Cancion> canciones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCanciones();

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

    public void getCanciones() {
        Call<Resultado> resultadoCall = ItunesAPI.getClient().getCanciones("beatles");

        resultadoCall.enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                Resultado resultado = response.body();
                List<Cancion> songs = resultado.getResults();

                canciones.addAll(songs);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error al llamar canciones", Toast.LENGTH_LONG);
            }
        });

    }

}
