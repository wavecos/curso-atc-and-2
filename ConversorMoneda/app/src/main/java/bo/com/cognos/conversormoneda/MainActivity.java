package bo.com.cognos.conversormoneda;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    private EditText editTextMonto;
    private TextView textViewResultado;
    private Button buttonCalcular;

    private String moneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMonto = findViewById(R.id.editTextMonto);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttonCalcular = findViewById(R.id.buttonCalcular);

//        editTextMonto.setHint(R.string.autor);


        textViewResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast alerta = Toast.makeText(context, "Hola Mundo", Toast.LENGTH_SHORT);
                alerta.show();
            }
        });

        moneda = getIntent().getStringExtra("moneda");

        if (moneda.equals("USD")) {
            editTextMonto.setHint("Monto en Dólares");
        } else if (moneda.equals("EUR")) {
            editTextMonto.setHint("Monto en Euros");
        }

        Log.d(TAG, "El tipo de moneda recibido es : " + moneda);
    }


    public void convertirMoneda(View view) throws Exception {
        // 1 leer el monto
        String monto = editTextMonto.getText().toString();

        Log.d("PRUEBA", "el monto es = " + monto);

        // Formula de conversion
        Double factorDeConversion = 0D;
        if (moneda.equals("USD")) {
            factorDeConversion = 6.94;
        } else if (moneda.equals("EUR")) {
            factorDeConversion = 8.28;
        }

        Double montoBolivianos = factorDeConversion * Double.valueOf(monto);

        if (montoBolivianos == 0) {
            Exception e = new Exception("ooops!!");
            Log.e(TAG, "Ha ocurrido un error : " + e.getMessage());
//            throw e;
        }

        textViewResultado.setText("" + montoBolivianos + " BOB");
        textViewResultado.setTextColor(getResources().getColor(R.color.colorPrimary));

        buttonCalcular.setText("LISTO");
    }


}
