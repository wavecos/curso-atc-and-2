package bo.com.cognos.topmusic;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bo.com.cognos.topmusic.domain.Cancion;


public class CancionAdapter extends RecyclerView.Adapter<CancionAdapter.CancionViewHolder> {

    private List<Cancion> dataset;

    public CancionAdapter(List<Cancion> dataset) {
        this.dataset = dataset;
    }

    @Override
    public CancionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View cancionView = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_item, parent, false);

        CancionViewHolder cancionViewHolder = new CancionViewHolder(cancionView);

        return cancionViewHolder;
    }

    @Override
    public void onBindViewHolder(CancionViewHolder holder, int position) {
        Cancion cancion = dataset.get(position);
        holder.textViewNombre.setText(cancion.getNombreArtista());

        String albumGenero = cancion.getNombreAlbum() + " - " + cancion.getGenero();
        holder.textViewAlbumGenero.setText(albumGenero);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    // Inner Class
    public static class CancionViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNombre;
        public TextView textViewAlbumGenero;

        public CancionViewHolder(View view) {
            super(view);
            textViewNombre = view.findViewById(R.id.textViewNombre);
            textViewAlbumGenero = view.findViewById(R.id.textViewAlbumGenero);

            textViewAlbumGenero.setTextColor(Color.MAGENTA);
        }
    }

}
