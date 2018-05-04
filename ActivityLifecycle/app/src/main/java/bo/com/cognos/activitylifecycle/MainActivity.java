package bo.com.cognos.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreated Finalizado", Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "onCreated Finalizado");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart Finalizado", Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "onStart Finalizado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume Finalizado", Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "onResume Finalizado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause Finalizado", Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "onPause Finalizado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop Finalizado", Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "onStop Finalizado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy Finalizado", Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "onDestroy Finalizado");
    }
}
