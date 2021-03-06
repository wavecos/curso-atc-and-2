package bo.com.cognos.topmusic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import bo.com.cognos.topmusic.domain.Cancion;


public class CancionAdapter extends RecyclerView.Adapter<CancionAdapter.CancionViewHolder> {

    private Context context;

    private List<Cancion> dataset;

    private static final String TAG = CancionAdapter.class.getSimpleName();

    public CancionAdapter(List<Cancion> dataset, Context context) {
        this.dataset = dataset;
        this.context = context;
    }

    @Override
    public CancionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View cancionView = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_item, parent, false);

        CancionViewHolder cancionViewHolder = new CancionViewHolder(cancionView);

        return cancionViewHolder;
    }

    @Override
    public void onBindViewHolder(CancionViewHolder holder, final int position) {
        final Cancion cancion = dataset.get(position);
        holder.textViewNombre.setText(cancion.getNombreCancion());

        String albumGenero = cancion.getNombreAlbum() + " - " + cancion.getGenero();
        holder.textViewAlbumGenero.setText(albumGenero);

        // Aca cargamos la imagen
        Picasso.get().load(cancion.getImagenUrl()).into(holder.imageViewAlbum);

        holder.imageViewAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "elemento :: " + position);
                Intent intent = new Intent(context, InfoActivity.class);
                intent.putExtra("cancion", cancion);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    // Inner Class
    public static class CancionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textViewNombre;
        public TextView textViewAlbumGenero;
        public ImageView imageViewAlbum;

        public CancionViewHolder(View view) {
            super(view);
            textViewNombre = view.findViewById(R.id.textViewNombre);
            textViewAlbumGenero = view.findViewById(R.id.textViewAlbumGenero);
            imageViewAlbum = view.findViewById(R.id.imageViewAlbum);

            textViewAlbumGenero.setTextColor(Color.MAGENTA);

            textViewNombre.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "Se hizo click en un cardview");
        }
    }

}
