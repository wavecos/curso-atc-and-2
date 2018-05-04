package bo.com.cognos.conversormoneda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void convertirUSD(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("moneda", "USD");
        startActivity(intent);
    }

    public void convertirEUR(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("moneda", "EUR");
        startActivity(intent);
    }

}
