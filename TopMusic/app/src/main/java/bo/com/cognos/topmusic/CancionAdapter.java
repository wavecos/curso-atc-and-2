package bo.com.cognos.topmusic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CancionAdapter extends RecyclerView.Adapter<CancionAdapter.ViewHolder> {

    private String[] dataset;

    public CancionAdapter(String[] dataset) {
        this.dataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View nombreArtista = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(nombreArtista);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewNombre.setText(dataset[position]);
    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }

    // Inner Class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNombre;

        public ViewHolder(View view) {
            super(view);
            textViewNombre = (TextView) view.findViewById(R.id.textViewNombre);
        }
    }

}
