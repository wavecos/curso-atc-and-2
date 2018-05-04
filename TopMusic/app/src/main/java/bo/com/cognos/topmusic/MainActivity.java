package bo.com.cognos.topmusic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
