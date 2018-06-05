package bo.com.cognos.quakeradar.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import bo.com.cognos.quakeradar.R;
import bo.com.cognos.quakeradar.WebActivity;
import bo.com.cognos.quakeradar.domain.Quake;

public class QuakeAdapter extends RecyclerView.Adapter<QuakeAdapter.QuakeViewHolder> {

    private Context context;
    private List<Quake> quakes;

    public QuakeAdapter(Context context, List<Quake> quakes) {
        this.context = context;
        this.quakes = quakes;
    }

    public void setQuakes(List<Quake> quakes) {
        this.quakes = quakes;
    }

    @NonNull
    @Override
    public QuakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View quakeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.quake_item, parent, false);
        QuakeViewHolder quakeViewHolder = new QuakeViewHolder(quakeView);

        return quakeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuakeViewHolder holder, int position) {
        final Quake quake = quakes.get(position);

        String magnitudeStr = String.valueOf(quake.getMagnitude());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String dateStr = "no hay fecha";
        if (quake.getDate() != null) {
            dateStr = dateFormat.format(quake.getDate());
        }

        holder.textViewMagnitude.setText(magnitudeStr);

        if (quake.getMagnitude() > 1) {
            holder.textViewMagnitude.setTextColor(context.getResources().getColor(R.color.quakeRed));
        }

        holder.textViewPlace.setText(quake.getPlace());
        holder.textViewDate.setText(dateStr);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("quake", quake);
                intent.putExtras(bundle);

//                intent.putExtra("quakeUrl", quake.getUrl());

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return quakes.size();
    }

    public static class QuakeViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewMagnitude;
        public TextView textViewPlace;
        public TextView textViewDate;

        public QuakeViewHolder(View itemView) {
            super(itemView);

            textViewMagnitude = itemView.findViewById(R.id.textViewMagnitude);
            textViewPlace = itemView.findViewById(R.id.textViewPlace);
            textViewDate = itemView.findViewById(R.id.textViewDate);
        }
    }


}
