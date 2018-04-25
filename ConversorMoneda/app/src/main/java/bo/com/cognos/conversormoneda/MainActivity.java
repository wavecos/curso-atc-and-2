package bo.com.cognos.conversormoneda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMonto;
    private TextView textViewResultado;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMonto = findViewById(R.id.editTextMonto);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttonCalcular = findViewById(R.id.buttonCalcular);
    }


    public void convertirMoneda(View view) {
        // 1 leer el monto
        String monto = editTextMonto.getText().toString();

        Log.d("PRUEBA", "el monto es = " + monto);

        // Formula de conversion
        Double montoBolivianos = 6.95 * Double.valueOf(monto);

        textViewResultado.setText("" + montoBolivianos + " BOB");
        textViewResultado.setTextColor(getResources().getColor(R.color.colorPrimary));

        buttonCalcular.setText("LISTO");
        buttonCalcular.setEnabled(false);
    }


}
