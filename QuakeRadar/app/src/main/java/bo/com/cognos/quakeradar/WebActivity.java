package bo.com.cognos.quakeradar;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import bo.com.cognos.quakeradar.domain.Quake;
import bo.com.cognos.quakeradar.persistence.AppDatabase;

public class WebActivity extends AppCompatActivity {

    private WebView webView;
    private Quake quake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = findViewById(R.id.webView);

        Bundle bundle = getIntent().getExtras();
        quake = (Quake) bundle.getSerializable("quake");
//        String quakeUrl = getIntent().getExtras().getString("quakeUrl");

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.loadUrl(quake.getUrl());
    }

    public void addFavorite(View view) {
        // Obtener una instancia del AppDatabase
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "quakes-db")
                .allowMainThreadQueries()
                .build();

        database.getQuakeDAO().insert(quake);
        Toast.makeText(this, "Añadido a Favoritos", Toast.LENGTH_SHORT).show();
    }
}
