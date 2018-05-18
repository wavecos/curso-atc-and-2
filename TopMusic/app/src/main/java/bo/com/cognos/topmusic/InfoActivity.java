package bo.com.cognos.topmusic;

import android.media.MediaPlayer;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import bo.com.cognos.topmusic.domain.Cancion;

public class InfoActivity extends AppCompatActivity {

    private ImageView imageViewAlbum;
    private TextView textViewAlbum;
    private TextView textViewCancion;
    private TextView textViewArtista;
    private TextView textViewGenero;
    private ImageButton imageButtonPlay;

    private Cancion cancion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageViewAlbum = findViewById(R.id.imageViewAlbum);
        textViewAlbum = findViewById(R.id.textViewAlbum);
        textViewCancion = findViewById(R.id.textViewCancion);
        textViewArtista = findViewById(R.id.textViewArtista);
        imageButtonPlay = findViewById(R.id.imageButtonPlay);

        cancion = getIntent().getExtras().getParcelable("cancion");


        Picasso.get().load(cancion.getImagenUrl()).into(imageViewAlbum);
        textViewAlbum.setText(cancion.getNombreAlbum());
        textViewCancion.setText(cancion.getNombreCancion());
        textViewArtista.setText(cancion.getNombreArtista());

    }


    public void playCancion(View view) {

        MediaPlayer player = new MediaPlayer();
        try {
            player.setDataSource(cancion.getCancionUrl());
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
