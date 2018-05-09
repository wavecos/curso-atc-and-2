package bo.com.cognos.topmusic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] canciones = {"let it be", "gang nan style", "los pollitos dice"};

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
